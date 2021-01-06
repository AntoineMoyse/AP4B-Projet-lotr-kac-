package fr.utbm.ap4b;

import java.util.ArrayList;

import fr.utbm.ap4b.ui.CardDraw;
import fr.utbm.ap4b.ui.Displayable;
import fr.utbm.ap4b.ui.GameInfo;
import fr.utbm.ap4b.ui.GraphUI;
import fr.utbm.ap4b.ui.PlayerInfo;
import fr.utbm.ap4b.utils.Resources;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayManager extends Application {
	public static Stage mainStage; //fen�tre principale
	private GameManager GM;
	private ArrayList<Displayable> ComponentList;
	
	public static void main(String[] args) {
		System.out.println("Main methode - Thread: " + Thread.currentThread().getName());
		launch(args); //lancement de l'application
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init methode - Thread: " + Thread.currentThread().getName());
		GM = new GameManager();
		//dans cette partie on g�re tout ce qui doit �tre fait avant d'afficher la fen�tre.
	}
	
	@Override
	public void start(Stage NewStage) throws Exception {
		System.out.println("Start methode - Thread: " + Thread.currentThread().getName());
		//dans cette partie on s'occupe de g�n�rer la fen�tre
		
		mainStage = NewStage; //l'objet qui contient le fen�tre nous est donn� par la superclass
		mainStage.setTitle(Resources.getStringRessources("title"));//on red�fini son titre
		mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/img/ticketToUTBMbiais.png")));//on d�fini l'icone
		mainStage.setResizable(true);//on d�fini quelques propri�t�s
		mainStage.setMinHeight(400);
		mainStage.setMinWidth(500);
		
		//create the graph
		GraphUI graphUI = new GraphUI(GM);
		CardDraw CD = new CardDraw(GM);
		PlayerInfo PI = new PlayerInfo(GM);
		GameInfo GI = new GameInfo(GM);

		ComponentList = new ArrayList<Displayable>();
		ComponentList.add(graphUI);
		ComponentList.add(CD);
		ComponentList.add(PI);
		ComponentList.add(GI);
		
		BorderPane root = new BorderPane();
		root.setCenter(graphUI.getNode());
		root.setBottom(PI.getNode());
		root.setRight(CD.getNode());
		root.setTop(GI.getNode());
		Scene scene = new Scene(root, 1000, 600);
		
		mainStage.setScene(scene);
		mainStage.show();//on affiche la fen�tre
		mainStage.centerOnScreen();//on initialise quelques propri�t�s
		mainStage.setAlwaysOnTop(false);
		
		for (Displayable Component : ComponentList) {
			Component.start();
		}
	}
	
	public void updateAll() {
		for (Displayable Component : ComponentList) {
			Component.update();
		}
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop methode - Thread: " + Thread.currentThread().getName());
		//lorsque l'application est quitt�
	}
}
