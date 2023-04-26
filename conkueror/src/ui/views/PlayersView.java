package ui.views;

import app.router.View;
import assets.Assets;
import ui.ViewPanel;

import javax.swing.*;
import java.awt.*;

@View(name="players")
public class PlayersView extends ViewPanel {

    public PlayersView() {
        setLayout(new FlowLayout());
    }

    public void initialize() {
        setBackground(Assets.Background.SunburstLogoMd);
    }

    @Override
    public void onUpdate() {
        System.out.println("Players got updated");
    }

    @Override
    public void onMount() {
        System.out.println("Players got mounted");
    }

}
