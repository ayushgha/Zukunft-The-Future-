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

/**
 * FXML Controller class
 *
 * @author Ayush Ghanekar
 */
public class StartupController implements Initializable {

      
    public Button btn1;
    public Button btn2;
    public Button btn3;
    /**
     * Initializes the controller class.
     */
    public void handleButtonAction(ActionEvent event) throws IOException{
     Parent startup_page = null;
     Parent signup_page=null;
     Parent aboutus_page=null;
     Stage stage; 
     
     if(event.getSource()==btn1){
        //get reference to the button's stage         
        stage=(Stage) btn1.getScene().getWindow();
        //load up OTHER FXML document
  startup_page = FXMLLoader.load(getClass().getResource("login.fxml"));
    Scene scene = new Scene(startup_page);
      stage.setScene(scene);
      stage.show();
      }
     else if(event.getSource()==btn2){
       stage=(Stage) btn2.getScene().getWindow();
  signup_page = FXMLLoader.load(getClass().getResource("signup.fxml"));
  Scene scene = new Scene(signup_page);
      stage.setScene(scene);
      stage.show();
      }
    
    else if(event.getSource()==btn3){
       stage=(Stage) btn3.getScene().getWindow();
  aboutus_page = FXMLLoader.load(getClass().getResource("aboutus.fxml"));
  Scene scene = new Scene(aboutus_page);
      stage.setScene(scene);
      stage.show();
      }
     //create a new scene with root and set the stage
     
    }

  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
