package net.x1a0.chuko_crossbow.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityArrow
import net.minecraft.init.Items
import net.minecraft.item.{EnumAction, ItemStack, Item}
import net.minecraft.world.World

object TestCube extends Item {
  setMaxStackSize(1)
  setCreativeTab(CreativeTabs.tabCombat)
  setUnlocalizedName("TestCube")
  setFull3D()
}
