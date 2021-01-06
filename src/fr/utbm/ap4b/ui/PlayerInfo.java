package fr.utbm.ap4b.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.utbm.ap4b.GameManager;
import fr.utbm.ap4b.model.CreditCard;
import fr.utbm.ap4b.model.DestinationGoalCard;
import fr.utbm.ap4b.utils.Resources;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class PlayerInfo implements Displayable {
	private GameManager GM;
	private Label PlayerName;
	private Label CreditList;
	private Label DestinationGoalList;
	private Label Color;
	private AnchorPane root;
	private VBox Player;
	
	public PlayerInfo(GameManager gM) {
		super();
		GM = gM;
		PlayerName = new Label("#PlayerName#");
		CreditList = new Label("#CreditList#");
		DestinationGoalList = new Label("#DestinationGoalList#");
		Color = new Label("#Color#");

		root = new AnchorPane();
		Player = new VBox();
		Player.getChildren().add(PlayerName);
		root.getChildren().add(CreditList);
		root.getChildren().add(DestinationGoalList);
		Player.getChildren().add(Color);
		root.getChildren().add(Player);
		
		//ResourceBundle bundle = ResourceBundle.getBundle(Resources.BUNDLEPATH);
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/fxml/player_info.fxml"), bundle);
        
		

		/**
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		**/
	}

	@Override
	public void start() {
		update();
	}

	@Override
	public Node getNode() {
		return root;
	}

	@Override
	public void update() {
		PlayerName.setText(GM.getCurrentPlayer().getPlayerName());
		CreditList.setText("GM.getCurrentPlayer().getCreditList()");
		DestinationGoalList.setText("GM.getCurrentPlayer().getDestinationGoalList()");
		Color.setText(GM.getCurrentPlayer().getColor());
	}

}
