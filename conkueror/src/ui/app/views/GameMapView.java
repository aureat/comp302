package ui.app.views;

import domain.game.Game;
import domain.game.Phase;
import domain.player.Player;
import ui.app.Context;
import ui.assets.Fonts;
import ui.service.GameController;
import ui.service.MapController;
import ui.app.router.Route;
import ui.app.controllers.GameMapController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.core.ImageBtnStack;
import ui.components.core.ImageButton;
import ui.components.maps.ClassicMapBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


@View(at = Route.GameMap)
public class GameMapView extends ViewPanel<GameMapController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets buttons = Assets.MenuMd;
    private final Assets cards = Assets.PanelContext;
    private final Assets phase = Assets.PanelPhase;
    private final Assets phases = Assets.PanelPhases;
    private final Assets avatars = Assets.AvatarCircular;
    private final Assets colors = Assets.ColorFrame;
    private final Assets drafts = Assets.PanelDraft;

    public JLabel phaseLabel = new JLabel();
    public JLabel avatarLabel = new JLabel();
    public JLabel colorLabel = new JLabel();

    public JLabel fortifyLabel = new JLabel();
    public JLabel attackLabel = new JLabel();
    public JLabel draftLabel = new JLabel();

    public List<ImageButton> draftButtons = new ArrayList<>();
    public ImageButton nextButton = new ImageButton(phase.getAsset("next").getImageIcon(64,64),500,500);
    public ImageButton aiButton = new ImageButton(phase.getAsset("ai").getImageIcon(64,64),500,500);

    public List<JLabel> avatarLabels = new ArrayList<>();
    public List<JLabel> colorLabels = new ArrayList<>();

    public ImageButton armyButton;
    public ImageButton territoryButton;
    public ImageButton effectButton;

    public JLabel cardName = new JLabel("");

    public GameController gameController;

    public GameMapView() {
        setLayout(null);
    }

    @Override
    public void preload() {

        gameController = GameController.getInstance();
        gameController.setView(this);

        backgrounds.loadAsset("map");
        buttons.loadAsset("pause");
        buttons.loadAsset("help");

        for (int i = 1;i<=20;i++){
            drafts.loadAsset(String.format("%d",i));
        }

        cards.loadAsset("army");
        cards.loadAsset("territory");
        cards.loadAsset("effect");
    }

    public void initialize() {

        // Set Background
        setViewBackground(backgrounds.getAsset("map"));

        // Game Map
        ClassicMapBoard map = new ClassicMapBoard(MapController.Mode.Game);
        map.setBounds(
                (getWidth() - map.getWidth())/2,
                15,
                map.getWidth(),
                map.getHeight()
        );
        add(map);

        // Button Stack
        ImageBtnStack stack1 = new ImageBtnStack(ImageBtnStack.VERTICAL, 48, 50, 22, 20);
        stack1.addButton(buttons.getAsset("pause"))
                .addActionListener(e -> getController().redirect(Route.Pause));
        stack1.addButton(buttons.getAsset("help"))
                .addActionListener(e -> getController().redirect(Route.Help));
        positionNorthWest(stack1, 30, 30);
        add(stack1);

        // Card Stack
        ImageBtnStack stack2 = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 37, 49, 22, 20);
        armyButton = stack2.addButton(cards.getAsset("army"));
        armyButton.addActionListener(e -> gameController.applyArmyCard());
        armyButton.setVisible(false);
        territoryButton = stack2.addButton(cards.getAsset("territory"));
        territoryButton.addActionListener(e -> gameController.applyTerritoryCard());
        territoryButton.setVisible(false);
        effectButton = stack2.addButton(cards.getAsset("effect"));
        effectButton.addActionListener(e -> {
            gameController.applyEffectCard();
        });
        effectButton.setVisible(false);
        positionSouthWest(stack2, 30, 18);
        add(stack2);

        // card name
        cardName.setFont(Fonts.GilroyExtraBold.deriveFont(21f));
        cardName.setHorizontalAlignment(JLabel.CENTER);
        cardName.setVerticalTextPosition(JLabel.CENTER);
        cardName.setVerticalAlignment(JLabel.CENTER);
        cardName.setHorizontalTextPosition(JLabel.CENTER);
        cardName.setVerticalTextPosition(JLabel.CENTER);
        cardName.setForeground(Color.WHITE);
        cardName.setBounds(getWidth() - 260, getHeight() - 50, 250, 40);
        add(cardName);

        // Phase Panel
        ImageIcon blackBack = phase.getAsset("bg").getImageIcon(391,77);
        phaseLabel.setBounds(getContainerWidth()/2-195,getContainerHeight()-77,391,77);
        phaseLabel.setIcon(blackBack);
        nextButton.setBounds(phaseLabel.getWidth()-70,5,64,64);
        phaseLabel.add(nextButton);

        draftButtons = new ArrayList<>();
        for (int i = 0; i<20; i++) {
            ImageButton draftButton = new ImageButton(drafts.getAsset(String.format("%d",i+1)).getImageIcon(64,64),500,500);
            draftButton.setBounds(phaseLabel.getWidth()-70,5,64,64);
            draftButton.setVisible(false);
            phaseLabel.add(draftButton);
            draftButtons.add(draftButton);
        }

        ImageIcon attackPhase = phases.getAsset("attack").getImageIcon(206,77);
        attackLabel.setIcon(attackPhase);
        attackLabel.setBounds(103,0,206,77);
        phaseLabel.add(attackLabel);
        attackLabel.setVisible(false);

        ImageIcon draftPhase = phases.getAsset("draft").getImageIcon(206,77);
        draftLabel.setIcon(draftPhase);
        draftLabel.setBounds(103,0,206,77);
        phaseLabel.add(draftLabel);

        ImageIcon fortifyPhase = phases.getAsset("fortify").getImageIcon(206,77);
        fortifyLabel = new JLabel(fortifyPhase);
        fortifyLabel.setBounds(103,0,206,77);
        phaseLabel.add(fortifyLabel);
        fortifyLabel.setVisible(false);

        nextButton.addActionListener(e -> {

            if (Game.getInstance().getPhase() == Phase.GameOver) {
                getController().redirect(Route.GameOver);
                return;
            }

            MapController.get().deselect();
            Game.getInstance().nextPhase();
            if (Game.getInstance().getPhase() == Phase.Draft) {
                cardName.setText("");
                GameController.getInstance().setChanceCardMode(false);
                GameController.getInstance().setArmyCardMode(false);
            }
            gameController.updatePhasePanel();
            gameController.updateContextPanel();
        });
        add(phaseLabel);

        gameController.updatePhasePanel();

    }

}

