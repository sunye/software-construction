

\end{document}
Continuous Integration
Improving Software Quality And Reducing Risk


Build Software Every Change
Build may consist of the compilation, testing, inspection, and deployment.
CI scenario typically go like
Developer commits code to version control repository
CI server detects that changes have occurred in the version control repository, and then executes a build script
CI server generate feedback by e-mailing build results to specified project member
CI server continues to poll for changes in the version control repository



Features of CI
Source Code Compilation
Database Integration
Testing
Inspection
Deployment
Document and Feedback
How could you know you are doing CI correctly?
Are you using a version control repository (or SCM tool)?
Is your project’s build process automated and repeatable? Does it occur entirely without intervention?
Are you writing and running automated test?
Is the execution of your tests a part of your build process?
How do you enforce coding and design standards?
Which of your feedback mechanisms are automated?
Are you using a separate integration machine to build software?







What prevents teams from Using CI?
Increased overhead in maintain the CI system
Too much change
Too many failed builds
Additional hardware/software cost
Developers should be performing these activities


How Do I Get to “Continuous” Integration?
Identify – Identify a process that requires automation
Build – Creating a build script makes the automation repeatable and consistent
Share – By using a version control system
Continuous – Ensure that the automated process is run with every change applied
Is it Continuous Compilation or Continuous Integration?
How much code coverage do you have with your test?
How long does it take to run your builds?
What is your average code complexity?
How much code duplication do you have?
Are you labeling your builds in your version control repository?
Where do you store your deployed software?
How does CI complement other development practices?
Developer testing
Coding standard adherence
Refactoring
Small release
Collective ownership
CI and you
Commit code frequently
Don’t commit broken code
Fix broken builds immediately
Write automated developer tests
All tests and  inspections must pass
Run private builds
Avoid getting broken code
Risk: Lack of Deployable Software
Scenario: “It works on My Machine”
Solution: Use a CI server along with an automated build using tools such as Ant, NAnt, or Rake
Scenario: “Synching with the Database”
Solution: Place all database artifacts in your version control repository
Scenario: “The Missing Click”
Solution: Using script to automate the deployment process
Risk: Late Discovery of Defects
Scenario: Regression Testing
Solution: Using unit test at the business, data, and common layers and run continuously as a port of your CI system
Scenario: Test Coverage
Solution: Running test coverage tool to assess the amount of source code that is actually executed by the tests
Risk: Lack of Project Visibility
Scenario: Did you Get the Memo
Solution: Automated mechanism that sends e-mails to affected parties when a build fails
Scenario: Inability to Visualize software
Solution: Automated code documentation tool

Risk: Low-Quality Software
Scenario: Coding standard adherence
Solution: Using Checkstyle and PMD to report any lines of code that were not meeting the established standards
Scenario: Architectural Adherence
Solution: Using analysis tools  such as JDepend or NDepend
Scenario: Duplicate Code
Solution: Automated inspection tools such as PMD’s CPD or the Simian static analysis tools




Integration build Scalability and Performance
Gather build metric
Analyze build metric
Choose and perform improvements
Reevaluate; repeat if necessary
Continues Database Integration
Automate Database Integration
Use a local database sandbox
Use a version control repository to share database asset
Give developer the capacity to modify database
Make the DBA part of the development team


Reduce Code Complexity
Cyclomatic Complexity Number (CCN) is a plain integer that measure complexity by coding the number of distinct paths through a method
Various studies with this metric over the years have determined that methods with CCN greater than 10 have a higher risk of defects
The most effective way to reduce cyclomatic complexity is to apply the extract method technique
Perform Design Reviews Continuously
Afferent Coupling, Fan In, an object has responsibility to too many other objects (high afferent)
Efferent Coupling, Fan Out, the object isn’t sufficiently independent of other objects (high efferent)
Instability = Efferent Coupling/(Efferent Coupling + Afferent Coupling)
Maintain Organization Standards with Code Audits
Coding standard facilitate a common understanding of a code base among a diverse group of developer
Human code reviews and pair programming can be effective in monitoring coding standards, they do not scale as well as automated tools
Popular code analysis tool for Java platform is PMD
Reduce Duplicate Code using PMD-CPD or Simian










CI Resources
Automated Inspection Resources



CI Resources


Deployment Resources
Capistrano



FeedBack Resources
Ambient Devices
Google Talk
Jabber
X10
Documentation Resources
Doxgen
JavaDoc
NDoc




Evaluating tools


Compatibility with your environment
Does the tools support your current build configuration?
Does the tool require installation of additional software in order to run?
Is the tool written in the same language as your project?
Reliability
Longevity
Usability





