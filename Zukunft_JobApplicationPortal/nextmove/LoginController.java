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
import javafx.scene.control.Alert;
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

public class LoginController implements Initializable {

public Button bt1;
public Button bt2;
@FXML private TextField UserID;
@FXML private TextField Password;
String p="ayush";
    private Object upload;

    
    public void handleButtonAction(ActionEvent event) throws IOException{
  
       // if(event.getText())
     Stage stage; 
     //System.out.println("you have entered "+UserID.getText()+ " and "+Password.getText());
     if(event.getSource()==bt1){
           
       Retreive ob= new Retreive();
       ob.retreiveLogin();
       for(int i=0;ob.Username!=null;i++) {
        if(UserID.getText().equals(ob.Username[i])==true && Password.getText().equals(ob.Password[i])==true)
        {  
            
        //get reference to the button's stage         
        stage=(Stage) bt1.getScene().getWindow();
         //load up OTHER FXML document
         Parent upload = FXMLLoader.load(getClass().getResource("upload.fxml"));
    Scene scene = new Scene((Parent) upload);
      stage.setScene(scene);
      stage.show();
      break;
        }
       }
     }
         
      else if(event.getSource()==bt2){
         
        //get reference to the button's stage         
        stage=(Stage) bt2.getScene().getWindow();
        //load up OTHER FXML document
  Parent login_page = FXMLLoader.load(getClass().getResource("startup.fxml"));
    Scene scene = new Scene(login_page);
      stage.setScene(scene);
      stage.show();
      }
    
    
    else
     {
         stage=(Stage) bt2.getScene().getWindow();
        //load up OTHER FXML document
  Parent login_page = FXMLLoader.load(getClass().getResource("startup.fxml"));
    Scene scene = new Scene(login_page);
      stage.setScene(scene);
      stage.show();  
     }
}
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
