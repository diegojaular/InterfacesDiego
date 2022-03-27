package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	// Listado de personas de la aplicaci�n
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
		
		// TODO Probamos el map con solo dos �tems, ya que como se puede observar requiere m�s l�neas de c�digo que la altenrativa anterior
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
		
		 // Icono de la aplicaci�n
	    this.primaryStage.getIcons().add(new Image("file:img/agenda.png"));

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Inicializa el dise�o de la pantalla principal.
	 */
	public void initRootLayout() {
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el dise�o de PersonOverview dentro de la pantalla principal
	 */
	public void showPersonOverview() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(personOverview);
			
			// Damos al controlador acceso a la aplicaic�n principal
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Se abre un di�logo para editar los detalles de una persona
	 * Si el usuario hace click en OK, se guarda y se devuelve true
	 *  
	 * @param person el objeto persona que va a ser editado
	 * @return true si el usuario hace click en OK y est� todo correcto, false en caso contrario.
	 */
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // Cargamos el dise�o del di�logo desde un XML
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Se crea un nuevo Stage para mostrar el di�logo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Crear o editar persona");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Carga la persona en el controlador
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // Muestra el di�logo y no contin�a el c�digo hasta que lo cierra el usuario
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
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
	 * M�todo get para lista de personas
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}

	/**
	 * TODO
	 * M�todo get para obtener el listado de personas (versi�n mapa)
	 * @return
	 */
	/*public ObservableList<Map<String,Object>> getMapData() {
		return mapData;
	}*/
	
	
}