## Creating the Instance
- Go to the EC2 console on AWS
- Click on Launch Instance
- Enter a name for the instance
- Select an AMI, in this case, we'll pick Amazon Linux
  - **MAKE SURE IT IS FREE TIER ELIGIBLE**
- Instance Type - configure CPU, memory
  - **MAKE SURE TO PICK A FREE TIER ELIGIBLE OPTION**
- Key Pair - create a new one
  - Select RSA, .pem as options
  - Once we click create, it will download the file
  - For Windows users, we can put the downloaded key in our user folder
  - Once we have the key file downloaded, we can continue on with our configuration
- Under Network Settings, can configure security group
  - Quick options are SSH, HTTPS, HTTP
    - For SSH, we can set the IP to be your own as opposed to anywhere
- Once everything is configured, review settings and hit "Launch Instance"

## Connect to the Instance
- Once we have our instance created, navigate to it (click the id from the list of running instances)
- We can click "Connect" to view different connection options
- We will choose "SSH Client"
- Open up Command Prompt
- Navigate to the key file that was downloaded earlier
- Ensure the proper permissions are set
  - For Mac users: chmod 400 "key-pair-2-4-26.pem"
  - For Windows, keeping the pem file in your C:/Users/User folder should work
- For the 4th step, AWS showcases the exact command to run
- Type yes when prompted
- Once we connect, we should see the Linux interface and we should be able to run commands like ls to view contents of a directory

## Setting up a Simple Web Server
- First, we will install httpd which lets us run a simple web server
  - sudo dnf install -y httpd
- We will configure the contents to display
  - echo "Hello EC2" | sudo tee /var/www/html/index.html
- Start the web server
  sudo systemctl start httpd
- If we paste the address (Public DNS) into our address bar, we should see the message "Hello EC2"
  - Assuming we have HTTP allowed in our Security Group
  - Example: ec2-3-128-27-136.us-east-2.compute.amazonaws.com
  - Might need to change from https to http

## Shut Down EC2
- Go to list of instances
- Ensure the box next to your EC2 is checked
- Click on Instance State -> Terminate