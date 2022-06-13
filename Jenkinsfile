pipeline {
    agent any

    tools {
        maven "Maven"
        jdk "jdk9.0.4"
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('Test') {
            steps {
//                 sh "mvn test -Dtest='test'"
                   sh "mvn -o test"
            }
        }

    }
}
