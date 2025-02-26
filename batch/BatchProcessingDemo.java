package batch;

import java.util.ArrayList;
import java.util.List;

public class BatchProcessingDemo {
    public static void main(String[] args) {
        // Create sample records
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            records.add(new Record(i));
        }

        // Initialize batch processor with 4 threads
        BatchProcessor processor = new BatchProcessor(4);

        // Process records in batches
        long startTime = System.currentTimeMillis();
        processor.processBatch(records);
        long endTime = System.currentTimeMillis();

        System.out.println("Processed " + records.size() + " records in " +
                (endTime - startTime) + " ms");

        // Shutdown the processor
        processor.shutdown();
    }
}
