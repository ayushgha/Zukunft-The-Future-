/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextmove;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ayush Ghanekar
 */
public class SignupController implements Initializable {
Stage stage;

     @FXML
    private JFXTextField UserID;

    @FXML
    private JFXTextField Last;

    @FXML
    private JFXTextField Password;

    @FXML
    private JFXDatePicker DOB;

    @FXML
    private JFXButton bt1;

    @FXML
    private JFXButton bt2;



    public void handleButtonAction(ActionEvent event) throws Exception{
   
        System.out.println("Ayush");
           
      String UID=UserID.getText();
     String pass=Password.getText();
    //  String date=DOB.getText();
     String lastname=Last.getText();
     System.out.println(""+UID+pass);
     InsertUser ob= new InsertUser();
    ob.insertTable(lastname, UID, pass);
     //System.out.println("values stored in database");
     //InsertUser object =new InsertUser();
     //object.insertTable(lastname,UID,pass,date);
     if(event.getSource()==bt1){
         
        //get reference to the button's stage         
        stage=(Stage) bt1.getScene().getWindow();
         //load up OTHER FXML document
         Parent Upload = FXMLLoader.load(getClass().getResource("login.fxml"));
    Scene scene = new Scene(Upload);
      stage.setScene(scene);
      stage.show();
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
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
