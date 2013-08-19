<%@ include file="../common/commonJs.jsp" %>

<form:form name="applyleave" id="applyleave" method="post" novalidate="novalidate" action="/lms-app/applyLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="applyLeaveController">
	  <div id="topcontent" style="margin-bottom:2px;">
      	<h5>{{hometabs}}</h5>
          <div class="signout">
             <h5>${empName}</h5>
             <input type = "hidden" name = "userName" value="${userName}" />
             <a href="/lms-app">Sign Out</a>
           </div>
       </div>
       <div id="applyleaverightcontent" style="margin-top:2px;">  
		  <table cellpadding="4">
		    <tr>
			   <td><span class="rc">Leave Type</span></td>
		       <td><select ng-model="leavetype" ng-options="item.LeaveCode as item.LeaveName for item in leaves"></select></td>
	        </tr>
	        <tr>
		       	<td><span class="rc">From Date</span></td>
				<td>
					<div class="control-group input-append">
						<input name="fromdatepicker" id="inputDatepicker" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="fromdate" 
						       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
						       data-date-today-Highlight='true' bs-datepicker readonly ng-change="todaysdate($event)" required/>
		            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <input type="radio" disabled ng-model="fromdaygreeting" name="fromdaygreeting" id="fromdaygreeting" value="am" checked="checked" ng-change="selectfromGreeting($event)"> AM 
                     <input type="radio" ng-model="fromdaygreeting" name="fromdaygreeting" id="fromdaygreeting" value="pm" ng-change="selectfromGreeting($event)"> PM <br/>
	            </td>
	         </tr>
	         <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="submitted" ng-show="submitted && applyleave.fromdatepicker.$error.required">From date Required.</span></td>
	    	</tr>
	         <tr>
	              <td><span class="rc">To Date</span></td>
				  <td>
				  	<div class="control-group input-append">
					    <input name="todatepicker" id="inputDatepicker" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="todate"
					           data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
						       data-date-today-Highlight='true' bs-datepicker readonly ng-change="todaysdate($event)" required/>
		        	    <button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <input type="radio" disabled ng-model="todaygreeting" name="todaygreeting" id="todaygreeting" ng-change="selectfromGreeting($event)" value="am" > AM 
                     <input type="radio" ng-model="todaygreeting" name="todaygreeting" id="todaygreeting" ng-change="selectfromGreeting($event)" value="pm" checked="checked"> PM <br/>
	              </td>
	       	</tr>
	       	<tr>
	    	     <td></td>
	    	     <td>
		    	     <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="todategreaterfromdate" ng-show="todategreaterfromdate">To-date should be greater.</span>
	                 <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="tofromgreeting" ng-show="tofromgreeting">This combination not allowed.</span>
		    	     <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="submitted" ng-show="submitted && applyleave.todatepicker.$error.required">To date Required.</span>
		    	     <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="selectdates" ng-show="selectdates">Please select dates first.</span>
	    	     </td>
	    	</tr>
	       	<tr>
		       	  <td><span class="rc">Number Of Days</span></td>
	              <td><input type="text" name="days" style="width: 15%; background-color: #FFFFFF;" ng-model="days" readonly><br></td>
	       	</tr>
	       		<tr> 
	 	          <td><span class="rc">Emergency Phone</span></td>
	              <td><input type="text"  ng-model="ephone" name="phone" required/></td>
		    </tr>
		    <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;"  ng-model="submitted" ng-show="submitted && applyleave.leavereason.$error.required">Phone number Required.</span></td>
	    	</tr>
	       	<tr> 
	 	          <td><span class="rc">Reason</span></td>
	              <td><textarea style="padding: 4px 6px;" ng-model="lreason" name="leavereason" required></textarea></td>
		    </tr>
		    <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;"  ng-model="submitted" ng-show="submitted && applyleave.leavereason.$error.required">Reason Required.</span></td>
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
            <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveleave(applyleave,$event)]"/> 
    		<input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetapplyleave()]"/>
	  </div>
	</div>
</form:form>