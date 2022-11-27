package Main.GUI;

import Main.Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreationPanel extends JPanel {

    //class variables listed in order of when they appear in constructor:
    private static JTextField enterName;

    private final JTextArea classText;
    private final JLabel classImage;

    private ButtonGroup classRadio;
    private JRadioButton rdoDesertRain;
    private JRadioButton rdoPoisonDart;
    private JRadioButton rdoHorned;

    private final JTextField hpText;
    private final JTextField defenseText;
    private final JTextField agilityText;
    private final JTextField baseAttackText;

    private JButton reroll;

    private ButtonGroup weaponRadio;
    private JRadioButton rdoDagger;
    private JRadioButton rdoClub;
    private JRadioButton rdoDiscus;

    private final JTextArea weaponText;
    private final JLabel weaponImage;

    private final JTextField attackModifierText;
    private final JTextField weightText;

    private final JButton startBattle;

    public static String getInputName() {return enterName.getText();}

    public JButton getStartBattleButton() {
        return startBattle;
    }

    public CharacterCreationPanel() {

        //set panel properties:
        Font titleFont = new Font("Kefa", Font.BOLD , 26);
        Font appFont = new Font("Kefa", Font.PLAIN, 14);
        Font jRadioFont = new Font("Kefa", Font.PLAIN, 12);
        Color backgroundColour = new Color(196,232,183);
        Color textFieldColour = new Color(255,255,209);

        setLayout(null); //this is null to use absolute positioning on the elements within the pane
        setVisible(true);
        setBackground(backgroundColour);

        ///////////////////////////////////////////////////////////////////////////////////////
        //TOP BANNER COMPONENTS
        ///////////////////////////////////////////////////////////////////////////////////////

        JLabel title = new JLabel("Hero Creator");
        title.setFont(titleFont);
        title.setBounds(30, 25, 213, 41);

        JLabel promptName = new JLabel("Enter Name:");
        promptName.setFont(appFont);
        promptName.setBounds(30, 85, 126, 25);

        enterName = new JTextField("");
        enterName.setBounds(164, 85, 175, 25);
        enterName.setBackground(textFieldColour);
        enterName.setFont(appFont);

        add(title);
        add(promptName);
        add(enterName);

        ///////////////////////////////////////////////////////////////////////////////////////
        //CHARACTER CLASS SELECTION
        // /////////////////////////////////////////////////////////////////////////////////////

        JLabel characterType = new JLabel("Frog Type");
        characterType.setBounds(30, 125, 108, 29);
        characterType.setFont(appFont);

        classText = new JTextArea(""); //description set with actionlistener
        classText.setBounds(30,285,313,50);
        classText.setLineWrap(true);
        classText.setBackground(textFieldColour);
        classText.setFont(appFont);

        classImage = new JLabel("Select a Class", SwingConstants.RIGHT); //justify right so it lines up with the weapon image text
        classImage.setBounds(150,140,191,136);
        classImage.setFont(appFont);

        add(characterType);
        add(classText);
        add(classImage);

        addClassRadio(jRadioFont);

        add(rdoDesertRain);
        add(rdoHorned);
        add(rdoPoisonDart);

        ///////////////////////////////////////////////////////////////////////////////////////
        //CHARACTER STATS
        ///////////////////////////////////////////////////////////////////////////////////////

        addRerollButton();
        add(reroll);

        JLabel characterStats = new JLabel("Frog Stats");
        characterStats.setBounds(370,125,114,29);
        characterStats.setFont(appFont);

        JLabel hp = new JLabel("Hit Points");
        hp.setBounds(370, 166, 100, 23);
        hp.setFont(appFont);

        hpText = new JTextField("");
        hpText.setBounds(536, 166, 40, 23);
        hpText.setBackground(textFieldColour);
        hpText.setFont(appFont);

        JLabel defense = new JLabel("Defense");
        defense.setBounds(370, 192, 100, 23);
        defense.setFont(appFont);

        defenseText = new JTextField("");
        defenseText.setBounds(536,192,40,23);
        defenseText.setBackground(textFieldColour);
        defenseText.setFont(appFont);

        JLabel agility = new JLabel("Agility");
        agility.setBounds(370,218,100,23);
        agility.setFont(appFont);

        agilityText = new JTextField("");
        agilityText.setBounds(536,218, 40, 23);
        agilityText.setBackground(textFieldColour);
        agilityText.setFont(appFont);

        JLabel baseAttack = new JLabel("Base Attack");
        baseAttack.setBounds(370,244,100,23);
        baseAttack.setFont(appFont);

        baseAttackText = new JTextField("");
        baseAttackText.setBounds(536,244,40,23);
        baseAttackText.setBackground(textFieldColour);
        baseAttackText.setFont(appFont);

        add(characterStats);
        add(hp);
        add(hpText);
        add(defense);
        add(defenseText);
        add(agility);
        add(agilityText);
        add(baseAttack);
        add(baseAttackText);

        ///////////////////////////////////////////////////////////////////////////////////////
        //WEAPON SELECTION
        ///////////////////////////////////////////////////////////////////////////////////////

        addWeaponRadio(jRadioFont);

        add(rdoDagger);
        add(rdoClub);
        add(rdoDiscus);

        JLabel weaponSelect = new JLabel("Select Your Weapon");
        weaponSelect.setBounds(28, 350, 222, 29);
        weaponSelect.setFont(appFont);

        weaponImage = new JLabel("Select a Weapon", SwingConstants.RIGHT);
        weaponImage.setBounds(210,390,130,111);
        weaponImage.setFont(appFont);

        weaponText = new JTextArea();
        weaponText.setBounds(27,495,313,60);
        weaponText.setLineWrap(true);
        weaponText.setBackground(textFieldColour);
        weaponText.setFont(appFont);

        add(weaponSelect);
        add(weaponImage);
        add(weaponText);

        ///////////////////////////////////////////////////////////////////////////////////////
        //WEAPON STATS / START BUTTON
        ///////////////////////////////////////////////////////////////////////////////////////

        JLabel weaponStats = new JLabel("Weapon Stats");
        weaponStats.setBounds(370,350,222,29);
        weaponStats.setFont(appFont);

        JLabel attackModifier = new JLabel("Attack Modifier:");
        attackModifier.setBounds(370,390,126,23);
        attackModifier.setFont(appFont);

        attackModifierText = new JTextField();
        attackModifierText.setBounds(536, 390, 40,23);
        attackModifierText.setBackground(textFieldColour);
        attackModifierText.setFont(appFont);

        JLabel weight = new JLabel("Weight:");
        weight.setBounds(370, 416, 126, 23);
        weight.setFont(appFont);

        weightText = new JTextField();
        weightText.setBounds(536,416,40,23);
        weightText.setBackground(textFieldColour);
        weightText.setFont(appFont);

        add(weaponStats);
        add(attackModifier);
        add(attackModifierText);
        add(weight);
        add(weightText);

        this.startBattle = new JButton("Start Battle");
        startBattle.setBounds(380,495,150,60);
        startBattle.setFont(appFont);

        //actionlistener for this button is in GameFrame
        add(this.startBattle);
    }

    //create radio buttons in their own method for easier reading
    private void addClassRadio(Font jRadioFont) {

        rdoDesertRain = new JRadioButton("Desert Rain");
        rdoDesertRain.setFont(jRadioFont);
        rdoDesertRain.setBounds(30, 166, 95, 23);

        rdoHorned = new JRadioButton("Horned");
        rdoHorned.setFont(jRadioFont);
        rdoHorned.setBounds(30, 205, 95, 23);

        rdoPoisonDart = new JRadioButton("Poison Dart");
        rdoPoisonDart.setFont(jRadioFont);
        rdoPoisonDart.setBounds(30, 244, 95, 23);

        classRadio = new ButtonGroup();
        classRadio.add(rdoDesertRain);
        classRadio.add(rdoPoisonDart);
        classRadio.add(rdoHorned);

        rdoDesertRain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player = GameFrame.getPlayer();
                player = new DesertRainFrog();

                createPlayer(player);
            }
        });


        rdoPoisonDart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player;
                player = new PoisonDartFrog();

                createPlayer(player);
            }
        });

        rdoHorned.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player;
                player = new ArgentineHornedFrog();

                createPlayer(player);
            }
        });
    }

    //method to reduce repeated code in chararcter radio buttons
    private void createPlayer(Player player) {
        setPlayerStats(player);

        //change the frog picture:
        classImage.setText("");
        classImage.setIcon(player.getCharacterImage());

        //display a description:
        classText.setText(player.getClassDescription());

        //allow the player to use previously locked buttons
        rdoClub.setEnabled(true);
        rdoDagger.setEnabled(true);
        rdoDiscus.setEnabled(true);
        reroll.setEnabled(true);

        //send the created player up to the frame so that it can be accessed everywhere
        GameFrame.setPlayer(player);
    }

    //used when selecting a class and clicking the reroll button:
    private void setPlayerStats(Player player) {
        //use the random stat method for the selected subclass:
        player.rerollStats();

        hpText.setText(String.format("%d", player.getHitPoints()));
        defenseText.setText(String.format("%d", player.getDefense()));
        agilityText.setText(String.format("%d", player.getAgility()));
        baseAttackText.setText(String.format("%d", player.getBaseAttack()));
    }

    private void addWeaponRadio(Font jRadioFont) {

        rdoDagger = new JRadioButton("Dagger");
        rdoDagger.setFont(jRadioFont);
        rdoDagger.setBounds(30,390, 145, 23);

        rdoClub = new JRadioButton("Club");
        rdoClub.setFont(jRadioFont);
        rdoClub.setBounds(30, 429, 145, 23);

        rdoDiscus = new JRadioButton("Mushroom Discus");
        rdoDiscus.setFont(jRadioFont);
        rdoDiscus.setBounds(30,468,145,23);

        //make sure all weapon buttons are initially unclickable until they select a  class
        rdoDagger.setEnabled(false);
        rdoClub.setEnabled(false);
        rdoDiscus.setEnabled(false);

        weaponRadio = new ButtonGroup();
        weaponRadio.add(rdoDagger);
        weaponRadio.add(rdoClub);
        weaponRadio.add(rdoDiscus);

        rdoDagger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player = GameFrame.getPlayer();
                Weapon weapon = new Weapon(Weapon.WeaponType.DAGGER);

                setPlayerWeapon(player, weapon);
            }
        });

        rdoClub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player = GameFrame.getPlayer();
                Weapon weapon = new Weapon(Weapon.WeaponType.CLUB);

                setPlayerWeapon(player, weapon);
            }
        });
        rdoDiscus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player = GameFrame.getPlayer();
                Weapon weapon = new Weapon(Weapon.WeaponType.DISCUS);

                setPlayerWeapon(player, weapon);
            }
        });
    }

    //method to avoid duplicate code in weapon radio buttons
    private void setPlayerWeapon(Player player, Weapon weapon) {

        attackModifierText.setText(String.format("%.1f", weapon.getAttackModifier()));
        weightText.setText(String.format("%.1f", weapon.getWeight()));

        weaponImage.setText("");
        weaponImage.setIcon(weapon.getWeaponImage());
        weaponText.setText(weapon.getWeaponDescription());

        player.setWeapon(weapon);
        GameFrame.setPlayer(player);
    }

    //create reroll button
    private void addRerollButton() {
        reroll = new JButton("Reroll");
        reroll.setBounds(438,300,80,23);

        //reroll is disabled until they select a character class
        reroll.setEnabled(false);

        reroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //make your player:
                Player player = GameFrame.getPlayer();
                setPlayerStats(player);
            }
        });
    }

    //called when "play again" is selected in the battle panel, makes a clean slate
    public void resetCharacterCreationPanel() {
        //name text
        enterName.setText("");
        //class radios
        classRadio.clearSelection();
        //class text
        classText.setText("");
        //class image
        classImage.setIcon(null);
        classImage.setText("Select a Class");
        //weapon radios
        weaponRadio.clearSelection();
        rdoDagger.setEnabled(false);
        rdoClub.setEnabled(false);
        rdoDiscus.setEnabled(false);
        //weapon text
        weaponText.setText("");
        //weapon image
        weaponImage.setIcon(null);
        weaponImage.setText("Select a Weapon");
        //frog stats
        hpText.setText("");
        defenseText.setText("");
        agilityText.setText("");
        baseAttackText.setText("");
        //weapon stats
        attackModifierText.setText("");
        weightText.setText("");
        //reroll button
        reroll.setEnabled(false);
    }
}
