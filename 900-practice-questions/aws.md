### Cloud / AWS Overview
* How would you describe AWS? What is "the cloud" or "cloud computing" and why is it so popular now?
  * AWS is leading cloud platform
  * Provides resources and services
  * Business benefits: no need to manage infrastructure; useful tooling; worldwide distribution/deployment
  * Downsides: locked into cloud provider
* Define Infrastructure, Platform, and Software as a Service
  * IaaS: direct access to hardware; most control
  * PaaS: hardware abstracted; developer provides the software to run
  * SaaS: software abstracted
* What's the difference between a Region and an Availability Zone (AZ)?
  * Regions cover a geographic area, all over the world
  * AZs are individual data centers; 3 AZs per region for redundancy and fault tolerance
* How are you charged for using AWS services? Does it vary by service?
  * By uptime, data stored, data exchanged
* Different ways to interact with AWS services?
  * Web console
  * AWS CLI / REST API
  * AWS SDK

### EC2

* What are the configuration options for EC2?
  * AMI
  * EBS
  * Security group
  * Instance size
  * Tagging
* What are the different EC2 instance sizes/types?
  * General purpose
  * Compute optimized (more CPU)
  * Memory optimized (more RAM)
  * Storage optimized (more I/O)
  * Sizes: nano, micro, small, medium, large, xlarge
* Once you create an EC2, how to connect to it?
  * Need `.pem` key and IP / domain; connect over `ssh`
* What are Security Groups? When defining a rule for a security group, what 3 things do you need to specify?
  * Control access to a particular resource
  * IP address (or range), port, protocol
* What's the difference between scalability, elasticity, and resiliency?
  * Scalability is a characteristic of cloud computing through which increasing workload can be handled by increasing in proportion the amount of resource capacity. It allows the architecture to provide on demand resources if the requirement is being raised by the traffic.
  * Elasticity is the concept of commissioning and decommissioning of large amount of resource capacity dynamically. It is measured by the speed by which the resources are coming on demand and the usage of the resources.
  * Resiliency refers to the ability to recover from a disaster or outage
* What is autoscaling?
  * Autoscaling is a feature of AWS which allows you to configure and automatically provision and spinup new instances without the need for your intervention. You do this by setting thresholds and metrics to monitor. When those thresholds are crossed a new instance of your choosing will be spun up, configured, and rolled into the load balancer pool. You can scaled horizontally without any operator intervention.
* Ways of paying for EC2?
  * On-demand: pay by the hour
  * Provisioned: if you know you will use for particular time, e.g. one year, can get discount
  * Spot: set price level at which to spin up instance; may be interrupted
* What is an AMI? What are the benefits of using one?
* What is EBS?

### RDS

* What's an RDS?
  * Relational database service - a PaaS offering that loads RDBMS software based on your configuration
* Which vendors are supported?
  * Oracle, MySQL, Postgres, Amazon Aurora, MariaDB, SQLServer

### S3

* What kind of data would you store on S3 vs a database?
  * Database: relational data, application-specific, not static assets
  * S3: object storage (files); static assets like images, videos, text documents, etc
  * Example: for an application, store username, password, address, and URL link to profile pic in database; actual profile pic stored in S3
* Are there any limits on S3?
  * Up to max of 5TB for individual file
  * No limits to amount of total storage you can use
* What are the rules for bucket naming?
  * Must be globally unique (no other bucket on AWS has same name)
* What are the different storage tiers?
  * Standard - most expensive
  * IA (infrequently accessed)
  * Glacier (cold storage) - cheapest
* How does security work with S3?
  * Configure access control lists (ACLs)
* Can you use S3 to host a front-end or back-end of an application?
  * Front-end (static site hosting)