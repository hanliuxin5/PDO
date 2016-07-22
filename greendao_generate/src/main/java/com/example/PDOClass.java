package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class PDOClass {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "pdo.deepspace");
        addDP(schema);
        new DaoGenerator().generateAll(schema, "./app/src/main/java-gen");


    }


    private static void addDP(Schema schema) {
        Entity dp = schema.addEntity(DeepSpaceEntry.TABLE_NAME);
        dp.addIdProperty().primaryKey().autoincrement();
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_DATE).notNull().unique();
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_EXPLANATION);
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_HDURL);
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_TITLE);
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_URL);
        dp.addStringProperty(DeepSpaceEntry.COLUMN_NAME_MEDIATYPE);
    }
}
