# ristretto
Ristretto compiler for Compiler Construction 2017 course at USI.ch

Author: Giacomo Del Rio

## Content
* bin:			compiled java classes
* dist:			redistributable jar file
* grammar:		ANTLR4 grammar for Ristretto
* lib:			jar dependencies
* samples:		some Ristretto examples
* src:			source files
* test:			test cases
	
To automate compilation and jar creation I provided an ant build file.


## Compile and build jar

```bash
$ cd RistrettoParser
$ ant compile
$ ant makejar
```

## Usage

```bash
java -jar ristretto-delrio.jar command [options] filename
	command must be one of the following:
	    -p	 parse filename
	    -t	 parse and typecheck filename
    options can be:
        -v    verbose
        -dot outfile    write a dot representation of the intermediate language produced by the command into outfile
```

Example:

```bash
$ cd RistrettoParser
$ java -jar dist/ristretto-delrio.jar -p -v samples/simple.ristr
```

### Running test cases

To run a specific test suite execute the specific java class as explained below.

##### Static analysis and type checking test suite

```bash
$ java -cp dist/ristretto-delrio.jar ch.usi.delrig.ristretto.test.StaticAnalysisTest tests/staticAnalysis
```