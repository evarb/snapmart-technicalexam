## snapmart-technicalexam

**github repo for my Snapmart Inc Technical Exam.**

### USAGE

1. Using Jenkins on your local machine,
add a New Item

![jenkins_new_item](https://user-images.githubusercontent.com/23231484/93321818-368f1500-f845-11ea-9acc-bca9e1fba776.png)

2. Enter a name and select **Freestyle project** then proceed by clicking **OK**
![jenkins_freestyle](https://user-images.githubusercontent.com/23231484/93322149-94bbf800-f845-11ea-8122-f856b4619fa4.png)

3. On the General tab, click **GitHub project** and input "https://github.com/evarb/snapmart-technicalexam.git" on the Project url field
![jenkins_github_project_url](https://user-images.githubusercontent.com/23231484/93322518-f9775280-f845-11ea-94b4-27965e69e7cd.png)

4. On the Build Environment tab, check **Delete workspace before build starts**
![image](https://user-images.githubusercontent.com/23231484/93322886-6ee32300-f846-11ea-8750-35af0c6c4195.png)

5. On the Build tab, click **Add build step** and select **Execute Windows batch command** and paste the following commands below..
```
git clone https://github.com/evarb/snapmart-technicalexam.git
cd snapmart-technicalexam\SnapmartTechnicalExam
mvn test -Dcucumber.options="--tags @end2endPass"
```
![image](https://user-images.githubusercontent.com/23231484/93323250-f6309680-f846-11ea-909c-e6cb31442d91.png)

6. On the Post-build Actions tab, click **Add post-build action** and select **Archive the artifacts** and paste the following..
`**\cucumber-reports\**`
-this is location of our generated reports 
![image](https://user-images.githubusercontent.com/23231484/93323691-85d64500-f847-11ea-84f3-ad48ca782d05.png)

7. Click **Apply** and **Save**

### BUILD and RUN

1. From the Jenkins Home Page, click the created job
![image](https://user-images.githubusercontent.com/23231484/93324191-24fb3c80-f848-11ea-8e0c-543cf8b4e42e.png)

2. click **Build Now**
3. You can see from the Build History that the job is running, click the running job
![image](https://user-images.githubusercontent.com/23231484/93324354-5b38bc00-f848-11ea-91c9-48ae4f54d7b8.png)

*Console Output (this will display the console logs)*
![image](https://user-images.githubusercontent.com/23231484/93324548-a783fc00-f848-11ea-8bd0-7bb880c74024.png)

*you can download the HTML Report by clicking the Build Artifacts then click **(all files in zip)***
![image](https://user-images.githubusercontent.com/23231484/93325028-44469980-f849-11ea-8fba-30a5e979009f.png)

This is how the generated HTML report looks like
![image](https://user-images.githubusercontent.com/23231484/93325110-5fb1a480-f849-11ea-9b2e-cc22075064c3.png)

### NOTES
- we currently have 2 scenarios
```
@end2endPass
@end2endFail
```
- you can edit the Build Step from the configuration to use the @end2endFail

`mvn test -Dcucumber.options="--tags @end2endFail"`
