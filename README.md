# Api Handler Volley

## Introduction:

This project is created in the intention to understand the Api hanlders for android using volley library and make it as readily usable component to integrate it with any projects.

## Installation:

Step 1: Add the volley library dependency to the app build.gradle

       implementation 'com.android.volley:volley:1.1.1'

Step 2: Add the internet permission in the AndroidManifest.xml file.

       <uses-permission android:name="android.permission.INTERNET"/>

Step 3: If you are using http protocal for api's, then add the below configuration in the android studio project.

   
       Step 3.1: Add the below configuration inside the application tag in AndroidManifest.xml file.

            android:networkSecurityConfig="@xml/network_security_config"
            android:usesCleartextTraffic="true"

   
       Step 3.2:  Add the below content inside network_security_config.xml file and put it inside a res/xml path.

            <?xml version="1.0" encoding="utf-8"?>
            <network-security-config>
                <base-config cleartextTrafficPermitted="true">
                    <trust-anchors>
                        <certificates src="system" />
                    </trust-anchors>
                </base-config>
            </network-security-config>

## Handler Part:

A static or companion object is implemented to invoke without object instantiation.

**(1) Get**

    getAyncNetworkCall - to get data from server through get api call.

**(2) Post**

    postAsyncNetworkCall - to post data to server through post api call.


## Usage / Example:

Sample get and post call is given as regions where you can try/implement by invoking each function and seeing it in Console.

## Issues
1. Constant's no need to be in Seperate File
2. How about http & https , the handler will work for fine ? 
3. How about JSON Parse , String Parse for Request & Response