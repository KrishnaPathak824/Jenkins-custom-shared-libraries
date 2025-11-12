def call(String Project, String Version){
withCredentials([usernamePassword('credentialsId':"docker-cred",passwordVariable:"dockerpass",usernameVariable:"dockeruser")]){
                    sh """
                    docker login -u $dockeruser -p $dockerpass
                    docker image tag ${Project} $dockeruser/${Project}:${Version}
                    docker image tag ${Project} $dockeruser/${Project}:latest
                    docker push $dockeruser/${Project}:${Version}
                    docker push $dockeruser/${Project}:latest
                    """
                    }
}
