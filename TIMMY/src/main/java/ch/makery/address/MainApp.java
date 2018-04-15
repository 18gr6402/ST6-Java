/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.makery.address;


import ch.makery.address.model.Person;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Steff
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private java.sql.Connection con;
    DatabaseOperation myDBClass = new DatabaseOperation();
    
    public MainApp() {
        // Add some sample data
        //personData.add(new Person("Steffen", "Jensen"));
        

    }
    
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        con = myDBClass.connect();
        
        buildData();
        
        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    
    private void buildData(){
        try{
            String SQL = "Select FirstName, LastName, Street, City, ZIP, birthday from PERSON Order By LastName";
            
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                Person p = new Person();
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setBirthday(rs.getDate("birthday").toLocalDate());
                p.setStreet(rs.getString("Street"));
                p.setCity(rs.getString("City"));
                
                try {
                    p.setPostalCode(Integer.parseInt(rs.getString("ZIP")));
                } catch (NumberFormatException nfe){
                    System.out.println("Error on formatting ZIP code to an integer");
                }
                personData.add(p);
            }
            
            for (Person person : personData) {
                person.firstNameProperty().addListener((ov, oldValue, newValue) ->{
                System.out.println("Old value: "+oldValue);
                System.out.println("New value: "+newValue);
                });
            }
            }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
            }
    }
    
    public void insertPersonData(Person p){
        try{
            java.sql.Date date = java.sql.Date.valueOf(p.getBirthday());
            
            String SQL = "INSERT INTO PERSON ( FirstName, LastName, Street, City, ZIP, birthday) VALUES ("
                    + "'" + p.getFirstName() + "',"
                    + "'" + p.getLastName() + "',"
                    + "'" + p.getStreet() + "',"
                    + "'" + p.getCity() + "',"
                    + "'" + p.getPostalCode() + "',"
                    + "'" + date + "')";
            
            int rows = con.createStatement().executeUpdate(SQL, 1);
            if (rows > 0)
                System.out.println("Succes!");
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Fejl ved indsætning af data");
        }
    }
    
    public void deletePersonData(Person p){
        try{
            String SQL = "DELETE FROM PERSON WHERE FirstName = '" + p.getFirstName() + "' AND LastName = '" + p.getLastName()+"'";
            
            int rows = con.createStatement().executeUpdate(SQL, 1);
            if (rows > 0)
                System.out.println("Slettet!");
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Fejl ved slet");
        }
    }
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(MainApp.class.getClassLoader().getResource("fxml/RootLayout.fxml"));
            //loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("fxml/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    /**
 * Opens a dialog to edit details for the specified person. If the user
 * clicks OK, the changes are saved into the provided person object and true
 * is returned.
 * 
 * @param person the person object to be edited
 * @return true if the user clicked OK, false otherwise.
 */
    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("fxml/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Rediger person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
