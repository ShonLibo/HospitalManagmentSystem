//  pipeline{
//
//      agent any
//
//
//      stages {
//
//          stage('Checkout') {        // this stage fetches the source code form github
//              steps {
//                  git branch: 'main', url: ''
//              }
//          }
//
//          stage('sonarQube inspection){
//
//             steps{
//                withSonarQubeEnv('sonarQ'){
//                    sh './mvnw clean org.sonar source.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
//
//                    // sh 'sonar-scanner -D sonar.projectKey=sonarQ'
//
//
//                }
//             }
//
//          }
//
//
//        stage('Build') {         // compiles the source code
//              steps {
//                  sh 'mvn clean compile'
//              }
//          }
//
//
//
//        stage('unit test') {    // runs unit test
//              steps {
//                  sh 'mvn test'
//              }
//
//
//        }
//
//
//         stage('Integration Tests') { // runs integration test
//                     steps {
//                         sh 'mvn verify'
//                     }
//
//         stage('Package') {  // Generates the JAR file
//                     steps {
//                         sh 'mvn package'
//                     }
//
//
//      }
//  }


///////////

pipeline {
    agent any

    environment {
            ITCH_API_KEY = credentials('ivymO7TQbEZazejnI5bvfousSX7A9GXGn1Ebfz3s') // Reference the credential ID
            ITCH_USER = 'Natty50'
            ITCH_GAME = 'Hospital Management System'
        }

    stages {
        stage('Checkout') { // Fetches source code from GitHub
            steps {
                git branch: 'main', url: 'https://github.com/ShonLibo/HospitalManagmentSystem.git'
            }
        }

       // stage('sonarQube inspection') {
        //    steps {
       //         withSonarQubeEnv('sonarQ') {
                    sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
       //         }
         //   }
       // }

        stage('Build') { // Compiles the source code
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') { // Runs unit tests
            steps {
                sh 'mvn test'
            }
        }

        stage('Integration Tests') { // Runs integration tests
            steps {
                sh 'mvn verify'
            }
        }

        stage('Package JAR') { // Generates the JAR file
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive JAR') { // Stores the JAR in Jenkins artifacts
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy to itch.io') { // Uploads the JAR to itch.io using Butler
            steps {
                withCredentials([string(credentialsId: 'ivymO7TQbEZazejnI5bvfousSX7A9GXGn1Ebfz3s', variable: 'BUTLER_API_KEY')]) {
                    sh 'butler login --api-key $BUTLER_API_KEY'
                    sh 'butler push target/*.jar Natty50/Hospital Management System :latest --user version 1.0.0''
                }
            }
        }
    }
}

