Here’s a sample **`deployment.yaml`** file for deploying an application in Kubernetes. This YAML defines a `Deployment` that creates and manages replicas of a Pod running an application.

---

### Sample `deployment.yaml`
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-app-deployment  # Name of the deployment
  labels:
    app: my-app            # Labels to identify the deployment
spec:
  replicas: 3              # Number of desired pod replicas
  selector:
    matchLabels:
      app: my-app          # Selector to match the pods managed by this deployment
  template:
    metadata:
      labels:
        app: my-app        # Labels for the pods
    spec:
      containers:
      - name: my-app       # Name of the container
        image: nginx:1.21  # Container image (replace with your application image)
        ports:
        - containerPort: 80 # Port exposed by the container
        resources:          # Resource limits and requests (optional)
          limits:
            memory: "512Mi"
            cpu: "500m"
          requests:
            memory: "256Mi"
            cpu: "250m"
        env:                # Environment variables (optional)
        - name: ENVIRONMENT
          value: "production"
        readinessProbe:     # Readiness probe to check app readiness
          httpGet:
            path: /
            port: 80
          initialDelaySeconds: 5
          periodSeconds: 10
        livenessProbe:      # Liveness probe to check app health
          httpGet:
            path: /
            port: 80
          initialDelaySeconds: 10
          periodSeconds: 15
```

---

### Explanation of Fields
1. **`apiVersion`**:
    - Specifies the API version used for the Deployment (`apps/v1` for modern Kubernetes deployments).

2. **`kind`**:
    - Declares the type of Kubernetes object. In this case, it’s a `Deployment`.

3. **`metadata`**:
    - Provides metadata like the name (`my-app-deployment`) and labels for the Deployment.

4. **`spec`**:
    - Defines the desired state of the Deployment.
    - **`replicas`**: Specifies the number of Pod replicas.
    - **`selector`**: Matches labels to determine which Pods are managed.
    - **`template`**: Contains the Pod specification.

5. **`containers`**:
    - Defines the containers in the Pod.
    - **`name`**: Name of the container.
    - **`image`**: Docker image to use (e.g., `nginx:1.21`).
    - **`ports`**: Ports exposed by the container.

6. **`resources`**:
    - Specifies CPU and memory resource limits and requests.

7. **`readinessProbe` & `livenessProbe`**:
    - Readiness probe checks if the application is ready to serve traffic.
    - Liveness probe checks if the application is running and restarts the container if it’s unhealthy.

---

### Deployment Commands
1. **Apply the Deployment**:
   ```bash
   kubectl apply -f deployment.yaml
   ```

2. **Verify Deployment**:
   ```bash
   kubectl get deployments
   ```

3. **View Pods**:
   ```bash
   kubectl get pods
   ```

4. **Check Deployment Logs**:
   ```bash
   kubectl logs <pod-name>
   ```

---

### Customization
- Replace `nginx:1.21` with your own application’s Docker image.
- Update the `replicas` field based on your desired scaling.
- Adjust resource requests and limits according to your application's needs.

Let me know if you need assistance customizing this further!