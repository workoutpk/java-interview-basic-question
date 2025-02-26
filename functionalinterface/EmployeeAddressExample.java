package functionalinterface;

import java.util.function.Function;

public class EmployeeAddressExample {
    public static void main(String[] args) {
        // Create an employee with an address
        Address address = new Address("123 Main St", "Springfield");
        Employee employee = new Employee("John Doe", address);
        // Using method reference to implement the functional interface
        AddressRetriever addressRetriever = Employee::getAddress;
        // Using the Function interface from java.util.function package
        Function<Employee, Address> addressFunction = Employee::getAddress;

        // Retrieve and print the address using our custom functional interface
        Address retrievedAddress = addressRetriever.getAddress(employee);
        System.out.println("Address retrieved using AddressRetriever: " + retrievedAddress);

        // Retrieve and print the address using the Function interface
        Address functionRetrievedAddress = addressFunction.apply(employee);
        System.out.println("Address retrieved using Function interface: " + functionRetrievedAddress);

    }
}
