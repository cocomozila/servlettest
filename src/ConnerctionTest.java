import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnerctionTest {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			System.out.println("db연결");

			PreparedStatement pt1 = conn.prepareStatement("insert into member_table values(?,?,?,?,?,?)");
			pt1.setString(1, "id값2");
			pt1.setString(2, "pw값2");
			pt1.setString(3, "이름2");
			pt1.setString(4, "010-7777-6666");
			pt1.setString(5, "email2@naver.com");
			pt1.setString(6, "제주");
			
			int rows = pt1.executeUpdate();
			System.out.println(rows);
			
			
			String sql = "select * from member_table";
			
			PreparedStatement pt = conn.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				System.out.println(id+" / "+password+" / "+name+" / "+phone+" / "+email);
			}			
			
			conn.close();
			System.out.println("db해제");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
