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
    Validate.isTrue(state == State.borrowed);
    
    // TODO

    Validate.isTrue(state == State.available ||
            state == State.reserved);
}
```

----

## Enumeration Approach Wrap-up

- Easy to implement, fast
- Hard to modify: new states or new transitions impact the whole code


