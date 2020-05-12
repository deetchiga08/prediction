node {
   // This is to demo github action	
   def mvn = tool (name: 'maven6', type: 'maven') + '/usr/share/mvn'
   stage('SCM Checkout'){
    // Clone repo
	git branch: 'master', 
	credentialsId: 'github', 
	url: 'https://github.com/deetchiga08/prediction'
     
     stage('Mvn Package'){
	   // Build using maven
	   
	   sh "${mvn} clean package deploy"
   }
   
stage('deploy-dev'){
       def tomcatDevIp = '117.218.245.217'
	   def tomcatHome = '/var/lib/tomcat8/'
	   def webApps = tomcatHome+'webapps/'
	   def tomcatStart = "${tomcatHome}bin/startup.sh"
	   def tomcatStop = "${tomcatHome}bin/shutdown.sh"
	   
	   sshagent (credentials: ['tomcat-dev']) {
	      sh 'scp -o StrictHostKeyChecking=no target/*.war brillersys@117.218.245.217:/var/lib/tomcat8/webapps/' 
          sh "ssh brillersys@${tomcatDevIp} ${tomcatStop}"
		  sh "ssh brillersys@${tomcatDevIp} ${tomcatStart}"
       }
   }
   }
