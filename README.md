# appiumPOC
This is POC for Appium android

To compile and run all tests, run:

mvn clean test

This contains the source code for running sample Appium tests using JUnit.

In order to run the tests, you will need to install Apache Maven, and Appium (according to the Appium installation instructions.

Setting up the Appium Tool on Windows
Prerequisites: This is a short list of software and hardware required for automating a mobile App testing using Appium:

Your PC should have JDK, Appium Server, Eclipse, Android SDK installed
Apk: Mobile Application to be automated in our Case ContactManager.apk
Testing Device: In this case Moto G
Jars: Java-client jars and Selenium Jars.
USB driver for Testing Device: Phone UDID

Access adb
Steps to Enable Developer Mode/Options on Android Phone or Tablet:

1) Open Settings, Tap on ‘About’ Option, Tap on ‘Software Information’, Tap On ‘More’.

2) Tap on “Build number” 7 times to enable Developer options.

3) Go back to Settings and make sure that “Developer options” is there.

4) Tap on Developer options and turn on USB Debugging option from the menu on the next screen.


In adb terminal type ‘adb devices’
C:\Users\>adb devices
List of devices attached
TA93305G0L      device

Object Spy
Open UIAutomatorViewer and go to the following path

adt-bundle-windows-x86_64-20140702\sdk\tools

Desired Capability:

DesiredCapabilities capability = new DesiredCapabilities();
//OS Name
 capability.setCapability("device","Android");
 capability.setCapability(CapabilityType.BROWSER_NAME, "");
//Mobile OS version. In My case its running on Android 4.2
 capability.setCapability(CapabilityType.VERSION, "4.2");
 capability.setCapability("app", app.getAbsolutePath());
//To Setup the device name
 capability.setCapability("deviceName","Moto G");
 capability.setCapability("platformName","Android");
//set the package name of the app
 capability.setCapability("app-package", "com.example.android.contactmanager-1");
 //set the Launcher activity name of the app
 capability.setCapability("app-activity", ".ContactManager");
//driver object with new Url and Capabilities
 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);


Appium Desktop:
New version of Appium 1.7.2 available in appium desktop to object spy.


Challenges:
New version of WebDriver agent has some issues with tap and click in IPad's and iphones.


Framework:
This Framework is deigned as Maven project , where the pom.xml will download all the dependencies needed for execution in the CI environemnt.

Test data parameterization can be achived in different ways lilke connect to DB or test data input from Excel sheet using Apache POI libraries.

Results and reporting can be done my TestNG or ReportNG framework.



