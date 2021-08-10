package _db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SQL001 {

	public static void insertClickNum(String user, String text){

			Connection conn = null;
			PreparedStatement pstmt = null;
			//ResultSet rs = null;

			conn = DBUtil.getConnection();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			int count1 = (int) text.chars().filter(ch -> ch == '1').count();
			int count2 = (int) text.chars().filter(ch -> ch == '2').count();
			int count3 = (int) text.chars().filter(ch -> ch == '3').count();
			int count4 = (int) text.chars().filter(ch -> ch == '4').count();
			int count5 = (int) text.chars().filter(ch -> ch == '5').count();
			int count6 = (int) text.chars().filter(ch -> ch == '6').count();
			int count7 = (int) text.chars().filter(ch -> ch == '7').count();
			int count8 = (int) text.chars().filter(ch -> ch == '8').count();
			int count9 = (int) text.chars().filter(ch -> ch == '9').count();
			int count0 = (int) text.chars().filter(ch -> ch == '0').count();


			// SQLを発行
			try {
				String sql = "INSERT INTO click_num VALUES" +
			                     "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.clearParameters();

				pstmt.setString(1, user);
				pstmt.setTimestamp(2, timestamp);
				pstmt.setInt(3, count1);
				pstmt.setInt(4, count2);
				pstmt.setInt(5, count3);
				pstmt.setInt(6, count4);
				pstmt.setInt(7, count5);
				pstmt.setInt(8, count6);
				pstmt.setInt(9, count7);
				pstmt.setInt(10, count8);
				pstmt.setInt(11, count9);
				pstmt.setInt(12, count0);
				pstmt.setString(13, text);


				pstmt.executeUpdate();

				/** 結果を取得
				String result = null;
				while (rs.next()) {
					result = rs.getString("txt01");
				}
				*/

				// 後始末
				//rs.close();
				pstmt.close();
				conn.close();


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


	}

}
