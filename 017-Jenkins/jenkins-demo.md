## Jenkins Demo Prerequisites
- To start, we will want to create a Java Maven project and push it up to a Github repository
- Want to ensure that the application has at least 1 test to run
- On Jenkins, make sure we have the Git plugin and the Pipeline plugin
  - Should be installed by default, can go to Settings -> Plugin Manager -> Available Plugins

## Steps to take on UI
- From the main page that lists our jobs/pipelines, we click "New Item"
- Give it a name, select Pipeline
- Check Github Project box, which should bring up an input field to enter in the url for the repo
- Can inspect some of the other fields but the main thing we want to configure is down below under Pipelines
  - Here, we can directly paste in the Jenkinsfile code
  - Otherwise, we can specify to use the Jenkinsfile in the repo
  - Also, specify Git information like the repo from which we're working, the default branch name, and the location of the Jenkinsfile in the repo
    - Optionally, specify credentials if we have a private repo

## Jenkinsfile
```groovy
pipeline {
  // Agents are entities in Jenkins that are used to run jobs
  // In this case, we are delegating to Jenkins to use any available agent
  agent any

  // set up stages of the pipeline, somewhat correlate with stages in our DevOps
  stages {
    // Check out the code from Github or wherever our code is hosted. In Jenkins, we can specify which url to pull in
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    // Run our tests, using mvn command, should run all tests in our project
    stage('Test') {
      steps {
        bat 'mvn -B -ntp test'
      }
    }

    // package our application into one unit, utilizing Maven
    stage('Package') {
      steps {
        bat 'mvn -B -ntp package'
      }
    }
  }

  post {
    always {
      // If you have Surefire tests, this will publish results in Jenkins.
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, allowEmptyArchive: true
    }
  }
}
```