package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creator : Ayça Begüm Taşçıoğlu
 * This class contains the informatin for the setting panel.
 */
public class Settings extends SimplePanel{
    public static final Color VERY_LIGHT_BLUE = new Color(51,204,255);
    //153- 0 - 0
    public static final Color MY_RED = new Color(153,0,0);
    JButton returnPrev = new JButton("Back");
    JLabel backgroundtitle = new JLabel("Background:");
    JButton c1 = new JButton("The Wall Background");
    JButton c2 = new JButton("Potterhead Background");
    JButton c3 = new JButton("Game of Thrones Background");
    JButton c4 = new JButton("Mountains Background");
    JButton c5 = new JButton("Brick Background");
    JLabel soundtitle = new JLabel("Sound:");
    JButton soundOn = new JButton("ON");
    JButton soundOff = new JButton("OF");
    int imageID;
    public Settings() {
        super();
        type = "settings";
        JLabel title = new JLabel("Settings");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        ButtonListener buttonListen = new ButtonListener();

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(100,400,300,400)));

        c1.addActionListener(buttonListen);
        c1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        c2.addActionListener(buttonListen);
        c2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        c3.addActionListener(buttonListen);
        c3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        c4.addActionListener(buttonListen);
        c4.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        c5.addActionListener(buttonListen);
        c5.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));


        backgroundtitle.setForeground(VERY_LIGHT_BLUE);
        backgroundtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        this.add(backgroundtitle);
        this.add(c1);
        this.add(c2);
        this.add(c3);
        this.add(c4);
        this.add(c5);
        soundtitle.setForeground(VERY_LIGHT_BLUE);
        soundtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        soundOn.addActionListener(buttonListen);
        soundOn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        soundOff.addActionListener(buttonListen);
        soundOff.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        this.add(soundtitle);
        this.add(soundOn);
        this.add(soundOff);

        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        returnPrev.setLocation(1000, 400);

        this.add(returnPrev);


    }
    public int getSelection(){
        return selection;
    }
    public void setBG(int imageID){
        setTheme(imageID);
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
            else if(event.getSource() == c1) {
                setTheme(0);
                repaint();
            }
            else if(event.getSource() == c2) {
                setTheme(1);
                repaint();
            }
            else if(event.getSource() == c3) {
                setTheme(2);
                repaint();
            }
            else if(event.getSource() == c4) {
                setTheme(3);
                repaint();
            }
            else if(event.getSource() == c5) {
                setTheme(4);
                repaint();
            }
        }
    }
}

