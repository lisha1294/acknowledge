Core Java

- Enhancements in Java 5: Generics, Enhanced for loop, Auto(un)boxing, Typesafe Enums, Varargs, Annotations
- Enhancements in Java 6: Collections framework, Webstart, Drag and drop, Instrumentation, i18n, I/O support, jar files, JDBC4
- Constant Interface Antipattern: putting static memebers into an interface and inherting that to leave of the class name of static methos.  So we have the static import.
- varags (variable arguments) are the elipses (...) part indicates that an array or a sequence of arguments may be used in its place.  It must be in the final argument position or a method signature.
- the compiler translates the varargs formal parameter into an array. 
- for each in example.  (Vector v) for (String s:v) {print(s);}

#TOC#
Objects
Variables
Return from a method
Controlling Access
Pass by Value
Numbers
Operators
Expressions, Statements, and Blocks
Control Flow Statements
Initialization
Nested Classes
Enums
Inheritance
Object class
Abstract & Interface
Methods
Modifiers
Numbers
Packages
Regular Expressionses


#Objects#
Real-world objects contain state and behavior.
A software object's state is stored in fields.
A blueprint for a software object is called a class.
Common behavior can be defined in a superclass and inherited into a subclass using the extends keyword.
A collection of methods with no implementation is called an interface.

#Variables#
- Instance Variables (Non-Static Fields) 
- Class Variables (Static Fields) static modifier; one copy regardless of how many times the class has been instantiated. 
- Local Variables declared in braces of a method. only visible to the methods in which they are declared;
- Parameters classified as "variables" not "fields". other parameter-accepting constructs as well (constructors and exception handlers)
- A type's fields, methods, and nested types are collectively called its members.
class variable = static field.
instance variable = non-static field.
- A variable declared within the opening and closing parenthesis of a method is called a parameter.
- Parameters refers to the list of variables in a method declaration. 
- Arguments are the actual values that are passed in when the method is invoked.
- compile-time constant: a primitive type or a string is defined as a constant and the value is known at compile time, the compiler replaces the constant name everywhere in the code with its value.
 
#Return from a method#
- Any method declared void doesn't need to return a value, but it may do so to branch out of a control flow block and exit the method.
- When a method uses a class name as its return type, such as whosFastest does, the class of the type of the returned object must be either a subclass of, or the exact class of, the return type. 
- covariant return type, means that the return type is allowed to vary in the same direction as the subclass when You override a method and define it to return a subclass of the original method,
- when you use an interface as a return type the object returned must implement the specified interface.

- explicit constructor invocation From within a constructor, you can also use the this keyword to call another constructor in the same class.

- (Static Fields) A class variable is any field declared with the static modifier; this tells the compiler that there is exactly one copy of this variable in existence, regardless of how many times the class has been instantiated. 
- The args variable is the parameter to a main method. parameters are always classified as "variables" not "fields". 
A type's fields, methods, and nested types are collectively called its members. 

#Controlling Access#
- package-private: when a class (or member) has no explicit public(private/protected) modifyer.
- The protected modifier specifies that the member can only be accessed within its own package (as with package-private) and, in addition, by a subclass of its class in another package.
- Public fields tend to link you to a particular implementation and limit your flexibility in changing your code.
Access Levels
Modifier    Class   Package Subclass World
public      Y       Y       Y        Y
protected   Y       Y       Y        N
no modifier Y       Y       N        N
private     Y       N       N        N


#Pass by Value#
- Reference data type parameters (objects) are passed into methods by value. However, the values of the object's fields can be changed in the method (see RelatableCircle.java in the innards directory)
- for example:
        ValueCircle myCircle = new ValueCircle(5,5);
        TestValueCircle test_circle = new TestValueCircle();
        test_circle.moveCircle(myCircle, 23, 56);
Even thought myCircle is not returned from the moveCircle method, the changes that happen in that method are reflected in the reference.
- if moveCircle changes the values, they are changed in the calling method as well.  However, if it creates a new object, that object loses its reference after the method returns.
- The difficult thing can be to understand that Java passes objects as references and those references are passed by value.  object references are passed by value. "call by value where the value is a reference" (Barbara Liskov re CLU language 1974), "call by sharing" (sometimes called "call by object-sharing or simply call by object")
- The references are pointers to an address.  Thats' why the value of the object is the same.
- In C you can assign a pointer, pass the pointer to a method, follow the pointer in the method and change the data that was pointed to. However, you cannot change where that pointer points.  In C++, Ada, Pascal and other languages that support pass-by-reference, you can actually change the variable that was passed.
- Java is by value for built-in types, and by value of the pointer for object types.
- however, primitive types are not changed by the method.
- my take: Java is a pass-by-address(or primitive) language.


#Numbers#
- the eight primitive data types supported by the Java programming language: byte, short, boolean, char, double, int, long, float. 

- byte: 8-bit signed two's complement integer. min -128 max 127 (incl).

- short: a 16-bit signed two's complement integer.min -32,768 max 32,767 (inclusive).use a short to save memory in large arrays, in situations where the memory savings actually matters.

- int: 32-bit signed two's complement integer, min -2,147,483,648 max 2,147,483,647  (-2 to the 31 and a maximum value of 2 tt 31-1). In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 232-1. Use the Integer class to use int data type as an unsigned integer. compareUnsigned, divideUnsigned etc have been added to the Integer class to support the arithmetic operations for unsigned integers.

- long: 64-bit two's complement integer. signed min -2 tt 63 max 2 tt 63-1. Java SE 8 an unsigned 64-bit long:min 0 and a max 264-1. Use this data type when you need a range of values wider than those provided by int. Also compareUnsigned, divideUnsigned etc

- float: single-precision 32-bit IEEE 754 floating point. range specified in the Floating-Point Types, Formats, and Values section of the Java Language Spec. As with the recommendations for byte and short, use a float (instead of double) if you need to save memory in large arrays of floating point numbers. not for precise values, such as currency. For that, use the java.math.BigDecimal

- double: double-precision 64-bit IEEE 754 floating point. (Range in Java Spec). decimal default choice. should never be used for precise values

- boolean: true/false. one bit of information, but its "size" isn't something that's precisely defined.

- char: single 16-bit Unicode character. min'\u0000' (or 0) max'\uffff' (or 65,535 inclusive).

-  System.out is a PrintStream object, so you can invoke PrintStream where you have been using print or println. For example,
System.out.format(String format, Object... args);
- The format string contains plain text as well as format specifiers (begin with a percent sign (%) and end with a converter. The converter indicating the type of argument to be formatted. In between the percent sign (%) and the converter you can have optional flags and specifiers), which are special characters that format the arguments of Object... args
- format(Locale l, String format, Object... args)
- Math.E, the base of natural logarithms
- double abs(double d)
- float abs(float f) or int, - long Returns the absolute value of the argument.
- double ceil(double d)   Returns the smallest integer that is greater than or equal to the argument. Returned as a double.
- double floor(double d)  Returns the largest integer that is less than or equal to the argument. Returned as a double.
- double rint(double d)   Returns the integer that is closest in value to the argument. Returned as a double.
- long round(double d) or int round(float f)  Returns the closest long or int, as indicated by the method's return type, to the argument.
- double min(double arg1, double arg2) works with float int long  Returns the smaller of the two arguments.
- double max(double arg1, double arg2) also float int long  Returns the larger of the two arguments.
- pseudo-randomly selected number includes 0.0 but not 1.0. 
- 0.0 <= Math.random() < 1.0

#Operators#
Consider the following code snippet:
    arrayOfInts[j] > arrayOfInts[j+1]
Question: What operators does the code contain?
Answer: >, +
Consider the following code snippet:
int i = 10;
int n = i++%5;
    Question: What are the values of i and n after the code is executed?
    Answer: i is 11, and n is 0.
    Question: What are the final values of i and n if instead of using the postfix increment operator (i++), you use the prefix version (++i))?
    Answer: i is 11, and n is 1.
logical complement operator "!".
result = result - 1; same as result -= 1;
%       remainder operator
// result is now 10
        result = result % 7; // result is now 3
Same as
// result is now 10
        result %= 7; // result is now 3
// result is now 10
   result = result + 8;
        // result is now 3
        result = result % 7;
?:      Ternary (shorthand for 
        if-then-else statement)
~       Unary bitwise complement
<<      Signed left shift
>>      Signed right shift
>>>     Unsigned right shift
&       Bitwise AND
^       Bitwise exclusive OR
|       Bitwise inclusive OR

#Expressions, Statements, and Blocks#
aValue = 8933.234; // assignment statement
System.out.println("Hello World!"); // method invocation statement
Operators may be used in building expressions, which compute values.
Expressions are the core components of statements.
Statements may be grouped into blocks.
a compound expression 1 * 2 * 3

#Control Flow Statements#
The do-while statement is similar to the while statement, but evaluates its expression at the bottom of the loop.
for ( ; ; ) {} // an infinite loop using the for statement
while (true) {} //  an infinite loop using the while statement
enhanced for statement for iteration through Collections and arrays:
int[] numbers =   {1,2,3,4,5,6,7,8,9,10};
for (int item : numbers) 
{
             System.out.println("Count is: " + item);
}


#Initialization#
- static initialization blocks are normal block of code enclosed in braces, { }, and preceded by the static keyword.  They are called in the order that they appear in the source code.
- private static method defined in a class:
    public static varType myVar = initializeClassVariable();
    private static varType initializeClassVariable() {
        // initialization code goes here
    }
- can be reused later if you need to reinitialize the class variable.
- Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword:
- The compiler copies initializer blocks into every constructor. can be used to share a block of code between multiple constructors.
- final method cannot be overridden in a subclass. 
- The method is final because calling non-final methods during instance initialization can cause problems.

#Nested Classes#
- There are Static nested classes, but Non-static nested classes are called inner classes.
A nested class can be declared private, public, protected, or package private. 
- cannot refer directly to instance variables or methods defined in its enclosing 
- Just like any other top-level class.
- have access to other members of the enclosing class, even if they are declared private.
- cannot define any static members itself.
- To instantiate an inner class, you must first instantiate the outer class. 
- two kinds of inner classes: local classes and anonymous classes.

#Enums#
All enums implicitly extend java.lang.Enum.  Since Java does not support multiple inheritance, an enum cannot extend anything else.
An interface name can be used anywhere a type can be used.

#Inheritance#
Questions and Exercises: Inheritance
1.a and c incorrect.  How do you hide an inherited method?  It's considered a bad programming practice, but the table in Overriding and Hiding Methods section shows the effect of declaring a method with the same signature as a method in the superclass.
http://docs.oracle.com/javase/tutorial/java/IandI/override.html
- overriding: instance method in the subclass that has the same signature as the one in the superclass
- hiding: a static method in the subclass that has the same signature as the one in the superclass
- A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.
- implicit casting:
    Object obj = new MountainBike();
- explicit casting:
    MountainBike myBike = (MountainBike)obj; // error without the cast
    if (obj instanceof MountainBike) {
        MountainBike myBike = (MountainBike)obj;
    }
- virtual method invocation, an aspect of polymorphism, is when the jvm calls the appropriate method for the object that is referred to in each variable, not the method that is defined by the variable's type
- The compiler automatically provides a no-argument, default constructor for any class without constructors. This default constructor will call the no-argument constructor of the superclass.
- constructor chaining: If a constructor does not explicitly invoke a superclass constructor, the Java compiler automatically inserts a call to the no-argument constructor of the superclass. If the super class does not have a no-argument constructor, you will get a compile-time error.   But Oject has one.  there will be a whole chain of constructors called, all the way back to the constructor of Object.
- Methods called from constructors should generally be declared final. If a constructor calls a non-final method, a subclass may redefine that method with surprising or undesirable results.
- final classes cannot be subclassed, useful when creating an immutable class like the String class.

#Object#
protected Object clone() throws CloneNotSupportedException
public boolean equals(Object obj)
protected void finalize() throws Throwable 
public final Class getClass()
public int hashCode()
public String toString()
notify, notifyAll, and wait 
- If an object contains a reference to an external object, you may need to override clone() to get correct behavior. Otherwise, a change in ObjExternal made by one object will be visible in its clone also. This means that the original object and its clone are not independent—to decouple them, you must override clone() so that it clones the object and ObjExternal. Then the original object references ObjExternal and the clone references a clone of ObjExternal, so that the object and its clone are truly independent.
- If you override equals(), you must override hashCode() as well.
- A hash code is the object's memory address in hexadecimal.
- if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are equated
- finalize() may be invoked on an object when it becomes garbage.
- You cannot override getClass().
- getClass().getSimpleName()
- getClass().getSuperclass() // its superclass 
- getClass().getInterfaces() // interfaces it implements
- getFields() getMethods() // other methods (of 50) in Class.class


#Abstract & Interface#
- Java does not permit multiple inheritance but interfaces provide an alternative because you can implement more than one interface.
- an interface can extend any number of interfaces. 
- If a class includes abstract methods, the class itself must be declared abstract
- All methods declared in an interface are implicitly public, so the public modifier can be omitted.
- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.


- if an abstract class is subclassed and contians unimplemented methods, it must also be declared abstract.
- All of the methods in an interface are implicitly abstract, so the abstract modifier is not used. (it could be—it's just not necessary).
- Unlike interfaces, abstract classes can contain fields that are not static and final, and they can contain implemented methods. 
- Such abstract classes are similar to interfaces, except that they provide a partial implementation, leaving it to subclasses to complete the implementation. 
- If an abstract class contains only abstract method declarations, it should be declared as an interface instead.
- Multiple interfaces can be implemented by classes anywhere in the class hierarchy, whether or not they are related to one another in any way. Think of Comparable or Cloneable, for example.
- By comparison, abstract classes are most commonly subclassed to share pieces of implementation. A single abstract class is subclassed by similar classes that have a lot in common (the implemented parts of the abstract class), but also have some differences (the abstract methods).
- You can define an abstract class that does not implement all of an interface method.
- An abstract class may have static fields and static methods that can be used with a class reference—for: AbstractClass.staticMethod()—as with any other class.


#Methods#
- Overriding Instance Methods: An instance method in a subclass with the same signature overrides the superclass's method.  An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.  
- the version of the hidden static method that gets invoked is the one in the superclass
- the version of the overridden instance method that gets invoked is the one in the subclass.
- Hidden Static Methods: If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.  The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.
- Interface Methods: Default methods and abstract methods in interfaces are inherited like instance methods. 
** What the hell is a default method?***
- However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
- Instance methods are preferred over interface default methods.  Pegasus.identifyMyself() returns the string "I am a horse."
- Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself() returns the string "I am able to lay eggs."
  This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 
- Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.

#Modifiers#
- an overriding method can allow more, but not less, access than the overridden method. ie: a protected instance method in the superclass can be made public, but not private, in the subclass.
- change an instance method in the superclass to a static method in the subclass, or vice versa = compile-time error.

You can prevent a class or method from being subclassed by using the final keyword.


#Numbers# 

Assignment Operators: C /= A is equivalent to C = C / A

The byteValue, shortValue, and similar methods of the Number class convert one numeric type to another. The valueOf method converts a string to a number, and the toString method converts a number to a string.

To format a string containing numbers for output, you can use the printf() or format() methods in the PrintStream class. 

What Integer method would you use to convert a string expressed in base 5 into the equivalent int? For example, how would you convert the string "230" into the integer value 65? Show the code you would use to accomplish this task.

What Double method can you use to detect whether a floating-point number has the special value Not a Number (NaN)?

Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(i);

becomes:

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(Integer.valueOf(i));

autoboxing happens when a primitive value is:
- Passed as a parameter to a method that expects an object of the corresponding wrapper class.
- Assigned to a variable of the corresponding wrapper class.

unboxing is Converting an object of a wrapper type (Integer) to its corresponding primitive (int) value. The Java compiler applies unboxing when an object of a wrapper class is:
- Passed as a parameter to a method that expects a value of the corresponding primitive type.
- Assigned to a variable of the corresponding primitive type.


#Packages#
- package private are All the top-level, non-public types in the same file as a pulic class.
- Importing java.awt.* imports all of the types in the java.awt package, but it does not import java.awt.color, java.awt.font, etc...  To import more, do this:
    import java.awt.*;
    import java.awt.color.*;


#Regular Expressionses#

Instances of the Pattern class are immutable and are safe for use by multiple concurrent threads. Instances of the Matcher class are not safe for such use.