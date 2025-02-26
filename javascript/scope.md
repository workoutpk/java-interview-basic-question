I'll provide a comprehensive explanation of scope in JavaScript with detailed code examples:

```javascript
// Scope in JavaScript: Understanding Variable Accessibility

// 1. Global Scope
var globalVariable = "I'm a global variable";

// 2. Function Scope
function demonstrateFunctionScope() {
    var functionScopedVar = "I'm function scoped";
    
    console.log("Function Scope Demonstration:");
    console.log("Accessing function scoped variable:", functionScopedVar);
    
    // Inner function demonstrating lexical scope
    function innerFunction() {
        var innerVar = "I'm an inner function variable";
        console.log("Inner function can access outer function variable:", functionScopedVar);
        console.log("Inner function variable:", innerVar);
    }
    
    innerFunction();
    
    // Trying to access innerVar here would cause an error
    // console.log(innerVar); // This would throw a ReferenceError
}

demonstrateFunctionScope();

// 3. Block Scope (introduced with let and const)
function demonstrateBlockScope() {
    console.log("\nBlock Scope Demonstration:");
    
    // var - function scoped
    var functionScopedVar = "Function scoped";
    
    // let - block scoped
    if (true) {
        let blockScopedVar = "Block scoped";
        var functionScopedInBlock = "Still function scoped";
        
        console.log("Block scoped variable inside block:", blockScopedVar);
        console.log("Function scoped variable inside block:", functionScopedInBlock);
    }
    
    // This works because var is function scoped
    console.log("Function scoped variable outside block:", functionScopedInBlock);
    
    // This would cause a ReferenceError
    // console.log(blockScopedVar); 
}

demonstrateBlockScope();

// 4. Lexical Scope (Closure)
function createCounter() {
    let count = 0; // Private variable
    
    return function() {
        count++; // Inner function has access to outer function's variables
        return count;
    };
}

const counter = createCounter();
console.log("\nClosure (Lexical Scope) Demonstration:");
console.log("First call:", counter()); // 1
console.log("Second call:", counter()); // 2
console.log("Third call:", counter()); // 3

// 5. Global vs Local Scope
let globalVar = "Global Variable";

function scopeExample() {
    let localVar = "Local Variable";
    
    console.log("\nScope Comparison:");
    console.log("Global Variable:", globalVar);
    console.log("Local Variable:", localVar);
}

scopeExample();

// 6. Scope Chain
function outerFunction() {
    let outerVar = "Outer Variable";
    
    function middleFunction() {
        let middleVar = "Middle Variable";
        
        function innerFunction() {
            let innerVar = "Inner Variable";
            
            console.log("\nScope Chain Demonstration:");
            console.log("Outer Variable:", outerVar);
            console.log("Middle Variable:", middleVar);
            console.log("Inner Variable:", innerVar);
        }
        
        innerFunction();
    }
    
    middleFunction();
}

outerFunction();

// 7. Scope with Different Variable Declarations
function scopeDeclarationDemo() {
    console.log("\nVariable Declaration Scope:");
    
    // var - function scoped, hoisted
    var varVariable = "Var Variable";
    
    // let - block scoped, not hoisted
    let letVariable = "Let Variable";
    
    // const - block scoped, not hoisted, cannot be reassigned
    const constVariable = "Const Variable";
    
    console.log("var variable:", varVariable);
    console.log("let variable:", letVariable);
    console.log("const variable:", constVariable);
}

scopeDeclarationDemo();

// 8. Immediately Invoked Function Expression (IIFE)
(function() {
    let privateVar = "I'm private";
    console.log("\nIIFE Demonstration:");
    console.log("Private variable inside IIFE:", privateVar);
})();

// 9. Global Object and Window in Browsers
function globalObjectDemo() {
    console.log("\nGlobal Object Demonstration:");
    
    // In browsers, global variables become properties of the window object
    var browserGlobalVar = "Browser Global";
    
    console.log("Global variable as window property:", window.browserGlobalVar);
}

// Note: This will only work in a browser environment
if (typeof window !== 'undefined') {
    globalObjectDemo();
}
```

Key Scope Concepts:

1. **Global Scope**
    - Variables declared outside any function
    - Accessible everywhere in the code

2. **Function Scope**
    - Variables declared inside a function
    - Accessible only within that function

3. **Block Scope**
    - Introduced with `let` and `const`
    - Variables are limited to the block they are declared in (inside {})

4. **Lexical Scope (Closure)**
    - Inner functions have access to outer function's variables
    - Creates private variables and data encapsulation

5. **Scope Chain**
    - JavaScript looks for variables in the current scope
    - If not found, it looks in the outer (enclosing) scope
    - Continues until it reaches the global scope

Variable Declaration Differences:
- `var`: Function-scoped, hoisted
- `let`: Block-scoped, not hoisted, can be reassigned
- `const`: Block-scoped, not hoisted, cannot be reassigned

Best Practices:
- Minimize global variables
- Use `let` and `const` instead of `var`
- Create closures for data privacy
- Understand scope to prevent unintended variable access

Would you like me to elaborate on any specific aspect of JavaScript scope?