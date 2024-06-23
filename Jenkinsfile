pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git url: 'https://github.com/pradeepsen11/flipkartHome-selenium-automation.git', branch: 'flipkart'
            }
        }
        
        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run Maven tests
                bat 'mvn test'
            }
        }
    }
}
