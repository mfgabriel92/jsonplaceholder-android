package com.example.gabriel.jsonplaceholder.data.local.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1To2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS `posts` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`userId` INTEGER NOT NULL," +
                "`title` TEXT NOT NULL," +
                "`body` TEXT NOT NULL," +
                "FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE" +
            ")"
        )
    }
}