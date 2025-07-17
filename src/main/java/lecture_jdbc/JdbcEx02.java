package lecture_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcEx02 {
	public static void main(String[] args) {
		// MariaDB Connection 
		final String URL = "jdbc:mariadb://127.0.0.1:3306/chosun";
		final String USER = "root";
		final String PASSWORD = "1234";
		
		// sql 값을 동적으로 받기 위해서
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			// MariaDB Driver Load
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			if (conn != null) {
				System.out.println("연결 성공");				
			}
			
			// DB에 저장
			// CRUD
			//  - CREATE → SQL(INSERT)
			String sql = "INSERT INTO tbl_student "
					   + "VALUES(?, ?, ?)";  // ?(바인딩 변수): 아직 어떤 값을 받을지 모름 
			pstmt = conn.prepareStatement(sql);
			
			// ?에 들어갈 값 세팅
			pstmt.setString(1,  "1002");
			pstmt.setString(2,  "홍길동");
			pstmt.setInt(3,  17);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}
			
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			// 자원 해제(반납)
			pstmt.close();
			conn.close();
			
		}
	}
}
