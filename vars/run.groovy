def call(String image, String container){
    sh """
        docker pull jhinga/${image}:latest

        if [ \$(docker ps -a -q -f name=^/${container}\$) ]; then
            docker stop ${container}
            docker rm ${container}
        fi

        docker run --name ${container} -d -p 8080:80 -e VITE_CLERK_PUBLISHABLE_KEY=\$KEY jhinga/${image}:latest
    """
}
