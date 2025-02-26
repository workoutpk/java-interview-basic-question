A **URI (Uniform Resource Identifier)** is a string of characters used to identify a resource on the internet or another network. It provides a standard way to locate or reference resources.

### **Components of a URI**
A URI can consist of several parts, some of which are optional:

```
scheme:[//authority]path[?query][#fragment]
```

1. **Scheme**: Indicates the protocol or mechanism used to access the resource (e.g., `http`, `https`, `ftp`, `mailto`).
    - Example: `http`, `ftp`, `file`.

2. **Authority**: Specifies the authority governing the resource. It includes:
    - **User Information** (optional): Username and password (e.g., `user:password@`).
    - **Host**: The domain name or IP address of the resource (e.g., `example.com`).
    - **Port** (optional): The port number for communication (e.g., `:80`).

3. **Path**: The location of the resource on the server.
    - Example: `/path/to/resource`.

4. **Query** (optional): A set of key-value pairs that provides additional instructions or parameters.
    - Example: `?key=value&name=john`.

5. **Fragment** (optional): A pointer to a subsection of the resource.
    - Example: `#section1`.

---

### **Types of URIs**
URIs can be categorized into two main types:

1. **URL (Uniform Resource Locator)**:
    - Identifies the location of a resource and how to access it.
    - Example: `https://example.com/page?query=123`.

2. **URN (Uniform Resource Name)**:
    - Identifies a resource by name within a specific namespace.
    - Example: `urn:isbn:0451450523` (an ISBN for a book).

---

### **Examples of URIs**
1. **HTTP URL**:
   ```
   https://www.example.com:8080/path/to/resource?query=abc#section1
   ```

    - Scheme: `https`
    - Authority: `www.example.com:8080`
    - Path: `/path/to/resource`
    - Query: `query=abc`
    - Fragment: `#section1`

2. **URN**:
   ```
   urn:oasis:names:specification:docbook:dtd:xml:4.1.2
   ```

    - Identifies a resource without pointing to its location.

3. **Mailto URI**:
   ```
   mailto:user@example.com
   ```

    - Scheme: `mailto`
    - Path: `user@example.com`

---

### **URI vs. URL**
While all URLs are URIs, not all URIs are URLs.

| Feature               | URI                                        | URL                                      |
|-----------------------|--------------------------------------------|------------------------------------------|
| **Purpose**           | Generic resource identification.          | Resource location and access method.    |
| **Includes URLs?**    | Yes.                                       | No.                                      |
| **Examples**          | `urn:isbn:0451450523`                     | `https://example.com`                   |

---

### **Use in Programming**
URIs are commonly used in web development and APIs to identify endpoints, parameters, and resources.

#### Example in Java:
```java
import java.net.URI;

public class URIDemo {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://example.com:8080/path?query=123#section");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### **Conclusion**
A URI is a universal way to identify and interact with resources on a network, playing a crucial role in the architecture of the web and various systems. It enables flexibility and standardization in resource identification and access.