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
