#!/usr/bin/env groovy
package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }
    def buildImage(String ImageName){
        script.echo "Building docker image with name $ImageName"
        script.sh "docker build -t $ImageName ."
    }
    def runImage(String ImageName,Integer PortNum){
        script.withCredentials(
            [
                script.usernamePassword
                (
                    credentialsId: "$CredsId",
                    passwordVariable: 'PASS',
                    usernameVariable: 'USER'
                )
            ]
        )
        script.sh "docker tag $ImageName $script.USER/$ImageName"
        script.sh "docker run -d -p$PortNum:3000 $script.USER/$ImageName"
    }
    def DockerPushImage(String ImageName){
        script.sh "docker push $ImageName"
    }
    def DockerLogin(String CredsId){
        script.withCredentials(
            [
                script.usernamePassword
                (
                    credentialsId: "$CredsId",
                    passwordVariable: 'PASS',
                    usernameVariable: 'USER'
                )
            ]
        ) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }
    def DockerComposeBuild(){
        script.echo "Building docker Containers..."
        script.sh 'docker-compose build'
    }
    def DockerComposeUpDetached(){
        script.echo "Building docker Containers..."
        script.sh 'docker-compose up -d --build'
    }
    def DockerComposeUpNoDetached(){
        script.echo "Building docker Containers..."
        script.sh 'docker-compose up --build'
    }
    def DockerComposeStop(){
        script.echo "Stopping docker Containers..."
        script.sh 'docker-compose stop'
    }
    def DockerComposeDown(){
        script.echo "Stopping docker Containers and removing down..."
        script.sh 'docker-compose down'
    }
    def DockerComposePruneAll(){
        script.echo "Erasing all docker Containers and files associated with it"
        script.sh 'docker system prune -a'
    }
}