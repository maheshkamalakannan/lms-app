
<%@ include file="../common/include_tags.jsp" %>
<form:form modelAttribute="ChangePasswordForm" name="changepassword" id="changepassword" method="post"  
           action="/lms-app/submitChangePassword" novalidate="novalidate" 
           ng-controller="changePasswordController">

	<div id="rightdata" ng-controller="constantsController">
    <h2> Change Password</h2>
		  <div id="rightcontent">
		  	<div class="signout">
   			    <h5>${empName}</h5>
			    <a href="#">Sign Out</a>
	        </div>
	       
	        <c:if test="${successmessage != null}">
  				<div id="status_message">${successmessage}</div>
			</c:if> 
    		
    		<div class="changepasswordele"> 
				<input  type="hidden" name="userName" id="userName" value = "${userName}"/>
				<input  type="hidden" name="empName" id="empName" value = "${empName}"/>
				         
				<input  type="password" name="oldPassword" placeholder="Old Password" 
				        style="margin-left: 2px; width: 35%;" ng-model="emp.passwordold" required/><br>
				<div>
		        	<span class="error" style="width: 35%;"
		        	 ng-show="submitted && changepassword.oldpassword.$error.required">{{passwordrequired}}</span>
		        	 <form:errors style="width: 80%;" path="oldPassword" cssClass="error" />
	            </div>
					      
		        <input  type="password" name="newPassword" placeholder="New Password" 
		                style="margin-left: 2px; width: 35%;" ng-model="emp.passwordnew" required/><br>
			    <div>
			        <span class="error" style="width: 35%;" 
					      ng-show="submitted && changepassword.newpassword.$error.required">{{newpasswordrequired}}</span>
		        </div>
					      
				<input  type="password" name="confirmNewPasswod" placeholder="Confirm Password" 
				        style="margin-left: 2px; width: 35%;" ng-model="emp.passwordconfirm" required/><br>
			    <div>
					<span class="error" style="width: 35%;" 
					      ng-show="submitted && changepassword.confirmpassword.$error.required">{{confirmationpasswordrequired}}</span>
				</div>
					      
				<div id="submit">
					<input type="submit" name="submit" value="Save" ng-click="[submitted=true,savepassword(changepassword,$event)]"/>
					 <input type="reset" name="reset" style="margin-left:108px;" value="Cancel" ng-click="reset(changepassword)"/>
				</div>
			 </div>
		  </div>
	</div>
</form:form>