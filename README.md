# Preface
This is a sample project to demonstrate my skills in Springboot, Spring MVV, BootStrap, Themeleaf.


# Installation

# Getting from github
1. download and install git for you platform from https://git-scm.com/downloads
2. Get project repository using following command

git clone https://github.com/sahlolbey/account


# Download and install JDK 1.8+ for your platform
1. Download the JDK 1.8+ binary for you platform from 
	https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html	
2. Use installation instruction for JDK from follwing address to install and configure JDK for you environment.
https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

# Download and install MySQL 
1. Download and install MySQL database community 5.6+ edition from 
https://dev.mysql.com/downloads/mysql/

# Maven
1.Download Apache Maven 3.6.1 from https://maven.apache.org/download.cgi
2.Use Maven Installation guide for your platform from https://maven.apache.org/install.html to install maven on your machine.

# Create Database
1. You should remember your mysql db root password then change your directory to project directory at command prompt.
2  Run the following command from command prompt.The system asks for MySql root password and you should enter it to run the command.

mysql -u root -p <src/main/sql-scripts/create.sql

# Build the application
1. Change current directory in command prompt to project directory.
2. Run the following command from command prompt.

	mvn package

3. If you get the "build successfull" message at the end of the above command execution then you can go to "Run the application" section of this file.

# Run the application
1- Change current directory in command prompt to project directory.
2- Type and execute the following command from command prompt.

	java -jar target\account-0.0.1-SNAPSHOT.jar
	
# Using the application
1- Run Browser of your choice and browse to http://localhost:8080
2- You will see a login page. You can use the follwing username and password to login to the system.	

user:ing1
password:1ing
-----------
user:ing2
password:2ing

3- When you sign in to the system you will see that the UI is simple and self descriptive.
4- The database tables of the system drops and recreate each time you restart the system. This is just for simplicity of testing the system.
