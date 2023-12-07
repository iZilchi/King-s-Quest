package Game;

import Game.minigame.minigame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Scene4 {
    JFrame frame;
    private JButton button;
    private JLabel label_3;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_9;
    private JLabel label_10;
    private JLabel label_11;
    private JLabel label_12;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_2_1;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel lblScene;
    private int currentMethod;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene4 window = new Scene4();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Scene4(String username) {
        this.username = username;
        initialize();
    }

    public Scene4() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        button = new JButton("Next");
        button.setBounds(750, 480, 86, 20);
        button.setVisible(true); // Initially not visible
        frame.getContentPane().add(button);

        lblScene = new JLabel("");
        lblScene.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblScene.setBounds(210, 450, 103, 25);
        frame.getContentPane().add(lblScene);

        label_3 = new JLabel("");
        label_3.setBounds(270, 420, 744, 140);
        frame.getContentPane().add(label_3);

        label_5 = new JLabel("");
        label_5.setBounds(270, 420, 744, 140);
        frame.getContentPane().add(label_5);

        label_6 = new JLabel("");
        label_6.setBounds(240, 420, 744, 140);
        frame.getContentPane().add(label_6);

        label_9 = new JLabel("");
        label_9.setBounds(295, 545, 744, 140);
        frame.getContentPane().add(label_9);

        label_10 = new JLabel("");
        label_10.setBounds(560, 545, 744, 140);
        frame.getContentPane().add(label_10);

        label_11 = new JLabel("");
        label_11.setBounds(295, 545, 744, 140);
        frame.getContentPane().add(label_11);

        label_12 = new JLabel("");
        label_12.setBounds(565, 545, 744, 140);
        frame.getContentPane().add(label_12);

        label_8 = new JLabel("");
        label_8.setIcon(new ImageIcon(Scene1.class.getResource("/choicebg.png")));
        label_8.setBounds(520, 580, 200, 77);
        frame.getContentPane().add(label_8);
        label_8.setVisible(false);

        label_7 = new JLabel("");
        label_7.setIcon(new ImageIcon(Scene1.class.getResource("/choicebg.png")));
        label_7.setBounds(250, 580, 200, 77);
        frame.getContentPane().add(label_7);
        label_7.setVisible(false);

        JLabel label_3_1 = new JLabel("");
        label_3_1.setIcon(new ImageIcon(Scene4.class.getResource("/textmessage2.png")));
        label_3_1.setBounds(60, 380, 900, 225);
        frame.getContentPane().add(label_3_1);

        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon(Scene4.class.getResource("/WickedWitch.png")));
        label_2.setBounds(650, 110, 253, 389);
        frame.getContentPane().add(label_2);

        label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(Scene4.class.getResource("/king.png")));
        label_1.setBounds(185, 120, 318, 341);
        frame.getContentPane().add(label_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Scene4.class.getResource("/goscene22.png")));
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

    public void label_7Clicked() {
        handleVisibility(); // Set visibility of labels
        dialogue6();
        button.setVisible(true);
    }

    public void label_8Clicked() {
        handleVisibility(); // Set visibility of labels
        dialogue8();
        button.setVisible(true);
    }

    public void label_9Clicked() {
        handleVisibility();
        dialogue14();
        dialogue13();
        button.setVisible(true);
    }

    public void label_10Clicked() {
        handleVisibility();
        dialogue16();
        dialogue15();
        button.setVisible(true);
    }

    private void handleVisibility() {
        label_7.setVisible(false);
        label_8.setVisible(false);
        label_9.setVisible(false);
        label_10.setVisible(false);
        label_11.setVisible(false);
        label_12.setVisible(false);
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
                dialogue4();
                break;
            case 4:
                dialogue9();
                break;
            case 5:
                dialogue10();
                break;
            case 6:
                dialogue11();
                break;
            case 7:
                dialogue12();
                break;
            case 8:
                openMiniGame();
                break;
            case 9:
                break;
            default:
                break;
        }
        currentMethod = (currentMethod + 1) % 10;
    }




    public void dialogue1() {
        label_3.setText("<html>King " + username + ": Wh- What is this?! Where am I?!! My precious<br>"
                + "gold! My Money!! NOOOOOOOO!!</html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
        label_6.setText("");
    }

    public void dialogue2() {
        label_3.setText("");
        label_5.setText("~~HIHIHIHIHIHIHIHIHI~~");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_6.setText("");
    }

    public void dialogue3() {
        label_3.setText("");
        label_5.setText("");
        label_6.setText("King " + username + ": Who are you? Where am I?");
        label_6.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
    }

    public void dialogue4() {
        label_3.setText("");
        label_5.setText("");
        label_6.setText("<html>Witch: Ah, King, greetings. I am the Witch of Greed, and you, my dear<br>"
                + "King, find yourself in the clutches of your own desires. You are here because <br>you "
                + "committed the sin of greed.</html>");
        label_6.setFont(new Font("Book Antiqua", Font.PLAIN, 18));

        label_9.setText("Deny your sin");
        label_9.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_10.setText("Admit your sin");
        label_10.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_11.setText("");
        label_12.setText("");

        label_7.setVisible(true);
        label_8.setVisible(true);
        button.setVisible(false);

        label_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_7Clicked();
            }
        });

        label_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_8Clicked();
            }
        });
    }

    public void dialogue5() {
        label_3.setText("<html>King " + username + ": Greed? What nonsense! My rule is about prosperity <br>" +
                "and opulence. I've brought wealth to my kingdom!</html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
        label_6.setText("");
    }

    public void dialogue6() {
        label_3.setText("<html>Witch: No your highness, your ruling has brought wealth to <br>" +
                "YOURSELF! How dare you deny the obvious?</html>");
        label_3.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_5.setText("");
        label_6.setText("");
    }

    public void dialogue7() {
        label_5.setText("<html>King " + username + ": So what? Everyone has their own desires! <br>" +
                "I'm sure everyone wants wealth. Don't you?</html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue8() {
        label_5.setText("<html>Witch: HIHIHIHI~~ How bold of you to say that. Not <br>everyone is a hog " +
                "like you who doesn't have self-control!</html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue9() {
        label_5.setText("<html>Witch: Your insatiable hunger for wealth and power has led you here, <br>" +
                "my King. This realm is a reflection of the darkness within <br>your heart. " +
                "The consequences of unchecked avarice.</html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue10() {
        label_5.setText("King " + username + ": ......");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue11() {
        label_5.setText("<html>Witch: To fix that greediness, we need to start with the most <br>" +
                "fundamental aspect of humans. VALUES</html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue12() {
        label_5.setText("<html>Witch: The only thing you can do to get out of here and awaken <br>" +
                "from this nightmare is to complete the trial that I have for you.</html>");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");

        label_9.setText("");
        label_10.setText("");
        label_11.setText("Do the trial");
        label_11.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_12.setText("Refuse the trial");
        label_12.setFont(new Font("Book Antiqua", Font.PLAIN, 18));

        label_11.setVisible(true);
        label_12.setVisible(true);

        label_7.setVisible(true);
        label_8.setVisible(true);
        button.setVisible(false);

        label_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_9Clicked();
            }
        });

        label_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_10Clicked();
            }
        });
    }

    public void dialogue13() {
        label_5.setText("King " + username + ": Okay fine, let's just get this over with....");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue14() {
        label_5.setText("Witch: Very well, let us proceed with the trial.");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue15() {
        label_5.setText("King " + username + ": No. I'm not going to do it!");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    public void dialogue16() {
        label_5.setText("Witch: Oh no, I'm sorry but it seems that you don't have the <br>" +
                "authority to choose here in my domain. Overcome the trial or stay here HIHIHIHIHI~~");
        label_5.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        label_3.setText("");
        label_6.setText("");
    }

    private void openMiniGame() {
        // Dispose of the current frame and open the mini-game
        frame.dispose();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    minigame window = new minigame(username);
//                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
