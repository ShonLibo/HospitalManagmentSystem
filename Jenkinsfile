 pipeline{

     agent any


     stages {

         stage('Checkout') {        // this stage fetches the source code form github
             steps {
                 git branch: 'main', url: ''
             }
         }

         stage('sonarQube inspection){

            steps{
               withSonarQubeEnv('sonarQ'){
                   sh './mvnw clean org.sonar source.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'

                   // sh 'sonar-scanner -D sonar.projectKey=sonarQ'


               }
            }

         }


       stage('Build') {         // compiles the source code
             steps {
                 sh 'mvn clean compile'
             }
         }



       stage('unit test') {    // runs unit test
             steps {
                 sh 'mvn test'
             }


       }


        stage('Integration Tests') { // runs integration test
                    steps {
                        sh 'mvn verify'
                    }

        stage('Package') {  // Generates the JAR file
                    steps {
                        sh 'mvn package'
                    }


     }
 }