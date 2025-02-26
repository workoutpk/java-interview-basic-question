package batch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchProcessor {
    private static final int BATCH_SIZE = 1000;
    private final ExecutorService executorService;
    public BatchProcessor(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    // Process records in batches
    public void processBatch(List<Record> records) {
        int totalRecords = records.size();
        int totalBatches = (totalRecords + BATCH_SIZE - 1) / BATCH_SIZE;
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < totalBatches; i++) {
            int start = i * BATCH_SIZE;
            int end = Math.min(start + BATCH_SIZE, totalRecords);
            List<Record> batch = records.subList(start, end);

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    processRecords(batch);
                } catch (Exception e) {
                    System.err.println("Error processing batch: " + e.getMessage());
                    // Handle error - could be logged, retried, or stored for later processing
                }
            }, executorService);

            futures.add(future);
        }

        // Wait for all batches to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private void processRecords(List<Record> batch) {
        // Simulate batch processing
        for (Record record : batch) {
            // Process individual record
            record.process();

            // Simulate some processing time
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }

}
