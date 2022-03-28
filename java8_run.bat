@echo off
cd target
java -classpath "lib\gson-2.8.9.jar;" com.melissadata.globalphone.Main com.melissadata.globalphone.view.GlobalPhoneController com.melissadata.globalphone.view.RootLayoutController com.melissadata.globalphone.model.GlobalPhoneOptions com.melissadata.globalphone.model.GlobalPhoneTransaction
cd ..