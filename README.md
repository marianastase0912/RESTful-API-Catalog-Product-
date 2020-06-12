# RESTful-API-Catalog-Product-

		A RESTful API created using Maven and Spring that exposes an endpoint  manage a catalog product.
	The configurations that you need to use this API are the following:
 		-access http://localhost:8082/authenticate to login with the credentials for the only user I added
 	(for simplicity) and generate the token needed to access any data
	 JSON:
	{
		"username": "name",
		"password": "pass"
	}
 		-access http://localhost:8082/catalog, using the token generated earlier in the Authorization header
 	(with Bearer method), to access the list of products
 		-access http://localhost:8082/catalog/id in a similar way to access an item by its id
 
		For testing I used Postman.

		I set the session to expire after 10hours.

		The token generated has its secretKey saved in application.properties.

		For the rate limit based on number of requests in a certain time period I used RateLimiter from
	Throttling in Java.
	
		For security I used a JWT authentication with these libraries: 
	o.jsonwebtoken jwt
	avax.xml.bind jaxb-api
	Dependencies: 
	For security:
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>
		
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		
	For configuration and test:
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
	For the rate limit:
	
		<dependency>
		    <groupId>com.google.guava</groupId>
		    <artifactId>guava</artifactId>
		    <version>27.1-jre</version>
		</dependency>
	</dependencies>
