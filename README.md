# Course Info
University of California, Berkeley

CS 61B Data Structures

Instructor: Josh Hug

Website:https://sp21.datastructur.es/

### To-Do
#### Proj
- [x] proj 0 : Implemented the main Logic of the Game 2048
- [x] proj 1 : Implemented the deque date structure
- [ ] proj 2
- [ ] proj 3

#### Lab 
- [x] lab 1 : Setting up
- [x] lab 2 : JUnit Tests and Debugging
- [x] lab 3 : Timing Tests and Randomized Comparison Tests
- [x] lab 4 : Git Exercise
- [x] lab 6 : Persistence and Command Line
- [x] lab 7 : Implemented a BSTMap
- [x] lab 8 : Implemented a HashMap



### Note:

#### lec 2

Static Methods a.k.a. Class Methods

Non-static Methods a.k.a. Instance Methods

> If the method needs to use “my instance variables”, the method must be non-static.

Static variable should be accessed by the name of class.

#### lec 5  

Private variables and methods can only be accessed by code inside the same java file

Declaring a nested class as static means that methods inside the static class can not
access any of the members of 
the enclosing class

### lec 8 
if a subclass has a method with the exact same signature
as in the superclass, we say the subclass overrides the method;
While methods with the same name but different signature are overloaded.

If X is a superclass of Y, then memory boxes for X may contain Y.

### lec 9

constructors are not inherited, 
and private members cannot be directly accessed by subclasses.

Note that Java will automatically make a call to the 
superclass's *no-argument* constructor.

Every class in Java is a descendant of the Object class
