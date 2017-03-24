Ristretto Parser
================

Author: Giacomo Del Rio

Content:
	bin			compiled java classes
	dist		redistributable jar file
	grammar		ANTLR4 grammar for Ristretto
	lib			jar dependencies
	samples		some Ristretto examples
	src			source files
	
To automate compilation and jar creation I provided an ant build file.


Compile and build jar
---------------------

$ cd RistrettoParser
$ ant compile
$ ant makejar


Usage
-----

java -jar ristretto-delrio.jar [-v] [-dot dotfile] infile
	-v: verbose
	-dot dotfile: creates a dot representation of the AST into "dotfile"
	infile: ristretto file to be parsed
	
Example:

$ cd RistrettoParser
$ java -jar dist/ristretto-delrio.jar -v samples/simple.ristr
