package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public AnchorPane rootLayout;
	public Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		initLayout();
	}
	
	public void initLayout() {
		try {
			primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));		
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
