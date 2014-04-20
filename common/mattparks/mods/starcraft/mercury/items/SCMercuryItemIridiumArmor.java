package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.mercury.MercuryCore;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCMercuryItemIridiumArmor extends ItemArmor
{
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public SCMercuryItemIridiumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        this.attachedMask = breathable;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (this.material == MercuryItems.ARMORIRIDIUM)
        {
            if (stack.getItem().itemID == MercuryItems.iridiumHelmet.itemID)
            {
                return "textures/model/armor/iridium_1.png";
            }
            else if (stack.getItem().itemID == MercuryItems.iridiumChestplate.itemID || stack.getItem().itemID == MercuryItems.iridiumBoots.itemID)
            {
                return "textures/model/armor/iridium_2.png";
            }
            else if (stack.getItem().itemID == MercuryItems.iridiumLeggings.itemID)
            {
                return "textures/model/armor/iridium_3.png";
            }
        }

        return null;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return MercuryCore.starcraftMercuryTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "starcraftmercury:"));
    }

    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
