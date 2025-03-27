#!/usr/bin/env groovy

def buildPushDocker(){
    echo "Building the image..."
    withCredentials([usernamePassword(credentialsId: "docker-hub-creds", usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        sh "docker build -t santana20095/node-app:${IMAGE_NAME} ."
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push santana20095/node-app:${IMAGE_NAME}"
    }
}