# Exercising-Netflix-OSS
1. Eureka Server - Eureka Server is a restservice for service discovery/registry , load balancing and manage fail over. contains module server and client.
	it helps all the node to communicate with each other.
	Eureka Server is service discovery for your microservices, where all client applications can register by themselves and other microservices look up the Eureka Server to get independent microservices to get the job complete.
	Eureka Server is also known as Discovery Server and it contains all the information about client microservices running on which IP address and port.
	application properties: - 
		eureka.client.register-with-eureka=false -- should not register this service itself in eureka
		eureka.client.fetch-registry=false -- should not register this service as client in eureka
2. Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port.
	With Netflix Eureka each client can simultaneously act as a server, to replicate its status to a connected peer.
	In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing.
	Its a microservice registered on the central server and it updates and retrieves addresses to/from the central Eureka server.
	application properties: -
		eureka.client.service-url.defaultZone=http://localhost:8761/eureka/ - determines the address where the Eureka Server is running so the client application can register itself in Eureka Server.
	Example : 
	annotation: @EnableEurekaServer
	 application.yml: server.port = 8761
	 eureka.instance.hostname = localhost
	 client.register-with-eureka=false
	 fetch-registry=false
	 
	 client:
	 #1 instance:
	 @EnableEurekaClient
	 application.properties:server.port=8082
	 spring.application.name=student-service
	 eureka.client.service-url.defaultZone= http://localhosr:8761/eureka
	 eureka.instance.instance-id=${spring.application.name}:${random.port}
	 
	 #2 instance;
	 @EnableEurekaClient
	 application.properties;server.port=8085
	 spring.application.name=result-service
	 eureka.client.service-url.defaultZone= http://localhosr:8761/eureka
	 eureka.instance.instance-id=${spring.application.name}:${random.port}
	 
	 To communicate between instance client
	 
	 @Autowired
	 private DiscoveryClient discoveryClient;
	 
	 public Marks getMarks(int id){
	 List<ServiceInstance> instances = discoveryClient.getInstances("results-service");
	 String baseUrl = instances.get(0).getUri().toString();
	 String resultUri  = baseUrl +"/results/"+id;
	 RestTemplate rest = new Restemplate();
	 Map<String,Integer> marks = (Map)rest.getForObject(resultUri,Object.class);
	 return new Marks(marks.get("language"),mark.get("math"));
	 }
3. Ribbon:- 
	3.1 LoadBalancer -  load balancing improves the distribution of workloads across multiple computing resources.
		Load balancing aims to optimize resource use, maximize throughput, minimize response time, and avoid overload of any single resource.
	3.2 . Ribbon primarily provides client-side load balancing algorithms.
	3.3 - Configurable load-balancing rules – Ribbon supports RoundRobinRule, AvailabilityFilteringRule, WeightedResponseTimeRule out of the box and also supports defining custom rules
		  Ribbon API enables us to configure the following components of the load balancer:
		
			Rule – Logic component which specifies the load balancing rule we are using in our application
			Ping – A Component which specifies the mechanism we use to determine the server's availability in real-time
			ServerList – can be dynamic or static. In our case, we are using a static list of servers and hence we are defining them in the application configuration file directly
	Refer - https://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon
			https://o7planning.org/11739/undertanding-load-balancing-in-spring-cloud-with-ribbon-and-example
4. Zuul:- 
	4.1 Zuul is a entry point to a cloud system and server side load balancing. provide authentication for each routed service.
		it manage to routing rules,filters and load balancing across cloud system.
		Zuul acts as the api gateway for all the deployed microservices and it sits as the middle man in between client applications and backend services. 
		4.1.1 Routing rules:- This is the centralized gateway for directing all the requests for the misroservices. Zuul proxy will communicate with Eureka server to get the details (ip address and port) of the relevant microservice for delegating the client request.
							  Example - zuul.routes.student-service.path=/student-api/**
										zuul.routes.student-service.serviceId=STUDENT-SERVICE
								if any path or request comes to /student-api will be redirected to the service registered in service id
		4.1.2 Filters: - Zuul filter can modify the incoming request before landing to target service. Zuul filter can intercept the request and add cross-cutting processing logic.
				Pre-filters – A pre-filter is invoked before the actual request to the target destination occurs with Zuul.
				Post filters – A post filter is invoked after the target service has been invoked and a response is being sent back to the client.
				Route filters – The route filter is used to intercept the call before the target service is invoked. Usually, a route filter is used to determine if some level of dynamic routing needs to take place.
				refer - https://techrocking.com/netflix-zuul-filter-flow/
5. Spring Cloud Gateway:- Zuul is blocking API, Here Api uses as many thread when the incomming request is more to process it.When there is no thread then the request has wait in the queue.
					Spring cloud gateway is the non-blocking api, there is always a thread available to process the request.
					5.1 Route - It consist of ID, destination url,and collection of predicates & collection of filter rules
					5.2 Predicate - to match request such as header , url & header etc.
					5.3 Filter - Using this filter we can modify the request and response as per requirements
					example - 
					spring:
					  cloud:
						gateway:
						  routes:
						  - id: employeeModule
							uri: http://localhost:1000/
							predicates:
							- Path=/employee/**
						  - id: consumerModule
							uri: http://localhost:1001/
							predicates:
							- Path=/consumer/** 
6. Configuration:- 
	Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments.
	spring.cloud.config.uri=http://localhost:8888
	Refer - https://dzone.com/articles/spring-cloud-config-server-programmer-gate
	