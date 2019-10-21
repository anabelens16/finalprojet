pipeline {
    agent any
    
    stages{
        stage('build'){
            steps{
     		sh "mvn -v"
                sh "mvn -DskipTests clean  package"
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
		sh	"jar tvf target/patients.war | grep public"

            		echo "1 gommette pour le build"
            	}
            }
        }
        stage('test'){
            steps{
                //sh "mvn test"
                echo "test toto"
                echo "lol"
                echo "test"
            }
        }
        stage('deliver'){
            steps{
                echo "TODO : deliver"
                sh "scp  target/patients.war root@13.58.127.120:/ourapp/wildfly/webapps_target/patients.war"
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
