I'll provide a comprehensive example demonstrating multiple ways to pass data between components in Angular, including:
1. Input/Output decorators
2. Services
3. Router parameters
4. Query parameters
5. Shared state management

```typescript
// 1. Parent-Child Communication (Input/Output)
// Parent Component
import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  template: `
    <div class="parent-container">
      <h2>Parent Component</h2>
      
      <!-- Passing data to child via input property -->
      <app-child 
        [parentMessage]="messageToChild"
        (childEvent)="handleChildEvent($event)"
      ></app-child>

      <div class="input-section">
        <input 
          type="text" 
          [(ngModel)]="messageToChild" 
          placeholder="Enter message to child"
        >
      </div>

      <p>Received from Child: {{ receivedFromChild }}</p>
    </div>
  `
})
export class ParentComponent {
  messageToChild = 'Hello from Parent!';
  receivedFromChild = '';

  handleChildEvent(message: string) {
    this.receivedFromChild = message;
  }
}

// Child Component
import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  template: `
    <div class="child-container">
      <h3>Child Component</h3>
      <p>Received Message: {{ parentMessage }}</p>
      
      <button (click)="sendToParent()">Send to Parent</button>
    </div>
  `
})
export class ChildComponent {
  @Input() parentMessage: string = '';
  @Output() childEvent = new EventEmitter<string>();

  sendToParent() {
    this.childEvent.emit('Message from Child Component');
  }
}

// 2. Shared Service Communication
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  // Using BehaviorSubject for shared state
  private dataSource = new BehaviorSubject<string>('Initial Shared Data');
  currentData = this.dataSource.asObservable();

  // Method to update data
  changeData(data: string) {
    this.dataSource.next(data);
  }
}

// Component Using Shared Service
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-component',
  template: `
    <div class="service-component">
      <h2>Service Shared Data</h2>
      <p>Current Shared Data: {{ sharedData }}</p>
      
      <input 
        type="text" 
        (input)="updateSharedData($event)" 
        placeholder="Update shared data"
      >
    </div>
  `
})
export class ServiceComponent implements OnInit {
  sharedData: string = '';

  constructor(private dataService: DataService) {}

  ngOnInit() {
    // Subscribe to shared data
    this.dataService.currentData.subscribe(
      data => this.sharedData = data
    );
  }

  updateSharedData(event: Event) {
    const input = event.target as HTMLInputElement;
    this.dataService.changeData(input.value);
  }
}

// 3. Router Parameter Passing
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail',
  template: `
    <div class="detail-component">
      <h2>User Details</h2>
      <p>User ID: {{ userId }}</p>
      <p>Name: {{ userName }}</p>
    </div>
  `
})
export class UserDetailComponent implements OnInit {
  userId: string = '';
  userName: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    // Get route parameters
    this.route.params.subscribe(params => {
      this.userId = params['id'];
    });

    // Get query parameters
    this.route.queryParams.subscribe(queryParams => {
      this.userName = queryParams['name'] || 'Unknown';
    });
  }
}

// Navigation Component
@Component({
  selector: 'app-user-list',
  template: `
    <div class="user-list">
      <h2>User List</h2>
      <ul>
        <li 
          *ngFor="let user of users" 
          (click)="navigateToDetails(user)"
        >
          {{ user.name }}
        </li>
      </ul>
    </div>
  `
})
export class UserListComponent {
  users = [
    { id: '1', name: 'John Doe' },
    { id: '2', name: 'Jane Smith' }
  ];

  constructor(private router: Router) {}

  navigateToDetails(user: { id: string, name: string }) {
    // Navigate with route parameters and query parameters
    this.router.navigate(['/user-detail', user.id], {
      queryParams: { name: user.name }
    });
  }
}

// 4. Routing Module Configuration
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'user-list', component: UserListComponent },
  { path: 'user-detail/:id', component: UserDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }

// 5. App Module Configuration
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    ParentComponent,
    ChildComponent,
    ServiceComponent,
    UserListComponent,
    UserDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule
  ],
  providers: [DataService]
})
export class AppModule { }

```

Let me break down the different data passing techniques:

1. Input/Output Decorators (Parent-Child Communication)
    - `@Input()`: Pass data from parent to child
    - `@Output()`: Emit events from child to parent
    - Two-way binding with `[(ngModel)]`

2. Shared Service Communication
    - Uses RxJS `BehaviorSubject` for state management
    - Observable pattern for real-time data sharing
    - Accessible across multiple components

3. Router Parameter Passing
    - Route parameters (`:id`)
    - Query parameters
    - Navigate between components with data

Key Techniques Demonstrated:
- Component interaction
- Service-based state management
- Routing with parameter passing
- Event emission
- Two-way data binding

Usage Examples:

```typescript
// Passing data via Input
@Component({
  template: '<app-child [message]="parentData"></app-child>'
})

// Using Shared Service
constructor(private dataService: DataService) {
  this.dataService.changeData('New Shared Value');
}

// Navigation with Parameters
this.router.navigate(['/user', userId], {
  queryParams: { filter: 'active' }
});
```

Recommendations:
- Use Input/Output for simple parent-child communication
- Use Services for complex, app-wide state management
- Use Router for navigational data passing
- Consider using NgRx for more complex state management in larger applications

Would you like me to elaborate on any specific data passing technique?