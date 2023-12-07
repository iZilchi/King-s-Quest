package Game.minigame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    public void setUsername(String username) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboard", "root", "mariadb3306");

            PreparedStatement insertPs = connection.prepareStatement("insert into record (userName) values (?)");
            insertPs.setString(1, username);
            int insertCount = insertPs.executeUpdate();
            System.out.println(insertCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTime(String time, int userID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboard", "root", "mariadb3306");

            PreparedStatement updatePs = connection.prepareStatement("update record set time = ? where userID = ?");
            updatePs.setString(1, time);
            updatePs.setInt(2, userID);
            int updateCount = updatePs.executeUpdate();
            System.out.println("updateCount" + updateCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getuserID(String username){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboard", "root", "mariadb3306");

            PreparedStatement getPs = connection.prepareStatement("select userID from record where userName = ?");
            getPs.setString(1, username);
            ResultSet resultSet = getPs.executeQuery();

            int userID = 0;

            while (resultSet.next()){
                userID = resultSet.getInt("userID");
            }
            return userID;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
