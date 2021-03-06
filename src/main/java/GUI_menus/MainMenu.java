package GUI_menus;

import GUI_components.GUIConfigLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu extends GameMenu {
    private JButton playButton, storeButton, statusButton, collectionsButton, settingsButton, exitButton;
    private Actions actions;

    public MainMenu() {
        super();
        initMenu();
        initButtons();

        repaint();
    }

    private void initMenu() {
        setLayout(null);
        setBounds(GUIConfigLoader.mainMenu.menuBounds);

    }

    private void initButtons() {
        actions = new Actions();

        playButton = new JButton("Play");
        playButton.setBounds(GUIConfigLoader.mainMenu.playButton_bounds);
        playButton.addActionListener(actions);
        add(playButton);

        storeButton = new JButton("Store");
        storeButton.setBounds(GUIConfigLoader.mainMenu.storeButton_bounds);
        storeButton.addActionListener(actions);
        add(storeButton);

        statusButton = new JButton("Status");
        statusButton.setBounds(GUIConfigLoader.mainMenu.statusButton_bounds);
        statusButton.addActionListener(actions);
        add(statusButton);

        collectionsButton = new JButton("Collections");
        collectionsButton.setBounds(GUIConfigLoader.mainMenu.collectionsButton_bounds);
        collectionsButton.addActionListener(actions);
        add(collectionsButton);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(GUIConfigLoader.mainMenu.settingsButton_bounds);
        settingsButton.addActionListener(actions);
        add(settingsButton);

        exitButton = new JButton("Quit");
        exitButton.setBounds(GUIConfigLoader.mainMenu.exitButton_bounds);
        exitButton.addActionListener(actions);
        add(exitButton);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        paintGraphics(g2d);
    }

    private void paintGraphics(Graphics2D g2d) {
        try {
            BufferedImage backgroundImage = ImageIO.read(GUIConfigLoader.mainMenu.background_image);
            g2d.drawImage(backgroundImage, 0, 0, GUIConfigLoader.mainMenu.menuBounds.width, GUIConfigLoader.mainMenu.menuBounds.height, null);

        } catch (IOException e) {


        }

    }

    private class Actions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                GameScreen.getInstance().gotoMenu("preparation");

            } else if (e.getSource() == storeButton) {
                menuAdmin.writeLog("Menu", "Store");
                GameScreen.getInstance().gotoMenu("store");

            } else if (e.getSource() == statusButton) {
                menuAdmin.writeLog("Menu", "Status");
                GameScreen.getInstance().gotoMenu("status");
                GameScreen.getInstance().refreshStatusMenu();


            } else if (e.getSource() == collectionsButton) {

                menuAdmin.writeLog("Menu", "Collections");
                GameScreen.getInstance().gotoMenu("collections");

            } else if (e.getSource() == settingsButton) {

            } else if (e.getSource() == exitButton) {

                menuAdmin.writeExitLog();
                System.exit(0);

            }
//
        }
    }
}

