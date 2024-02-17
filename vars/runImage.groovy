#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName,def PortNum){
    return new Docker(this).buildImage(imageName,PortNum)
}