<%@ include file="../common/commonJs.jsp" %>

<form:form name="cancelleave" id="cancelleave" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

	<div id="rightdata" ng-controller="cancelleaveController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{cancelleavetab}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	  </div>
	  <div style="width:600px; padding:15px;">
	       <div id="cancelleavegrid" ng-init='init(data1=${jsonString})'>
		      <div class="cancelleavegridStyle" ng-grid="gridOptions"></div>
	       </div>
	  </div> 
	  <div style="width:350px; margin:-31em 15px 5px 52em; height: 340px;">
		  <table cellpadding="4">
	        <tbody>
	          <tr>
				<td class="rc">Email : </td>
				<td>vijay.c@madronesoft.com</td>
			</tr>
			<tr>
				<td class="rc">Reporting To : </td>
				<td>Kumarvel C.M</td>
			</tr>
			</tbody>
		  </table> 
	      <div class="rc" style="margin-top:50px; padding:5px;">Reason For Cancellation:</div>
	      <textarea style="padding: 4px 6px; margin-left:5px;" ng-model="cnclreason" name="cancelreason" required maxlength="100"></textarea>
	      <span class="error" style="width: 70%;" ng-show="submitted && cancelleave.cancelreason.$error.required">{{leavereasonrequired}}</span>
		  <div style="padding: 15px 3px; margin-left:5px;">
	           <input type="submit" name="submit" value="Submit" ng-click="[submitted=true,cancelleave(cancelleave,$event)]"/> 
	   		   <input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetcancelleave()]"/>
		  </div>
	  </div>
	</div>

</form:form>