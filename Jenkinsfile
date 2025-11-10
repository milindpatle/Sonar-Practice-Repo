pipeline {
    agent any

    environment {
        PATH = "/opt/maven/bin:$PATH" 
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean deploy'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'SonarQube Scanner Tool' // Tool name configured in Jenkins -> Global Tool Configuration
            }
            steps {
                withSonarQubeEnv('SonarQubeScannerServer') { // Name configured under "Manage Jenkins -> Configure System -> SonarQube Servers"
                    sh """
                        ${scannerHome}/bin/sonar-scanner 	
                    """
                }
            }
        }
    }
}

