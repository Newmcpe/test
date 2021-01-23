package ru.newmcpe.test.listener

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.entity.EntityType
import ru.newmcpe.test.TestPlugin

class CustomNamesListener(plugin: TestPlugin): PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.SPAWN_ENTITY_LIVING) {
    override fun onPacketSending(event: PacketEvent) {
        val player = event.player
        val packet = event.packet

        val entity = packet.getEntityModifier(event.player.world).read(0)

        if(entity.type == EntityType.DROPPED_ITEM) {
            entity.customName = player.name
        }
    }
}
