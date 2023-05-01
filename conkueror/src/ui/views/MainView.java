package ui.views;

import app.router.View;
import assets.Assets;
import ui.ViewPanel;

import javax.swing.*;
import java.awt.*;

@View(name="main", isDefault=true)
public class MainView extends ViewPanel {

    public MainView() {
        setLayout(new FlowLayout());
    }

    public void initialize() {
        setBackground(Assets.Background.Main);
        System.out.println(getRouter().getContainer().getWidth());
        System.out.println(getRouter().getContainer().getHeight());
    }

    @Override
    public void onUpdate() {
        System.out.println("Main got updated");
    }

    @Override
    public void onMount() {
        System.out.println("Main got mounted");
    }

}
