package fr.utbm.ap4b.ui;

import fr.utbm.ap4b.GameManager;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class GameInfo implements Displayable{
	private GameManager GM;
	private Label Round;
	private Label Player;
	private Label Points;
	private HBox Root;
	
	public GameInfo(GameManager gM) {
		super();
		GM = gM;
		Round = new Label("#Nème tour#");
		
		Root = new HBox();
		Root.getChildren().add(Round);
	}

	@Override
	public void start() {
		update();
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return Root;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (GM.getRound() == 1) {
			Round.setText("1er tours");
		} else {
			Round.setText(GM.getRound() + "ème tours");
		}
		
	}

}
