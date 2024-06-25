pipeline {
    agent any

    triggers {
        cron('0 10 * * *')
    }

    environment {
        TZ = 'Asia/Kolkata'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository, main branch
                git url: 'https://github.com/pradeepsen11/flipkartHome-selenium-automation.git', branch: 'flipkart'
            }
        }
        
        stage('Build and Test') {
            steps {
                // Run Maven build and tests
                bat 'mvn clean install'
            }
        }

        stage('Publish Report') {
            steps {
                script {
                    // Use emailext plugin to send the report
                    emailext(
                        to: 'pksen7117@gmail.com',
                        subject: "Extent Report - Build #${env.BUILD_NUMBER}",
                        body: """
                            <p>Please find the attached Extent Report for build #${env.BUILD_NUMBER}.</p>
                            <p>Build details:</p>
                            <ul>
                                <li>Project: ${env.JOB_NAME}</li>
                                <li>Build Number: ${env.BUILD_NUMBER}</li>
                                <li>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></li>
                            </ul>
                        """,
                        attachLog: true,
                        attachmentsPattern: 'ExtentReports/ExtentReportResult.html',
                        mimeType: 'text/html'
                    )
                }
            }
        }
    }
}
