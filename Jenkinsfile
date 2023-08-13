pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew assembleDebug'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Coverage') {
            steps {
                sh './gradlew jacocoTestReport'
            }
            post {
                always {
                    jacoco(path: '**/build/jacoco/testDebugUnitTest.exec')
                }
            }
        }

        stage('Static Code Analysis') {
            steps {
                 sh './gradlew ktlintCheck'
            }
        }

        // CD stages start here

        stage('Deliver') {
            steps {
                echo 'Releasing artifact...'
                sh './gradlew assembleRelease'  // This assumes you have set up signing for release builds
                archiveArtifacts artifacts: '**/build/outputs/apk/release/*.apk', allowEmptyArchive: true

            }
        }

        stage('Deploy to Dev Env') {
            steps {
                echo 'Mock deploying artifact to Dev environment...'
                sh 'mkdir -p "C:\\ProgramData\\Jenkins\\.jenkins\\jobs\\Patient App pipeline\\apk"'
                sh 'cp **/build/outputs/apk/release/*.apk "C:\\ProgramData\\Jenkins\\.jenkins\\jobs\\Patient App pipeline\\apk"'
            }
        }

        stage('Deploy to QAT Env') {
            steps {
                echo 'Mock deploying artifact to QAT environment...'
            }
        }

        stage('Deploy to Staging Env') {
            steps {
                echo 'Mock deploying artifact to Staging environment...'
            }
        }

        stage('Deploy to Production Env') {
            steps {
                echo 'Mock deploying artifact to Production environment...'
            }
        }

    }
}
