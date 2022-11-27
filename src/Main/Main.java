package Main;

import Main.GUI.GameFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameFrame characterCreation = new GameFrame();
                    characterCreation.setVisible(true);
                } catch (Exception e) {
                    //output info about the error
                    e.printStackTrace();
                }
            }
        });
    }
}
