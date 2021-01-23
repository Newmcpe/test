package ru.newmcpe.test.entity

import net.minecraft.server.v1_13_R2.EntityHuman
import net.minecraft.server.v1_13_R2.EntityIronGolem
import net.minecraft.server.v1_13_R2.EntityOcelot
import net.minecraft.server.v1_13_R2.PathfinderGoalNearestAttackableTarget
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld

class EntityOcelot(
    location: Location
) : EntityOcelot((location.world as CraftWorld).handle) {
    override fun n() {
        super.n()
        targetSelector.a(2, PathfinderGoalNearestAttackableTarget(this, EntityHuman::class.java, true))
    }
}