package com.face_Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.utils.GsonUtils;
import com.utils.HttpUtil;

import com.util_face.AuthService;;
@WebServlet("/Login_ser_test")
public class Login_ser_test extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2973067803096322988L;
	
	public static String getValueFromJson(String data, String key) {
        JSONObject dataJson;
        try {
            dataJson = new JSONObject(data);
            JSONObject dataJson2 = dataJson.getJSONObject(key);
            JSONObject dataJson3 = dataJson2.getJSONArray("user_list").getJSONObject(0);
            String value = dataJson3.getString("user_id");
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8"); // 设置防止提交的中文数据乱码
			response.setContentType("text/html;charset=UTF-8"); // 设置响应的信息不乱码
			PrintWriter out = response.getWriter();// 获取一个能够向客户端显示信息的对象
			// 泛型集合ArrayList List Map
			 String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
			String img = request.getParameter("base");// 获取前台网页传过来的base64的字符串（人脸信息）
			img = img.substring(22);
			try {
			HashMap<String, String> map = new HashMap<String, String>();
			  map.put("image", img);
	          map.put("liveness_control", "NORMAL");
	          map.put("group_id_list", "employees");
	          map.put("image_type", "BASE64");
	          map.put("quality_control", "LOW");
	          map.put("max_user_num", "1");
	          String param = GsonUtils.toJson(map);
	          String accessToken = AuthService.getAuth();
	          
	          String result = HttpUtil.post(url, accessToken, "application/json", param);
	          String res=getValueFromJson(result,"result");
	          
	          
				System.out.println(res);
				HttpSession session = request.getSession(true);  
				session.setAttribute("userid", res);
				out.print(result);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
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