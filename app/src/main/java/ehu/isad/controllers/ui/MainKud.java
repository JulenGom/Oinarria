package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.model.Proba;
import ehu.isad.utils.Sarea;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainKud implements Initializable {
    private App main;

    private List<Proba> proba;

    public MainKud(App main) {
        this.main = main;
    }

    @FXML
    private ComboBox<Proba> cmbx;

    @FXML
    private TableView<Proba> tbl;

    @FXML
    private TableColumn<Proba, Image> clmn1;

    @FXML
    private TableColumn<Proba, String> clmn2;

    @FXML
    private TableColumn<Proba, Integer> clmn3;

    @FXML
    private Button btn;

    @FXML
    void onClick(ActionEvent event) throws IOException {
       main.bigarrenaKargatu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboBoxHasieratu();
        this.taulaHasieratu();
    }


    private void comboBoxHasieratu(){
        List<Proba> datuLista = new ArrayList<>();
        datuLista.add(new Proba("Proba1",1));
        datuLista.add(new Proba("Proba2",2));
        ObservableList<Proba> datuak = FXCollections.observableArrayList(datuLista);
        cmbx.setItems(datuak);
    }


    private void taulaHasieratu(){
        tbl.setEditable(true);
        clmn2.setCellValueFactory(new PropertyValueFactory<>("Izena"));
        clmn3.setCellValueFactory(new PropertyValueFactory<>("Zenb"));
        clmn3.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //Datu bat aldatzea
        clmn3.setOnEditCommit(
                t->{
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setZenb(t.getNewValue());
        });

        //Irudia jarri
        clmn1.setCellValueFactory(new PropertyValueFactory<>("Irudia"));
        clmn1.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(15);
                    imageview.setFitWidth(20);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        //add your data to the table here.
        datuaKargatu();


        //Proba1 izena badu ez utzi editatzen
        Callback<TableColumn<Proba, Integer>, TableCell<Proba, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.<Proba, Integer>forTableColumn(new IntegerStringConverter());

        clmn3.setCellFactory(col -> {
            TableCell<Proba, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getIzena().equals("Proba1")) {
                        cell.setEditable(false);
                    }else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell ;
        });
    }


    private void datuaKargatu(){
        proba = new ArrayList<>();
        proba.add(new Proba("Proba1",1));
        proba.add(new Proba("Proba2",2));
        proba.add(new Proba("Proba3",3));
        proba.add(new Proba("Proba1",4));
        ObservableList<Proba> probak = FXCollections.observableArrayList(proba);
        tbl.setItems(probak);
    }


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
