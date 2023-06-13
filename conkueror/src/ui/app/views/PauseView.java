package ui.app.views;

import domain.game.Game;
import ui.app.Context;
import ui.app.router.Route;
import ui.app.controllers.PauseController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageBtnStack;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@View(at = Route.Pause)
public class PauseView extends ViewPanel<PauseController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets menu = Assets.MenuMd;
    private final Assets board = Assets.PanelBoard;
    private final Assets buttons = Assets.ButtonLg;
    private final Assets avatar = Assets.AvatarCircular;
    private final Assets frame = Assets.ColorFrame;

    private List<JTextField> acounts = new ArrayList<>();
    private List<JTextField> tcounts = new ArrayList<>();

    public PauseView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("sunburst-logo-sm");

        menu.loadAsset("resume");
        menu.loadAsset("help");

        board.loadAsset("bg");
        board.loadAsset("armies");
        board.loadAsset("territories");

//        for(int i = 0 ; i< Game.getInstance().getPlayersCount();i++){
//            frame.loadAsset(Game.getInstance().getPlayers().get(i).getColor().toString());
//            avatar.loadAsset(Game.getInstance().getPlayers().get(i).getAvatar().toString());
//        }

        buttons.loadAsset("save-exit");
        buttons.loadAsset("quit-game");

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
        stack1.addButton(menu.getAsset("help"))
                .addActionListener(e -> getController().redirect(Route.Help));


        // center the stack in the panel
        stack1.setBounds(
                25,
                25,
                stack1.getPreferredSize().width,
                stack1.getPreferredSize().height
        );

        add(stack1);

        // Button Stack
        ImageBtnStack stack2 = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 325, 59, 15, 30);
        stack2.addButton(buttons.getAsset("save-exit"))
                .addActionListener(e -> {
                    Game.getInstance().saveGame();
                });
        stack2.addButton(buttons.getAsset("quit-game"))
                .addActionListener(e -> System.exit(0));

        // center the stack in the panel
        stack2.setBounds(
                (getWidth() - stack2.getPreferredSize().width) / 2,
                (getHeight() - 2*stack2.getPreferredSize().height+20),
                stack2.getPreferredSize().width,
                stack2.getPreferredSize().height
        );

        add(stack2);

        ImageIcon blackBack = board.getAsset("bg").getImageIcon(896,469);
        JLabel boardLabel = new JLabel(blackBack);
        boardLabel.setBounds((getContainerWidth()-896)/2,(getContainerHeight()-469)/2,896,469);

        for(int i = 0; i<Game.getInstance().getPlayersCount();i++){
            ImageIcon cAvatar = avatar.getAsset(Game.getInstance().getPlayers().get(i).getAvatarString()).getImageIcon(57,57);
            JLabel avatarLabel = new JLabel(cAvatar);
            ImageIcon cFrame = frame.getAsset(Game.getInstance().getPlayers().get(i).getColor().toString()).getImageIcon(57,57);
            JLabel frameLabel = new JLabel(cFrame);
            frameLabel.setBounds(0,0,57,57);
            avatarLabel.add(frameLabel);
            avatarLabel.setBounds(35,21+73*i,57,57);
            boardLabel.add(avatarLabel);

            JLabel textLabel = new JLabel();
            textLabel.setBounds(100,21+73*i,555,57);
            textLabel.setLayout(new BorderLayout());
            JTextField playerName = new JTextField();
            playerName.setText(Game.getInstance().getPlayers().get(i).getFullName());
            playerName.setEditable(false);
            playerName.setBorder(new LineBorder(new Color(1f,0f,0f,0f )));
            playerName.setFont(Fonts.GilroyBold.deriveFont(24f));
            playerName.setForeground(Color.white);
            playerName.setPreferredSize(new Dimension(555,57));
            playerName.setOpaque(false);
            textLabel.add(playerName);
            boardLabel.add(textLabel);

            JLabel armies = new JLabel(board.getAsset("armies").getImageIcon(11,32));
            armies.setBounds(blackBack.getIconWidth()-200,30+73*i,11,32);
            JLabel territories = new JLabel(board.getAsset("territories").getImageIcon(21,24));
            territories.setBounds(blackBack.getIconWidth()-100,36+73*i,21,24);
            boardLabel.add(armies);
            boardLabel.add(territories);

            JLabel aLabel = new JLabel();
            aLabel.setBounds(blackBack.getIconWidth()-160,21+73*i,70,57);
            aLabel.setLayout(new BorderLayout());
            JTextField aCount = new JTextField();
            acounts.add(aCount);
            aCount.setText(String.valueOf(Game.getInstance().getPlayers().get(i).getAllArmiesCount()));
            aCount.setEditable(false);
            aCount.setBorder(new LineBorder(new Color(1f,0f,0f,0f )));
            aCount.setFont(Fonts.GilroyBold.deriveFont(24f));
            aCount.setForeground(Color.white);
            aCount.setPreferredSize(new Dimension(70,57));
            aCount.setOpaque(false);
            aLabel.add(aCount);
            boardLabel.add(aLabel);

            JLabel tLabel = new JLabel();
            tLabel.setBounds(blackBack.getIconWidth()-60,21+73*i,70,57);
            tLabel.setLayout(new BorderLayout());
            JTextField tCount = new JTextField();
            tcounts.add(tCount);
            tCount.setText(String.valueOf(Game.getInstance().getPlayers().get(i).getTerritoryCount()));
            tCount.setEditable(false);
            tCount.setBorder(new LineBorder(new Color(1f,0f,0f,0f )));
            tCount.setFont(Fonts.GilroyBold.deriveFont(24f));
            tCount.setForeground(Color.white);
            tCount.setPreferredSize(new Dimension(70,57));
            tCount.setOpaque(false);
            tLabel.add(tCount);
            boardLabel.add(tLabel);

        }

        add(boardLabel);

    }

    @Override
    public void onMount() {
        super.onMount();
        for (int i = 0; i < Game.getInstance().getPlayersCount(); i++) {
            acounts.get(i).setText(String.valueOf(Game.getInstance().getPlayers().get(i).getAllArmiesCount()));
            tcounts.get(i).setText(String.valueOf(Game.getInstance().getPlayers().get(i).getTerritoryCount()));
        }
    }
}
