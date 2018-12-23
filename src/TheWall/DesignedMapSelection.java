package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class DesignedMapSelection extends SimplePanel {
    //Map[] list = new Map[4];
    String[] list = { "BerlinWall\tAeyc\t4.4", "TheGreatWall\tErdemege\t8.7", "SampleWall\tUnknown\t6.4"};
    //JButton[] list = {new JButton("button1"), new JButton("button2")};
    JComboBox maps = new JComboBox(list);
    JButton returnPrev = new JButton("Back");

    public DesignedMapSelection()
    {
        super();
        type = "designedMapSelection";
        JLabel title = new JLabel("Choose a Map to Play!");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        maps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //IF STATEMENT IS OK BUT FOR TRIAL IT IS COMMENTED
                //if (maps.getSelectedItem() == list[0])
                selection = 1;
            }
        });


        this.add(maps);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        returnPrev.addActionListener(buttonListen);
        this.add(returnPrev);

    }
    public int getSelection(){
        return selection;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }


}

