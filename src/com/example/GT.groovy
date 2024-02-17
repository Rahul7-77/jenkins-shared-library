#!/usr/bin/env groovy
package com.example

class Gt implements Serializable{
    def script
    Gt(script){
        this.script=script
    }
    def cloneGitUrlPub(String Giturl){
        script.echo "Cloning the code from $Giturl"
        script.sh "git clone $Giturl"
    }
    def cloneGitUrlPvt(string CredsId,string UserName,string RepoName){
        script.withCredentials(
            [
                script.usernamePassword
                (
                    credentialsId: "$CredsId",
                    passwordVariable:'PASS',
                    usernameVariable:'USER'
                )
            ]
        ){
            script.echo "Cloning code from private github repo"
            script.sh "git clone https://$script.USER:$script.PASS@github.com/$script.UserName/$script.RepoName"
        }
    }
}