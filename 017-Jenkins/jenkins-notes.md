## Jenkins
- Jenkins - self-contained automation server
  - automate building, testing, deployment of software
- Job - a repeatable set of steps that automate a task
  - Jobs can be triggered manually, externally, or by another job
  - When jobs run, we can view health information, view logs
  - Health is measured with a weather analogy
    - Sunny -> > 80% tests passing
    - Partially Sunny
    - Cloudy
    - Rainy
    - Stormy
  - Build have colors to represent state
    - blue - success
    - yellow - unstable
    - red - failure
    - grey - no builds yet
- Jenkinsfile
  - Used to specify the different stages in our pipeline
  - Include stages for each major part in the pipeline
  - Stages are broken into steps which are the specific actions to take in each stage
- Jenkins Interface
  - Can view different pipelines that were set up
  - In each Pipeline, we can view the status of the different builds (success or failure, which stages were reached)
  - Can also view the console output which is useful for debugging why our builds failed

## Install Links:
- Windows - https://www.jenkins.io/doc/book/installing/windows/
- Mac - https://www.jenkins.io/doc/book/installing/macos/
- Note that Jenkins runs on port 8080 by default, can change if you don't want to conflict with Spring boot applications that run on 8080

## Alternatives to Jenkins
- Jenkins is only one solution to automating builds/pipelines
- Can set up Github Actions to, for example, run tests whenever we push code, which can be integrated with Jenkins
- Gitlab is another platform hosting Git repositories that includes more enterprise-level features including CICD automation