# Start by specifying a base image
FROM ubuntu

# Install programs and run some updates
RUN apt-get update
RUN apt-get -y dist-upgrade
# install the JDK:
RUN apt-get -y install default-jdk

# Set up the working directory
WORKDIR /example

# Now that we have our base image, required dependencies, and a working directory, we can 

# To start, define a simple HelloWorld class
RUN echo 'public class HelloWorld { public static void main(String [] args) {System.out.println("Hello World updated");}}' > HelloWorld.java

# Compile the file
RUN javac HelloWorld.java

# Run the Java program (Entrypoint)
CMD ["java", "HelloWorld"]
# To build image: docker build -t java-hello-world .
# To run container based off image: docker run java-hello-world
