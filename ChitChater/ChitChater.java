/**
 * Java 2. Homework 4. Chat GUI.
 *
 * @author Nikolay Gritskevich
 * @versin dated 03.04.2017
 */

//import javax.awt.*;
//import javax.awt.event.*;
import javax.swing.*;

public class ChitChater extends JFrame {

    public ChitChater() {
       //super("Окно"); ???
       // setSize(500, 300);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
       // add(pnl);
       // setVisible(true);
       super("My First Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 840, 680);
        setVisible ( true );
    }

    public static void main(String[] args) {
    new ChitChater();

    }
}