#!/usr/bin/env groovy

def call(){
    withCredentials([usernamePassword(credentialsId: "git-creds", usernameVariable: 'USER', passwordVariable: 'PWD') ]){
        sh "git config --global user.email jenkins@example.com"
        sh "git config --global user.name jenkins"

        sh "git status"
        sh "git branch"
        sh "git config --list"

        sh "git remote set-url origin https://${USER}:${PWD}@github.com/raouf21-dev/jenkins-exercises.git"
        sh 'git add .'
        sh "git commit -m 'ci version bump'"
        sh "git push origin HEAD:master"
    }
}