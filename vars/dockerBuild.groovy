def call(String service, String name){
  sh """
                cd ${service}
                docker build -t ${name} .
     """
}
