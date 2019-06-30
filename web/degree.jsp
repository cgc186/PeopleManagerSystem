<%-- 
    Document   : degree
    Created on : 2019-6-28, 21:35:17
    Author     : 98530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            window.onload = function () {
                var chart = new CanvasJS.Chart("chartContainer",
                        {
                            title: {
                                text: "员工文化程度统计"
                            },
                            legend: {
                                maxWidth: 700,
                                itemWidth: 240
                            },
                            data: [
                                {
                                    type: "pie",
                                    showInLegend: true,
                                    legendText: "{indexLabel}",
                                    dataPoints: [
                                        { y: 4181563, indexLabel: "小学" },
				{ y: 2175498, indexLabel: "初中" },
				{ y: 3125844, indexLabel: "高中" },
				{ y: 1176121, indexLabel: "技工"},
				{ y: 1727161, indexLabel: "中专" },
				{ y: 4303364, indexLabel: "大专"},
				{ y: 1717786, indexLabel: "本科"},
				{ y: 1717786, indexLabel: "研究生"}
                                        <c:forEach items="${Basiclist}" var="entry">
                                            { y: ${entry.number}, indexLabel: ${entry.name} },
                                        </c:forEach>
                                    ]
                                }
                            ]
                        });
                chart.render();
            }
    </script>
    <script type="text/javascript" src="js/canvasjs.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <div id="chartContainer" style="height: 700px; width: 100%;"></div>
</body>
</html>
