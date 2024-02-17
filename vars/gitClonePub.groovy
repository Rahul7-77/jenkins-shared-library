#!/usr/bin/env groovy
import com.example.GT

def call(String branch = 'main', boolean changelog = false, boolean poll = false, String url) {
    // Clone the Git repository with specified configuration options
    git branch: branch, changelog: changelog, poll: poll, url: url
}