package net.x1a0.chuko_crossbow.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityArrow
import net.minecraft.init.Items
import net.minecraft.item.{EnumAction, ItemStack, Item}
import net.minecraft.world.World

object WoodChukoCrossbow extends Item {
  setMaxStackSize(1)
  setMaxDamage(384)
  setCreativeTab(CreativeTabs.tabCombat)
  setUnlocalizedName("ChukoCrossbow")
  setFull3D()

  val rand = Item.itemRand

  def reloadCoolDown: Int = 40 // ticks

  /**
   * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
   */
  override def onItemRightClick(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer): ItemStack = {
    par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack))
    par3EntityPlayer.getEntityData.setBoolean("chuko_shooting", true)
    par1ItemStack
  }

  override def onUpdate(par1ItemStack: ItemStack, par2World: World, par3Entity: Entity, par4: Int, par5: Boolean): Unit = {
    // par5 seems to identify whether the item is in user's hand
    if (par5) {
      val tag = par3Entity.getEntityData
      val countdown = tag.getInteger("chuko_reloadCountDown")
      if (countdown > 0) {
        tag.setInteger("chuko_reloadCountDown", countdown - 1)
      } else {
        if (tag.getBoolean("chuko_shooting")) {
          shoot(par1ItemStack, par2World, par3Entity.asInstanceOf[EntityPlayer])
          tag.setInteger("chuko_reloadCountDown", reloadCoolDown)
        }
      }
    }
  }

  /**
   * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
   */
  override def onPlayerStoppedUsing(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer, par4: Int): Unit = {
    par3EntityPlayer.getEntityData.setBoolean("chuko_shooting", false)
  }

  def shoot(itemStack: ItemStack, world: World, player: EntityPlayer): Unit = {
    val flag: Boolean = player.capabilities.isCreativeMode
    val arrow: EntityArrow  = new EntityArrow(world, player, 2.0F)
    itemStack.damageItem(1, player)
    world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 1.2F) + 0.5F)

    arrow.setDamage(arrow.getDamage * 2)

    if (flag) {
      arrow.canBePickedUp = 2
    } else {
      player.inventory.consumeInventoryItem(Items.arrow)
    }

    if (!world.isRemote) {
      world.spawnEntityInWorld(arrow)
    }
  }

  /**
   * How long it takes to use or consume an item
   * (seems to be in 1/10 seconds)
   */
  override def getMaxItemUseDuration(par1ItemStack: ItemStack): Int = 72000

  /**
   * returns the action that specifies what animation to play when the items is being used
   */
  override def getItemUseAction(par1ItemStack: ItemStack): EnumAction = EnumAction.bow

  /**
   * Return the enchantability factor of the item, most of the time is based on material.
   */
  override def getItemEnchantability: Int = 1
}
