# Application links in SCP CF

https://employeeslist-java.cfapps.eu10.hana.ondemand.com/employees

https://employeeslist-java.cfapps.eu10.hana.ondemand.com/create

https://approuter-springboot.cfapps.eu10.hana.ondemand.com

https://approuter-springboot.cfapps.eu10.hana.ondemand.com/odata.svc/Employees

https://S0017254285trial.authentication.eu10.hana.ondemand.com/config?action=who

# Blogs and tutorials about this scenario

https://blogs.sap.com/2015/12/08/sap-hana-sps-11-new-developer-features-hdi/

https://help.sap.com/doc/4505d0bdaf4948449b7f7379d24d0f0d/2.0.01/en-US/b3092cdd8e754a08a9e86006a53c4cca.html

https://www.sap.com/developer/tutorials/xsa-hdi-module.html

https://blogs.sap.com/2017/05/15/step-1-with-sap-s4hana-cloud-sdk-set-up/

https://blogs.sap.com/2017/05/19/step-3-with-sap-s4hana-cloud-sdk-helloworld-on-scp-cloudfoundry/

https://blogs.sap.com/2017/05/21/step-4-with-sap-s4hana-cloud-sdk-calling-an-odata-service/

https://blogs.sap.com/2017/06/23/step-5-resilience-with-hystrix/

https://blogs.sap.com/2017/12/20/deep-dive-6-with-sap-s4hana-cloud-sdk-extend-your-cloud-foundry-application-with-tenant-aware-persistency/

https://blogs.sap.com/2017/07/18/step-7-with-sap-s4hana-cloud-sdk-secure-your-application-on-sap-cloud-platform-cloudfoundry/

https://blogs.sap.com/2017/09/11/step-10-with-sap-s4hana-cloud-sdk-virtual-data-model-for-odata/

https://blogs.sap.com/2017/09/19/step-12-with-sap-s4hana-cloud-sdk-automated-testing/

https://blogs.sap.com/2017/09/19/step-12-with-sap-s4hana-cloud-sdk-automated-testing/

https://blogs.sap.com/2017/09/20/continuous-integration-and-delivery/

https://blogs.sap.com/2017/12/07/step-19-with-s4hana-cloud-sdk-mocking-s4hana-calls-or-how-to-develop-an-s4hana-extension-without-an-s4hana-system/

# NPM commands

npm config set @sap:registry https://npm.sap.com

# CF commands

cf -help -a

java -jar mta.jar -build-target=CF build

cf deploy cloud-employeeslistapp-springboot.mtar

cf create-service xsuaa application xsuaa-springboot -c xs-security.json

cf update-service xsuaa-springboot -c xs-security.json

cf allow-space-ssh SPACE_NAME

cf enable-ssh APP_NAME

cf security-groups

cf security-group SECURITY_GROUP

cf ssh -L localhost:30015:<host>:<port> <application_name> -N

cf m  

cf cs application-logs lite app-logs  

cf bs employeeslist-java app-logs 

cf restage employeeslist-java

https://docs.cloudfoundry.org/devguide/deploy-apps/ssh-apps.html

C:\Users\fabiano.a.rosa>cf curl /v2/info

{
   "name": "",
   "build": "",
   "support": "https://help.cf.eu10.hana.ondemand.com",
   "version": 0,
   "description": "Cloud Foundry at SAP Cloud Platform",
   "authorization_endpoint": "https://login.cf.eu10.hana.ondemand.com",
   "token_endpoint": "https://uaa.cf.eu10.hana.ondemand.com",
   "min_cli_version": null,
   "min_recommended_cli_version": null,
   "api_version": "2.98.0",
   "app_ssh_endpoint": "ssh.cf.eu10.hana.ondemand.com:2222",
   "app_ssh_host_key_fingerprint": "f3:12:47:b5:3a:19:6e:6c:4e:9d:90:2e:6f:8e:87:cc",
   "app_ssh_oauth_client": "ssh-proxy",
   "doppler_logging_endpoint": "wss://doppler.cf.eu10.hana.ondemand.com:443"
}


ssh -p 2222 cf:f3:12:47:b5:3a:19:6e:6c:4e:9d:90:2e:6f:8e:87:cc/0@ssh.cf.eu10.hana.ondemand.com

mvn install:install-file -Dfile=ngdbc.jar -DgroupId=com.sap.db.jdbc -DartifactId=ngdbc -Dversion=2.0.14 -Dpackaging=jar

-------------------------------------------- 

XSUAA

https://blogs.sap.com/2017/11/16/guide-for-user-authentication-and-authorization-in-sap-cloud-platform/

-------------------------------------------- 
Retrieve Credentials for Remote Applications
https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/0f48b2e84d73489692450ea7bf4d1916.html
--------------------------------------------

cf create-service-key xsuaa-springboot xsuaa-springboot-java-sk

cf service-key xsuaa-springboot xsuaa-springboot-java-sk


{
 "clientid": "sb-employeeslist-java!t2404",
 "clientsecret": "o3ySpV8AENXYfowb2YNvuPSRG6o=",
 "identityzone": "s0017254285trial",
 "identityzoneid": "c3c3bee0-2a33-49db-a7b3-203c72531d7c",
 "sburl": "https://internal-xsuaa.authentication.eu10.hana.ondemand.com",
 "tenantid": "c3c3bee0-2a33-49db-a7b3-203c72531d7c",
 "tenantmode": "dedicated",
 "uaadomain": "authentication.eu10.hana.ondemand.com",
 "url": "https://s0017254285trial.authentication.eu10.hana.ondemand.com",
 "verificationkey": "-----BEGIN PUBLIC KEY-----MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAwThn6OO9kj0bchkOGkqYBnV1dQ3zU/xtj7Kj7nDd8nyRMcEWCtVzrzjzhiisRhlrzlRIEY82wRAZNGKMnw7cvCwNixcfcDJnjzgr2pJ+5/yDZUc0IXXyIWPZD+XdL+0EogC3d4+fqyvg/BF/F0t2hKHWr/UTXE6zrGhBKaL0d8rKfYd6olGWigFd+3+24CKI14zWVxUBtC+P9Fhngc9DRzkXqhxOK/EKn0HzSgotf5duq6Tmk9DCNM4sLW4+ERc6xzrgbeEexakabvax/Az9WZ4qhwgw+fwIhKIC7WLwCEJaRsW4m7NKkv+eJR2LKYesuQ9SVAJ3EXV86RwdnH4uAv7lQHsKURPVAQBlranSqyQu0EXs2N9OlWTxe+FyNkIvyZvoLrZl/CdlYc8AKxRm5rn2/88nkrYQ0XZSrnICM5FRWgVF2hn5KfZGwtBN85/D4Yck6B3ocMfyX7e4URUm9lRPQFUJGTXaZnEIge0R159HUwhTN1HvyXrs6uT1ZZmW+c3p47dw1+LmUf/hIf8zd+uvHQjIeHEJqxjqfyA8yqAFKRHKVFrwnwdMHIsRap2EKBhHMfeVf0P2th5C9MggYoGCvdIaIUgMBX3TtCdvGrcWML7hnyS2zkrlA8SoKJnRcRF2KxWKs355FhpHpzqyZflO5l98+O8wOsFjGpL9d0ECAwEAAQ==-----END PUBLIC KEY-----",
 "xsappname": "employeeslist-java!t2404"
}

https://docs.cloudfoundry.org/api/uaa/version/4.8.0/index.html#authorization-code-grant-2

https://docs.cloudfoundry.org/concepts/architecture/uaa.html

https://content.pivotal.io/blog/how-to-integrate-an-application-with-cloud-foundry-using-oauth2

https://help.sap.com/viewer/70cdad3d4f2f4af08c795a7c44081827/1.0/en-US/544ca556b7934a16850764c05e53050c.html

URL:

https://s0017254285trial.authentication.eu10.hana.ondemand.com/oauth/token?grant_type=client_credentials

Basic Authentication:

User: (clientid)

Password: (clientsecret)

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIyMTI5YjNiMzg4Nzk0NDY4YjNlMDgyYTk1ZmY5NzY0ZSIsImV4dF9hdHRyIjp7ImVuaGFuY2VyIjoiWFNVQUEifSwic3ViIjoic2ItZW1wbG95ZWVzbGlzdC1qYXZhIXQyNDA0IiwiYXV0aG9yaXRpZXMiOlsidWFhLnJlc291cmNlIl0sInNjb3BlIjpbInVhYS5yZXNvdXJjZSJdLCJjbGllbnRfaWQiOiJzYi1lbXBsb3llZXNsaXN0LWphdmEhdDI0MDQiLCJjaWQiOiJzYi1lbXBsb3llZXNsaXN0LWphdmEhdDI0MDQiLCJhenAiOiJzYi1lbXBsb3llZXNsaXN0LWphdmEhdDI0MDQiLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwicmV2X3NpZyI6IjE0YmJhOGIyIiwiaWF0IjoxNTIwMTcyOTY2LCJleHAiOjE1MjAyMTYxNjYsImlzcyI6Imh0dHA6Ly9zMDAxNzI1NDI4NXRyaWFsLmxvY2FsaG9zdDo4MDgwL3VhYS9vYXV0aC90b2tlbiIsInppZCI6ImMzYzNiZWUwLTJhMzMtNDlkYi1hN2IzLTIwM2M3MjUzMWQ3YyIsImF1ZCI6WyJ1YWEiLCJzYi1lbXBsb3llZXNsaXN0LWphdmEhdDI0MDQiXX0.eJJAAzMDV1FL9FFLvysY-eg-inNgEkSxE_bWsZPzc56xKiIYXfqd12j3KvCV2WlgSW5ETYPGnp07TXgPEdAV5IPg9ruJJ5wnImLJrycRux17h25uV9ngH3SNOpOqODHl4E_oi0c_XHS6ha_u65iH-Sqx9GvLaZLnGXgncfIeC8UKJjfl9AqXZEFd-0726ocRE2--KYlUiGwwgZEcmFtpfxpxlfx9YGX8D5t6UEQYEjr68cT8obx5_89tA8PI5y_pcZ7ndBhnIsG96XlCQ12S3Fg-G7i04TudNwqXkh9mtgFwPeMZ9S5acyKway2oEifUYs25YKI80vTcWJDsFh-8kgMzJOyrRqFeUV8m9Vu1XfvdlMNktIaCnRRp5K5u9M0grC_2eoCgn7Wg7eOg9MOfU9YjoZKVrHJWZ_4YmicbntlnmEJUjfYOPY_Uti_Sf16kS3c4HU2m4OnsAfx-TYX3IUztXiaxw1UCORL1EKgl4JOEST0wfR7WetE0U751xlRQR5XChJVutu9ONXWP8mXIrQjYi3tDs3h1tud0SPynhBGybzK6J-xz-BedT64yz6-LDsIleGFIgO3B_1BuzO30Qc14NZRFVmYrqlIRWiJaTuMm8abkbMsaLFqXLSINxJEhLzg0GNQ_y1ylIWbwxGgY7Z2alOcmpxJ9v1sOLBORu9Q",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "uaa.resource",
    "ext_attr": {
        "enhancer": "XSUAA"
    },
    "jti": "2129b3b388794468b3e082a95ff9764e"
}
