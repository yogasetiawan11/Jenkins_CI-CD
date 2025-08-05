# Execute this application locally
Checkout the repo and move to the Directory
```bash
git clone https://github.com/yogasetiawan11/Jenkins_CI-CD.git
cd Jenkins_CI-CD.git
```

Execute the Maven target to generate Artifacts 
```bash
mvn clean package
```
This maven target stores The artifact to the target Directory, so you can either Execute the artifacts or run with docker container 

! to avoid error in local set up you have to go with Docker way

## Execute locally and require java 11 and access on the http//:localhost:8080
```bash
java -jar target/spring-boot-web.jar
```

## With Docker
Build the docker Image

```bash
docker build -t ci-ci-pipeline:v1
docker run -d -p 8010:8080 -t ci-ci-pipeline:v1
```

You can run on the http://localhost:8010

# Configure Sonar Server locally

## Requirement before install Sonarqube

1. Java 17+ (Oracle JDK, OpenJDK, or AdoptOpenJDK)
2. Hardware Recommendations:
-    Minimum 2 GB RAM
-    2 CPU cores

open up the terminal
```bash
adduser sonarqube
su - sonarqube
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-10.4.1.88267.zip
unzip *
cd sonarqube-10.4.1.88267/ (file that you've been unzip)
chown -R sonarqube:sonarqube /opt/sonarqube
chmod -R 775 /opt/sonarqube
cd /opt/sonarqube/bin/linux-x86-64
./sonar.sh start
```

If you've had yet unzip, you need back to root user to install unzip then go back to sonar user
