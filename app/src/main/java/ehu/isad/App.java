
package ehu.isad;

import ehu.isad.controllers.ui.BigarrenaKud;
import ehu.isad.controllers.ui.MainKud;
import ehu.isad.utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application{

    private Parent AppUI;
    private Stage stage;
    private Scene sceneMain;

    private MainKud mainKud;
    private BigarrenaKud bigarrenaKud;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        this.mainKargatu();
    }


    private void ikonoaJarri(String izena){
        String imagePath = Utils.lortuEzarpenak().getProperty("pathToImages")+".png";
        try {
            if(stage.getIcons().size()>0){
                stage.getIcons().remove(0);
            }
            stage.getIcons().add(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void pantailakKargatu(String load) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+load+".fxml"));
        mainKud = new MainKud(this);
        bigarrenaKud = new BigarrenaKud(this);

        Callback<Class<?>, Object> controllerFactory = type -> {
            if (type == MainKud.class) {
                return mainKud ;
            }
            else if(type == BigarrenaKud.class){
                return bigarrenaKud;
            }
            else {// default behavior for controllerFactory:
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc); // fatal, just bail...
                }
            }
        };

        loader.setControllerFactory(controllerFactory);
        AppUI = (Parent) loader.load();
        sceneMain = new Scene(AppUI);
    }

    public void bigarrenaKargatu() throws IOException {
        this.pantailakKargatu("bigarrena");
        stage.setTitle("Bigarren pantaila");
        this.ikonoaJarri("");
        stage.setScene(sceneMain);
        stage.show();
    }

    public void mainKargatu() throws IOException {
        this.pantailakKargatu("main");
        stage.setTitle("App Oinarria");
        this.ikonoaJarri("");
        stage.setScene(sceneMain);
        stage.show();
    }
}
