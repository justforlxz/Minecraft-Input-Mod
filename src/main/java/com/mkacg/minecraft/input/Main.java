package com.mkacg.minecraft.input;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "mkacginputmod";
    public static final String VERSION = "1.0";

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        System.out.println(String.format("I'm ready loaded! %s %s", MODID, VERSION));

        UDP udp = new UDP();
        udp.start();
    }
}