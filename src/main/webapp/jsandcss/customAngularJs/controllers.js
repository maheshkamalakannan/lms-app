'use strict';

/* Controllers */

function loginController($scope) {
  $scope.loginSubmit = function(form,event){
     if(form.$valid){
	   form.submit();
	 }
	 else{
	  $('.alert-error').hide();	 
	  event.preventDefault();
	 }
  };
}

function constantsController($scope){
	$scope.emailrequired     = "Email address is required.";
	$scope.invalidemail      = "Invalid Email address.";
	$scope.passwordrequired  = "Password is required.";
    $scope.signin            = "Sign In";
    
    $scope.newpasswordrequired           = "New Password is required.";
    $scope.newpasswordminlength          = "Password must be 7 characters.";
    $scope.confirmationpasswordrequired  = "Confirm Password is required.";
    $scope.confirmationpassword          = "Current password and New Password are same.";
    $scope.passwordmismatch              = "Passwords do not match.";
    
    $scope.fromdaterequired              = "From date Required.";
    $scope.todaterequired                = "To date Required.";
    $scope.tofromcombination             = "This combination not allowed.";
    $scope.todategreater                 = "To-date should be greater.";
    $scope.phonerequired                 = "Phone number Required.";
    $scope.leavereasonrequired           = "Leave Reason Required.";
    $scope.daygreeting1                  = "AM";
    $scope.daygreeting2                  = "PM";
    
    
    $scope.hometab                       = "Home";
    $scope.changepasswordtabs            = "Home > Settings > Change Password";
    $scope.applyleavetab                 = "Home > Leaves > Apply Leave";
    $scope.cancelleavetab                = "Home > Leaves > Cancel Leave";
    $scope.leavesummarytab               = "Home > Leave Summary";
}
function changePasswordController($scope){
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
}

var mycontroller = angular.module('mainController', ['ngGrid','$strap.directives']);

/*mycontroller.controller('applyleavegrid', function($scope) {
	
});*/
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
		    		columnDefs: [{field: 'Type', displayName: 'Type'},
		    		             {field: 'Total', displayName: 'Total'},
		    		             {field: 'Consumed', displayName: 'Consumed'},
		    		             {field: 'Balance', displayName: 'Balance'}
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
			$scope.gridData = data1;
			$scope.gridOptions = { 
		    		data: 'gridData',
		    		multiSelect: false,
		    		showFooter:true,
		    		columnDefs: [{field: 'fromDate', displayName: 'From Date'},
		    		             {field: 'toDate', displayName: 'To Date'},
		    		             {field: 'noOfDays', displayName: 'Total Days'},
		    		             {displayName: 'Action', cellTemplate: '<input type="radio" ng-model="cancelleave" name="cancelleave" id="cancelleave">'}
		    		             ]};
	  };
	  
	  $scope.cancelleave = function(form,event){
		 if(form.$invalid){
			   form.submit();
			 }
		 else{
			 event.preventDefault();
		 }
	};
	
	$scope.resetcancelleave = function(){
		$('.error').css("display","none");
        $scope.cnclreason = '';
	};
});

mycontroller.controller('leavesummaryController', function($scope, $window, $location) {
	 /*JS for leavesummary page*/
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

