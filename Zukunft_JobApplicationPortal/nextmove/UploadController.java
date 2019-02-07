/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextmove;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
/**
 * FXML Controller class
 *
 * @author Ayush Ghanekar
 */
public class UploadController implements Initializable {
    @FXML private WebView webView;
    private WebEngine engine;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        engine = webView.getEngine();
        
    }    
    public void btn1(ActionEvent event){
        engine.load("file:///C:/Users/Ayush%20Ghanekar/Desktop/let.html");
        
    }
    
}
