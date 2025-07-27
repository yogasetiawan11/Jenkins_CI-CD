# What is shared library
shared library is a common repetitive or a common reusable code, such as script or functions that can be used by different jenkins pipeline

Instead of same code again and again in the same pipeline, you can create ``shared library`` and use it in all pipelines that need, this can make your code more organize and easier to maintain.

Example
```bash
        stage('test') {
            steps {
                sh 'node --version'
            }
        }
```
If I want to write the same code all you need to do copy this script and modify depending of your need, to stored this shared library you can create 1 folder called ``var`` in github, gitlab, etc. Inside this folder you store all of your script/shared library.

Think of it like a library of books, Instead of buying the same book over and over again, you can borrow it from the library whenever you need it.

# Advantages
- Standarization of Pipelines
- Reduce duplication of code
- Easy onboarding of new applications, projects or teams
- One place to fix issues with the shared or common code
- Code Maintainence
- Reduce the risk of errors
