package ehu.isad.controllers.db;

public class DBKudeatzaileMongo {
    //singleton
    private static DBKudeatzaileMongo mongoKud = new DBKudeatzaileMongo();

    private DBKudeatzaileMongo() { }

    public static DBKudeatzaileMongo getInstance() {
        return mongoKud;
    }

   //TODO: MONGO
}
