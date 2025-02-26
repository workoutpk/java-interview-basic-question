Here are the key regex characters and patterns used in Java:

```java
// Basic Characters
.       // Any single character except newline
^       // Start of line
$       // End of line
\       // Escape character

// Quantifiers
*       // Zero or more times (e.g., a*)
+       // One or more times (e.g., a+)
?       // Zero or one time (e.g., a?)
{n}     // Exactly n times (e.g., a{3})
{n,}    // n or more times (e.g., a{2,})
{n,m}   // Between n and m times (e.g., a{2,4})

// Character Classes
[abc]   // Any character a, b, or c
[^abc]  // Any character except a, b, c
[a-z]   // Any character a through z
[A-Z]   // Any character A through Z
[0-9]   // Any digit 0 through 9

// Predefined Character Classes
\d      // Any digit [0-9]
\D      // Any non-digit [^0-9]
\s      // Any whitespace character [ \t\n\r\f]
\S      // Any non-whitespace character
\w      // Any word character [a-zA-Z0-9_]
\W      // Any non-word character

// Grouping and Alternation
(...)   // Grouping
|       // Alternation (OR) (e.g., cat|dog)
```

Example usage:

```java
String text = "Hello123World";
// Examples of pattern matching
text.matches("\\w+")               // true (all word characters)
text.matches("[A-Za-z]+\\d+.*")   // true (letters, then numbers, then anything)

// Common use cases
String email = "user@domain.com";
email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")  // Email validation

String phone = "123-456-7890";
phone.matches("\\d{3}-\\d{3}-\\d{4}")  // Phone number validation

// Extracting numbers from text
String text = "The price is $19.99";
text.replaceAll("[^0-9.]", "")  // Returns "19.99"
```

These patterns can be used with Java's regex methods like:
- `String.matches()`
- `Pattern.compile()`
- `Matcher.find()`
- `String.replaceAll()`
- `String.split()`

Would you like to see more specific examples of how to use these patterns in practical scenarios?