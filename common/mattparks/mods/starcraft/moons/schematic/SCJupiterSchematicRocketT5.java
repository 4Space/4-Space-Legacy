package mattparks.mods.starcraft.moons.schematic;

import mattparks.mods.starcraft.moons.SCJupiterConfigManager;
import mattparks.mods.starcraft.moons.client.gui.SCJupiterGuiSchematicRocketT5;
import mattparks.mods.starcraft.moons.inventory.SCJupiterContainerRocketBenchT5;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
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
 
public class SCJupiterSchematicRocketT5 implements ISchematicPage
{
    @Override
    public int compareTo(ISchematicPage o)
    {
        if (this.getPageID() > o.getPageID())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public int getGuiID()
    {
        return SCJupiterConfigManager.idGuiRocketCraftingBenchT5;
    }

    @Override
    public int getPageID()
    {
        return SCJupiterConfigManager.idSchematicRocketT5;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCJupiterContainerRocketBenchT5(player.inventory, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCJupiterGuiSchematicRocketT5(player.inventory, x, y, z);
    }
}
