package net.x1a0.chuko_crossbow

import cpw.mods.fml.common.event.FMLPreInitializationEvent

trait Proxy {
  def preInit(event: FMLPreInitializationEvent) {}
}

class CommonProxy extends Proxy
