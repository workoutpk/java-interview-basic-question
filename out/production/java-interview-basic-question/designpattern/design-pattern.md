The **Gang of Four (GoF) design patterns** are a collection of 23 design patterns introduced in the influential book *Design Patterns: Elements of Reusable Object-Oriented Software*, authored by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides. These patterns provide standardized solutions to common software design problems and are categorized into three main groups: **creational**, **structural**, and **behavioral** patterns.

### Categories of GoF Design Patterns

#### 1. Creational Patterns
These patterns deal with object creation mechanisms, aiming to create objects in a manner suitable to the situation. They provide flexibility in how objects are instantiated.

- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
- **Factory Method**: Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.
- **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Builder**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Prototype**: Creates new objects by copying an existing object, known as the prototype.

#### 2. Structural Patterns
These patterns focus on how classes and objects are composed to form larger structures. They help ensure that if one part of a system changes, the entire system doesn't need to change.

- **Adapter**: Allows incompatible interfaces to work together by converting the interface of a class into another interface that clients expect.
- **Bridge**: Separates an object's abstraction from its implementation so that the two can vary independently.
- **Composite**: Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.
- **Decorator**: Adds new functionality to an existing object without altering its structure, typically by wrapping it in another object.
- **Facade**: Provides a simplified interface to a complex subsystem, making it easier to use.
- **Flyweight**: Reduces memory usage by sharing common parts of state between multiple objects instead of storing all data in each object.
- **Proxy**: Provides a surrogate or placeholder for another object to control access to it.

#### 3. Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects. They help define how objects interact in a system.

- **Chain of Responsibility**: Passes requests along a chain of handlers, allowing multiple handlers to process the request without coupling the sender with the receiver.
- **Command**: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.
- **Interpreter**: Defines a representation for a language's grammar along with an interpreter that uses the representation to interpret sentences in the language.
- **Iterator**: Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.
- **Mediator**: Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring explicitly to each other.
- **Memento**: Captures and externalizes an object's internal state so that it can be restored later without violating encapsulation.
- **Observer**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **State**: Allows an object to alter its behavior when its internal state changes, appearing as if it changed its class.
- **Strategy**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable; allows the algorithm to vary independently from clients that use it.
- **Template Method**: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses; allows subclasses to redefine certain steps without changing the algorithm's structure.
- **Visitor**: Represents an operation to be performed on elements of an object structure without changing the classes of the elements on which it operates.

### Conclusion

The Gang of Four design patterns serve as foundational concepts in software engineering, providing reusable solutions that enhance code maintainability, scalability, and flexibility. Understanding these patterns can significantly improve software design practices and lead to more robust applications.

Citations:
[1] https://www.scholarhat.com/tutorial/designpatterns/gang-of-four-gof-design-patterns
[2] https://www.digitalocean.com/community/tutorials/gangs-of-four-gof-design-patterns
[3] https://www.geeksforgeeks.org/gang-of-four-gof-design-patterns/
[4] https://www.geeksforgeeks.org/introduction-to-gang-of-fourgof-design-patterns/
[5] https://en.wikipedia.org/wiki/Design_Patterns
[6] https://www.amazon.in/Design-Patterns-Object-Oriented-Addison-Wesley-Professional-ebook/dp/B000SEIBB8
[7] https://springframework.guru/gang-of-four-design-patterns/
[8] https://www.sitepoint.com/community/t/repeating-elements-across-web-pages-html-includes/262031