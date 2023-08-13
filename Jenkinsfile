pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Your build commands
                sh './gradlew assembleDebug'
            }
        }

        stage('Test') {
            steps {
                // Your test commands
                sh './gradlew test'
            }
        }

        // Additional stages for coverage and static analysis will go here
    }
}
