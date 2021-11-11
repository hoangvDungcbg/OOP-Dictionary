/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionaryuet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class RemoveController implements Initializable {
    @FXML
    private TextField remove,status;
    @FXML
    private Button back,rem;
    
    /**
     * Initializes the controller class.
     */
    public void returntomain(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene addscene = new Scene(root);
        
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(addscene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void removeword() throws IOException{
        String s=remove.getText();
        int x=DictionaryManagement.getIndex(s);
        if(x!=-1){
        DictionaryManagement.remove(remove.getText());
        status.setText("Success!!!");
        } else{
            status.setText("Failed!!!");
        }
        DictionaryManagement.dictionaryExportToFile();
    }
}
