package ehu.isad.model;

public class license {
    private String izena;


    @Override
    public String toString() {
        return "license{" +
                "izena='" + izena + '\'' +
                '}';
    }
    public license (String izena){this.izena = izena;}
}
