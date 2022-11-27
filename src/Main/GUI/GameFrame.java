package Main.GUI;

import Main.Classes.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private SplashPanel splashPanel;
    private CharacterCreationPanel characterCreationPanel;
    private BattlePanel battlePanel;

    private static Player player;
    private static Monster monster;

    public GameFrame() {

        //frame properties:
        this.setTitle("Phrogz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,600,600);

        //content pane to hold all new panels
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        this.setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0,0));

        //create all panel objects for the game:
        splashPanel = new SplashPanel();
        characterCreationPanel = new CharacterCreationPanel();
        battlePanel = new BattlePanel();

        JButton enterCharacterCreationPanel = splashPanel.getStartButton();
        enterCharacterCreationPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                characterCreationPanel.setVisible(true);
                battlePanel.setVisible(false);
            }
        });

        JButton startBattle = characterCreationPanel.getStartBattleButton();
        startBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                characterCreationPanel.setVisible(false);
                battlePanel.setVisible(true);

                //only make the monster when the battle starts
                monster = new Monster();

                //make sure the name is set when the character is confirmed
                player.setName(CharacterCreationPanel.getInputName());

                battlePanel.setBattleImages();
                battlePanel.setDisplay();
            }
        });

        JButton playAgain = battlePanel.getPlayAgainButton();
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //wipe the creation panel clean:
                characterCreationPanel.resetCharacterCreationPanel();

                //change panels to go back to start:
                splashPanel.setVisible(true);
                characterCreationPanel.setVisible(false);
                battlePanel.setVisible(false);
            }
        });

        //(no need to specify splashPanel as visible since it is the first one added)
        contentPane.add(splashPanel);
        contentPane.add(characterCreationPanel);
        contentPane.add(battlePanel);
    }

    //store the player in the game frame so it can be accessed from any panel
    public static Player getPlayer() {return player;}
    public static void setPlayer(Player player) {
        GameFrame.player = player;
    }

    public static Monster getMonster() {return monster;}
}
