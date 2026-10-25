
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'libaray.management.app'
        CONTAINER_NAME = 'springboot-app'

        // Docker command-line folder
        PATH = "C:\\Users\\Win11\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/madhavbera/project3.git'
            }
        }

        stage('Check Docker') {
            steps {
                bat 'where docker'
                bat 'docker --version'
                bat 'docker info'
            }
        }

        stage('Check Project Files') {
            steps {
                bat 'cd'
                bat 'dir'
                bat 'dir /s /b pom.xml'
                bat 'dir /s /b Dockerfile'
            }
        }

        stage('Build and Test') {
            steps {
                dir('libaray.management.app') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('libaray.management.app') {
                    bat 'docker build -t %IMAGE_NAME% .'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                bat '''
                    docker rm -f %CONTAINER_NAME% 2>nul
                    docker run -d --name %CONTAINER_NAME% -p 9090:8283 %IMAGE_NAME%
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the first error in Console Output.'
        }
    }
}
