package com.mkacg.minecraft.input;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Input.MODID, version = Input.VERSION)
public class Input {
    public static final String MODID = "mkacgInputMod";
    public static final String VERSION = "1.0";

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(String.format("I'm ready loaded! %s %s", MODID, VERSION));

        FMLCommonHandler.instance().bus().register(new InputHandle());
        KeyBind.init();
    }
}
