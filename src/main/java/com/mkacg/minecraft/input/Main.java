package com.mkacg.minecraft.input;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "mkacginputmod";
    public static final String VERSION = "1.0";

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(String.format("I'm ready loaded! %s %s", MODID, VERSION));

        MinecraftForge.EVENT_BUS.register(new InputHandle());
        KeyBind.init();
    }
}
