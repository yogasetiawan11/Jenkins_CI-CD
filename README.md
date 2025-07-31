# What is CI/CD
CI stand for continous integration and CD stand for continous delivery.
Continuous Integration is the practice of automatically building and testing code every time a team member commits changes to version control like github. This helps catch bugs early, improves code quality, your code quality is mantained and ensures that the software is always in a deployable state.

Continuous Delivery is the practice of automatically preparing code changes for release to production. Continuous Deployment goes a step further by automatically deploying every change that passes tests to production. Continous Delivery which ensure that your Deployment or Delivery is done 

<img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/f764d699-9933-4c68-97b4-74e968c73a07" />

Example with use case, imagine I have Git Repository Developer always store all of code in Repository and there is jenkins or any orchestrator which is responsible for watching ``commit`` or ``pull`` on this Repository. whenever there is a pull request or commit created Jenkins has to be triggered. There are multiple ways how Jenkins can be triggered. one is Jenkin can continously pull to Your Repo, It can configure some build triggered in Jenkins. but The most efficient way is to use ``webhook`` using webhook Your Jenkins will not watch The Repository but Your Repository will send notification to Your Jenkins

## To configure webhook follow this steps:
- Go to Jenkins you can get Your webhook URL
- You can take this URL and put in Github settings
- In Github settings you will have option for webhook where you can spesify which action The webhook has to be triggered

After Jenkins starts triggering the pipeline, you move to the CI part. For example, if you are managing the Jenkins installation and configuring all the plugins, that's fine. But let's say you are not responsible for those things. what you will do is write a Jenkinsfile. Using this file, you define a set of actions (such as building, testing, and deploying your code) that Jenkins will execute automatically as part of your pipeline.

In the build stage, you will define plugins or tools such as Maven, npm, or others, depending on your programming language and project requirements. These tools help automate tasks like

If you're using docker as an Agent you don't worry about the installation at all and you can skip the Installation because Docker Images directly Available for these things

## To configure this Plugin 
- Basically you go to Jenkins then go to Configure system and you install maven, npm or tools based on your requirement.