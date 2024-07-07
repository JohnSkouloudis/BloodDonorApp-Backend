# Postgres

```sh
cd k8s/postgres
```
# Persistant Volume
```sh
kubectl apply -f postgres-pvc.yaml
```
# Deployment
```sh
kubectl apply -f postgres-deployment.yaml
```
# Service
```sh
kubectl apply -f postgres-svc.yaml
```
