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

    public String URLtikIrakurri(long isbn){
        return this.zatitu(this.datuakLortu(isbn),isbn);
    }

    private String datuakLortu(long isbn){
        String lerroa = " ";
        URL openLibrary;

        try {
            openLibrary = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=details&format=json");
            URLConnection konexioa = openLibrary.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(konexioa.getInputStream()));
            lerroa = in.readLine();
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return lerroa;
    }

    private String zatitu(String lerroa, long isbn){
        String[] zatiak = lerroa.split("ISBN:" + isbn+ "\": ");
        lerroa = zatiak[1].substring(0, zatiak[1].length()-1);
        System.out.println(lerroa);
        return lerroa;
    }

    public void irudiaGorde(String url, String hFitxategia){
        BufferedImage image;
        try{
            URL Url =new URL(url);
            image = ImageIO.read(Url);
            ImageIO.write(image, "png", new File(Utils.lortuEzarpenak().getProperty("pathToImages")+hFitxategia+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
