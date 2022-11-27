package Main.GUI;

import javax.swing.*;
import java.awt.*;

public class SplashPanel extends JPanel {

    private JButton startButton;

    public SplashPanel () {

        Font titleFont = new Font("Kefa", Font.BOLD , 26);
        Font appFont = new Font("Kefa", Font.PLAIN, 12);
        //set a custom color:
        Color backgroundColor = new Color(196,232,183);

        //set panel properties
        setLayout(null); //this is null to use absolute positioning on the elements within the pane
        setVisible(true);
        setBackground(backgroundColor);

        //make game title
        JLabel titleText = new JLabel("Battle Frogs", SwingConstants.CENTER);
        titleText.setFont(titleFont);
        //you will need to change this:
        titleText.setBounds(150,10,300,50);

        //make title picture
        JLabel titleImage = new JLabel();
        //you will need to change this:
        titleImage.setIcon(new ImageIcon(getClass().getResource("/Main/images/FrogSplash.png")));
        titleImage.setBounds(130,100,340,316);

        this.startButton = new JButton("Start Game");
        this.startButton.setBounds(200,470,200,50);
        this.startButton.setFont(appFont);


        //add everything to this panel:
        add(titleText);
        add(titleImage);
        add(this.startButton);
    }

    public JButton getStartButton() {
        return startButton;
    }

}
