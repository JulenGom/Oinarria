package ehu.isad.controllers.db;

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

    public List<String> lortuRS(){
        String query = "select izena, bandera from taula"; //WHERE urtea=currentYear()
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String izena = rs.getString("izena");
                String bandera = rs.getString("bandera");
                System.out.println(izena + ":" + bandera);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }

    public void insertUpdate(){
        String query = "INSERT INTO taula VALUES()"; //UPDATE taula SET blablabla
        DBKudeatzaileSQLite dbKudeatzaile = DBKudeatzaileSQLite.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }
}
