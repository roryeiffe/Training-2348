## Docker
- A technology that lets us package all of the dependencies of an application into one unit which can be replicated on another machine, pulling in the required dependencies automatically

## Containers
- Container - mechanism for packaging an app with its dependencies so that it runs in its own isolated sandbox
  - Dependency Examples 
    - Installing Java, JDK
    - Installing Maven
    - Node
  - Ensures our app run regardless of host environment (even if the technologies aren't downloaded on the host computer)
  - Container can't change host environment and vice versa
  - Secure
    - Isolated from host
    - Standardized
      - Some base images we can pull from
    - Lightweight
    - Scalable
## Images
- Template for containers
- Containers will be a runnable instance of an image
- Typically, to run a Docker container:
  - Define an image by writing a Dockerfile
  - Build image from the Dockerfile
  - Run container based off of the image

## Container vs Virtual Machines
- Virtual Machines virtualize the entire OS
- More bulky than containers
- Containers leverage the host's OS and contain the libraries/dependencies they need

## Docker Architecture
- Client-Server Architecture
- Server - Docker Daemon
  - Long-running process that is responsible for managing Docker objects (containers, images)
  - Listen for calls to manage containers, images
  - If we have Docker Desktop running, then our daemon is running
- Client - Command Line Interface
  - We send commands to Docker via the command line
  - prefaced by the word "docker"
  - Cheatsheet - https://dockerlabs.collabnix.com/docker/cheatsheet/ 

## Docker Images
- Image - the template that outlines dependencies for a particular container and its primary processes
- Blueprint for containers
- docker pull *image name*
- docker push *image name*

## Docker Containers
- Running instance of a Docker image
- Share the host OS
- For Windows computers, there is an additional layer of virtualization
  - Must have Hyper-V and virtualization enabled
- Container states - 
  - created
  - restarted
  - running
  - paused
  - exited
  - dead

## Dockerfile
- a file that is used to again to define images
- file must be named "Dockerfile" (note lack of spaces and casing)
- Define everything needed for an image
  - Starting Point, base image to start from
  - Dependencies - whatever technologies we need to run
  - Define 1 or more commands to run
- Most Dockerfiles begin with FROM, to indicate the base image

### Commands
- docker images - lists images
- docker ps - list running containers (add -a flag to list all containers)
- docker build -t java-hello-world .
- docker run java-hello-world
- docker run --rm grycap/cowsay
- docker pull *image name*
- docker push *image name*