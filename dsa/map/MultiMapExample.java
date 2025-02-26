package dsa.map;

import org.w3c.dom.events.EventListener;

public class MultiMapExample {
    public static void main(String[] args) {
        // Example 1: Student Course Registration
        System.out.println("Example 1: Student Course Registration");
        Multimap<String, String> studentCourses = new Multimap<>();

        // Adding courses for students
        studentCourses.put("John", "Mathematics");
        studentCourses.put("John", "Physics");
        studentCourses.put("Jane", "Biology");
        studentCourses.put("Jane", "Chemistry");
        studentCourses.put("Jane", "Physics");

        // Print all courses for each student
        studentCourses.keySet().forEach(student -> {
            System.out.println(student + "'s courses: " + studentCourses.get(student));
        });

        // Example 2: Category-Product Mapping
        System.out.println("\nExample 2: Category-Product Mapping");
        Multimap<String, Product> categoryProducts = new Multimap<>();


        // Adding products to categories
        categoryProducts.put("Electronics", new Product("Laptop", 999.99));
        categoryProducts.put("Electronics", new Product("Phone", 599.99));
        categoryProducts.put("Books", new Product("Java Programming", 49.99));
        categoryProducts.put("Books", new Product("Python Basics", 39.99));

        // Print products by category
        categoryProducts.entries().forEach(entry -> {
            System.out.println(entry.getKey() + " products: " + entry.getValue());
        });


        // Example 3: Tag-Based Document System
        System.out.println("\nExample 3: Tag-Based Document System");
        Multimap<String, Document> tagDocuments = new Multimap<>();


        // Adding documents with tags
        Document doc1 = new Document("Java Basics", "Java programming basics...");
        Document doc2 = new Document("Advanced Java", "Advanced Java concepts...");
        Document doc3 = new Document("Java Design Patterns", "Common design patterns...");

        tagDocuments.put("java", doc1);
        tagDocuments.put("beginner", doc1);
        tagDocuments.put("java", doc2);
        tagDocuments.put("advanced", doc2);
        tagDocuments.put("java", doc3);
        tagDocuments.put("design-patterns", doc3);

        // Search documents by tag
        System.out.println("Documents tagged with 'java': " + tagDocuments.get("java"));
        System.out.println("Documents tagged with 'beginner': " + tagDocuments.get("beginner"));

        // Example 4: Event Listener System
        System.out.println("\nExample 4: Event Listener System");
        Multimap<String, EventListener> eventListeners = new Multimap<>();

        // EventListener interface
        interface EventListener {
            void handleEvent(String event);
        }

        // Adding listeners
        eventListeners.put("click", event -> System.out.println("Handling click: " + event));
        eventListeners.put("click", event -> System.out.println("Logging click: " + event));
        eventListeners.put("keypress", event -> System.out.println("Handling keypress: " + event));

        // Simulate event dispatch
        String clickEvent = "Button clicked";
        System.out.println("Dispatching click event:");
//        eventListeners.get("click").forEach(listener -> listener.handleEvent(clickEvent));
    }
}
