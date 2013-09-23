<%@ include file="../common/commonJs.jsp" %>

<form:form name="leaveTypeForm" id="leaveTypeForm" method="post" novalidate="novalidate" action="/lms-app/submitSetLeaveType" ng-controller="constantsController">

	<div id="rightdata" ng-controller="setLeaveTypeController" ng-cloak>
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminsetleavetype}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <input type = "hidden" name = "userAction" value={{userAction}} ng-model="nguserAction" />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	            <c:if test="${SucessMessage != null}">
	  		     <div class="success" style="margin: -45px 5px 0px 23.5em; width:37.5%;">${SucessMessage}</div>
			  </c:if>
			  <!-- LMS-087 Starts-->
			  <c:if test="${FailureMessage != null}">
	  		     <div class="error" style="margin: -37px 5px 5px 23.5em; width:37.5%;">${FailureMessage}</div>
			  </c:if>
			  <!-- LMS-087 Ends-->
	  </div>
	  
	  <div class="leavesummaryContent">
	       <div id="setleavetypegrid" ng-init='init(data1=${jsonString})'>
		      <div class="setleavetypegridStyle" ng-grid="gridOptions"></div>
	       </div>
	       <input style="margin-top:5px;" type="button" name="Search" value="Create" ng-click="[createleavetype($event)]"/>
	  </div> 
	  
	  <div class="setleavetypebottom">
		 <div class="setLeavetypeBottomleftContent" ng-model="showleavediv" ng-show="showleavediv">
		   <table cellpadding="4">
		    <tbody>
		      <tr><td><span class="rc">{{employeeleavetype}}</span></td>
		          <td><input type="text" name="id" id="leavetype" ng-model="ngid" maxlength="2" style="width:100px;" read-only  char-only required/>
		      </tr>
		      <tr>
	    	     <td></td>
	    	     <td> 
	    	     <span class="error" style="width: 95%; margin-top:-13px; margin-bottom: 5px;" ng-show="submitted && leaveTypeForm.id.$error.required">{{setleavetypereq}}</span>
	    	     </td>
		     </tr>
		     <tr><td><span class="rc">{{setleavedays}}</span></td>
		          <td><input type="text" name="days" id="leavedays"  ng-model="ngdays" maxlength="2" style="width:100px;" num-only  required/>
		      </tr>
		      <tr>
	    	     <td></td>
	    	     <td>
	    	     <span class="error" style="width: 95%; margin-top:-13px; margin-bottom: 5px;" ng-show="submitted && leaveTypeForm.days.$error.required">{{setleavedaysreq}}</span>
	    	     </td>
		     </tr>
		    </tbody>
		   </table>
		 </div>
		 <div class="setLeavetypeBottommiddelContent" ng-model="showleavediv" ng-show="showleavediv">
			   <table cellpadding="4">
			    <tbody>
			      <tr><td><span class="rc">{{setleavedesc}}</span></td>
			          <td><textarea name="description" id="leavedescription" ng-model="ngdescription" maxlength="50"  required></textarea><!-- LMS-083 Adding maxlength 100 from 50 -->
			      </tr>
			      <tr>
		    	     <td></td>
		    	     <td>
		    	     <span class="error" style="width: 95%; margin-top:-13px; margin-bottom: -40px;" ng-show="submitted && leaveTypeForm.description.$error.required">{{setleavedescreq}}</span>
		    	     </td>
			     </tr>
			    </tbody>
			   </table>
			 <div class="setleavetypebutton" ng-model="showleavediv" ng-show="showleavediv">
				 <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveleavetype(leaveTypeForm,$event)]"/> 
				 <input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,cancelleavetype()]"/>
			</div>
		</div>
	</div>
</div>
</form:form>