# How to Install Java and Jenkins on Ubuntu
Jenkins is a popular open-source automation server used for continuous integration and continuous delivery (CI/CD). Before installing Jenkins, you need to have Java installed on your system. Below are the steps to install Java and Jenkins on Ubuntu.

1. Update Your System
Open your terminal and update your package index:
```sudo apt update```

2. Install Java (OpenJDK 17)
Jenkins requires Java to run. Install OpenJDK 17 with:
```sudo apt install openjdk-17-jre -y```

Verify the installation:

3. Add Jenkins Repository and Key
```java -version```

4. Because I'm using WSL (Ubuntu) 
```bash
curl -fsSL https://pkg.jenkins.io/debian/jenkins.io-2023.key | sudo tee \
  /usr/share/keyrings/jenkins-keyring.asc > /dev/null
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins
```
You can change this depending Your OS. you can check documentation in Jenkins

5. Verify Jenkins Has installed 
```dpkg -l | grep jenkins```

6. Start Jenkins and enable it to run 
```bash
sudo systemctl start jenkins
sudo systemctl status jenkins
```

7. By default, Jenkins runs on port 8080. Open your browser and go to:
```http://localhost:8080```

![This The display if you succes](/c/Users/DESKTOP/OneDrive/Project/Screenshot 2025-07-25 162328.png)

then paste this command in VM ```sudo cat /var/lib/jenkins/secrets/initialAdminPassword```, Copy the output and paste into Jenkins 

## Click Install sugest Plugin

![wait untill finish](c:\Users\DESKTOP\OneDrive\Project\Screenshot 2025-07-25 163147.png)

![Enter your Data](c:\Users\DESKTOP\OneDrive\Project\Screenshot 2025-07-25 163542.png)

![And finally you have succed to instaling jenkins](c:\Users\DESKTOP\OneDrive\Project\Screenshot 2025-07-25 164317.png)

## Install Docker pipeline plugin in Jenkins:
- Log in to Jenkins.
- Go to manage and search for ``Docker pipeline``
- Select and Install
- Restart Jenkins after plugin has installed.

## Docker as agent Configuration

run this command bellow 

```bash 
sudo apt update
sudo apt install docker.io
```

## Grant VM user and Jenkins user permission to the docker daemon

```bash
sudo su -
user -aG docker jenkins
user -aG docker (your name VM users)
systemctl restart docker
```
Then restart Jenkins again 

```bash
http://localhost:8080/restart
```
And your docker agent configuration is now success