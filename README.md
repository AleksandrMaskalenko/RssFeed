# Introduction #
"RSS Feed Application" - Simple CRUD application base on Spring MVC using Java EE 8 Servlet/JSP and MySQL database. 
 Build a deployable web application resource (WAR) file, and then deploy it inside a Tomcat server running as a Docker container. 


## Important note ##

Before start application build, choose views version, by default set "new.design=true", in property file. 
Before environment setup/startup, please make sure if port 8080 and 3306 not used other applications.

# Requirements #

* Linux/Unix system*
* Maven (tested with version 3.6.2)
* JDK 8 (tested with openjdk version "1.8.0_222")
* Docker (tested with 18.09.7, build 2d0083d)

# Libraries used #

* Spring Framework 4
* Spring MVC
* JSP
* JSTL
* Hibernate
* Maven
* Docker
* MySQL
* Apache Tomcat

# Design patterns used #

* Facade
* DTO
* MVC

# Installation #
## Clone the repository: ##

```
git clone git://github.com/AleksandrMaskalenko/RssFeed.git
```
or just download .zip file and unpack them


## Build project: ##

```
mvn clean package
```


## For environment setup run script and start up: ##

For Linux/Unix:

```
./setup_env.sh
```

Test in the browser by link:
http://localhost:8080/FeedsRss_war/feeds