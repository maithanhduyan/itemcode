node {

    stage('Clone sources') {
        sh 'git pull https://github.com/maithanhduyan/itemcode.git/ master'
    }
    
    stage("Test") {
        sh "mvn test" 
    }

    stage("Build") {
        sh "mvn clean install" 
    }

      stage("Run") {

         if (isUnix()) {
            sh "pid=\$(lsof -i:8081 -t); kill -TERM \$pid || kill -KILL \$pid"
        } else {
            bat "FOR /F \"tokens=5 delims= \" %%G IN (\"netstat -a | findstr :8081\") DO TaskKill.exe /PID %%G /fi \"memusage gt 0\""
        }
         
        withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
            if (isUnix()) {
                sh 'nohup mvn spring-boot:run &'
            } else {
                bat 'start mvn spring-boot:run '
            }
        }
    }

}