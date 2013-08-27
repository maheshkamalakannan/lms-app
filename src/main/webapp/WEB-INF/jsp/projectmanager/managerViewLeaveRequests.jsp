<%@ include file="../common/commonJs.jsp" %>

<form:form name="viewleavereq" id="viewleavereq" method="post" novalidate="novalidate" action="/lms-app/cancelLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="managerViewApprovedLeaveController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{viewleaverequest}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{selecteddata}} />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	  </div>
	    <div id="viewleaverequestcontent">
	       <c:if test="${SucessMessage != null}">
		      <div class="success" style="margin: 5px 5px 5px 250px; width:42%;">${SucessMessage}</div>
		   </c:if>
	       <div style="padding-bottom:10px;"ng-init='init(data1=${jsonString})'>
		      <div class="viewleaverequestgridStyle" ng-grid="gridOptions"></div>
	       </div>
		   <!--  <div id="viewleaverequestleftcontent">
		      <div class="viewleaverequestgridStyle1" ng-grid="gridOptions1"></div>
	       </div> -->
	       <div id="viewleaverequestrightcontent">
		      <div class="rc">{{viewleaverequestcomment}}</div>
		      <textarea style="margin-left:5px; width:300px; height:60px;" ng-model="ngcomments" name="comments" required maxlength="100"></textarea>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-show="submitted && viewleavereq.comments.$error.required">{{viewleaverequestcommentrequired}}</span>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-model="selectleavetoapprove" ng-show="selectleavetoapprove">{{viewleaverequestapprove}}</span>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-model="selectleavetoreject" ng-show="selectleavetoreject">{{viewleaverequestreject}}</span>
			  <div style="margin-top:7px; margin-left:5px;">
		           <input type="submit" name="submit" value="Approve" ng-click="[submitted=true,approveleave(viewleavereq,$event)]"/> 
		   		   <input type="submit"  style="margin-left:10px;" name="submit"   value="Reject" ng-click="[submitted=true,rejectleave(viewleavereq,$event)]"/>
			  </div>
		  </div>
	  </div>
	</div>
</form:form>