Here's a complete implementation for retrieving a file from Azure Blob Storage by filename in Spring Boot:

## Azure Blob Storage Integration for Spring Boot

I've created a complete solution for retrieving files from Azure Blob Storage by filename using Spring Boot. The implementation includes:

1. **Azure Blob Storage Service**: Handles the core functionality for interacting with Azure Blob Storage.
2. **REST Controller**: Exposes endpoints for file operations.
3. **Application Properties**: Configuration for Azure Blob Storage connection.
4. **Maven Dependencies**: Required dependencies for the project.

### How to Use

1. **Add the dependencies** to your `pom.xml`:
    - Spring Boot Web Starter
    - Azure Storage Blob
    - Azure Identity

2. **Configure your application.properties**:
    - Set your Azure connection string and container name
    - Configure file upload limits if needed

3. **Use the Service in your application**:
    - Inject the `AzureBlobStorageService` where needed
    - Call the `downloadFile()` method with the filename to retrieve a file

### API Endpoints

The implementation provides the following REST endpoints:

- **GET /api/files/{filename}**: Download a file by name
- **POST /api/files/upload**: Upload a file
- **DELETE /api/files/{filename}**: Delete a file
- **GET /api/files/exists/{filename}**: Check if a file exists

### Main Features

- **Proper Error Handling**: Returns appropriate HTTP status codes
- **Content Type Detection**: Automatically sets the correct MIME type
- **Streaming Download**: Uses ByteArrayResource for efficient file transfer
- **Connection Management**: Uses Azure's recommended client patterns

### Security Note

For production, consider using Managed Identities or Azure AD authentication instead of connection strings. You'd modify the BlobServiceClient initialization to use DefaultAzureCredential instead of a connection string.



package com.example.azure.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
public class AzureBlobStorageService {

    @Value("${azure.storage.connection-string}")
    private String connectionString;
    
    @Value("${azure.storage.container-name}")
    private String containerName;
    
    private BlobContainerClient getBlobContainerClient() {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
                
        return blobServiceClient.getBlobContainerClient(containerName);
    }
    
    /**
     * Download a file from Azure Blob Storage by filename
     * 
     * @param filename Name of the file to download
     * @return ResponseEntity containing the file as a resource
     */
    public ResponseEntity<Resource> downloadFile(String filename) {
        BlobContainerClient containerClient = getBlobContainerClient();
        
        // Check if the blob exists
        BlobClient blobClient = containerClient.getBlobClient(filename);
        if (!blobClient.exists()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        
        // Get blob properties to determine content type
        BlobProperties properties = blobClient.getProperties();
        
        // Download the blob content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blobClient.download(outputStream);
        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
        
        // Build the response
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(properties.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
    
    /**
     * Upload a file to Azure Blob Storage
     * 
     * @param file The file to upload
     * @param filename Name to save the file as
     * @return URL of the uploaded file
     */
    public String uploadFile(MultipartFile file, String filename) throws IOException {
        BlobContainerClient containerClient = getBlobContainerClient();
        BlobClient blobClient = containerClient.getBlobClient(filename);
        
        try (InputStream data = file.getInputStream()) {
            blobClient.upload(data, file.getSize(), true);
        }
        
        return blobClient.getBlobUrl();
    }
    
    /**
     * Delete a file from Azure Blob Storage
     * 
     * @param filename Name of the file to delete
     * @return true if deleted successfully, false otherwise
     */
    public boolean deleteFile(String filename) {
        BlobContainerClient containerClient = getBlobContainerClient();
        BlobClient blobClient = containerClient.getBlobClient(filename);
        
        if (blobClient.exists()) {
            blobClient.delete();
            return true;
        }
        
        return false;
    }
    
    /**
     * Check if a file exists in Azure Blob Storage
     * 
     * @param filename Name of the file to check
     * @return true if file exists, false otherwise
     */
    public boolean fileExists(String filename) {
        BlobContainerClient containerClient = getBlobContainerClient();
        BlobClient blobClient = containerClient.getBlobClient(filename);
        return blobClient.exists();
    }
}


package com.example.azure.controller;

import com.example.azure.service.AzureBlobStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class AzureBlobStorageController {

    private final AzureBlobStorageService azureBlobStorageService;

    @Autowired
    public AzureBlobStorageController(AzureBlobStorageService azureBlobStorageService) {
        this.azureBlobStorageService = azureBlobStorageService;
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        return azureBlobStorageService.downloadFile(filename);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("filename") String filename) {
        try {
            String fileUrl = azureBlobStorageService.uploadFile(file, filename);
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload file: " + e.getMessage());
        }
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        boolean deleted = azureBlobStorageService.deleteFile(filename);
        if (deleted) {
            return ResponseEntity.ok("File deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/exists/{filename}")
    public ResponseEntity<Boolean> fileExists(@PathVariable String filename) {
        boolean exists = azureBlobStorageService.fileExists(filename);
        return ResponseEntity.ok(exists);
    }
}


# Azure Blob Storage configuration
azure.storage.connection-string=your-azure-storage-connection-string
azure.storage.container-name=your-container-name

# File upload configuration
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB