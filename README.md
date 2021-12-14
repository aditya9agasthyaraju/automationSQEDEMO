## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 1.  verify the basic UI of the Page(whether all the respective element will get displayed or not)
 2.  Verify whether user is able to place the Pizza order with no toppings
 3.  Verify whether user is able to place order with one toppings
 4.  Verify whether user is able to place with multiple toppings
 5.  verify whether correct cost is getting calculated or not on the basis of pizza selected
 6.  Verify whether user is getting a proper error message on without providing any details for pickup information
 7.  Verify whether is getting proper error message without selecting any payment
 8.  verify whether user is getting proper error message on without selecting the quantity
 9.  Verify whether user is able to getting error message on not selecting any payment & selecting valid details from pickup information


#### Defects
 1.  User is able to place order without selecting any quantity 
 2. User is able to place order without selecting any payment option
 3. Error msg is not getting displayed for without providing phone number in pickup information

