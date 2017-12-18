package com.mkacg.minecraft.input;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyBindings {
    public static KeyBinding Binding_T;
    @SideOnly(Side.CLIENT)
    public static void Register() {
        Binding_T = new KeyBinding("message t", org.lwjgl.input.Keyboard.KEY_T, "");
        ClientRegistry.registerKeyBinding(Binding_T);
    }
}
