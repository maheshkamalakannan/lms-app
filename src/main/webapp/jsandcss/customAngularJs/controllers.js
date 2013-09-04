'use strict';

var mycontroller = angular.module('mainController', ['ngGrid','$strap.directives']);

/* Directives */
/* Allowing only number in textbox */
mycontroller.directive('uiMask', function() {
	return {
        require: 'ngModel',

        link: function(scope, element, attrs, controller) {
                element.mask(attrs.uiMask, {completed  :function()
                    {
                      scope.$apply(controller.$setViewValue(this.val()));
                    }}
                );
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

mycontroller.directive('makeReadonly', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
        	$(element).attr("disabled", true);
        	$(element).css("background-color", "#FFFFFF");
        }
    };
});

mycontroller.directive('ngBlur', function() {
	  return function( scope, elem, attrs ) {
	    elem.bind('blur', function() {
	      scope.$apply(attrs.ngBlur);
	    });
	  };
	});
mycontroller.directive('ngFocus', function( $timeout ) {
	  return function( scope, elem, attrs ) {
	    scope.$watch(attrs.ngFocus, function( newval ) {
	      if ( newval ) {
	        $timeout(function() {
	          elem[0].focus();
	        }, 0, false);
	      }
	    });
	  };
	});

mycontroller.directive('capitalizeFirst', function(uppercaseFilter) {
	   return {
	     require: 'ngModel',
	     link: function(scope, element, attrs, modelCtrl) {
	        var capitalize = function(inputValue) {
	           var capitalized = inputValue.charAt(0).toUpperCase() +
	               inputValue.substring(1);
	           if(capitalized !== inputValue) {
	              modelCtrl.$setViewValue(capitalized);
	              modelCtrl.$render();
	            }         
	            return capitalized;
	         }
	         modelCtrl.$parsers.push(capitalize);
	         capitalize(scope[attrs.ngModel]);
	     }
	   };
	});

mycontroller.directive('numOnly', function(){
	   return {
	     require: 'ngModel',
	     link: function(scope, element, attrs, modelCtrl, event) {
	         modelCtrl.$parsers.push(function (inputValue) {
	           if (inputValue == undefined){
	        	   return '' ;
	           }
	           var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
	           if (transformedInput!=inputValue) {
	              modelCtrl.$setViewValue(transformedInput);
	              modelCtrl.$render();
	           }         
	           return transformedInput;         
	       });
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
    
    $scope.emailnotexists                    = "Email Address Does Not Exists.";
    $scope.firstname                         = "First Name :";
    $scope.lasttname                         = "Last Name :";
    $scope.empid                             = "Employee ID :";
    $scope.contact                           = "Contact :";
    $scope.admpassword                       = "Password :";
    $scope.secemail                          = "Secondary Email :";
    $scope.joindateincorrect                 = "Joining Date is Incorrect.";
    $scope.department                        = "Department :";
    $scope.role                              = "Role :";
    $scope.address                           = "Address :";
    $scope.city                              = "City :";
    $scope.state                             = "State :";
    $scope.pincode                           = "Pincode :";
    $scope.mandatoryfields                   = "All fields are mandatory.";
    $scope.pinlength                         = "Pincode must be 6 digits";
    
    
    $scope.hometab                       = "Home";
    $scope.changepasswordtabs            = "Home > Settings > Change Password";
    $scope.applyleavetab                 = "Home > Leaves > Apply Leave";
    $scope.cancelleavetab                = "Home > Leaves > Cancel Leave";
    $scope.leavesummarytab               = "Home > Leave Summary";
    
    $scope.viewleaverequest              = "Home > Leave > View Leave Requests";
    $scope.viewapprovedleaves            = "Home > Reports > View Approved Leaves";
    $scope.viewrejectedleaves            = "Home > Reports > View Rejected Leaves";
    
    $scope.adminadduser                  = "Home > Users > Add User";
    $scope.adminmoduser                  = "Home > Users > Modify User";
    $scope.admindeluser                  = "Home > Users > Delete User";
    $scope.adminsetleavetype             = "Home > Configuration > Set Level Type";
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
	  $scope.phoneminlen           = false;
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
  
  $scope.hideerror = function(){
	  $scope.phoneminlen           = false;
  };
  
  $scope.saveleave = function(form,event){
		 if(form.$valid){
			 if($scope.tofromgreeting == true || $scope.todategreaterfromdate == true){
				 event.preventDefault();
			 }
			 else if($scope.ephone.length < 8){
				 $scope.phoneminlen = true;
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
		    $scope.selecteddata  = '';
			$scope.gridData      = data1;
			$scope.gridOptions = { 
		    		data: 'gridData',
		    		multiSelect: false,
		    		showFooter:true,
		    		columnDefs: [{displayName: '', cellClass:'aligncolumn', cellTemplate: '<input type="radio" name="cancel" id="cancel" ng-model="ngcancel" ng-click="assign(row)" value="cancel">', width:20,},
		    		             {field: 'fromDate', displayName: 'From Date', cellClass:'aligncolumn'},
		    		             {field: 'toDate', displayName: 'To Date', cellClass:'aligncolumn'},
		    		             {field: 'leaveType', displayName: 'Leave Type', cellClass:'aligncolumn'},
		    		             {field: 'noOfDays', displayName: 'Total Days', cellClass:'aligncolumn'},
		    		             {field: 'status', displayName: 'Status', width:60, cellClass:'aligncolumn'},
		    		            ]
			       };
			$scope.assign = function(row){
				$scope.myData1 = row.entity;
				$scope.selecteddata = [{"id":row.entity.id,"fromDate": row.entity.fromDate,"fromDateSession":row.entity.fromDateSession,"toDate": row.entity.toDate,"toDateSession":row.entity.toDateSession,"noOfDays": row.entity.noOfDays,"leaveType": row.entity.leaveType,"action":row.entity.action,"status": row.entity.status,"reason":row.entity.reason,"empId":row.entity.empId,"empName":row.entity.empName}];
				$scope.selectleavetocancel = false;
			};
	  };
	  
	  $scope.submitcancelleave = function(form,event){
		  $scope.selectleavetocancel = false;
		 if(form.$valid){
			 if($scope.selecteddata == ''){
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
        $scope.selecteddata = '';
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

mycontroller.controller('ViewLeaveRequestsController', function($scope, $window, $location) {
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
		
		$scope.myData1 = [{Type: row.entity.leaveType, Total: '30', Consumed: '20', Balance: '10'}];
	};
	/*$scope.assign = function(row){
		$scope.myData1 = [{Type: row.entity.leaveType, Total: '30', Consumed: '20', Balance: '10'}];
	};*/

	$scope.gridOptions1 = {
	        data: 'myData1',
	        columnDefs: [{ field: "Type",displayName : "Type",cellClass:'aligncolumn' },
	                     { field: "Total", displayName : "Total",cellClass:'aligncolumn'},
	                     { field: "Consumed", displayName : "Consumed",cellClass:'aligncolumn'},
	                     { field: "Balance", displayName : "Balance",cellClass:'aligncolumn'},
	                    ]
	    };
	
	  $scope.approveleave = function(form,event){
		 if(form.$valid){
			 if($scope.myData1 == ' ' ){
				 $scope.selectleavetoapprove = true;
				 $scope.selectleavetoreject = false;
				 event.preventDefault();
			 }
			 else{
				 $('form').attr("action","/lms-app/submitViewLeaveRequest1");
				 $('form').submit();
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
				 $('form').attr("action","/lms-app/submitViewLeaveRequest2");
				 $('form').submit();
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
		
		 $scope.$on('ngGridEventData', function (e,s) {
	         $scope.gridOptions.selectItem(0,true);
	         $(".ngViewport").focus();
	     });
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
		
		 $scope.$on('ngGridEventData', function (e,s) {
	         $scope.gridOptions.selectItem(0,true);
	         $(".ngViewport").focus();
	     });
	};
	
});

mycontroller.controller('adduserController', function($scope, $window, $location) {
	$scope.pinminlen = false;
	
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
	
	$scope.hideerror = function(){
		$scope.pinminlen = false;
	};
	
	 $scope.saveuser = function(form,event){
		 if(form.$valid){
			 if($scope.dateofjoin > new Date()){
				 $scope.dateishigher = true;
				 event.preventDefault();
			 }
			 else if($scope.ngpincode.length < 6){
				 $scope.pinminlen = true;
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
        $scope.ngsecemail  = '';
        $scope.ngempid     = '';
        $scope.ngphone     = '';
	};
	
});

mycontroller.controller('modifyUserController', function($scope, $window, $location) {
	$scope.showdiv       = false;
	$scope.userexistence = false;
	$scope.ngsearch      = true;
	$scope.ngsearchemail = '';
	$scope.searchuser = function(form,data){
		var user = $scope.ngsearchemail;
		if((user != "") && (!form.$error.email)){
		 $.ajax({
             type: "POST",
             url:  location.protocol + "//" + location.host+"/lms-app/submitSearchUser",
             data: "searchEmail=" + user,
             async: false,
             success: function(response) {
            	 if(response.status == "SUCCESS") {
            	    	  $scope.showdiv = true;
            	    	  $scope.ngsearch= false;
            	    	  $('.error').css("display","none");
            	    	  
            	    	  $scope.ngfirstname = response.result[0].firstname;  $scope.nglastname    = response.result[0].lastname;
            	          $scope.ngnewEmpId  = response.result[0].newEmpId;   $scope.ngemail       = response.result[0].email;  
            	    	  $scope.ngpassword  = response.result[0].password;   $scope.ngsecemail    = response.result[0].secemail;   
            	    	  $scope.ngaddress   = response.result[0].address;    $scope.ngcity        = response.result[0].city;
            	    	  $scope.ngstate	 = response.result[0].state;      $scope.ngpincode     = response.result[0].pincode;
            	    	  $scope.ngdateofjoin= response.result[0].dateofjoin; $scope.nguserId      = response.result[0].userId;
            	    	  //combos
            	    	  $('select[name="reportingto"]' ).val(response.result[0].reportingto);      
            	    	  $('select[name="dept"]' ).val(response.result[0].dept);
            	    	  $('select[name="desig"]' ).val(response.result[0].desig);
            	    	  $('select[name="role"]' ).val(response.result[0].role);
            	    	  $('input[name="userId"]' ).val(response.result[0].userId); 
            	      }
            	      else{
            	    	  $scope.userexistence = true;
            	    	  $scope.showdiv = false;
            	      }
                     },
             error: function(e){
                     alert('no party');
                     }
             });
		}
		else{
			event.preventDefault();
		}
	};
	
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
	
	$scope.takeuserback = function(){
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
        $scope.ngsecemail  = '';
        $scope.ngempid     = '';
        $scope.ngphone     = '';
        $scope.ngsearchemail = '';
		$scope.showdiv       = false;
		$scope.ngsearch      = true;
	};
	
	$scope.updateuser = function(form,event){
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
	
	$scope.changeEmail = function(){
		$scope.userexistence = false;
	};
});

mycontroller.controller('setLeaveTypeController', function($scope, $window, $location) {
	$scope.showleavediv = false;
	/*$scope.init = function(data1) {
		$scope.gridData = [];
		$scope.gridData = data1;
		$scope.gridOptions = { 
	    		data: 'gridData',
	    		multiSelect: false,
	    		showFooter:true,
	    		columnDefs: [{field: 'Name', displayName: 'Name',cellClass:'aligncolumn',width:50,},
	    		             {field: 'Description', displayName: 'Description',cellClass:'aligncolumn',width:90,},
	    		             {field: 'Days', displayName: 'Days',cellClass:'aligncolumn',width:95,}
	    		             ]};
		
		 $scope.$on('ngGridEventData', function (e,s) {
	         $scope.gridOptions.selectItem(0,true);
	         $(".ngViewport").focus();
	     });
	};*/
	$scope.gridData =[{Name:"CL",Description:"Something",Days:"20"},
	                  {Name:"EL",Description:"again Something",Days:"10"}];
	$scope.gridOptions = { 
    		data: 'gridData',
    		multiSelect: false,
    		showFooter:true,
    		columnDefs: [{field: 'Name', displayName: 'Name',cellClass:'aligncolumn'},
    		             {field: 'Days', displayName: 'Days',cellClass:'aligncolumn'},
    		             {field: 'Description', displayName: 'Description',cellClass:'aligncolumn'},
    		             {displayName: 'Delete', cellClass:'aligncolumn', cellTemplate: '<input type="radio" name="view" id="view"  ng-click="deleterow(row)" value="View">', width:60,},
    		             {displayName: 'Modify', cellClass:'aligncolumn', cellTemplate: '<input type="radio" name="view" id="view"  ng-click="modifyrow(row)" value="View">', width:60,},
    		             ]};
	
	 $scope.$on('ngGridEventData', function (e,s) {
         $scope.gridOptions.selectItem(0,true);
         $(".ngViewport").focus();
     });
	 
	$scope.deleterow = function(row){
		$scope.selecteddata = [{"Name": row.entity.Name,"Description": row.entity.Description, "Days": row.entity.Days}];
	};
	
	$scope.modifyrow = function(row){
		$scope.showleavediv = true;
		$scope.ngleaveName  = row.entity.Name;
		$scope.ngleavedesc  = row.entity.Description;
		$scope.ngleavedays  = row.entity.Days;
	};
	
	$scope.createleavetype = function(event){
		$scope.showleavediv = true;
		$scope.ngleaveName  = '';
		$scope.ngleavedesc  = '';
		$scope.ngleavedays  = '';
	};
	
	$scope.cancelleavetype = function(){
		$scope.showleavediv = false;
		$scope.ngleaveName  = '';
		$scope.ngleavedesc  = '';
		$scope.ngleavedays  = '';
	};
	
	$scope.saveleavetype = function(form,event){
		if(form.$valid){
				 form.submit();
			 }
		 else{
			 $('.success').css("display","none");
			 event.preventDefault();
		 }
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

