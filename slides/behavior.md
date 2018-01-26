## Mapping UML Designs to Code
### Behavioral Aspects

----

## Step 8
### State Machine Implementation

----
![](resources/png/open-parenthesis.png)

----
## State Machines

- Represent the behavior of a class (or component) in terms of its reactions to changes form its environment.
- Composed of _States_, connected by _Transitions_, triggered by _Events_

----
### States and Transitions

![](resources/png/uml-states-transitions.png)

----
### Transitions receive and send events, have guards and actions

![](resources/png/uml-events.png)

----

![](resources/png/close-parenthesis.png)

----

## Implementation Approaches

1.  Enumerations/Integers.
2.  _State_ design pattern.

----
## State Machine example

![](resources/png/sm-book.png)
Book States

----
## Enumeration Approach

- Rationale:
    - Use an enumeration to represent states.
    - Verify and change states inside each concerned method.

----

![](resources/png/sm-book.png)<!-- .element: style="width:50%;" -->

![](resources/png/enum-state.png)<!-- .element: style="width:20%;" -->

----

### Enumeration implementation

![](resources/png/enum-state.png)<!-- .element: style="width:20%;" -->

```java
public enum State {

    oredered, available, borrowed, reserved
}
```

----

### Operation Implementation

![](resources/png/sm-book.png)<!-- .element: style="width:50%;" -->

```java
public void returnBook() {
 if (state != State.borrowed) throw new IllegalStateException();

 // TODO

 if(state != State.available && state != State.reserved) 
     throw new IllegalStateException();
}
```

----

## Enumeration Approach Wrap-up

- Easy to implement, fast
- Hard to modify: new states or new transitions impact the whole code

----
## State Pattern Approach

- Apply the _State_ design pattern:
  - Create a class for each State.
  - Delegate the behavior to the these classes
  - Throw an exception when an operation is called in the wrong state.

----

![](resources/png/sm-book.png) <!-- .element: style="width:40%;" -->
![](resources/png/state-pattern.png) <!-- .element: style="" -->

Create a class for each state.

----
```java
public class BookWithStates implements Book {

    private BookState state = new Ordered();

    @Override
    public boolean reserve(Reader aReader) {
        return state.reserve(aReader);
    }

    @Override
    public void deliver() {
        state.deliver();
    }

    @Override
    public void borrow() {
        state.borrow();
    }

    @Override
    public void returnBook() {
        state.returnBook();
    }
}
```

Delegate the behavior to the sate class.

----

```java
public class DefaultBookState implements BookState {

    @Override
    public boolean reserve(Reader aReader) {
        throw new IllegalStateException();
    }

    @Override
    public void deliver() {
        throw new IllegalStateException();
    }

    @Override
    public void borrow() {
        throw new IllegalStateException();
    }

    @Override
    public void returnBook() {
        throw new IllegalStateException();
    }
}
```
Default behavior.

----

```java
class Ordered extends DefaultBookState {

    @Override
    public void deliver() {
        // TODO
    }

    @Override
    public boolean reserve(Reader aReader) {
        // TODO
        return false;
    }
}
```
_Ordered_ State

----
## State pattern Approach Wrap-up

- Harder to implement: class proliferation (1 class per state).
- Easier to modify: new states or new transitions have a limited impact.


----
## Step 9
### Method Implementation

----
## UML Method Specification

- Alternatives
  - Operation pre- and post-conditions
  - Activity diagrams

----
## Operation pre- and post-conditions

- Based on «procedural abstractions».
  - Technique to document/specify **what** the operation does, without indicating **how** it works.

- **Pre-condition**: a statement or set of statements that outlines a condition that should be true, or conditions that should be true, when the operation is called. 
  - The operation is not guaranteed to perform as it should unless the pre-conditions have been met.

----

- **Post-condition**: is a statement or statements describing the condition that will be true when the operation has completed its task. 
  - If the operation is correct and the pre-condition(s) met, then the post-condition is guaranteed to be true.


----
## Pre- and post-conditions in UML

- In UML pre- and post-conditions are precisely specified in [OCL](https://sunye.github.io/ocl/#/)
- OCL states for "The Object Constraint Language"
- It is a pure expression language:
  - An OCL expression is guaranteed to be without side effect. 
  - It cannot change anything in the model.


----

## Example: library operations

![](resources/png/library-interface.png)<!--.element: style="width: 300px;" -->

- Operation `Library::return(bookId:Integer)` 
- **post-conditions**:
  - the book becomes available.
  - the member no longer has the book.

----
In OCL:

```
context Library::return(bookId:Integer)
pre:
  bookId > 0
post:
  let borrowing = self.borrowings->
    select(each| each.book.id = bookId)->last() in
            
  -- the book becomes available
  borrowing.book.oclInState(Available) and
  -- the member no longer has the book
  borrowing.member.books->excludes(borrowing.book)
```


----

![](resources/png/library-interface.png)<!--.element: style="width: 300px;" -->

- Operation `Library::borrow(bookId:Integer, memeberId:Integer):Boolean`
- **post-conditions**:
	- the book is unavailable
	- the member has the book in his borrowed books.
	- the library keeps a trace of the borrowing.

----
In OCL:

```
context Library::borrow(bookId:Integer, memeberId:Integer):Boolean
post:
  let book = self.books[bookId] in
  let member = self.members[memberId] in
  
  -- the book is unavailable
  book.oclInState(Unavailable) and
  
  -- the member has the book in his borrowed books.
  member.borrowed->includes(book) and
  
  -- the library keeps a trace of the borrowing.
  self.borrowings->select(each | each.member = member and 
      each.book = book)->exists(each | each.oclIsNew())
```

----
## Implementing pre- and post-conditions

Rationale:
  - Raise exceptions when pre-conditions are not respected
  - Deduce implementation from post-conditions

----
## Book return operation


```
context Library::return(bookId:Integer)
pre:
  bookId > 0
post:
  let borrowing = self.borrowings->
    select(each| each.book.id = bookId)->last() in
            
  -- the book becomes available
  borrowing.book.oclInState(Available) and
  -- the member no longer has the book
  borrowing.member.books->excludes(borrowing.book)
```
<!--.element: style=" position: absolute; top: 200px; left: -200px; width: 700px;" -->

```java
public void returnBook(Integer bookId) {
 Validate.isTrue(bookId > 0);

 Borrowing borrowing = borrowings.stream()
         .filter(each -> each.book().id() == bookId)
         .findFirst()
         .get();
 borrowing.book().returnBook();
 borrowing.member().borrowed().remove(borrowing.book());
}
```
<!--.element: style=" position: absolute; top: 200px; right: -200px; width: 700px;" -->

----
## Pre- and post-conditions Wrap-up

- Precise and easy to specify (if you know OCL), for simple operations.
- Not adapted for more complex operations: concurrency, distribution, etc.

----
## Activities diagram

- Activity diagrams specify the behavior of a UML Operation.
- They are composed of a set of **Activities** and (data and/or control) **Flows**.

----
![](resources/png/open-parenthesis.png)

----


![](resources/png/uml-activities.png)

----
### Parameters, pre- and post-conditions

![](resources/png/uml-activities-parameter.png)

----
### Data and control flows

![](resources/png/uml-activities-flow.png)<!-- .element: style="width:40%;" -->

----

![](resources/png/close-parenthesis.png)

----
### Book borrow

![](resources/png/borrow-book.png)<!--.element: style="height:600px;" -->

----
### Borrow implementation

![](resources/png/borrow-book.png)<!--.element: style=" position: relative; top: 00px; left: -300px; width: 500px;" -->

```java
public boolean borrow(Integer memberId, Integer bookId) {
 Member member;
 if (!books.containsKey(bookId)) {return false;}

 Book book = books.get(bookId);
 if (!book.isAvailable()) { return false;}
 if (!members.containsKey(memberId)) {
     member = this.registerMember(memberId);
 } else {
     member = members.get(memberId);
     if (member.isMaxQuotaExceed()) {
         return false;
     }
 }
 Borrow borrow = new Borrow(member, book);
 this.borrows.add(borrow);
 return true;
}
```
<!--.element: style=" position: absolute; top: 100px; right: -200px; background-color: blue; width: 700px;" -->

----
## Activities diagram Wrap-up

- Useful to specify complex algorithms.
- Can be very precise.
- Hard to use.

----
## Last Step
### Use Sequence Diagrams to implement tests

----
![](resources/png/open-parenthesis.png)

----
## Sequence diagrams

- Examples of cooperation between objects.
- Illustrate the dynamic sequence of a process through messages exchanged between objects.
- Time is represented as an explicit (vertical) dimension.


----

![](resources/png/uml-sequence.png)<!-- .element: style="height:600px;"-->

----
![](resources/png/close-parenthesis.png)

----
## Book reservation

![](resources/png/sd-reservation.png)

----
### Map Sequence diagrams to test cases

![](resources/png/sd-reservation.png)<!--.element: style=" position: relative; top: 00px; left: -300px; width: 500px;" -->

```java
class LibraryTest {

  private Library lib = new Library();

  @BeforeEach
  void setUp() {
        lib.createMember(42, "Philippe");
        lib.createBook(1, "Baudolino");
  }

  @Test
  void reserve() {
    Calendar date = Calendar.getInstance();
    date.set(2017, 2, 1);
    lib.reserve("Baudolino", 42, date);

    Assertions.assertTrue(lib.reservations()
      .stream()
      .anyMatch(each -> each.member().id() == 42 &&
        each.book().title().equals("Baudolino") &&
        each.date().equals(date))
    );
  }
}
```
<!--.element: style=" position: absolute; top: 100px; right: -200px; background-color: blue; width: 700px;" -->

----
## Sequence diagrams Wrap-up

- Sequence diagrams represent execution traces. 
- They illustrate the collaboration among objects.
- They are not adapted to specify algorithms (conditionals, loops, etc.).

----
## Conclusion

- UML (and its different diagrams) can be useful to specify design details and clarify choices.
- Each diagram has a different proposal, but they all represent the same model.
- Designers and developers must have a clear and common idea about how to map designs to code.


