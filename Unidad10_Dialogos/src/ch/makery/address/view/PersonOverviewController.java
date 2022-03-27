package ch.makery.address.view;

import ch.makery.address.Main;
import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

	// TODO Versión con map
	/*@FXML
    private TableView<Map<String,Object>> personTable;
    @FXML
    private TableColumn<Map<String,Object>, String> firstNameColumn;
    @FXML
    private TableColumn<Map<String,Object>, String> lastNameColumn;*/
	
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Referencia a la aplicación principal
    private Main mainApp;
    
    /**
     * Método para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {
    	// Se inicializan las columnas firstName y lastName
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	
      	// TODO Versión con map 
    	// Se crea un objecto que herede de ObservableValue
    	/*firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("firstName").toString()));
    	lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("lastName").toString()));*/   
    }

    /**
     * Referencia a la aplicación principal
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(this.mainApp.getPersonData());
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    
    /**
     * Se llama cuando el usuario hace click en el botón nuevo 
     * Se añade una nueva persona a la tabla
     */
    @FXML
    private void handleNewPerson(ActionEvent event) {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }       
    }    
}