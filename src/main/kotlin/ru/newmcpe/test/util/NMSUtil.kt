package ru.newmcpe.test.util

import net.minecraft.server.v1_13_R2.EntityLiving
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftEntity
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.entity.CreatureSpawnEvent
import kotlin.reflect.KClass

object NMSUtil {
    fun spawnNMSMob(entityClazz: KClass<out EntityLiving>, location: Location): CraftEntity{
        val entity = entityClazz.constructors.first().call(location)

        addEntityToWorld(entity.bukkitEntity)

        entity.run {
            setLocation(location.x, location.y, location.z, location.yaw, location.pitch)
        }

        return entity.bukkitEntity
    }

    fun addEntityToWorld(entity: Entity) {
        val handle = (entity as CraftEntity).handle
        handle.dead = false
        (entity.getWorld() as CraftWorld).addEntity<Entity>(handle, CreatureSpawnEvent.SpawnReason.CUSTOM)
    }
}