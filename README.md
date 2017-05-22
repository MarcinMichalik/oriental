# Oriental
Oriental is a simple library for OrientDB. Detach and atach solution is not always good for me. I map results to my domain class and this library make it easier.

## Usage

### Import

**Maven**

settings.xml
```xml
<profiles>
  <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-marcinmichalik-maven</id>
                    <name>bintray</name>
                    <url>http://dl.bintray.com/marcinmichalik/maven</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-marcinmichalik-maven</id>
                    <name>bintray-plugins</name>
                    <url>http://dl.bintray.com/marcinmichalik/maven</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile> 
  </profiles>
  <activeProfiles>
      <activeProfile>bintray</activeProfile>
  </activeProfiles>
```

oriental-core
```xml
<dependency>
  <groupId>me.michalik</groupId>
  <artifactId>oriental-core</artifactId>
  <version>1.0.0-alpha</version>
  <type>pom</type>
</dependency>
```
oriental-frames
```xml
<dependency>
  <groupId>me.michalik</groupId>
  <artifactId>oriental-frames</artifactId>
  <version>1.0.0-alpha</version>
  <type>pom</type>
</dependency>
```
**Gradle**

```groovy
repositories {
	maven {
		url  "http://dl.bintray.com/marcinmichalik/maven"
	}
}
```

oriental-core
```groovy
compile 'me.michalik:oriental-core:1.0.0-alpha'
```
oriental-frames
```groovy
compile 'me.michalik:oriental-frames:1.0.0-alpha'
```

## Examples

**Configuration**

Oriental core.

```java
OrientalProperties orientalProperties = new OrientalProperties();
orientalProperties.setUrl("remote:localhost:2422/db");
orientalProperties.setUser("user");
orientalProperties.setPassword("paswd");
Oriental oriental = new Oriental(orientalProperties);
```

Oriental frames.

```java
OrientalProperties orientalProperties = new OrientalProperties();
orientalProperties.setUrl("remote:localhost:2422/db");
orientalProperties.setUser("user");
orientalProperties.setPassword("paswd");
OrientalFrames orientalFrames = new OrientalFrames(orientalProperties, new com.tinkerpop.frames.FramedGraphFactory());
```

Oriental and OrientalFrames are not singleton.

Spring

```java
@Bean
public Oriental oriental(){
        OrientalProperties orientalProperties = new OrientalProperties();
        orientalProperties.setPassword(orientProperties.getPassword());
        orientalProperties.setUser(orientProperties.getUser());
        orientalProperties.setUrl(orientProperties.getUrl());
        return new Oriental(orientalProperties);
}
```

**Find by id**
```java
oriental.graphNoTxOperation().findVertexById(new ORecordId(10, 1)).map(orientVertex -> orientVertex.getIdentity().toString());
```

map method close connection.

**Query**
```java
oriental.graphNoTxOperation().queryVertex("SELECT FROM V").map(orientVertex -> orientVertex.getIdentity().toString());
```

**Save**
```java
oriental.graphNoTxOperation().saveVertex("myClass", orientVertex -> orientVertex.setProperty("prop", "value"));
```

**Update**
```java
oriental.graphNoTxOperation().updateVertex(new ORecordId(10, 1), orientVertex -> orientVertex.setProperty("prop", "value"));
```
