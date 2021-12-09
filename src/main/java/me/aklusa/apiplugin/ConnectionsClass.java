package me.aklusa.apiplugin;

import java.sql.*;

public class ConnectionsClass {


    private String host = "verification.hyperlink-network.com";
    private String port = "3306";
    private String user = "tester";
    private String password = "xHhg5dczEWyy2t@";
    private String dbname = "licenses";
    private ResultSet resultSetone = null;
    private ResultSet resultSettwo = null;
    private ResultSet rsec = null;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    String tempuser = "";
    String dbpass = "";
    int apikey_id = 0;
    String lickey = "";
    String sl = "";

    public boolean isActivated(String apikey, String licensekey) throws SQLException {

        boolean activationStatus = false;


        try {
            connect = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbname + "?" + "user=" + user + "&password=" + password);
            statement = connect.createStatement();

            resultSetone = statement.executeQuery("select id from api_keys where apikey='"+apikey+"';");

            while (resultSetone.next()) {
                apikey_id = resultSetone.getInt("id");
            }

            resultSettwo = statement.executeQuery("select license_key from license_keys where api_key_id="+apikey_id+"&& license_key='" + licensekey + "';");

            while (resultSettwo.next()) {
                sl = resultSettwo.getString("license_key");
            }
            if(sl.length() > 0) {
                activationStatus = true;
            }

        } catch (Exception e) {
            System.out.println("Failure");
            throw e;

        } finally {

        }

        return activationStatus;
    }



}
