package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scene3 {
    JFrame frame;
    private JButton button;
    private JLabel label_3;
    private JLabel label_5;
    private JLabel label_2;
    private JLabel label_2_1;
    private JLabel lblScene;
    private int currentMethod;
    private static String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene3 window = new Scene3(username);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Scene3(String username) {
        Scene3.username = username;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        button = new JButton("Next");
        button.setBounds(770, 520, 86, 20);
        button.setVisible(true);
        frame.getContentPane().add(button);

        lblScene = new JLabel("");
        lblScene.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblScene.setBounds(150, 490, 103, 25);
        frame.getContentPane().add(lblScene);

        label_3 = new JLabel("");
        label_3.setBounds(230, 460, 744, 140);
        frame.getContentPane().add(label_3);

        label_5 = new JLabel("");
        label_5.setBounds(240, 460, 744, 140);
        frame.getContentPane().add(label_5);

        JLabel label_3_1 = new JLabel("");
        label_3_1.setIcon(new ImageIcon(Scene3.class.getResource("/textmessage2.png")));
        label_3_1.setBounds(60, 420, 900, 225);
        frame.getContentPane().add(label_3_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Scene3.class.getResource("/King sleeping.png")));
        label.setBounds(0, 0, 1008, 730);
        frame.getContentPane().add(label);

        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleMethod();
            }
        });
    }

    public void toggleMethod() {
        switch (currentMethod) {
            case 0:
                dialogue1();
                break;
            case 1:
                dialogue2();
                break;
            case 2:
                openScene4();
                break;
            default:
                break;
        }
        currentMethod = (currentMethod + 1) % 3;
    }

    public void dialogue1() {
        label_3.setText("One breezy night, as " + username + " is sleeping sound....");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
    }

    public void dialogue2() {
        label_5.setText("<html>The best dream of gold and money " + username +
                " could ever have <br> has been replaced by a nightmare that will change <br>" + username + "'s life. ");
        label_3.setText("");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
    }

    private void openScene4() {
        frame.dispose(); // Close the current scene1 frame

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene4 scene4 = new Scene4(username);
                    scene4.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
