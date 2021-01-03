package ehu.isad.model;

import ehu.isad.utils.Utils;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Proba {
    private Image irudia;
    private String izena;
    private Integer zenb;
    private Boolean bool;

    public Proba(String izena, Integer zenb, Boolean bool) {
        String imagePath = Utils.lortuEzarpenak().getProperty("pathToImages")+".png";
        try {
            this.irudia = new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.izena = izena;
        this.zenb = zenb;
        this.bool = bool;
    }

    public Image getIrudia() {
        return irudia;
    }

    public String getIzena() {
        return izena;
    }

    public Integer getZenb() {
        return zenb;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setIrudia(Image irudia) {
        this.irudia = irudia;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setZenb(Integer zenb) {
        this.zenb = zenb;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return this.izena;
    }
}
