package ui.views;

import app.router.View;
import ui.ViewPanel;

import javax.swing.*;

@View(name="login", isDefault=true)
public class LoginView extends ViewPanel {

    public LoginView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Login View"));
    }

}
