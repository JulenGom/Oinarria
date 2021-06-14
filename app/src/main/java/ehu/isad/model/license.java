package ehu.isad.model;

public class license {
    private String name;


    @Override
    public String toString() {
        return "license{" +
                "name='" + name + '\'' +
                '}';
    }
    public license (String izena){this.name = izena;}
    public String getLicense(){return this.name;}
    public void setLicense(String izena){
        this.name = izena;
    }

}
