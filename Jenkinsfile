node{
def tomcatIp = '117.218.245.217'
def tomcatUser = 'deployer'
def stopTomcat = "ssh ${tomcatUser}@${tomcatIp} /var/lib/tomcat8/bin/shutdown.sh"
def startTomcat = "ssh ${tomcatUser}@${tomcatIp} /var/lib/tomcat8/bin/startup.sh"
def copyWar = "scp -o StrictHostKeyChecking=no target/*.war ${tomcatUser}@${tomcatIp}:var/lib/tomcat8/webapps/"
stage('SCM Checkout'){
git branch: 'master',
credentialsId: 'deetchiga08',
url: 'https://github.com/deetchiga08/prediction'
}
stage('Maven Build'){
def mvnHome = tool name: 'maven', type: 'maven'
sh "${mvnHome} clean package"
}

stage('Deploy Dev'){
sh 'mv target/*.war target/*.war'

sshagent(['tomcat-dev']) {
sh "${stopTomcat}"
sh "${copyWar}"
sh "${startTomcat}"
}
}
}
