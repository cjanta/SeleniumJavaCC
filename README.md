# SeleniumJavaCC
automated website access

## Dependencies
JRE System Library [JavaSE-17]

# SeleniumJavaCC_ARGS.jar
window: make a reference (Verknüpfung) and attach to target path following args separated by a whitespace character:

1. yourUsername - no containing whitespaces
2. yourpassword - no containing whitespaces
3. driver [optional]: default firefox - firefox | chrome

Example:
..\SeleniumJavaCC_ARGS.jar Max123 ztropyx85 chrome


Credentials will be disposed after each run.

## Referenced Libs
included - udjust classpath accordingly
\lib\selenium-java-4.24.0

or

https://www.selenium.dev/downloads/


# Java with VS Code Hints

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
