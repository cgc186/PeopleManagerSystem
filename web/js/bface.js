function login(url) {
	var video = document.getElementById('video');
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	var tracker = new tracking.ObjectTracker('face');
	var i = 0;
	tracker.setInitialScale(4);
	tracker.setStepSize(2);
	tracker.setEdgesDensity(0.1);
	tracking.track('#video', tracker, {
		camera : true
	});
	tracker.on('track', function(event) {
		context.clearRect(0, 0, canvas.width, canvas.height);
		event.data.forEach(function(rect) {
			while (i >= 0) {
				canvas.getContext('2d').drawImage(video, 0, 0, canvas.width,
						canvas.height);

				$.post(url, {
					"base" : canvas.toDataURL()
				}, function(res) {
					if (res.error_code == 0) {
						if (res.result.user_list['0'].score > 80) {
							location.href = 'index/index.html';
						}
					} else {
						alert('登陆失败,请重试');
						location.href = 'face.jsp';
					}
				}, "json");
				i--;
			}
			context.strokeStyle = '#a64ceb';
			context.strokeRect(rect.x, rect.y, rect.width, rect.height);
			context.font = '11px Helvetica';
			context.fillStyle = "#fff";
			context.fillText('x: ' + rect.x + 'px', rect.x + rect.width + 5,
					rect.y + 11);
			context.fillText('y: ' + rect.y + 'px', rect.x + rect.width + 5,
					rect.y + 22);
		});
	});
}

function reg(url) {
	var video = document.getElementById('video');
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	var tracker = new tracking.ObjectTracker('face');
	var i = 0;
	tracker.setInitialScale(4);
	tracker.setStepSize(2);
	tracker.setEdgesDensity(0.1);
	tracking.track('#video', tracker, {
		camera : true
	});
	tracker.on('track', function(event) {
		context.clearRect(0, 0, canvas.width, canvas.height);
		event.data.forEach(function(rect) {
			while (i >= 0) {
				canvas.getContext('2d').drawImage(video, 0, 0, canvas.width,
						canvas.height);

				$.post(url, {
					"base" : canvas.toDataURL()
				}, function(result) {
					
					if (result.error_code == 0) {
						alert('注册成功,请使用人脸识别登陆');
						location.href = 'face.jsp';
					} else {
						alert('注册失败,请刷新后重试');
						location.href = 'face.jsp';
					}
				}, "json");
				i--;
			}
			context.strokeStyle = '#a64ceb';
			context.strokeRect(rect.x, rect.y, rect.width, rect.height);
			context.font = '11px Helvetica';
			context.fillStyle = "#fff";
			context.fillText('x: ' + rect.x + 'px', rect.x + rect.width + 5,
					rect.y + 11);
			context.fillText('y: ' + rect.y + 'px', rect.x + rect.width + 5,
					rect.y + 22);
		});
	});
}