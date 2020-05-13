node{
   def tomcatIp = '117.218.245.217'
   def tomcatUser = 'brillersys'
   def stopTomcat = "ssh ${tomcatUser}@${tomcatIp} /var/lib/tomcat8/bin/shutdown.sh"
   def startTomcat = "ssh ${tomcatUser}@${tomcatIp} /var/lib/tomcat8/bin/startup.sh"
   def copyWar = "scp -o StrictHostKeyChecking=no target/prediction-portal-api.war ${tomcatUser}@${tomcatIp}:/var/lib/tomcat8/webapps/"
   stage('SCM Checkout'){
        git branch: 'master', 
	        credentialsId: 'javahometech',
	        url: 'https://github.com/javahometech/myweb'
   }
   stage('Maven Build'){
        def mvnHome = tool name: 'maven 3.6.0', type: 'maven'
	   sh "${mvnHome}/usr/share/maven clean package"
   }
   
   stage('Deploy Dev'){
	   sh 'mv target/prediction-portal-api.war target/prediction-portal-api.war' 
	   
       sshagent(['deploy-tomcat']) {
			sh "${stopTomcat}"
			sh "${copyWar}"
			sh "${startTomcat}"
	   }
   }
}
