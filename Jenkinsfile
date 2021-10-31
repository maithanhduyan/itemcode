node {

    stage('Clone sources') {
        git url: 'https://github.com/maithanhduyan/itemcode.git/'
    }
    
    stage("Test") {
        sh "mvn test" 
    }

    stage("Build") {
        sh "mvn clean install" 
    }

      stage("Run") {
        withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
            if (isUnix()) {
                sh 'nohup mvn spring-boot:run &'
            } else {
                bat 'start mvn spring-boot:run '
            }
        }
    }

}