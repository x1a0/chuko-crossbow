package net.x1a0.chuko_crossbow.client

import net.minecraft.client.model.{ModelRenderer, ModelBase}
import net.minecraft.entity.Entity

class TestCubeModel extends ModelBase {
  val shape1: ModelRenderer = new ModelRenderer(this, 0, 0)
  shape1.addBox(-8F, -8F, -8F, 16, 16, 16)
  shape1.setRotationPoint(0F, 0F, 0F)
  shape1.setTextureSize(64, 32)
  shape1.mirror = true
  setRotation(shape1, 0F, 0F, 0F)

  override def render(entity: Entity, f: Float, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float): Unit = {
    super.render(entity, f, f1, f2, f3, f4, f5)
    setRotationAngles(f, f1, f2, f3, f4, f5, entity)
    shape1.render(f5)
  }

  private def setRotation(model: ModelRenderer, x: Float, y: Float, z: Float): Unit = {
    model.rotateAngleX = x
    model.rotateAngleY = y
    model.rotateAngleZ = z
  }
}
