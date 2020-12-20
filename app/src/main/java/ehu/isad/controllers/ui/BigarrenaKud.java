package ehu.isad.controllers.ui;

import ehu.isad.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BigarrenaKud implements Initializable {

    private App main;

    public BigarrenaKud(App main) {
        this.main = main;
    }

    @FXML
    void onClick(ActionEvent event) throws IOException {
        main.mainKargatu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
