try{
	node{
    stage('Git Checkout'){
		git credentialsId: 'deetchiga08', 
		    url: 'https://github.com/deetchiga08/prediction',
			}
	
	
	
	stage('Maven Build'){
		sh 'mvn clean package'
	}
	stage('Deploy to Dev'){
		sh 'mv target/*.war target/prediction-portal-api.war'
		sshagent(['deploy-tomcat']) {
			sh 'ssh brillersys@117.218.245.217 rm -rf /var/lib/tomcat8/webapps/prediction-portal-api*'
		    sh 'scp target/prediction-portal-api.war brillersys@117.218.245.217:/var/lib/tomcat8/webapps/'
		    sh 'ssh brillersys@117.218.245.217 sudo service tomcat restart'
		}
	}
	}
