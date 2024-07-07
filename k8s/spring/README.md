# Spring(backend)

```sh
cd k8s/spring
```
# Pull blood-donor-backend Image
[requires secret for authentication](/k8s/README.md)
```sh
docker pull ghcr.io/panayiotisperdios/blood-donor-backend:latest
```
# Deployment
```sh
kubectl apply -f spring-deployment.yaml
```
# Service
```sh
kubectl apply -f spring-svc.yaml
```
# Ingress(Optional)
[requires ingress enabled](/k8s/README.md)
```sh
kubectl apply -f spring-ingress.yaml
```