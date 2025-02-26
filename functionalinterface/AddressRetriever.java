package functionalinterface;
@FunctionalInterface
public interface AddressRetriever {
    Address getAddress(Employee employee);
}
