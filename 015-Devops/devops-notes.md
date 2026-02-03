## DevOps
- Development Operations
- A set of practices/methodologies designed to make the development, deployment, and maintenance of code into a streamlined process
  - Usually involves the automation of tasks
  - Structured Workflows
  - Striving for Efficiency and Sustainability

### DevOps Stages/Steps
1. Source Code Control - writing code and maintaining in some repository (Github)
2. Automation - test functionality of code (unit testing, integration testing, etc.), create a working build of the app
3. Deploy to Staging - deploy working build to a temporary environment where we can optionally run more tests and deploy to production
4. Acceptance Testing - more testing, can see how the app works in a temporary/simulated environment
5. Deployment to Production - migrate the build to a production environment where it is accessible by end users

## CICD
- Each phase builds on the last
- If we have a Continuous Delivery pipeline, this implies that we also have Continuous Integration set up
- The further down we go, the more steps in our overview we go

### Continuous Integration
- Process of regularly merging code into a central repository
- Review changes whenever they come in, ensuring it integrates well with the current code base
- Git, Github, Gitlab
- Without CI, we wouldn't be able to go on to Continuous Delivery or Deployment
- The more frequently we merge code, the fewer issues will arise, less complex merge conflicts
- Benefits
  - Ensures each member of the team is working on up-to-date code
  - Identify failures early/whenever we merge them in
  - Reducing risks

### Continuous Delivery
- Automate the source code control, building/testing, deployment to staging environment
- Leave acceptance testing and deployment to production to human intervention
- Deployments can be made "at the push of a button"
- Benefits
  - Reduced Risk for deployment - catch issues in the temporary environment
  - Predictable Progress - iterative builds that indicate progress 
  - Feedback - based on how the build performs in the temporary environment


### Continuous Deployment
- Every step of the pipeline is automated
- Efficiency-wise, this model is very desirable because everything is automated
  - But requires the most work to set up, rigid requirements, comprehensive tests
  - Requires more detailed/rigorous pipelines
- Because the push to production is automated, can have less risky deployments if we deploy in small changes and receive user feedback consistently