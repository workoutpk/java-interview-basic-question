Here’s a categorized list of commonly used Docker commands:

---

### Docker Basics
1. **`docker --version`** – Check Docker version.
2. **`docker info`** – Display detailed system information about Docker.
3. **`docker help`** – Get help on Docker commands.

---

### Container Management
4. **`docker run [image]`** – Run a new container from an image.
    - Example: `docker run -it ubuntu bash` (Interactive shell in Ubuntu).
5. **`docker ps`** – List running containers.
6. **`docker ps -a`** – List all containers, including stopped ones.
7. **`docker stop [container_id]`** – Stop a running container.
8. **`docker start [container_id]`** – Start a stopped container.
9. **`docker restart [container_id]`** – Restart a container.
10. **`docker rm [container_id]`** – Remove a stopped container.
11. **`docker logs [container_id]`** – View logs of a container.
12. **`docker exec -it [container_id] [command]`** – Execute a command inside a running container.
    - Example: `docker exec -it my_container bash`.

---

### Image Management
13. **`docker images`** – List all Docker images.
14. **`docker pull [image_name]`** – Download an image from Docker Hub.
    - Example: `docker pull nginx`.
15. **`docker build -t [tag_name] [path]`** – Build a Docker image from a Dockerfile.
16. **`docker tag [source_image] [target_image]`** – Tag an image with a new name.
17. **`docker push [image_name]`** – Push an image to a repository (requires login).
18. **`docker rmi [image_id]`** – Remove an image.
19. **`docker save [image_name] -o [file.tar]`** – Save an image as a tar archive.
20. **`docker load -i [file.tar]`** – Load an image from a tar archive.

---

### Network Management
21. **`docker network ls`** – List all Docker networks.
22. **`docker network inspect [network_name]`** – Inspect details of a network.
23. **`docker network create [network_name]`** – Create a new network.
24. **`docker network connect [network_name] [container_id]`** – Connect a container to a network.
25. **`docker network disconnect [network_name] [container_id]`** – Disconnect a container from a network.

---

### Volume Management
26. **`docker volume ls`** – List all volumes.
27. **`docker volume create [volume_name]`** – Create a new volume.
28. **`docker volume inspect [volume_name]`** – View details of a volume.
29. **`docker volume rm [volume_name]`** – Remove a volume.
30. **`docker run -v [volume_name]:[path_in_container] [image]`** – Mount a volume to a container.

---

### Docker Compose (if installed)
31. **`docker-compose up`** – Start services defined in a `docker-compose.yml` file.
32. **`docker-compose down`** – Stop and remove all services and containers.
33. **`docker-compose ps`** – List containers created by Compose.
34. **`docker-compose build`** – Build images defined in `docker-compose.yml`.
35. **`docker-compose logs`** – View logs of services.

---

### Container Management Tools
36. **`docker inspect [container_id]`** – View details about a container.
37. **`docker stats [container_id]`** – View real-time resource usage of containers.
38. **`docker top [container_id]`** – Show processes running inside a container.
39. **`docker commit [container_id] [image_name]`** – Create a new image from a container's changes.
40. **`docker export [container_id] -o [file.tar]`** – Export a container’s filesystem to a tar archive.
41. **`docker import [file.tar]`** – Import a tar archive as an image.

---

### Troubleshooting and Cleanup
42. **`docker system df`** – Show Docker disk usage.
43. **`docker system prune`** – Remove unused data (images, containers, volumes).
44. **`docker container prune`** – Remove all stopped containers.
45. **`docker image prune`** – Remove unused images.
46. **`docker logs -f [container_id]`** – Follow live logs of a container.

---

Let me know if you’d like detailed examples or assistance with any specific Docker commands!