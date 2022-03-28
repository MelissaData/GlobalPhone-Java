@echo off
rd .\target /s /q
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\globalphone\*.java .\src\main\java\com\melissadata\globalphone\model\*.java .\src\main\java\com\melissadata\globalphone\view\*.java
xcopy src\main\resources\ target\ /s /q
xcopy lib\ target\lib\ /s /q