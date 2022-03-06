package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	// Listado de personas de la aplicación
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	// TODO Alternativa con maps para incluir el listado de personas
	//private ObservableList<Map<String,Object>> mapData = FXCollections.observableArrayList();
	
	public Main() {
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
		
		// TODO Probamos el map con solo dos ítems, ya que como se puede observar requiere más líneas de código que la altenrativa anterior
		/*Map<String, Object> item1 = new HashMap<>();
		item1.put("firstName", "Hans");
		item1.put("lastName" , "Muster");

		mapData.add(item1);

		Map<String, Object> item2 = new HashMap<>();
		item2.put("firstName", "Ruth");
		item2.put("lastName" , "Mueller");

		mapData.add(item2);*/
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Inicializa el diseño de la pantalla principal.
	 */
	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el diseño de PersonOverview dentro de la pantalla principal
	 */
	public void showPersonOverview() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(personOverview);
			
			// Damos al controlador acceso a la aplicaicón principal
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Método get para lista de personas
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}

	/**
	 * TODO
	 * Método get para obtener el listado de personas (versión mapa)
	 * @return
	 */
	/*public ObservableList<Map<String,Object>> getMapData() {
		return mapData;
	}*/
	
	
}