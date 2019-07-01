package com.util_face;

import javax.servlet.annotation.WebServlet;

import com.baidu.aip.face.AipFace;
@WebServlet("/AipFaceUtil")
public class AipFaceUtil {
	// 设置APPID/AK/SK
		private static final String APP_ID = "16271550";
		private static final String API_KEY = "1ZWlPjcv1tMaZithRjYaT0xI";
		private static final String SECRET_KEY = "7FILVTZmqlH09T6Ebvzh3jkCuGzdkFmN";
		private static AipFace client = null;
		private AipFaceUtil() {
			super();
			// TODO Auto-generated constructor stub
		}
		public static AipFace getInstance() {
			if (client == null) {
				client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
				client.setConnectionTimeoutInMillis(2000);//连接超时时间
				client.setSocketTimeoutInMillis(60000);//数据传输超时时间
			}
			return client;
		}
		
}

