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
        stage("Package") {
            steps {
                sh './gradlew build'
            }
        }
        stage("DockerBuild") {
            steps {
                sh 'docker build -t localhost:5000/comnet/calculator:latest .'
            }
        }
        stage("DockerPush") {
            steps {
                sh 'docker push localhost:5000/comnet/calculator'
            }
        }
        stage("DeployToStage") {
            steps {
                sh 'docker run -d --rm -p 8765:8090 --name calculator localhost:5000/comnet/calculator'
            }
        }
        stage("AcceptanceTest") {
            steps {
                sleep 60
                sh './acceptance_test.sh'
            }
        }
    }
    post {
        always {
            sh "docker stop calculator"
            sh "docker rm calculator"
        }
    }
}
