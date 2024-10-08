# SeleniumJavaCC
automated website access

## Dependencies
JRE System Library [JavaSE-17]

# seleniumCC.jar
windows: make a reference (Verknüpfung) and attach to target path following args separated by a whitespace character:

1. yourUsername - no containing whitespaces
2. yourpassword - no containing whitespaces
3. driver [optional]: default firefox - firefox | chrome

Examples:
- ..\seleniumCC.jar Max123 ztropyx85 chrome
- ..\seleniumCC.jar Max123 ztropyx85

Credentials will be disposed after each run.

## Referenced Libs
included - udjust classpath accordingly
\lib\selenium-java-4.24.0

or

https://www.selenium.dev/downloads/

## Usage with task-scheduler
TODO: 
- Windows client Aufgabenplaner checklist
- Linux server toll: "cron" https://help.ubuntu.com/community/CronHowto
- Linux Gui f. cron: https://gnome-schedule.sourceforge.net/
- sudo apt-get install gnome-schedule
