#!/usr/bin/env groovy
import com.example.Gt

def call(String giturl){
    return new GT(this).cloneGitUrl(giturl)
}