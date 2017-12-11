package com.mkacg.minecraft.input;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Input.MODID, version = Input.VERSION)
public class Input {
    public static final String MODID = "mkacgInputMod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(String.format("I'm ready loaded! %s %s", MODID, VERSION));
    }
}
