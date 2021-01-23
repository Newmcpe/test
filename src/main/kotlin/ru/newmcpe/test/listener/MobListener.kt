package ru.newmcpe.test.listener

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack
import ru.newmcpe.test.dao.DiedOcelotsTable
import ru.newmcpe.test.entity.EntityOcelot
import ru.newmcpe.test.util.NMSUtil
import ru.newmcpe.test.util.StringUtil

class MobListener : Listener {
    @EventHandler
    fun onZombieDied(event: EntityDeathEvent) {
        val entity = event.entity
        val lastDamageCause = entity.lastDamageCause

        if (lastDamageCause is EntityDamageByEntityEvent) {
            if(lastDamageCause.damager !is Player)
                return

            if (entity.type == EntityType.ZOMBIE) {
                val ocelot = NMSUtil.spawnNMSMob(EntityOcelot::class, entity.location)
                ocelot.customName = StringUtil.getRandomString()
            }
        }
    }

    @EventHandler
    fun onOcelotDied(event: EntityDeathEvent){
        val entity = event.entity
        val lastDamageCause = entity.lastDamageCause

        if (lastDamageCause is EntityDamageByEntityEvent) {
            val damager = lastDamageCause.damager

            if(damager !is Player)
                return

            if (entity.type == EntityType.OCELOT) {
                event.drops.clear()
                event.drops.add(ItemStack(Material.LEATHER))

                entity.world.dropItem(entity.location, ItemStack(Material.GLOWSTONE))
                DiedOcelotsTable.add(damager.name, entity.name)
            }
        }
    }
}