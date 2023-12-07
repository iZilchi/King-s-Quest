package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scene2 {
    JFrame frame;
    private JButton button;

    private JLabel label_3;
    private JLabel label_5;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_2_1;
    private JLabel lblScene;
    private int currentMethod;

    private String username;

    public Scene2(String username) {
        this.username = username;
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

        lblScene = new JLabel("SCENE 3");
        lblScene.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblScene.setBounds(210, 450, 103, 25);

        label_3 = new JLabel("");
        label_3.setBounds(250, 460, 744, 140);
        frame.getContentPane().add(label_3);

        label_5 = new JLabel("");
        label_5.setBounds(210, 460, 744, 140);
        frame.getContentPane().add(label_5);

        JLabel label_3_1 = new JLabel("");
        label_3_1.setIcon(new ImageIcon(Scene3.class.getResource("/textmessage2.png")));
        label_3_1.setBounds(60, 420, 900, 225);
        frame.getContentPane().add(label_3_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Scene3.class.getResource("/Poor kingdom.png")));
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
                openScene3();
                break;
            default:
                break;
        }
        currentMethod = (currentMethod + 1) % 3;
    }


    public void dialogue1() {
        label_5.setText("<html><div style='text-align: left;'>The King, blinded by his lust for wealth, named " + username + "<br>" +
                " had taxed the people into destitution.</div></html>");
        label_3.setText("");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
    }

    public void dialogue2() {
        label_3.setText("<html><div style='text-align: center;'>-- draining the lifeblood from the very soil that once bore <br>" +
                "abundance</div></html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
    }



    private void openScene3() {
        frame.dispose();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene3 scene3 = new Scene3(username);
                    scene3.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
