# iOS Automation using Appium
This repository contains sample scripts for iOS Mobile Automation (using a sample Recipe app) using Appium on MacOSX.

## Why Appium:
1. You don't need to modify it in any way in order to automate it as Appium uses vendor-provided automation frameworks under the hood - 
  * iOS: Apple’s UIAutomation
  * Android 4.2+: Google’s UiAutomator
  * Android 2.3+: Google’s Instrumentation (Instrumentation support is provided by bundling a separate project, Selendroid)
2. You are not locked into a specific language or framework to write and run your tests as the vendor-provided frameworks are wrapped in WebDriver (aka “Selenium WebDriver”) API.
3. There is no need to reinvent the wheel for automation APIs as WebDriver protocol is extended with extra API methods useful for mobile automation.
4. Appium is open source.
To know more about Appium design and concepts, please refer: http://appium.io/slate/en/master/?java#about-appium


## Prerequisites:
1. Mac OS X 10.7 or higher
2. Xcode (>= 4.6.3) and command line tools: 
  * Xcode: https://developer.apple.com/downloads/
  * Command-line tools: xcode-select --install
3. Brew: ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
4. Node.js and Appium:
  * brew install node    # get node.js
  * npm install -g appium     # get appium
  * npm install wd    # get appium client
  * appium-doctor     # check if everything is correctly set
5. Appium.app (for Appium Inspector) - https://bitbucket.org/appium/appium.app/downloads/
6. Any IDE, say Eclipse: http://www.eclipse.org/downloads/

## Executing a Basic Script 
### Create a Sample Project:
1. Launch Eclipse. Click on File -> New -> Other -> Maven project.
2. Select workspace and archetype-quickstart.
3. Provide Group and Artifact ID.
4. Click 'Finish'.
5. Add Appium Java Client Dependency: You can add appium java client dependency (which is a java language binding for writing Appium tests) in pom.xml as -

### Desired Capabilities (for running on Real Device): 
1.  DEVICE_NAME: The kind of mobile device to use (iPhone 6, iPhone 5s etc.)
2.  APP: The absolute local path or remote http URL to a .ipa file.
3.  BUNDLE_ID: Unique bundle identifier for the iOS app you want to run (say- com.smriti.myApp). This capability is not required for if you specify 'APP' capability.
4.  UDID: Unique device identifier of your phone (You can get this from iTunes from device details when you connect your phone)

### Desired Capabilities (for running on Simulator): 
1.  DEVICE_NAME: The kind of mulator to use (iPhone Simulator etc.)
2.  APP: The absolute local path or remote http URL to a .app file.

All other Appium capabilties details can be found here - https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md

### Launch Appium and Run Scripts:
1. Launch Appium Server:  appium &
2. Run your scripts
3. To View any element id : Launch Appium Inspector




