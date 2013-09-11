<%@ include file="../common/commonJs.jsp" %>

<form:form name="LeaveCorrectionForm" id="LeaveCorrectionForm" method="post" novalidate="novalidate" action="/lms-app/cancelLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="leaveCorrectionController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminviewleave}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	  </div>
	  <div class="leavecorrectionleftcontent">
	       <span class="rc">Department</span>
				    <select name="deptId" id="deptId" ng-model="ngdeptId">
		      				<c:forEach items="${deptList}" var="dept">
			       				<option value="${dept.id}">${dept.description}</option>
			   				</c:forEach>
						</select>
			  		<span class="rc" style="margin-left:10px;">Leave Type</span>
		      		<select name="leaveType" id="leaveType" ng-model="ngleaveType">
	  				  	 	<c:forEach items="${leaveTypes}" var="ltype">
	       				 		<option value="${ltype.id}">${ltype.description}</option>
	   						</c:forEach>
					</select>
	   </div>
	   <div class="leavecorrectionrightcontent">
	       <span class="rc">From Date</span>
			<div class="control-group input-append">
				<input name="fromDate" id="fromDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="ngfromdate" 
				       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
				       data-date-today-Highlight='true' bs-datepicker readonly ng-change="lcfromdate($event)" required/>
	           	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	        </div>
	        <span class="rc" style="margin-left:10px;">To Date</span>
	        <div class="control-group input-append">	
				<input name="toDate" id="toDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="ngtodate" 
				       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
				       data-date-today-Highlight='true' bs-datepicker readonly ng-change="lctodate($event)" required/>
            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
            </div>
            <input type="button" name="search" value="search" ng-click="[submitted=true,leaveCorrectionsSearch(adduser,$event)]"/>
            
            <span class="error" style="width: 33%;" ng-model="fromdatereq" ng-show="fromdatereq">{{fromdaterequired}}</span>
            <span class="error" style="width: 33%; margin-left: 225px;" ng-model="todatereq" ng-show="todatereq">{{todaterequired}}</span> 
            <span class="error" style="width: 33%; margin-left: 225px;" ng-model="todategreaterfromdate" ng-show="todategreaterfromdate">{{todategreater}}</span> 
	  </div>
	</div>
</form:form>