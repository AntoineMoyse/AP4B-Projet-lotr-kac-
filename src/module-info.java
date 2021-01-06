module ap4b {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires JavaFXSmartGraph;
	
	exports fr.utbm.ap4b to javafx.graphics;
}