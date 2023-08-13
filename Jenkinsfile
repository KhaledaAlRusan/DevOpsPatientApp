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
                    // Specify the path to the JaCoCo XML report
                    jacoco(executionDataPath: '**/build/jacoco/test.exec', 
                           classPattern: '**/classes', 
                           sourcePattern: '**/src/main/java')
                }
            }
        }
    }
}
