<%@ include file="common/include_tags.jsp" %>
<html ng-app>
<head>
</head>

<body>

	<form:form modelAttribute="LoginForm" name="loginForm" method="post"  action="/lms-app/authenticate" ng-controller="loginController" novalidate="novalidate" >
	<div class="content" ng-controller="constantsController">
		<div class="background logo_desc">
		</div>
		<div class="left_block logo_desc">
			<div class="content">
			   <img src="<%=request.getContextPath()%>/jsandcss/images/employees.jpg" style="width:480px; height:515px;" alt="Milford Sound in New Zealand"/>
			</div>
		</div>
		<div class="background loginform">
		  <div class="shadow">
            <div id="loginform" ng-class="{true: 'error'}[submitted && loginForm.email.$invalid,submitted && loginForm.password.$invalid ]">
			         <h2 style="margin-left:73px;">{{signin}}</h2>
					 <div id="loginelements">
						  <input type="email" 
								 name="userName" 
								 placeholder="Email Address" 
								 ng-model="email" 
								 required/><br>
								 <div>
								   <span class="error" style="width: 80%;" ng-show="submitted && loginForm.userName.$error.required">{{emailrequired}}</span>
								   <span class="error" style="width: 80%;" ng-show="submitted && loginForm.userName.$error.email">{{invalidemail}}</span>
								 </div>
                          <input  type="password" 
								  name="password" 
								  style="margin-left: 2px;" 
								  placeholder="Password"
								  ng-model="password" 
								  required/><br>
							      <div>
							        <span class="error" style="width: 80%;" ng-show="submitted && loginForm.password.$error.required">{{passwordrequired}}</span>
							        <form:errors style="width: 80%;" path="password" cssClass="error" />
							      </div>
					   <div id="submit">
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
