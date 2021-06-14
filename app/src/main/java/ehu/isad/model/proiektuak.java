package ehu.isad.model;

import com.google.gson.Gson;
import ehu.isad.utils.Sarea;

public class proiektuak {

    private String full_name;
    private String description;
    private license license;
    private Integer open_issues;


    public String getFull_name() {
        return full_name;
    }

    public proiektuak(){
    }
    public license getDetails() {
        return license;
    }


    @Override
    public String toString() {
        return "proiektuak{" +
                "full_name='" + full_name + '\'' +
                ", description='" + description + '\'' +
                ", license=" + license +
                ", open_issues=" + open_issues +
                '}';
    }

    public license getLicense() {
        return license;
    }


    public proiektuak proiektuakLortu(String izena)  {

        Sarea s = new Sarea();
        String lerroa = s.URLtikIrakurri(izena);
        System.out.println(lerroa);

        Gson gson = new Gson();
        proiektuak p = gson.fromJson(lerroa,proiektuak.class);
        p.full_name = izena;
        return p;
    }
    public void setZenb(Integer zenb){ this.open_issues=zenb;}

    public String getDescription() {
        return description;
    }



    public Integer getOpen_issues() {
        return open_issues;
    }

    public void setIzena(String izena) {
        this.full_name=izena;

    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setIssues(Integer open_issues) {
        this.open_issues=open_issues;
    }

    public void setLicense(String license) {
        this.license=new license(license);
    }
}

