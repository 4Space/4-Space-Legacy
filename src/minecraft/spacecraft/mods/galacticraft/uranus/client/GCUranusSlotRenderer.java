package spacecraft.mods.galacticraft.uranus.client;

import spacecraft.mods.galacticraft.uranus.GCUranus;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCUranusSlotRenderer implements ICelestialBodyRenderer
{

    @Override
    public ResourceLocation getPlanetSprite()
    {
        return new ResourceLocation(GCUranus.TEXTURE_DOMAIN, "textures/gui/planets/uranus.png");
    }

    @Override
    public String getPlanetName()
    {
        return "Uranus";
    }

    @Override
    public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
    {
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, y + slotHeight / 2 * 1.3, -90.0D, 0.35D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, y + slotHeight / 2 * 1.3, -90.0D, 0.65D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, y - slotHeight / 2 * 1.3, -90.0D, 0.65D, 0.35D);
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, y - slotHeight / 2 * 1.3, -90.0D, 0.35D, 0.35D);
        tessellator.draw();
    }
}