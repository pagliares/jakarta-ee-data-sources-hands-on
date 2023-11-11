# Jakarta EE datasources hands-on

## Commands used

 ./asadmin start-domain domain1 (Starts Payara/Glassfish)
 
 ./asadmin stop-domain domain1 (Stops Payara/Glassfish)

./asadmin restart-domain domain1 (Restart Payara/Glassfish)
  
 ./asadmin list-domains (List the domains in execution)
  
 ./asadmin version (version of Payara/Glassfish installed)
  
 ./asadmin deploy target/Data_Source_JPA-1.0-SNAPSHOT.war (Deploy to the Glassfish/Payara)
  
 ./asadmin redeploy --name Data_Source_JPA-1.0-SNAPSHOT target/Data_Source_JPA-1.0-SNAPSHOT.war (Redeploy to the Glassfish/Payara. The parameter --name only worked when I used the name of the war file, without war).

 curl localhost:8080/Data_Source_JPA-1.0-SNAPSHOT/rest/company/1
