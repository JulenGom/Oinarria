package ehu.isad.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Sarea {

    public Sarea(){}

    public String URLtikIrakurri(String url){
        return this.datuakLortu(url);
    }

    private String zatitu(String datuakLortu, String url) {
        String[] zatiak = datuakLortu.split("{ id:"+ "}");
        String prueba = zatiak[1].substring(0, zatiak[1].length()-1);
        return datuakLortu;
    }

    private String datuakLortu(String izena){
        String lerroa = " ";
        URL github;

        try {
            github = new URL("https://api.github.com/repos/"+izena);
            URLConnection konexioa = github.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(konexioa.getInputStream()));
            lerroa = in.readLine();

            System.out.println(lerroa);
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return lerroa;
    }

//    private String zatitu(String lerroa, long isbn){
//        String[] zatiak = lerroa.split("ISBN:" + isbn+ "\": ");
//        lerroa = zatiak[1].substring(0, zatiak[1].length()-1);
//        System.out.println(lerroa);
//        return lerroa;
//    }

}


