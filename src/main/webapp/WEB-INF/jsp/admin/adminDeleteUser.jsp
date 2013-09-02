<%@ include file="../common/commonJs.jsp" %>

<form:form name="deleteuser" id="deleteuser" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

	<div id="rightdata" ng-controller="modifyUserController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{admindeluser}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/lms-app">Sign Out</a>
	          </div>
	          <c:if test="${SucessMessage != null}">
		        <div class="success" style="margin: -27px 5px 5px 250px; width:42%;">${SucessMessage}</div>
		      </c:if>
	          <div id="search" ng-model="ngsearch" ng-show="ngsearch">
	            <span class="rc">{{employeeemail}}</span> 
	            <input style="margin-left:17px" type="email" name="emailSearch" id="searchEmail" ng-model="ngsearchemail"  ng-change="changeEmail()" width-reducer required/>
	            <input type="button" name="Search" value="Search" ng-click="[search=true,searchuser(deleteuser,$event)]"/>
	            <span class="error" style="width: 20%;margin-top:-5px; margin-left:120px;" ng-show="search && deleteuser.emailSearch.$error.required">{{emailrequired}}</span> 
	            <span class="error" style="width: 20%;margin-top:-5px; margin-left:120px;" ng-show="search && deleteuser.emailSearch.$error.email">{{invalidemail}}</span>
	            <div class="error" ng-model="userexistence" ng-show= "userexistence" style="margin: 120px 150px 150px 350px; width:32%;">{{emailnotexists}}</div>
	         </div>
	  </div>
	  <div id="adminleftcontent" ng-model="showdiv" ng-show="showdiv">
	   <table>
	    <tbody>
	      <tr><td><span class="rc">{{firstname}}</span></td>
	          <td><input type="text" name="firstname" ng-model="ngfirstname" maxlength="30" width-reducer make-readonly required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td> 
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{lasttname}}</span></td>
	          <td><input type="text" name="lastname" ng-model="nglastname" maxlength="30" width-reducer make-readonly required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	     <tr><td><span class="rc">{{empid}}</span></td>
	          <td><input type="text" name="empid" ng-model="ngempid" width-reducer make-readonly required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{employeeemail}}</span></td>
	          <td><input type="email" name="email" ng-model="ngemail" width-reducer make-readonly required/>
	      </tr>
	      <tr><td><span class="rc">{{contact}}</span></td>
	          <td><input type="text" name="phone" ng-model="ngphone" maxlength="10" width-reducer make-readonly required/>
	      </tr>
	      <tr><td><span class="rc">{{admpassword}}</span></td>
	          <td><input type="password" name="password" ng-model="ngpassword" maxlength="10" ng-minlength="7" width-reducer make-readonly required/>
	      </tr>
       	 <tr><td><span class="rc">{{secemail}}</span></td>
	   			 <td><input type="email" name="secemail" ng-model="ngsecemail" width-reducer make-readonly/>
		 </tr>
	    </tbody>
	   </table>
	  </div>
	  <div id="adminmiddlecontent" ng-model="showdiv" ng-show="showdiv">
		   <table>
		   	 <tbody>
		   	         <tr>
				       	<td><span class="rc">{{joiningdate}}</span></td>
						<td>
							<div class="control-group input-append">
								<input name="dateofjoin" id="dateofjoin" style="background-color: #FFFFFF; width:115px" class="input-small" type="text" ng-model="dateofjoin" 
								       data-date-format="dd/mm/yyyy" data-date-today-Highlight='true' bs-datepicker readonly ng-change="olddate($event)" make-readonly required/>
				            	<button type="button" class="btn" data-toggle="datepicker" make-readonly><i class="icon-calendar"></i></button>
			               	 </div>
			            </td>
			          </tr>
		   	         <tr><td><span class="rc">{{employeedesignation}}</span></td>
	          			 <td><input type="text" name="designation" ng-model="ngdesignation" width-reducer make-readonly required/>
	      			 </tr>
				   	 <tr>
					   <td><span class="rc">{{department}}</span></td>
				       <td><select name="leaveType" width-reducer make-readonly>
			      				   <option value="admin">ADMIN</option>
			      				   <option value="admin">DEVELOPMENT</option>
							</select>
						</td>
				      </tr>
				     <tr><td><span class="rc">{{role}}</span></td>
				           <td><select name="level" width-reducer make-readonly>
				      				   <option value="admin">Amin</option>
				      				   <option value="admin">Employee</option>
								</select>
							</td>
				      </tr>
				     <tr><td><span class="rc">{{reportingto}}</span></td>
				           <td><select name="level" width-reducer make-readonly>
				      				   <option value="admin">Manager</option>
				      				   <option value="admin">Admin</option>
								</select>
							</td>
				      </tr>
				      <tr><td><span class="rc">{{address}}</span></td>
				          <td><textarea style="padding: 4px 6px; height:70px;" ng-model="ngaddress" name="address"  width-reducer required maxlength="100" make-readonly></textarea></td>
				      </tr>
		    </tbody>
		</table>
	</div>
	<div id="adminrightcontent" ng-model="showdiv" ng-show="showdiv">
		<table>
			<tbody>
				<tr><td><span class="rc">{{city}}</span></td>
		            <td><input type="text" name="city" ng-model="ngcity" maxlength="20" width-reducer make-readonly required/>
			    </tr>
			    <tr><td><span class="rc">{{state}}</span></td>
			        <td><input type="text" name="state" ng-model="ngstate" width-reducer make-readonly required/>
			    </tr>
			    <tr><td><span class="rc">{{pincode}}</span></td>
			        <td><input type="text" name="pincode" ng-model="ngpincode" maxlength="6" width-reducer make-readonly required/>
			    </tr>
			</tbody>
		</table>
		<div class="adminbuttonsalign">
	        <input type="submit" name="submit" value="Delete" ng-click="[submitted=true,deleteuser(deleteuser,$event)]"/> 
			<input type="button"  style="margin-left:10px;" name="back"   value="Back" ng-click="[takeuserback()]"/>
		</div>
	  </div>
	</div>
</form:form>