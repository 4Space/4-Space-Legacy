package mattparks.mods.starcraft.europa.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.EnumSet;

import mattparks.mods.starcraft.europa.CommonProxyEuropa;
import mattparks.mods.starcraft.europa.EuropaCore;
import mattparks.mods.starcraft.europa.dimension.SCEuropaWorldProvider;
import micdoodle8.mods.galacticraft.core.client.GCCoreCloudRenderer;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ClientProxyEuropa extends CommonProxyEuropa
{
    public class ClientPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
        {
            final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
            final int packetType = PacketUtil.readPacketID(data);
            EntityPlayer player = (EntityPlayer) p;

            if (packetType == 0)
            {
                final Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class };
                final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

                int entityID = 0;
                Entity entity = null;
                
                switch ((Integer) packetReadout[1])
                {
                case 0:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);
                }
            }
        }
    }
    
    public static class TickHandlerClient implements ITickHandler
    {
        @Override
        public String getLabel()
        {
            return "Starcraft Europea Client";
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
        }

        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.CLIENT);
        }

        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
            final Minecraft minecraft = FMLClientHandler.instance().getClient();

            final WorldClient world = minecraft.theWorld;

            if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
                if (world != null)
                {
                    if (world.provider instanceof SCEuropaWorldProvider)
                    {
                        if (world.provider.getSkyRenderer() == null)
                        {
                            world.provider.setSkyRenderer(new SCEuropaSkyProvider());
                        }

                        if (world.provider.getCloudRenderer() == null)
                        {
                            world.provider.setCloudRenderer(new GCCoreCloudRenderer());
                        }
                    }

                    for (int i = 0; i < world.loadedEntityList.size(); i++)
                    {
                        final Entity e = (Entity) world.loadedEntityList.get(i);

                        if (e != null)
                        {
                            {

                                {
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();

    public static boolean handleLavaMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }

    public static boolean handleWaterMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.water);
    }

    {
    }

    {
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        return null;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
        NetworkRegistry.instance().registerChannel(new ClientPacketHandler(), EuropaCore.CHANNEL, Side.CLIENT);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
//        MinecraftForge.EVENT_BUS.register(new GCSaturnSounds());
    }

    @Override
    public void registerRenderInformation()
    {
    	;
    }
}
