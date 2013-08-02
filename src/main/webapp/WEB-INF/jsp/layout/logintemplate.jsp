<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
 
<html>  
	<head>  
	    <title>
	    <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
		</title>
	</head>
	<body>
		            <tiles:insertAttribute name="header"></tiles:insertAttribute> 
		            <tiles:insertAttribute name="body"></tiles:insertAttribute> 
		            <tiles:insertAttribute name="footer"></tiles:insertAttribute> 
	</body>  
</html>