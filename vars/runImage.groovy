#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName,Integer PortNum){
    return new Docker(this).runImage(imageName,PortNum)
}