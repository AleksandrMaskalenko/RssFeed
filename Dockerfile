FROM tomcat:8.5
COPY target/FeedsRss-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/feeds.war
EXPOSE 8080
CMD ["catalina.sh", "run"]