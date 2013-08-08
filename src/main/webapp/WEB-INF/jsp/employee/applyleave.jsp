<%@ include file="../common/include_tags.jsp" %>

<form:form name="applyleave" id="applyleave" method="post" novalidate="novalidate" action="/lms-app/authenticate" ng-controller="applyLeaveController">

	<div id="rightdata" ng-controller="constantsController">
		  <div id="rightcontent">
	      	<h5>{{hometabs}}</h5>
	            <div class="signout">
		             <h5>${empName}</h5>
		             <a href="/lms-app">Sign Out</a>
	            </div>
		  </div> 
            <div id="leftcontent">
                <table cellpadding="0" class="cf" width="100%">
                 <tbody>
					<tr class="r7">
						<td class="r8"><span class="rc">Employee ID</span></td>
						<td class="r8"><span class="rc">007</span></td>
					</tr>
					<tr class="r7">
						<td class="r8"><span class="rc">Email ID</span></td>
						<td class="r8"><span class="rc">vijay.c@madronesoft.com</span></td>
					</tr>
					<tr class="r7">
						<td class="r8"><span class="rc">Immediate Supervisor</span></td>
						<td class="r8"><span class="rc">xxxx</span></td>
					</tr>
					<tr class="r7">
						<td class="r8"><span class="rc">Designation</span></td>
						<td class="r8"><span class="rc">SE</span></td>
					</tr>
				 </tbody>
				</table>
            </div>
            <div id="grid" ng-controller="gridCtrl">
               <div class="gridStyle" ng-grid="gridOptions"></div>
            </div>
               
             <div class="bottomleftContent">
             <h4><span class="rc">Leave Details</span></h4><br>
              <table cellpadding="1">
	              <tbody>
	              <tr>
	                  <td><span class="rc">Leave Type</span></td>
	                  <td><select ng-model="leavetype" ng-options="item.LeaveCode as item.LeaveName for item in leaves"></select></td>
	              </tr>
	               <tr>
		             <td><span class="rc">From Date</span></td>
					 <td><div class="control-group input-append">
						    <input id="inputDatepicker" class="input-small" type="text" ng-model="datepicker.fromdate" data-date-format="dd/mm/yyyy" readonly bs-datepicker>
	                        <button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
                      	 </div>
                     </td>
                     <td><span class="rc" style="margin-left: -60px;">To Date</span></td>
					 <td><div class="control-group input-append">
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
                  </tbody>
               </table>    
             </div>
             
             <div class="bottomrightContent">
             <h4><span class="rc">Emergency Contact</span></h4>
                <table cellpadding="15">
	              <tbody>
	                <tr>
	                    <td><span class="rc">Phone</span></td>
	                    <td><input type="text" name="phone"/></td>
	                </tr>
	                <tr>
	                    <td><span class="rc">Address</span></td>
	                    <td><textarea ngModel="address" name="contactaddress"></textarea></td>
	                </tr>
	              </tbody>
	            </table>
             </div>
             
             <div id="leavesubmit">
				   <input type="submit" name="submit" value="Apply" ng-click="[submitted=true,savepassword(changepassword,$event)]"/>
				   <input type="reset" name="reset" style="margin-left:18px;" value="Cancel" />
			 </div>
	</div>
</form:form>