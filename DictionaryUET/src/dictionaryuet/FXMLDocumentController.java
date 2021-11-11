/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionaryuet;
import java.io.*;
import com.sun.speech.freetts.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button,add1,edit1,remove1,speak;
    @FXML
    private Label label;
    @FXML
    private TextField searchbar;
    @FXML
    private TextArea textArea;
    @FXML
    private ListView<String> list;
    private static final String VOICENAME = "kevin16";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
            this.list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> searchbar.setText(newValue.trim()));
            this.list.getItems().addAll(Objects.requireNonNull(DictionaryManagement.dictionarySearcher(searchbar.getText())));
            searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            this.list.getItems().clear();
            this.list.getItems().addAll(Objects.requireNonNull(DictionaryManagement.dictionarySearcher(searchbar.getText())));
            
        });
    }    

    public void voice(ActionEvent event) throws Exception{
        Voice speech;
        VoiceManager vm = VoiceManager.getInstance();
        speech = vm.getVoice(VOICENAME);
        speech.allocate();
        try{
            speech.speak(searchbar.getText());
        } catch(Exception e){
            }
             }
    @FXML
    private void searchtheword()throws IOException {  
        functions();      
    }
    
    @FXML
    public void HandleMouseClick(MouseEvent event) {
        String select = list.getSelectionModel().getSelectedItem();
        textArea.setText(DictionaryManagement.dictionarybeta(select));
    }
    public void functions(){
        listview();
        searchbar();
        textArea.setText(DictionaryManagement.dictionarybeta(searchbar.getText()));
    }
    public void listview() {
        this.list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> searchbar.setText(newValue.trim()));
    }
    public void searchbar() {
            searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            this.list.getItems().clear();
            this.list.getItems().addAll(Objects.requireNonNull(DictionaryManagement.dictionarySearcher(searchbar.getText())));
            
        });
    }
    public void add(ActionEvent event) throws Exception {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene addscene1 = new Scene(root);
        Stage window = (Stage) add1.getScene().getWindow();
        window.setScene(addscene1);
        window.show();
    } catch(Exception e){
        System.out.println("Cant load");
    }
    }
    public void remove(ActionEvent event) throws Exception {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("remove.fxml"));
        Scene addscene1 = new Scene(root);
        Stage window = (Stage) remove1.getScene().getWindow();
        window.setScene(addscene1);
        window.show();
    } catch(Exception e){
        System.out.println("Cant load");
    }
    }
    public void edit(ActionEvent event) throws Exception{
        try {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Scene addscene1 = new Scene(root);
        Stage window = (Stage) edit1.getScene().getWindow();
        window.setScene(addscene1);
        window.show();
    } catch(Exception e){
        System.out.println("Cant load");
    }
    }
    @FXML
    public void useAPI(ActionEvent event) throws Exception{
        textArea.setText(GoogleAPI.translate(searchbar.getText()));
    }
    
    
}
