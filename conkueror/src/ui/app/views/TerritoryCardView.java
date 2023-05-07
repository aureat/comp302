package ui.app.views;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import domain.card.TerritoryCard;
import domain.gamemap.TerritoryType;
import domain.gamemap.ContinentType;
import domain.card.CardType;
import domain.mapstate.MapState;


//Router eklenecek altun.
public class TerritoryCardView  extends JFrame {

    private ArrayList<TerritoryCard> territoryCards;
    private JPanel cardPanel;

    public TerritoryCardView() {
        // Initialize the JFrame
        super("Territory Cards");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create some sample territory cards
        territoryCards = new ArrayList<>();

        List<TerritoryType> territories = MapState.getInstance().getMap().getTerritories();
        for (TerritoryType territory : territories) {
            territoryCards.add(new TerritoryCard(territory.getName(), territory, territory.getContinent(), CardType.TERRITORY, "This is a description of " + territory.getName() + ".", true, 1));
        }

        //territoryCards.add(new TerritoryCard("Alaska", TerritoryType.ALASKA, ContinentType.NORTH_AMERICA, CardType.TERRITORY,  "This is a description of Alaska.", true, 2));
        //territoryCards.add(new TerritoryCard("Brazil", TerritoryType.BRAZIL, ContinentType.SOUTH_AMERICA, CardType.TERRITORY,  "This is a description of Brazil.", true, 3));
        //territoryCards.add(new TerritoryCard("China", TerritoryType.CHINA, ContinentType.ASIA, CardType.TERRITORY,  "This is a description of China.", true, 4));

        // Create a panel to hold the territory cards
        cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));

        // Add each territory card to the panel
        for (TerritoryCard territoryCard : territoryCards) {
            JPanel territoryCardPanel = new JPanel();
            territoryCardPanel.setLayout(new BorderLayout());

            JLabel cardLabel = new JLabel(territoryCard.getName());
            cardLabel.setHorizontalAlignment(JLabel.CENTER);
            territoryCardPanel.add(cardLabel, BorderLayout.CENTER);

            JLabel descriptionLabel = new JLabel(territoryCard.getDescription());
            descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
            territoryCardPanel.add(descriptionLabel, BorderLayout.SOUTH);

            JButton tradeButton = new JButton("Trade");
            tradeButton.setEnabled(territoryCard.canBeTraded());
            territoryCardPanel.add(tradeButton, BorderLayout.EAST);

            cardPanel.add(territoryCardPanel);
        }

        // Add the card panel to the JFrame
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new TerritoryCardView();
    }
}
