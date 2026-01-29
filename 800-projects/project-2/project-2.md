## Project Title: Social Media Microservices Application
### Project Description: 
Develop a full-stack social media platform using a microservices architecture. The application will support common social features such as user registration and login, creating and viewing posts, commenting/liking, and following other users. The backend will be composed of multiple Spring Boot microservices (each owning its own data and API boundaries) that communicate through well-defined interfaces. The React frontend will provide a responsive UI that aggregates data from multiple services to deliver a cohesive user experience. The system should emphasize scalability, maintainability, and clear separation of concerns across services.

This will be a group project. (1 team of 4 and 1 of 5)

We will present next Friday. 

### Objective / Tools Used: 
Java, Spring, Spring Boot, React, JavaScript, TypeScript

### Requirements
- Design a system using a microservices architecture, including service boundaries and responsibilities
  - Architecture must have at least 2 distinct services (Posts, Profiles, Authentication, Reactions,etc.)
- Build multiple Spring Boot services with clean REST APIs and separation of concerns
- Implement service-to-service communication patterns (e.g., REST calls) and handle failures
- Apply authentication and authorization concepts across a distributed backend
- Develop a React frontend in JavaScript/TypeScript that integrates with multiple backend services
- Model and persist social data (users, posts, likes/comments, follows) with appropriate relationships
- Manage state, routing, and API integration in a TypeScript-based React application
- Use API contracts and shared DTO patterns to keep services aligned during development
- Practice group software engineering workflows (Git branching, code reviews, conflict resolution, task breakdown)

### User Stories

#### Accounts & Identity

1. **User Registration**
   As a new user, I want to register with an email/username and password so that I can create an account.

1. **User Login**
   As a user, I want to log in so that I can access authenticated features.

1. **Logout**
   As a user, I want to log out so that my session is ended on shared devices.

1. **Access Protected Routes**
   As a user, I want protected actions (posting, liking, commenting, following) to require authentication so that only valid users can perform them.

1. **Role/Permission Checks**
   As a system, I want to enforce authorization rules (e.g., only the author can delete their post) so users can’t modify others’ content.

#### Profiles

1. **View Profile**
   As a user, I want to view a user’s profile (bio, join date, stats) so I can learn about them.

1. **Edit My Profile**
   As a user, I want to update my profile details (display name, bio, avatar URL) so my profile reflects me.

1. **Search Users**
   As a user, I want to search users by username/display name so I can find people to follow.


#### Posting

1. **Create Post**
    As a user, I want to create a text post (optionally with an image URL) so I can share updates.

1. **View Single Post**
    As a user, I want to open a post to see its details so I can read it and interact.

1. **View User’s Posts**
    As a user, I want to view all posts by a specific user so I can browse their content.

1. **Home Feed**
    As a user, I want a home feed that shows recent posts from people I follow so I can keep up with updates.

#### Likes/Comments

1. **Like a Post**
    As a user, I want to like a post so I can show appreciation.

1. **Unlike a Post**
    As a user, I want to remove my like so I can change my mind.

1. **Prevent Duplicate Likes**
    As a system, I want to prevent a user from liking the same post twice so counts are accurate.

1. **Add Comment**
    As a user, I want to comment on a post so I can join the discussion.

1. **View Comments**
    As a user, I want to see comments on a post so I can read the conversation.

#### Following

1. **Follow User**
    As a user, I want to follow another user so their posts appear in my feed.

1. **Unfollow User**
    As a user, I want to unfollow someone so their posts stop appearing in my feed.

1. **View Followers / Following Lists**
    As a user, I can view who I am following and who is following me.

1. **Prevent Self-Follow**
    As a system, I want to prevent users from following themselves so relationships stay valid.


### Scrum
- Daily Stand-Ups
  - At the beginning of project time (usually after lunch ends), each team will have their own stand-up meeting
    - Each developer will give their stand-up (what you worked on, what next blockers)
    - Scrum Master will take notes on this
    - The 2 Scrum Masters (one from each time) will meet with Rory and convey their team's information

### Roles
- Scrum Master - in charge of daily stand-ups and any other Scrum meetings like sprint planning
- Git Leader - responsible for managing branches, PRs
- Styling Leader - making styling decisions, making the app more cohesive

### What to do Now
- Before learning about Microservices, we can still
  - Appoint Roles
  - Planning
    - Entity structure (what fields/columns are going to into our entities)
      - Data Types, etc.
    - Front-End
      - Plan out project structure, folders, components
      - Can even begin working on front-end code and use placeholder data whenever we need to make an axios call
    - Back-End - Can start to think about how to split up the services
      - Recommend to not go too in-depth before we start Microservices
- Re-read and understand the project document

### Misc
- When working, you want to make sure you work on back-end and front-end
  - Feature-based approach
    - One person takes on feature
    - One/Two people takes on service
- Pick a distinct them (Hogwarts social media site, Star Wars, Sports, etc.)
  - Can use https://coolors.co/?home for picking color palettes


### Presentation
- Everyone has to speak at least once, can talk about the services/features you worked on
- What to Include
  - Technologies Used
  - Overview of user stories and stretch goals
  - Overview of Challenges Faced
  - Learning Outcomes
  
### How many Services
- Minimum: 2
- The more we have the more realistic the design becomes but it will increase the complexity of the project
- Either way, can talk about the decision made in the presentation