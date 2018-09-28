@echo off
javac -classpath ".\melissadata\globalphone\org.apache.sling.commons.json-2.0.20.jar;" .\melissadata\globalphone\*.java .\melissadata\globalphone\view\*.java ./melissadata\globalphone\model\*.java
java -classpath ".\melissadata\globalphone\org.apache.sling.commons.json-2.0.20.jar;"; melissadata.globalphone.Main melissadata.globalphone.view.GlobalPhoneController melissadata.globalphone.view.GlobalPhoneTransactionController melissadata.globalphone.view.RootLayoutController melissadata.globalphone.model.GlobalPhoneOption
del .\melissadata\globalphone\*.class 
del .\melissadata\globalphone\view\*.class 
del .\melissadata\globalphone\model\*.class