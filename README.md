# flyway-java-spike

Demonstrates using Java to drive migrations in [Flyway](https://flywaydb.org/).

### How to run this project

Simply run `mvn clean compile package flyway:migrate`.  The `target` directory will appear with an extensionless sqlite db file called `foobar`.  It can be accessed with sqlite if you have it installed: `sqlite ./target/foobar`.

You can also run `mvn clean compile flyway:migrate -P cucumber`, which activates the Cucumber maven profile.  This will demonstrate running the main migrations plus test migrations.  Test migrations are useful for pre-loading the database with fake data for integration testing.  Note how under `test` the package is NOT called `com.workiva.db.migration`.  The `migration` package is called `testmigration` so that by default Flyway won't run the test migration.  See the POM file for Flyway configuration details.

If an error occurs, make sure you are using Java 8.  You can also run run the command in error mode, to show stack traces and so forth: `mvn -e clean compile package flyway:migrate`

### Stuff

The migrations can be found in `src/main/java/com/workiva/db/migration`.  The `App` Java is boilerplate and isn't relevant to migrations.

`V1_2_1__MigrateJsonSkuidToColumn` migration demonstrates how to use Jackson Jr. to pluck properties from a JSON blob and put it into a separate table column.

Please be sure to read [the documentation on Java-based migrations](https://flywaydb.org/documentation/migration/java).