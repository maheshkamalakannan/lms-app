<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
 
<html>  
	<head>  
	    <title>
	   	 <tiles:insertAttribute name="title" ignore="true"/>
		</title>
	</head>
	<body>
	    <tiles:insertAttribute name="header"></tiles:insertAttribute>
	    
	    <div class="background logo_desc">
		</div>
		<div class="left_block logo_desc" style="width:290px;">
		  <div class="content">
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
          </div>
		</div>
		
		<div class="background loginform" style="margin-left: 290px;">
		  <div class="content">
               <tiles:insertAttribute name="body"></tiles:insertAttribute>
          </div>
        </div>
        
        <div class="bottom_block footer footerbackground">
		  <div class="hr"></div>
			<div class="content">
               <tiles:insertAttribute name="footer"></tiles:insertAttribute>
            </div>
        </div>
	</body>  
</html>