<%@ include file="../common/commonJs.jsp" %>

<form:form name="leavesummary" id="leavesummary" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

<div id="rightdata" ng-controller="leavesummaryController">
  <div id="topcontent" style="margin-bottom:2px;">
     	<h5>{{leavesummarytab}}</h5>
         <div class="signout">
             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
            <input type = "hidden" name = "userName" value="${userName}" />
            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
            <a href="/lms-app">Sign Out</a>
          </div>
      </div>
</div>

</form:form>