package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scene1 {
    JFrame frame;
    private JButton button;
    private JLabel label_3;
    private JLabel label_5;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel lblScene;
    private int currentMethod;

    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene1 window = new Scene1("YourUsername");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Scene1(String username) {
        this.username = username;
        initialize();
    }

    public Scene1() {
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
        label_5.setBounds(230, 460, 744, 140);
        frame.getContentPane().add(label_5);

        JLabel label_3_1 = new JLabel("");
        label_3_1.setIcon(new ImageIcon(Scene1.class.getResource("/textmessage2.png")));
        label_3_1.setBounds(60, 420, 900, 225);
        frame.getContentPane().add(label_3_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Scene1.class.getResource("/Scene1.png")));
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
                dialogue3();
                break;
            case 3:
                openScene2();
                break;
            default:
                break;
        }
        currentMethod = (currentMethod + 1) % 4;
    }

    public void dialogue1() {
        label_3.setText("<html><div style='text-align: center;'>Once there was a kingdom ruled by greedy King " + username + ".</div></html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
    }

    public void dialogue2() {
        label_5.setText("<html><div style='text-align: center;'>The King, driven by greed, was named " + username + ".<br> "
                + "He had his eyes set only on wealth and would do anything, <br> "
                + "by any means to get what he wanted.</div></html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
    }

    public void dialogue3() {
        label_3.setText("<html><div style='text-align: center;'>The once-thriving kingdom now stood frail and the joy that once <br>"
                + "echoed through the streets had been replaced by the heavy <br>"
                + "silence of suffering, all because of King " + username + ".</div></html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
    }

    private void openScene2() {
        frame.dispose();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene2 scene2 = new Scene2(username);
                    scene2.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
