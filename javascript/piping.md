In JavaScript, **piping** is a functional programming concept that involves passing the output of one function as the input to another function in a left-to-right sequence. This approach improves code readability and modularity by chaining functions together in a clear and logical manner.

## Key Features of Piping

1. **Function Chaining**: Piping allows multiple functions to be executed in a specific order, where the output of one function becomes the input for the next.
2. **Left-to-Right Execution**: Unlike `compose`, which processes functions from right to left, piping executes functions in a left-to-right order.
3. **Improved Readability**: It simplifies complex transformations by breaking them into smaller, reusable functions and chaining them together.

---

### Example of Piping

Here’s an example of how piping works:

```javascript
// Define some simple functions
const getName = (person) => person.name;
const uppercase = (string) => string.toUpperCase();
const addGreeting = (name) => `Hello, ${name}!`;

// Pipe function implementation
const pipe = (...functions) => (input) =>
  functions.reduce((acc, fn) => fn(acc), input);

// Use the pipe function
const greetPerson = pipe(getName, uppercase, addGreeting);

const result = greetPerson({ name: 'John' });
console.log(result); // Output: "Hello, JOHN!"
```

### Explanation:
1. The `pipe` function takes multiple functions as arguments.
2. It returns a new function that processes an initial input through all the provided functions in sequence.
3. In this example:
    - `getName` extracts the `name` property.
    - `uppercase` converts the name to uppercase.
    - `addGreeting` adds a greeting message.

---

### Async Piping

Piping can also handle asynchronous functions using Promises:

```javascript
const fetchData = async (url) => fetch(url).then((res) => res.json());
const extractData = (data) => data.results;
const countItems = (items) => items.length;

const pipeAsync = (...functions) => (input) =>
  functions.reduce((chain, func) => chain.then(func), Promise.resolve(input));

const processApiData = pipeAsync(fetchData, extractData, countItems);

processApiData('https://api.example.com/data')
  .then((count) => console.log(`Item count: ${count}`))
  .catch((error) => console.error(error));
```

---

### Benefits of Piping

1. **Modularity**: Each function performs a single task, making code easier to test and maintain.
2. **Reusability**: Functions can be reused across different pipelines.
3. **Readability**: The left-to-right flow mirrors how we naturally think about data transformations.

---

### Comparison with Compose

| Feature               | Pipe                          | Compose                       |
|-----------------------|-------------------------------|-------------------------------|
| Execution Order       | Left-to-right                | Right-to-left                |
| Syntax Example        | `pipe(f1, f2)(input)`        | `compose(f2, f1)(input)`     |
| Use Case              | Natural flow of transformations | When starting with the final result |

---

In summary, piping is a powerful and intuitive way to chain multiple functions together in JavaScript, especially useful for functional programming and data transformations.

Citations:
[1] https://www.geeksforgeeks.org/what-is-piping-in-node-js/
[2] https://dev.to/joelbonetr/js-functional-concepts-pipe-and-compose-1mho
[3] https://dev.to/benlesh/a-simple-explanation-of-functional-pipe-in-javascript-2hbj
[4] https://www.freecodecamp.org/news/pipe-and-compose-in-javascript-5b04004ac937/
[5] https://www.geeksforgeeks.org/a-quick-introduction-to-pipe-and-compose-in-javascript/
[6] https://stackoverflow.com/questions/71910164/can-you-help-me-understand-how-piping-functions-in-javascript-work
[7] https://wavelop.com/en/story/javascript-pipe-function