package com.domker.lazylinker.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane1;
    private JLabel tab1;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        add(tabbedPane1);
        add(tab1);
    }

}
