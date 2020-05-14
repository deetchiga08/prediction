node{
   stage('SCM Checkout'){
     git 'https://github.com/deetchiga08/prediction'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'maven 3.6.0', type: 'maven'   
      sh "mvn clean package"
   }
   stage('Deploy to Tomcat'){
      
      sshagent(['dev-tomcat']) {
         sh 'scp -o StrictHostKeyChecking=no target/*.war brillersys@117.218.245.217:/opt/mydeploy'
      }
   }
}
   

