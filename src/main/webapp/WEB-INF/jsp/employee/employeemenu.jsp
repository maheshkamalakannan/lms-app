<%@ include file="../common/include_tags.jsp" %>

<html>
	
	<body>
	   <div id="leftdata">
			         <div id="navigation">
					    <ul class="top-level">
					        <li><a href="/lms-app/employeeHome">Home</a>
					        </li>
					        <li>
					            <a href="#">Leaves</a>
					            <ul class="sub-level">
					                <li><a href="/lms-app/applyLeave" ng-model="showapplyleavediv" ng-click="applyLeave()">Apply Leave</a></li>
					                <li><a href="/lms-app/cancelLeave" ng-model="showcancelleavediv" ng-click="cancelLeave()">Cancel Leave</a></li>
					            </ul>
					        </li>
					        <li>
					            <a href="#">Leave Summary</a>
					            <ul class="sub-level">
					                <li><a href="/lms-app/leaveSummary" ng-model="showleavesummarydiv" ng-click="leaveSummary()">Leave Summary</a></li>
					            </ul>
					        </li>
							<li>
					            <a href="#">Settings</a>
					            <ul class="sub-level">
					                <li><a href="/lms-app/changePassword" ng-model="showchangepassworddiv" ng-click="changepassword(welcome)">Change Password</a></li>
					            </ul>
					        </li>
					        <li>
					            <a href=" ">Sign Out</a>
					        </li>
					    </ul>
					</div>
                </div>
	</body>
</html>