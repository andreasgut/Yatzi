package sample;

import database.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionHighscore {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ObservableList<Highscore> resultTable = FXCollections.observableArrayList();
    TableView<Highscore> resultTableV;


    public ConnectionHighscore(){
        try {
            this.connection = dbConnection.getConnection();

            //funktioniert
        }

        catch (SQLException ex){
            ex.printStackTrace();
        }

        if(this.connection == null){
            System.exit(1);

        }


    }

    public boolean isDatabaseConnected(){
        return this.connection !=null;
        //funktioniert

    }

    public ObservableList<Highscore> getHighscore(){


        try {
        preparedStatement = this.connection.prepareStatement("SELECT vorname, nachname, datum, score, RANK() OVER(ORDER BY score DESC) AS Rang FROM highscore LIMIT 3");
        //problem bei abfrage: score ist ein string, darum kann er nix vergleichen, sonst alles ok
        resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);}
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fehler bei Datenbank");
        }

        resultTable.clear();




        try {
            while (resultSet.next()) {

                Highscore highscore = new Highscore(resultSet.getString("Rang"), resultSet.getString("Vorname"),
                        resultSet.getString("Nachname"),
                        resultSet.getString("Score"), resultSet.getString("Datum"));

                resultTable.add(highscore);
            }

        }
        catch (SQLException ex ){
            ex.printStackTrace();
        }

    return resultTable;
    }

    public void enter(){

    }


    public boolean isLogin(String user, String pass, String opt) throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login WHERE username = ? AND password = ? AND division = ?";

        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            pr.setString(3, opt);

            rs = pr.executeQuery();

            boolean boolean1;

            if(rs.next()) {
                return true;
            }
            return false;

        }
        catch (SQLException ex){
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }
    }
}
