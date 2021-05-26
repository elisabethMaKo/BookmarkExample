# TDD Basic Example

This project shows a basic TDD example with some of the most common annotations.

This project used Java and Maven.

We have to declare the maven-surefire-plugin in the pom.xml file and configure the dependencies of this plugin. 

We have to declare the following dependencies:

The junit-platform-surefire-provider dependency allows us to run tests that use either the “old” JUnit (3 or 4) or JUnit 5.

If we want to run tests that use either JUnit 3 or 4, we have to declare the junit-vintage-engine dependency.

If we want to run tests that use JUnit 5, we have to declare the junit-jupiter-engine dependency.

* Junit Jupiter Dependency graph
    - https://junit.org/junit5/docs/current/user-guide/
* JUnit Annotation
    - https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations

  
## Maven goals
### Run the unit tests
```
mvn clean test
```

### Generate javadoc for the source code
```
mvn javadoc:javadoc
```

### Generate javadoc for the test code
```
mvn javadoc:test-javadoc
```

### Generate Jacoco source code coverage report
```
mvn test jacoco:report
```

### Check if thresholds limits are achieved
```
mvn test jacoco:check
```

### Generates a PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage
```

### Generates a quicker PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage -DwithHistory
```

### Complete example

``` 
mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=4 -DtimestampedReports=false
```
## Jacoco dependencies
* https://github.com/pitest/pitest-junit5-plugin
  - https://mvnrepository.com/artifact/org.pitest/pitest-junit5-plugin
    - required to work with JUnit5

# Test Überlegungen
...
## bookmark a URL
--> URL is addable
#### Test ensure that we can add URL to URLlist
1. URL https://www.google.com is addable to listURL

...
### URL must be valid
--> the parts that make up an URL must be there
--> the URL validator class helps with identifying that 


### Rating 
--> Rating steht in einer Hashmap wo die URL der key ist, und das Rating erhöht wird

--> Url-Hashmap: key= tag und ausgebaut wird Url = value --> Rating Hashmap = value   

URL Hashmap bekommt die Rating-Hashmap als Entries 
--> fürs Rating abfrage der Url-Hashmap ob URL schon vorhanden  
--> wenn Ja muss int rating im richtigen Eintrag erhöht werden
###above works

--> we need to find existing entries --> if that is true we need to return the tag
--> with the tag we can find the url already excisting, and with the URL we can increas the rating


Entrypoint: addHashtoHash --> Url already exists () deletes entry --> tag --> ratingIncrease () --> rating++

## Rating 2nd atemped 
first attemped got to convoluted 
we now decided to have to hashmaps that were NOT linked: an URL-hashmap that would keep the urls as value and the tags 
as keys; and a rating hashmap that would keep the url as key and the rating as value; 
for the user it will make no difference, but for us in the backend it will be a lot easier 

###Testing:
test to see if the urls are valid
2 tests to add things to our hashmaps
we test to see if we can find a tagged url
test to see if we can increase the rating
test to see if we can remove the tag


