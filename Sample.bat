@echo off
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\globalphone\*.java .\src\main\java\com\melissadata\globalphone\model\*.java .\src\main\java\com\melissadata\globalphone\view\*.java
xcopy src\main\resources\ target\ /s /q
cd target
java -classpath "../lib\gson-2.8.9.jar;" com.melissadata.globalphone.Main com.melissadata.globalphone.view.GlobalPhoneController com.melissadata.globalphone.view.RootLayoutController com.melissadata.globalphone.model.GlobalPhoneOptions com.melissadata.globalphone.model.GlobalPhoneTransaction
cd ..
rd .\target /s /q