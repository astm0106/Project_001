package a001;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class App001
 */
//@WebServlet("/App001")
public class App001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public App001() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            //DBに接続(URL,USER_ID,PASSWORD)
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
            conn = ds.getConnection();

            //SQLを発行
            pstmt = conn.prepareStatement("select  * from tbl01 ");
            //pstmt.clearParameters();
            //pstmt.setString(1, "X");
            rs = pstmt.executeQuery();

            //結果を取得
            String result = null;
            while(rs.next()) {
                result = rs.getString("txt01");
            }

            //後始末
            rs.close();
            pstmt.close();
            conn.close();

            //結果をブラウザへ
            StringBuilder sb = new StringBuilder();
            sb.append("<html><body>").append(result).append("</body></html>");
            PrintWriter pw = response.getWriter();
            pw.write(sb.toString());
            pw.flush();
            pw.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
