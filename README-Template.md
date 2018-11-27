# file-processing-app

This app polls a directory C:\SITA_TEST_TASK\IN for new files every 5 seconds.
 
If a new file is found, then the application should sum all the numbers in the file and create a new file containing the resulting value in the directory (C:\SITA_TEST_TASK\OUT)

When the input file is successfully processed it should be moved to the following directory (C:\SITA_TEST_TASK\PROCESSED) 

If an error occurs while processing the input file then the input file should be moved into the following directory (C:\SITA_TEST_TASK\ERROR) with .ERROR appended to the end of the filename. 

## Getting Started


### Prerequisites

Spring STS or Eclipse with Maven Build support 
Java 1.7 or Java 1.8 

create following directories - 
C:\SITA_TEST_TASK\IN
C:\SITA_TEST_TASK\OUT
C:\SITA_TEST_TASK\PROCESSED
C:\SITA_TEST_TASK\ERROR

## Running the tests

 Please refer src/test/java Folder . Right click the test case you want to run and select RunAs ->JunitTest

## Deployment

As This is simple backend utility . There is one class Named - ApplicationEntryPoint . Right click and run as Java applciation .

## Built With

Maven 

## Contributing


## Versioning
1.0.0.snapshot

## Authors

Deepali Mehndiratta

## License


## Acknowledgments



