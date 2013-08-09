<%@ include file="../common/commonJs.jsp" %>

<form:form name="applyleave" id="applyleave" method="post" novalidate="novalidate" action="/lms-app/authenticate" ng-controller="applyLeaveController">

	<div id="rightdata" ng-controller="constantsController">
		  <div id="rightcontent">
	      	<h5>{{hometabs}}</h5>
	            <div class="signout">
		             <h5>${empName}</h5>
		             <input type = "hidden" name = "userName" value="${userName}" />
		             <a href="/lms-app">Sign Out</a>
	            </div>
		  </div>
		 
		  <table cellpadding="8">
		  <tr>
		   <td><span class="rc">Leave Type</span></td>
	       <td><select ng-model="leavetype" ng-options="item.LeaveCode as item.LeaveName for item in leaves"></select></td>
	       </tr>
	       <tr>
	       	<td><span class="rc">From Date</span></td>
			<td>
				<div class="control-group input-append">
					<input id="inputDatepicker" class="input-small" type="text" ng-model="datepicker.fromdate" data-date-format="dd/mm/yyyy" readonly bs-datepicker>
	            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
               	 </div>
              </td>
              <td><span class="rc" style="margin-left: -10px;">To Date</span></td>
			  <td>
			  	<div class="control-group input-append">
				    <input id="inputDatepicker" class="input-small" type="text" ng-model="datepicker.todate" data-date-format="dd/mm/yyyy" readonly bs-datepicker>
	        	        <button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
               	 </div>
              </td>
	       	</tr>
	       	<tr>
	       		<td><span class="rc">Number Of Days</span></td>
                <td><input type="text" style="width: 10%; background-color:#FFFFFF" name="noofleaves" onfocus="this.blur()" readonly><br></td>
	       	</tr>
	       	<tr> 
	 	       <td><span class="rc">Reason</span></td>
	           <td><textarea ngModel="lreason" name="leavereason"></textarea></td>
		    </tr>
		    <tr>
	        	<td><span class="rc">Emergency Phone</span></td>
	        	<td><input type="text" name="phone"/></td>
	    	</tr>
	    	<tr>
	        	<td><span class="rc">Contact Address</span></td>
	     		<td><textarea ngModel="address" name="contactaddress"></textarea></td>
	     	</tr>	
		  </table>
		  <div id="submit"> <input type="submit" style="align:center" name="submit" value="Save" ng-click="[submitted=true,savepassword(changepassword,$event)]"/> 
	     		<input type="reset"  name="reset"   value="Cancel" ng-click="reset(changepassword)"/>
	      </div>
		  
		  <div id = "empDetailsDiv">
			<table cellpadding="0"  width="100%" border="0">
				<tr>
					<td>Employee ID</td>
					<td>007</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>mailsenthil77@gmail.com</td>
				</tr>
				<tr>
					<td>Designation</td>
					<td>Senior Software engineer</td>
				</tr>
				<tr>
					<td>Reporting To</td>
					<td>xxxxxxxxxxx xxxxxx</td>
				</tr>
			</table>
		</div>
		
		<div id="grid" ng-controller="gridCtrl">
			<div class="gridStyle" ng-grid="gridOptions"></div>
		</div>
		  
	</div>
	
</form:form>