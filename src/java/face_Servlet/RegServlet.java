package face_Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import util_face.AipFaceUtil;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5399914751488740184L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);  //
		String userid=(String) session.getAttribute("userid");//备用
		request.setCharacterEncoding("UTF-8"); // 设置防止提交的中文数据乱码
		response.setContentType("text/html;charset=UTF-8"); // 设置响应的信息不乱码
		PrintWriter out = response.getWriter();// 获取一个能够向客户端显示信息的对象
		// 泛型集合ArrayList List Map
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("user_info", "test1");
		options.put("quality_control", "LOW");
		options.put("liveness_control", "LOW");
		String img = request.getParameter("base");// 获取前台网页传过来的base64的字符串（人脸信息）
		img = img.substring(22);
		JSONObject res = AipFaceUtil.getInstance().addUser(img, "BASE64", "employees", "0001", options);
		System.out.println(res.toString(2));
		out.print(res.toString(2));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}