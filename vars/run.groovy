def call(String image, String container){
sh """
    docker pull jhinga/${image}:latest
    docker stop ${container}
    docker rm ${container}
    docker run --name ${container} -d -p 8080:80 -e VITE_CLERK_PUBLISHABLE_KEY=$KEY ${image}:latest
"""
}
