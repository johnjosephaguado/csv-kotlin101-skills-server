# csv-kotlin101-skills-server

**Steps:**
1. Pull the latest code and open it with IntelliJ IDE
2. Build and Run


**To pre-load sample data:**
1. go to project src->main->resources
2. open data.sql
3. Modify or insert your test data

**Testing**
1. Sanity Test : http://localhost:7171/sanity
2. Export "Kotlin Server Tester.postman_collection.json" to POSTMAN
   1. Login endpoint
   2. Consultant endpoints
   3. Pull-down endpoints
   4. Search endpoint

3. Visit http://localhost:7171/h2-console to access H2 DB console 
   1. Save Settings : Generic H2 (Embedded)
   2. Setting Name  : Generic H2 (Embedded)
   3. Driver Class  : org.h2.Driver
   4. JDBC URL      : jdbc:h2:mem:testdb
   5. User Name     : sa
   6. Password      : password



