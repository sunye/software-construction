# Mapping Designs to Code

Mapping Designs to Code
Roadmap
 Identify coding standards
 Identify an implementation strategy
 Implement detailed design
 Perform unit test
 Release for integration
 Implement detailed design
For each component:
Implement component
Implement unit test
For each class in component:
Implement class
Implement unit test
Coding Conventions
Generic conventions (for Java):
Sun/Oracle Code Conventions
Google Java Style Guide
Project specific:
GNU Coding Standards
Mozilla Coding Style Guide
Implementation Strategy
UML lacks semantics: there is no universal rule for mapping design to code
The strategy specifies how to do it.
Different parts: components, classes, attributes, operations, state charts, etc.
Type Correspondence Table
Attribute Implementation
Attribute Accessors
Reflexive Accessors
Class Implementation
Class Implementation
Minimal Interface
Association Implementation
Handshake Problem
Alternative Implementation [Harrison et al. 2000]

Class-Association


Component Implementation
Component Implementation
General idea:
Only the interfaces are public. 
The component inner classes should not be visible (outside their package).
Coding Tips
Avoid Repetition
Avoid Complexity
Keep Things Simple
Avoid Unnecessary Optimizations
Profile first!
Respect the Law of Demeter
Any method of a class should call only methods belonging to:
Its class
The parameters that were passed in to the method
Any objects created by the class
Any attribute referenced object
Global variables
In other words:  do not use objects to get other objects
Learn Code Smells
Code smells are “warnings signs” of deeper problems:
God classes, feature envy, long methods, too many parameters, nested if statements, etc.
Think Globally, Program Locally
Make variables as local as possible and as invisible as possible
If you have the choice between protected or private visibility, choose private.
Making attributes protected gives objects of subclasses access to attributes of their super-classe.
Depend on Interfaces, not on Implementations
Conclusion
Code construction is not only implementation.
It is not a phase of the development process.
References
“Code Complete”. Steve McConnell. 2nd edition. Microsoft Press.
