<%@ include file="../common/commonJs.jsp" %>

<form:form name="viewapproveleave" id="viewapproveleave" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

	<div id="rightdata" ng-controller="viewLeavesController" ng-cloak>
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{viewapprovedleaves}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/">Sign Out</a>
	          </div>
	  </div>
	   <div class="leavesummaryContent">  
	       <div ng-init='init(data1=${jsonString})'>
		      <div class="approverejectedleavegridStyle" ng-grid="gridOptions"></div>
	       </div>
	   </div>
	</div>
</form:form>