# Apache Maven

----

## Foreword

«Maven was born of the practical desire to make several projects at the Apache Software Foundation(ASF) work in the same, predictable way. 

Before, every project at the ASF had a different approach to compilation, distribution, and web site generation. Ex. Build process for Tomcat was different from build process used by Struts. Turbine developers used a different approach to site generation than the developers of Jakarta, Commons, etc. (...)»

----

« (...) This lack of common approach to building software meant that every new project tended to copy and paste another project’s build system.

The barrier to entry for a project with a difficult build system was extremely high. Difficult to attract developer because it could take an hour to configure everything in just the right way.»

http://maven.apache.org


----

## Maven is

- A project management framework.
- A build tool.
- A set of standards.
- An artifact repository.
- An standard build life cycle.

----

## Principles

«Convention over configuration»

«Reuse of build logic»

----

## Conventions

- Standard directory layout: sources, resources, config files, generated output, documentation, web site, etc.
- A single Maven project produces a single output.
- Standard naming conventions.

----

## Features

- A comprehensive software project model (POM) and tools that interact with this declarative model.
- Allows developers to declare goals and dependencies and rely on default structure and plugin capabilities.

----

## Benefits

- Coherence: Maven allows organizations to standardize on a set of best practices.
- Reusability (reusing the best practices).

----

## Benefits

- Agility: lowers the barrier to reuse not only of build logic but of components. It is easier to create a component and integrate it to a multi-project build. Easier for developers to jump between projects without the a steep learning curve.
- Maintainability: stop building the build and focus on the application. 

----

## The Project Object Model

```xml
<project>
 <modelVersion>4.0.0</modelVersion>
  <groupId>com.mycompany.app</groupId>
  <artifactId>javaero</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>Javaero</name>
  <url>http://maven.apache.org</url>
  <description></description>
 <dependencies>
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
       <scope>test</scope>
     </dependency>
  </dependencies>
</project>
```

- This pom will allow you to compile, test and generate basic documentation.

----

## Build lifecycle 

- A series of phases where each phase can perform one or more actions, or goals, related to that phase.
- For instance, the compile phase invokes a certain set of goals to compile set of classes.

----

## Build lifecycle

- If you tell Maven to compile, the validate, initialize, generate-sources, process-sources, generate-resources, and compile phases will execute.

----

## Build lifecycle

- Standard build life cycle consists of many phases and these can be thought of as extension points. 
- When you need to add some functionality to the build lifecycle you do so with the plugin. 

----

## Build lifecycle

- Maven Plugins provide reusable build logic that can be slotted into the standard build life cycle. 
- Any time you need to to customize the way your projects builds you either employ the use of an existing plugin or create custom plugin for the task at hand.

----

## Default build lifecycle

![](resources/png/build-lifecycle.png)

----

## Default build lifecycle (simplified)

1. **validate** - validate the project is correct and all necessary information is available
1. **compile** - compile the source code of the project
1. **test** - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
1. **package** - take the compiled code and package it in its distributable format, such as a JAR.

----

1. **integration-test** - process and deploy the package if necessary into an environment where integration tests can be run
1. **verify** - run any checks to verify the package is valid and meets quality criteria
1. **install** - install the package into the local repository, for use as a dependency in other projects locally
1. **deploy** - done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

----

## Dependencies

- A dependency is a reference to a specific artifact that resides in a repository. 
- In order for Maven to attempt to satisfy a dependency, Maven needs to know what the repository to look in as well as the dependency’s coordinates. 
- A dependency is uniquely identified by the following identifiers: groupId, artifactId and version.

----

## Dependencies are declaratives

- In the POM you are not telling Maven where the dependencies physically, you are simply telling Maven what a specific project expects.

----

## Dependencies

- When a dependency is declared, Maven tries to satisfy that dependency by looking in all of the remote repositories that are available, within the context of your project, for artifacts that match the dependency request. 
- If matching artifact is located, it transports it from remote repository to your local for general use.

----

## Dependency Declaration

```xml
<project>
     :
<dependencies>
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>3.8.1</version>
       <scope>test</scope>
     </dependency>
  </dependencies>
 	:
</project>
```

----

## Repositories

- Types of repositories: 
  1. Local: `~/.m2/repository`
	- you must have a local repository in order for Maven to work. 
  2.  Remote

![](resources/jpg/repository.jpg)

----

### General pattern for the repository layout

![](resources/jpg/repository-pattern.jpg)

If the groupId is a fully qualified domain name such as `z.y.x` then you would end up with a directory structure like the following: 

![](resources/jpg/directory-pattern.jpg)

----

## Locating Dependency Artifacts

1. Maven will attempt to find the artifact with `groupId`, `artifactId` and `version` in local repository ->  `~/.m2/repository/…` 
1. If this file is not present, it will be fetched from remote repository.
1. By default, Maven will fetch an artifact from the central Maven repository at https://repo.maven.apache.org/
1. If your project’s POM contains more than one remote repository, Maven will attempt to download an artifact from each repository in the order defined in your POM.
1. Once dependency is satisfied, the artifact is downloaded and installed in your local repository.

----

## Getting Started with Maven 

----

## Preparing to use Maven:

1. Download Maven from http://maven.apache.org and unzip it to your desired installation directory. Ex. C:\maven in Windows, or /usr/local/maven in Linux.
1. Add System variable M2_HOME as well as $M2_HOME/bin directory to your system path.
1. Type the following in a terminal or command prompt: 

    mvn --version

----

1. If you are behind a firewall, create a `<your-home-directory>/.m2/setting.xml` with the following content:

```xml
<settings>
  <proxies>
    <proxy>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.ensinfo.sciences.univ-nantes.prive</host>
      <port>3128</port>
    </proxy>
  </proxies>
</settings>
```

----

1. If there is an active Internal Maven proxy running. create a <your-home-directory>/.m2/setting.xml with the following content:

```xml
<settings>
	<mirrors>
		<mirror>
			<id>maven.mycompany.com</id>
			<name>University's Maven Proxy</name>
			<url><http://maven.mycompany.com/maven3</url>
			<mirrorOf>central</mirrorOf>
		</mirror>
	</mirrors>
</settings>
```

----
## Creating your First Maven Project

- To create the Quick Start Maven project, execute the following:

```sh
mvn archetype:generate -DgroupId=fr.unantes.datatypes 
    -DartifactId=units 
	-DarchetypeArtifactId=maven-archetype-quickstart 
	-DinteractiveMode=false
```

----

- New directory `units` has been created for the new project, and this directory contains your `pom.xml` which looks like the following file:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>fr.unantes.datatypes</groupId>
  <artifactId>units</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>units</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

----

- Directory structure of your project after archetype generation:

![](resources/png/units.png)

----

## Maven Basic Commands

- Compile the project: `mvn compile`
  - The output were placed in target/classes
- Compile rests and sources and run unit tests: `mvn test`
- Compile your test (but not execute them): `mvn test-compile`
- Make a JAR file or the package: `mvn package`
  - take a look at the target directory and you will see the generated JAR file.
- Install the artifact(JAR file) you’ve generated into your local repository so that it can be used by other projects. `<your-home-directory>/.m2/repository `is the default  location: `mvn install`

----

## Test Execution

- Surefire plugin (which executes the test) looks for tests contained in files with a particular naming convention. By default the following tests are included:
  - `**/*Test.java`
  - `**/***/Test*.java`
  - `**/*TestCase.java`

- Conversely, the following tests are excluded:
  - `**/Abstract*Test.java`
  - `**/Abstract*TestCase.java`

- Generate a basic website for the project: `mvn site`
- Clean the project (remove the `target` directory): `mvn clean`

----

- Create descriptor for the projects
  - for IntelliJ IDEA: `mvn idea:idea`
  - for eclipse: `mvn eclipse:eclipse`

----

## Summary

- Maven is a set of standards, a repository, a framework and is a software.
- Maven is more than just downloading another JAR and a set of scripts, it is the adoption of processes that allow you to take your software to the next level. 

----

## References

- http://maven.apache.org
- «Intro to Maven 2.0».  Powerpoint presentation. Available at http://javaero.org
	


