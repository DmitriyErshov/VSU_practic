pipeline {
    agent any
    
    stages {
        stage("Compile code") {
            steps {
                bat 'mvn clean compile assembly:single'
            }
        }
        stage("Tests") {
            when {
                branch 'feature/*'
            }
            steps {
                bat 'mvn test'
            }
        }
        stage("Static analyse") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        stage("Report") {
            when {
                branch 'feature/*'
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install") {
            steps {
                bat 'mvn install'
            }
        }
        stage("Publish") {
            steps {
                bat 'copy "target\\LRUCache-1.0-SNAPSHOT-jar-with-dependencies.jar" "C:\\NewIdeaProjects\\VSU_practic"'
            }
        }
    }
}