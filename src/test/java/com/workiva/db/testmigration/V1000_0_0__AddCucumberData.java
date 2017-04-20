package com.workiva.db.testmigration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1000_0_0__AddCucumberData implements JdbcMigration {
    private static final String SQL_INSERT_EVEN_MORE_NONSENSE_PRODUCTS = "INSERT INTO product (name, properties, skuid) VALUES " +
            "('Cucumber Salad', '{}', 'F-0000001')," +
            "('Pickled Cucumber', '{}', 'F-0000002')," +
            "('Evolved Cucumber - The Cuke', '{}', 'F-0000003');";

    public void migrate(Connection connection) throws Exception {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_EVEN_MORE_NONSENSE_PRODUCTS)) {
            stmt.execute();
        }
    }
}
