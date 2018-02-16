# Automatic Code Generation

----

## Plan

- Introduction<!-- .element: class="fragment highlight-blue" -->
- Approaches
- Xtend
- Acceleo
- Conclusion



----

## Code Generation

- Operation that generates textual artifacts (documents, source code, configuration, etc.) from models (graph-like).
- Motivation:
  - **Abstraction**: from abstract syntax to the concrete syntax (textual)
  - **Readability**: the models we generate are often not easy to read
  - **Executability and testing**: easy to generate running code and test it

----

<!-- .slide: style="text-align: left;"> -->
```java
public class Team {
  // (..)
}

public class Match {
  // (..)
}

public class Player {
  // (..)
}
```
<!-- .element: style="position:absolute; width:48%; right:0px;"-->


![](resources/png/uml-soccer.png)

<!-- .element: style="position:absolute; width:48%; left:0px;"  -->

----

## Underlying model

- Set of classes of a specific programming language allowing to instantiate a model.
- For instance, to represent a UML model in Java, we need different classes:
  - `UMLClass`
  - `UMLAttribute`
  - `UMLOperation`
  - etc.
- The underlying model can be:
  - generic or specific to a modeling language.
  - follow a standard: JMI (Java Metadata Interface), EMF (Eclipse Modeling Framework).

----

## Plan

- Introduction
- Approaches<!-- .element: class="fragment highlight-blue" -->
- Xtend
- Acceleo
- Conclusion

----

## Code Generation Approaches 

1. Script Languages
1. General Purpose Languages (GPLs): Java, C#
1. Generic transformation tools: Graph transformations, XSLT
1. CASE tools scripting languages: Objecteering, Rose
1. Dedicated model transformation languages: ATL, Operational QVT
1. Dedicated model to text transformation languages: xTend, Jet, Acceleo

----

## Script Languages

- sed (Stream Editor), 1973
- Awk (Text processing language), 1977
- Perl, 1987
- Python, Ruby, etc.

----

## Script example 

```sh
#!/usr/local/bin/tcsh -f
# $* : Eiffel files to process

foreach f ( $* )
set classname = `basename $f .e`
echo -n "Doing $classname. "
set newcode = /tmp/inserted_text$$
############################################################################"
# First, extract attribute and association declarations
############################################################################"
sed -n -e '1,/^ * -- attribute/d' \
	-e '/^ * -- associations/,$d' \
	-e '/^ *[a-z][_A-Za-z0-9]* *:  *[A-Z][_A-Z [\]]*[^a-z]*$/s/ *: */ /p'\
	 $f  > /tmp/att_list$$

sed -n -e '1,/^ * -- associations/d' \
	-e '/^feature/,$d' \
	-e '/^ *[a-z][_A-Za-z0-9]* *:  *[A-Z][_A-Z [\]]*[^a-z]*$/s/ *: */ /p'\
	 $f > /tmp/association_list$$
```


----
## General Purpose Languages


- Java, VB, C++, C#,... 	Your favorite language!
- Rules and scheduling implemented from scratch using the programming language
- No overhead to learn a new language
- Tool support to write the transformations

----

## GPL Approaches (1/2)

- Visitor-Based Approaches: 
  - Some visitor mechanisms to traverse the internal representation of a model and write code to a text stream
  - Iterators, sequence of `Write()` calls.

----

## Visitor Example

- For example, you want to perform some processing on UML classes and their attributes.  
- In the underlying model, a class and its associated attributes is represented by the composition relation below:

![](resources/png/class-attribute.png)

----

- Several visitors can be used to traverse the model:

![](resources/png/codegen-visitor.png)

----

- To see how the traversal completes its task, we will refer to the following sequence diagram:

![](resources/png/sd-visitor.png)

----

## Visitor Drawbacks

- Not scalable: a lot of code to write, difficult to maintain
- Basic behavior implementation: load the model, save the text, implement the methods that perform the code generation operation, etc.
- Lack of declarative query language
- Difficult to generate readable code (pretty printing)

----

## GPL Approaches (2/2)

- Template-Based Approaches
  - A template consists of the target text containing slices of meta-code to access information from the source and to perform text selection and iterative expansion
  - The structure of a template resembles closely the text to be generated
  - Textual templates are independent of the target language and simplify the generation of any textual artifacts

----

## Templates

![](resources/png/template-engine.png)

<!-- .element: style="width:90%;" -->

----

## Template example

From:
```
class  <<class.name>>  {
	<<FOR Feature f: class.features>>
	private <<f.type f.name>> ;
	<<ENDFOR>>
}
```

To:

```java
class Person {
	private int age;
}
```

----

## Generic transformation tools

- Typically XML based
  - But XML (XMI) is verbose
- XSLT can be used to transform XML trees into other (XML) (trees)
  - But models are graphs
- Associations (reference) between nodes are done by values
- XSLT transformations are not really easy to maintain
- Better for simple transformations

----

## XSLT example

```xml
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:func="http://exslt.org/functions" xmlns:my="urn:my-functions" xmlns:date="http://exslt.org/dates-and-times" xmlns:math="http://exslt.org/math" extension-element-prefixes="func date">

  <xsl:param name="p1"/>
  <xsl:param name="p2"/>
  <xsl:param name="p3"/>
  <xsl:param name="p4"/>
  <xsl:template match="/">
     <root>
        <function><xsl:value-of select="my:func()"/></function>
        <date><xsl:value-of select="date:date()"/></date>
        <max><xsl:value-of select="math:max(//max/value)"/></max>
        <params>
           <p1><xsl:value-of select="$p1"/></p1>
           <p2><xsl:value-of select="$p2"/></p2>
           <p3><xsl:value-of select="$p3"/></p3>
           <p4><xsl:value-of select="$p4"/></p4>
        </params>
     </root>
  </xsl:template>
  <func:function name="my:func">
	<func:result select="'func-result'"/>
  </func:function>
</xsl:stylesheet>
```

----

## CASE tools scripting languages

- Arcstyler from Interactive Objects 
  - MDA-Cartridge, JPython (Python & Java)
- Objecteering from Objecteering Software
  - J language
- OptimalJ from Compuware
  - TPL language
- Fujaba (From UML to Java and Back Again)
  - Open Source 

----

## CASE tools scripting languages

- **Advantages**
  - Good level of maturity
  - Excellent integration with their CASE tool
- **Drawbacks**
  - Proprietary languages and/or tight coupling with the CASE
  - Often developed as a second thought, not central
  - Many limitations when model transformation get complex
  - Structuring, modularity, reuse problem
  - Configuration management issue when they need to be evolved and maintained for long periods

----

## Dedicated model transformation languages

- Simplify development and maintenance of model-transformations
- Higher expression power
- Enhanced structuring
- Composition of rules
- Interoperability

----

![](resources/png/m2m.png)

----

## Transformation rule example

```
rule Member2Female {
	from
		s: Families!Member (s.isFemale())
	to
		t: Persons!Female (
			fullName <- s.firstName + ' ' + s.familyName
		)
}
```

----

## Model transformation drawbacks

- Transformation languages are generally used to implement model transformations
- Not really adapted to generate code
- Transformation rules tend to be granular

----

## Dedicated model to text transformation languages

- Acceleo
  - Implementation reference for OMG's MTL (MOF Model to Text Transformation Language)
  - Dedicated template engine for code generation
- Xtend
  - Java + Templates + Sugar


----

## M2T Transformation Languages

- **Advantages**
  - Template-based approach: text fragments + template expressions (constructs)
  - Declarative query language: OCL, XPath, etc.
  - Template engine: replaces template expressions with data at runtime and produces output files 
  - Scalable: at least more than other approaches
  - Produces readable code
- **Drawbacks**
  - Another language to learn
  - Difficult to choose where to place specific behavior: in the meta-model or in the templates.

----

## Plan

- Introduction
- Approaches
- Xtend<!-- .element: class="fragment highlight-blue" -->
- Acceleo
- Conclusion

----

## Xtend

- Extension of Xpand (i.e. a template-based M2T)
- Brings together the advantages of  GPLs and Template expressions
- Statically-typed PL which translates to comprehensible Java code, but improves: 
  - Lambda expressions
  - Method dispatch & method extension
  - Template expressions
- Generates reusable Java code

----

## Lambda expresssions

Java code:

```java
final JTextField textField = new JTextField();
textField.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    textField.setText("Something happened!");
  }
});
```

Xtend code:

```java
textField.addActionListener([ e |
  textField.text = "The command '" + e.actionCommand + "' happened!"
])
```

----

## Template expressions in Xtend

```java
	def genCore (Calendar c) '''
	private static  Calendar buildCalendar() {
			//creating a calendar
			Calendar calendar = new Calendar();
			//creating events
			«FOR e : c.events»
			Event event«c.events.indexOf(e)» = new Event();
			event«c.events.indexOf(e)».setName("«e.name»");
			event«c.events.indexOf(e)».setDate(«e.time.split('/').get(0)», «e.time.split('/').get(1)», «e.time.split('/').get(2)»);
			event«c.events.indexOf(e)».setStartTime("«e.from»");
			event«c.events.indexOf(e)».setEndTime("«e.to»");
			event«c.events.indexOf(e)».setLocation("«e.location»");
				
			calendar.addEvent(event«c.events.indexOf(e)»);
            «ENDFOR»
			System.out.println(calendar);
			return calendar;
			}
	'''
```

----

## Example of Java generated code

```java
  public CharSequence genCore(final Calendar c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private static  Calendar buildCalendar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//creating a calendar");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Calendar calendar = new Calendar();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//creating events");
    _builder.newLine();
    {
      EList<Event> _events = c.getEvents();
      for(final Event e : _events) {
        _builder.append("\t\t");
        _builder.append("Event event");
        EList<Event> _events_1 = c.getEvents();
        int _indexOf = _events_1.indexOf(e);
        _builder.append(_indexOf, "\t\t");
        _builder.append(" = new Event();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("event");
        EList<Event> _events_2 = c.getEvents();
```

----

## Conditions

    <<IF>>…<<ELSE>>…<<ENDIF>> 

```java
def someHTML(Paragraph p) '''
  <html>
    <body>
      «IF p.headLine != null»
        <h1>«p.headline»</h1>
      «ENDIF»
      <p>
        «p.text»
      </p>
    </body>
  </html>
'''
```

----

## Loops

    <<FOR>> … <<ENDFOR>> 
  
```java
def someHTML(List<Paragraph> paragraphs) '''
  <html>
    <body>
      «FOR p : paragraphs»
        «IF p.headLine != null»
          <h1>«p.headline»</h1>
        «ENDIF»
        <p>
          «p.text»
        </p>
      «ENDFOR»
    </body>
  </html>
'''
```

----

## Loops with separators

```java
def someHTML(List<Paragraph> paragraphs) '''
  <html>
    <body>
      «FOR p : paragraphs BEFORE '<div>' SEPARATOR '</div><div>' AFTER '</div>'»
        «IF p.headLine != null»
          <h1>«p.headline»</h1>
        «ENDIF»
        <p>
          «p.text»
        </p>
      «ENDFOR»
    </body>
  </html>
'''
```

----

## Plan

- Introduction
- Approaches
- Xtend
- Acceleo<!-- .element: class="fragment highlight-blue" -->
- Conclusion

----

## Acceleo

- Reference implementation of the OMG «Model to Text Transformation Language» Standard
- Developed by Obeo
- Available in Eclipse (Eclipse Modeling Distribution)
- Combines  an expressive query language with a template engine

----

## Modules

- Acceleo is organized in modules (`.mtl` files)
- Modules contain a file description, templates, and queries.
- The main template is annotated with `@main`

----

## Module structure

```
[comment encoding = UTF-8 /]
[**
* The documentation of the module generate2.
*/]
[module generate('http:///uml.ecore')]

[**
* The documentation of the template generateElement. * @param aDocument
*/]
[template public generateClass(c : Class)]
[comment @main/]
[file (c.name, false, 'UTF-8')]

[/file]
[/template]
```

----

- A module is identified by a name and a modeling language identifier (URI):

```
[module generate('http:///uml.ecore')]
```

- Template statements are specified inside tags `[.../]`:
  - Field access: `[c.name]`
  - Method call: `[c.getAbsolutePath()]`

----

## Conditions

- Syntax: `[IF]...[ELSE]...[/IF]`

```
[if (condition)]
    (...)
[elseif (condition)]
    (...)
[elseif (condition)]
    (...)
[/if]
```

----

## Loops

```
[template public classToJava(c : Class)] 
class [c.name/] {
    // Attribute declarations
    [for(a : Attribute | c.attribute)]
      [a.type.name/] [a.name/]; 
    [/for]
 }
 [/template]
```

----

## Calling other templates

```
[template public classToJava(c : Class)] 
class [c.name/] {
    // Attribute declarations
    generateAttributes(c)
}
[/template]
 
[template public generateAttributes(c : Class)]
  (..)
[/template]
```

----

## Queries

```
[query public hasStereotype( e : uml::Element, value: String) : Boolean =
    e.getAppliedStereotypes()->select(e: uml::Stereotype  | e.name = value)->notEmpty()
/]
```

----

## Plan

- Introduction
- Approaches
- Xtend
- Acceleo
- Conclusion<!-- .element: class="fragment highlight-blue" -->

----

## Conclusion

- Code generation is not only a matter of _how_ to generate
  - It is mostly a matter of _what_ to generate
- A limited yet useful approach
- Code generation is also software development
  - Software engineering practices must be applied
