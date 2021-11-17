# JamLogPapertrail
Centralize the logging of all your Mendix projects in Papertrail.

Easy to implement, this module does not require any change in the Mendix module. Adding the module and configuring the constants is all that is needed.

# Installation
* Import Module
* Make sure AfterStartup is called after startup

# Configuration
After creating an account on https://papertrailapp.com you can add a system. Choose 'something else' in the from drop down.
Then scroll down to the bottom of the page and click on 'I need to specially name my system'. 
Choose 'My system's hostname changes' and give it a name. Press save.

**Set constants:**

* EnableOnLocalhost: Set this constant to false if you do not want to sent log from localhost to the external system.
* PapertrailLogLevel: The level on which the log be logged in Papertrail. The possible values are TRACE, DEBUG, INFO, WARNING, ERROR, CRITICAL, NONE
* PapertrailHost: You can find the host when you edit your system on papertrailapp.com. It is in the configuration section, copy and paste the part before ':' from 'Logs to'. For example: logs5.papertrailapp.com
* PapertrailPort: You can find the port when you edit your system on papertrailapp.com. It is in the configuration section, copy and paste the part after ':' from 'Logs to'. For example: 10402
You can find the log under the menu item 'Event'.
