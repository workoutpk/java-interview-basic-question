Here’s a categorized list of essential Kubernetes (kubectl) commands:

---

### Cluster Information
1. **`kubectl version`** – Show the Kubernetes client and server version.
2. **`kubectl cluster-info`** – Display information about the cluster.
3. **`kubectl config view`** – View kubeconfig settings.
4. **`kubectl config current-context`** – Show the current context.
5. **`kubectl get nodes`** – List all nodes in the cluster.
6. **`kubectl describe node [node_name]`** – Display detailed information about a node.

---

### Workload Management (Pods, Deployments, ReplicaSets)
7. **`kubectl get pods`** – List all pods in the default namespace.
8. **`kubectl get pods -n [namespace]`** – List all pods in a specific namespace.
9. **`kubectl describe pod [pod_name]`** – Display detailed information about a pod.
10. **`kubectl logs [pod_name]`** – View logs of a specific pod.
11. **`kubectl logs -f [pod_name]`** – Stream live logs of a pod.
12. **`kubectl exec -it [pod_name] -- [command]`** – Execute a command in a running pod.
    - Example: `kubectl exec -it my-pod -- /bin/bash`.
13. **`kubectl delete pod [pod_name]`** – Delete a specific pod.
14. **`kubectl rollout restart deployment [deployment_name]`** – Restart a deployment.
15. **`kubectl scale deployment [deployment_name] --replicas=[number]`** – Scale a deployment.

---

### Deployment Management
16. **`kubectl get deployments`** – List all deployments.
17. **`kubectl describe deployment [deployment_name]`** – View detailed information about a deployment.
18. **`kubectl delete deployment [deployment_name]`** – Delete a deployment.
19. **`kubectl rollout history deployment [deployment_name]`** – View deployment rollout history.
20. **`kubectl rollout undo deployment [deployment_name]`** – Roll back to a previous deployment.

---

### Service and Networking
21. **`kubectl get services`** – List all services.
22. **`kubectl describe service [service_name]`** – Display detailed information about a service.
23. **`kubectl delete service [service_name]`** – Delete a service.
24. **`kubectl get endpoints`** – Show the endpoints for services.
25. **`kubectl port-forward [pod_name] [local_port]:[container_port]`** – Forward a local port to a pod.

---

### Namespace Management
26. **`kubectl get namespaces`** – List all namespaces.
27. **`kubectl create namespace [namespace_name]`** – Create a new namespace.
28. **`kubectl delete namespace [namespace_name]`** – Delete a namespace.
29. **`kubectl config set-context --current --namespace=[namespace_name]`** – Switch the current namespace.

---

### ConfigMaps and Secrets
30. **`kubectl get configmaps`** – List all ConfigMaps.
31. **`kubectl describe configmap [configmap_name]`** – View details of a ConfigMap.
32. **`kubectl create configmap [configmap_name] --from-literal=[key]=[value]`** – Create a ConfigMap.
33. **`kubectl get secrets`** – List all secrets.
34. **`kubectl describe secret [secret_name]`** – View details of a secret.
35. **`kubectl create secret generic [secret_name] --from-literal=[key]=[value]`** – Create a secret.

---

### Persistent Volumes and Storage
36. **`kubectl get pv`** – List all persistent volumes.
37. **`kubectl get pvc`** – List all persistent volume claims.
38. **`kubectl describe pv [pv_name]`** – View details of a persistent volume.
39. **`kubectl describe pvc [pvc_name]`** – View details of a persistent volume claim.

---

### Resource Management
40. **`kubectl apply -f [file.yaml]`** – Apply a resource configuration from a file.
41. **`kubectl create -f [file.yaml]`** – Create resources from a file.
42. **`kubectl edit [resource_type] [resource_name]`** – Edit a resource interactively.
43. **`kubectl delete -f [file.yaml]`** – Delete resources defined in a file.

---

### Monitoring and Debugging
44. **`kubectl get events`** – List all events in the cluster.
45. **`kubectl describe [resource_type] [resource_name]`** – Display detailed information about a resource.
46. **`kubectl top pods`** – Show resource usage of pods.
47. **`kubectl top nodes`** – Show resource usage of nodes.
48. **`kubectl get pod [pod_name] -o yaml`** – View pod details in YAML format.

---

### Advanced Commands
49. **`kubectl apply --dry-run=client -f [file.yaml]`** – Validate resource configuration without applying it.
50. **`kubectl get all`** – List all resources in the current namespace.
51. **`kubectl get [resource_type] -o wide`** – Show additional details about a resource.
52. **`kubectl label [resource_type] [resource_name] [key]=[value]`** – Add a label to a resource.
53. **`kubectl annotate [resource_type] [resource_name] [key]=[value]`** – Add an annotation to a resource.

---

Let me know if you want detailed explanations, examples, or specific guidance on any Kubernetes commands!