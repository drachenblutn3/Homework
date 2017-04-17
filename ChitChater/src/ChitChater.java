/**
 * Java 2. Homework 4. Chat GUI.
 *
 * @author Nikolay Gritskevich
 * @versin dated 03.04.2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChitChater extends JFrame implements ActionListener {
    JPanel pnl = new JPanel();
    public void Window() {
        super("Окно");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        setVisible(true);
    }

    public static void main(String[] args) {
    Window gui = new Window();
    }
}


