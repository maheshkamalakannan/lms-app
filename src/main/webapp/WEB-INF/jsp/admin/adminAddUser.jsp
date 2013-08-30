<%@ include file="../common/commonJs.jsp" %>

<form:form name="adduser" id="adduser" method="post" novalidate="novalidate" action="/lms-app/cancelLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="adduserController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminadduser}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	          
		      <div class="success" style="margin: -27px 5px 5px 250px; width:42%;">${SucessMessage}</div>
		     
	  </div>
	  <div id="adminleftcontent">
	   <table>
	    <tbody>
	      <tr><td><span class="rc">First Name :</span></td>
	          <td><input type="text" name="firstname" ng-model="ngfirstname" maxlength="30" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td> 
    	     </td>
	     </tr>
	      <tr><td><span class="rc">Last Name :</span></td>
	          <td><input type="text" name="lastname" ng-model="nglastname" maxlength="30" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	     <tr><td><span class="rc">Employee ID :</span></td>
	          <td><input type="text" name="empid" ng-model="ngempid" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">Email Address :</span></td>
	          <td><input type="email" name="email" ng-model="ngemail" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
	    	     <span class="error" style="width: 80%;margin-top:-5px; margin-bottom:4px;" ng-show="submitted && adduser.email.$error.email">Email Address is invalid.</span>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">Contact :</span></td>
	          <td><input type="text" name="phone" ng-model="ngphone" maxlength="10" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">Password :</span></td>
	          <td><input type="password" name="password" ng-model="ngpassword" maxlength="10" ng-minlength="7" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	       <span class="error" style="width: 35%;" ng-show="submitted && changepassword.newPassword.$error.minlength">{{newpasswordminlength}}</span>
    	     </td>
	     </tr>
       	 <tr><td><span class="rc">Secondary Email :</span></td>
	   			 <td><input type="email" name="secemail" ng-model="ngsecemail" width-reducer/>
		 </tr>
	     <tr>
	  	 <td></td>
 			<td>
 			  <span class="error" style="width: 80%;margin-top:-5px; margin-bottom:4px;" ng-show="submitted && adduser.secemail.$error.email">Email Address is invalid.</span>
 			</td>
		 </tr>
	     
	    </tbody>
	   </table>
	  </div>
	  <div id="adminmiddlecontent">
		   <table>
		   	 <tbody>
		   	         <tr>
				       	<td><span class="rc">Date Of Join :</span></td>
						<td>
							<div class="control-group input-append">
								<input name="dateofjoin" id="dateofjoin" style="background-color: #FFFFFF; width:115px" class="input-small" type="text" ng-model="dateofjoin" 
								       data-date-format="dd/mm/yyyy" data-date-today-Highlight='true' bs-datepicker readonly ng-change="olddate($event)" required/>
				            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
			               	 </div>
			            </td>
			          </tr>
			          <tr>
			    	     <td></td>
			    	     <td>
				    	    <span class="error" style="width: 80%; margin-top:-5px; margin-bottom:4px;" ng-model="dateishigher" ng-show="dateishigher">Date is Join is incorrect.</span> 
			    	     </td>
				     </tr>
		   	         <tr><td><span class="rc">Designation :</span></td>
	          			 <td><input type="text" name="designation" ng-model="ngdesignation" width-reducer required/>
	      			 </tr>
	                 <tr>
    	     			<td></td>
    	     			<td>
    	     			</td>
	     			 </tr>
				   	 <tr>
					   <td><span class="rc">Department :</span></td>
				       <td><select name="leaveType" width-reducer>
			      				   <option value="admin">ADMIN</option>
			      				   <option value="admin">DEVELOPMENT</option>
							</select>
						</td>
				      </tr>
				     <tr><td><span class="rc">Level :</span></td>
				           <td><select name="level" width-reducer>
				      				   <option value="admin">Amin</option>
				      				   <option value="admin">Employee</option>
								</select>
							</td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td>
			    	     </td>
				     </tr>
				     <tr><td><span class="rc">Reporting To :</span></td>
				           <td><select name="level" width-reducer>
				      				   <option value="admin">Manager</option>
				      				   <option value="admin">Admin</option>
								</select>
							</td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td>
			    	     </td>
				     </tr>
				      <tr><td><span class="rc">Address :</span></td>
				          <td><textarea style="padding: 4px 6px; height:70px;" ng-model="ngaddress" name="address"  width-reducer required maxlength="100"></textarea></td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td> 
			    	     </td>
				     </tr>
		    </tbody>
		</table>
	</div>
	<div id="adminrightcontent">
		<table>
			<tbody>
				<tr><td><span class="rc">City :</span></td>
		            <td><input type="text" name="city" ng-model="ngcity" maxlength="20" width-reducer required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    </td>
			    </tr>
			    <tr><td><span class="rc">State :</span></td>
			        <td><input type="text" name="state" ng-model="ngstate" width-reducer required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    </td>
			    </tr>
			    <tr><td><span class="rc">Pincode :</span></td>
			        <td><input type="text" name="pincode" ng-model="ngpincode" maxlength="6" width-reducer required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    </td>
			    </tr>
			</tbody>
		</table>
		<div class="adminbuttonsalign">
		    <span class="error" style="width: 80%; margin-top:-5px; margin-bottom:10px;" ng-model="submitted" ng-show="((submitted && adduser.firstname.$error.required) || (submitted && adduser.lastname.$error.required) ||
		    	                                                                                                            (submitted && adduser.email.$error.required) || (submitted && adduser.password.$error.required) ||
		    	                                                                                                            (submitted && adduser.dateofjoin.$error.required) || (submitted && adduser.designation.$error.required) ||
		    	                                                                                                            (submitted && adduser.address.$error.required) || (submitted && adduser.city.$error.required) ||
		    	                                                                                                            (submitted && adduser.state.$error.required) || (submitted && adduser.pincode.$error.required) ||
		    	                                                                                                            (submitted && adduser.level.$error.required) || (submitted && adduser.reportingto.$error.required) ||
		    	                                                                                                            (submitted && adduser.empid.$error.required) || (submitted && adduser.phone.$error.required))">All fields are mandatory.</span>
	        <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveuser(adduser,$event)]"/> 
			<input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetuser()]"/>
		</div>
	  </div>
	</div>
</form:form>