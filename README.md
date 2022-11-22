# recruitment-system
Final project for Java Academy 2022

## Starting the application locally

The main Spring Boot application class can be found in the webapp module: `RecruitmentSystemApplication.`.
The application should be started with local profile, by providing the VM argument `-Dspring.profiles.active=local`.

## Deployment details

- Test server can only be accessed from within NTT Data Internal Network. For details, please contact Robert Horvat.
- To create an executable war file, the build should be performed using ci profile: `mvn clean package -Pci`.
- The war file should be uploaded to the server manually from `webapp/target` to `/home/java_academy_download`. 
Once the upload is finished, run the command `sudo /srv/recruitmentSystem/deploy.sh`
- The configuration files for the application are found in `/srv/recruitmentSystem/conf`
- Make sure the embedded tomcat is shut down before starting a new instance!
- To start the embedded tomcat, use the command: `sudo /srv/recruitmentSystem/server_start.sh &`
- To stop the existing instance, use the command: `sudo /srv/recruitmentSystem/server_stop.sh &`
