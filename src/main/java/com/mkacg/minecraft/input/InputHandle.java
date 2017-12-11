package com.mkacg.minecraft.input;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InputHandle {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBind.openGUI.isPressed()) {
            Dialog dialog = new Dialog();
            String value = dialog.getString();
            Minecraft.getMinecraft().player.sendChatMessage(value);
            System.out.println(value);
        }
    }
}
