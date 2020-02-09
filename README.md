# Spring-boot-Contact-Management-Application
This Contact management Application is implemented using Spring Boot, Spring Data JPA, Spring MVC, In-memory H2 database and JQuery.

This Application doesn't concentrate much on UI part.

It uses only one table-

Contact       - to Store User's contact information like FirstName, LastName,Email id , Phone number & Status(Active/Inactive).<br>
<br>               
Using Spring Boot implementation, application workflow is being maintained as per microservices architectural design, so in future this service can be plugged in to microservices infrastructure and can be used as full fledge microservice.
 - Request Mapping using annotations and usage of Controller,Repository annotations
 - Front End Forms to Back End DataBinding
 - AutoWiring of required objects
 - Redirection from one controller to another using flash attributes<br>
 
As part of JPA Validator, this application implements
 - Null check , length check using annotations
 - Cross field verification using class level user defined annotations
 - Usage Valid and bindingresult annotation in controller classes<br>
 
 As part of Spring Data JPA 
 - Usage of CRUD repository 
 - Usage of findBy and delete methods using different name patterns<br>
 
As part of Hibernate ORM
  - Usage of Entity , ID annotations
  - Usage of Mapping annotations, used only unidirectional Many to One mapping
  - Usage of Query and Param annotations while using JPQL 
  - Usage of Transactional annotations while deleteby pattern methods <br>
  
 
 Extended features can be enabled in this application ?
 
 - AOP for logging and security session check before accessing critical controller methods
 - User access provisioning & Web security.
 - HATEOS implementation to provide extended details to clients.
 
 Steps to run the application-
 
 1. Application will be runnable to any environment by generating WAR, JAR.
 2. It can be deployed in Normal Spring IDE environment and can be tested as stand-alone application.
 3. Application port can be changed in application.properties for server.port, currently port is- 4005.
 4. Please change log file path in application.properties file (logging.file=)
 3. Below are details of resources in this application-
 
 Application Home URL- http://localhost:4005/home
 Application View Contacts- http://localhost:4005/all_contacts
 Add Contacts- http://localhost:4005/show_addcontact
 H2 DB Console- http://localhost:4005/h2-console
 
Functionalities on the application-
1. View all stored contact.
2. Add new contact with required validation on associated attributes
3. For all contact auto generated contact ID is being used for unique identification.
4. Update contact details.
5. Delete contact.
6. Activate/Inactivate contact on the update page.
7. All required functionalities are provided in each and every page to reduce number of user iterations and employ flexible workflow for contact management.
8. All requied exception handling is maintained.
9. Logging 

