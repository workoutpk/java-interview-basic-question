Here’s a list of commonly used **Azure CLI (Command-Line Interface) commands**, categorized for easier reference:

---

### ⚙️ **Account Management**
- `az login` – Sign in to your Azure account.
- `az logout` – Sign out of your Azure account.
- `az account list` – List all Azure subscriptions.
- `az account set --subscription <subscription_name_or_id>` – Set the active subscription.
- `az account show` – Show details of the currently active subscription.

---

### ☁️ **Resource Group Management**
- `az group create --name <group_name> --location <location>` – Create a new resource group.
- `az group list` – List all resource groups.
- `az group delete --name <group_name>` – Delete a resource group.
- `az group show --name <group_name>` – Show details of a resource group.

---

### 💾 **Storage Management**
- `az storage account create --name <account_name> --resource-group <group_name> --location <location> --sku <sku>` – Create a storage account.
- `az storage account list` – List storage accounts.
- `az storage container create --name <container_name> --account-name <account_name>` – Create a blob container.
- `az storage blob upload --container-name <container_name> --file <file_path> --name <blob_name>` – Upload a file as a blob.

---

### 💻 **Virtual Machine (VM) Management**
- `az vm create --resource-group <group_name> --name <vm_name> --image <image> --admin-username <username> --generate-ssh-keys` – Create a VM.
- `az vm list` – List all virtual machines.
- `az vm start --name <vm_name> --resource-group <group_name>` – Start a VM.
- `az vm stop --name <vm_name> --resource-group <group_name>` – Stop a VM.
- `az vm delete --name <vm_name> --resource-group <group_name>` – Delete a VM.

---

### 🔒 **Azure Active Directory (AD)**
- `az ad user create --display-name <name> --user-principal-name <user@domain> --password <password>` – Create a new AD user.
- `az ad user list` – List all Azure AD users.
- `az ad group create --display-name <name> --mail-nickname <nickname>` – Create a new AD group.
- `az ad group member add --group <group_name> --member-id <user_id>` – Add a user to a group.

---

### 🏷️ **Azure Resource Management**
- `az resource list` – List all resources in a subscription.
- `az resource delete --ids <resource_id>` – Delete a specific resource.
- `az resource show --ids <resource_id>` – Show detailed information about a resource.

---

### 📈 **Monitoring & Metrics**
- `az monitor activity-log list` – List activity logs.
- `az monitor metrics list --resource <resource_id>` – Retrieve metrics for a resource.
- `az monitor alert create --name <alert_name> --resource-group <group_name>` – Create a new alert rule.

---

### 📊 **Networking**
- `az network vnet create --name <vnet_name> --resource-group <group_name> --subnet-name <subnet_name>` – Create a virtual network and subnet.
- `az network nsg create --resource-group <group_name> --name <nsg_name>` – Create a network security group.
- `az network public-ip create --name <ip_name> --resource-group <group_name>` – Create a public IP address.

---

### 🐳 **Azure Kubernetes Service (AKS)**
- `az aks create --resource-group <group_name> --name <cluster_name> --node-count <count> --enable-addons monitoring --generate-ssh-keys` – Create a Kubernetes cluster.
- `az aks get-credentials --resource-group <group_name> --name <cluster_name>` – Get credentials for the cluster.
- `az aks list` – List AKS clusters.
- `az aks delete --name <cluster_name> --resource-group <group_name>` – Delete a Kubernetes cluster.

---

### 🛠️ **App Service Management**
- `az webapp create --resource-group <group_name> --plan <app_service_plan> --name <app_name> --runtime "<runtime>"` – Create a web app.
- `az webapp list` – List all web apps.
- `az webapp delete --name <app_name> --resource-group <group_name>` – Delete a web app.

---

Would you like any specific examples or explanations for these Azure commands? 🚀