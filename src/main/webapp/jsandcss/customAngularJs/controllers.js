'use strict';

var mycontroller = angular.module('mainController', ['ngGrid','$strap.directives']);

/* Directives */
/* Allowing only number in textbox */
mycontroller.directive('numberMask', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            $(element).numeric();
        }
    };
});

mycontroller.directive('widthReducer', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
        	if($(element).prop("tagName") == "SELECT"){
        		$(element).css("width","165");
        	}
        	else{
        		$(element).css("width","150");
        	}
        	
        }
    };
});


/* Controllers */
mycontroller.controller('loginController', function($scope, $window, $location) {
  $scope.loginSubmit = function(form,event){
     if(form.$valid){
	   form.submit();
	 }
	 else{
	  $('.alert-error').hide();	 
	  event.preventDefault();
	 }
  };
});

mycontroller.controller('constantsController', function($scope, $window, $location) {
	$scope.emailrequired     = "Email address is required.";
	$scope.invalidemail      = "Invalid Email address.";
	$scope.passwordrequired  = "Password is required.";
    $scope.signin            = "Sign In";
    
    $scope.newpasswordrequired           = "New Password is required.";
    $scope.newpasswordminlength          = "Password must be 7 characters.";
    $scope.confirmationpasswordrequired  = "Confirm Password is required.";
    $scope.confirmationpassword          = "Current password and New Password are same.";
    $scope.passwordmismatch              = "Passwords do not match.";
    
    $scope.employeeleavetype             = "Leave Type";
    $scope.alfromdate                    = "From Date";
    $scope.altodate                      = "To Date";
    $scope.numberofdays                  = "Number Of Days";
    $scope.emergencyphone                = "Emergency Phone";
    $scope.reason                        = "Reason";
    $scope.employeeid                    = "Employee ID :";
    $scope.employeeemail                 = "Email :";
    $scope.employeedesignation           = "Designation :";
    $scope.reportingto                   = "Reporting To :"; 
    $scope.joiningdate                   = "Joining Date :"; 
    $scope.fromdaterequired              = "From date is Required.";
    $scope.todaterequired                = "To date is Required.";
    $scope.tofromcombination             = "Selected combination not allowed.";
    $scope.todategreater                 = "To-date should be greater.";
    $scope.phonerequired                 = "Phone number is Required.";
    $scope.leavereasonrequired           = "Reason for Leave is Required.";
    $scope.phonenumberminlength          = "Phone No must be 8 digits";
    $scope.daygreeting1                  = "AM";
    $scope.daygreeting2                  = "PM";
    
    $scope.cancelreasonrequired          = "Reason for Cancellation is Required.";
    $scope.selectleavetocncl             = "Select Leave to cancel.";
    
    $scope.viewleaverequestcomment           = "Comments :";
    $scope.viewleaverequestcommentrequired   = "Comment is Required.";
    $scope.viewleaverequestapprove           = "Select a Leave to Approve.";
    $scope.viewleaverequestreject            = "Select a Leave to Reject.";
    
    $scope.hometab                       = "Home";
    $scope.changepasswordtabs            = "Home > Settings > Change Password";
    $scope.applyleavetab                 = "Home > Leaves > Apply Leave";
    $scope.cancelleavetab                = "Home > Leaves > Cancel Leave";
    $scope.leavesummarytab               = "Home > Leave Summary";
    
    $scope.viewleaverequest              = "Home > Leave > View Leave Requests";
    $scope.viewapprovedleaves            = "Home > Reports > View Approved Leaves";
    $scope.viewrejectedleaves            = "Home > Reports > View Rejected Leaves";
    
    $scope.adminadduser                  = "Home > Users > Add Users";
});

mycontroller.controller('changePasswordController', function($scope, $window, $location) {
	$scope.showerror = false;
	$scope.confirmerror = false;
	$scope.savepassword = function(form,event){
		if(form.$valid){
			if($scope.passwordconfirm !=  $scope.passwordnew){
				$scope.showerror=true;
				event.preventDefault();
			}
			else if($scope.passwordcurrent ==  $scope.passwordnew){
				$scope.confirmerror=true;
				event.preventDefault();
			}
			else{
		       form.submit();
			}
		}
		else{
		 event.preventDefault();
		}
	};
	
	$scope.clearerror = function(){
		$scope.showerror=false;
		$scope.confirmerror=false;
	};
	
	$scope.reset = function(){
		$scope.passwordcurrent = '';
		$scope.passwordnew = '';
		$scope.passwordconfirm = '';
		$('.error').css("display","none");
	};
});

mycontroller.controller('employeehomeController', function($scope, $window, $location) {
	 /*JS for employee home page*/
});

mycontroller.controller('applyLeaveController', function($scope, $window, $location) {
	  $scope.todategreaterfromdate = false;
	  var diff                     = "";
	  $scope.tofromgreeting        = false;
	  var countwithoutweekend      = ""; 
	  $scope.leaves = [
	                     {LeaveCode : 'CL', LeaveName : 'Casual Leave' },       
	                     {LeaveCode : 'EL', LeaveName : 'Earned Leave' }];
	  $scope.leavetype        = 'CL';
	  $scope.fromdaygreeting  = 'am';
	  $scope.todaygreeting    = 'pm';
	  
	  /*Grid and grid data for Apply Leave*/
	  $scope.init = function(data1) {
			$scope.gridData = data1;
			$scope.gridOptions = { 
		    		data: 'gridData',
		    		multiSelect: false,
		    		showFooter:true,
		    		columnDefs: [{field: 'Type', displayName: 'Type', cellClass:'aligncolumn'},
		    		             {field: 'Total', displayName: 'Total', cellClass:'aligncolumn'},
		    		             {field: 'Consumed', displayName: 'Consumed', cellClass:'aligncolumn'},
		    		             {field: 'Balance', displayName: 'Balance', cellClass:'aligncolumn'}
		    		             ]};
	  };
	  
	  $scope.todaysdate = function(event) {
		  if(($scope.fromdate > $scope.todate) && ($scope.fromdate != '' && $scope.todate != '')){
			  $scope.todategreaterfromdate = true;
			  event.preventDefault();
		  }
		  else{
			    $scope.todategreaterfromdate = false;
			    var fromgreeting             = $scope.fromdaygreeting;
				var togreeting               = $scope.todaygreeting;
				$scope.tofromgreeting        = false;
				countwithoutweekend = calcBusinessDays($scope.fromdate,$scope.todate);
				calculateDays(fromgreeting,togreeting,event);
		    }
		  };
		  
		  $scope.selectfromGreeting = function(event){
			 $scope.tofromgreeting        = false;
			 if($scope.fromdate == '' && $scope.todate == '')
			 {
				 $scope.submitted        = false;
			 }
			 else{
				 var fromgreeting = $scope.fromdaygreeting;
				 var togreeting   = $scope.todaygreeting;
				 calculateDays(fromgreeting,togreeting,event);
			 }
		  };
		  
  function calculateDays(fromgreeting,togreeting,event){
	     if(((fromgreeting == 'pm' && togreeting == 'pm') || (fromgreeting == 'am' && togreeting == 'am')) && ($scope.fromdate < $scope.todate)){
			    $scope.days                  = 0;
			    //diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (countwithoutweekend+1)-0.5;
		 }
		 else if((fromgreeting == 'am' && togreeting == 'pm') && ($scope.fromdate < $scope.todate)){
			    $scope.days                  = 0;
			    //diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (countwithoutweekend+1);
		 }
		 else if((fromgreeting == 'pm' && togreeting == 'am') && ($scope.fromdate < $scope.todate)){
			    $scope.days                  = 0;
			    //diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (countwithoutweekend);
		 }
		 else if(($scope.fromdate > $scope.todate)){
			 console.log(" from date is greater not applicable");
		 }
		 else{
			 if((fromgreeting == 'pm' && togreeting == 'pm') || (fromgreeting == 'am' && togreeting == 'am')){
				 $scope.days                  = 0;
				 //diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
				 $scope.days = (countwithoutweekend+1)-0.5;
			 }
			 else if((fromgreeting == 'pm' && togreeting == 'am')){
				 $scope.tofromgreeting = true;
				 $scope.days = '';
				 event.preventDefault();
			}
			else{
				 $scope.days                  = 0;
				 //diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
				 $scope.days = (countwithoutweekend+1);
			 }
		 }
  }
  
  /*http://stackoverflow.com/questions/3464268/find-day-difference-between-two-dates-excluding-weekend-days*/
  function calcBusinessDays(dDate1, dDate2) { // input given as Date objects
      var iWeeks, iDateDiff, iAdjust = 0;
      if (dDate2 < dDate1) return -1; // error code if dates transposed
      var iWeekday1 = dDate1.getDay(); // day of week
      var iWeekday2 = dDate2.getDay();
      iWeekday1 = (iWeekday1 == 0) ? 7 : iWeekday1; // change Sunday from 0 to 7
      iWeekday2 = (iWeekday2 == 0) ? 7 : iWeekday2;
		
      if ((iWeekday1 > 5) && (iWeekday2 > 5)) iAdjust = 1; // adjustment if both days on weekend
      iWeekday1 = (iWeekday1 > 5) ? 5 : iWeekday1; // only count weekdays
      iWeekday2 = (iWeekday2 > 5) ? 5 : iWeekday2;

      // calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
      iWeeks = Math.floor((dDate2.getTime() - dDate1.getTime()) / 604800000)

      if (iWeekday1 <= iWeekday2) {
        iDateDiff = (iWeeks * 5) + (iWeekday2 - iWeekday1)
      } else {
        iDateDiff = ((iWeeks + 1) * 5) - (iWeekday1 - iWeekday2)
      }

      iDateDiff -= iAdjust // take into account both days on weekend

      return (iDateDiff); // add 1 because dates are inclusive
  }
  
  $scope.saveleave = function(form,event){
		 if(form.$valid){
			 if($scope.tofromgreeting == true || $scope.todategreaterfromdate == true){
				 event.preventDefault();
			 }
			 else{
			   form.submit();
			 }
		 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
	 };
	 
	 $scope.resetapplyleave = function(){
			$scope.ephone     = '';
			$scope.lreason    = '';
			$scope.fromdate   = '';
			$scope.todate     = '';
			$scope.days       = '';
			$scope.fromdaygreeting  = 'am';
			$scope.todaygreeting    = 'pm';
			$('.error').css("display","none");
			$('#todaygreeting').attr('disabled','true');
			$('#fromdaygreeting').attr('disabled','true');
		};
			
});

mycontroller.controller('cancelleaveController', function($scope, $window, $location) {
	/*Grid and grid data for cancel Leave*/
	  $scope.init = function(data1) {
		    $scope.mySelections = [];
			$scope.gridData = data1;
			$scope.gridOptions = { 
		    		data: 'gridData',
		    		selectedItems: $scope.mySelections,
		    		multiSelect: false,
		    		showFooter:true,
		    		selectWithCheckboxOnly: false,
                    showSelectionCheckbox: true,
                    keepLastSelected: false,
                    showFilter:true,
                    afterSelectionChange: function (item, event) { $scope.selectleavetocancel = false; },
		    		columnDefs: [{field: 'fromDate', displayName: 'From Date', cellClass:'aligncolumn'},
		    		             {field: 'toDate', displayName: 'To Date', cellClass:'aligncolumn'},
		    		             {field: 'leaveType', displayName: 'Type', cellClass:'aligncolumn'},
		    		             {field: 'noOfDays', displayName: 'Total Days', cellClass:'aligncolumn'},
		    		             {field: 'status', displayName: 'Status', width:60, cellClass:'aligncolumn'},
		    		            ]
			       };
	  };
	  
	  $scope.submitcancelleave = function(form,event){
		  $scope.selectleavetocancel = false;
		 if(form.$valid){
			 if($scope.mySelections == ''){
				 $scope.selectleavetocancel = true;
				 event.preventDefault();
			 }
			   form.submit();
			 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
	};
	
	$scope.resetcancelleave = function(){
		$('.error').css("display","none");
		$('.ngSelectionCheckbox').attr("checked", false);
		$scope.mySelections = '';
        $scope.cnclreason   = '';
	};
});

mycontroller.controller('leavesummaryController', function($scope, $window, $location) {
	/*Grid and grid data for LeaveSummary*/
	  $scope.init = function(data1,data2) {
			$scope.gridData1 = data1;
			$scope.gridData2 = data2;
			$scope.gridOptions2 = { 
		    		data: 'gridData2',
		    		selectedItems: $scope.mySelections,
		    		multiSelect: false,
		    		showFooter:true,
		    		columnDefs: [{field: 'fromDate', displayName: 'From Date', width:95, cellClass:'aligncolumn'},
		    		             {field: 'toDate', displayName: 'To Date', width:95, cellClass:'aligncolumn'},
		    		             {field: 'noOfDays', displayName: 'Total Days', width:95, cellClass:'aligncolumn'},
		    		             {field: 'leaveType', displayName: 'Leave Type', width:95, cellClass:'aligncolumn'},
		    		             {field: 'status', displayName: 'Status', width:60, cellClass:'aligncolumn'},
		    		             {field: 'reason', displayName: 'Reason', resizable:false, cellClass:'aligncolumn'},
		    		            ]
			       };
			$scope.gridOptions1 = { 
					data: 'gridData1',
		    		multiSelect: false,
		    		showFooter:true,
		    		columnDefs: [{field: 'Type', displayName: 'Leave Type', cellClass:'aligncolumn'},
		    		             {field: 'Total', displayName: 'Total', cellClass:'aligncolumn'},
		    		             {field: 'Consumed', displayName: 'Consumed', cellClass:'aligncolumn'},
		    		             {field: 'Balance', displayName: 'Balance', cellClass:'aligncolumn'}
		    		             ]
			       };
	  };
});

mycontroller.controller('managerViewApprovedLeaveController', function($scope, $window, $location) {
	    $scope.selectleavetoapprove = false;
	    $scope.selectleavetoreject  = false;
	    $scope.myData1              = ' ';
	    
		$scope.init = function(data1) {
		$scope.gridData = [];
		$scope.gridData = data1;
		$scope.gridOptions = { 
	    		data: 'gridData',
	    		multiSelect: false,
	    		showFooter:true,
	    		columnDefs: [{displayName: '', cellClass:'aligncolumn', cellTemplate: '<input type="radio" name="view" id="view"  ng-click="assign(row)" value="View">', width:20,},
	    		             {field: 'empId', displayName: 'ID',cellClass:'aligncolumn',width:50,},
	    		             {field: 'empName', displayName: 'Name',cellClass:'aligncolumn',width:90,},
	    		             {field: 'leaveType', displayName: 'Leave Type',cellClass:'aligncolumn',width:95,},
	    		             {field: 'fromDate', displayName: 'From Date',cellClass:'aligncolumn',width:90,},
	    		             {field: 'fromDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'toDate', displayName: 'To Date',cellClass:'aligncolumn', width:90,},
	    		             {field: 'toDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'noOfDays', displayName: 'Days',cellClass:'aligncolumn',width:40,},
	    		             {field: '', displayName: 'Contact',cellClass:'aligncolumn',width:90,},
	    		             {field: 'leaveReason', displayName: 'Reason',cellClass:'aligncolumn'},
	    		             ]};
		 $scope.$on('ngGridEventData', function (e,s) {
	         $scope.gridOptions.selectItem(0,true);
	         $(".ngViewport").focus();
	     });
	};
	
	$scope.assign = function(row){
		$scope.myData1 = row.entity;
		$scope.selecteddata = [{"id": row.entity.id,"empId": row.entity.empId, "empName": row.entity.empName, "leaveType": row.entity.leaveType, "fromDate": row.entity.fromDate, "fromDateSession":row.entity.fromDateSession,
			                    "toDate": row.entity.toDate ,"toDateSession": row.entity.toDateSession, "noOfDays": row.entity.noOfDays, "status": row.entity.status, "approvalComment": row.entity.approvalComment}];
		$scope.selectleavetoapprove = false;
		$scope.selectleavetoreject  = false;
	};
	/*$scope.assign = function(row){
		$scope.myData1 = [{Type: row.entity.leaveType, Total: '30', Consumed: '20', Balance: '10'}];
	};

	$scope.gridOptions1 = {
	        data: 'myData1',
	        columnDefs: [{ field: "Type",displayName : "Type",cellClass:'aligncolumn' },
	                     { field: "Total", displayName : "Total",cellClass:'aligncolumn'},
	                     { field: "Consumed", displayName : "Consumed",cellClass:'aligncolumn'},
	                     { field: "Balance", displayName : "Balance",cellClass:'aligncolumn'},
	                    ]
	    };*/
	
	  $scope.approveleave = function(form,event){
		 if(form.$valid){
			 if($scope.myData1 == ' ' ){
				 $scope.selectleavetoapprove = true;
				 $scope.selectleavetoreject = false;
				 event.preventDefault();
			 }
			 else{
				 document.viewleavereq.action = "/lms-app/submitViewLeaveRequest1";
				 document.viewleavereq.submit();
			 }
			   
			 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
	};
	
	$scope.rejectleave = function (form,event){
		if(form.$valid){
			 if($scope.myData1 == ' ' ){
				 $scope.selectleavetoreject = true;
				 $scope.selectleavetoapprove = false;
				 event.preventDefault();
			 }
			 else{
				 document.viewleavereq.action = "/lms-app/submitViewLeaveRequest2";
				 document.viewleavereq.submit();
			 }
			   
			 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
	};
	
});

mycontroller.controller('viewRejectedLeaveController', function($scope, $window, $location) {
	/*Grid for rejectedlist by manager */
	$scope.init = function(data1) {
		$scope.gridData = [];
		$scope.gridData = data1;
		$scope.gridOptions = { 
	    		data: 'gridData',
	    		multiSelect: false,
	    		showFooter:true,
	    		columnDefs: [{field: 'empId', displayName: 'ID',cellClass:'aligncolumn',width:50,},
	    		             {field: 'empName', displayName: 'Name',cellClass:'aligncolumn',width:90,},
	    		             {field: 'leaveType', displayName: 'Leave Type',cellClass:'aligncolumn',width:95,},
	    		             {field: 'fromDate', displayName: 'From Date',cellClass:'aligncolumn',width:90,},
	    		             {field: 'fromDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'toDate', displayName: 'To Date',cellClass:'aligncolumn', width:90,},
	    		             {field: 'toDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'noOfDays', displayName: 'Days',cellClass:'aligncolumn',width:40,},
	    		             {field: 'status', displayName: 'Status',cellClass:'aligncolumn',width:60,},
	    		             {field: 'leaveReason', displayName: 'Reason',cellClass:'aligncolumn'},
	    		             ]};
	};
	
});

mycontroller.controller('viewApprovedLeaveController', function($scope, $window, $location) {
	/*Grid for rejectedlist by manager */
	$scope.init = function(data1) {
		$scope.gridData = [];
		$scope.gridData = data1;
		$scope.gridOptions = { 
	    		data: 'gridData',
	    		multiSelect: false,
	    		showFooter:true,
	    		columnDefs: [{field: 'empId', displayName: 'ID',cellClass:'aligncolumn',width:50,},
	    		             {field: 'empName', displayName: 'Name',cellClass:'aligncolumn',width:90,},
	    		             {field: 'leaveType', displayName: 'Leave Type',cellClass:'aligncolumn',width:95,},
	    		             {field: 'fromDate', displayName: 'From Date',cellClass:'aligncolumn',width:90,},
	    		             {field: 'fromDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'toDate', displayName: 'To Date',cellClass:'aligncolumn', width:90,},
	    		             {field: 'toDateSession', displayName: 'Session',cellClass:'aligncolumn',width:70,},
	    		             {field: 'noOfDays', displayName: 'Days',cellClass:'aligncolumn',width:40,},
	    		             {field: 'status', displayName: 'Status',cellClass:'aligncolumn',width:60,},
	    		             {field: 'leaveReason', displayName: 'Reason',cellClass:'aligncolumn'},
	    		             ]};
	};
	
});

mycontroller.controller('adduserController', function($scope, $window, $location) {
	$scope.olddate = function($event){
		$scope.dateishigher = false;
		if($scope.dateofjoin > new Date()){
			 $scope.dateishigher = true;
			 event.preventDefault();
		 }
		else{
			$scope.dateishigher = false;
		}
	};
	
	 $scope.saveuser = function(form,event){
		 if(form.$valid){
			 if($scope.dateofjoin > new Date()){
				 $scope.dateishigher = true;
				 event.preventDefault();
			 }
				 form.submit();
			 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
	};
	
	$scope.resetuser = function(){
		$('.error').css("display","none");
		$scope.ngfirstname = '';
        $scope.nglastname  = '';
        $scope.ngemail     = '';
        $scope.ngpassword  = '';
        $scope.dateofjoin  = '';
        $scope.ngdesignation = '';
        $scope.nglevel     = '';
        $scope.ngreportingto = '';
        $scope.ngaddress   = '';
        $scope.ngcity      = '';
        $scope.ngstate     = '';
        $scope.ngpincode   = '';
	};
	
});

function welcomeController($scope, $http) {
	$scope.oldpassword = false;
	$scope.newpassword = false;
	$scope.confirmpassword = false;
	console.log("Value "+$scope.oldpassword);
	
	$http.get('../json/EmployeeData.json').success(function(data) {
	    $scope.empdata = data;
	    $scope.loldpassword     = "Old Password:";
	    $scope.lnewpassword     = "New Password:";
	    $scope.lconfirmpassword = "Confirm Password:";
	    $scope.lsave            = "Save";
	    $scope.lreset           = "Reset";
	  });
  $scope.changepassword = function(form){
    $scope.showchangepassworddiv = true;
    $scope.showapplyleavediv = false;
    $scope.showcancelleavediv = false;
    $scope.showleavesummarydiv = false;
    
    $scope.oldpassword1 ='';
    $scope.newpassword1 ='';
    $scope.confirmpassword1 ='';
  };
  
  $scope.applyLeave = function(){
    $scope.showchangepassworddiv = false;
    $scope.showapplyleavediv = true;
    $scope.showcancelleavediv = false;
    $scope.showleavesummarydiv = false;
  };
  
  $scope.cancelLeave = function(){
    $scope.showchangepassworddiv = false;
    $scope.showapplyleavediv = false;
    $scope.showcancelleavediv = true;
    $scope.showleavesummarydiv = false;
  };
  
  $scope.leaveSummary = function(){
    $scope.showchangepassworddiv = false;
    $scope.showapplyleavediv = false;
    $scope.showcancelleavediv = false;
    $scope.showleavesummarydiv = true;
  };
  
  $scope.welcomeSubmit = function(form,$event){
	 
	  if(!(form.$valid)){
		 alert("form not valid");
		 $scope.oldpassword = true;
		 $scope.newpassword = true;
		 $scope.confirmpassword = true;
	  }
	  else{
		  alert("form is full valid");
		  alert($scope.oldpassword1);
		  $scope.oldpassword = false;
		  $scope.newpassword = false;
		  $scope.confirmpassword = false;
		  form.submit();
	}
	  
  };
  
  $scope.reset = function(welcome,$event){
		  $scope.oldpassword = false;
		  $scope.newpassword = false;
		  $scope.confirmpassword = false;
	  };
  
  
	  

}

