## HTTP

Hyper-text transfer protocol

protocol - a set of rules for communication

Originally designed for the transfer of HTML documents via the internet.

### Structure

To use the http protocol we need to create an http request and recieve the http response

#### http request

Consists of a head and a body.
The head contains meta-data such as what URI we're sending the request to, what kind of request it is, and any headers we included.
The body contains the actual subject of the request, usually the data we're adding to the server.

#### http response

consists of a head and a body.
head contains the status code and other information
body contains the response usually in the form of an html document but sometimes it is data.

### Http Methods


GET - returns a representation of that resource
POST - creates an entity inside of that resource
PUT - replaces that resource or creates it if doesn't exist
DELETE - removes the specific resource
PATCH - update the resource with the parts included in the PATCH

Define how we transfer information and what the reciever is supposed to do with it.

*Idempotent* - An operation that has the same result no matter how many times you do it.

```Java
// assignment operation is idempotent
int i = 5;
i = 5;
i = 5;
i = 5;

// adding to an arrayList is not idempotent
List<Integer> i = new ArrayList<>();
i.add(5);
i.add(5);
i.add(5);
```

(I) = Idempotent, (N) = Not Idempotent

* GET - (I) - Retreives data from the server, no information in Body of request
* POST - (N) - Creates or appends information to a collection or resource. We do not know the final destination of the new resource (If I add a new restaurant, I do not know what ID the database will give it)
* PUT - (I) - Replaces information on the server at the location specified.
* DELETE - (I) - Removes data from a specific location
---
* PATCH - Update/replace part of a resource
* CONNECT - Try to establish a connection
* TRACE
* OPTIONS - Attempt to establish which methods are allowed on a specific resource
* HEAD - (I) Retrieves just the header information from the server.

### Status Codes - THE SERVER SPEAKS

#### 100 - Informational - I'm doing something

* 100 - Continue - I've received part of your request, continue with the next part.

#### 200 - Success - I did it.

* 200 - Ok - Nothing went wrong.
* 201 - Created - You asked me to make something and I did.
* 204 - No Content - I did what you asked and have nothing to show for it.

#### 300 - Redirect - What you asked for is somewhere else

* 301 - Moved Permanently - I'm sending you there, please go there in the future instead of here.

#### 400 - Client Error - YOU did something wrong

* 400 - Bad Request - You sent me a request and I don't understand it.
* 401 - Unauthorized - You are not authenticated.
* 403 - Forbidden - You do not have access to this document.
* 404 - Page Not Found - There is nothing at that URI.
* 405 - Method Not Allowed - You sent a PUT, I don't allow PUTs on that resource.
* 409 - Conflict - This request would invalidate the state of the server. (usually, you tried to add something that already exists)
* 418* - I am a Teapot - You asked me to make a coffee, but I'm a teapot.
* 451* - Unavailable for Legal Reasons - Fahrenheit 451 (about government censorship). The title is suppposed to be the temperature at which books ignite. Content was taken down because the goverment requested it be removed. Usually used for copyright claims.

#### 500 - Server Error - I did something wrong

* 500 - Internal Server Error - Usually the code entered an error state. Threw an exception in Java.
* 503 - Service Unavailable - The server went down temporarily

## Richardson Maturity Model [Fowler](https://martinfowler.com/articles/richardsonMaturityModel.html)

How RESTful is your service? We aren't talking about Constraints, we're talking about the design of the service itself. How did you design your endpoints and how you interact with them. **Note, that the Richardson Maturity Model does not define a REST web service, it merely provides a way to discuss them.**

Constraints we aren't thinking about: Statelessness, Code on Demand, Layered System, Cacheability

* Level 0: Not RESTful at all - Utilizing Http at all. We are just using http as a transport protocol, but nothing else is defined.

We have an endpoint and we can send requests to that endpoint telling the service what to do.
Note, all requests use the same endpoint.

* Level 1: a little RESTful - Introduces Resources

Each resource has it's own endpoint that we can send requests to in order to accomplish tasks.

* Level 2: sorta RESTful - Introduce Http Verbs

We determine *what* we are doing with each request by examing the http verb used to make it.

* Level 3: Probably RESTful - HATEOAS

Once we are representing other resources within our resource in a way that allows our client to obtain that resource... once we're self-documenting, that's when we make it.

