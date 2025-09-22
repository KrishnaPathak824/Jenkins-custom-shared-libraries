def call(String service, String name){
  sh '''
                cd code
                cd ${service}
                docker build -t ${name} .
     '''
}
