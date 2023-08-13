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
    }
}
