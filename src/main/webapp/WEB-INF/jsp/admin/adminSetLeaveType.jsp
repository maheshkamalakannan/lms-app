<%@ include file="../common/commonJs.jsp" %>

<form:form name="setleavetype" id="setleavetype" method="post" novalidate="novalidate" action="/lms-app/cancelLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="setLeaveTypeController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminsetleavetype}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	  </div>
	  <div class="leavesummaryContent">  
	       <div>
		      <div class="setleavetypegridStyle" ng-grid="gridOptions"></div>
	       </div>
	       <input style="margin-top:5px;" type="button" name="Search" value="Create" ng-click="[createleavetype($event)]"/>
	  </div>
	  <div class="setleavetypebottom">
		 <div class="setLeavetypeBottomleftContent" ng-model="showleavediv" ng-show="showleavediv">
		   <table>
		    <tbody>
		      <tr><td><span class="rc">Leave Type:</span></td>
		          <td><input type="text" name="leaveName" ng-model="ngleaveName" maxlength="10"  required/>
		      </tr>
		      <tr>
	    	     <td></td>
	    	     <td> 
	    	     <span class="error" style="width: 95%; margin-top:-5px; margin-bottom: 5px;" ng-show="submitted && setleavetype.leaveName.$error.required">Leave Name is Required.</span>
	    	     </td>
		     </tr>
		     <tr><td><span class="rc">Leave Days:</span></td>
		          <td><input type="text" name="leavedays" ng-model="ngleavedays" num-only required/>
		      </tr>
		      <tr>
	    	     <td></td>
	    	     <td>
	    	     <span class="error" style="width: 95%; margin-top:-5px; margin-bottom: 5px;" ng-show="submitted && setleavetype.leavedesc.$error.required">Leave Days is Required.</span>
	    	     </td>
		     </tr>
		    </tbody>
		   </table>
		 </div>
		 <div class="setLeavetypeBottommiddelContent" ng-model="showleavediv" ng-show="showleavediv">
			   <table>
			    <tbody>
			      <tr><td><span class="rc">Description:</span></td>
			          <td><textarea name="leavedesc" ng-model="ngleavedesc" maxlength="30"  required></textarea>
			      </tr>
			      <tr>
		    	     <td></td>
		    	     <td>
		    	     <span class="error" style="width: 95%; margin-top:-5px; margin-bottom: 5px;" ng-show="submitted && setleavetype.leavedesc.$error.required">Leave Description is Required.</span>
		    	     </td>
			     </tr>
			    </tbody>
			   </table>
			 <div class="setleavetypebutton" ng-model="showleavediv" ng-show="showleavediv">
				 <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveleavetype(setleavetype,$event)]"/> 
				 <input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,cancelleavetype()]"/>
			</div>
		</div>
	</div>
</div>
</form:form>