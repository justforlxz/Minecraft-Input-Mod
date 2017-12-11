package com.mkacg.minecraft.input;

import javax.swing.*;
import java.awt.*;

public class Dialog extends JDialog {

    private JPanel m_panel;
    private JLabel m_tip;
    private JTextField m_textField;
    private JButton m_acceptBtn;

    public Dialog() {
        initUI();
        Container container = getContentPane();
        container.setLayout(null);
        container.add(m_panel);
    }

    private void initUI() {
        m_panel = new JPanel();
        m_tip = new JLabel("输入的内容会被直接发送到游戏内.");
        m_textField = new JTextField(200);
        m_acceptBtn = new JButton("提交");

        m_panel.setLayout(null);

        m_panel.add(m_tip);
        m_panel.add(m_textField);
        m_panel.add(m_acceptBtn);
    }

    public String getString() {
        return m_textField.getText();
    }
}