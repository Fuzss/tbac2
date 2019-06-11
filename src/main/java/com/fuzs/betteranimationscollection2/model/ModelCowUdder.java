package com.fuzs.betteranimationscollection2.model;

import com.fuzs.betteranimationscollection2.feature.FeatureCow;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCowUdder extends ModelCow
{
    public ModelRenderer utter;

    public ModelCowUdder()
    {
        super();

        this.body = new ModelRenderer(this, 18, 4);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);

        this.utter = new ModelRenderer(this, 52, 0);
        this.utter.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 1);
        if (FeatureCow.nipples) {
            this.utter.addBox(-1.5F, -2.5F, -2.75F, 1, 1, 1, -0.125F);
            this.utter.addBox(0.5F, -2.5F, -2.75F, 1, 1, 1, -0.125F);
            this.utter.addBox(0.5F, 1.5F, -2.75F, 1, 1, 1, -0.125F);
            this.utter.addBox(-1.5F, 1.5F, -2.75F, 1, 1, 1, -0.125F);
        }
        this.utter.setRotationPoint(0.0F, 4.5F, -6.0F);
        this.body.addChild(this.utter);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        // prevent calves from having an utter
        if (this.isChild)
        {
            this.utter.isHidden = true;
        } else {
            this.utter.isHidden = false;
        }
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        this.utter.rotateAngleX = MathHelper.sin(limbSwing * 0.5F) * limbSwingAmount * 0.25F;
        this.utter.rotateAngleY = MathHelper.cos(limbSwing) * limbSwingAmount * 0.625F;
    }
}