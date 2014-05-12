package net.x1a0.chuko_crossbow

import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{SidedProxy, FMLLog, Mod}
import net.x1a0.chuko_crossbow.item._

@Mod(modid = ChukoCrossbowMod.MOD_ID, version = ChukoCrossbowMod.VERSION, modLanguage = "scala")
object ChukoCrossbowMod {

  final val MOD_ID  = "chuko_crossbow"
  final val VERSION = "0.1.0"

  @SidedProxy(clientSide = "net.x1a0.chuko_crossbow.client.ClientProxy", serverSide = "net.x1a0.chuko_crossbow.CommonProxy")
  var proxy: Proxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerItem(WoodChukoCrossbow, "Wood Chuko-crossbow")
    GameRegistry.registerItem(TestCube, "Test Cube")
    proxy.preInit(event)
  }

  @EventHandler
  def init(event: FMLInitializationEvent) {
    FMLLog.info("ChukoCrossbow Mod loaded!")
  }
}

