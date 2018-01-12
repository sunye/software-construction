# Software Construction

[comment]: # (TODO)
[comment]: # (How to verify multiplicities?)
[comment]: # (Mapping designs to Unit Tests?)
[comment]: # (logging?)
[comment]: # (DevOps)

----
## Plan
- Introduction
- Mapping designs to code
- Conclusion

----

## Introduction

----

## Definition

> «Code Construction is the detailed creation of working meaningful software through a combination of coding, verification, unit testing, integration testing, and debugging.» [SWEBOK]

----

## A Software Engineering Activity

![](resources/png/software-construction.png)

- An activity is not a phase.
- Referring to the construction as an activity does not imply a distinct phase.

----

## Software Construction Sub-Activities
Software construction is more than just programming: 

- Software Designing
- Coding and debugging
- Unit Testing
- Integration
- Integration Testing
- Construction Planning
- Implementation modeling

note:
The choice of construction method is a key aspect of the construction planning activity. The choice of construction method affects the extent to which construction prerequisites (e.g. Requirements analysis, Software design, .. etc) are performed, the order in which they are performed, and the degree to which they are expected to be completed before construction work begins. Construction planning also defines the order in which components are created and integrated, the software quality management processes, the allocation of task assignments to specific software engineers, and the other tasks, according to the chosen method.[1]

----
## Roadmap

1. Identify coding standards
1. Identify an implementation strategy
1. Implement detailed design
1. Perform unit test
1. Release for integration

----
## Construction Technologies

----

## Software Design

- The Unified Modeling Language (UML). [Version 2.5](http://www.omg.org/spec/UML/).
- OMG standard containing:
  - A notation (concrete syntax)
  - A meta-model (abstract syntax)
  - Almost **no semantics**!
- Several diagrams (concerns), one model.
- Several actors and processes, one syntax.
  - Reduces the learning curve, but:
  - Increases misinterpretation and confusion!<!-- .element: class="fragment highlight-red" -->


----
## Automatic Code Generation
- Code generate (part of) the code from the design model.
- Several tools available: Xtend, Acceleo, etc.

note:
Writing generation templates is also “code construction”!

----
## Design by Contract

- Design-by-Contract
  - Specification of class invariants and pre and post conditions of methods.
  - Eiffel, JML, jContract. 
- Assertive programming
  - Use of assertions inside methods.
- Test-driven development

----
## Contracts in Eiffel

```
	make_fine (y, mo, d, h, mi: INTEGER; s: DOUBLE) is
			-- Set `year', `month' `day' to `y', `mo', `d'.
			-- Set `hour', `minute', `second' to `h', `m', `s'.
		require
			month_large_enough: mo >= 1
			month_small_enough: mo <= Months_in_year
			day_large_enough: d >= 1
			day_small_enough: d <= days_in_i_th_month (mo, y)
			h_large_enough: h >= 0
			h_small_enough: h < Hours_in_day
			m_large_enough: mi >= 0
			m_small_enough: mi < Minutes_in_hour
			s_large_enough: s >= 0
			s_small_enough: s < Seconds_in_minute
		local
			new_second: INTEGER
		do
			make_date (y, mo, d)
			new_second := s.truncated_to_integer
			make_precise_time (h, mi, new_second,
				((s - new_second) * 1000).truncated_to_integer)
		ensure
			year_set: year = y
			month_set: month = mo
			day_set: day = d
			hour_set: hour = h
			minute_set: minute = mi
			second_set: second = s.truncated_to_integer
			millisecond_set: millisecond = ((s - s.truncated_to_integer) * 1000).truncated_to_integer
		end
```

----

## Assertions
- Ensure the state of variables
- Improve code readability
- Improve error localization 
- Can be disabled 



----

## Java Assertion Example

```java
public abstract class Application {
    private Logger logger = Logger.global;
    private List<Service> services = new ArrayList<Service>();
    private Registry registry;
    private MessagingService messaging;

    public Application(Factory factory) {
        registry = factory.createRegistry();
        messaging = factory.createMessaging();

        assert registry != null : "Registry service was not created correctly";
        assert messaging != null : "Messaging service was not created correctly";

        this.addService(registry);
        this.addService(messaging);
    }
}
```

----
## Java Assertion with AssertJ

```java
class Assertion {
	public double calculate(int x, int y) {
		assertThat(x).isNotZero();
		assertThat(y).isLessThanOrEqualTo(10);
		// (...)
}
```
http://joel-costigliola.github.io/assertj/


----

## Build Management

- Build is the task that generates executable software from source code.
- Building software is not only compilation: dependency management, code generation, unit testing, configurations, etc.
- Maven, Gradle (Java), Grails (Ruby), Gem (Javascript), etc.

note:
Writing build scripts is also “code construction”

----

## Revision Control

- Revision control tracks and controls changes in the source code.
- If something goes wrong, it can determine what was changed and by who.
- CVS, SVN, Git, Mercurial, etc.

![](resources/tiff/git-logo.tiff)<!-- .element: style=" width:200px; position:absolute; right:0px;"-->

note:
In software engineering, software configuration management (SCM or S/W CM)[1] is the task of tracking and controlling changes in the software, part of the larger cross-disciplinary field of configuration management.[2] SCM practices include revision control and the establishment of baselines. If something goes wrong, SCM can determine what was changed and who changed it. If a configuration is working well, SCM can determine how to replicate it across many hosts.

----

## Automatic Testing
- Automatic execution of unit tests:
  - Shortens time to defect detection
  - Increases personal discipline
  - Avoids regression
- Test-driven development
- JUnit, TestNG, Selenium, etc.

![](resources/tiff/junit-logo.tiff)<!-- .element: style=" width:200px; position:absolute; right:0px;"-->

----

## Code Refactoring
- Refactoring improves the design of existing code without changing its behavior
- Examples: change of a class name, creation of an abstract class, extraction of the interface of class, etc.

----

## Reverse Engineering

- Legacy code (or other software) may be an important source of information
- Automatic analysis/modification of legacy code: MoDisco, Spoon, etc

![](resources/tiff/modisco-logo.tiff)<!-- .element: style=" width:200px; position:absolute; right:0px;"-->

----

## StackOverflow-based Development

- Discussion groups (from Usenet to Stack Overflow) are an important source of information:
  - code excerpts
  - advantages and drawbacks
  - alternative solutions
  - coding tips

----

## Continuous Integration

![](resources/tiff/continuous-integration.tiff)

----

## DevOps

![](resources/png/devops.png)

----

## Construction Tools
- Programming languages: 
  - GPL: Java, Scala, C++
  - DSL: Protobuf, Haxe
- IDE: Eclipse, NetBeans, IntelliJ
- Build: Ant, Maven, Gradle
- Static analysis: PMD, Findbugs
- Profiling: JProfile

----
## Coding Tips

----

## Avoid Repetition

![](resources/jpg/repetition.jpg)

----
## Avoid Complexity

```c
float InvSqrt (float x){
    float xhalf = 0.5f*x;
    int i = *(int*)&x;
    i = 0x5f3759df - (i>>1);
    x = *(float*)&i;
    x = x*(1.5f - xhalf*x*x);
    return x;
}
```
The inverse square root implementation in Quake 3

http://www.gamedev.net

----

## Keep Things Simple

Replace:
```java
if (booleanExpression) {
    return true;
} else {
    return false;
}
```
by:
```java
return booleanExpression;
```

----

And:
```java
if (condition) {
    return x;
}
return y;
```
by:
```java
return (condition ? x : y);
```

----

## Avoid Unnecessary Optimizations

- Profile first!

----

## Respect the Law of Demeter

- Any method of a class should call only methods belonging to:
  - Its class
  - The parameters that were passed in to the method
  - Any objects created by the class
  - Any attribute referenced object
  - Global variables
- In other words:  do not use objects to get other objects

http://wiki.c2.com/?LawOfDemeter

note:
In some cases (using collection of objects) this law can be “release”.
Iterators, for instance, break this law.

----
## Learn Code Smells
- Code smells are “warnings signs” of deeper problems.
- For instance: god classes, feature envy, long methods, too many parameters, nested if statements, etc.

http://wiki.c2.com/?CodeSmell

----

## Think Globally, Program Locally
- Make variables as local as possible and as invisible as possible
- If you have the choice between protected or private visibility, choose private.
- Making attributes protected gives objects of subclasses access to attributes of their super-classe.

----
## Depend on Interfaces, not on Implementations

```java
class Dependency {
    Collection<String> names = new LinkedList<
                         String>();
    Collection<String> getNames(){}
    void addMoreNames(Collection<String> others){} 
}
```

note:
If a different implementation is needed (ArrayList, SynchronizedArrayList, etc.), maintenance is simplified.

----
## Coding Conventions

- Generic conventions (for Java):
  - [Sun/Oracle Code Conventions](https://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)
  - [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Project specific:
  - [GNU Coding Standards](https://www.gnu.org/prep/standards/html_node/index.html)
  - [Mozilla Coding Style Guide](https://developer.mozilla.org/en-US/docs/Mozilla/Developer_guide/Coding_Style)
  - [Apache Coding Standards](https://portals.apache.org/development/code-standards.html)

----
## Conclusion

- Code construction is not only implementation.
- It is not a phase of the development process.


