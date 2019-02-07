/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextmove;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.stage.StageStyle.UNDECORATED;

/**
 *
 * @author Ayush Ghanekar
 */
public class NextMove extends Application {
    
   public void start(Stage stage) throws Exception {
     //  System.out.println("TILL HERE7");
        Parent root=null;
        root= FXMLLoader.load(getClass().getResource("startup.fxml"));
        //System.out.println(root);
       // System.out.println("TILL HERE1");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(UNDECORATED);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
        JobApplication job = new JobApplication();
	job.getJob("new.docx");
    }
    
}
