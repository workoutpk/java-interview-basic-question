In Angular, a **dynamic component** refers to a component that is created and added to the DOM programmatically at runtime rather than being declared in the application's static template. This approach is useful when the component to be displayed is not known at compile time or when you need to load components dynamically based on user interactions or application state.

---

### **Key Concepts of Dynamic Components in Angular**

1. **Dynamic Component Creation**:
    - Use Angular's APIs to instantiate components dynamically, typically with the help of a `ComponentFactoryResolver` (in Angular versions prior to 9) or `ViewContainerRef.createComponent()` (in Angular 9+).

2. **Use Cases**:
    - Showing modal dialogs.
    - Dynamic form generation.
    - Loading widgets or components based on configuration files or user actions.
    - Implementing a plugin-like architecture.

3. **Key APIs**:
    - **`ViewContainerRef`**: Provides methods to add or remove elements from the DOM dynamically.
    - **`ComponentFactoryResolver`** (deprecated in Angular 9): Creates a factory for a specific component.
    - **`ComponentRef`**: Represents a reference to the dynamically created component.

---

### **Steps to Create a Dynamic Component**

#### 1. **Create the Component**
Define the component to be loaded dynamically. For example:

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-dynamic',
  template: `<h2>I am a dynamically loaded component!</h2>`,
})
export class DynamicComponent {}
```

#### 2. **Create a Host Component**
This is where the dynamic component will be loaded:

```typescript
import { Component, ViewChild, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-host',
  template: `<ng-container #dynamicContainer></ng-container>`,
})
export class HostComponent {
  @ViewChild('dynamicContainer', { read: ViewContainerRef, static: true })
  container!: ViewContainerRef;

  loadDynamicComponent() {
    this.container.clear(); // Clear existing components
    const componentRef = this.container.createComponent(DynamicComponent);
    // Access the dynamic component instance via `componentRef.instance` if needed
  }
}
```

#### 3. **Module Declaration**
Add both components to the `declarations` array in your module and ensure the dynamic component is included in the `entryComponents` array (for Angular versions <9).

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HostComponent } from './host.component';
import { DynamicComponent } from './dynamic.component';

@NgModule({
  declarations: [AppComponent, HostComponent, DynamicComponent],
  imports: [BrowserModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

#### 4. **Trigger Dynamic Component Loading**
You can invoke the `loadDynamicComponent()` method from the host component when needed:

```html
<button (click)="loadDynamicComponent()">Load Component</button>
<app-host></app-host>
```

---

### **Dynamic Component Loading in Angular 9+**
With Angular 9 and later, you no longer need to use `ComponentFactoryResolver`. You can directly call the `createComponent()` method on a `ViewContainerRef`.

#### Example:
```typescript
import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { DynamicComponent } from './dynamic.component';

@Component({
  selector: 'app-host',
  template: `<ng-container #dynamicContainer></ng-container>`,
})
export class HostComponent {
  @ViewChild('dynamicContainer', { read: ViewContainerRef, static: true })
  container!: ViewContainerRef;

  loadDynamicComponent() {
    this.container.clear();
    const componentRef = this.container.createComponent(DynamicComponent);
  }
}
```

---

### **Advanced Dynamic Component Use Cases**
1. **Passing Data to Dynamic Components**:
   Use the `instance` property of `ComponentRef` to pass data:
   ```typescript
   const componentRef = this.container.createComponent(DynamicComponent);
   componentRef.instance.someInputProperty = 'Some Data';
   ```

2. **Handling Outputs**:
   Subscribe to event emitters of the dynamically loaded component:
   ```typescript
   componentRef.instance.someOutputEvent.subscribe(value => {
     console.log(value);
   });
   ```

3. **Destroying a Dynamic Component**:
   Call the `destroy()` method on the `ComponentRef`:
   ```typescript
   componentRef.destroy();
   ```

---

### **Benefits of Dynamic Components**
- Flexible: Adapt UI dynamically based on runtime conditions.
- Modular: Load only the necessary components, which can reduce initial load time.
- Extensible: Supports plugin-like architectures.

---

Let me know if you'd like further explanation or a detailed example of a specific use case!