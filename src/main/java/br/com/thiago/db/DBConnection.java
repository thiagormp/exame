package br.com.thiago.db;

import java.sql.*;

/**
 * Created by thiago on 8/27/18.
 */
public class DBConnection {
    private java.sql.Connection connection;

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection("jdbc:mysql://"+Connection.host+"/"+Connection.database+"?" +
                            "user="+Connection.user+"&password="+Connection.password);
        }catch (Exception e){
            throw new RuntimeException("Erro ao se conectar. Erro: "+e.getMessage());
        }
    }

    public PreparedStatement executeSQL(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);
    }

    public void disconnect(){
        if(this.connection!=null){
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao desconectar. Erro: "+e.getMessage());
            }
            this.connection = null;
        }
    }
}
