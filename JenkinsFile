pipeline {
    agent any
    tools { 
        Maven 'M3' 
        jdk 'Open JDK 11' 
    }
    stages {
        stage ('Initialize') {
            steps {
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
             }
        }

        stage ('Build') {
            steps {
                """
                mvn test
                """
            }
        }
    }
}
