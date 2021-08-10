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

import _db.SQL001;

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


			// . JSON テキストを全部取り出す
			BufferedReader br = request.getReader();
			String jsonText = br.readLine();

			String user_name = JsonToValue.getValue("user_name", jsonText);
			String array_string = JsonToValue.getValue("array", jsonText);

			SQL001.insertClickNum(user_name, array_string);



				// 文字化け対策
				response.setContentType("text/html; charset=UTF-8");
				// 結果をブラウザへ
				StringBuilder sb = new StringBuilder();

				sb.append("<html><body>").append("jsonText: " + jsonText).append("</body></html>");

				PrintWriter pw = response.getWriter();
				pw.write(sb.toString());
				pw.flush();
				pw.close();

	}
}
