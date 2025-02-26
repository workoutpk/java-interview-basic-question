package dsa.map;

public class Document {
    String title;
    String content;

    Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title;
    }
}
