# CafeOBJ-to-Java mapping example

Here you will find the results a simple experiment, how [CafeOBJ](https://cafeobj.org/) 
signatures (i.e., sort names and operations) can be mapped to Java "stubs". 
The basic mapping idea has been described in a report, which you will find 
[here](https://www.researchgate.net/profile/Benno_Schmidt) soon.

## The source code
In the [source folder](https://github.com/bogeo/BennosCafe/javaBennos/source), you 
will find a simple CafeOBJ specification of the POI-recommendation problem. The 
module file (extension .mod) given there has been mapped to simple Java stubs. 
(The .cafe might be useful who those who are interested in the description of the
POI-recommender problem.)
 
## Mapping configuration
The [mapping folder](https://github.com/bogeo/BennosCafe/javaBennos/mapping) contains
the mapping information files used to generate the Java stubs. This are Java code
templates and a configuration file to define substitutions of identifier names.

## The target code
The generated Java code has been put to the 
[target folder](https://github.com/bogeo/BennosCafe/javaBennos/target). Note that 
it is intended to have all those TODOs in the target code to illustrate the working 
mechanism. However, after finishing the CafeOBJ-to-Java mapping transformation, 
additional code has been added to the stubs to get a very simple runnable 
POI-recommendation system. This code fragments have been marked with 

    // -- { add_impl_begin }
    ...
    // -- { add_impl_end }

comments in the Java code. 

## Software requirements
We have been used [CafeOBJ](https://cafeobj.org/) version 1.5.8 to build the 
executable source module and Java SE 1.6 to run the target model.

Comments and suggestions are welcome!