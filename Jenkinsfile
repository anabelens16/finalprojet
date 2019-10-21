pipeline {
    agent any
    
    stages{
        stage('build'){
            steps{
                sh "mvn --version"
                sh "java -v"
                sh "mvn clean compile"
            }
            post{
            	always {
            		echo "build stage finished!!!!!"
            	}
            	changed {
            		echo "Du changement en build"
            	}
            	failure {
            		echo "Pas bon le build"
            	}
            	success {
            		echo "1 gommette pour le build"
            	}
            }
        }
        stage('test'){
            steps{
                sh "mvn test"
            }
        }
        stage('package'){
            steps{
                sh "mvn -DskipTests package"
            }
        }
        stage('deliver'){
            steps{
                echo "TODO : deliver"
            }
        }
    }
    post{
    	always {
    		echo "pipeline finished!"
    	}
    	changed {
    		echo "Du changement dans le pipeline"
    	}
    	failure {
    		echo "Pas bon le pipeline"
    	}
    	success {
    		echo "1 super gommette pour le pipeline"
    	}
    }
}
