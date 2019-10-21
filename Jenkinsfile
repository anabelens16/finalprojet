pipeline {
    agent any
    
    stages{
        stage('build'){
            steps{
                sh "pwd"
                sh "echo $JAVA_HOME"
                sh "mvn --version"
                sh "java --version"
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
                //sh "mvn test"
                echo "test toto"
                echo "lol"
                echo "test"
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
                sh "scp -i /root/.ssh/id_rsa /var/jenkins_home/workspace/PipelinePackaging/target/patients.war ubuntu@13.58.127.120:/ourapp/wildfly/webapps_target/patients.war"
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