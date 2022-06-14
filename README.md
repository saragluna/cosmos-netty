# cosmos-netty
To demo the cosmos and netty issue when using JPMS.

## Set up 
1. Check out the `azure-sdk-for-java` repo
   ```bash
   git clone git@github.com:Azure/azure-sdk-for-java.git
   ```
2. Install the latest `azure-cosmos` sdk into local maven repo, **Java 11 required**
   ```bash
   cd sdk/cosmos/azure-cosmos
   mvn clean install -DskipTests
   ```
3. Fill the cosmos `endpoint`, `key`, `database`, `container` in the `main` method of `DemoApplication`

## Run the application with combinations

> `Netty version` can be changed via uncomment specific netty.version in this project's pom file
>
> `module-info.java` should be changed in the source code of `azure-cosmos` before installing 
|Behavior| Netty 4.1.77.Final| Netty 4.1.76.Final | Netty 4.1.69.Final|
|--|--|--|--|
|`module-info.java` removing `requires io.netty.transport.epoll;`|can work|can work|java.lang.module.FindException: Module io.netty.transport.classes.epoll not found, required by com.azure.cosmos|
|`module-info.java` no changes|java.lang.module.FindException: Module io.netty.transport.epoll not found, required by com.azure.cosmos|can work|java.lang.module.FindException: Module io.netty.transport.classes.epoll not found, required by com.azure.cosmos|

