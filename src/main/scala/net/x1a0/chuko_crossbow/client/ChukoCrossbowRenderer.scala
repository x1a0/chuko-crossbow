package net.x1a0.chuko_crossbow.client

import cpw.mods.fml.client.FMLClientHandler
import net.minecraft.client.Minecraft
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRendererHelper, ItemRenderType}
import org.lwjgl.opengl.GL11

class ChukoCrossbowRenderer extends IItemRenderer {
  val chukoCrossbowModel: ChukoCrossbowBaseModel = new ChukoCrossbowBaseModel()
  val resourceFile = "chukocrossbow:models/ChukoCrossbowBase.png"

  override def renderItem(typ: ItemRenderType, item: ItemStack, data: Object*): Unit = {
    val mc: Minecraft = FMLClientHandler.instance().getClient
    typ match {
      case ItemRenderType.EQUIPPED => // render in 3rd person
        GL11.glPushMatrix()
        mc.renderEngine.bindTexture(new ResourceLocation(resourceFile))
        GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F)
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F)
        GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F)
        GL11.glTranslatef(0.0F, 0.0F, -0.8F)
        chukoCrossbowModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F)
        GL11.glPopMatrix()

      case ItemRenderType.EQUIPPED_FIRST_PERSON =>
        GL11.glPushMatrix()
        val scale = 3.0F
        GL11.glScalef(scale, scale, scale)
        mc.renderEngine.bindTexture(new ResourceLocation(resourceFile))
        GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F)
        GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F)
        GL11.glRotatef(200.0F, 0.0F, 0.0F, 1.0F)
        GL11.glTranslatef(-0.5F, 0.0F, -0.2F)
        chukoCrossbowModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F)
        GL11.glPopMatrix()

      case ItemRenderType.ENTITY =>
        GL11.glPushMatrix()
        val scale = 1.2F
        GL11.glScalef(scale, scale, scale)
        mc.renderEngine.bindTexture(new ResourceLocation(resourceFile))
        GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F)
        GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F)
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F)
        GL11.glTranslatef(0.0F, 0.0F, 0.0F)
        chukoCrossbowModel.render(data(1).asInstanceOf[Entity], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F)
        GL11.glPopMatrix()

      case ItemRenderType.INVENTORY =>
        GL11.glPushMatrix()
        val scale = 1.0F
        GL11.glScalef(scale, scale, scale)
        mc.renderEngine.bindTexture(new ResourceLocation(resourceFile))
        GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F)
        GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F)
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F)
        GL11.glTranslatef(0.0F, 0.0F, 0.0F)
        chukoCrossbowModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F)
        GL11.glPopMatrix()
    }
  }

  override def handleRenderType(item: ItemStack, typ: ItemRenderType): Boolean = true

  override def shouldUseRenderHelper(typ: ItemRenderType, item: ItemStack, helper: ItemRendererHelper): Boolean = {
    typ match {
      case ItemRenderType.INVENTORY => true
      case ItemRenderType.EQUIPPED_FIRST_PERSON => helper match {
        case (ItemRendererHelper.BLOCK_3D | ItemRendererHelper.EQUIPPED_BLOCK) => true
        case _ => false
      }

      case ItemRenderType.ENTITY => helper match {
        case (ItemRendererHelper.BLOCK_3D | ItemRendererHelper.EQUIPPED_BLOCK) => true
        case _ => false
      }
      case _ => false
    }
  }
}
