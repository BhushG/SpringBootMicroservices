package com.security.springboot.jwt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  JWT: JSON Web Tokens
 *  It is used to do web authentication
 *  HTTP is stateless protocol. You just tell HTTP server what you want and HTTP server sends response.
 *  When along with what you want, you want send who you are, you can use JWT tokens
 *  session tokens -> reference tokens
 *  JWT -> value tokens
 *  JWT is not for authentication, it is for authorization. JWT comes in picture when authentication is complete
 *  Client passes JWT token as part of header Authorization: Bearer Token
 *  As json message payload is Bse64 encoded, we don't want to store confidential information in JWT token
 *  Anyone having JWT token will be authorized. So someone if steals JWT token, he will be authorized.
 *  JWT working: https://www.youtube.com/watch?v=_XbXkVdoG_0&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=11
 *
 *  JWT Authorization Implementation:
 *      i) create new Authentication API endpoint -> using AuthenticationManager
 *      ii) examine every request for a valid JWT and authorize. -> using filters
 *
 *  we need to add following dependency in the project to use JWT
 * <dependency>
 * 			<groupId>io.jsonwebtoken</groupId>
 * 			<artifactId>jjwt</artifactId>
 * 			<version>0.9.1</version>
 * 	</dependency>
 *
 */
@SpringBootApplication
public class SpringBootJWTSecurity
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootJWTSecurity.class, args);
    }
}
