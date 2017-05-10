# listsorter

A listsorter generating a randomly ordered list to be sorted using random numbers decide which values to compare and switch in the case the first of the two is bigger than the second. The app should save the data in a db and be able to retrieve earlier sortings at startup of the app.
You will need to configure a MySql instance and add it to the application through application.properties before starting up the app.
The app is build in Spring boot, using java 8, and @SpringBootTest so to run the app see to that the db is up running, that the db is configured with the correct settings in the application.properties in src/main/resources run the app using mvn spring-boot:run command so the tests manage to retrieve the context correctly.
