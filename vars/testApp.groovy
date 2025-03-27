#!/usr/bin/env groovy

def testApp(){
    dir('app'){
        sh "npm install"
        sh "npm run test"
    }
}