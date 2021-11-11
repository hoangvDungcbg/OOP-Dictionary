/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionaryuet;

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
public class EditController implements Initializable {
    @FXML
    private TextField newmeaning, newword, oldword,status;
    @FXML
    private Button back, edit;
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
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void edit(ActionEvent event) throws Exception{
        String s = oldword.getText();
        int index = DictionaryManagement.getIndex(s);
        if(index == -1){
            status.setText("WORD NOT FOUND!!!");
        } else {
            Dictionary.dict.get(index).setWord_target(newword.getText());
            Dictionary.dict.get(index).setWord_explain(newmeaning.getText());
            Dictionary.map.put(newword.getText(), newmeaning.getText());
            status.setText("SUCCESS!!!");
            DictionaryManagement.dictionaryExportToFile();
        }
    }
}
