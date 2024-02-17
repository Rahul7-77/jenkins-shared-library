#!/usr/bin/env groovy

import com.example.GT

def call(String CredsId,String UserName,String RepoName){
    return new GT(this).cloneGitUrlPvt(CredsId,UserName,RepoName)
}