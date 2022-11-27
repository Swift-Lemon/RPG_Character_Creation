package Main.GUI;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    private JLabel playerImage;

    private JLabel monsterImage;

    private TextArea display;

    private JButton playAgainButton;

    public JButton getPlayAgainButton() {return playAgainButton;}

    public BattlePanel() {

        //panel properties:
        Font titleFont = new Font("Kefa", Font.BOLD , 26);
        Font appFont = new Font("Kefa", Font.PLAIN , 14);
        Color backgroundColour = new Color(196,232,183);
        Color textFieldColour = new Color(255,255,209);

        setLayout(null); //this is null to use absolute positioning on the elements within the pane
        setVisible(true);
        setBackground(backgroundColour);

        //panel title:
        JLabel title = new JLabel("Battle to the Death!");
        title.setBounds(200, 20, 400, 100);
        title.setFont(titleFont);

        //display character images:
        playerImage = new JLabel();
        playerImage.setBounds(80, 100, 191, 136);

        monsterImage = new JLabel();
        monsterImage.setBounds(380, 100, 150, 150);

        //display character stats:
        display = new TextArea();
        display.setBounds(50, 250, 500, 200);
        display.setFont(appFont);
        display.setBackground(textFieldColour);

        this.playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(220,500,150,50);
        playAgainButton.setFont(appFont);
        //actionlistener for this button is in GameFrame

        add(title);
        add(monsterImage);
        add(playerImage);
        add(display);
        add(this.playAgainButton);
    }

    //populate the battle screen with pictures of the characters
    public void setBattleImages() {

        //these can't be set on app startup because they rely on objects that are null at startup
        playerImage.setIcon(GameFrame.getPlayer().getCharacterImage());
        monsterImage.setIcon(GameFrame.getMonster().getCharacterImage());
    }

    //use object toString methods to print a battle report
    public void setDisplay() {

        display.setText(GameFrame.getPlayer().toString() + "\n\n" + GameFrame.getMonster().toString());
    }
}
