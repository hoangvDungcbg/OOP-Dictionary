/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionaryuet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class AddController implements Initializable {
    
    
    public void returntomain(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene addscene = new Scene(root);
        
        Stage window = (Stage) cancel.getScene().getWindow();
        window.setScene(addscene);
        window.show();
    }
    
    @FXML
    private TextField enter,status;
    @FXML
    private TextField enter1;
    @FXML
    private Button add,cancel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void addword()throws IOException{
        String s = enter.getText();
        String ss = enter1.getText();
        int x = DictionaryManagement.getIndex(s);
        if(x==-1){
        DictionaryManagement.add(s, ss);
        status.setText("SUCCESS!");
    } else{
            status.setText("WORD EXISTED!!!");
        }
    }
}
