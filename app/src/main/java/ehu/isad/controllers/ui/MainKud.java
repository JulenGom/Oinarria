package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.controllers.db.MainKudeatzaile;
import ehu.isad.model.Proba;
import ehu.isad.model.proiektuak;
import ehu.isad.utils.Sarea;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainKud implements Initializable {
    private App main;

    private List<proiektuak> proiektuak;

    public MainKud(App main) {
        this.main = main;
    }

    @FXML
    private TableView<proiektuak> tbl;

    @FXML
    private TableColumn<proiektuak, String> tblfn;

    @FXML
    private TableColumn<proiektuak, String> tblic;

    @FXML
    private TableColumn<proiektuak, String> tbldesc;

    @FXML
    private TableColumn<proiektuak, Integer> tblop;

    @FXML
    private Button btn;

    @FXML
    private TextField text;

    @FXML
    private Text mezua;

    @FXML
    void onClick(ActionEvent event) throws IOException {
       //Check botoia sakatu
        //Datuak taulara gehitu
        if(!text.getText().equals("")){
            String izena = text.getText();
            System.out.println(izena);
            Kargatu(izena);
        }

    }

    private void Kargatu(String izena) {
        boolean dago = MainKudeatzaile.getInstance().datuBaseanDago(izena);
        proiektuak p = null;
        if(dago==true){
            mezua.setText("Datubasean zegoen");
            mezua.setVisible(true);
        }else{
            p = p.proiektuakLortu(izena);
           MainKudeatzaile.getInstance().proiektuaGorde(p);
           ObservableList<proiektuak> proiektuak = FXCollections.observableArrayList(p);
            tbl.setItems(proiektuak);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.taulaHasieratu();
    }

    private void taulaHasieratu(){
        mezua.setVisible(false);
        tbl.setEditable(true);
        tblfn.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        tblic.setCellValueFactory(new PropertyValueFactory<>("license"));
        tbldesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tblop.setCellValueFactory(new PropertyValueFactory<>("open_issues"));


        //Datu bat aldatzea
        tblop.setOnEditCommit(
                t->{
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setZenb(t.getNewValue());
        });

        //add your data to the table here.
        datuaKargatu();
    }


    private void datuaKargatu(){
        List<proiektuak> proiektu = MainKudeatzaile.getInstance().lortuProiektuak();
        ObservableList<proiektuak> proiektuak = FXCollections.observableArrayList(proiektu);
        tbl.setItems(proiektuak);
    }

}

