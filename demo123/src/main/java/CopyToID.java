import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CopyToID {
    public  void connect() throws IOException {

        InputStream input = new FileInputStream("C:\\Users\\гарипов\\Desktop\\demo\\demo123\\src\\main\\resources\\demo.properties");

        Properties s = new Properties();

        s.load(input);

        final String DB_URL = s.getProperty("spring.datasource.url");


        final String USER = "postgres";
        final String PASS = "123";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            Statement statement = null;
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO table_name SELECT *FROM postgres.public.message");

            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}



