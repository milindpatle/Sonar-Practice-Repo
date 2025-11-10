pipeline {
    agent any

    tools {
        maven 'Maven' // Define Maven tool name as configured in Jenkins
        jdk 'JDK17'   // Define JDK tool name as configured in Jenkins
    }

    environment {
        SONARQUBE = credentials('sonarqube-token') // Add SonarQube token credentials in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/USERNAME/my-java-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=my-java-app -Dsonar.login=$SONARQUBE'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Application...'
            }
        }
    }
}
