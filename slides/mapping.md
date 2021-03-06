## Mapping UML Designs to Code
### Structural Aspects

----
## Plan

- Introduction
- Creating an Implementation Strategy
- Classes
- Attributes
- Associations


----

## Mapping Designs to Code

Translating a UML model to object-oriented source code is a difficult task:
- UML has several diagrams representing different aspects of the model.
- The mapping from UML concepts (classes, associations, signals, states, operations, etc.) to OO concepts (classes, fields, and methods) is not trivial.
- UML lacks semantics: there is no universal rule for mapping design to code.
- The developer needs an «Implementation Strategy» to guide the translation. <!-- .element: class="fragment highlight-red" -->

[comment]: # (UML Model => Object-Oriented Source Code)

----
## Implementation Strategy

- A set of rules that specifies how to translate design models to code.
- Different parts: components, classes, attributes, operations, state charts, etc.
- A correspondence table between UML types and the target language types.
- Occasionally: a specific UML profile (set of tags and stereotypes), generation templates, configurations, etc.

----
## Implementation Roadmap
 
- For each component:
  1. Implement component
  1. Implement unit test
  1. For each class in component:
    1. Implement class
    1. Implement unit tests

----

## Plan

- Introduction
- Creating an Implementation Strategy
- Classes
- Attributes
- Associations

----
##  Creating an Implementation Strategy

1. Rules for class implementation.
1. Type correspondence table.
2. Rules for multi-valued attribute implementation.
3. Rules for multi-valued attribute implementation.
3. Rules for unidirectional association implementation.
3. Rules for bidirectional association implementation.

----
## Plan

- Introduction
- Creating an Implementation Strategy
- Classes
- Attributes
- Associations

----
## Step 1
### Class Implementation

----
## Class Implementation

Approaches:

1. Simple correspondence.
  - For each UML class, create a Java class.
2. Class-Interface.
  - For each UML class, create a pair (class, interface)
3. Generation Gap.
  - For each UML class, create a triple (interface, abstract class, concrete class)


----
## Simple Correspondence Approach
### For each UML class, create a Java class.

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:350px; width:300px;" -->



```java
public class HTMLPage  {
    // (...)
}
```
<!-- .element: style="position:absolute;  left:320px; top:400px; width:750px" -->



----
## Class-Interface Approach
### For each UML class, create a pair (class, interface)

![](resources/png/htmlpage-interface.png)

Here,  «Implementation Model» is a graphical representation for Java.

note:
Yes, UML can also be used to represent implementation models.

----
### For each UML class, create a pair (class, interface)

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:300px;" -->

```java
public interface HTMLPage {
    // (...)
}

public class BasicHTMLPage implements HTMLPage {
    // (...)
}
```
<!-- .element: style="position:absolute;  left:320px; top:200px; width:750px" -->


----
## Class-Interface Approach Wrap-up

- Useful when the class `HTMLPage` is used in different contexts: DAO, RPC, Persistence, Tests, etc.

----
## Generation Gap Approach

- Based on the «Generation Gap» pattern.

----
### For each UML class, create a triple (interface, abstract class, concrete class)

![](resources/png/htmlpage-generation-gap.png)


----
### For each UML class, create a triple (interface, abstract class, concrete class)

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:200px;" -->

```java
public interface HTMLPage {
    // (...)
}

public abstract class BasicHTMLPage implements HTMLPage {
    // (...)
}

public class UserHTMLPage extends BasicHTMLPage {
    // (...)
}
```
<!-- .element: style="position:absolute;  left:220px; top:200px; width:750px" -->

----
## Generation Gap Wrap-up

- Useful in a automatic code generation context:
  - The subclass `UserHTMLPage` is only generated once. 
  - User code is never overwritten.
- Class/Interface proliferation.

----
## Approach extension
### Use a common interface

![](resources/png/common-interface.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:200px;" -->

```java
public interface Common {
	Common copy();
	Common deepCopy();
	boolean equals(Common);
	String toString();
}
```
<!-- .element: style="position:absolute;  left:220px; top:200px; width:750px" -->

----
## Common Interface

- Facility methods available for all objects.
- Can be extended with _reflexion_ methods, e.g., 
  - `get(String attrName)`
  - `call(String methodName)`
  - etc.

----
## Step 2
### Propose a type correspondence table

----
## UML Types

Base UML only has 5 primitive types. However, new datatypes can be added using «profiles».

Type | Values
--|--
Integer | -1, 0, 1, 2, ...
Boolean | true, false
UnlimitedNatural | 0, 1, *
String | "to be or not to be"
Real | 1.5, 3.14, ...

----
##  Correspondence Table (example)

UML	| Java | MySQL | TypeScript
--|-- 
`Integer` | `java.lang.Integer` | `BIGINT` | `number`
`Boolean` | `java.lang.Boolean` | `BOOLEAN` | `boolean`
`UnlimitedNatural` | `java.lang.Integer` | `TINYINT` | `number`
`String` | `java.lang.String` | `VARCHAR` | `string`
`Real` | `java.lang.Double` | `REAL` | `number`



note:
Since few projects have several target languages, what is the point of using “neutral” datatypes?
Independently from the choice, it is important to mention that it is difficult to be precise if we only use the 4 UML datatypes!
This table can be improved using stereotypes, tags, OCL invariants, etc.

----
##  Another Correspondence Table

UML	| Java 
--|-- 
`Integer` | `int` 
`Boolean` | `boolean` 
`UnlimitedNatural` | `int` 
`String` | `java.lang.StringBuilder` 
`Real` | `double` 

----
## Plan

- Introduction
- Creating an Implementation Strategy
- Classes
- Attributes
- Associations

----

## Step 3
### Monovalued Attribute Implementation

----

![](resources/png/open-parenthesis.png)

----

## UML Attributes

Attributes are a typed structural property, which specify the structure of all instances of a given classifier.

![](resources/png/htmlpage.png)


----

### Attributes are mono-  or multi-valued.

![](resources/png/person.png)

```
code : Integer [1]
-- monovalued mandatory attribute. 
-- e.g.: 1; 2; 99.

last name : String [0..1]
-- monovalued optional attribute. 
-- e.g.: null;  "john"; "paul".
    
first names : String [*]
-- multivalued attribute. 
-- e.g.: {}, {"john", "paul"}, {"ringo", "george"}
```

----
### Attributes  have properties

![](resources/png/person-properties.png)

```
Properties: readOnly, union, subsets <p>, redefines <p>, 
    ordered, unordered, unique, nonunique, seq, sequence, id
```

----
### Attributes have visibilities

Symbol | Visibility
--|--
`+` | Public
`#` | Protected
`~` | Package
`-` | Private

----
### Attributes have constraints

![](resources/png/person-constraints.png)

Constraints respect the [OCL](https://sunye.github.io/ocl/) syntax.

----
### Attributes can be derived from others

![](resources/png/person-age.png)

Derived attributes are specified in [OCL](https://sunye.github.io/ocl/).


----

![](resources/png/close-parenthesis.png)

----

## Mono-valued Attribute Implementation

- Different approaches:
    1. Naive implementation.
    2. Getters and Setters.
    3. Attribute Wrappers.

----

## Naive approach
- Rationale:
    - UML Attribute = Java Field
    - Same visibility
    - Read-only attribute = final field

![](resources/png/htmlpage.png)<!-- .element: style="width: 30%;" -->


----

![](resources/png/htmlpage.png)<!-- .element: style="width: 30%;" -->

```java
public class HTMLPage {
	public final String title;
	Integer version;
	protected String contents;
	private Boolean visibility = new Boolean(true);
}
```

----
## Naive Approach Drawbacks

![](resources/png/htmlpage.png)<!-- .element: style="width: 20%;" -->

- Cannot handle:
  - Derived attributes.
  - Constraints.


----

## Getters/Setter approach

![](resources/png/htmlpage.png)<!-- .element: style="width: 20%;" -->

- Rationale:
  - For each mono-valued attribute:
    - Create a private field for each non-derived attribute.
    - Create a getter method for each attribute, respecting the visibility.
    - Create a setter method for each non read-only, non derived attribute.



----
### Create a private filed for each non-derived attribute.

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->

```java
public class HTMLPage {
	private final String title;
	private Integer version;
	private String contents;
	private Boolean visibility = new Boolean(true);
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create a getter method for each attribute, respecting the visibility.

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->



```java
public class HTMLPage {
	public String getTitle() {
		return title;
	}
	public Integer getSize() {
		return contents.size();
	}
	Integer getVersion() {
		return version;
	}
	protected String getContents() {
        return contents;
    }
    private Boolean getVisibility() {
        return visibility;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create a setter method for each non read-only, non derived attribute.
![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->



```java
public class HTMLPage {
    void setVersion(Integer aVersion) {
        version = aVersion;
    }
    protected void setContents(String str) {
        contents = str;
    }
    private void setVisibility(Boolean bool) {
        visibility = bool;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
## Getter/Setter Approach Wrap-up

- All fields are private.
- Visibility is ensured by method access. 
- Getters and Setters can implement read-only and derived attributes. 

----
## Attribute Wrapper  Approach

![](resources/png/htmlpage.png)<!-- .element: style="width: 20%;" -->

- Rationale:
  - Create a _wrapper_ class for attribute types.
  - For each mono-valued attribute:
    - Create a private field for each non-derived attribute.
    - Create an accessor method for each attribute, respecting the visibility.

----
### Create a _wrapper_ class for  attribute types

![](resources/png/htmlpage.png)

<!-- .element: style="position:absolute; left:0px; top:200px; width:20%;" -->

```java
public class Attribute<T> {
    private T value;
    public Attribute();
    public Attribute(T t) {
        value = t;
    }
    public void set(T newValue) {
        value = newValue;
    }
    public T get() {
        return value;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----

### Read-only attributes

![](resources/png/htmlpage.png)

<!-- .element: style="position:absolute; left:0px; top:200px; width:20%;" -->

```java
public class ReadOnlyAttribute<T> {
    private final T value;
    public Attribute(T t) {
        value = t;
    }
    public void set(T newValue) {
        throw new UnsupportedOperationException();
    }
    public T get() {
        return value;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Derived attributes

![](resources/png/htmlpage.png)

<!-- .element: style="position:absolute; left:0px; top:200px; width:250px;" -->

```java
public class SizeAttribute<T> {
    private final Attribute<String> contents;
        
    public SizeAttribute(Attribute<String> attr) {
        contents = attr;
    }
    public void set(T newValue) {
        throw new UnsupportedOperationException();
    }
    public T get() {
        return contents.get().size();
    }
}
```
<!-- .element: style="position:absolute;  left:260px; top:200px; width:750px" -->

----
### Create a private filed for each non-derived attribute.

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute; left:0px; top:200px; width:250;" -->

```java
public class HTMLPage {
	private final Attribute<String> title = 
        new ReadOnlyAttribute<String>();
	private final Attribute<Integer> version = 
        new Attribute<Integer>();
	private final Attribute<String> contents = 
        new Attribute<String>();
	private final Attribute<Boolean> visibility = 
        new Attribute<Boolean>(true);
    private final SizeAttribute<Integer> size = 
        new SizeAttribute(contents);
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create an accessor method for each attribute, respecting the visibility.

![](resources/png/htmlpage.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->

```java
public class HTMLPage {
	public Attribute<String> title() {
		return title;
	}
	public SizeAttribute<Integer> size() {
		return size;
	}
	Attribute<Integer> version() {
		return version;
	}
	protected Attribute<String> contents() {
        return contents;
    }
    private Attribute<Boolean> visibility() {
        return visibility;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
## Attribute Wrapper  Approach Wrap-up

- All fields are private.
- Visibility is ensured by method access.
- Class/object multiplication. 
- Wrappers can implement read-only and derived attributes, but a specific class may be necessary.
- Extensible: other methods/behaviors can be implemented, e.g. `reset()`

----
## Step 4
### Multi-valued Attribute Implementation


----

![](resources/png/open-parenthesis.png)

----

### Multi-Valued Attributes  have properties

![](resources/png/patient-properties.png)


----

![](resources/png/close-parenthesis.png)

----
## Multi-valued Attribute Implementation

- Different approaches:
    1. Naive implementation.
    2. Getters and Setters.
    3. Attribute Wrappers.

----
## Naive approach

- Rationale:
    - UML Attribute = Java Field
    - Same visibility
    - Relay on the Java Collections Framework, [JCF](https://en.wikipedia.org/wiki/Java_collections_framework)

<!-- .element: style="position:absolute;  left:000px; top:200px; width:750px" -->


![](resources/png/patient.png)<!-- .element: style="position:absolute;  right:0px; top:100px; width:30%;" -->


----

![](resources/png/patient.png)

<!-- .element: style="position:absolute; left:000px; top:200px; width:250px; "-->

```java
public class Patient {
	public final Set<String> pathologies =
        new HashSet<String>;
	public final Collection<String>  exams =
        new ArrayList<String>();
	public final List<Double> temperatures =
        new ArrayList<Double>;
	public final Collection<String> notes =
        new ArrayList<String>();
}
```
<!-- .element: style="position:absolute;  left:260px; top:200px; width:750px" -->

----

## Naive Approach Drawbacks

![](resources/png/patient.png)<!-- .element: style="width: 20%;" -->


- Cannot handle:
  - Multiplicities.
  - Constraints.


----

## Getters/Setter approach

![](resources/png/patient.png)<!-- .element: style="width: 20%;" -->

- Rationale:
  - For each multi-valued attribute:
    - Create a private field for each non-derived attribute.
    - Create `add()`, `remove()`, and `get()` methods for each attribute, respecting the visibility.

----

### Create a private field for each non-derived attribute.
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->


```java
public class Patient {
	private final Set<String> pathologies =
        new HashSet<String>();
	private final Collection<String>  exams =
        new ArrayList<String>();
	private final List<Double> temperatures =
        new ArrayList<Double>();
	private final Collection<String> notes =
        new ArrayList<String>();
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----

### Create a `add()` method for each attribute
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->


```java
public class Patient {
    public boolean addPathologie(String str) {
        return this.pathologies.add(str);
    }
    public boolean addExam(String str) {
        return this.examns.add(str);
    }
    public boolean addTemperature(Double d) {
        return this.temperatures.add(d);
    }
    public boolean addNote(String str) {
        if (notes.size == 5) return false;
        return this.notes.add(str);
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create a `remove()` method for each attribute
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->


```java
public class Patient {
    public boolean removePathologie(String str) {
        return this.pathologies.remove(str);
    }
    public boolean removeExam(String str) {
        return this.examns.remove(str);
    }
    public boolean removeTemperature(Double d) {
        return this.temperatures.remove(d);
    }
    public boolean removeNote(String str) {
        return this.notes.remove(str);
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create a `get()` method for each attribute
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->


```java
public class Patient {
    public String getPathologie(int i) {
        return this.pathologies.get(i);
    }
    public String getExam(int i) {
        return this.examns.get(i);
    }
    public Double getTemperature(int i) {
        return this.temperatures.get(i);
    }
    public String getNote(int i) {
        return this.notes.get(i);
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
## Getter/Setter Approach Wrap-up

- All fields are private.
- Visibility is ensured by method access. 
- Getters and Setters can implement maximum multiplicity checks.
- Limited interface for dealing with collections: only 3 methods vs. 25 for Java `List` interface.
- Method proliferation.

----
## Attribute Wrapper  Approach

![](resources/png/patient.png)<!-- .element: style="width: 20%;" -->

- Rationale:
  - Create a _wrapper_ class for attribute types.
  - For each multi-valued attribute:
    - Create a private field for each attribute.
    - Create an accessor method for each attribute, respecting the visibility.

----
### Create a _wrapper_ class for attribute types
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->

```java
public class MultivaluedAttribute<T> {
    private final List<T> values;
    
    public MultivaluedAttribute(List<T> l) {
        this.valued = l;
    }
    
    public boolean add(T t) {
        return this.values.add(t);
    }
    
    public boolean remove(T t) {
        return this.values.remove(t);
    }
    
    // (...)
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create a private field for each attribute
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->

```java
public class Patient {
	private final MultivaluedAttribute<String> pathologies =
        new MultivaluedAttribute<String>(new HashSet<String>());
            
	private final MultivaluedAttribute<String>  exams =
        new MultivaluedAttribute<String>(new ArrayList<String>());
        
	private final MultivaluedAttribute<Double> temperatures =
        new MultivaluedAttribute<double>(new ArrayList<Double>());
        
	private final MultivaluedAttribute<String> notes =
        new MultivaluedAttribute<String>(new ArrayList<String>());
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
### Create an accessor method for each attribute, respecting the visibility.
![](resources/png/patient.png)<!-- .element: style="position:absolute;  left:0px; top:200px; width:20%;" -->

```java
public class Patient {
    public MultivaluedAttribute<String> pathologies() {
        return this.pathologies;
    }
    public MultivaluedAttribute<String> exams() {
        return this.examns;
    }
    public MultivaluedAttribute<Double> temperature() {
        return this.temperatures;
    }
    public MultivaluedAttribute<String> notes() {
        return this.notes;
    }
}
```
<!-- .element: style="position:absolute;  left:250px; top:200px; width:750px" -->

----
## Attribute Wrapper Approach Wrap-up

- All fields are private.
- Visibility is ensured by method access.
- Class/object proliferation. 
- Wrappers can implement read-only and derived attributes, but a specific class may be necessary.
- Wrappers can implement maximum multiplicity checks.
- Extensible: other methods/behaviors can be implemented, e.g. the Java `List` interface.

----
## Plan

- Introduction
- Creating an Implementation Strategy
- Classes
- Attributes
- Associations

----

## Step 5
### Unidirectional Association Implementation

----
![](resources/png/open-parenthesis.png)

----
## UML Associations

- An association between two (or more) classes represents a **stable link** between two (or more) objects, instances from theses classes.

![](resources/png/uml-association-terms.png)

----
### Associations have directions

![](resources/png/uml-association-directions.png)

----
### Associations have properties

![](resources/png/uml-association-properties.png)

----
![](resources/png/close-parenthesis.png)

----

## Unidirectional  Associations

- Different approaches:
    2. Getters and Setters.
    3. Cursors.

----
## Getters and Setters

- Rationale
  - Monovalued roles ([0..1], [1]): similar to attributes.
  - Multivalued roles ([0..2], [*], etc.): use the `Collection` interface:
    - Applies the ([Decorator](https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm) design pattern.
  - Visibility is ensured by accessor visibilities. 

![](resources/png/client-account-card.png) <!-- .element: style="width:60%;" -->

----
![](resources/png/card-account.png)

```java
public class Card {
    private Account account;
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account anAccount) {
        this.account = anAccount;
    }
}

```

----
![](resources/png/folder-pages-uni.png)

```java
public class HTMLFolder {

    private Collection<HTMLPage> pages = new PageCollection(new HashSet<HTMLPage>());

    public Collection<HTMLPage> getPages() {
        return pages;
    }
}
```

----

```java
public class PageCollection implements Collection<HTMLPage> {

    private Collection<HTMLPage> pages;

    public PageCollection(Collection<HTMLPage> list) {
        this.pages = list;
    }

    public int size() {
        return pages.size();
    }

    public boolean isEmpty() {
        return pages.isEmpty();
    }

    public boolean contains(Object o) {
        return pages.contains(o);
    }

    public Iterator<HTMLPage> iterator() {
        // TODO: Implement the Iterator!
        return pages.iterator();
    }

    public Object[] toArray() {
        return pages.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return pages.toArray(a);
    }

    public boolean add(HTMLPage htmlPage) {
        return pages.add(htmlPage);
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return pages.containsAll(c);
    }

    public boolean addAll(Collection<? extends HTMLPage> c) {
        return pages.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends HTMLPage> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return pages.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return pages.retainAll(c);
    }

    public void clear() {
        pages.clear();
    }

    public HTMLPage get(int index) {
        return get(index);
    }

    public HTMLPage set(int index, HTMLPage element) {
        return set(index, element);
    }

    public boolean remove(int index) {
        return pages.remove(index);
    }


    public int lastIndexOf(Object o) {
        return lastIndexOf(o);
    }

}
```


----
## Getter/Setter Approach Wrap-up

- Mono- and multi-valued roles have different interfaces.
- The `Collection` decorator allows the addition of new behavior:
  - Upper-bound multiplicity check.
  - Constraints.
- Unique roles may use the JCF `Set` implementations (`HashSet`, `TreeSet`, etc.).

----
## «Cursors» Approach
- Rationale:
  - Mono- and multi-valued roles use the same interface, the `Cursor`.
  - Cursors are specific to each role.

![](resources/png/cursor.png)<!-- .element: style="position:absolute; right:0px; width:200px;" -->


----

![](resources/png/folder-files.png)

![](resources/png/file-cursor.png)<!-- .element: style="width:40%;"-->

----

![](resources/png/folder-files.png)

```java
public interface Folder {

    String getName();
    void setName(String aName);

    FileCursor files();
}
```

----

![](resources/png/folder-files.png)

```java
public interface File {

    Integer getSize();
    void setSize(Integer aSize);

    String getName();
    void setName(String aName);
}
```

----
### FileCursor

```java
public class FileCursor implements Cursor<File>, File {

    Collection<File> files;
    Optional<File> current;

    public FileCursor(Collection<File> aCollection) {
        files = aCollection;
    }

    @Override
    public Integer getSize() {
        if (current.isPresent()) {
            return current.get().getSize();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void setSize(Integer aSize) {
        if(!current.isPresent()) {
            throw new IllegalStateException();
        }
        current.get().setSize(aSize);
    }

    @Override
    public String getName() {
        if (current.isPresent()) {
            return current.get().getName();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void setName(String aName) {
        if(!current.isPresent()) {
            throw new IllegalStateException();
        }
        current.get().setName(aName);
    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public void next() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void insert(File file) {

    }
}
```


----
## Cursors Approach Wrap-up

- Mono- and multi-valued roles have the same interface.
  - Is it a good thing?
- Cursors have less methods than Collections.
- Cursors allow the addition of new behavior:
  - Upper-bound multiplicity check.
  - Constraints.
- Unique roles may use the JCF Set implementations (HashSet, TreeSet, etc.).
- Respects the «Demeter» law.


----
## Step 6 
### Bidirectional  Association Implementation

----

![](resources/png/open-parenthesis.png)

----
## Handshaking

![](resources/png/folder-files-bi.png)

- Referential integrity
  - A file cannot belong to two folders at the same time.
  - Adding a file to a folder should have the same effect as setting the folder of a file.


----

![](resources/png/snapshot1.png)

```java
doc.setFolder(archive)
```

```java
archive.getFiles().add(doc)
```

----

![](resources/png/snapshot2.png)

----

![](resources/png/snapshot3.png)

----

![](resources/png/close-parenthesis.png)

----
## Bidirectional  Associations

- Different approaches:
    2. Getters and Setters.
    3. Cursors.

----
## Bidirectional  Associations
### Simple Case

![](resources/png/folder-files-bi-readonly.png)

----

![](resources/png/folder-files-bi-readonly.png)

```java
public class File {
    private Folder folder;

    public File(Folder aFolder) {
        folder = aFolder;
    }

    public Folder getFolder() {
        return folder;
    }
}
```

----

## Bidirectional  Associations

![](resources/png/folder-files-bi.png)

- To ensure the integrity:
  - `file.setFolder(folder)` must call `folder.getFiles().add(file)` **and**
  - `folder.getFiles().add(file)` must call `file.setFolder(folder)` 
  - Problem: How to avoid the loop ? <!-- .element: class="fragment"-->


----

### Solution 1: let the client call both
```java
Folder folder = new Folder();
File file = new File();

file.setFolder(folder);
folder.getFiles.add(file);
```

----
### Problems

- All clients must respect this rule.
- Difficult to ensure during the class lifetime.

----
### Solution 2: use auxiliary methods

- Add a method called `basicSet(Folder)` to the class `File`.
- Add a method called `basicAdd(File)` to the class `FileCollection`.

----

![](resources/png/sd-add-file.png)

----

![](resources/png/sd-set-folder.png)

----
### More problems

- Getter/Setter approach: `basicAdd()` is not in the `List` interface.
- Cursor approach: each cursor must know its opposite (not so simple).

----
## Step 7
### Operation Implementation

----

![](resources/png/open-parenthesis.png)

----

## Operations, Receptions, and Methods


- An _Operation_ is a feature of a class that specifies the name, type, parameters, and constraints for invoking an associated behavior.
- A _Reception_ specifies that a class is prepared to receive a _Signal_.
- Methods can implement both, operations and receptions. Method execution is either synchronous, or asynchronous.

----

## Receptions and Signals

![](resources/png/receptions.png)

----

## Operations

![](resources/png/operations.png)

----

![](resources/png/close-parenthesis.png)


----
## Operation implementation

![](resources/png/operations.png)<!-- .element: style="width:20%;" -->

```java
public class Book {

    public boolean reserve(Reader aReader) {
        // TODO
        return false;
    }

    public void deliver() {
        // TODO
    }

    public void borrow() {
        // TODO
    }

    public void returnBook() {
        // TODO
    }
}
```

----
## Reception implementation
![](resources/png/receptions.png)<!-- .element: style="width:40%;" -->

```
public class Notify implements Serializable {

    public final String message;

    public Notify(String message) {
        this.message = message;
    }
}
```

----

![](resources/png/receptions.png)<!-- .element: style="width:40%;" -->

```java
public class Alarm {

    private final BlockingQueue<Notify> notifications = 
        new ArrayBlockingQueue<Notify>(10);

    public void accept(Notify notify) {
        this.notifications.offer(notify);
    }

    // TODO: write a thread that reads the blocking queue and executes the notification.
}
```

----
## Conclusion
