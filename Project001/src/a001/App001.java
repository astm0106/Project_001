package a001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public App001() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			// . JSON テキストを全部取り出す
			BufferedReader br = request.getReader();
			String jsonText = br.readLine();
			jsonText = URLDecoder.decode(jsonText, "UTF-8");
			//System.out.println( jsonText );

			// . JSON オブジェクトに変換
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(jsonText);

			// . JSON オブジェクトから特性の属性を取り出す
			String user_name = (String) jsonObj.get("user_name");
			/**
			// 配列の取得
			String array = (String) jsonObj.get("array");

			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				conn = _db.DBUtil.getConnection();

				// SQLを発行
				pstmt = conn.prepareStatement("select  * from tbl01 ");
				// pstmt.clearParameters();
				// pstmt.setString(1, "X");
				rs = pstmt.executeQuery();

				// 結果を取得
				String result = null;
				while (rs.next()) {
					result = rs.getString("txt01");
				}

				// 後始末
				rs.close();
				pstmt.close();
				conn.close();
*/
				// 文字化け対策
				response.setContentType("text/html; charset=UTF-8");
				// 結果をブラウザへ
				StringBuilder sb = new StringBuilder();
//			sb.append("<html><body>").append(result).append("</body></html>");

				sb.append("<html><body>").append("user_name: " + user_name).append("</body></html>");
				//sb.append("<html><body>").append("" + ":" + jsonText).append("</body></html>");

				PrintWriter pw = response.getWriter();
				pw.write(sb.toString());
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
