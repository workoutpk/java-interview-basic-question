I'll create an example of reading an XML file and mapping it to Java entity classes using JAXB (Java Architecture for XML Binding).

```java
// pom.xml dependencies
/*
<dependencies>
    <dependency>
        <groupId>jakarta.xml.bind</groupId>
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.22</version>
    </dependency>
</dependencies>
*/

// Address.java
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

// Department.java
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String name;
    private String code;
    private String location;
}

// Employee.java
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @XmlAttribute
    private Long id;
    
    @XmlElement(name = "first-name")
    private String firstName;
    
    @XmlElement(name = "last-name")
    private String lastName;
    
    private String email;
    
    @XmlElement(name = "hire-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate hireDate;
    
    private double salary;
    
    private Department department;
    
    private Address address;
}

// Employees.java (Root element class)
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    @XmlElement(name = "employee")
    private List<Employee> employeeList;
}

// LocalDateAdapter.java (Custom adapter for LocalDate)
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE;
    
    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date, dateFormat);
    }
    
    @Override
    public String marshal(LocalDate date) throws Exception {
        return date.format(dateFormat);
    }
}

// XMLReader.java
public class XMLReader {
    public static Employees readXML(String xmlFilePath) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            File xmlFile = new File(xmlFilePath);
            return (Employees) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new JAXBException("Error reading XML file: " + e.getMessage());
        }
    }
    
    public static void writeXML(Employees employees, String outputPath) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            
            // Make the output pretty printed
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            File outputFile = new File(outputPath);
            marshaller.marshal(employees, outputFile);
        } catch (JAXBException e) {
            throw new JAXBException("Error writing XML file: " + e.getMessage());
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        try {
            // Read XML file
            Employees employees = XMLReader.readXML("employees.xml");
            
            // Process employees
            employees.getEmployeeList().forEach(employee -> {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Department: " + employee.getDepartment().getName());
                System.out.println("Location: " + employee.getAddress().getCity());
                System.out.println("------------------------");
            });
            
            // Example of creating and writing new XML
            Employee newEmployee = new Employee(
                3L,
                "John",
                "Doe",
                "john.doe@example.com",
                LocalDate.now(),
                75000.0,
                new Department("IT", "IT01", "New York"),
                new Address("123 Main St", "New York", "NY", "10001", "USA")
            );
            
            List<Employee> currentList = employees.getEmployeeList();
            currentList.add(newEmployee);
            
            // Write updated XML
            XMLReader.writeXML(employees, "updated_employees.xml");
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

```

Example XML file (employees.xml):
```xml
<?xml version="1.0" encoding="UTF-8"?>
<employees>
    <employee id="1">
        <first-name>Alice</first-name>
        <last-name>Smith</last-name>
        <email>alice.smith@example.com</email>
        <hire-date>2022-01-15</hire-date>
        <salary>65000.0</salary>
        <department>
            <name>Human Resources</name>
            <code>HR01</code>
            <location>Chicago</location>
        </department>
        <address>
            <street>456 Oak Street</street>
            <city>Chicago</city>
            <state>IL</state>
            <zipCode>60601</zipCode>
            <country>USA</country>
        </address>
    </employee>
    <employee id="2">
        <first-name>Bob</first-name>
        <last-name>Johnson</last-name>
        <email>bob.johnson@example.com</email>
        <hire-date>2021-06-20</hire-date>
        <salary>72000.0</salary>
        <department>
            <name>Finance</name>
            <code>FIN01</code>
            <location>New York</location>
        </department>
        <address>
            <street>789 Pine Avenue</street>
            <city>New York</city>
            <state>NY</state>
            <zipCode>10002</zipCode>
            <country>USA</country>
        </address>
    </employee>
</employees>
```

Key Features:

1. XML Annotations:
    - @XmlRootElement: Specifies root element
    - @XmlAccessorType: Defines access type
    - @XmlElement: Maps XML elements
    - @XmlAttribute: Maps XML attributes

2. Custom Date Adapter:
    - Handles LocalDate conversion

3. Entity Classes:
    - Employee
    - Department
    - Address
    - Employees (root wrapper)

4. XML Operations:
    - Reading from XML file
    - Writing to XML file
    - Pretty printing output

5. Error Handling:
    - Exception handling for XML operations

To use this code:

1. Add JAXB dependencies to pom.xml
2. Create the XML file
3. Run the main class
4. Check console output and generated XML

Additional Features you might want to add:

1. XML Schema validation
2. Custom field validation
3. More complex data types
4. Logging
5. Error recovery mechanisms

Would you like me to explain any part in more detail or add additional functionality?