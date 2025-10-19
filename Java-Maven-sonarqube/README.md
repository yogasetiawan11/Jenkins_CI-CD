# Image of this Project

<img width="985" height="537" alt="Image" src="https://github.com/user-attachments/assets/88972e42-816b-4288-b56d-99989266e2cd" />


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

open up the terminal then run one by one:
```bash
sudo apt install unzip  
adduser sonarqube
su - sonarqube
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-10.4.1.88267.zip
unzip *
cd sonarqube-10.4.1.88267/ #(file that you've been unzip)
chmod -R 775 /home/sonarqube/sonarqube-10.4.1.88267
chown -R sonarqube:sonarqube /home/sonarqube/sonarqube-10.4.1.88267
cd /home/sonarqube/sonarqube-10.4.1.88267/bin/linux-x86-64  # Choose your vm architecture
./sonar.sh start
```

If you've had yet unzip, you need back to root user to install unzip then go back to sonar user

# Connect sonarqube with jenkins
Go to sonarqube UI
```bash
- Open sonarqube 
- Click on security
- Generate token
```

Once you get the tokens, copy it and go to jenkins
```bash
- Go to jenkins
- Install sonar plugin
- Click manage credential
- Click system
- Click global credential
- Click Add credential
- then choose the credential as "secret text" 
```


After that you can use this sonar on the Pipeline

# Docker Slave Configuration
Run the command bellow to install docker:
```bash
sudo apt update 
sudo apt install docker.io
```

Grant the Jenkins and Ubuntu user to access the docker daemon 
```bash
sudo su -
usermod -aG docker jenkins
usermod -aG docker ubuntu  
systemctl restart docker
```

