@echo off
echo Creating client JAR file...

REM Clean and build the project
call gradlew clean build

REM Create a directory for the client JAR
mkdir -p client-jar

REM Copy the necessary files to the client-jar directory
copy build\libs\*.jar client-jar\
copy rmi.policy client-jar\

echo Client JAR file created successfully in the client-jar directory.
echo Please distribute the files in the client-jar directory to your clients.
