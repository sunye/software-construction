# Test-Driven Development

----

## Plan

- Introduction.<!-- .element: class="fragment highlight-blue" -->
- TDD and unit tests
- Strategies.
- Conclusion.

----
## Agile Methods

- Pragmatic development method
  - Rapid feedback on development status
  - Short development cycles
- Adaptation
  - Fast development feedback
  - Regular adjustments
  - Flexible planning
  - Incremental development
  - No heavy prediction whose errors would be found later
- High human implication


----
## Agile Methods

- RAD (Rapid Application Development)
- XP (eXtreme Programming)
- Scrum
- Lean
- Kanban

----
## Traditional development

![](resources/png/developpement-traditionnel.png)

----
## Test-driven development

![](resources/png/tdd-1.png)

----
## Test-driven development

![](resources/png/tdd-2.png)

----
## Test-driven development

![](resources/png/tdd-3.png)


----
## Test-driven development

![](resources/png/tdd-4.png)

----
## Approach

1. Write test cases before the software unit
  - Test cases describe what the unit should do
  - Before writing the code, tests fail
2. Implement the code that makes the test case pass
  - After the implementation, test cases should pass

----
## Development Style

- TDD Mantra : red/green/refactor
  1. Write tests and make them fail
  2. Write code to make tests pass
  3. Refactor
  
note:
    Style, comme KISS (Keep it simple, stupid) ou YAGNI (You Ain't Gonna Need It).


----
## Consequences

- Test cases specify **what** the unit should do, but not **how**.

note:
    Les cas de test spécifient ce que le programme doit faire mais pas comment
    il faut associer TDD à des refactorings fréquentsrevoir la structure du codene pas oublier la conceptionGrande importance du test de non-régression quand on refactore les cas de test qui passaient doivent continuer à passer


----
## Consequences

- First, developers  think about how to use the unit.
- Second, they think about how to implement it.

note:
But in consequence, it leads the developer to ! first think about “how to use”the component (why do we need the component, what’s it for?) ! and only then about “how to implement”. So, it’s a testing technique as well as a design technique ! It results into components that are easy to test. ! It results into components that are easy to enhance and adapt. In the end, there is no code without a test. The developer can tell at any time ! whether everything still works as it should, or ! what exactly does no longer work as it once did.


----
## Consequences

- It is a development approach that results into units that are easy to:
  - Unit test
  - Enhance and adapt
  
note:
So, it’s a testing technique as well as a design technique ! It results into components that are easy to test. ! It results into components that are easy to enhance and adapt. In the end, there is no code without a test. 


----
## Consequences

- Developers know at any time:
  - What works as it should
  - What does no longer work as it once did

note:
The developer can tell at any time ! whether everything still works as it should, or ! what exactly does no longer work as it once did.


----
## Motivations

- Developers never have free time to write tests
- Tests help developers to overcome complexity.
  - Reduces developer's frustration

note:
If you intend to test after you‘ve developed the system, you won‘t have the time for testing. "Write the tests before the code! If things get complicated, you might fear that „the system“doesn‘t work. "Execute the tests and get positive feedback (everything still works) or get pointed to the bit that does not / no longer work. If you‘re overwhelmed by the complexity, you get frustrated. "Start with the simplest thing and proceed in tiny steps! 
    

----
## Plan

- Introduction.
- TDD and unit tests<!-- .element: class="fragment highlight-blue" -->
- Strategies.
- Conclusion.


----
## Development Cycle

- Five steps cycle:
  1. Write a unit test
  1. Make it fail
  1. Write enough code to make it pass
  1. Check that the test passes
  1. Eliminate duplicate code, improve design

note:
vérifier qu'il échoue (car le code qu'il teste n'existe pas), afin de vérifier que le test est valide;
    

----
## Benefits

- Test cases become a support to documentation:
  - They specify the expected behavior
  - They show examples of code usage

note:
The test is the executable specification. ! You start thinking about the goal first, then about the possible implementations. ! You understand the program‘s behavior by looking at the tests. The tests tell you more than just an API description, they show the dynamics, how to use the API. You develop just enough. ! You get to the goal as quick as possible. ! You don‘t develop unnecessary code. ! There is no code without a test. ! There is no test without a user requirement. Once you get one test working, you know it is working now and forever. ! You use the tests as regression tests. The tests give us the courage to refactor. ! You can prove that everything still works after the refactoring by simply executing the tests. It‘s more fun that way, it reduces fear. 
    

----
## Benefits

> YAGNI (You Ain't Gonna Need It).

- Developers only write necessary code
  - They only code when a test fails
- No code without test and no test without a user requirement

note:
YAGNI (You Ain't Gonna Need It).
You develop just enough. ! You get to the goal as quick as possible. ! You don‘t develop unnecessary code. ! There is no code without a test. ! There is no test without a user requirement. Once you get one test working, you know it is working now and forever. ! You use the tests as regression tests. The tests give us the courage to refactor. ! You can prove that everything still works after the refactoring by simply executing the tests. It‘s more fun that way, it reduces fear. 
Pas de code sans test : donc pas de test structurel, pas évident non plus de se servir d’interface de code qui n’existe pas, on a donc des tests fonctionnels à provenance niveau test système.
    

----
## Benefits

- Rapid feedback on code quality
- Short development cycle iterations
- Code is executed straight away


----

## Benefits

- Automatic unit tests are reproducible:
  - They can be used as non-regression tests and after refactoring.
  - They reduce fear on changes

note:
    Once you get one test working, you know it is working now and forever. ! You use the tests as regression tests. The tests give us the courage to refactor. ! You can prove that everything still works after the refactoring by simply executing the tests. It‘s more fun that way, it reduces fear. 



----
## Plan

- Introduction.
- TDD and unit tests
- Strategies.
  - Development<!-- .element: class="fragment highlight-blue" -->
  - Debugging
  - Maintenance
- Conclusion.


----

## Development Strategy

1. Test often
  - to find errors quickly
  - to know when it is finished
2. Move forward by small steps
  - programming and refactoring
3. Use automation tools.

----
## Development Strategy

![](resources/png/tdd-5.png)

----
## Automation Tools


- For unit tests:
  - Easy unit tests writing
  - Fast test execution
  - Re-execution facilities
- Integrated Development Environment
  - Improves coding: autocompletion, method generation, code formatting
  - Quick test execution
  - Refactoring
  - Examples: 
    - [NetBeans](https://netbeans.org), [Eclipse](https://www.eclipse.org), [IntelliJ IDEA](https://www.jetbrains.com/idea/).

note:
Integrated development environment ! For writing tests, using auto-completion and generation of missing code. ! For running the tests ! For refactoring ! E.g. Eclipse Build environment ! For executing tests automatically and during the build process ! For computing code coverage ! For generating test reports ! E.g. Maven 


----
## Automation Tools

- Build tools:
  - Automatic test execution
  - Automatic report and website generation
  - [Maven](https://maven.apache.org), [Gradle](https://gradle.org)
- Test evaluation
  - PIT, Cobertura
- Static code analysis
  - PMD, Checkstyle, Findbugs
- Continuous integration tools:
  - Sonar, Jenkins, Travis
- Collaboration tools
  - Mattermost, Slack

note:
Build environment ! For executing tests automatically and during the build process ! For computing code coverage ! For generating test reports ! E.g. Maven 


----
## Gradle / Maven

- Repetitive task automation
- Sequence of different stages of building

----
## PMD

- Open-source tool for static code analysis
- Available as a plugin for most IDEs (Eclipse, Netbeans, JEdit, IDEA, etc.)
- Available for Maven
- Detects:
  - Dead code: unused variables, parameters, and methods
  - Unused objects
  - Empty code blocks: try / catch / finally / switch
  - Duplicate code
  - Unnecessarily complex expressions
https://pmd.github.io


----

## Checkstyle

- Open-source tool for checking code formatting and presentation
- Support different code conventions
- Available as a plugin for most IDEs (Eclipse, Netbeans, IDEA, etc.)
- Available for Maven and Gradle
- http://checkstyle.sourceforge.net

----
## Plan

- Introduction.
- TDD and unit tests
- Strategies.
  - Development
  - Debugging<!-- .element: class="fragment highlight-blue" -->
  - Maintenance
- Conclusion.

----

## Debugging Strategy

- Repeat:
  1. Find the most annoying defect
  1. Write a unit test that exposes it
  1. Correct the error
  1. Test
  1. Refactor
  1. Test again

----

## Debugging Strategy

![](resources/png/debug.png)

----

## Plan

- Introduction.
- TDD and unit tests
- Strategies.
  - Development
  - Debugging
  - Maintenance<!-- .element: class="fragment highlight-blue" -->
- Conclusion.

----

## Maintenance

> «— Are you sure that RPG is a programming language?»


----
## Maintenance

Legacy code:

> «— Does someone remember who wrote this code?»

> «— Last time someone touched this, we needed 3 weeks to make it work again.»

> «— The documentation is available, but it does not correspond to the code anymore.»

note:
    Legacy code = code patrimonial

----
## Working with legacy code

- Developers must take small steps, like a tightrope walker
- Without forgetting the safety network:
  - Unit tests, versioning, backups

note:
Go Hunting for BearBuild the Safety NetWork in small incrementsExpect to slow down, then speed upMeasure the results


----
## Maintenance approach

![](resources/png/legacy.png)

----
## Maintenance approach

1. Try to understand the legacy code. And don't.
1. Try to write a unit test based on what they understood. The test fails.
1. Improve the test until it passes
1. Restart with the next unit.


note:
    Write a test to see if you understand :Test FAILS Adapt test (iteratively): Test PASSES Move on to next piece.


----
## Plan


- Introduction.
- TDD and unit tests
- Strategies.
- Conclusion.<!-- .element: class="fragment highlight-blue" -->


----
## Conclusion

- Requirements drive the tests.
- Tests drive the development of the application code.
- No application code is written without writing a failing test first.
- Tests are executed often.
- Tests and code are written in elementary increments.
- Refactoring becomes a continuous operation and is supported by a passing a suite of tests.

note:
Tests are collected in a suite and the suite is run frequently, like every time after code is written.Test and code are written in elementary increments.Refactoring is a continuous operation, and is supported by a passing battery of tests.


----
## Benefits

- Reduces debugging time (and bugs)
- Short development cycles
- Tests become part of the software product
- Improve documentation
- Improve code quality
- Reduce maintenance costs
- Increases development speed (less time is spent chasing bugs)

note:
Reduces the number of bugs by orders of magnitude,
Increases development speed, because less time is spent chasing bugs.
Improves code quality because of the increased modularity, and continuous and relentless refactoring.
Decreases maintenance costs because the code is easier to follow.

----
## References

- Kanban: Successful Evolutionary Change for Your Business : David Anderson ISBN 978-0984521401 (existe en français http://tinyurl.com/LivreKanban) 
- Product Development Flow : Don Reinertsen - ISBN 978-1935401001
- Kanban pour l'IT : Laurent Morisseau - ISBN 978-2100578672
- Personal Kanban : Jim Benson - ISBN 978-1453802267

----

- Scrumban : Corey Ladas - ISBN 978-0578002149
- Kanban for the skeptics : Nick Oostvogels https://leanpub.com/kanbanforskeptics
- Kanban and Scrum : Henrik Kniberg, Mattias Skarin ISBN 978-0557138326
- The Goal : Eliyahu Goldratt (1984) ISBN 978-0884270614
- The Lean Startup : Eric Ries ISBN 978-0307887894
