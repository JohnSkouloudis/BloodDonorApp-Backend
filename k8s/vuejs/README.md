# Vuejs(frontend)

```sh
cd k8s/vuejs
```
# Pull blood-donor-backend Image
[requires secret for authentication](/k8s/README.md)
```sh
docker pull ghcr.io/panayiotisperdios/blood-donor-frontend:latest
```
# Deployment
```sh
kubectl apply -f vuejs-deployment.yaml
```
# Service
```sh
kubectl apply -f vuejs-svc.yaml
```
# Ingress
[requires ingress enabled](/k8s/README.md)
```sh
kubectl apply -f vuejs-ingress.yaml
```