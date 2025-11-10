pipeline {
    agent any

    tools {
        maven 'Maven-3.9.9'  // Make sure this is configured in Jenkins Global Tool Configuration
        jdk 'Java-21'        // Make sure this is configured in Jenkins Global Tool Configuration
    }

    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean compile test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeScannerServer') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=milind-patle_sonarqube-practice -Dsonar.organization=milind-patle'
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completed - check SonarQube dashboard for analysis results'
        }
        success {
            echo 'Build and SonarQube analysis completed successfully!'
        }
        failure {
            echo 'Pipeline failed - check logs for details'
        }
    }
}