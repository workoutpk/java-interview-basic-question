Creating user authentication in an Angular application involves implementing a login system, securing routes, and managing user sessions. Below is a step-by-step guide to implement basic user authentication:

---

### Step 1: Install Angular and Dependencies
First, ensure you have Angular CLI installed and create a new project:
```bash
ng new angular-auth-app
cd angular-auth-app
```

Install required packages for HTTP handling and authentication:
```bash
npm install @angular/forms @angular/router
```

---

### Step 2: Set Up Authentication Service
Create an `AuthService` to handle login, logout, and token storage.

#### AuthService (`auth.service.ts`)
```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://your-api-url.com'; // Replace with your API endpoint
  private loggedIn = new BehaviorSubject<boolean>(this.hasToken());

  constructor(private http: HttpClient, private router: Router) {}

  login(credentials: { email: string, password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, credentials).pipe(
      tap((response: any) => {
        localStorage.setItem('token', response.token);
        this.loggedIn.next(true);
      })
    );
  }

  logout(): void {
    localStorage.removeItem('token');
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
}
```

---

### Step 3: Create a Login Component
Generate a login component using the Angular CLI:
```bash
ng generate component login
```

#### Login Component (`login.component.ts`)
```typescript
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email = '';
  password = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    this.authService.login({ email: this.email, password: this.password }).subscribe({
      next: () => this.router.navigate(['/dashboard']),
      error: err => this.errorMessage = 'Invalid credentials'
    });
  }
}
```

#### Login Template (`login.component.html`)
```html
<div class="login-container">
  <h2>Login</h2>
  <form (ngSubmit)="onSubmit()">
    <label for="email">Email:</label>
    <input type="email" id="email" [(ngModel)]="email" name="email" required />
    
    <label for="password">Password:</label>
    <input type="password" id="password" [(ngModel)]="password" name="password" required />
    
    <button type="submit">Login</button>
  </form>
  <p *ngIf="errorMessage" class="error">{{ errorMessage }}</p>
</div>
```

---

### Step 4: Add Route Guard
A route guard restricts access to routes for authenticated users only.

#### Auth Guard (`auth.guard.ts`)
```bash
ng generate guard auth
```

```typescript
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): Observable<boolean> {
    return this.authService.isLoggedIn().pipe(
      map(isLoggedIn => {
        if (!isLoggedIn) {
          this.router.navigate(['/login']);
        }
        return isLoggedIn;
      })
    );
  }
}
```

---

### Step 5: Secure Routes in App Routing
Configure routes to protect certain components using the `AuthGuard`.

#### Routing (`app-routing.module.ts`)
```typescript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
```

---

### Step 6: Add HTTP Interceptor for Token
An interceptor adds the authentication token to every HTTP request.

#### Interceptor (`auth.interceptor.ts`)
```bash
ng generate interceptor auth
```

```typescript
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.authService.getToken();
    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    return next.handle(request);
  }
}
```

---

### Step 7: Configure the App Module
Include `FormsModule`, `HttpClientModule`, and register the `AuthInterceptor`.

#### App Module (`app.module.ts`)
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './interceptors/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
```

---

### Step 8: Create a Dashboard Component
Create a simple dashboard to test authentication.

#### Dashboard Component (`dashboard.component.html`)
```html
<h1>Welcome to the Dashboard</h1>
<button (click)="logout()">Logout</button>
```

#### Dashboard Component (`dashboard.component.ts`)
```typescript
import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  constructor(private authService: AuthService) {}

  logout(): void {
    this.authService.logout();
  }
}
```

---

This implementation provides a basic user authentication system. You can expand it with features like registration, role-based access, and session expiration. Replace the mock API URL with your actual backend service.