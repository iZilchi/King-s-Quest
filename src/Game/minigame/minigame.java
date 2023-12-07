package Game.minigame;

import javax.swing.JFrame;
import java.awt.*;

public class minigame {

    public JFrame frame;
    private static String username;

    public minigame(String username){
        minigame.username = username;
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    minigame window = new minigame(username);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void initialize(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("King's Quest");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }

    public static String getUsername() {
        return username;
    }
}
