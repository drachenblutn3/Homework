import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import bot.*;

public class MyWindowApp extends JFrame implements ActionListener { //Наследуя от JFrame мы получаем всю функциональность окна

   final String TITLE_OF_PROGRAM = "ChitChater =D";

   JTextPane dialogue; // area for dialog
    JCheckBox ai;       // enable/disable AI
    JTextField message; // field for entering messages
    SimpleBot sbot;     // chat-bot class (in bot package)
    SimpleAttributeSet botStyle; // style bot text

  public MyWindowApp(){
    setTitle(TITLE_OF_PROGRAM); //Заголовок окна
    setBounds(400, 100, 840, 680); //Если не выставить 
                                   //размер и положение 
                                   //то окно будет мелкое и незаметное
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при 
    
        /*   try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wowwp.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pack();*/

        /*  JLabel background = new JLabel(new ImageIcon("wowwp.jpg"));

        add(background);

        background.setLayout(new FlowLayout());*/

        BufferedImage img = ImageIO.read("wowwp.jpg");
int w = img.getWidth(null);
int h = img.getHeight(null);
BufferedImage bi = new
    BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
Graphics g = bi.getGraphics();
g.drawImage(img, 0, 0, null);


         dialogue = new JTextPane();
        dialogue.setEditable(false);
        dialogue.setContentType("text/html");
        JScrollPane scrollBar = new JScrollPane(dialogue);
        botStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(botStyle, true);
        StyleConstants.setForeground(botStyle, Color.blue);
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        //Image background = Toolkit.getDefaultToolkit().createImage("wowwp.jpg");
        //bp.drawImage(background, 0, 0, null);
        ai = new JCheckBox("AI");
        ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true); //С этого момента приложение запущено!
        sbot = new SimpleBot(); // creating bot object
  }

  public static void main(String[] args) { //эта функция может быть и в другом классе
    MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
    
  }

  @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            try {
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(), message.getText() + "\n", 
                    new SimpleAttributeSet());
                doc.insertString(doc.getLength(),
                    sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n",
                    botStyle);
            } catch(Exception e) { }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}