//<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
//<script type="text/javascript" src="js/jquery.js"></script>
function getEmploy(){
	var array = new Array();
	<c:forEach item="${employeeslist}" var="employ" varStatus="status" >
		array.push(employ);
	</c:forEach> 
}