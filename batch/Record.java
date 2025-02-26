package batch;

// Sample Record class
class Record {
    private final int id;
    private boolean processed;

    public Record(int id) {
        this.id = id;
    }

    public void process() {
        // Simulate processing logic
        this.processed = true;
    }
}
