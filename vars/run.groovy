def call(String image, String container){
    sh """
        docker pull jhinga/${image}:latest

        if [ \$(docker ps -a -q -f name=^/${container}\$) ]; then
            docker stop ${container}
            docker rm ${container}
        fi

        docker run --name ${container} -d -p 8081:80 -e VITE_CLERK_PUBLISHABLE_KEY=pk_test_cmVndWxhci1zYXR5ci0zMS5jbGVyay5hY2NvdW50cy5kZXYk jhinga/${image}:latest
    """
}
