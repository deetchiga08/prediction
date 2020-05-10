node
{
    stage ("SCM checkout'){
           
           git 'https://https://github.com/deetchiga08/prediction'
           }
        stage ('compile package') {
          def mvnHome =  tool name: 'maven 3.6.0', type: 'maven'
            sh = "${mvnHome}/usr/share/maven mvn package"
           
        }
           }

            
