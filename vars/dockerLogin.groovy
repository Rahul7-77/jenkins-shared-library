#!/usr/bin/env groovy
import com.example.Docker

def call(String CredsId){
    return new Docker(this).DockerLogin(CredsId)
}