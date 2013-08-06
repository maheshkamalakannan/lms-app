<%@ include file="../common/include_tags.jsp" %>
<form:form name="changepassword" id="changepassword" method="post" novalidate="novalidate" action="/lms-app/authenticate" ng-controller="changePasswordController">

	<div id="rightdata" ng-controller="constantsController">
	
		  <div id="rightcontent">
		      <h5>{{changepasswordtabs}}</h5>
		            <div class="signout">
			             <h5>Vijay Chandra</h5>
			             <a href="#">Sign Out</a>
		            </div>
		    
				    <div class="changepasswordele">
				          <input  type="text" name="oldpassword" placeholder="Old Password" style="margin-left: 2px; width: 35%;" ng-model="emp.passwordold" required/><br>
					      <div>
					        <span class="error" style="width: 35%;" ng-show="submitted && changepassword.oldpassword.$error.required">{{passwordrequired}}</span>
					      </div>
					      
						  <input  type="password" name="newpassword" placeholder="New Password" style="margin-left: 2px; width: 35%;" ng-model="emp.passwordnew" required/><br>
					      <div>
					        <span class="error" style="width: 35%;" ng-show="submitted && changepassword.newpassword.$error.required">{{newpasswordrequired}}</span>
					      </div>
					      
					      <input  type="password" name="confirmpassword" placeholder="Confirm Password" style="margin-left: 2px; width: 35%;" ng-model="emp.passwordconfirm" required/><br>
					      <div>
					        <span class="error" style="width: 35%;" ng-show="submitted && changepassword.confirmpassword.$error.required">{{confirmationpasswordrequired}}</span>
					      </div>
					      
						  <div id="submit">
							   <input type="submit" name="submit" value="Save" ng-click="[submitted=true,savepassword(changepassword,$event)]"/>
							   <input type="reset" name="reset" style="margin-left:108px;" value="Cancel" ng-click="reset(changepassword)"/>
						  </div>
				    </div>
		  </div>
	</div>
</form:form>