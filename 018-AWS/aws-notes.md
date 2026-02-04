## AWS
- Amazon Web Services
  - Offer a variety of different services to perform different actions on the cloud
  - ex: RDS - hosting a database on the cloud, EC2 - having an instance run which can be used for many different purposes, S3 - used to store unstructured data (images, resources, builds of projects)
- Benefits
  - Pay as you go - because these services are allocated on the cloud, a lot of times we can scale up and down as we need and only pay for what we're using
  - Don't have to guess/predict the capacity because we scale up to meet high demand or scale down during times of less traffic
  - Increased set-up speed
    - Can deploy a back-end application in minutes as opposed to however long it would take to set up your own hardware
  - Don't have to worry about over-head costs for running data centers (power, security, etc.)
  - Economies of Scale - because there are so many users on AWS platform, price is reduced overall
- There are other cloud providers like Microsoft Azure and Google Cloud Platform which contain similar solutions

## IaaS, PaaS, SaaS
- Infrastructure as a Service
  - We have a lot of control
  - The only thing that AWS is managing is the hardware
  - We, as the developers, have control over which type of instance we set up, the application code, the data, the users
  - An example of IaaS is EC2 because we can control which OS is running, configure the environment how we want
- Platform as a Service
  - The environment is already set up for us, we just care about the application and the data
  - RDS is an example of Platform as a Service because we specify which dialect/configuration and AWS handles the rest, gives us a DB instance that we can connect to
- Software as a Service
  - Everything is managed/created by the provider. We are are just responsible for managing users
  - Ex: Microsoft Office
- https://www.redhat.com/rhdc/managed-files/styles/default_800/private/iaas-paas-saas-diagram5.1-1638x1046.png.webp?itok=1I1jAjm0

## AWS Regions and Availability Zones
- AWS operates all over the world, latency would be a big issue if they only had a handful of data centers
- A region is an area of the world (US East, US West, Europe, Asia)
- There are many different AWS regions, allowing us to pick whichever one is closest to us or our customer base
  - AZ - Availability Zone
  - Multiple AZs make up a region
  - AZs are isolated from each other so if one goes down, other AZs can still remain operational
  - Redundancy - storing data in multiple AZs so one failure doesn't result in the loss of all data
  - A single AZ can also contain multiple physical buildings/data centers

## Identity Access Management (IAM)
- This is a service on AWS that lets us manage users, groups, permissions for our AWS account
- Each AWS account has a root user that has permission to do everything
  - Spin up any type of service
  - Delete services
  - Change account settings
  - Manage IAM
- Best Practice to apply the least permissions possible to a given user
  - We don't want to give permissions that they don't need
- Will set up Multi-Factor Authentication so that when we login, we will require a code from our device
  - If someone manages to guess our password, they still wouldn't be able to get into our account without the code from the device
- When you first register on AWS, one of the steps is registering some debit/credit card
  - We will include explicit instructions to make sure we're using the free tier of these services

### Set up User
- In IAM, we can create user objects with username/passwords and permissions
- The permissions can be specific (ex: only allow reading of EC2 resources)
  - Can also be more broad like EC2 Full Access
  - If we sign in as that user, we will only have access to whatever services we specified in the permissions
- We can set up MFA for the individual users in addition to the root user

### Add MFA
- First, need to download an authenticator app to your mobile device
  - ex: Google Authenticator, Microsoft
- On AWS, navigate to IAM service
  - For root user, should be able to set up from the dashboard
  - AWS will show a QR code
  - From the app, we can click on "Add" or plus button, choose option to scan QR code
  - Once scanned, the app will add a new entry containing a code to log in to AWS
    - Codes refresh at a set interval
  - On AWS, it will prompt you to enter in 2 codes that are generated from the authenticator app
  - Once these are confirmed, MFA should be set up and you should be prompted when you login for the code

## EC2 - Elastic Compute Cloud
- Elastic - scale up/down to meet demand (make sure we have enough instances to handle high traffic, make sure we shut down instances during times of low traffic so we're not wasting money/resources)
- Compute - a virtual instance on which we can run a wide variety of programs/applications
- Cloud - instance is hosted on the cloud, we can connect to our instance via SSH
- Provides secure, resizable compute capacity in the cloud
- Makes it easier to scale web applications
- Configure CPU, memory, storage, network rules
- Connect to EC2 via SSH. We can also run a web server on our instance and reach those via HTTP
- AMI - Amazon Machine Image - starting template for our EC2, includes some pre-configured properties
- EBS - Elastic Block Store - storage for EC2 instances, we can attach multiple EBS to an EC2 instance

### EC2 Autoscaling
- Automatically scale (add more EC2 instances (horizontal scaling)) to meet demand
- Improves fault tolerance - terminating faulty EC2 instances and spin up new healthy ones
- Increase Availability
  - making sure there is an instance available to handle any given request
- Lower cost during times of low traffic
- Groups - collection of EC2 instances with similar characteristics
  - We maintain a fixed number of instances, even if the instance becomes unhealthy
  - Increase the number of instances during high traffic
  - Decrease when we don't need as many

### Security Groups
- Act as a virtual firewall for EC2 instances
  - Control incoming and out going traffic based on ip address/port
  - 22 SSH
  - 80 HTTP
  - 5432 Postgres
  - Option for selecting our own IP address so we don't make the instance available to the public
  - Ex: we can set up a rule on our EC2 instance to allow traffic on port 80 for HTTP requests
- Stateful
  - If we send some sort of request from the instance, we will be allowed to take in the response regardless of the inbound rules
  - If we receive a request, we should be able to send a response regardless of the outbound rules

## RDS - Relational Database Service
- AWS's service for relational databases
- Pick our dialect, PostgreSQL in our case
- Configure version, storage, backups
- Spin up a database instance
  - Connect to it from DBeaver
  - Could also specify credentials in our application.properties

## S3 - Simple Storage Service
- While RDS stores structured data (rigid tables, schemas), we can use S3 to store unstructured data (html, text, pdfs, videos, images, zip files)
- S3 lets us create buckets which can store objects
- We can control access to individual objects using ACLs (Access Control Lists)
- We can host front-end pages by uploading an html file to our bucket
  - Ensure the html file is public
  - Configure static website settings
- Each item has its own url
  - We can use this to upload profile pictures to the S3 bucket and just use the url to the image in our database
- S3 has different tiers of storage
  - Each has their own pros/cons including cost, time of retrieval
    - For example, if we archive some data, it might cost less but take longer to retrieve if we need it
  - https://www.cloudkeeper.com/cms-assets/s3fs-public/2023-07/diagram%203.png