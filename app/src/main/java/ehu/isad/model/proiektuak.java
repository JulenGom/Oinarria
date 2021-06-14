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

    public proiektuak(String full_name, license license, String description, Integer open_issues){
        this.full_name=full_name;
        this.license = license;
        this.description = description;
        this.open_issues = open_issues;
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

    public proiektuak proiektuakLortu(String izena)  {

        Sarea s = new Sarea();
        System.out.println(izena);
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

    public license getLicense() {
        return license;
    }

    public Integer getOpen_issues() {
        return open_issues;
    }
}

