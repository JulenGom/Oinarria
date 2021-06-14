package ehu.isad.model;

import com.google.gson.Gson;
import ehu.isad.utils.Sarea;

public class proiektuak {

    private String full_name;
    private String description;
    private license license;
    private Integer open_issues;


    public proiektuak(){}
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
        String lerroa = s.URLtikIrakurri(izena);

        Gson gson = new Gson();
        proiektuak p = gson.fromJson(lerroa,proiektuak.class);
        p.full_name = izena;
        return p;
    }

}

