# SpringBootOAuth2Google

One of the key features in Spring Security 5 is support for writing applications that integrate with services that are secured with OAuth 2. This includes the ability to sign into an application by way of an external service such as Google or GitHub.

# Enabling OAuth 2 login
Suppose that you want to enable users of your application to be able to sign in with google. With Spring Security 5, it couldn’t be any easier. All you need to do is add Spring Security’s OAuth 2 client support to your project’s build and then configure your application’s google credentials.

First, add the Spring Security OAuth 2 client library to your Spring Boot project’s build, along with the Spring Security starter dependency:

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-oauth2-client</artifactId>
</dependency>

# Obtaining Client Credentials
To obtain client credentials for Google OAuth2 authentication, head on over to the Google API Console – section “Credentials”.

Here we'll create credentials of type “OAuth2 Client ID” for our web application. This results in Google setting up a client id and secret for us.

We also have to configure an authorized redirect URI in the Google Console, which is the path that users will be redirected to after they successfully login with Google.

By default, Spring Boot configures this redirect URI as /login/oauth2/code/{registrationId}. Therefore, for Google we'll add the URI:

http://localhost:8081/login/oauth2/code/google
