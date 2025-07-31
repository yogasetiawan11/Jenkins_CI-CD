# How to Install Java and Jenkins on Ubuntu
Jenkins is a popular open-source automation server used for continuous integration and continuous delivery (CI/CD). Before installing Jenkins, you need to have Java installed on your system. Below are the steps to install Java and Jenkins on Ubuntu.

1. Update Your System
Open your terminal and update your package index:
```bash
sudo apt update
```

3. Install Java (OpenJDK 17)
Jenkins requires Java to run. Install OpenJDK 17 with:
```bash
sudo apt install openjdk-17-jre -y
```

Verify the installation:

3. Add Jenkins Repository and Key
```bash
java -version
```

5. Because I'm using WSL (Ubuntu) 
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
```bash
dpkg -l | grep jenkins
```

7. Start Jenkins and enable it to run 
```bash
sudo systemctl start jenkins
sudo systemctl status jenkins
```

7. By default, Jenkins runs on port 8080. Open your browser and go to:
```bash
http://localhost:8080
```

<img width="987" height="596" alt="Image" src="https://github.com/user-attachments/assets/fb100856-b391-4271-920c-5d978077b381" />

then paste this command in VM ```sudo cat /var/lib/jenkins/secrets/initialAdminPassword```, Copy the output and paste into Jenkins 

## "Click Install sugest Plugin"

## wait untill finish
<img width="1008" height="638" alt="Image" src="https://github.com/user-attachments/assets/af0b5fec-7246-41d7-923b-8156043accf1" />

## Enter Your name, Password etc.
<img width="829" height="633" alt="Image" src="https://github.com/user-attachments/assets/83ae785e-05ff-406f-bcbf-9a0ee146cd04" />

## And finally you have succed to instaling jenkins
<img width="1352" height="639" alt="Image" src="https://github.com/user-attachments/assets/1e443ab6-383f-4e34-9c29-5ee4a44956af" />

## Install Docker pipeline plugin in Jenkins:
- Log in to Jenkins.
- Go to manage and search for ``Docker pipeline``
- Select and Install
- Restart Jenkins after plugin has installed.
<img width="1366" height="591" alt="Image" src="https://github.com/user-attachments/assets/249a4bd8-b37a-4527-8af9-6f81fc94d574" />

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
And your docker agent configuration is now successful.