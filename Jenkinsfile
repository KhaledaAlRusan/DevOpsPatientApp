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

        stage('Coverage') {
            steps {
                sh './gradlew jacocoTestReport'
            }
            post {
                always {
                    jacoco()
                }
            }
        }
        stage('Static Code Analysis') {
            steps {
                 sh './gradlew ktlintCheck'
                 }
                    post {
                        always {
                            recordIssues tool: kotlin(name: 'ktlint'), pattern: 'app/build/reports/ktlint/ktlint*.txt' // Adjust the pattern according to your project structure
                        }
                    }
                }

    }
}
