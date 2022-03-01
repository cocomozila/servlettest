package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MemberDAO {
	
	public int getTotalMember() {
		
		int total = 0;
		
		try {			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			
			PreparedStatement pt = conn.prepareStatement("select count(*) from member_table");
			
			ResultSet rs = pt.executeQuery();
			rs.next();
			total = rs.getInt("count(*)");
			conn.close();			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			return total;			
		}
	}
	
	public void limitSelectMember() {
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		try {			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			
			PreparedStatement pt = conn.prepareStatement("select * from member_table limit ?, ?");
			pt.setInt(1, 5);
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
			
			conn.close();			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<MemberDTO> lookupMember() {
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		try {			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "1234");
			
			PreparedStatement pt = conn.prepareStatement("select * from member_table");
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
			
			conn.close();			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;		
	}
	
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
			
			PreparedStatement pt = conn.prepareStatement("select * from member_table where id=?");
			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				str[0] = rs.getString("id");
				str[1] = rs.getString("password");
			}
			
			conn.close();			
			return str;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return str;		

	}

}
