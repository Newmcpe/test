package ru.newmcpe.test.dao

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.timestamp
import org.jetbrains.exposed.sql.insert
import java.time.Instant

object DiedOcelotsTable : Table("died_ocelots") {
    val playerName = varchar("player_name", 16)
    val ocelotName = varchar("ocelot_name", 16)
    val killTime = timestamp("kill_time").default(Instant.now())

    fun add(playerName: String, ocelotName: String) {
        insert {
            it[this.playerName] = playerName
            it[this.ocelotName] = ocelotName
        }
    }
}