package mattparks.mods.starcraft.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SCVenusBlock extends Block
{
    public SCVenusBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }
}
