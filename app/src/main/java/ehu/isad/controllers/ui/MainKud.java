package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.utils.Sarea;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;

import java.net.URL;
import java.util.ResourceBundle;

public class MainKud implements Initializable {
    private App main;

    public MainKud(App main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //TODO: ComboBox, taula

    private void thread(){
        Thread taskThread=new Thread(()->{
            //Egin beharrekoa

            Platform.runLater(()->{
                System.out.println("runlater");
            });
        });
        taskThread.start();
    }
}
