set projectLocation=D:\luna_java_EE_workspace\TA_epic
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml 