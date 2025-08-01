# What is CI/CD
CI stand for continous integration and CD stand for continous delivery.
Continuous Integration is the practice of automatically building and testing code every time a team member commits changes to version control like github. This helps catch bugs early, improves code quality, your code quality is mantained and ensures that the software is always in a deployable state.

Continuous Delivery is the practice of automatically preparing code changes for release to production. Continuous Deployment goes a step further by automatically deploying every change that passes tests to production. Continous Delivery which ensure that your Deployment or Delivery is done 

# Let's Start with CI part


<img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/420d1261-36c0-4162-bc82-5dbce033d282" />


Example with use case, imagine I have Git Repository Developer always store all of code in Repository and there is jenkins or any orchestrator which is responsible for watching ``commit`` or ``pull`` on this Repository. whenever there is a pull request or commit created Jenkins has to be triggered. There are multiple ways how Jenkins can be triggered. one is Jenkin can continously pull to Your Repo, It can configure some build triggered in Jenkins. but The most efficient way is to use ``webhook`` using webhook Your Jenkins will not watch The Repository but Your Repository will send notification to Your Jenkins

## To configure webhook follow this steps:
- Go to Jenkins you can get Your webhook URL
- You can take this URL and put in Github settings
- In Github settings you will have option for webhook where you can spesify which action The webhook has to be triggered

After Jenkins starts triggering the pipeline, you move to the CI part. For example, if you are managing the Jenkins installation and configuring all the plugins, that's fine. But let's say you are not responsible for those things. what you will do is write a Jenkinsfile. Using this file, you define a set of actions (such as building, testing, and deploying your code) that Jenkins will execute automatically as part of your pipeline.

In the build stage, you will define plugins or tools such as Maven, npm, or others, depending on your programming language and project requirements. These tools will help you to build your Application

If you're using docker as an Agent you don't worry about the installation at all and you can skip the Installation or configuration because Docker Images directly Available for these things

## To configure this Plugin 
- Basically you go to Jenkins then go to Configure system and you install maven, npm or tools based on your requirement.

let's say you have built then ``Unittest will be run`` once your Unittest is successful then you can perform ``static code analysis`` If 2 this things has passed you can move to the next step

- units of code are tested in isolation to verify their correctness. The goal is to ensure each unit functions as intended before integrating them into the larger application.
- static code analysis it will verify this app is not expose to any static code

When there's some ERROR you can Configure some alert In Jenkins there is something called as E-mail Plugins, or you can send out notification, or you can send out Slack notification using API, etc.

In the next step you can Integrate it with ``Sonar Qube`` or other Scanning Tools then you can verify what happened In the previous stage like, Scanning your code to look for If there's any Vulnerability inside the code. If there's Vulnerability you can send out Nofitication, If there's no security Vulnerability you can proceed with the creation of Docker Image. 

In this Part you can use Docker agent itself, or you can basically create Docker Plugin, or you can create Shell script using command ``Docker build`` using Docker build you'll get a Docker Image Finally you will send this Docker Image to a Docker Registry/Container Registry, It can be Docker hub, ECR (AWS), Quay.io, etc. 

All of this things is Continous Integration Process (CI)

At the end of CI part You have an Image ready this Image has new tag for sure. Let's say you have an image the version was 1.0.0 (app 1.0.0) so this will be your previous artifact

whereas your artifact will be something like (app 1.0.1) because you're trying to change something then you will push this new version to your Container Registry this will be last stage of your Continous Integration (CI) Once this is Push you can connect it with CD 

# How does your CD get triggered
In this case we're going to talking about Communication between CI that we have discussed and CD and How these 2 things communicate each other 

Traditionally what people were doing they used to Ansible Playbooks or Shell Scrips They include the CD also in the same Pipeline so once the Image is built, It will trigger Ansible Playbooks or Shell Script which will push the Artifacts to Kubernetes or any target platform 

But there is a Problem when use this approach because these Tools isn't designed for contious delivery CD 

For this reason you have to choose tools spesific for CD like: Gitops, ArgoCD, etc 


<img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/40f43acc-48e8-4c68-9ca2-e8d423b6ee10" />


Once the docker is pushed to Docker Registry, we have Kubernetes Cluster Inside this k8s we have deployed 2 Continous Delivery tools:
1. Argo Image Updater (IA)
2. Argo CD
both of these things are Kubernetes Controllers that we have deployed on our Kubernetes Cluster 

What they will do is, First Tools IA (Image updater) It would continously monitor the Image Registry. as soon as an Image is created, It will pick The Image and It will update the Image in another Git Repository that we have, this Git Repo is purely for the Image Manifest which is our Helm chart, or Pod.yaml, or Deploy.yml or whatever you would like to mention. 

as soon as the Git Repository has updated with the Image then the other Kubernetes controller that we have (Argo CD) It takes the new Image and Deploy to Kubernetes cluster

This is how CD process work.