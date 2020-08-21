                      Resilience : fault Management

Any System Subject to failure.

Layers of system and its failures

-Hardware failures
-OS Failures
-Network failures

Software failures:
..................
->JVM failures
  -out of memory
  -heap dump errors
  -process related errors
  -thread related errors
-How to fix failures
  -there tools available to detect memories,threads,heap dump 
   -jmeter,heapdump errors, apache benchmark....

->Exception handling
 file handling,database handling, call third party apis,networking, biz use case failures.
-How to fix application errors
  -Exception handlers--- give report , we can decide what do.

try{
 //what type of code i can write
 //The code subject to fail, risky code. : The code may cause error any time.

}
catch(Exception e){
  //for recovery code.
  //you report to other code or ui
  //you can log those errors, you can audit latter.
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Application types and its architectures:

1.Back end application
 -web
 -distributed application
2.User interface application
  -web
  -mobile
  -iot

Distributed Application:

Application is built based various components.

components
 -Data-Models-Entities
 -Repository-DAO---talks to DataSources
 -Integration Component - talks to External systems like - Mainframe,SAP,e-commerce platforms,Third party web services(SOAP,REST),SOA,NO SQL...
 -Biz layer/ Service layer
 -Web Layer

How to build distributed application ?

Distributed application built on various patterns and principles.

Types of Distributed application:
.................................

- Monolithic 
- MicroServices

Monolithic :
 It is distributed application.
 -Built,compile,pack,test,deploy as a single unit.
 -Technology driven model : focus given on tech stack eg if u select java, the whole is built mostly using java 
 -In case any failures in the  part of the system, the whole system may go down.
 .....

 Micro services :
  It is also one the distributed architecture /application

- Domain Driven Model 
    - built application based on biz domains.
    - Whole application is broken into biz modules ; In Reservation System
       - Customer is a separate application
          which has its own layers ,database,tech stack : polytech
       - Accounts is a separate application
          which has its own layers ,database,tech stack : polytech

-Built , compile ,test , deploy individually : 
          Continuous Req
          Continuous Dev
          Continuous Test
          Continuous deployment
          Continuous Release 
               -CI and CD : Dev ops

 Many Software communicates others under one roof : Micro services
   Where failures are highly expected.

How to handle Failures,Recover failures, How to respond to applications and users with respect to failures.

                                 Micro Services
                                      |
                        ------------------------------------
                        |                                  |
                    Application                        Infrastructure
                       |                                    |
                     Spring                           (CI/CD,Cloud......)
                 (Spring Cloud)

                    Micro Service Fault Management Technologies
                    ............................................
                     Application                        Infrastructure
                       |                                    |
                     Spring                           (CI/CD,Cloud......)
                   (Spring Cloud)                              
                        |             
       How to handle Application failures?
                       |
                    Spring 
                      |
                      |
       Latency and Fault Tolerance for Distributed Systems 
                      |
       -------------------------------                 
       |                             |          
    Hystrix                      Resilience4J
                                        |
                                We will learn about this

Getting started with Resilience4J:
................................
Resilience 4j has built on various programming models

->Traditional annotation driven model like Hystrix.
->Functional style programming
->Reactive and Functional Style Programming.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Functional Programming

Reactive Programming

Resilence4J

Software Setup:
- JDK 8
- Intellij idea - Community edition /any editor
- maven
- docker and docker compose
- apache bench mark
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Functional Programming and implementations:
..........................................

What is fp?
-Functional programming is one the programming paradigm.

Programming paradigm: Way to build
->Object oriented
->Procedural oriented
->Functional Programming
->Event Driven Programming
->Reactive Programming

Object Oriented Principles:
...........................
1.Abstraction
2.Encapsulation
3.Hierarchy
4.Typing
5.Modularity
----------------------
6.Concurrency
7.Persistency 

if any pl implements the first 5 principles are object oriented programming language. - C++,java,C#

"Object Based" Programming language

if any pl does not implement any of one of the  5 principles or partially implement are object based programming language.
 - javascript 

 Functional Programming:
   Functional programming is one the oldest programming model.
   It was created in 1935.

History of functional Programming
.................................
    In 1930,The scientist called "Alan Turing" : Turing Machine ->State Machine
    -Abstract computing machine : it is mathematical abstraction for storing ,processing data,read (state).

State Machine: 
  It is mathematical abstraction of "How to store state in memory and manipulate that memory".

 eg 
  int a =10; ----> a's memory address--->1024 and 10 

 State mutations:
   a++ -> 11-------What is memory address of 11? 1024.

After, 1970 - Concurrency--multi process -- multi threading

multi state mutation will lead
1.data corruption.
   ->Mutx - Lock
  
Lock will lead another problems
  -Blocking
  -what if thread takes more time--->waiting--performance
  -Thread dead locking

Solution to Turning Machine:
.............................

Lambda Calculus:
  It is another mathematical approach like state machine to represent state in memory and mutate it.

Lambda Calculus invented by The "Alonzo Church" , Who is PHD student of "Alan Turning"..

The Programming languages which implements "lambda Calculus theory" called "Functional programming".

Lambda expressions the programs construction through "functions" -->f()

The languages which implements lambda Calculus
 ->Scheme
 ->haskell

Java is object oriented only?
No , After Java 8.

Java 8 implements Lambda Calculus(Functional Programming)

  "Java is Object oriented, functional Style" Programming language.
      -Hybrid language.

Today most of the pl , are hybrid.
  javascript : object based,functional style,event driven.......
  

With Respect hybrid languages
 java- Object oriented, functional style.

style vs pure:
..............
  if a pl implements 100% principles of an paradigm, those languages called "Pure"

  if a pl implements not all principles or partially, those languages called "style".
  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxx

Functional Programming  Principles:
...................................
 
  Function is abstraction to encapsulate application state and its logic

1.Side Effects:
  The application mutate some sort of state, may be outer world(out side to application boundary) - database calls,files.

2.Referential Transparency:
  Variables are once defined dnt change their value throughout the program
  In fp, programs dont have assignment statements.
  what if i want to change the variable, we should not mutate old memory address,
     rather assign computed result into new memory address.
  This eleminates any changes of side effects because any variable can be replaced with
  its actual value at any point of execution.

"Pure" function :

Pure should be

 1. function takes arg, return the same , which never modifes the state.
  
      function  update(value){
           return value;
      }
  
 2.  What if i want to change state

   Thinking in values:
             The value changes should not be in same place, rather than it should be in different memory address--->Immutablity -- Immutable values

      function  update(value){
           return value; //state changes
      }


 100               104          240
 |                  |           |
 Value1---update-->Value2 ---->update



3.Recursion:
   no loops in fp- only fp

4.Function is first class citizen : every thing is function, function itself a value.

  ->function as parameter---->Callback ---Async 
  ->Function is returned --->closure
  ->function composition --> f()-->f()--f()=>result
     ->curry
     ->memoization
     -Partial applications
     -Lifting

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Java Functional Programming implementation:

1.Function declarations,invocation using free variable patterns
  => Lambda expression
2.Pure function 
3.Function Composition

Functional programming is simulated in source code only via interfaces, but once code is compiled , it becomes object models.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Lambda calcus implemenation:
...........................

inner classes:
 1.anonymous inner class --- functional implements.

interfaces : functional interface

functional interfaces: To enable functional programming in java

1.To implement lambda , java provides interface having single abstract method "SAM".

Functional interfaces must have only one abstract method  : SRP principle.

2.interface can have other methods
   -default methods
   -static methods


Basic:
package com.ibm.fp.basics;


/**
 * interfaces ;
 */
//How to provide implementation for an interface

interface Welcome {
    void sayHello();
}

//way 1:

/**
 * drawback of this model
 * - if i want to implement interface, i need new class again , this will increase no of classes.
 */
class WelcomeImpl implements Welcome {
    @Override
    public void sayHello() {
        //
        System.out.println("Hello");
    }
}

public class BasicLambda {
    public static void main(String[] args) {

        //Declare Welcome type variable
        Welcome welcome = null;
        //
        welcome = new WelcomeImpl();
        welcome.sayHello();

        //way -1anonymous inner class
        /**
         * This apporah is legacy object oriented model
         */
        welcome = new Welcome() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        welcome.sayHello();
        //we want only logic ,: lambda functions
        welcome = () -> {
            System.out.println("Hello");
        };
        welcome.sayHello();

    }
}

package com.ibm.fp.basics.rules;

/**
 * Lambda Rules
 * 1.interface must have only one abstract method.
 * -SAM - Single Abstract method ; SRP - SOILD RULES
 * 2.you can have default and static methods
 */
interface Greeter {
    //static methods
    static String doSomething() {
        return "doSomething";
    }

    //abstract method
    void sayHello();

    //default
    default public String saySomething() {
        return "I am telling something";
    }
}

public class LambdaRules {
    public static void main(String[] args) {
        Greeter greeter = null;
        greeter = () -> {
            System.out.println("Hello");
        };
        greeter.sayHello();
        System.out.println(greeter.saySomething());
        System.out.println(Greeter.doSomething());
    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Can we use any interface in jdk as lambda?
Yes!, any interface is having single abstract method. we can use

eg:
Thread creation using Runnable  interface?


package com.ibm.fp.basics.rules;

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadsUsingLambda {
    public static void main(String[] args) {
        Thread thread = null;
        thread = new Thread(new MyThread());
        thread.start();

        Runnable myRunner = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread = new Thread(myRunner);
        thread.start();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
        //Lambda
        Runnable myLambdaRunner = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        thread = new Thread(myLambdaRunner);
        thread.start();
        thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();

        //simple pattern
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Use case;

What if somebody has provided interface, now you have to use lambda based on that interface.

java provides an annotation, maker annotation,used by compiler during compile time.

@Functional

package com.ibm.fp.basics.rules;

@FunctionalInterface
interface Hello {
    void sayHello();
}

public class FunctionalAnnotation {
    public static void main(String[] args) {
        Hello hello = null;
        hello = () -> {
            System.out.println("Hello");
        };
        hello.sayHello();

    }
}

How to refactor lambda code ;  various code simplification
..........................................................
->Simple Code Refactoring
->Parameters and Args
->return values
->Type Inference


package com.ibm.fp.lambda.advanced;

//Single
@FunctionalInterface
interface Single {
    void sayHello();
}

//args and parameters
@FunctionalInterface
interface Greeter {
    void setMessage(String message);
}

@FunctionalInterface
interface BiFunction {
    void setMessage(String message, String name);
}

//return values
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}


public class LambdaAdvanced {
    public static void main(String[] args) {
        //Single
        Single single = null;
        //Code refectoring
        single = () -> {
            System.out.println("Helllo");
        };
        single.sayHello();
        // if function has only one line of body, we can remove {}
        single = () -> System.out.println("Helllo");
        single.sayHello();
        //Parameters and args
        Greeter greeter = null;
        //message is args, what you receive
        greeter = (String message) -> {
            System.out.println(message);
        };
        //"Hello" is parameter; what you pass
        greeter.setMessage("Hello");
        //if you write lambda you can remove type
        //Type interfence; type of variable is understood.
        greeter = (message) -> System.out.println(message);
        greeter.setMessage("Hello");
        //if funcition take single parameter, you can remove even bracket
        greeter = message -> System.out.println(message);
        greeter.setMessage("Hello");

        //two parameters
        BiFunction biFunction = null;
        biFunction = (message, name) -> System.out.println(message + name);
        biFunction.setMessage("Hello", "Subramanian");

        //Return values
        Adder adder = null;
        adder = (a, b) -> {
            int result = a + b;
            return result;
        };
        System.out.println(adder.add(10, 10));
        //return value , only return statement : remove return statement as well
        adder = (a, b) -> a + b;
        System.out.println(adder.add(10, 10));

    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

What you can pass as parameter and Return from lambda?

You can pass primitives and objects

  int,string,double,boolean,Employee,Order......

Can you can Pass function as parameter to another function or constructors?

 Yes!


package com.ibm.fp.lambda.advanced;

/**
 * Function as parameter to another function.
 */

@FunctionalInterface
interface Handler {
    void connect();
}

//parameters and args with respect to function as parameters:  simulate non blocking data return

@FunctionalInterface
interface HttpHandler {
    boolean write(Object data);
}


class NetServer {
    //Take Handler as Arg
    public void start(Handler handler) {
        handler.connect();
    }
}

class HttpServer {
    public void handleRequest(HttpHandler httpHandler) {
        try {
            //fake Response
            String fakeResponse = "Hello! HttpServer";
            Thread.sleep(1000);
            boolean status = httpHandler.write(fakeResponse);
            if (status) {
                System.out.println("Response committed");
            } else {
                System.out.println("something went wrong");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

class HandlerImpl implements Handler {
    @Override
    public void connect() {
        System.out.println("Start Net Server");
    }
}

public class FunctionAsParam {
    public static void main(String[] args) {
        NetServer netServer = null;
        netServer = new NetServer();

        netServer.start(new HandlerImpl());

        //anonous
        Handler handler = null;

        handler = new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        };
        netServer.start(handler);

        netServer.start(new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        });
        //lambda methods
        handler = () -> System.out.println("Start Net Server via Lambda");
        netServer.start(handler);
        //inline
        netServer.start(() -> System.out.println("Start Net Server via inline Lambda"));

        ///////////////////////////////////////////////////////////////////////////////////
        HttpServer httpServer = new HttpServer();

        //call
        httpServer.handleRequest(new HttpHandler() {
            @Override
            public boolean write(Object data) {
                System.out.println(data);
                return true;
            }
        });
        //lambda way of gettting data
        System.out.println("Waiting");
        httpServer.handleRequest(response -> {
            System.out.println(response);
            return true;
        });
        System.out.println("end");


    }
}
//////////////////////////////////////////////////////////////////////////////////

Lab 1:
Objective : Lambda as parameter.

Create Login Validation Api.
Login api should pass data to handler based on biz logic
 -userName = admin and password =admin
 if user and password is admin and admin, send "Login Success" Message else "Login failed Message".
login method should accept two functions
   -Resolve - handling success result
   _Reject - handling failure result.

Clue : Pass two function as parameter , one is SUccess handler and another one is failure handler.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Method References:

->It is technique to reduce lot of lambda code itself.


package com.ibm.com.ibm.fp;


@FunctionalInterface
interface Printer {
    void print(String value);
}

class MicroTaskRunner {
    public static void startMicroTaskStatic() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public void startMicroTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}

class Loop {

    //thread logic is isloated into a separate method
    private void startMicroTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public void start() {
        Thread thread = null;
        //thread logic
        thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
        thread = new Thread(() -> startMicroTask());
        thread.start();
        //method reference : refering method without using lambda syntax this::method-instance methods
        thread = new Thread(this::startMicroTask);
        thread.start();
        //method reference : outside the class  reference::method
        MicroTaskRunner microTaskRunner = new MicroTaskRunner();
        thread = new Thread(() -> microTaskRunner.startMicroTask());
        thread.start();
        thread = new Thread(microTaskRunner::startMicroTask);
        thread.start();
        thread = new Thread(new MicroTaskRunner()::startMicroTask);
        thread.start();
        thread = new Thread(MicroTaskRunner::startMicroTaskStatic);
        thread.start();

    }
}

public class methodreference {
    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.start();
        Printer printer = null;
        printer = value -> System.out.println(value);
        printer.print("Hello");

        printer = System.out::println;
        printer.print("Hello");


    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Advanced Uses:

if you want to implement lambda, you need functional interface.

Lets i want to design common interfaces which accepts and returns

-single input, no output
-two input , single output
-only integer input,return the same
-two any type of input,return boolean ; predicate
etc...
do you think that it is good idea to have your own functional interfaces for common uses cases

No!

Then what i should do? 

Java 8 provides java.util.function package which has lot of built in common use interfaces.

Important functional interfaces:
...............................
1.Consumer
2.Predicate
3.Supplier
4.UnaryOperator
5.BinaryOperator
6.Function

 		 T - any Type  <T>  - Generic type

 		nothing->T            Supplier
		T->nothing            Consumer
		T->T                  UnaryOperator
		T,T->T                BinaryOperator
		S->T                  Function
		T->boolean            Predicate


package com.ibm.com.ibm.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {
    public static void main(String[] args) {
        //Consumer :returns
        Consumer<String> consumer = null;
        consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Accept");
        consumer = value -> System.out.println(value);
        consumer.accept("Accept");
        //
        Supplier<String> supplier = null;
        supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        System.out.println(supplier.get());
        supplier = () -> "Hai";
        System.out.println(supplier.get());

        //consumer inside java apis : collections : iterators : forEach
        List<String> names = Arrays.asList("Subramanian", "Geetha", "Divya Sree");
        names.forEach(name-> System.out.println(name));
        names.forEach(System.out::println);

        Predicate<Integer> predicate = null;
        predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.intValue() == 10; // true or false
            }
        };
        String result = "";
        result = predicate.test(10) ? "True" : "False";
        System.out.println(result);

        predicate = value -> value.intValue() == 10;
        result = predicate.test(10) ? "True" : "False";
        System.out.println(result);


    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&


                                  Resilience4J
                                ................

Life Before Resilience4J:
..........................

Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.


latency and fault :

 latency   -slow
 fault     -Error /something went wrong.

Why netflx stop?

 They dont want to measure app performance,fault management using "Preconfigured" through
settings
  program settings -
    source code
    app config files -properties or yaml files
who recommends Resilience4 4J.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Resilience4j is a lightweight fault tolerance library inspired by Netflix Hystrix, but designed for functional programming.


Features of  Resilience4 4J

1.Provides two model of programming
  1.legacy style - Annotation style - OO
  2.higher-order functions(decorators) to enhance any functional interface, lambda expression or method reference with fault management apis.

2.It is very light weight when compare to hystrix
    RE4J has only one direct dependency  - Vavr,
     Vavr has no any external dependency
 hystrix has dependency archaius 
     - appche common, guava.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

                                Vavr
                            -------------
Vavr is an object-functional language extension to Java 8, which aims to reduce the lines of code and increase code quality. It provides persistent collections, functional abstractions for error handling, concurrent programming, pattern matching and much more.

Vavr fuses the power of object-oriented programming with the elegance and robustness of functional programming. The most interesting part is a feature-rich, persistent collection library that smoothly integrates with Java's standard collections.

Vavr inspired from Java 8 functional programming implementations
 -lambdas
 -streams

 Missing Main java 8 feature 
  - Immutablity

Immutable Collection: according to java 8 , not modifiable
   List<T> list = Collection.unmodifiableList(list)

   ///add
   list.add() //throw error.

Features:
.........
->Vavr Will give real immutable Collection , You can modify, but modification wont
happen on Original List instance rather it will create  new Instance.

According to Vavr, Collections are pure, immutable, functional style.

->Functional Implementation
  -Function Composition
  -Curry function
  -Higher Order Function
  -Lifting
  -Partial function
  -Switch..Case

-Vavr Values
  -Option
  -Try
  -Lazy
  -Either
  -Future
  
  Getting Started:

   <dependencies>
        <dependency>
            <groupId>io.vavr</groupId>
            <artifactId>vavr</artifactId>
            <version>0.10.2</version>
        </dependency>
    </dependencies>

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Collections:
............

->How to create immutable Collection.

Note:
Object creation:
 - Via constructor patterns
    SomeClass someRef=new SomeClass()
 -Via Factory
    SomeClass SomeRef = SomeClassFactory.factoryMethod()

    someClass().someapi().build() - Every api returns the same type of someClass

 If you want to create Object in Vavr we use factory method named "of"
   -> SOmeClass.of()=>Returns Object Reference
  
package com.ibm.fp.vavr;

import io.vavr.collection.List;
import io.vavr.collection.Queue;
import io.vavr.collection.SortedSet;
import io.vavr.collection.TreeSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class VavrCollectionDemo {
    public static void main(String[] args) {
        //List Cration

        List<String> names = List.of("Subramanian", "Raj", "Ram");
        names.forEach(name -> System.out.println(name));
        System.out.println(names.hashCode());
        List<String> newList = names.tail().prepend("Srisha");
        System.out.println(newList.hashCode());

        Queue<Integer> queue = Queue.of(1, 2, 5);
        System.out.println(queue);

        //Set
        SortedSet<Integer> set = TreeSet.of(6, 12, 78, 89);
        System.out.println(set);
        //Comparator
        Comparator<Integer> c = (a, b) -> b - a;
        SortedSet<Integer> reversed = TreeSet.of(c, 2, 3, 1, 2);
        System.out.println(reversed);

        //Stream api from java 8 and vavr also supports streams
        //Fluent Pattern , Pure functions,Immutablity
        System.out.println(Arrays.asList(30, 89, 67).stream().map(Integer::intValue).collect(Collectors.toList()));


    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Function Abstraction:

Java 8 Provides java.util.Function as generic functional interface.
-Drawbacks
   -It takes only one parameter
   -BiFunction which accepts two parameters

Vavr provides functions up to a limit of 8 parameters.
The interfaces are named as Function0,Function1,Function2.....8

How to declare functions?
package com.ibm.fp.vavr;


import io.vavr.Function2;
import io.vavr.Function1;

public class VaVrFunctionAbstraction {
    public static void main(String[] args) {
        Function2<Integer, Integer,Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 10));
        Function1<Integer, Integer> doubleMe = a1 -> a1 *2;
        System.out.println(doubleMe.apply(10));


    }
}

Advanced Functional Programming Concepts:
.........................................

1.Composition:
Functions can be chained together
Applying a function to the result of another function creates a new function.
The functions f: X → Y and g: Y → Z can be concatenated to form a function h: g (f (x)) with h: X → Z. 


    public static void composition() {
        //How to coimbine many functions togehter , forms new Function
        Function1<Integer, Integer> plusOne = a -> {
            System.out.println("PlusOne a's Value : " + a);
            return a + 1; // 2 +1 => 3
        };
        Function1<Integer, Integer> multiplyByTwo = a -> {
            System.out.println("multiplyByTwo  a's Value: " + a);
            return a * 2; //  3 * 2
        };

        //andThen Compose functions from left to right side
        Function1<Integer, Integer> plusOneAndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(plusOneAndMultiplyBy2.apply(3).intValue());

        System.out.println("...................");

        //andThen Compose functions from right to left side
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.compose(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());


    }

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Partial Functions: Partial Application:
.......................................

It allows you to derive a function from existing one by fixing some values.
You can fix one or more parameters, and the number of fixed parameters defines
the boundary of the new function.


    public static void partials() {
        //One parameter is fixed , the remaining parameters are dynamic
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //create new function
        Function1<Integer, Integer> adder = sum.apply(2);
        System.out.println(adder.apply(100));

    }

Curry Function:
 Curry is a concept to partially apply a function by fixing a value for one of the parameters.
    public static void curry() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> adder = sum.curried().apply(12);
        System.out.println(adder.apply(100));
    }
Caching : Memoization:
.......................
Memoization is a form of caching.A memoized function executes only once and then
returns the result from the a cache.
   public static void cache() {
        //Memoization
        Function0<Double> hashCache = Function0.of(Math::random).memoized();
        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1);
        System.out.println(randomValue2);
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
-Vavr Values
  -Option
  -Try
  -Lazy
  -Either
  -Future

Option:
.......
Option is used to invert NullPointerException. You can Treat null Pointer Exception in good way using functional style.

The result would either None or SOME
 optional *value*, no more nulls
Option<T> option = Option.of(...);



   public static void options() {
        //The result would either None or SOME
        // optional *value*, no more nulls
        //Option<T> option = Option.of(...);
        Option<String> maybeFoo = Option.of("foo");
        System.out.println(maybeFoo);
        //Get value
        System.out.println(maybeFoo.get());
        Option<String> maybeNone = Option.of(null);
        System.out.println(maybeNone);
        //System.out.println(maybeNone.get());
        //escape from the Runtime Error, handle it safely
        System.out.println(maybeNone.getOrNull());
        System.out.println(maybeNone.getOrElse("some default"));

    }
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Try : Functional Error Handling:
...............................

A value can be wrapped in a context
If one applies a function to the packed value, it can depending on the context have a different result.
Which represents a computation that may either result in an exception, or return a successfully computed value

Try(SUCCESS,FAILURE) =>ANY ONE

try{
 api call --->
}catch(){
 
}

class SomeClass {
    public static String doSomething() {
        String some = "somadfafafadfaf";
        if (some.length() < 5) {
            throw new RuntimeException("Invalid length");
        }
        return some;
    }
}

    public static void trys() {
        /**
         * try{
         *     SomeClass.doSomething()
         * }catch(Exception es){
         *
         * }
         */
        Try<String> sometry = Try.of(SomeClass::doSomething);
        System.out.println(sometry);
        //Get data if no error else
        // System.out.println(sometry.get());
        System.out.println(sometry.getOrElse("I am giving some values"));
        //Recover from Errors : Select alternate plans ,
        // if something goes wrong you may give data caching server
        String recovered = sometry.recover(throwable -> {
            return "From Cache"; // call cachingprovider.cacheapi
        }).get();
        System.out.println("Recovery :" + recovered);

        //fluent pattern
        sometry.onSuccess(s -> {
            System.out.println("On Success :" + s);
        }).onFailure(f -> System.out.println("On Failure : " + f)).andFinally(() -> {
                    System.out.println("Finally");
                });


    }
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Lazy:
Which represents lazy evaulated value, Compared to Supplier,Lazy is memoizing.

    //which represents a lazy evaluated value. Compared to a Supplier,
        // Lazy is memoizing, i.e. it evaluates only once and therefore is referentially transparent.
        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated()); // = false
        System.out.println(lazy.get());         // = 0.123 (random generated)
        System.out.println(lazy.isEvaluated()); // = true
        System.out.println(lazy.get());         // = 0.123 (memoized)
Either:
  Either represents a value of two possible types.
    -Left and Right

 public static void eithers() {
//Either represents a value of two possible types. An Either is either a Left or a Right
        Either<String, Integer> eithervalue = computeStuff(2);
        System.out.println("Test Either - IsLeft " + eithervalue.isLeft());
        System.out.println("Test Either - IsRight " + eithervalue.isRight());
        System.out.println(eithervalue.getOrElse(0));
    }

Future:
  A future is a computation result that becomes available at some point.
   -deferred execution.
 All operations are provided are non blocking.
 The underlying "Executor Service" is used to execute async handlers.

 Future handle async result - either success / failure.

public static void futures() throws InterruptedException {
        //A Future is a computation result that becomes available at some point. All operations provided are non-blocking.
        // The underlying ExecutorService is used to execute asynchronous handlers, e.g. via onComplete(â€¦â€‹)
        /**
         * A Future has two states: pending and completed.
         *
         * Pending: The computation is ongoing. Only a pending future may be completed or cancelled.
         *
         * Completed: The computation finished successfully with a result, failed with an exception or was cancelled.
         */
        Future<Integer> magicInt = Future.of(Executors.newSingleThreadExecutor(), () -> {
            System.out.println("We have begun");
            Stream<Integer> take = Stream.from(1).take(500);
            for (int t : take) {
                if (t % 1000 == 0)
                    System.out.println("t is now: " + t);
            }
            System.out.printf(Thread.currentThread().getName());

            return new Random().nextInt();
        }).onComplete(finalresult -> {
            System.out.println("YES WE ARE DONE WITH TOUGH WORK" + finalresult);
        });

        magicInt.await();
        System.out.println("is Completed: " + magicInt.isCompleted());
        System.out.println("Test Future - END");
    }


Functional Switch Case:

    //match --functional switch case
    public static void matches() {
        /**
         *     import static io.vavr.API.*;
         *     Having the static methods Match, Case and the atomic patterns
         *     $() - wildcard pattern
         *
         *     $(value) - equals pattern
         *
         *     $(predicate) - conditional pattern
         */
        Integer i = 10;

        Integer of1 = Match(i).of(
                Case($(1), 10),
                Case($(), 20)
        );
        String matched = Match(i).of(
                Case($(1), "xxx eet"),
                Case($(2), "value two")
                , Case($(), "default value... ?")
        );

        System.out.println("matched: " + matched);

        i=1;
        Option<String> match2 = Match(i).option(
                Case($(1), "Value 1"),
                Case($(2), "value two")
        );
        System.out.println(match2.getOrElse("0"));
  }

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Resillence4J-Fault tolerance Patterns:
.....................................

Patterns:
1.Bulk head
2.CircuitBreaker
3.RateLimiter
4.TimeLimiter(Timeout)
5.Retry

Coding:
Modularization :
 With Resilience4j you dont need to go all in one, you can pick up what you need.
Resilience4j provides several core modules and add-on modules:

core libs
resilience4j-circuitbreaker: Circuit breaking
resilience4j-ratelimiter: Rate limiting
resilience4j-bulkhead: Bulkheading
resilience4j-retry: Automatic retrying (sync and async)
resilience4j-cache: Result caching
resilience4j-timelimiter: Timeout handling

framework abstractions

resilience4j-spring-boot: Spring Boot Starter
resilience4j-spring-boot2: Spring Boot 2 Starter
resilience4j-ratpack: Ratpack Starter
resilience4j-Vertx: Vertx Future decorator

Mertics or Fault Management modules

Metrics modules
resilience4j-micrometer: Micrometer Metrics exporter
resilience4j-metrics: Dropwizard Metrics exporter
resilience4j-prometheus: Prometheus Metrics exporter

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Coding :

Two Spring Boot Project

-BackEnd
-FrontEnd

Front End
 -has list of Rest End point
Back End
 -has list of Rest End Point

 FrontEnd----SpringRestTemplate----------------------BackEnd

Project Creation:

1.Spring Project:
  https://start.spring.io/

BackEnd Application: Provider
.............................
application.properties
 server.port=8081

Controller: Which to be called by Other Application.

package com.example.resilence4jprovider;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@Log
public class MessageController {

    private static final int WAIT_TIME_MS = 1000;
    private int counter = 0;

    @GetMapping("/")
    public String okay() {
        return "I'm okay.";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(WAIT_TIME_MS);
        return "I'm okay, just slow";
    }

    @GetMapping("/error")
    public String error() {
        throw new InternalServerErrorException("I'm definitely not okay!");
    }

    @GetMapping("/erratic")
    public String erratic() throws InterruptedException {
        log.info(Integer.toString(counter++));
        if (ThreadLocalRandom.current().nextInt(0, 5) != 0) {
            log.info("erratic");
            throw new InternalServerErrorException("I am erratic");
        }
        log.info("ok");
        return "For I am ok!";
    }

}

Exception:
package com.example.resilence4jprovider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InternalServerErrorException
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String msg) {
        super(msg);
    }
    
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Consumer Application: Front End Application

application.properties
provider.uri=http://localhost:8081
maxConcurrent=1


main :

ResilienceConsumerApplication.java

package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ResilienceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilienceConsumerApplication.class, args);
	}

}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Communication:
  Consumer Application will call rest end point of Provider Application.
For Communicaiton we need Object-RestTemplate

Create RestTemplateBean: Inside Configuration.

package com.example.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerConfiguration
 */
@Configuration
public class ConsumerConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}

Resilence4J Depedency in pom.xml:
.................................

<dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-circuitbreaker</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-bulkhead</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-ratelimiter</artifactId>
            <version>1.0.0</version>
        </dependency>

        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-timelimiter</artifactId>
            <version>1.5.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-retry</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Implementation of Resilence4J: only for Functional Style;
.........................................................

General Steps for all Patterns:

1.Create configuration object
2.Create a Registry Object
3.Create or get a Resilence4J Object(Bulkhead,retry....)
4.Code the remote Operation as a lambada expression or a functional interface    direct implementation, a normal java method
5.create a decorator or wrapper around the code from step 4 using one helper methods
6.call the decorator method to invoke the remote operation.
   -get,apply...


Steps:

Creation:
    1.Configuration Object
    2.Create Registry Object
    3.Create BulkHead Object
...................................................
Decoration: Wrapping ; just like wrapping code inside try block in exeception block
  4.Decorate your call ---->Wrap the call 
...................................................
Execute a functional Interface
  5.TRY it - once execution done, handle it, watch it.


BulkHead:
.........

Step-1 : Create Configuration Object.

BulkHeadConfig config=BulkHeadConfig
                        .custom()
                        .maxConcurrentCalls(10)
                        .maxWaitDuration(Duration.ofMillis(100))
                        .build();

Step-2 : Create Registry with Global Configuration.


BulkHeadRegistry  registry=BuildHeadRegistry.of(config);

Step 3 : Create BulkHead Object from the Registry.

BulkHead bulkHead=registry.bulkhead("mybulkhead");

*******************************************************************************
Execution: Where , where you want to call third party Service.

Step 4.1: Decorator : Decorator may vary implementation to implementation
BulkHeadDecorators:
 -Callable
 -Supplier
 -Runnable
 -Consumer
 -CheckedRunnable
 -CheckedSupplier
 -CheckedConsumer
 -CompletionStage

CheckedFunction0<String> decoratedSupplier=BulkHead.decorateCheckedSupplier(bulkhead,()->{
     //call external api /remote api
     return restTemplate.forObject(url);
 });

Step 4.2 : Execution : Handle Response: It could either SUCCESS /FAILURE

decoratedSupplier.get()---Triggers call.

Handling Resultion
Try<String> result=Try.Of(decoratedSupplier)
result
  .Onsuccess()
  .onFailure()
  .recover()
..............................................................................
Decorator Interfaces:

1.Callable and Runnable:
- Where you want execute async operations(Multi threaded env).

Callable vs Runnable:
Both interfaces are designed to represent a task that can be executed by multiple threads. Runnable tasks can be run using the Thread class or ExecutorService whereas Callables can be run only using the latter.

2.Supplier
     -Return result, no input
3.Consumer
    -No Return, it takes output.
decorate*
  decorateSupplier,decorateConsumer .....

  OurApplication will call remote Service, 
     -may give result.
     -may throw exeception
         -UnCheckedException
              decorate* api you can use
         -CheckedException
              deccorateChecked*
        you assume that remote service may throw, checked Exception.
    
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Bulk Head:
 Limit the number of concurrent remote operations.

 Concurrent : no of threads : Each thread considered one request

 Litmit the number of simultaneous requests to remote operations.

 Basic Bulkhead Config
 package com.example.consumer;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceRequestController {
    private final RestTemplate restTemplate;
    private final String providerUri;
    //BulkHead declaration
    private final Bulkhead bulkhead;

    public ServiceRequestController(RestTemplate restTemplate, @Value("${provider.uri}") String providerUri, @Value("${maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.providerUri = providerUri;
        //maxConcurrent value limits no of concurrent users allow to invoke remote api
        this.bulkhead = createBulkhead(maxConcurrent);

    }

    //configuration methods
    private Bulkhead createBulkhead(int maxConcurrent) {
        //Configuration
        BulkheadConfig bulkheadConfig = BulkheadConfig
                .custom()
                .maxConcurrentCalls(maxConcurrent)
                .build();
        //Registry if want ; optional
        //create BulkHead object with configuration.
        Bulkhead bulkhead = Bulkhead.of("bulkhead-app", bulkheadConfig);
        return bulkhead;
    }

    @GetMapping()
    public String okay() {
        return "The message of Provider Api  " + restTemplate.getForObject(providerUri, String.class);
    }

}

Events:


package com.example.consumer;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequestController.class);
    private final RestTemplate restTemplate;
    private final String providerUri;
    //BulkHead declaration
    private final Bulkhead bulkhead;


    public ServiceRequestController(RestTemplate restTemplate, @Value("${provider.uri}") String providerUri, @Value("${maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.providerUri = providerUri;
        //maxConcurrent value limits no of concurrent users allow to invoke remote api
        this.bulkhead = createBulkhead(maxConcurrent);
    }

    //configuration methods
    private Bulkhead createBulkhead(int maxConcurrent) {
        //Configuration
        BulkheadConfig bulkheadConfig = BulkheadConfig
                .custom()
                .maxConcurrentCalls(maxConcurrent)
                .build();
        //Registry if want ; optional
        //create BulkHead object with configuration.
        Bulkhead bulkhead = Bulkhead.of("bulkhead-app", bulkheadConfig);

        //add bulk head events to watch, bulk head operations.
        bulkhead.getEventPublisher()
                .onCallPermitted(event -> LOGGER.info("Call Permitted"))
                .onCallRejected(event -> LOGGER.info("Call Rejected"))
                .onCallFinished(event -> LOGGER.info("Call Completed"));

        return bulkhead;
    }

    @GetMapping()
    public String okay() {
        return "The message of Provider Api  " + restTemplate.getForObject(providerUri, String.class);
    }
    //End


}

Retry: Retry failed remote operations/request automatically 
..........................................................

When to use Retry?

- Sending an HTTP Request to a REST Point
- Calling a RPC or Web Service
- Reading and writing  data to/from a datastore-sql,nosql
- Sending and Receiving messages from message brokers-Rabbitmql,kafka..

We can call any api, operations are subject fail.

We have two options when a remote operation fails
  - immediately return an error to client
  - we may retry the operation.

  package com.example.consumer;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@RestController
public class ServiceRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequestController.class);
    private final RestTemplate restTemplate;
    private final String providerUri;
    //BulkHead declaration
    private final Bulkhead bulkhead;

    //Retry configuration
    private final Retry retry;

    public ServiceRequestController(RestTemplate restTemplate, @Value("${provider.uri}") String providerUri, @Value("${maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.providerUri = providerUri;
        //maxConcurrent value limits no of concurrent users allow to invoke remote api
        this.bulkhead = createBulkhead(maxConcurrent);
        this.retry = createRetry();
    }

    private Retry createRetry() {
        //Retry config
        RetryConfig config = RetryConfig
                .custom()
                .maxAttempts(25)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        //Retry Registry
        RetryRegistry registry = RetryRegistry.of(config);

        //Retry Instance
        Retry retry = registry.retry("app-retry");

        retry.getEventPublisher()
                .onRetry(r -> System.out.println("Retrying..... : " + r.getNumberOfRetryAttempts()))
                .onSuccess(e -> System.out.println("Retry success!!! : " + e.getNumberOfRetryAttempts()))
                .onError(e -> System.out.println("Retry error : " + e.getNumberOfRetryAttempts()));

        return retry;
    }

    //configuration methods
    private Bulkhead createBulkhead(int maxConcurrent) {
        //Configuration
        BulkheadConfig bulkheadConfig = BulkheadConfig
                .custom()
                .maxConcurrentCalls(maxConcurrent)
                .build();
        //Registry if want ; optional
        //create BulkHead object with configuration.
        Bulkhead bulkhead = Bulkhead.of("bulkhead-app", bulkheadConfig);

        //add bulk head events to watch, bulk head operations.
        bulkhead.getEventPublisher()
                .onCallPermitted(event -> LOGGER.info("Call Permitted"))
                .onCallRejected(event -> LOGGER.info("Call Rejected"))
                .onCallFinished(event -> LOGGER.info("Call Completed"));

        return bulkhead;
    }

    @GetMapping()
    public String okay() {
        return "The message of Provider Api  " + restTemplate.getForObject(providerUri, String.class);
    }

    //End point to simulate bulk head
    @GetMapping("/bulkhead")
    public String bulkHeadEndPoint() {
        //decoration only
        CheckedFunction0<String> someServiceCall = Bulkhead.decorateCheckedSupplier(bulkhead, () -> {
            //wrap remote api call.
            return "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class);
        });
        //Result Handler : you may get result or Failure
        Try<String> result = Try
                .of(someServiceCall)
                .recover((throwable) -> "This is a bulkhead fallback : You may return cached Response");
        //execute the method
        return result.get(); //which tri

    }

    //Retry end point

    @GetMapping("/retry")
    public String retry() throws Exception {
        CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry, () -> {
            return "The message was " + restTemplate.getForObject(providerUri, String.class);
        });
        Try<String> result = Try.of(retryableSupplier)
                .recover((throwable) -> "Hello world from recovery function");
        return result.get();
    }


}
.................................................................................

Time Limitter : Timeout:
.......................
Setting a limit on the amount of time we are willing to wait for an operation to complete is called time limitig.
if operation does not complete within the time we specifed, we want to be notified about a timeout error.
This other wise called as "setting a deadline".

Why Timeout?
- users /clients/ programs/services not need wait indefinitely.


    @GetMapping("/timeout")
    public String timeoutEndPoint() throws Exception {
        //Timeout code has to be wrapped inside Future.
        String result = timeLimiter.executeFutureSupplier(
                () -> CompletableFuture.supplyAsync(() -> "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class)));
        return result;
    }

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

CircuitBreaker:

State:
OPEN
  -For handling failures
CLOSED
 -For Handling success
HALF-OPEN
 -transition 

CB : 
 -Will take decision , that when to open or close circuit

CB can handle

->failure calls
failureRateThreshold : 50
    When the failure rate is equal or greater than the threshold the CircuitBreaker transitions to open and starts short-circuiting calls.
CLOSED ----OPEN---|
->slow calls

Exception and CircuitBreaker:

Flow
1
Service A----calls----CB-------ServiceB

2.
Service A----calls----CB<---throw Exception----ServiceB
   CB will open , Starts Handling Failures.

3.As a biz owner , you have to decide , Should i Open Circuit for all Exceptions
  or not.
    private final CircuitBreaker circuitBreaker;

     private CircuitBreaker createCircuitBreaker() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(20000)).build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("resilience-provider", circuitBreakerConfig);

        circuitBreaker.getEventPublisher().onSuccess(event -> LOGGER.info("Call success via circuit breaker"))
                .onCallNotPermitted(event -> LOGGER.info("Call denied by circuit breaker"))
                .onError(event -> LOGGER.info("Call failed via circuit breaker"));
        return circuitBreaker;
    }

  @GetMapping("/circuitbreaker")
    public String circuitBreakerFail(@RequestParam boolean shouldFail) {
        if (shouldFail) {
            return callServiceViaCircuitBreaker("/error");
        } else {
            return callServiceViaCircuitBreaker("/");
        }
    }

&&&
Full Code:
package com.example.consumer;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@RestController
public class ServiceRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequestController.class);
    private final RestTemplate restTemplate;
    private final String providerUri;
    //BulkHead declaration
    private final Bulkhead bulkhead;
    //Retry configuration
    private final Retry retry;
    //Timeout
    private final TimeLimiter timeLimiter;

    //CB
    private final CircuitBreaker circuitBreaker;

    public ServiceRequestController(RestTemplate restTemplate, @Value("${provider.uri}") String providerUri, @Value("${maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.providerUri = providerUri;
        //maxConcurrent value limits no of concurrent users allow to invoke remote api
        this.bulkhead = createBulkhead(maxConcurrent);
        this.retry = createRetry();
        this.timeLimiter = createTimeLimiter();
        this.circuitBreaker = createCircuitBreaker();
    }
    private CircuitBreaker createCircuitBreaker() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(20000)).build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("resilience-provider", circuitBreakerConfig);

        circuitBreaker.getEventPublisher().onSuccess(event -> LOGGER.info("Call success via circuit breaker"))
                .onCallNotPermitted(event -> LOGGER.info("Call denied by circuit breaker"))
                .onError(event -> LOGGER.info("Call failed via circuit breaker"));
        return circuitBreaker;
    }

    private TimeLimiter createTimeLimiter() {

        //Time limitter config
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(6000))
                .build();

        //Timer limitter
        TimeLimiter timeLimiter = TimeLimiter.of("timelimiter-app", config);


        timeLimiter.getEventPublisher().onSuccess(event -> {
            LOGGER.info("Timeout call is going");
        }).onTimeout(event -> {
            LOGGER.info("Timeout");
        }).onError(err -> {
            LOGGER.info("Error " + err.toString());
        });

        return timeLimiter;
    }

    private Retry createRetry() {
        //Retry config
        RetryConfig config = RetryConfig
                .custom()
                .maxAttempts(25)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        //Retry Registry
        RetryRegistry registry = RetryRegistry.of(config);

        //Retry Instance
        Retry retry = registry.retry("app-retry");

        retry.getEventPublisher()
                .onRetry(r -> System.out.println("Retrying..... : " + r.getNumberOfRetryAttempts()))
                .onSuccess(e -> System.out.println("Retry success!!! : " + e.getNumberOfRetryAttempts()))
                .onError(e -> System.out.println("Retry error : " + e.getNumberOfRetryAttempts()));

        return retry;
    }

    //configuration methods
    private Bulkhead createBulkhead(int maxConcurrent) {
        //Configuration
        BulkheadConfig bulkheadConfig = BulkheadConfig
                .custom()
                .maxConcurrentCalls(maxConcurrent)
                .build();
        //Registry if want ; optional
        //create BulkHead object with configuration.
        Bulkhead bulkhead = Bulkhead.of("bulkhead-app", bulkheadConfig);

        //add bulk head events to watch, bulk head operations.
        bulkhead.getEventPublisher()
                .onCallPermitted(event -> LOGGER.info("Call Permitted"))
                .onCallRejected(event -> LOGGER.info("Call Rejected"))
                .onCallFinished(event -> LOGGER.info("Call Completed"));

        return bulkhead;
    }

    @GetMapping()
    public String okay() {
        return "The message of Provider Api  " + restTemplate.getForObject(providerUri, String.class);
    }

    //End point to simulate bulk head
    @GetMapping("/bulkhead")
    public String bulkHeadEndPoint() {
        //decoration only
        CheckedFunction0<String> someServiceCall = Bulkhead.decorateCheckedSupplier(bulkhead, () -> {
            //wrap remote api call.
            return "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class);
        });
        //Result Handler : you may get result or Failure
        Try<String> result = Try
                .of(someServiceCall)
                .recover((throwable) -> "This is a bulkhead fallback : You may return cached Response");
        //execute the method
        return result.get(); //which tri

    }

    //Retry end point

    @GetMapping("/retry")
    public String retry() throws Exception {
        CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry, () -> {
            return "The message was " + restTemplate.getForObject(providerUri, String.class);
        });
        Try<String> result = Try.of(retryableSupplier)
                .recover((throwable) -> "Hello world from recovery function");
        return result.get();
    }

    @GetMapping("/timeout")
    public String timeoutEndPoint() throws Exception {
        //Timeout code has to be wrapped inside Future.
        String result = timeLimiter.executeFutureSupplier(
                () -> CompletableFuture.supplyAsync(() -> "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class)));
        return result;
    }

    @GetMapping("/circuitbreaker")
    public String circuitBreakerFail(@RequestParam boolean shouldFail) {
        if (shouldFail) {
            return callServiceViaCircuitBreaker("/error");
        } else {
            return callServiceViaCircuitBreaker("/");
        }
    }
    private String callServiceViaCircuitBreaker(String uri) {
        CheckedFunction0<String> someServiceCall = CircuitBreaker.decorateCheckedSupplier(circuitBreaker,
                () -> "The message was " + restTemplate.getForObject(providerUri + uri, String.class));
        Try<String> result = Try.of(someServiceCall)
                .recover((throwable) -> "This is a circuit breaker fallback");
        return result.get();
    }


}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Annotation Based Programming:
............................

-Annotation are used to decorate methods where you are going to call third party
apis

-application.properties /yml file can be used to supply configurations.
 -CB,TIMO,BH....

 Metrics Module:
 
 
 Why metrics:

 ->Monitoring system

 Eg:
   - how many cb open state
   -  how many cb closed state
   - how many concurrent calls
 
 MeterRegistry meterRegistry = new SimpleMeterRegistry();
CircuitBreakerRegistry circuitBreakerRegistry =
  CircuitBreakerRegistry.ofDefaults();
CircuitBreaker foo = circuitBreakerRegistry
  .circuitBreaker("backendA");
CircuitBreaker boo = circuitBreakerRegistry
  .circuitBreaker("backendB");

TaggedCircuitBreakerMetrics
  .ofCircuitBreakerRegistry(circuitBreakerRegistry)
  .bindTo(meterRegistry)
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&



What is Reactive Programming ?

 Programming Paradigm(way) like oo,fp,pro

What is Reactive?

  Oxford dictionary defines reactive  as "showing a response to a stimulus"

Response :  The result
Stimuls : trigger/actions ---Events

 Get Response because of some events --- event driven programming model.

Event dirven programming is extension of  oo:Observable Design pattern.

Reactive programming is collection of many design patterns and principles.

 -Observable Design pattern
 -Iterator Design pattern
 -Functional style pattern



-Observable Design pattern
				
				Publisher/Owner/Producer
					|
	      -----------------------------------------------------------------			
	     |                   |          |           |
          Listeners            Subscriber  Subscriber Subscriber
			


How objects communicate

      
  By passing messages via method calls with intermediate object (Event).


Publisher sends/publishes data with events via broker called notfication interface to subcribers



          	Publisher/Owner/Producer
					|
			 data + event(Event)
					|
		Event Notification Interface
					|
	      -----------------------------------------------------------------			
	     |                   |          |           |
          Listeners            Subscriber  Subscriber Subscriber


Subscribers are objects who are listening for events, once event is given, who process event and consume take.


Problems of existing Observable Pattern:
.........................................

Legacy observer design pattern has only 1 thing

  1.they will be able to send only data

Have not addresssed the following
  1.what if error is produced
  2.what if the producer has stopped producing values. 

Reactive programming address the above issues.

Producer can send data,error, complete - events/signals

	Publisher/Owner/Producer <---------Data Source(Device)
					|
				 data / error  & complete
					|
			       Event Notification Interface
					|
			------------------------------------- channels
			|               |                  |
                     data              error              complete

			|		|		   |
			------------------------------------
					  |
				      Subscriber
			
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Iterator Design Pattern design:

				   DataSource-List/Collection -Object
				    (1,2,3,4,5,6,7,8,9,10)
					  |
					Iterator - PULL Alogorthim- get/read/request(N)
					   |
				   Subscribers

PULL Based iterator , is default iterator already implemented in many languages.


Drawbacks of pull based iterator :

1.both object should sync each other.
2.only data will be pulled via iterator.next/get/read/request call
3.Errors are handled via try...catch.
4.No complete signal is given.
5.all data must be loaded in advance- memory waste
6.live data may not be processed on fly.

Publisher/Owner/Producer <---------Data Source(Device)
					|
				  push data into memory over time.
					|
				  -----------------------------
                                      1---2---3--4--error--5--|-->
				  ------------------------------
                        		|    
				     emit event data,data -complete           	
			
				 data / error  & complete
					|
			       Event Notification Interface
					|
			------------------------------------- channels
			|               |                  |
                     data              error              complete

			|		|		   |
			------------------------------------
					  |
				      Subscriber
When error or complete signal is given, channel will be closed.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Reactive Programs are functional style based.

 -Pure functions
 -Immutablity
 -Higher order functions: function composition.

 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Reactive  = {observable + iterator(push + pull=Reactive PUSH) + functional style} 

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Application of Reactive Programming:
....................................

                             DATA Movement -IO
                             DATA PROCESSING - BIZ LOGIC
                             DATA STORAGE - DATA STORE

DATA MOVEMENT IN HTTP CHANNEL:
DataBase Server -100 rows
  |
read
 |
Web Server ----writes into HTTP Channel------------------Delivered to Clients


all 100 rows written into http and flushed to clients : traditional io

row by row written and delivered to client row by row : streaming.
--------------------------------------------------------------------------------

Processing Data :

Lets say I have list of Employee Objects.
List?

- I want to convert all employee names in uppercase
- I want to filter employees who's salary is less than 100k
- I want to filter those employees rating should be greater than 5
- print all the employee name and department.


Reactive is just spec, what about implementation? who has given this implementation.

Reactive spec initally implemented not as open source project , by netflex ->
  RxJava 1.0 - open source.
 

**********************************************************************************************

Once Rxjava other extensions came into market,peopel started building reactive application.

one point of time, people had confusion.

Whether my system is Reactive?

Many companies like ms,google,netflex,amzon....joined together who published one spec
https://www.reactivemanifesto.org/
**********************************************************************************************
Where is reactive Programming ? Use case of Reactive Programming?


   ********Data  Streaming and Processing in blocking and nonblocking *******

Data Processing  y comapare with Batch processing.....

Pipe lines : streaming of data.

Stream :

     Sequence of data / flow of data which is supplied and consumed


Stream Types:

1.Source Stream
2.Intermediate Stream 

 ->Up Stream
 ->Down Stream
********************************************************************************************

Core Concepts in Reactive Programming:
......................................

1.Publisher
   Publisher is Object
2.Subscriber
   Subscriber is also Object
3.Stream
  logical representation of data movement

Java and Reactive Programming implementation:
  Reactive programming spec 

1.Rxjava 1.x
2.Rxjava 2.x ,Rx 3.x
3.Project Reactor
4.Java 9

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Programming implementation:

Select Framework / Lib:

-> RXJAVA

-> Project Reactor.


Publisher
  1.Observable
	 2.Subject
	    AsyncSubject...
  	 3.Single
         4.MayBe

2.Observer
   Subscriber who is listening for data.


3.Operators
    Operators are methods in java, which performes some data processing operations.

Operators are like work stations in "assembly line analogy". Operators forms upstream and downstream.


Steps:
1.data source , where data is available ; primtives,array,list,...
2.Observable - Source Stream
 -create Stream/Observable
 factory apis:
   -create
   -other factory methods
3.subscription

processing data

1.data source , where data is available ; primtives,array,list,...
2.Observable - Source Stream
 -create Stream/Observable
 factory apis:
   -create
   -other factory methods

3.processing data using operators- filter,map,zip,....
   -forms up stream and down stream.

4.subscription
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamProcessing {
    //Stream Processing
    public static void processStreams() {
        //create of data
        Observable<Integer> stream = Observable
                .just(1, 2, 3, 4, 5, 6, 7) //source /upstream
                .map(x -> x * 2) //down stream / upstream
                .filter(i -> i < 10); //down stream /upstream

        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void main(String[] args) {
        processStreams();
    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

UpStream
 sends data in sequence to next stream
Down Stream
 The streams Receives data from upstream

 A----B
Back Pressure:
 up stream is fast,down stream slow
   -data inconsistency
   -data loss
   -low latency
   etc....
How to handle back pressure?

 adding buffer , processing 

We have many algorthim
  -Buffer
  -Elimentates
........

Observable is object has no Buffer  feature by default.


Rxjava2 introduced new Object eq to Observable---Flowable.

There is spec which talks about standard back pressure solution
                         "Reactive Streams"
             
Reactive Streams is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure.

Reactive Streams is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure. This encompasses efforts aimed at runtime environments (JVM and JavaScript) as well as network protocols.


The Team provided common spec:

1.Publisher
2.Subscriber
3.Subscription
4.Processor

Rxjava Back Pressure Implementation:
  Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4);
        flowable.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Back Pressured");
        });
    }
Non Blocking and Async Programming:
...................................
package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NonBlocking {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Hello")
                .observeOn(Schedulers.newThread())
                .map(String::toUpperCase)
                .doOnNext(d -> {
                    System.out.println(Thread.currentThread().getName());
                })
                .observeOn(Schedulers.newThread())
                .subscribe(s->{
                    System.out.println(Thread.currentThread().getName());
                });

        Thread.sleep(500);
    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

    Birth of Project Reactor


Project Reactor born with 
- simple , meaning full Publisher apis
- BackPressure Ready
- Non Blocking Ready-Netty Engine Engine
- fully reactive stream implementation

How Project Reactor Handles BackPressure:

  "Defered pull-push" : Reactive pull

 Defered means "postphone/dealy" : consumer can delay consuming data.
 Consumer can tell producer give N elements only.

Project Reactor has slogon ----->  "Nothing happens until you subscribe"

Pull because at the subscription and request steps, the Subscriber will send a signal to producer /upstream up to the source and essentially pull the next chunk of data

  Producer pushes data , where consumer pulls data 

*********************************************************************************************

Objects

1.Flux ---->Flowable --- o..to N
2.Mono --- Flowable ---- o-1
3.Operators
4.Schedulers

package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamProcessing {
    //Stream Processing
    public static void processStreams() {
        //create of data
        Observable<Integer> stream = Observable
                .just(1, 2, 3, 4, 5, 6, 7) //source /upstream
                .map(x -> x * 2) //down stream / upstream
                .filter(i -> i < 10); //down stream /upstream
        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void main(String[] args) {
        processStreams();
    }
}

package com.ibm.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ProjectReactor {

    public static void controlBackpressure() {
        Flux<Integer> producer = Flux.range(1, 100);

        producer.log().subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Subscription is done");
                //ask the upstream how many elements you want
                //s.request(3); //requests only 3 elements
                //request all elements
                s.request(10); // request(unbound)
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Data " + value);

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error  " + t.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("Completed ");

            }
        });
    }

    public static void main(String[] args) {
        Flux<String> producer = Flux.create(fluxSink -> {
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.complete();

        });
        producer.log().subscribe();

        Flux<Integer> justproducer = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        justproducer.log().subscribe();

        Flux<Integer> rangeProducer = Flux.range(1, 100);
        rangeProducer.log().subscribe();

        controlBackpressure();
    }
}

package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class StreamCreation {
    public static void createoperator() {
        //create method : push data- emit data event, push error - error event is emitted,complete
        Observable<Integer> stream = Observable.create(observer -> {
            //push
            observer.onNext(1);
            observer.onNext(2);
            //observer.onError(new RuntimeException("Errr"));
            observer.onNext(3);
            observer.onComplete();

        });

        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void createStramingUsingJust() {
        //create of data
        Observable<Integer> stream = Observable.just(1, 2, 3, 4, 5, 6, 7);
        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void createStramingUsingArray() {
        //create of data
        int[] list = {1, 2, 3, 4, 5, 6, 7};
        Observable<int[]> stream = Observable.fromArray(list);
        //subscriber
        stream.subscribe(data -> {
            System.out.println(data[0]);
        }, err -> System.out.println(err), () -> {
            System.out.println("Stream completed : Int Array");
        });
    }

    public static void createStramingUsingList() {
        //create of data
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> mylist =Arrays.asList(array);
        Observable stream = Observable.fromIterable(mylist);
        //subscriber
        stream.subscribe(data -> {
            System.out.println(data);
        }, err -> System.out.println(err), () -> {
            System.out.println("Stream completed : List Array");
        });
    }
    public static void main(String[] args) {
//        createoperator();
//        createStramingUsingJust();
//        createStramingUsingArray();
        createStramingUsingList();
    }
}

package com.ibm.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ProjectReactor {

    public static void controlBackpressure() {
        Flux<Integer> producer = Flux.range(1, 100);

        producer.log().subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Subscription is done");
                //ask the upstream how many elements you want
                //s.request(3); //requests only 3 elements
                //request all elements
                s.request(10); // request(unbound)
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Data " + value);

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error  " + t.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("Completed ");

            }
        });
    }

    public static void main(String[] args) {
        Flux<String> producer = Flux.create(fluxSink -> {
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.complete();

        });
        producer.log().subscribe();

        Flux<Integer> justproducer = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        justproducer.log().subscribe();

        Flux<Integer> rangeProducer = Flux.range(1, 100);
        rangeProducer.log().subscribe();

        controlBackpressure();
    }
}




















































 
























































































































