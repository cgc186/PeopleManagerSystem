<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>人脸识别 • 在线版</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bface.css" rel="stylesheet">
</head>

<body>
	<!--整体内容区域-->
	<div class="container container-main">
		<!--人脸识别模态框-->
		<div class="modal fade" id="myModal" aria-hidden="true"
			data-backdrop="static" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel"
							style="display: inline-block">BFace ▪ 人脸识别</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="modal-body-title">
							<!--头部提示文字-->
							<p>请将头部放在视频区域内,匹配成功将会自动登入系统</p>
							<p>
								如果视频内未出现识别框或长时间未响应 <a style="cursor: pointer">请单击此处</a>
							</p>
						</div>
						<!--人脸框-->
						<div class="modal-body-viode">
							<canvas id="canvas" width="420" height="340"></canvas>
							<video id="video" width="420" height="340" preload autoplay loop
								muted></video>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--人脸识别开启模态框按钮-->
		<table style="margin: 200px auto;">
			<tr>
				<td colspan="3"><img alt="" src="images/timg.jpg" /></td>
			</tr>
			<tr>
				<td align="center">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#myModal" onclick="showLogin()">登陆</button>
				</td>
				
				</td>
				<td align="center">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#myModal" onclick="showReg()">注册</button>
				</td>
			</tr>
		</table>
	</div>

	<!--JS导入-->
	<script type="text/javascript" src="js/tracking-min.js"></script>
	<script type="text/javascript" src="js/face-min.js"></script>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bface.js"></script>
	<script type="text/javascript">
		function showLogin() {
			//调用人脸识别方法
			login("http://localhost:8080/PeopleManagerSystem/Login_ser_test");
		}
		function showReg() {
			//调用人脸识别方法
			reg("http://localhost:8080/PeopleManagerSystem/RegServlet");
		}
	</script>
</body>

</html>