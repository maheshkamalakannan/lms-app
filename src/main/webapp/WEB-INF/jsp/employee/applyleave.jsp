<%@ include file="../common/commonJs.jsp" %>

<form:form name="applyleave" id="applyleave" method="post" novalidate="novalidate" action="/lms-app/authenticate" ng-controller="applyLeaveController">

	<div id="rightdata" ng-controller="constantsController">
	  <div id="topcontent">
      	<h5>{{hometabs}}</h5>
          <div class="signout">
             <h5>${empName}</h5>
             <input type = "hidden" name = "userName" value="${userName}" />
             <a href="/lms-app">Sign Out</a>
           </div>
       </div>
       <div id="applyleaverightcontent">  
		  <table cellpadding="4"  ng-controller="MainCtrl">
		    <tr>
			   <td><span class="rc">Leave Type</span></td>
		       <td><select ng-model="leavetype" ng-options="item.LeaveCode as item.LeaveName for item in leaves"></select></td>
	        </tr>
	        <tr>
		       	<td><span class="rc">From Date</span></td>
				<td>
					<div class="control-group input-append">
						<input id="inputDatepicker" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="fromdate" 
						       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
						       data-date-today-Highlight='true' bs-datepicker readonly ng-change="fromsdate($event)">
		            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <input type="radio" ng-model="fromdaygreeting" value="am"> am 
                     <input type="radio" ng-model="fromdaygreeting" value="pm"> pm <br/>
	            </td>
	         </tr>
	         <tr>
	              <td><span class="rc">To Date</span></td>
				  <td>
				  	<div class="control-group input-append">
					    <input id="inputDatepicker" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="todate"
					           data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
						       data-date-today-Highlight='true' bs-datepicker readonly ng-change="todaysdate($event)">
		        	    <button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <input type="radio" ng-model="todaygreeting" value="am"> am 
                     <input type="radio" ng-model="todaygreeting" value="pm"> pm <br/>
                     <span class="error" style="width: 80%;" ng-model="todategreaterfromdate" ng-show="todategreaterfromdate">To-date should be greater.</span>
	              </td>
	       	</tr>
	       	<tr>
		       	  <td><span class="rc">Number Of Days</span></td>
	              <td><input type="text" name="days" style="width: 10%; background-color: #FFFFFF;" ng-model="days" readonly><br></td>
	       	</tr>
	       	<tr>
	        	  <td><span class="rc">Emergency Phone</span></td>
	        	  <td><input type="text" name="phone" required/></td>
	        	  <span class="error" style="width: 80%;" ng-model="phone" ng-show="submitted && applyleave.phone.$error.required">Phone Number Required.</span>
	    	</tr>
	       	<tr> 
	 	          <td><span class="rc">Reason</span></td>
	              <td><textarea ngModel="lreason" name="leavereason"></textarea></td>
	              <span class="error" style="width: 80%;" ng-model="reason" ng-show="submitted && applyleave.leavereason.$error.required">Reason Required.</span>
		    </tr>
		    
		  </table>
		</div>
	  
	  <div id="applyleaveleftcontent">
			  <table cellpadding="4">
		        <tbody>
		          <tr>
					<td class="rc">Employee ID</td>
					<td>007</td>
				  </tr>
				  <tr>
					<td class="rc">Email</td>
					<td>mailsenthil77@gmail.com</td>
				  </tr>
				  <tr>
					<td class="rc">Designation</td>
					<td>Senior Software engineer</td>
				  </tr>
				  <tr>
					<td class="rc">Reporting To</td>
					<td>xxxxxxxxxxx xxxxxx</td>
				  </tr>
		        </tbody>
		      </table>
			<div id="grid" ng-controller="gridCtrl">
			  <div class="gridStyle" ng-grid="gridOptions"></div>
		    </div>
	  </div>
 	  <div id="leavesubmit">
            <input type="submit" name="submit" value="Save" ng-click="[submitted=true,savepassword(changepassword,$event)]"/> 
    		<input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="reset(changepassword)"/>
	  </div>
	</div>
</form:form>