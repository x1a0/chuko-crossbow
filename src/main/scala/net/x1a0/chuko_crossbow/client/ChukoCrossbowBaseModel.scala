package net.x1a0.chuko_crossbow.client

import net.minecraft.client.model.{ModelRenderer, ModelBase}
import net.minecraft.entity.Entity

class ChukoCrossbowBaseModel extends ModelBase {

  val bodyUpper: ModelRenderer = new ModelRenderer(this, 0, 0)
  bodyUpper.addBox(-1F, 0F, -12F, 2, 1, 22)
  bodyUpper.setRotationPoint(0F, 0F, 0F)
  bodyUpper.setTextureSize(64, 32)
  bodyUpper.mirror = true
  setRotation(bodyUpper, 0F, 0F, 0F)

  val bodyLower: ModelRenderer = new ModelRenderer(this, 26, 0)
  bodyLower.addBox(-1F, 1F, -10F, 2, 1, 10)
  bodyLower.setRotationPoint(0F, 0F, 0F)
  bodyLower.setTextureSize(64, 32)
  bodyLower.mirror = true
  setRotation(bodyLower, 0F, 0F, 0F)

  val tail: ModelRenderer = new ModelRenderer(this, 26, 0)
  tail.addBox(-2F, 0F, 10F, 4, 1, 1)
  tail.setRotationPoint(0F, 0F, 0F)
  tail.setTextureSize(64, 32)
  tail.mirror = true
  setRotation(tail, 0F, 0F, 0F)

  val wingLeft: ModelRenderer = new ModelRenderer(this, 0, 18)
  wingLeft.addBox(1F, 1F, -9F, 8, 1, 1)
  wingLeft.setRotationPoint(0F, 0F, 0F)
  wingLeft.setTextureSize(64, 32)
  wingLeft.mirror = true
  setRotation(wingLeft, 0F, 0F, 0F)

  val wingRight: ModelRenderer = new ModelRenderer(this, 0, 20)
  wingRight.addBox(-9F, 1F, -9F, 8, 1, 1)
  wingRight.setRotationPoint(0F, 0F, 0F)
  wingRight.setTextureSize(64, 32)
  wingRight.mirror = true
  setRotation(wingRight, 0F, 0F, 0F)

  val clipLower: ModelRenderer = new ModelRenderer(this, 40, 9)
  clipLower.addBox(-1F, -2F, -10F, 2, 2, 10)
  clipLower.setRotationPoint(0F, 0F, 0F)
  clipLower.setTextureSize(64, 32)
  clipLower.mirror = true
  setRotation(clipLower, 0F, 0F, 0F)

  val clipUpper: ModelRenderer = new ModelRenderer(this, 40, 0)
  clipUpper.addBox(-1F, -3F, -10F, 2, 1, 8)
  clipUpper.setRotationPoint(0F, 0F, 0F)
  clipUpper.setTextureSize(64, 32)
  clipUpper.mirror = true
  setRotation(clipUpper, 0F, 0F, 0F)

  val loaderRight: ModelRenderer = new ModelRenderer(this, 0, 8)
  loaderRight.addBox(-2F, 0F, -2F, 1, 1, 7)
  loaderRight.setRotationPoint(0F, 0F, 0F)
  loaderRight.setTextureSize(64, 32)
  loaderRight.mirror = true
  setRotation(loaderRight, 0.5235988F, 0F, 0F)

  val loaderMiddle: ModelRenderer = new ModelRenderer(this, 0, 0)
  loaderMiddle.addBox(-1F, 0F, 4F, 2, 1, 1)
  loaderMiddle.setRotationPoint(0F, 0F, 0F)
  loaderMiddle.setTextureSize(64, 32)
  loaderMiddle.mirror = true
  setRotation(loaderMiddle, 0.5235988F, 0F, 0F)

  val loaderLeft: ModelRenderer = new ModelRenderer(this, 0, 0)
  loaderLeft.addBox(1F, 0F, -2F, 1, 1, 7)
  loaderLeft.setRotationPoint(0F, 0F, 0F)
  loaderLeft.setTextureSize(64, 32)
  loaderLeft.mirror = true
  setRotation(loaderLeft, 0.5235988F, 0F, 0F)

  val outerWingLeft: ModelRenderer = new ModelRenderer(this, 26, 18)
  outerWingLeft.addBox(6F, 1F, -8F, 5, 1, 1)
  outerWingLeft.setRotationPoint(0F, 0F, 0F)
  outerWingLeft.setTextureSize(64, 32)
  outerWingLeft.mirror = true
  setRotation(outerWingLeft, 0F, 0F, 0F)

  val outerWingRight: ModelRenderer = new ModelRenderer(this, 26, 20)
  outerWingRight.addBox(-11F, 1F, -8F, 5, 1, 1)
  outerWingRight.setRotationPoint(0F, 0F, 0F)
  outerWingRight.setTextureSize(64, 32)
  outerWingRight.mirror = true
  setRotation(outerWingRight, 0F, 0F, 0F)

  override def render(entity: Entity, f0: Float, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float): Unit = {
    super.render(entity, f0, f1, f2, f3, f4, f5)
    setRotationAngles(f0, f1, f2, f3, f4, f5, entity)
    bodyUpper.render(f5)
    bodyLower.render(f5)
    tail.render(f5)
    wingLeft.render(f5)
    wingRight.render(f5)
    clipLower.render(f5)
    clipUpper.render(f5)
    loaderRight.render(f5)
    loaderMiddle.render(f5)
    loaderLeft.render(f5)
    outerWingLeft.render(f5)
    outerWingRight.render(f5)
  }

  private def setRotation(model: ModelRenderer, x: Float, y: Float, z: Float): Unit = {
    model.rotateAngleX = x
    model.rotateAngleY = y
    model.rotateAngleZ = z
  }
}
