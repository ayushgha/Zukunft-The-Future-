/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextmove;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ayush Ghanekar
 */

public class AboutusController implements Initializable {
public Button abt;


public void handleButtonAction1(ActionEvent event) throws IOException{
  
       // if(event.getText())
     Stage stage; 
     
     if(event.getSource()==abt){

             stage=(Stage) abt.getScene().getWindow();
         //load up OTHER FXML document
         Parent upload = FXMLLoader.load(getClass().getResource("startup.fxml"));
    Scene scene = new Scene((Parent) upload);
      stage.setScene(scene);
      stage.show();
     }
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
