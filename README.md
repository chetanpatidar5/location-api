# location-api
Steps to run the application using docker make sure your docker is running in your local machine
Step 1) Download the clone from below git repo 
https://github.com/chetanpatidar5/location-api

step 2) make sure to do mvn install to generate jar in local-go to root path of the application
C:\Users\DELL\Downloads\location-api-master\location-api-master>mvn install

step 3) Unzip the folder and go to root path of the application
 
Ex. C:\Users\DELL\IdeaProjects\IdeaProjects\location-api\location-api
Step 3) type this command to build the image 
Docker build -t location-api.jar .

Step 4) run the docker application
Docker run -p 9090:8080 location-api.jar
 
5)Hit the swagger url 
http://localhost:9090/swagger-ui/index.html


3)How to Run Application Using Docker Compose
if we don’t want to run application without port here are the steps to run the application using docker compose file-
At the root of the project, you will see a docker-compose-server-h2.yml file. To run this docker compose file we need to follow below steps-
Steps to run the application using docker compose-
•	1)Start the docker container or start docker desktop in local machine 
•	2) Place in other folder or use same folder and file  docker-compose-server-h2.yml and run below command 
Command -  docker-compose -f docker-compose-server-h2.yml up -d
 
 


3)Hit the swagger url 
http://localhost:8080/swagger-ui/index.html
