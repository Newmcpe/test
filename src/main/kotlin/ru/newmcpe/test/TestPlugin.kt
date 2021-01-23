package ru.newmcpe.test

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import ru.newmcpe.test.dao.DiedOcelotsTable
import ru.newmcpe.test.listener.MobListener

class TestPlugin : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(MobListener(), this)

        connectDatabase()
    }

    private fun connectDatabase() {
        val databaseAddress = System.getenv("DATABASE_ADDRESS") ?: "localhost:5432"
        val databaseName = System.getenv("DATABASE_NAME") ?: "flycash"
        val databaseUser = System.getenv("DATABASE_USER") ?: "flycash"
        val databasePassword = System.getenv("DATABASE_PASSWORD") ?: "qwerty"
        Database.connect(
            url = "jdbc:postgresql://$databaseAddress/$databaseName",
            user = databaseUser,
            password = databasePassword
        )
        transaction {
            SchemaUtils.create(DiedOcelotsTable)
        }
    }
}