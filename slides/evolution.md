# Software Evolution

----

## Plan

- Basic Definitions<!-- .element: class="fragment highlight-blue" -->
- Evolution
- Evolution Laws
- Maintenance
- Maintenance Process
- Conclusion

----

«**Software evolution** is the term used in software engineering (specifically software maintenance) to refer to 
all programming activity that is intended to generate a new software version from an earlier operational version.»[Lehman & Ramil 2000]


----


«**Software maintenance** is the modification of a software product after delivery to correct faults, to improve performance or other attributes, or to adapt the product to a modified environment.» [IEEE 610-12-1990]

----

## Evolution and Maintenance

- Often, the terms evolution and maintenance are used interchangeably.
- Some authors consider that maintenance preserves software from failure whereas evolution changes the software from a worse to a better state.
- Others consider maintenance to be set of planned activities whereas evolution concern whatever happens to a system over time.

----

## Types of Software Maintenance

There are 4 types of maintenance, wrt the goal of the maintenance activity:

- Adaptive maintenance 
- Corrective maintenance 
- Perfective maintenance 
- Preventive maintenance

----

«**Adaptive maintenance** is the maintenance activity performed to make a computer program usable in a changed environment.»

- Occurs as a result of external influences or strategic changes.
- For instance:
  - The government creates new taxes or changes the VAT rate.
  - A bank buys another one and their system must be integrated into their own system.

----

«**Corrective maintenance** is the maintenance activity performed to correct faults in hardware or software.»

- Occurs when customers detect a deviation of the software from its expected behavior, which was not detected during development.

----

«**Perfective maintenance** is the maintenance activity performed to improve the performance, maintainability, or other properties of software.»

- Occurs after the deployment, when costumers ask for minor improvements in the software.
- For instance:
  - Better validation, simpler data input, better performance.

----

«**Preventive maintenance** is the maintenance activity performed for the purpose of preventing problems before they occur.»


----

«A **legacy software** system is any system that significantly resists modifications and changes while remaining of significant value for its owner. The system might have been developed using an outdated programming language or an obsolete development method. Most likely, it has changed hands several times and shows many signs of degradation.»

![](resources/jpg/legacy-code.jpg)<!-- .element: style=" width:300px;"-->

----

«Legacy code often differs from its suggested alternative by actually working and scaling.»

[Bjarne Stroustrup's FAQ: What is "legacy code"?]

----

«**Reengineering** is the examination and alteration of a subject system to reconstitute it in a new form and the subsequent implementation of the new form. Reengineering generally includes some form of reverse engineering (to achieve a more abstract description) followed by some form of forward engineering or restructuring. This may include modifications to fulfill new requirements not met by the original system.»

![](resources/png/reengineering.png)

----

«**Forward engineering** is the traditional process of moving from high-level abstractions and logical, implementation-independent designs to the physical implementation of a system.»

----

**Reverse engineering** is the process of analyzing a subject system to identify its components and their interrelationships and to create representations of the system in another form or at a higher level of abstraction. Reverse engineering generally involves extracting design artifacts and building or synthesizing abstractions that are less implementation-dependent.

![](resources/png/reverseengineer.png)<!-- .element: style=" width:300px;"-->

----

## Plan

- Basic Definitions
- Evolution<!-- .element: class="fragment highlight-blue" -->
- Evolution Laws
- Maintenance
- Maintenance Process
- Conclusion

----

## Software Aging

«Programs, like people, get old. We cannot prevent aging, but we can understand its causes, take steps to limit its effects, temporarily reverse some of the damage it has caused, and prepare for the day when the software is no longer viable.»

----

«A sign that the software engineering profession has matured will be that we lose our preoccupation with the first release and focus on the long-term health of our products. Researchers and practitioners must change their perception of the problems of software development. Only then will software engineering deserve to be called *engineering*.» [Parnas, 1994]

note:
David Parnas
[http://ieeexplore.ieee.org/document/296790/]

----
## Why software ages?

- Maintenance activities.
- Ignorant surgery and architectural erosion.
- Inflexibility from the start.
- Insufficient or inconsistent documentation.
- Deadline pressure.
- Duplicated functionality (code duplication)
- Lack of modularity

----

## Software Change is inevitable!

- New requirements emerge when the software is used
- The business environment changes
- Errors must be repaired
- New computers and equipment are added to the system
- The performance or reliability of the system may have to be improved


- A key problem for all organizations is implementing and managing change to their existing software systems. <!-- .element: class="fragment" -->


----

## Importance of Evolution

- Organizations have huge investments in their software systems -- they are critical business assets
- To maintain the value of these assets to the business, they must be changed and updated
- The majority of the software budget in large companies is devoted to changing and evolving existing software rather than developing new software

----

## Changes Induce Technical Debt

- As a change is started on a software system, often there is a need to make other coordinated changes at the same time in other parts of the software.
- These other required changes, if not completed immediately, incur a kind of debt that must be paid at some point in the future.
- This technical debt is “the extra development work that arises when code that is easy to implement in the short run is used instead of applying the best overall solution”.

----

- Just like financial debt, if technical debt is not repaid, the uncompleted changes accumulate interest on top of interest, because of increased entropy.
- The longer you wait to make the changes, the harder it becomes.

----

## Change is Hard to Anticipate

- Many changes cannot be anticipated at design time: 

«The fundamental problem, supported by 40 years of hard experience, is that many changes actually required are those that the original designers cannot even conceive of.»

[Bennett & Rajlich 2000]

----

- The Heisenberg principle of software development:

«Requirements start changing from the moment you start building or using a software system»

- Key challenge for organizations: implementing and managing change to their existing software systems

----

## Software Evolution

- Evolution may arise:
  - **During software development**, where the design evolves and matures as the understanding of the problem to be solved and how to solve it gradually increases

----

- Evolution may *also*  arise:
  - **During software maintenance**: after deployment, in the continuing process of adapting the system to the changing needs of its users and usage environment
  - **When the system’s continuous evolution made it too complex to maintain**: the system may requiring a more extensive restructuring, redesign or even a full reimplementation or replacement


----

## Static vs. Dynamic Software Evolution

- **Static evolution**
  - changes are applied manually by a human programmer
  - part of the software gets adapted or replaced by a programmer and the evolved software is redeployed
- **Dynamic evolution**
  - changes are applied automatically at runtime
  - to better suit the current needs of the software system
  - by automatically generating, adapting, transforming or selecting parts of the software
  - e.g., self-adaptive systems, context-oriented programming, etc.

----

## Plan

- Basic Definitions
- Evolution
- Evolution Laws<!-- .element: class="fragment highlight-blue" -->
- Maintenance
- Maintenance Process
- Conclusion

----

## Laws of Software Evolution

- In 1965, Mark Halpern used the term *evolution* to define the dynamic growth of software.
- The term evolution in relation to application software took gradually in the 1970s.
- Lehman and his collaborators from IBM are generally credited with pioneering the research field of software evolution.
- Lehman formulated a set of observations that he called *laws of evolution*.

https://en.wikipedia.org/wiki/Lehman%27s_laws_of_software_evolution

----

- These laws are the results of studies of the evolution of large-scale proprietary or closed source system (CSS).
- The laws concern what Lehman called E-type systems: «Monolithic systems produced by a team within an organization that solve a real world problem and have human users.»

----

### Continuing change (1st law) 

«A software system that is used in a real-world environment must necessarily change, or else become progressively less useful in that environment.»

note:
Reasons:
Evolution of the environment (“operational domain”)
Hence, increasing mismatch between the system and its environment
Continuous need for change because requirements and environment continuously evolving

----

### Increasing complexity (2nd)

«As an evolving software system changes, its structure tends to become more complex. Extra resources must be devoted to preserving and simplifying the structure.»

note:
Reasons:
Inspired by the second law of entropy in thermodynamics.
Unaddressed technical debt increases entropy.
Small changes are applied in a step-wise process; each ‘patch’ makes sense locally, not globally
Effort needed to address accumulated technical debt; a more significant restructuring or refactoring may be needed

----

### Self-regulation (3rd) 

«Software evolution is a self-regulating process. Software properties such as size, time between releases, and the number of reported errors is approximately invariant for each system release.»

----

### Conservation of organizational stability (4th) 

«Over a software system’s lifetime, its rate of development is approximately constant and independent of the resources devoted to its development.»

----

### Conservation of familiarity (5th)

«The amount of incremental change in each successive release of a software system tends to stay constant or decrease over time.»

----

### Continuing growth (6th) 

«The amount of functionality in a software system will increase over time, in order to satisfy its costumers.»

note:
Related to the first law, but with focus on functional requirements often one cannot afford to omit existing functionality
“omitted attributes will become the bottlenecks and irritants in usage as the user has to replace automated operation with human intervention. Hence they also lead to demand for change”

----

### Declining quality (7th)

«A software system will be perceived as losing quality over time, unless its design is carefully maintained and adapted to new operational constraints.»

note:
Related the first law, but with focus on observed reliability

----

### Feedback system (8th) 

«Successfully evolving a software system requires recognition that the development process is a multi-loop, multi-agent, multi-level feedback system.»

----

## Applicability of Lehman’s laws

- Lehman’s laws seem to be generally applicable to large, tailored systems developed by large organizations.
- Confirmed in early 2000’s by work by Lehman on the FEAST project.
- It is not clear how they should be modified for
  - Shrink-wrapped software products;
  - Systems that incorporate a significant number of COTS components;
  - Small organizations;
  - Medium sized systems.

note:
  COTS - Commercial off-the-shelf,
  Shrink-wrapped:  Computing (of a product) sold commercially as a ready-made software package.

----

## Plan

- Basic Definitions
- Evolution
- Evolution Laws
- Maintenance<!-- .element: class="fragment highlight-blue" -->
- Maintenance Process
- Conclusion

----

## Maintenance process

«You cannot manage what you cannot control, and you cannot control what you do not measure. »

[Tom DeMarco - Controlling Software Projects, 1982]

----

## Metrics

- An objective view of a software system is essential
- Often, maintainers have a biased view (they only see problems)
- Metrics give an unbiased view of the system

----

## Some metrics for Maintenance

- System size (eg: LOC)
- Effort (eg: man/hour)
- Schedule (eg: start/end dates)
- Quality (eg: number of errors)

----

## Be Careful with Metrics

- Need to be analyzed in context
- Not an end but a mean (not a goal but a tool)

----

## Software is knowledge

- Contains a lot of knowledge about the world
- 40% to 60% of maintenance is spent reading (understanding) the code
- Maintenance needs this knowledge

----

## Types of knowledge

- Application Domain:
  - Business rules, processes, etc.
- Organizational structure
  - Positions, responsibilities, roles, hierarchy, etc.
- Processes
  - Activities, generated artifacts.
- Software system itself
  - Documents, Components, Architecture
- Techniques and tools
  - OOP, AOP, SPL, MDE, IDE, compilers, etc.

----

## Saving knowledge

- A good part of software development is spent on acquiring this knowledge and putting it in the system.
- Then, developers forget or go away: the knowledge only exists in the software.
- A good part of maintenance is spent on re-acquiring this knowledge, to understand the system to change it

- It is important to try to save this knowledge: code comments, architecture and design models, wiki, formal specifications, etc.

----

## Plan

- Basic Definitions
- Evolution
- Evolution Laws
- Maintenance
- Maintenance Process<!-- .element: class="fragment highlight-blue" -->
- Conclusion

----

## Software Maintenance Process

![](resources/jpg/software-maintenance-process.jpg)

[IEC 14764]

----


The maintenance process comprises the following high level activities:


<!-- .slide: style="text-align: left;"> -->  

1. Process Implementation.
2. Problem and Modification Analysis.
3. Modification Implementation.
4. Maintenance Review and Acceptance.
5. Migration.
6. Retirement.

<p class="current-visible"
style="position:absolute; left:700px; top:100px;">
<img src="resources/jpg/software-maintenance-process.jpg" width="75%"></p>

----

### Process Implementation

- Software and organization need to be prepared
- Prepare maintenance when development starts
- Prepare software:
  - Where is the source code?
  - Is there documentation? How to make change (VCS)?
- Prepare organization: 
  - What is the maintenance process? 
  - Who is responsible of what?


----

### Problem and Modification Analysis

- **1** Analyze and confirm request

  - Reproduce  (with a test - TDD)
  - Classify  (adaptive, corrective, emergency corrective, etc.)
  - Check its validity (Real bug? Needed new feature?)
  
- **2** Propose a solution
  - Estimate costs, plan (schedule)
  - Consider several possible solutions and compare them objectively

----

- **3** Document the request and the solution proposal
  - Software is knowledge!
  - Documentation can take several forms (models, comments, wiki, formal document, commit message, etc.)

- **4** Obtain authorization to apply solution
  - You might be the authorizing authority (simplified process)

----

### Modification Implementation

- Implement solution
  - Bug fix for corrective maintenance
  - Development process for evolution

- Test modification and system
  - Regression testing (did not break some other part of the system)

----

### Maintenance Review and Acceptance

- Review and approval
- Might require formal approval (ex: Quality Assurance authority)

----

### Migration

- Large modification
  - Potentially affects all users
  
- Might change more than the software
  - Hardware, OS, DB, ...

----

- Plan
  - When, who, why
  - Parallel operations
  - Data conversion
  - Backup old version, old data

- Notify
  - Identify affected people 
  - Notify in advance 
  - Notify when finished

----

### Retirement

- End of life of software system
  - Similar to migration
  - Plan, Notify, Parallel operation, Archive


----

## Plan

- Basic Definitions
- Evolution
- Evolution Laws
- Maintenance
- Maintenance Process
- Conclusion<!-- .element: class="fragment highlight-blue" -->

----

## Maintenance Misconceptions

- Perfect development can eliminate maintenance.
- New technologies and tools will reduce maintenance.
- Maintenance is difficult and boring

----

## Conclusion

- Software evolution is very important
- Typically ill-perceived
- There is an important cultural problem (misunderstanding)


----

## References

- ISO/IEC 74764 IEEE Std. 74764-2006, Software Engineering—Software Life Cycle Processes—Maintenance, IEEE, 2006; doi: 10.1109/IEEESTD.2006.235774. K.H. Bennett and V.T. Rajlich, “Software Maintenance and Evolution: A Roadmap,” in Proc. Conf. Future of Software Eng., ACM Press, 2000, pp. 73-87; doi: 10.1145/336512.336534. 
- N. Chapin , “Types of Software Evolution and Software Maintenance,” J. Software Maintenance and Evolution: Research and Practice, vol. 13, no. 1, 2001, pp. 3-30; doi: 10.1002/smr.220.

----

- E.J. Chikofsky and J.H. Cross, “Reverse Engineering and Design Recovery: A Taxonomy,” IEEE Software, vol. 7, no. 1, 1990, pp. 13-17; doi: 10.1109/52.43044.
- M. M. Lehman, L. Belady. Program Evolution: Processes of Software Change. Academic Press, London, 1985, 538pp. https://dl.acm.org/citation.cfm?id=7261