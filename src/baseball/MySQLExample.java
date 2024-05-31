package baseball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/baseball";
        String username = "root";
        String password = "111111";

        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 쿼리 실행
            String sql = "SELECT * FROM bs_rank";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 결과 처리
            while (resultSet.next()) {
                System.out.println("bs_id: " + resultSet.getString("bs_id"));
                System.out.println("bs_nick: " + resultSet.getString("bs_nick"));
            }

            // 리소스 해제
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}