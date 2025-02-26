Implementing an authentication guard in a React application is essential for protecting certain routes from unauthorized access. Below are steps and examples for creating an auth guard using React Router, particularly focusing on version 6 and above.

## Step-by-Step Guide to Implement Auth Guard in React

### 1. Set Up Your React Application

First, ensure you have a React application set up. If you haven't created one yet, you can bootstrap a new app using:

```bash
npx create-react-app my-app
cd my-app
npm start
```

### 2. Install React Router

To manage routing in your application, install `react-router-dom`:

```bash
npm install react-router-dom
```

### 3. Create Authentication Context

Create a context to manage authentication state across your application. This will help keep track of whether a user is logged in.

```javascript
// AuthContext.js
import React, { createContext, useContext, useState } from 'react';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const login = () => setIsAuthenticated(true);
    const logout = () => setIsAuthenticated(false);

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
```

### 4. Create Protected Route Component

Next, create a component that will act as a gatekeeper for your protected routes.

```javascript
// ProtectedRoute.js
import { Navigate } from 'react-router-dom';
import { useAuth } from './AuthContext';

const ProtectedRoute = ({ children }) => {
    const { isAuthenticated } = useAuth();
    
    if (!isAuthenticated) {
        return <Navigate to="/login" replace />;
    }

    return children;
};

export default ProtectedRoute;
```

### 5. Set Up Routes in Your App

Now, integrate everything into your main application file and define the routes.

```javascript
// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './AuthContext';
import ProtectedRoute from './ProtectedRoute';
import Home from './Home';
import Login from './Login';
import ProtectedPage from './ProtectedPage';

function App() {
    return (
        <AuthProvider>
            <Router>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/login" element={<Login />} />
                    <Route 
                        path="/protected" 
                        element={
                            <ProtectedRoute>
                                <ProtectedPage />
                            </ProtectedRoute>
                        } 
                    />
                </Routes>
            </Router>
        </AuthProvider>
    );
}

export default App;
```

### 6. Create Login and Protected Components

You need components for login and the protected page.

```javascript
// Login.js
import React from 'react';
import { useAuth } from './AuthContext';

const Login = () => {
    const { login } = useAuth();

    const handleLogin = () => {
        login();
        // Redirect or perform other actions after login
    };

    return (
        <div>
            <h2>Login Page</h2>
            <button onClick={handleLogin}>Log In</button>
        </div>
    );
};

export default Login;

// ProtectedPage.js
import React from 'react';

const ProtectedPage = () => {
    return <h2>This is a protected page!</h2>;
};

export default ProtectedPage;
```

### 7. Test Your Application

Run your application and test the following scenarios:
- Accessing the `/protected` route without logging in should redirect to `/login`.
- After logging in via the `/login` route, you should be able to access the `/protected` route.

## Conclusion

This implementation provides a basic structure for an auth guard in a React application using `react-router-dom`. You can enhance this setup by integrating real authentication mechanisms (e.g., JWT tokens) and improving user experience with better state management or UI feedback during authentication processes.

Citations:
[1] https://www.npmjs.com/package/@authing/guard-react
[2] https://blog.netcetera.com/how-to-create-guarded-routes-for-your-react-app-d2fe7c7b6122?gi=36bc81efa897
[3] https://ui.dev/react-router-protected-routes-authentication
[4] https://stackoverflow.com/questions/49552776/how-to-apply-authguard-to-routes-having-multiple-components-in-reactjs
[5] https://www.reddit.com/r/reactjs/comments/1cck2zd/need_help_to_implement_routeguardauthguard_on_my/
[6] https://dev.to/tigawanna/auth-guarding-in-react-392o
[7] https://developer.auth0.com/resources/guides/spa/react/basic-authentication
[8] https://projectreactor.io/docs/core/milestone/reference/reactiveProgramming.html