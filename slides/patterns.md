# Design Patterns

----

## Plan

- Introduction
- A first example
- Pattern description form
- Back to the example (the State pattern)
- Conclusion

----

## Software Design is Hard

- Especially for in inexperienced designers.
- Designing good-quality reusable software is even harder.
- Software design experience is difficult to communicate.

----

## Becoming a Chess Master

- **First learn rules and physical requirements**: e.g., names of pieces, legal movements, chess board geometry and orientation, etc. 
- **Then learn principles**: e.g., relative value of certain pieces, strategic value of center squares, power of a threat, etc. 
- **However, to become a master of chess, one must study the games of other masters**: These games contain patterns that must be understood, memorized, and applied repeatedly 
- There are hundreds of these patterns.

[Levine and Schmidt]

----

## Becoming a Software Design Master

- **First learn the rules**: e.g., the algorithms, data structures, and languages of software 
- **Then learn the principles**: e.g., structured programming, modular programming, object oriented programming, generic programming,  etc.
- **However, to truly master software design, one must study the designs of other masters**: These designs contain patterns that must be understood, memorized, and applied repeatedly. 
- There are hundreds of these patterns. 

[Levine and Schmidt]

----

## Speaking like a Chess Master

<!-- .slide: style="text-align: left;"> --> 

- When a chess master describes a particular position in a game, he does not give the position of all pieces.
- Instead, he refers to a known game:
- We had the same opening as the 6th game of Fischer vs Spassky in 1972, but in move 11 I placed my tower in b1 instead of c1.
- There are hundred of known games.

<!-- .element: style="width:600px;" -->

![](resources/gif/72sf01.gif)
Game 6 : Fischer - Spassky. After 38.Rf5-f6 (xN) 

<!--  .element: style="position:absolute; right:0px; top:200px; width:200px; font-size: small;" -->

note:
Fischer–Boris Spassky, World Chess Championship 1972 (Iceland), 6th match game, Queen's Gambit Declined, Tartakower (D59), 1–0 Saidy called this game "[the] finest artistic achievement of the whole match".[628]
position:relative; top:0px; right:0px; width:200px

----

## Speaking like a Software Design Master

<!-- .slide: style="text-align: left;"> --> 

- When designers discuss about software, they do not describe classes, attributes, types, and methods.
- Instead, they refer to known patterns:
  - e.g., in JUnit, a Test Case is a Command and a Test Suite a Composite.

<!-- .element: style="width:500px;" -->

![](resources/gif/junit-patterns.gif)
http://junit.org/

<!--  .element: style="position:absolute; right:0px; top:200px; width:400px; font-size: small; text-align: center;" -->

----

## Motivation

- How to catalog design solutions, only known by expert designers?
- And above all, how to make them accessible to inexperienced designers?
  - Catalog proven design solution and describe them as patterns. 

----

## A Little History (1/5) 

- Christopher Alexander:
  - Notes on the Synthesis of Form, Harvard University Press, 1964.
  - Oregon Experiment, Oxford University Press, 1975.
  - A Pattern Language: Towns, Buildings}, Construction, Oxford University Press, 1977.
  - Timeless Way of Building, Oxford University Press, 1979.

note:

The current use of the term "pattern" is derived from the writings 
of the architect Christopher Alexander who has written several books 
on the topic as it relates to urban planning and building 
architecture:

%lthough these books are ostensibly about architecture and urban 
planning, they are applicable to many other disciplines, including 
software development. In [Notes], Alexander argues that current 
architectural methods result in products that fail to meet the real 
demands and requirements of its users, society and its individuals, 
and are unsuccessful in fulfilling the quintessential purpose of all 
design and engineering endeavors: to improve the human condition. 
Alexander wanted to create structures that are good for people and 
have a positive influence on them by improving their comfort and 
their quality of life. He concluded that architects must constantly 
strive to produce work products that better fit and adapt to the 
needs of all their inhabitants and users and their respective 
communities. In [APL] Alexander describes some "timeless" design 
ideas to try and realize these goals.

----

## History (2/5)

- In [TTWoB] Alexander proposes an architecture paradigm, based on three concepts:
  - The Quality (a.k.a. ``the Quality Without a Name'').
  - The Gate.
  - The Way (a.k.a. ``the Timeless Way'').

note:

The quality: This is the essence of all things living and useful 
that imparts unto them qualities such as: freedom, wholeness, 
completeness, comfort, harmony, habitability, durability, openness, 
resilience, variability, and adaptability. It is what makes us feel 
"alive" and "sated", gives us satisfaction, and ultimately improves 
the human condition. 

The gate: This is the mechanism that allows us to reach the quality. 
It is manifested as a living common pattern language that permits us 
to create multiform designs which fulfill multifaceted needs. It is 
the universal "ether" of patterns and their relationships that 
permeate a given domain. The gate is the conduit to the quality. 

----

## History (3/5)

- Using Pattern Languages for Object-Oriented Programs.  Ward Cunningham and Kent Beck. OOPSLA'87.

note:

In 1987, Ward Cunningham and Kent Beck were working with Smalltalk 
and designing user interfaces. They decided to use some of 
Alexander's ideas to develop a small five pattern language for 
guiding novice Smalltalk programmers. They wrote up the results and 
presented them at OOPSLA'87 in Orlando in the paper "Using Pattern 
Languages for Object-Oriented Programs".

----

## History (4/5)

- Advanced C++ Programming Styles and Idioms. Jim Coplien, 1991. 
- Workshops OOPSLA de 90 à 92.


----

## History (5/5)

<!-- .slide: style="text-align: left;"> --> 

- Hillside Group (PLoP Conferences): Kent Beck, Grady Booch, 
- Richard Gabriel et al. OOPSLA 1993, 94.
- Design Patterns [GoF]. 1995.

<!-- .element: style="width:500px;" -->

![](resources/jpg/gof-book.jpg)
["Gang of Four"](http://wiki.c2.com/?GangOfFour)

<!--  .element: style="position:absolute; right:0px; top:00px; width:300px; font-size: small; text-align: center;" -->

----

## Pattern Definition

- General definition:
> “A pattern is a general reusable solution to a commonly occurring problem within a given context.”
- Christopher Alexander:
> “Each pattern is a three-part rule, which expresses a relation between a certain context, a problem, and a solution.”

note:

The first definition is correct, yet it could be misinterpreted. 

----

## A First Example

### The State pattern

----

## TCP/IP Protocol Implementation

![](resources/png/tcp-ip.png)

<!--  .element: style="position:absolute; left:100px; top:200px; width:300px;" -->


```java
TCP/IP::send(s : Stream) {
if state = ‘opened’
	{
	(…)
	}
if state = ‘closed’
	{
	(…)
	}
if state = ‘idle’
	{
	(…)
	}
}
```

<!--  .element: style="position:absolute; right:100px; top:200px; width:400px;" -->

----

## Problem

- How to avoid a connexion state verification each time a packet is sent?

----

## Solution

- Isolate the behavior that depends on the connexion states on different classes.

----

## In other words

![](resources/png/tcp-ip-state.png)

----

## Connexion Example (1/2)

```java
TCP/IP::open() {
	this.status.open();
}
```

![](resources/png/tcp-ip-open.png)

----

## Connexion Example (2/2)

![](resources/png/tcp-ip-open2.png)

----

## Consequences

- Each instance of « TCP/IP » is linked to an instance of a subclass of « TCP/IP State » 
- State verification is no longer necessary.

----

## Observations

- This solution is used on several TCP/IP protocol implementations.
- A similar solution is used on several drawing programs (tool behavior according to the selected figure).

![](resources/png/drawing-context.png)

----

## Pattern Description Form

----

## Description Forms

- Patterns are not code, they are only “documentation”.
- A pattern is described in a specific literary form.
- There are different pattern description forms:
  - Alexander, Coplien, GoF, Portland, Cockburn, etc.

----

## Essential Parts

- Name
- Context
- Problem
- Forces
- Solution
- Author and Date

----

## Name

- A significant label that reflects the principle of the pattern.
- The name tends to be based on the solution.
- The name becomes part of the domain vocabulary (pattern language).

----

## Context

- The context describes the place of the pattern in a system.
- It specifies programming languages, sizes, scope, performance, or anything else that, if changed, would invalidate the pattern.

----

## Problem

- Usually the problem is presented as a question or as a statement.
- The first thing one looks.
- The understanding of the problem comes with an analysis of pattern forces.

----

## Forces

- Forces are the core of a pattern.
- Forces determine a problem is difficult: they describe the trade-offs that drive the solution.
- Once the designer understands the forces of a pattern, he also understands the soundness of the solution and why a simpler solution is not well-adapted.
- Typically, forces are related to software quality factors: performance, maintainability, etc.

----

## Solutions

- Solutions equilibrate les forces.
- Solutions apply to the system as a whole: they are transformable and not fixed. 
- Solutions are not unique: a single pattern can be applied several times and yet have different solutions.
- Solutions can be partially described as UML Collaboration.

----

## Author and Date

- The author of a pattern is seldom its creator.

----

## Back to the Example

----

## Name 

- State.
- Alias: Objects for States, Envelope-Letter. 

----

## Problem

- How to treat an object whose behavior is strongly dependent on its internal state, without checking this state at each operation call?

----

## Context

- The object behavior depends on its state.
- Operations have large, multipart conditional statements that depend on the object's state.

----

## Solution 

![](resources/png/pattern-state-collaboration.png)
UML Collaboration Diagram

----

## Solution

![](resources/png/pattern-state-collaboration-use.png)
UML Class Diagram

----

## Forces (1/2)


1. State-specific behavior is isolated, increasing maintainability. 
1. Replacing a conditional by a delegation may reduce performance.
1. State transition become explicit, increasing testability.
1. State sub-instances may be shared by several contexts, if they do not contain properties.



----

## Forces (2/2)

1. Who defines the state transitions?
  - **The Context**: less robust
  - **The States**: the context must provide an appropriate interface and the states must know the context.
1. How to create and destroy states?
1. When the context is created.
1. Later (lazy instantiation).
1. Dynamic inheritance may be used in Self

----
## Author and Date

- The State pattern is part of the GoF Catalog.
- It was applied to TCP connection protocols [Johnson and Zweig 91] and to graphical editors such as HotDraw [Johnson 92] and Unidraw [Vlissides and Linton 90].

----

## Conclusion

----

## Final Remarks

- Patterns are micro-architecture, they cannot ensure a good overall architecture.
- Patterns do not cover all design decisions: creativity is still needed!
- Do not be overly enthusiastic: patterns should not be used at all costs.
- Learning patterns requires time. Do not be impatient.

----

## Conclusion

- Design patterns collect design knowledge and improve communication.
- There are hundred of design patterns available.
- Essential patterns: Composite, Strategy, State, Command, Iterator, Proxy, Template Method, Façade, Null Object.

----

## References (1/3)

- « Software Patterns ». James Coplien. SIGS Books. New York, 1996.
- « Smalltalk Patterns: Best Practices ». Kent Beck. Prentice Hall, 1997, 256 pp., ISBN 0-13-476904-X.
- « Design Patterns: Elements of Reusable Object-Oriented Software ». Erich Gamma, Richard Helm,Ralph Johnson, and John Vlissides. Addison Wesley. October 1994. 

----

## References (2/3)

- The « Pattern Languages of Program Design » series:
  - Coplien & Schmidt
  - Vlissides, Coplien, & Kerth
  - Martin, Riehle, Buschmann
  - Harrison, Foote, Rohnert

----

## References (3/3)

- «Introduction to Patterns and Frameworks.» Dr. David L. Levine and Douglas C. Schmidt. Department of Computer Science Washington University, St. Louis.

----

## Web Sites

- Patterns homepage: http://hillside.net/patterns/
- Portland Pattern repository: http://c2.com/ppr/index.html
- Cetus Links: http://www.objenv.com/cetus/oo_patterns.html
- Patterns FAQ: http://g.oswego.edu/dl/pd-FAQ/pd-FAQ.html
