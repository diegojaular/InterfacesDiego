package ejercicio1;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainLayouts_Controles extends Application {
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLayouts_Controles.class.getResource("MainLayouts_Controles.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio sobre layouts y controles");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
