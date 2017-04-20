package com.workiva.db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_1_0__AddPropertiesToProductTable implements JdbcMigration {
    public void migrate(Connection connection) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("ALTER TABLE product ADD COLUMN properties BLOB");

        try {
            stmt.execute();
        } finally {
            stmt.close();
        }
    }
}
