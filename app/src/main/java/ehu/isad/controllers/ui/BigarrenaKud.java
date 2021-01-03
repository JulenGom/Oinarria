package ehu.isad.controllers.ui;

import ehu.isad.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BigarrenaKud implements Initializable {

    private App main;

    public BigarrenaKud(App main) {
        this.main = main;
    }

    @FXML
    private TextField txt;

    @FXML
    private Button btn2;

    @FXML
    private Button btn1;

    @FXML
    void onClick(ActionEvent event) throws IOException {
        if(event.getSource()==btn1){
            main.mainKargatu();
        }
        else if(event.getSource()==btn2){
            txt.setText("CUCU!");
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
