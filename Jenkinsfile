pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("CheckOut") {
            steps {
                git url : 'https://github.com/MSC4791/calculator.git'
            }
        }
        stage("Compile") {
            steps {
                sh './gradlew compileJava'
            }
        }
        stage("UnitTest") {
            steps {
                sh './gradlew test'
            }
        }
        stage("CodeCoverage") {
            steps {
                sh './gradlew jacocoTestReport'
                publishHTML (target : [
                    reportDir : 'build/reports/jacoco/test/html',
                    reportFiles : 'index.html',
                    reportName : 'JaCoCo Report'
                ])
                sh './gradlew jacocoTestCoverageVerification'
            }
        }
        stage("StaticCodeAnalysis") {
            steps {
                sh './gradlew checkstyleMain'
                publishHTML (target : [
                    reportDir : 'build/reports/checkstyle/',
                    reportFiles : 'main.html',
                    reportName : 'CheckStyle Report'
                ])
            }
        }
    }
}
