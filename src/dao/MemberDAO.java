package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

public class MemberDAO {
	
	public void insertMember(MemberDTO dto) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			System.out.println("db연결");
			
			PreparedStatement pt1 = conn.prepareStatement("insert into member_table values(?,?,?,?,?,?)");
			pt1.setString(1, dto.getId());
			pt1.setString(2, dto.getPassword());
			pt1.setString(3, dto.getName());
			pt1.setString(4, dto.getPhone());
			pt1.setString(5, dto.getEmail());
			pt1.setString(6, dto.getAddress());
			
			int rows = pt1.executeUpdate();
			System.out.println(rows);				
			
			conn.close();
			System.out.println("db해제");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String [] selectMember(String id) {
		
		String str [] = new String[2];
		
		try {			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			System.out.println("db연결");
			
			PreparedStatement pt = conn.prepareStatement("select * from member_table where id=?");
			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				str[0] = rs.getString("id");
				str[1] = rs.getString("password");
			}
			
			conn.close();
			System.out.println("db해제");
			
			return str;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return str;		

	}

}
