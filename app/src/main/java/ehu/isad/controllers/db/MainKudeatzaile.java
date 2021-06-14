package ehu.isad.controllers.db;

import ehu.isad.model.license;
import ehu.isad.model.proiektuak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainKudeatzaile {
    private static final MainKudeatzaile instance = new MainKudeatzaile();

    public static MainKudeatzaile getInstance() {
        return instance;
    }

    private MainKudeatzaile() { }

    public List<proiektuak> lortuProiektuak(){
        String query = "select full_name, description, license, open_issues from repos";
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<proiektuak> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String izena = rs.getString("full_name");
                String description = rs.getString("description");
                String license = rs.getString("license");
                Integer open_issues = rs.getInt("open_issues");
                proiektuak p = new proiektuak();
                p.setIzena(izena);
                p.setDescription(description);
                p.setLicense(license);
                p.setIssues(open_issues);
                emaitza.add(p);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
    public boolean datuBaseanDago(String izena){

        String query = "select * from repos where full_name='"+izena+"'";
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        boolean emaitza = false;
        try {
            if (rs.next()){
                emaitza=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emaitza;
    }

    public void insertUpdate(){
        String query = "INSERT INTO taula VALUES()"; //UPDATE taula SET blablabla
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }

    public void proiektuaGorde(proiektuak p) {
        String izena = p.getFull_name();
        String license = p.getLicense().getLicense();
        String description = p.getDescription();
        Integer issues = p.getOpen_issues();
        String query = "INSERT INTO repos VALUES('"+izena+"','"+license+"','"+description+"','"+issues+"')";
        System.out.println(query);
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }
}
