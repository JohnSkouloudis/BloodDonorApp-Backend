# Kubernetes Installation and Setup(Remote machine)
```sh
sudo snap install microk8s --classic
```
# Allow in firewall
Replace cni0 with your network interface, e.g. eth0 (you can find it by running the command ip a)
```sh
sudo ufw allow in on eth0 && sudo ufw allow out on eth0
sudo ufw default allow routed
```
# Access microk8s without sudo
```sh
sudo usermod -a -G microk8s $USER
mkdir ~/.kube
sudo chown -f -R $USER ~/.kube
sudo su - $USER
```
# Enable Ingress
```sh
microk8s.enable dns storage ingress
```
# Kubernetes remote access(with kubectl)
* [Kubectl Link](https://kubernetes.io/docs/tasks/tools/)
```sh
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
chmod +x kubectl
# with no root access
./kubectl get nodes

# with root access
sudo mv kubectl /usr/local/bin/kubectl
kubectl get nodes
```
 
# Alternative(K9s)
```sh
curl -sS https://webinstall.dev/k9s | bash
```
# Copy kubeconfig file from remote vm
```sh
mkdir -p ~/.kube
scp <host>:/home/<remote_user>/.kube/config ~/.kube
```
Replace lines(on local machine) certificate-authority-data and server ip with external remote machine ip
```sh
nano ~/home/<user>/.kube/config
insecure-skip-tls-verify: true
server: https://<remote_machine_external_ip>:16443
```

# Container Registry (github packages)

## Github Packages
* create personal access token (settings --> Developer settings -- > Personal Access Tokens), select classic
* select read:packages
* save the token to a file
* to see packages, go to your github profile and select tab Packages
* tag an image
```sh
docker build -t ghcr.io/<GITHUB-USERNAME>/ds-spring:latest -f nonroot.Dockerfile .
```
* login to docker registry
```sh
cat ~/github-image-repo.txt | docker login ghcr.io -u <GITHUB-USERNAME> --password-stdin
```
* push image
```sh
docker push ghcr.io/<GITHUB-USERNAME>/ds-spring:latest
```
## create docker login secret

* create a .dockerconfigjson file, like this
```json
{
    "auths": {
        "https://ghcr.io":{
            "username":"REGISTRY_USERNAME",
            "password":"REGISTRY_TOKEN",
            "email":"REGISTRY_EMAIL",
            "auth":"BASE_64_BASIC_AUTH_CREDENTIALS"
    	}
    }
}
```


* create <BASE_64_BASIC_AUTH_CREDENTIALS> from the command
```sh
echo -n <USER>:<TOKEN> | base64
```

## create dockerconfig secret
```sh
kubectl create secret docker-registry registry-credentials --from-file=.dockerconfigjson=k8s/.dockerconfig.json
```

# Links
* [Troubleshooting cert-manager](https://cert-manager.io/docs/troubleshooting/)
* [Spring boot health probes](https://www.baeldung.com/spring-liveness-readiness-probes)