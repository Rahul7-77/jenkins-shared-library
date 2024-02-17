#!/usr/bin/env groovy

def call(){
    dependencyCheck additionalArguments: '--scan ./ ', odcInstallation: 'DP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}