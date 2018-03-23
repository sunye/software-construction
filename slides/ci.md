# Continuous Integration

----

## Plan

- Introduction<!-- .element: class="fragment highlight-blue" -->
- Control Version Systems
- Test Automatization
- Build Automation
- Feedback Mechanisms
- Continuous Deployment
- Conclusion

----

## Introduction

----

## Continuous Integration

« Continuous Integration is a software development practice where members of a team integrate their work frequently, usually each person integrates at least daily - leading to multiple integrations per day.
Each integration is verified by an automated build (including test) to detect integration errors as quickly as possible.» [Fowler]

----

## In other words...

- Software integration is often perceived as a complex and annoying task.
- Continuous integration simplifies this task, making it part of developers daily work.

----

## A simple technique

- A simple yet powerful technique allowing software development teams to:
  - keep team members in harmony.
  - reduce potential drift hazard.
  - limit complexity

----

- Regular build and test of the latest version of the software under development.
- Local testing and propagation to a single storage location of each developer's work.

----

## Motivation (1/3)

- Time saving:
  - no more repetitive tasks.
  - reduced need for documentation.
  - better integration of newcomers, which can analyze and use build scripts directly.
- Developers' confidence improvement:
  - Independent from the momentary/punctual efficiency of the developers.
  - Use of reproducible procedures.

----

## Motivation (2/3)

- Risk reduction:
  - errors are detected and fixed very early.
  - software quality this measurable over time.
  - reduction of assumptions.
- Manual task reduction:
  - the build process is invariable:  it follows the same sequence of tasks.
  - the process runs automatically after each change/commit.


----

## Motivation (3/3)

- Availability of ready-to-use software at any time and place.
- Project visibility improvement:
  - effective decisions.
  - observable evolutions.
- Establish greater confidence in the software product from the development team

note:
One of the most significant problems in software development is assuming
CI help to mitigate
- Lack of cohesive, deployable software
- Lack defect discovery
- Low-quality software
- Lack of project visibility
This facilitates
The reduction of labor on repetitive process
The capability to overcome resistance to implement improvements by using auto mated mechanisms for important processes


----

## Continuous Integration Components

- Control Version System (Repository)
- CI Server
- Build Scripts
- Feedback Mechanisms
- Integration
- Build Machine

----



![](resources/jpg/ci-components.jpg)


----

## Plan

- Introduction
- Control Version Systems<!-- .element: class="fragment highlight-blue" -->
- Test Automatization
- Build Automation
- Feedback Mechanisms
- Continuous Deployment
- Conclusion

----

## Control Version System

- Unique place of sharing.
- Regression, snapshots, branches, etc.
- Tools: Git, Mercurial, Subversion, etc.

![](resources/jpg/branch-and-merge.jpg)

----

## Plan

- Introduction
- Control Version Systems
- Test Automatization<!-- .element: class="fragment highlight-blue" -->
- Build Automation
- Feedback Mechanisms
- Continuous Deployment
- Conclusion

----

## Test Automatization

- Developers:
  - participate in the creation of the tests
  - validate their code locally.
- Tools: JUnit, Selenium, SonarQube, PMD, FindBugs, etc.

![](resources/png/junit.png)
![](resources/jpg/selenium.jpg)

----

## Unit Test Automatization

- Unit test verify the behavior of small elements in software system
- Mocks are simple object that substitute for real, more complicated object
- The key aspect for unit test is having no reliance on outside dependecies

----

## Integration Test Automatization

- Component or subsystem test verify portions of a system and may require a full installed system or same external dependencies
- Component level test use more dependencies than unit test but still not necessarily as many as high level system tests

----

## System Test Automatization

- System test exercise a complete software system and therefore require a full installed system
- System test are fundamentally different form functional test, system test much like a client would use the system
- Automate Functional tests
- Functional tests test the functionality of an application from the view point of a client, known as acceptance tests

----

## Continuous Test Evaluation

- Assess Code Coverage:
  - Line coverage, statement coverage, indicates that a particular line of code was exercised
  - Branch coverage measure the coverage of decision points
  - Test run slower than they do in no coverage scenarios; It may be appropriate to run code coverage tools as part of a secondary, more heavyweight build

----

## Continuous Inspection

- Code Review can be impressively effective; however, they are run by humans, who tend to be emotional
- Pair Programming has also been shown to be effective when applied correctly
- Automated static code analysis scales more efficiently than humans for large code bases
- What is the different between inspection and testing
- Testing is dynamic and executes the software in order to test the functionality
- Inspection analyze the code based on a set of predefined rules
- Example of inspection targets include coding “grammar” standards, architectural layering adherence, code duplication, and so on

----

## Plan

- Introduction
- Control Version Systems
- Test Automatization
- Build Automation<!-- .element: class="fragment highlight-blue" -->
- Feedback Mechanisms
- Continuous Deployment
- Conclusion

----

## Build Automatization

- Non-trivial Software is build using build management tools.
- The goal of a build management tool is to fully automate all steps required to build the product given the source artifacts of the project.
- The result of the build should always be the same - independently of the developer’s local configuration.
  - Builds must be stable.
- The build management tool is responsible for automatically carrying out all steps necessary to build the product.

----

## Build Automatization Tools

- Client tools: scripts to compile, assemble, generate, deploy, etc. 
- Schedulers: automation scripts in the server side (e.g. crontab).
- Examples: Ant, NAnt, Maven, Gradle, Rake, etc.

----

## Build Tools Functionalities

- A Build Automation typically executes the following tasks:
  - Source Code Formatting
  - Code generation
  - Code compilation
  - Component packaging
  - Program execution
  - File manipulation

----

- Extended taks: 
  - Development test execution
  - Version control tool integration
  - Generating and publishing documentation, release notes, web pages, etc.
  - Deployment to the test system/production system(s)
  - Code quality analysis
  - Extensibility
  - Multiplatform builds
  - Accelerated builds

----

## Build Schedulers Functionalities

- Essential:
  - Build execution
  - Version control integration
  - Build tool integration
  - Feedback
  - Build labeling
- Extended: 
  - Inter-project dependencies
  - User interface
  - Artifact publication
  - Security

----

## Build Types and Mechanisms

- Types: 
  - Private Build
  - Integration Build
  - Commit build
  - Secondary build
  - Release Build
- Mechanisms:
  - On demand (e.g., by a developer)
  - Scheduled by a build server (e.g., every night)
  - Poll for changes
  - Event-driven (e.g., on every commit to a version control system)


----

## Plan

- Introduction
- Control Version Systems
- Test Automatization
- Build Automation
- Feedback Mechanisms<!-- .element: class="fragment highlight-blue" -->
- Continuous Deployment
- Conclusion

----

## Feedback Mechanisms

- Send the right information to the right people at the right time and in the right way: 
  - Email
  - SMS
  - Windows taskbar monitor
  - Sounds
  - Collaboration tools: IRC, RSS, Slack, Mattermost, Fleep, etc.

----

## Typical Deployment

![](resources/png/deployment.png)

----

## Active Operation

- Developers propagate their changes.
- The integration server monitors the control version system.

----

## Continuous Integration Tools

- Hudson, Jenkins.
- CruiseControl / CruiseControl.NET.
- Apache Continuum.
- PMEase QuickBuild (open-source: LuntBuild).
- And several others AnthillPro, Bamboo, BuildForge, Continuous Integration Server Matrix, Draco.NET, Gauntlet, ParaBuild, etc.

----

## Plan

- Introduction
- Control Version Systems
- Test Automatization
- Build Automation
- Feedback Mechanisms
- Continuous Deployment<!-- .element: class="fragment highlight-blue" -->
- Conclusion

----

## Continuous Deployment

- Release working software any time, any place
- Label a repository’s assets
- Produce a clean environment
- Label each build
- Run all tests
- Create build feedback reports
- Possess capability to roll back release

----

## Plan

- Introduction
- Control Version Systems
- Test Automatization
- Build Automation
- Feedback Mechanisms
- Continuous Deployment
- Conclusion<!-- .element: class="fragment highlight-blue" -->

----

## Practices of Continuous Integration
### According to Martin Fowler

- Maintain a Single Source Repository.
- Automate the Build
- Make Your Build Self-Testing
- Everyone Commits To the Mainline Every Day
- Every Commit Should Build the Mainline on an Integration Machine
- Fix Broken Builds Immediately

----

- Keep the Build Fast
- Test in a Clone of the Production Environment
- Make it Easy for Anyone to Get the Latest Executable
- Everyone can see what's happening
- Automate Deployment


----

## Conclusion

- Continuous Integration essential aspects:
  - Version control
  - Automatic and fast build
  - Code quality
  - Information share

----
## References

- http://martinfowler.com/articles/continuousIntegration.html
- «Continuous Delivery: Reliable Software Releases through Build, Test, and Deployment Automation». Jez Humble and David Farley.

----


