ChangeLog Microservice
==========================================

The service is implemented in Java using Spring and Spring Cloud
The implementation is exposing a REST API for CRUD Operatios using a GemFire installation.


Technologies
------------

- GemFire
- Spring Boot
- Spring Cloud



How To Compile
--------------

The microservice can be compiled with:

```
gradle clean build
```

Before Run
----------

The microservice uses a GemFire v8.2 installation where the ChangeLog region needs to be created.
Once GemFire has been installed, the region can be created using the following commands:

Inside a command prompt, execute the next command to start the GemFire Shell.

```
gfsh
```

Once inside the GemFire Shelle execute the following commands:

First, start a GemFire locator. You must specify the name and port.

```
start locator --name=locator1 --port=41111 --host=localhost
```

Now, start a GemFire server. You need to specify the name.

```
start server --name=server1
```

With locator and server created, proceed to create the region with the following command.
The region name must match with the name specified in the annotated class represented in Java.

```
create region --name=ChangeLog --type=REPLICATE
```

Finally, start pulse the use browser to check GemFire servers and regions:

```
start pulse
```



How To Run
----------

The microservice can be started with:

```
gradle bootRun
```



How To Test
----------

The microservice can be tested with:

```
gradle test
```



