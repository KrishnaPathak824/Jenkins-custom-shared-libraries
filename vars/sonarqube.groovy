def call(String SonarQubeAPI, String Project, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){
    sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Project} -Dsonar.projectkey=${ProjectKey} -x"
  }
}
