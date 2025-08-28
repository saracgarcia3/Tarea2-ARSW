# tarea2 (ARSW)

Proyecto Maven listo con:
- Java 21
- JUnit 5
- Exec Maven Plugin (para ejecutar `Main`)

## Estructura rápida
```
src/main/java/com/sara/arsw/app/Main.java
src/main/java/com/sara/arsw/collections/DoublyLinkedList.java
src/main/java/com/sara/arsw/io/DoubleFileReader.java
src/main/java/com/sara/arsw/service/Statistics.java
src/test/java/com/sara/arsw/StatisticsTest.java
src/test/resources/col1.txt
src/test/resources/col2.txt
```

## Comandos
```bash
mvn -q -DskipTests package
mvn -q test
mvn -q exec:java -Dexec.args="src/test/resources/col1.txt"
```
