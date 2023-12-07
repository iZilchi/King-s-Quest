package Game;

import Game.minigame.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Menu {
    private JFrame window;
    private JLayeredPane layeredPane;
    private JPanel titleNamePanel, buttonPanel, loadingPanel;
    private JLabel titleNameLabel, loadingLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);
    private JButton startButton, spaceButton, exitButton;
    private JButton lastHoveredButton;
    public String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Menu menu = new Menu();
        });
    }


    public Menu() {
        window = new JFrame();
        window.setSize(1024, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        layeredPane = new JLayeredPane();
        window.setContentPane(layeredPane);

        ImageIcon backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1024, 768);
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);

        titleNamePanel = new JPanel();
        titleNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        titleNamePanel.setOpaque(false);
        titleNameLabel = new JLabel("KING'S QUEST");
        titleNameLabel.setForeground(Color.pink);
        titleNameLabel.setFont(titleFont);

        titleNamePanel.add(titleNameLabel);
        titleNamePanel.setBounds(112, 100, 800, 200);
        layeredPane.add(titleNamePanel, JLayeredPane.PALETTE_LAYER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setOpaque(false);

        startButton = createButton("PLAY", e -> startButtonClicked());
        spaceButton = createButton(" ", e -> space());
        exitButton = createButton("EXIT", e -> exitButtonClicked());

        buttonPanel.add(startButton);
        buttonPanel.add(spaceButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBounds(312, 300, 400, 200);
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        setHover(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBackground(Color.black);
        button.setForeground(Color.pink);
        button.setFont(normalFont);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(actionListener);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setHover(button);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetHover();
            }
        });

        return button;
    }

    private void setHover(JButton button) {
        resetHover();
        lastHoveredButton = button;
        button.setForeground(Color.white);
        button.setText(">" + " " + button.getText());
    }

    private void resetHover() {
        if (lastHoveredButton != null) {
            lastHoveredButton.setForeground(Color.pink);
            String buttonText = lastHoveredButton.getText();
            lastHoveredButton.setText(buttonText.substring(2));
            lastHoveredButton = null;
        }
    }

    private void showUsernameInputDialog() {
        // Input dialog for the username
        username = JOptionPane.showInputDialog(window, "What is your name my King?");
        Database db = new Database();

        if (username != null && !username.isEmpty()) {
            // If a username is provided, proceed with the loading
            db.setUsername(username);
            showLoadingScreen();
            loadGameAsync();
        }
        // If the user cancels or provides an empty username, do nothing
    }

    private void loadGameAsync() {
        SwingWorker<Void, ImageIcon> worker = new SwingWorker<Void, ImageIcon>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a loading process
                publish(new ImageIcon(getClass().getClassLoader().getResource("loading.png")));
                Thread.sleep(1000);
                publish(new ImageIcon(getClass().getClassLoader().getResource("loading.png")));
                Thread.sleep(1000);
                publish(new ImageIcon(getClass().getClassLoader().getResource("loading.png")));
                Thread.sleep(1000);
                return null;
            }

            @Override
            protected void process(List<ImageIcon> chunks) {
                loadingLabel.setIcon(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                System.out.println("Loading complete!");
                // Hide loading screen
                loadingPanel.setVisible(false);
                layeredPane.remove(loadingPanel);
                // Open the next scene
                openScene1(username);
            }
        };

        // Show loading screen
        worker.execute();
    }

    private void startButtonClicked() {
        // Show input dialog for the username
        showUsernameInputDialog();
    }

    private void space() {
        // Add logic for the Load button here
    }

    private void exitButtonClicked() {
        int confirmed = JOptionPane.showConfirmDialog(window, "Are you sure you want to exit the game?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void showLoadingScreen() {
        loadingPanel = new JPanel();
        loadingPanel.setLayout(new BorderLayout());
        loadingPanel.setBounds(0, 0, window.getWidth(), window.getHeight());
        loadingPanel.setOpaque(true);
        loadingPanel.setBackground(Color.BLACK);

        loadingLabel = new JLabel();
        loadingPanel.add(loadingLabel, BorderLayout.CENTER);

        layeredPane.add(loadingPanel, JLayeredPane.MODAL_LAYER);
    }

    private void openScene1(String username) {
        window.dispose();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Scene1 scene1 = new Scene1(username);
                    scene1.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getUsername() {
        return username;
    }
}
