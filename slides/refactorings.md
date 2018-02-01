# Refactoring

----

## Plan

- Introduction<!-- .element: class="fragment highlight-blue" -->
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction
- Automatization
- Conclusion

----

## Software evolution ideas

- Software is never finished.
- Software maintenance is just continuous development.

- Consequence: code becomes complex and brittle

----

## Why?

- Original design is always inadequate.
- Even good designers cannot:
  - get right the first time.
  - predict how the software will evolve.
  - understand correctly the problem domain and user requirements.

----

## Software evolution basis

«Evolutionary Software Development».  Fred Brooks.

>“— Grow, don’t build software.”

----

## Evolutionary Software Development

![](resources/png/evolutionary.png)
<!-- .element: style="position:relative; width:400px; right:-200px; top:00px;" -->


1. Prototyping
1. Evolution
1. Consolidation

<!-- .element: style="position:relative; width: 500px; left:-200px; top:-300px;" -->


----

### Software prototyping

- Solidifies user requirements
- Sketches the initial software design 

![](resources/png/evolutionary.png)
<!-- .element: style="position:relative; width: 400px;" -->

----

### Software evolution

- Adds new functionalities. 
- Determines expansion points (hot-spots).

![](resources/png/evolutionary.png)
<!-- .element: style="position:relative; width: 400px;" -->

----

### Software consolidation

- Improves Design:
  - Corrects defects
  - Introduces new abstractions

![](resources/png/evolutionary.png)
<!-- .element: style="position:relative; width: 400px;" -->

----

## Software refactoring definition

> «A program transformation that preserves the visible behavior»

> «The process of improving the design of a software source code».

----

## Simple example

### Class rename

From:

```java
public class Stuff {
    // (...)
}
```

To:

```java
public class ConfigurationManager {
    // (...)
}
```

----

## Another example

### Insert intermediate class

From:

```java
public class Root {}

public class ConcreteA extends Root {}

public class ConcreteB extends Root {}
```

To:

```java
public class Root {}

public class IntermediateClass extends Root {}

public class ConcreteA extends IntermediateClass {}

public class ConcreteB extends IntermediateClass {}
```

----

## A more complex example

![](resources/png/complex-refactoring.png)

----

## Origins

- Software maintenance and evolution
- Software application development
- Software framework development

----

## Motivation

- The eternal quest for code uniqueness
- The code is read and modified more often than it is written

----

## Difficulties

- Understand an existing design is hard
- Modify an existing design is even harder
- Code changes may introduce errors, defeating the propose.
- Results are not visible.

----

- Every software project is under time pressure.
- Developers are paid to add new features.
- Refactoring can be very expensive.

----

## Code evolution without refactoring

- Design becomes more corrupt and code becomes more brittle.
- Changes become more expensive and more frequent and are made quickly and poorly.

----

## Refactoring during software construction

- Gradually change the code to get a healthy design.
- Design is done continuously.
- By building the system, we discover how to improve it.

----

## Plan

- Introduction
- Refactoring Operations<!-- .element: class="fragment highlight-blue" -->
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction
- Automatization
- Conclusion

----

## Refactoring operations

- Simple source-to-source transformation with no visual effect. 
- Since refactoring operations are behavior-preserving, they can be composed and still preserve behavior.
- Learning refactoring operations is similar to learning simple arithmetics.

----

## Basic operations

- Add entity
- Remove entity
- Rename entity
- Move entity
- Intra-method
- Composite operations

----

### Add entity

- Add an attribute (instance or class level)
- Add a class
- Add a method (instance or class level)

![](resources/png/add-entity.png)
<!-- .element: style="position:relative; width:500px;" -->

----

### Remove entity

- Remove an attribute (instance or class level)
- Remove a class
- Remove a method (instance or class level)

----

### Rename entity

- Rename a local variable
- Rename an attribute  (instance or class level)
- Rename a class
- Rename a method (instance or class level)
- Change a method signature:
  - rename, permute, add, or remove arguments.

----

### Push-down (Specialization) or Pull-up (Generalization) property 

- Attribute push-down or pull-up (instance or class level).
- Method push-down or pull-up (instance or class level).

![](resources/png/attribute-generalization.png)
<!-- .element: style="position:relative; width:600px;" -->

----

### Move property

- Move attribute or method to another class

![](resources/png/move-property.png)
<!-- .element: style="position:relative; width:500px;" -->

----

### Intra-method

- Extract code as method
- Extract code as temporary variable
- Inline method
- Inline temporary variable

----

### Composite operations

- Encapsulate attribute
- Make attribute read-only
- Extract interface from class
- Extract inner class
- Create template method

----

### Other operations

- Change entity visibility
- Introduce factory method
- Convert variable to attribute

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design<!-- .element: class="fragment highlight-blue" -->
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction
- Automatization
- Conclusion

----

## Refactor for extensibility

- Strategy:
  - Refactor code before code extension
  - Separate things that change from things that do not.
  - Apply design patterns.

----

## Design patterns

Variability point | Design Pattern
--|--
Algorithms | Strategy, Visitor
Actions | Command
Implementation | Bridge
Response to change | Observer
Interactions between objects | Mediator

----

Variability point | Design Pattern
--|--
Object being created | Factory Method, Abstract Factory, Prototype
Structure being crated | Builder
Traversal Algorithm | Iterator
Object interfaces | Adapter
Object behavior | Decorator, State

----

## Example: introduce algorithm variability

```java
public class Client {
    public void writeAsciiOn(OutputStream o) {
        o.print('name: ');
        o.print(this.name);
        (...)}
    }
```

> Suppose that we want to print in HTML, XML, Framemaker, etc.

----

### Steps


1. Create `AsciiStrategy` class
2. Add instance attribute to class `Client` and initialize it to `AsciiStrategy`
3. Move method `writeAsciiOn()`to class `AsciiStrategy`
4. Rename method `writeAsciiOn()` to `writeOn()`

----

### Result

```java
public class Client {
    private writeStrategy = new AsciiStrategy();
    public void writeOn(OutputStream o) {
        writeStrategy.writeOn(this, o)}
}

public class AsciiStrategy {
    public void writeOn(Client c, OutputStream o)
        o.print('name: ');
        o.print(c.name);
        (...)}
}
```

----

### Consequences

- The printing behavior was extracted from the class `Client`.
- Adding new printing behavior could be easily achieved.

![](resources/png/write-strategy.png)

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction<!-- .element: class="fragment highlight-blue" -->
- Automatization
- Conclusion

----

## Refactor and Software Construction

Strategies during construction:

1. Extend and then refactor
1. Refactor to extend
1. Debug and then refactor 
1. Refactor to debug
1. Refactor to understand

----

### Extend and then refactor

When you need to add a new functionality:

- Find a  class or method with similar behavior and copy it
- Make it work
- Eliminate redundancy

----

### Refactor to extend

- A functionality seems too complex to implement
- Refactor the current design to make the change easy
- Make the change

----

### Debug and then refactor 

- Locate and fix the bug
- Refactor tge code to make the bug obvious: 
  - Add assertions
  - Extract method
  - Assign meaningful names 
  - Create explaining constants for magic numbers
  - Create explaining constants or variables for complex expressions

----

### Refactor to debug

- Since refactor operations are behavior-preserving, they also preserve bad behavior.
- Before debugging, refactor to simplify complex code 
- Then, debug it 

----

### Refactor to understand

- Refactor when trying to understand a complex code:
  - Split large methods
  - Create explaining constants or variables for magic numbers
  - Assign meaningful names 
  - Do not worry about performance

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability<!-- .element: class="fragment highlight-blue" -->
- Integrate Refactoring to Software Construction
- Automatization
- Conclusion

----

> “Let the program tell you where to refactor” - Kent Beck

----

## Refactor to improve code maintainability

- Strategy:
  - Use heuristics to find where the code should refactored
  - These heuristics are commonly called «code smells».

----

### The good, the bad, and the ugly

- A code smell is:
  - A sign that something in the code is not good
  - not necessarily a certainty
  - not necessarily bad

In other words: use your flair to find bad code!

note:
There's good code and bad code, right? Well, there is, but there's also a lot of code in the middle. Code that's pretty good, but could be better. What's good about it and what's bad? We want to save the part's that are good, and fix the parts that are less good. That's what refactoring is all about.

To refactor the code, however, we have to develop a sense of what's bad. There are design principles that make a pretty clear distinction and there are heuristics that, with thought, can generally indicate the difference. Sometimes something is a little bad, but it's the best we can do right now for reasons out of our control. Perhaps the alternatives are worse, so we live with it. But we need to develop a nose for code that "smells bad" so that we recognize it quickly. Then we can fix it, or even prevent it from going into the system in the first place.

----

## Code Smells (1/5)

### Bloaters

- Long Method
- Large Class
- Primitive Obsession
- Long Parameter List
- Data Clumps
- Too many private methods

note:
Bloaters are code, methods and classes that have increased to such gargantuan proportions that they are hard to work with. Usually these smells do not crop up right away, rather they accumulate over time as the program evolves (and especially when nobody makes an effort to eradicate them).

----

#### Long method

- The longer a method is, the more difficult it is to understand how it works. 
- The method is the smallest unit of overriding
- No metric will always be correct
- Statements within a method should be at the same level of abstraction

----

#### Long method -- Fix

- Extract code snippets as smaller methods:
  - If an entire method is long and low-level, find the sequence of higher-level steps.
  - Comments in the middle of a method often point out good places to extract.
- Smaller methods can often be reused

----

#### Large class

- Often, an excessive number of methods or attributes hides a duplication of code.
- Again, no metric fits all cases
- Look for disparate sets of methods and instance variables
- Example:
  - class `org.eclipse.emf.common.util.URI`
  - Non-Commenting Source Statements: 2034
  - Methods: 115
  - Inner classes: 5

----

#### Large class -- Fix

- Create _compositions_ of smaller classes
- Find logical sub-components of the original class and create classes to represent them
- Move methods and attributes into the new components
- Related refactoring operations: Extract Class, Extract Subclass

----

#### Long Parameter List

- A long parameter list often hides a missing abstraction
- A method with too many parameters is seldom reusable
- Error prone (argument permutation)

----

#### Long Parameter List -- Fix

- Create a class containing all interrelated  parameters.
- Use this class as a parameter
- Find methods that should be in the new class

----

#### Too many private methods

- Methods should be public, unless they violate a class invariant.
- Only public methods can be tested.

## Code Smells (2/5)

### Object-Orientation Abusers

- Nested conditionals
- Temporary Field
- Refused Bequest
- Alternative Classes with Different Interfaces

note:
All these smells are incomplete or incorrect application of object-oriented programming principles.

----

#### Nested conditionals

- Symptom of methods in the wrong place
- Rather than switching allow method lookup to do the switching
- New cases do not require changing existing code (the ultimate goal)

----

#### Nest conditionals -- Fix

- If the conditional expression involves type test (isKindOf(), type(), getClass(), etc.), put the method on that class.
- If the expression involves null objects (isEmpty(), isNil(), null, empty()), consider the Null Object pattern.

----

## Code Smells (3/5)

### Change Barriers

- Divergent Change
- Shotgun Surgery
- Parallel Inheritance Hierarchies

note:
These smells mean that if you need to change something in one place in your code, you have to make many changes in other places too. Program development becomes much more complicated and expensive as a result.

----

#### Parallel Inheritance Hierarchies

- A special case of Shotgun Surgery. Every time you make a subclass of one class, you also have to make a subclass of another.
- Often, classes from both hierarchies share a same prefix
- Example: Transactions and Accounts. An account only accepts transactions from the same type.
- Fix: use Move Method and Move Attribute to combine the hierarchies into one.

----

## Code Smells (4/5)

### Expendables

- Comments
- Duplicate Code
- Lazy Class
- Data Class
- Dead Code
- Speculative Generality

note:
A dispensable is something pointless and unneeded whose absence would make the code cleaner, more efficient and easier to understand.

----

#### Comments 

- A comment should describe an intention and not explain an action.
- Too many unnecessary comments overloads the code and make it unreadable.
- Related refactoring operations: assign meaningful name to method, extract commented snippet as method, introduce assertions.

----

#### Duplicated code

- Do everything once and only once
- Duplicate code makes the system harder to understand
- Duplicate code is harder to maintain:
  - Any change must be duplicated
  - The maintainer must be aware

----

#### Duplicated code -- Fix

- Push-up identical methods to common superclass
- Push-up the more general method 
- Move the method into a common component (e.g., Strategy)
- Related refactoring operations: Extract Method, PullUp Method, Form Template Method

(See also: Large Methods)

----

#### Data classes

- Classes with attributes, getters and setters and nothing else 
- Aka, Data Transfer Objects (DTO)
- Related refactoring operation: Move Method

```java
package fr.unantes.test.badcode;

/**
 * @author dupond
 * @author dupont
 */
public class Entreprise extends Person {

    private String raisonSociale;

    public Enterprise(String companyName) {
        this.companyName = companyName;
    }

    public String getRaisonSociale() {
        return this.companyName;
    }

    public String toString() {
        return this.companyName;
    }

    public String write() {
        return this.companyName;
    }
}
```

----

#### Speculative Generality

- Over-generalized code in an attempt to predict future needs.
- Unused classes, methods, attributes, or parameters.
- Code becomes hard to understand and support.

----

#### Speculative Generality -- Fix

- Remove unnecessary delegation with Inline Class
- Remove (almost) empty abstract classes
- Remove unused parameters
- Methods named with odd abstract names should be brought down to earth with Rename Method

## Code Smells (5/5)

### Couplers

- Feature Envy
- Inappropriate Intimacy
- Message Chains
- Middle Man
- Incomplete Library Class

note:
All the smells in this group contribute to excessive coupling between classes or show what happens if coupling is replaced by excessive delegation.

----

#### Feature envy

- A method that invokes the getters of another class
  - move it into the class
- Sometimes just a portion of a method
  - extract the portion
  - move it

```java
public class EnterpriseGroup extends Group {
    public String toString() {
        String display;
        display = "Group: " + this.nom + "\n\n";
        for (int i = 0; i < this.persons.size(); i++) {
            display += ((Enterprise) this.persons.get(i)).getCompanyName() + "\n";
        }
        return display;
    }
}
```

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction<!-- .element: class="fragment highlight-blue" -->
- Automatization
- Conclusion

----

## A loan metaphor

- Quick and dirty coding is like taking out a loan
- Living with bad code is the interest
- Debt is necessary for a business
- Too much debt is not healthy and will eventually catch up to you

----

## Refactoring phase

- Refactor after a code release:
  - Little more breathing room
  - The design is still fresh in your mind

----

## Agile software development

- Listen
- Test
- Code
- Refactor Continually

----

- Some of the principles still apply, even if your not extreme
- Whenever something seems difficult or awkward, refactor to make it easy 
- Let the program tell you where it needs to be fixed
- If you cut and paste, you must refactor

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction
- Automatization<!-- .element: class="fragment highlight-blue" -->
- Conclusion

----

## Using Standard Tools

- Safe refactoring needs tests
- Tests must pass before and after each refactoring operation.
- Use standard testing tools: JUnit, TestNG, etc.
- Current Java IDE provide refactoring operations: Eclipse, Netbeans, IntelliJ IDEA

----

## Refactoring tools

- Smalltalk: Refactoring Browser, Lint.
- Python: Bicycle Repair Man, pycheck.
- Java: Eclipse, IntelliJ Idea, JFactor, XRefactory, JBuilder, RefactorIt, JRefactory, Transmogrify, JafaRefactor, CodeGuide, jLint.
- C++: SlickEdit, Ref++, Xrefactory.
- Ruby: Ruby Refactoring

----

## Plan

- Introduction
- Refactoring Operations
- Refactor to Improve Design
- Refactor to Improve Maintainability
- Integrate Refactoring to Software Construction
- Automatization
- Conclusion<!-- .element: class="fragment highlight-blue" -->

----

## Conclusion

- Evolutionary Software Development
- Refactorings
- How to find smelly code
- Ways of integrating refactoring into your process

----

## References

- PhD Thesis from William Opdyke, Don Roberts, and John Brant.
- Martin Fowler's book and [website](http://www.refactoring.com)
- [eXtreme Programming](http://www.extremeprogramming.org)
- [SourceMaking](https://sourcemaking.com/refactoring)
- [Coding Horror Blog](https://blog.codinghorror.com/code-smells/)

----

## Credits

Several slides and examples are based on a John Brant and Don Roberts presentation "Refactoring Techniques and Tools" at Smalltalk Solutions '99.
