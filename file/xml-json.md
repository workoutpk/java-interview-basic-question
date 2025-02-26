```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
public static void main(String[] args) throws Exception {
// JSON
ObjectMapper jsonMapper = new ObjectMapper();
String jsonString = "{\"name\":\"John\",\"age\":30}";
JsonNode jsonNode = jsonMapper.readTree(jsonString);
System.out.println(jsonNode);

        // XML
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = "<person><name>John</name><age>30</age></person>";
        JsonNode xmlNode = xmlMapper.readTree(xmlString);
        System.out.println(xmlNode);
    }
}
```