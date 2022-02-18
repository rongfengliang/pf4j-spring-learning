# pf4j with spring


## Starting

* init (starting test database)

```code
docker-compose up -d 
```

* build plugins

```shell
mvn clean  package
```

* copy plugins to one directory

```shell
mkdir  <path to plugins>/plugins

cp plugina/target/plugina-1.0-SNAPSHOT.jar   <path to plugins>/plugins/

cp plugina/target/pluginb-1.0-SNAPSHOT.jar   <path to plugins>/plugins/

```

* starning bootstrap 

```shell
with ide or fat jar


java -Dpf4j.pluginsDir=<path to plugins>/plugins -jar bootstrap/target/bootstrap-1.0-SNAPSHOT.jar
```