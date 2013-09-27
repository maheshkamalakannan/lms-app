<%@ include file="../common/commonJs.jsp" %>

<form:form modelAttribute="ResetPasswordForm" name="resetpasswordform" method="post"  action="/lms-app/submitResetPassword" ng-controller="resetPasswordController" novalidate="novalidate" >
	<div class="content" ng-controller="constantsController">
		<div class="">
		  <!-- <div class="forgotshadow">  -->
		  <div>
		    <div class="forgotcontent">
		        <div class="inputcontent" ng-cloak>
		            <input  type="password" name="newPassword" placeholder="New Password" style="margin-left: 2px;" ng-model="passwordnew" ng-change="hidemeter()" maxlength="10" password-meter required/>
				      <div>
				        <span class="error" style="width: 35%;" ng-show="submitted && resetpasswordform.newPassword.$error.required">{{newpasswordrequired}}</span>
				        <span class="error" style="width: 35%;" ng-model="newpasswordlength" ng-show="newpasswordlength">{{newpasswordminlength}}</span>
				        <span class="error" ng-model="confirmerror" ng-show="confirmerror">{{confirmationpassword}}</span>
				      </div>
						      
				     <input  type="password" name="confirmNewPasswod" placeholder="Confirm Password" style="margin-left: 2px;" ng-model="passwordconfirm" ng-change="clearerror()" maxlength="10" required/><br>
				       <div>
				         <span class="error" style="width: 35%;" ng-show="submitted && resetpasswordform.confirmNewPasswod.$error.required">{{confirmationpasswordrequired}}</span>
				         <span class="error" ng-model="showerror" ng-show="showerror">{{passwordmismatch}}</span>
				       </div>
						      
					  <div id="submit">
						   <input type="submit" name="submit" value="Save" ng-click="[submitted=true,savepassword(resetpasswordform,$event)]"/>
						   <input type="reset" name="reset" style="margin-left:90px;" value="Cancel" ng-click="[submitted=false,reset()]"/>
					  </div>
				</div>			 
		    </div>
		</div>
      </div>
	</div>
 </form:form>