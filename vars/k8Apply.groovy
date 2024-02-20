#!/usr/bin/env groovy
def call(String file){
    sh "kubectl apply -f ${file}.yaml"
}