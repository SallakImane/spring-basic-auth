# Spring basic Authentification

Example project using : Spring Boot + Spring MVC + Role Based Spring Security + JPA + MySQL.

# Getting Started

Before moving to secure actual projects, let's discuss spring boot provided autoconfiguration of spring security for a quick start.

## Part One : Spring Security with its autoconfiguration features 

Adding the Spring Security Starter (spring-boot-starter-security) to a Spring Boot application will:

+ Enable HTTP basic security.

+ Register the `AuthenticationManager` bean with an in-memory store and a single user.

+ Ignore paths for commonly used static resource locations (such as /css/, /js/, /images/, etc).

+ Enable common low-level features such as XSS, CSRF, caching, et

Add below dependencies to pom.xml file

	<dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-security</artifactId>
	</dependency>

## Part Two : Spring Security (Java Configuration)

### Step 1 : Create Class `CustomUserDetailservice` Implement `UserDetailsService`

Spring Security uses the `UserDetailsService` interface, which contains the `loadUserByUsername(String username)` method to look up `UserDetails` for a given username. The UserDetails interface represents an authenticated user object 

and Spring Security provides an out-of-the box implementation of `org.springframework.security.core.userdetails.User`. 

### Step 2 : Create Class `CustomUserDetail` Implement `UserDetails`

Spring Security uses the `UserDetails` interface, which contains the methods (getUserName()/getPassword()....) for allows to represent a user.


### Step 3 : Customized Spring Security Configuration Extending `WebSecurityConfigurerAdapter`

Spring Boot implemented the default Spring Security autoconfiguration in `SecurityAutoConfiguration`. To switch the default web application security configuration and provide our own customized security configuration, we can create a

configuration class that extends `WebSecurityConfigurerAdapter` and is annotated with `@EnableWebSecurity`.

# Authors
 + [**Sallak Imane**](https://github.com/SallakImane)