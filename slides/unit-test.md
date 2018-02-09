# Unit Testing

----

## Golden rule

> «If a method does not have automatic tests, it does not work».

----

## Plan

- Introduction<!-- .element: class="fragment highlight-blue" -->
- JUnit
- Guidelines
- Conclusion

----

## Definition

> Unit testing is a software testing approach that consists in testing each unit of the software under test individually.

----

## Units

- Intuitively, a unit is the smallest testable part of a software.
- In procedural programming: a function or a procedure.
- In object-oriented programming: a class.

![](resources/png/unit.png)<!-- .element: style="width:100px;" -->

----

## Goals

- Check that each unit works as designed
- Isolate each software part and show they are corrects


----

## Rationale

- The reliability of a system is equal to its less reliable part.

![](resources/png/system.png)<!-- .element: style="width:200px;" -->

- A trustworthy system is made of trustworthy units.

----

## Dynamic unit tests

- Unit tests can be either static or dynamic
- Static unit tests:
  - unit code reviews, inspections, etc.
  - automatic static analysis.
- Dynamic unit tests:
  - isolate and run units.

----

## Tested properties

- Functional behavior
- Error handling
- Input values check
- Performance

----

## Benefits

- Avoid the «Developer's Block»:
  - Developers do not fear to change existing code
  - Improve developer's confidence on his code

- Are a living documentation
  - Tests are usage examples of each unit
  - Work as the unit specification

----

## Software construction simplification

### Unit tests

- Simplify debugging:
  - Reduce the search space
  - Avoid useless "prints"

- Simplify evolution:
  - Avoid regression
  - Work as a «safety net»

- Simplify integration:
  - If developers trust on each unit, integration errors are easier to find
  
----

## An investment in the future

###Automatic unit tests 

- Will be reused countless times during the software lifetime
  - During corrective and evolutive maintenance
- Force developers to write testable code
- Improve design
  - Tests are clients of the unit under test, helping developers to write simple interfaces

----

## Plan

- Introduction
- JUnit<!-- .element: class="fragment highlight-blue" -->
- Guidelines
- Conclusion

----

## JUnit

- Java Framework for writing dynamic unit tests
- Open source, available at http://www.junit.org
- Origins:
  - eXtreme Programming (XP)
  - Smalltalk Test Framework (Kent Beck)
  - First implementation by Erich Gamma 1997

----

## Simple example

- Use JUnit to test the `Interval` class.
- The `Interval` class represents simple intervals
  - Method `includes()` checks if a value belongs to the interval


----

## The `Interval` class

```java
public class Interval<T extends Comparable> {
    private final T begin;
    private final T end;

    protected Interval(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    public boolean includes(T i) {
        return i.compareTo(begin) >= 0 && i.compareTo(end) <= 0;
    }
}
```

----

## Testing the `Interval` class

1. Create a test class
2. Implement a test method that:
  - Instantiates the `Interval` 1-10 
  - Check if `5` belongs to this interval

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

    @Test
    void testIncludes() {
        Interval<Integer> interval = new Interval<>(0, 10);
        assertTrue(interval.includes(5));
    }
}
```

----

### Some Implementation details

- JUnit automatically executes all methods adorned with `@Test`
- `Assertions.assertTrue(<exp>)` makes the test fail if `<exp>` evaluates to false.

----
### Improving the tests

- Check if `-1` and `11` do not belong to the interval

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

    @Test
    void testIncludes() {
        Interval<Integer> interval = new Interval<>(0, 10);
        assertTrue(interval.includes(5));
    }

    @Test
    void testIncludesUpperBoundary() {
        Interval<Integer> interval = new Interval<>(0, 10);
        assertFalse(interval.includes(11));
    }

    @Test
    void testIncludesLowerBoundary() {
        Interval<Integer> interval = new Interval<>(0, 10);
        assertFalse(interval.includes(-1));
    }
}
```

----
### Assembling common code

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {
    private Interval<Integer> interval_1_10;

    @BeforeEach
    void setup() {
        interval_1_10 = new Interval<>(0, 10);
    }

    @Test
    void testIncludes() {
        assertTrue(interval_1_10.includes(5));
    }

    @Test
    void testIncludesUpperBoundary() {
        assertFalse(interval_1_10.includes(11));
    }

    @Test
    void testIncludesLowerBoundary() {
        assertFalse(interval_1_10.includes(-1));
    }
}
```

----

###  More implementation details

- JUnit automatically executes the method adorned with `@BeforeEach` before each `@Test` method.
- In the example, `setup()` is executed 3 times.

![](resources/png/junit-execution.png)<!-- .element: style="width:500px;"  -->

----

### Parameterized tests

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {
    private Interval<Integer> interval_1_10;

    @BeforeEach
    void setup() {
        interval_1_10 = new Interval<>(0, 10);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void testIncludes(int value) {
        assertTrue(interval_1_10.includes(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 11, Integer.MAX_VALUE})
    void testNotIncludes(int value) {
        assertFalse(interval_1_10.includes(value));
    }
}
```

----

- JUnit automatically executes methods adorned with `@ParameterizedTest` several times: one time for each value

----

## Plan

- Introduction
- JUnit
- Guidelines<!-- .element: class="fragment highlight-blue" -->
- Conclusion

----

## Guidelines

- Ensure Isolation
  - To ensure testing robustness and simplify maintenance, tests should never rely on other tests nor should they depend on the ordering in which tests are executed.

- Make test reproducibles
  - Multiple test executions must consistently yield the same result, provided no changes were made on the software under test.

----

- Ensure atomicity
  - Tests must either pass or fail, they cannot be partially successful.

- Test behaviors, not methods:
  - One test should be responsible for one scenario only (single responsibility).
  - One method, multiple behaviors:  multiple tests
  - One behavior, multiple methods:  one test

----

- Write readable tests
  - Unit test must be easy to read and understand
  - Variable, method, and class names should be self-descriptive

- Name tests to represent PASS conditions:
  - `public void canMakeReservation()`
  - `public void totalBillEqualsSumOfMenuItemPrices()`

----

- Write single flow code:
 - No conditional logic or loops
 - Test should have no uncertainty:
 - All inputs should be known
 - Method behavior should be predictable
 - Expected output should be strictly defined
 - Split in to two tests rather than using “If” or “Case”
 - Tests should not contain “While”, “Do While” or “For” loops.
 - If test logic has to be repeated, it probably means the test is too complicated.
 - Call method multiple times rather than looping inside of method.

----

- Do not handle exceptions
  - Indicate expected exception with attribute.
  - Catch only the expected type of exception. 
  - Fail test if expected exception is not caught. 
  - Let other exceptions go uncaught.

----

- Use informative assertion messages
  - By reading the assertion message, one should know why the test failed and what to do.
  - Include business logic information in the assertion message (such as input values, etc.)
  - Good assertion messages:
  - Improve documentation of the code,
  - Inform developers about the problem if the test fails.

----

- Separate test logic from production code
  - Separate Unit tests and Production code in separate projects.
  - Do not create Methods or Properties used only by unit tests.
  - Use Dependency Injection or Mocks to isolate Production code.

----

- Separate tests per business module
  - Create separate test project for every layer or assembly
  - Decrease execution time of test suites by splitting in to smaller suites
  - Suite 1 - All Factories
  - Suite II - All Controllers
  - Smaller Suites can be executed more frequently

----

## Plan

- Introduction
- JUnit
- Guidelines
- Conclusion<!-- .element: class="fragment highlight-blue" -->

----

> «If debugging is the process of removing bugs, then programming must be the process of putting them in» 
[Edsger W. Dijkstra]

----
## Conclusion

- It is impossible to test a program completely.
- Testing cannot prove the absence of bugs.
- Specifications are never final: software is always evolving

----

- Unit tests are also software: use software engineering best practices:
  - modularity, factorization, reuse, etc.
- Maintaining old tests up to date is as important as writing new ones.

----

> « There’s always one more bug» 
[Lubarsky’s Law of Cybernetic Entomology] 


