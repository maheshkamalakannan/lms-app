<%@ include file="common/include_tags.jsp" %>
<html ng-app>
<head>
	<script type="text/javascript">
	
		$(function() {
			$("#signin").click(function(event) {
	        	$("#LoginForm").attr("action", "/lms-app/authenticate")
				$("#LoginForm").submit();
			});
	
		});
	</script>
</head>

<body>
	<form:form modelAttribute="LoginForm" name="loginForm" method="post"  action="/lms-app/authenticate" ng-controller="loginController" >
	<div class="content">
		<div class="background logo_desc">
		</div>
		<div class="left_block logo_desc">
			<div class="content">
			   <img src="<%=request.getContextPath()%>/resources/images/employees.jpg" style="width:480px; height:515px;" alt="Milford Sound in New Zealand"/>
			   <!--<img src="employees.jpg" style="max-width:100%;" alt="Milford Sound in New Zealand">-->
			</div>
		</div>
		<div class="background loginform">
		  <div class="shadow">
            <div id="anotherDiv" ng-class="{true: 'error'}[submitted && loginForm.email.$invalid,submitted && loginForm.password.$invalid ]">
			         <h2 style="margin-left:73px;">Sign In</h2>
					 <div id="anotherDiv1">
						  <form:input path="userName" type="email" 
								 name="email" 
								 placeholder="Email Address" 
								 ng-model="email" 
								 /><br>
								 <div>
								   <span class="error" style="width: 80%;" ng-show="submitted && loginForm.email.$error.required">Email address is required.</span>
								   <span class="error" style="width: 80%;" ng-show="submitted && loginForm.email.$error.email">Invalid Email address.</span>
								 </div>
                          <form:password path="password" 
								  name="password" 
								  style="margin-left: 2px;" 
								  placeholder="Password"
								  ng-model="password" 
								  /><br>
							      <div>
							        <span class="error" style="width: 80%;" ng-show="submitted && loginForm.password.$error.required">Password is required.</span>
							      </div>
					   <div id="anotherDiv2">
						  <input type="submit" name="submit" value="Login" ng-click="[submitted=true,loginSubmit(loginForm,$event)]"/>
					   </div>
					</div>       								   
              </div>							   
		</div>
      </div>
	</div>
		
 </form:form>

</body>
</html>
