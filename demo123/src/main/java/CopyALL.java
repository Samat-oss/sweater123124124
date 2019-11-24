


import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.*;

public class CopyALL {

    private ConnectOne connectOne;
    private ConnectTwo connectTwo;

    public void all() throws SQLException, IOException {

//        String select="SELECT *FROM table_name2";
//
//        connectOne=new ConnectOne();
//Connection connection=connectOne.connect();
//Statement statement = connection.createStatement();
//return statement.executeQuery(select);

        connectOne = new ConnectOne();
        connectTwo = new ConnectTwo();
        Statement statement;
        Statement statement1;
        ResultSet resultSet;
        Connection connection;
        Connection connection1;

        connection = connectOne.connect();

        statement = connection.createStatement();

        resultSet = statement
                . executeQuery("SELECT *FROM postgres.public.table_name2");

        connection1 = connectTwo
                .connect();

        statement1 = connection1
                . createStatement();

        String sql = "INSERT INTO postgres2.public.table_name  (id,column_2,column_3,column_4,column_5)"
                + "VALUES(?,?,?,?,?);";

        PreparedStatement preparedStatement = connection1
                .prepareStatement(sql);
try {
    while (resultSet.next()) {
        preparedStatement
                .setInt(1, resultSet.getInt(1));
        preparedStatement
                .setInt(2, resultSet.getInt(2));
        preparedStatement
                .setInt(3, resultSet.getInt(3));
        preparedStatement
                .setInt(4, resultSet.getInt(4));
        preparedStatement
                .setInt(5, resultSet.getInt(5));
        preparedStatement
                .execute();
    }
}
catch (PSQLException p){
    sql="DROP TABLE table_name2";
    sql="CREATE TABLE table_name2()";
    System.out.println("Такие значения уже существуют в базе данных!");
}
        try {
            if (resultSet != null) {
                resultSet.next();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error: " + ex.getMessage());
        }

    }

    public static void main(String[] args) throws IOException, SQLException {
        CopyALL copyALL = new CopyALL();
        copyALL.all();
    }
}


