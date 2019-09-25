XML Rss Feed CDUD application

Prerequisites

Linux/Unix system*

Git
JDK 8 (tested with openjdk version "1.8.0_222")
Maven (tested with Apache Maven 3.6.2)
Docker (tested with 18.09.7, build 2d0083d)

Clone the repository:
git clone git://github.com/AleksandrMaskalenko/RssFeed.git


Build project:
mvn clean package


For environment setup run script:
./setup_env.sh
(be sure if this script executable, if not, run command - sudo chmod +x ./setup_env.sh)  )

Test in the browser
http://localhost:8080/FeedsRss_war/feeds