pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
    }

    environment {
        EMAIL_TO = "it2021091@hua.gr"
        DOCKER_USER = 'panayiotisperdios'
        DOCKER_SERVER = 'ghcr.io'
        DOCKER_PREFIX = 'ghcr.io/panayiotisperdios/blood-donor-backend'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'git@github.com:JohnSkouloudis/BloodDonorApp-Backend.git'
            }
        }
        
        stage('Docker build and push') {
            steps {
                sh '''
                    HEAD_COMMIT=$(git rev-parse --short HEAD)
                    TAG=$HEAD_COMMIT-$BUILD_ID
                    docker build --rm -t $DOCKER_PREFIX:$TAG -t $DOCKER_PREFIX:latest -f nonroot.Dockerfile .
                    docker push $DOCKER_PREFIX --all-tags
                '''
            }
        }
        stage('Run Ansible pipeline') {
            steps {
                build job: 'ansible'
            }
        }
        stage('Install project with Docker Compose') {
            steps {
                sh '''
                    export ANSIBLE_CONFIG=~/workspace/ansible/ansible.cfg
                    ansible-playbook -i ~/workspace/ansible/hosts.yaml -l azure-backend-server ~/workspace/ansible/playbooks/spring-vue-docker.yaml
                '''
            }
        }
    }
}
