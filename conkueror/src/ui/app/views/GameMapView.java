package ui.app.views;

import domain.game.Game;
import ui.app.Context;
import ui.app.router.Route;
import ui.app.controllers.GameMapController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.core.ImageBtnStack;
import ui.components.core.ImageButton;
import ui.components.map.WorldMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@View(at = Route.GameMap)
public class GameMapView extends ViewPanel<GameMapController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets buttons = Assets.MenuMd;
    private final Assets cards = Assets.PanelContext;
    private final Assets phase = Assets.PanelPhase;
    private final Assets phases = Assets.PanelPhases;
    private final Assets avatars = Assets.AvatarCircular;
    private final Assets colors = Assets.ColorFrame;
    private int turn = 0;
    private JLabel phaseLabel = new JLabel();
    private JLabel avatarLabel = new JLabel();
    private JLabel colorLabel = new JLabel();
    private ArrayList<JLabel> avatarLabels = new ArrayList<>();
    private ArrayList<JLabel> colorLabels = new ArrayList<>();


    public GameMapView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("map");
        buttons.loadAsset("pause");
        buttons.loadAsset("help");
        buttons.loadAsset("cards");

        cards.loadAsset("army");
        cards.loadAsset("territory");
        cards.loadAsset("effect");

        for (int p = 0 ; p < Game.getInstance().getPlayersCount()-1;p++){
            avatars.loadAsset(Game.getInstance().getPlayers().get(p).getAvatar().toString());
            colors.loadAsset(Game.getInstance().getPlayers().get(p).getColor().toString());
        }


    }

    public void initialize() {

        Assets backgrounds = Assets.Background;

        // Set Background
        setViewBackground(backgrounds.getAsset("map"));

        // map
        WorldMap map = new WorldMap();
        getController().setMap(map);
        setSizeOnCenter(map);
        add(map);

        // Button Stack
        ImageBtnStack stack1 = new ImageBtnStack(ImageBtnStack.VERTICAL, 48, 50, 22, 20);
        stack1.addButton(buttons.getAsset("pause"))
                .addActionListener(e -> getController().redirect(Route.Pause));
        stack1.addButton(buttons.getAsset("help"))
                .addActionListener(e -> getController().redirect(Route.Help));
        stack1.addButton(buttons.getAsset("cards"))
                .addActionListener(e -> System.exit(0));

        // place the stack in the panel
        stack1.setBounds(
                30,
                30,
                stack1.getPreferredSize().width,
                stack1.getPreferredSize().height
        );

        add(stack1);

        // Card Stack
        ImageBtnStack stack2 = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 37, 49, 22, 20);
        stack2.addButton(cards.getAsset("army"))
                .addActionListener(e -> getController().redirect(Route.Pause));
        stack2.addButton(cards.getAsset("territory"))
                .addActionListener(e -> getController().redirect(Route.Help));
        stack2.addButton(cards.getAsset("effect"))
                .addActionListener(e -> System.exit(0));

        // place stack in the panel
        stack2.setBounds(
                30,
                getContainerHeight()-67,
                stack2.getPreferredSize().width,
                stack2.getPreferredSize().height
        );

        add(stack2);

        ImageIcon blackBack = phase.getAsset("bg").getImageIcon(391,77);
        phaseLabel.setBounds(getContainerWidth()/2-195,getContainerHeight()-77,391,77);
        phaseLabel.setIcon(blackBack);
        ImageButton nextButton = new ImageButton(phase.getAsset("next").getImageIcon(64,64),500,500);
        nextButton.setBounds(phaseLabel.getWidth()-70,5,64,64);
        phaseLabel.add(nextButton);

        ImageIcon attackPhase = phases.getAsset("attack").getImageIcon(206,77);
        JLabel attackLabel = new JLabel(attackPhase);
        attackLabel.setBounds(103,0,206,77);
        phaseLabel.add(attackLabel);
        attackLabel.setVisible(false);

        ImageIcon draftPhase = phases.getAsset("draft").getImageIcon(206,77);
        JLabel draftLabel = new JLabel(draftPhase);
        draftLabel.setBounds(103,0,206,77);
        phaseLabel.add(draftLabel);

        ImageIcon fortifyPhase = phases.getAsset("fortify").getImageIcon(206,77);
        JLabel fortifyLabel = new JLabel(fortifyPhase);
        fortifyLabel.setBounds(103,0,206,77);
        phaseLabel.add(fortifyLabel);
        fortifyLabel.setVisible(false);

        for(int n = 0;n<Game.getInstance().getPlayersCount();n++){
            avatarLabels.add(new JLabel());
            colorLabels.add(new JLabel());
        }


        rounder(turn);





        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (draftLabel.isVisible()){
                    attackLabel.setVisible(true);
                    draftLabel.setVisible(false);
                }else if (attackLabel.isVisible()) {
                    fortifyLabel.setVisible(true);
                    attackLabel.setVisible(false);
                }else if (fortifyLabel.isVisible()) {
                    draftLabel.setVisible(true);
                    fortifyLabel.setVisible(false);
                    turn++;
                    rounder(turn);
                }
            }
        });





        add(phaseLabel);

    }
    public void rounder(int i){

        i = i%(Game.getInstance().getPlayersCount());
        ImageIcon colorF = colors.getAsset(Game.getInstance().getPlayers().get(i).getColor().toString().toLowerCase()).getImageIcon(70,70);
        colorLabel.setIcon(colorF);
        colorLabel.setBounds(0,0,70,70);
        ImageIcon avatarR = avatars.getAsset(Game.getInstance().getPlayers().get(i).getAvatar().toString().toLowerCase()).getImageIcon(70,70);
        avatarLabel.setIcon(avatarR);
        avatarLabel.setBounds(5,0,70,70);
        avatarLabel.add(colorLabel);
        phaseLabel.add(avatarLabel);

        //for(int a = 0; a<avatarLabels.size()-1)
        //ImageIcon color = colors.getAsset(Game.getInstance().getPlayers().get((i+1)%Game.getInstance().getPlayersCount()).getColor().toString().toLowerCase()).getImageIcon(70,70);
        //colorLabels.get(a).setIcon(color);
        //ncLabel1.setBounds(0,0,70,70);
        //ImageIcon avatar1 = avatars.getAsset(Game.getInstance().getPlayers().get((i+1)%Game.getInstance().getPlayersCount()).getAvatar().toString().toLowerCase()).getImageIcon(70,70);
        //naLabel1.setIcon(avatar1);
        //naLabel1.setBounds(getContainerWidth()-105,21,70,70);
        //naLabel1.add(ncLabel1);
        //phaseLabel.add(naLabel1);
    }

}

