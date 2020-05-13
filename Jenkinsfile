node{
stage('SCM Checkout'){
git branch: 'master',
url: 'https://github.com/deetchiga08/prediction'

}
stage('Maven Build'){
def mvnHome = tool name: 'maven 3.6.0', type: 'maven'
sh "mvn clean package"
}
stage('deploy-dev'){
def tomcatDevIp = '117.218.245.217'
def tomcatHome = '/var/lib/tomcat8/'
def webApps = tomcatHome+'webapps/'
def tomcatStart = "${tomcatHome}bin/startup.sh"
def tomcatStop = "${tomcatHome}bin/shutdown.sh"

sshagent(['dev'])  {
sh sshpass -p "flamingo@123" "scp -o StrictHostKeyChecking=no /target/prediction-portal-api*.war brillersys@${tomcatDevIp}:${webApps}prediction-portal-api.war"
sh "ssh brillersys@${tomcatDevIp} ${tomcatStop}"
sh "ssh brillersys@${tomcatDevIp} ${tomcatStart}"
}
}
}
