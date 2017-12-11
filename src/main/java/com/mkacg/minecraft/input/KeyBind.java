package com.mkacg.minecraft.input;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBind {
    public static KeyBinding openGUI;

    @SideOnly(Side.CLIENT)
    public static void init() {
        openGUI = new KeyBinding("key.OpenGUI", Keyboard.KEY_T, "key.categories.youMod");
        ClientRegistry.registerKeyBinding(openGUI);
    }
}
