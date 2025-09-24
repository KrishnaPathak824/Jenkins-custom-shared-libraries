def call(String Project){
withCredentials([usernamePassword('credentialsId':"docker-cred",passwordVariable:"dockerpass",usernameVariable:"dockeruser")]){
                    sh """
                    docker login -u $dockeruser -p $dockerpass
                    docker image tag ${Project} $dockeruser/${Project}:${BUILD_ID}
                    docker image tag ${Project} $dockeruser/${Project}:latest
                    docker push $dockeruser/${Project}:${BUILD_ID}
                    docker push $dockeruser/${Project}:latest
                    """
                    }
}
