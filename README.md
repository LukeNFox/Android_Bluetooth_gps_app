Project Option 1: Bluetooth device survey
This application should run in the background as an Android Service. (See Android Service Sample
application on blackboard)
The aim of this application is to periodically (approx. every 15 minutes) detect the GPS co-ordinates
of the user as well as a list of Bluetooth devices that the device can detect and upload each detected
location plus devices to your own Firebase backend server. The application should use GPS obtained
locations if available, if they are not available then other location sources such as NETWORK sources
should be used.
When the application is opened, a menu with two buttons should be displayed.
The first button should open an activity where detected locations are displayed as pointers on a map.
When a pointer is touched then the application should display the number of Bluetooth devices
detected at that location.
The second button should open an activity where a list of all unique devices detected is shown.
At least 1 day worth of data should be collected by the app and uploaded to the server.