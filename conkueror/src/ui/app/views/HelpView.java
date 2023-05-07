package ui.app.views;

import domain.game.Game;
import ui.app.Context;
import ui.app.controllers.HelpController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageBtnStack;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@View(at = Route.Help)
public class HelpView extends ViewPanel<HelpController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets menu = Assets.MenuMd;
    private final Assets board = Assets.PanelBoard;
    private final Assets buttons = Assets.ButtonLg;
    private final Assets avatar = Assets.AvatarCircular;
    private final Assets frame = Assets.ColorFrame;

    public HelpView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("sunburst-logo-sm");

        menu.loadAsset("resume");
    }

    public void initialize() {

        Assets backgrounds = Assets.Background;
        Assets buttons = Assets.ButtonLg;

        // Set Background
        setViewBackground(backgrounds.getAsset("sunburst-logo-sm"));

        // Button Stack
        ImageBtnStack stack1 = new ImageBtnStack(ImageBtnStack.VERTICAL, 48, 50, 16, 20);
        stack1.addButton(menu.getAsset("resume"))
                .addActionListener(e -> getController().redirect(Route.GameMap));


        // center the stack in the panel
        stack1.setBounds(
                21,
                21,
                stack1.getPreferredSize().width,
                stack1.getPreferredSize().height
        );

        add(stack1);


        ImageIcon blackBack = board.getAsset("bg").getImageIcon(896,469);
        JLabel boardLabel = new JLabel(blackBack);
        boardLabel.setBounds((getContainerWidth()-896)/2,(getContainerHeight()-469)/2,896,469);

        JLabel textLabel = new JLabel();
        textLabel.setBounds(0,0,850,450);
        textLabel.setLayout(new BorderLayout());

        JTextField playerName = new JTextField();
        playerName.setText("ConKUeror is a multiplayer strategy game that can be played on Windows, MacOS, and Linux.\n The game is about conquering and invading countries in a virtual multiplayer world, and it offers a unique and immersive gaming experience that challenges players' strategic thinking and decision-making skills.\n The game has three types of cards: territory cards, army cards, and chance cards.\n Players can trade army cards to gain an additional army if they have a set of three cards. Each player is given a number of infantry pieces at the beginning of the game, and they take turns placing their armies onto unoccupied territories until all territories are claimed. The game continues until a player has reached complete world domination. A round of the game consists of three phases: draft, attack, and fortify.\n The game can be customized with various features and gameplay options, making it appealing to different interest groups.");
        playerName.setEditable(false);
        playerName.setBorder(new LineBorder(new Color(1f,0f,0f,0f )));
        playerName.setFont(Fonts.GilroyBold.deriveFont(24f));
        playerName.setForeground(Color.white);
        playerName.setPreferredSize(new Dimension(555,57));
        playerName.setOpaque(false);

        textLabel.add(playerName);
        boardLabel.add(textLabel);


        add(boardLabel);

    }

}
