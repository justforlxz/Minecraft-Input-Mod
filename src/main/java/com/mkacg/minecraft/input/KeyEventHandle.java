package com.mkacg.minecraft.input;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

public class KeyEventHandle {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onKeyInput(InputEvent.KeyInputEvent event) throws IOException {
        if (KeyBindings.Binding_T.isPressed()) {
            // Start Minecraft Input Helper

            ProcessBuilder pb = new ProcessBuilder("/usr/bin/minecraft-input-helper");
            pb.start();

            System.out.println("Key press");
        }
    }
}
