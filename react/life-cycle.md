Here’s an example of a React class component demonstrating lifecycle methods with an API call:

```javascript
import React, { Component } from 'react';

class UserList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
      loading: true,
      error: null,
    };
    console.log('Constructor: Component is initialized');
  }

  // Lifecycle method invoked immediately after the component is mounted
  componentDidMount() {
    console.log('componentDidMount: Component is mounted');
    this.fetchUsers();
  }

  // Method to fetch data from an API
  fetchUsers() {
    fetch('https://jsonplaceholder.typicode.com/users')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        this.setState({ users: data, loading: false });
        console.log('API data fetched successfully');
      })
      .catch((error) => {
        this.setState({ error, loading: false });
        console.error('Error fetching data:', error);
      });
  }

  // Lifecycle method invoked when component updates (e.g., state or props change)
  componentDidUpdate(prevProps, prevState) {
    if (prevState.users !== this.state.users) {
      console.log('componentDidUpdate: Users state updated');
    }
  }

  // Lifecycle method invoked before component is removed from the DOM
  componentWillUnmount() {
    console.log('componentWillUnmount: Component is about to be unmounted');
  }

  render() {
    const { users, loading, error } = this.state;

    console.log('Render: Rendering component');

    if (loading) {
      return <p>Loading...</p>;
    }

    if (error) {
      return <p>Error: {error.message}</p>;
    }

    return (
      <div>
        <h1>User List</h1>
        <ul>
          {users.map((user) => (
            <li key={user.id}>{user.name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default UserList;
```

---

### **Explanation**:
1. **Constructor**:
    - Initializes the state and logs when the component is created.

2. **componentDidMount**:
    - Triggers the `fetchUsers` method to load data after the component mounts.

3. **fetchUsers**:
    - Makes an API call to fetch data and updates the state with the results or an error.

4. **componentDidUpdate**:
    - Logs a message whenever the `users` state is updated.

5. **componentWillUnmount**:
    - Prepares the component for cleanup (e.g., canceling API calls or clearing intervals).

6. **render**:
    - Displays loading, error messages, or the user list depending on the state.

### **Steps to Run**:
1. Create a new React project (e.g., using `create-react-app`).
2. Add the above code in a file (e.g., `UserList.js`).
3. Import and render the `UserList` component in `App.js`.
4. Run the project using `npm start` or `yarn start`.

This example demonstrates how to use React class component lifecycle methods effectively, especially for managing API calls.