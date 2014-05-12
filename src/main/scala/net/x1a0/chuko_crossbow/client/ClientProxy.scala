package net.x1a0.chuko_crossbow.client

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.client.MinecraftForgeClient
import net.x1a0.chuko_crossbow.item._
import net.x1a0.chuko_crossbow.Proxy

class ClientProxy extends Proxy {
  override def preInit(event: FMLPreInitializationEvent) {
    registerItemRenderer()
  }

  private def registerItemRenderer(): Unit = {
    MinecraftForgeClient.registerItemRenderer(WoodChukoCrossbow, new ChukoCrossbowRenderer())
    MinecraftForgeClient.registerItemRenderer(TestCube, new TestCubeRenderer())
  }
}
