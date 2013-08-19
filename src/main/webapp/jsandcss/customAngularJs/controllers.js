'use strict';

/* Controllers */

function loginController($scope) {
  $scope.loginSubmit = function(form,event){
     if(form.$valid){
	   form.submit();
	 }
	 else{
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
    
    
    $scope.changepasswordtabs            = "Home > Settings > Change Password";
    $scope.hometabs                      = "Home > Leaves > Apply Leaves";
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

mycontroller.controller('gridCtrl', function($scope) {
	$scope.gridData = [{Type: "CL", Total: 10, Consumed: 5, Balance: 2},
	                   {Type: "EL", Total: 10, Consumed: 5, Balance: 2}];
    
    $scope.gridOptions = { 
    		data: 'gridData',
    		multiSelect: false};
});

mycontroller.controller('applyLeaveController', function($scope, $window, $location) {
	  $scope.todategreaterfromdate = false;
	  var diff                     = "";
	  $scope.tofromgreeting        = false;
	  $scope.leaves = [
	                     {LeaveCode : 'CL', LeaveName : 'Casual Leave' },       
	                     {LeaveCode : 'EL', LeaveName : 'Earned Leave' }];
	  $scope.leavetype        = 'CL';
	  $scope.fromdaygreeting  = 'am';
	  $scope.todaygreeting    = 'pm';
	  /*$scope.fromdate         = new Date();
	  $scope.todate           = new Date();
	  $scope.days             = 1;*/
	  
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
				$('#fromdaygreeting').removeAttr('disabled');
				$('#todaygreeting').removeAttr('disabled');
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
			    diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (diff+1)-0.5;
		 }
		 else if((fromgreeting == 'am' && togreeting == 'pm') && ($scope.fromdate < $scope.todate)){
			    $scope.days                  = 0;
			    diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (diff+1);
		 }
		 else if((fromgreeting == 'pm' && togreeting == 'am') && ($scope.fromdate < $scope.todate)){
			    $scope.days                  = 0;
			    diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
			    $scope.days = (diff);
		 }
		 else if(($scope.fromdate > $scope.todate)){
			 console.log(" from date is greater not applicable");
		 }
		 else{
			 if((fromgreeting == 'pm' && togreeting == 'pm') || (fromgreeting == 'am' && togreeting == 'am')){
				 $scope.days                  = 0;
				 diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
				 $scope.days = (diff+1)-0.5;
			 }
			 else if((fromgreeting == 'pm' && togreeting == 'am')){
				 $scope.tofromgreeting = true;
				 $scope.days = '';
				 event.preventDefault();
			}
			else{
				 $scope.days                  = 0;
				 diff = Math.floor(( $scope.todate - $scope.fromdate ) / 86400000);
				 $scope.days = (diff+1);
			 }
		 }
  }
		  
  function countSatSun(start, end){
			  var weekendcount = 0;
			  if(end < start){
				  return;
			  }
			  for(var count = {sun:0, sat:0}; start < end; start.setDate(start.getDate() + 1)){
				if(start.getDay() == 0){
					 // count.sun++;
					weekendcount++;
				}
				else if(start.getDay() == 6){
					//count.sat++;
					weekendcount++;
				}
			 }
			  return weekendcount;
		}
  
  $scope.saveleave = function(form,event){
		 if(form.$valid){
			 form.submit();
		 }
		 else{
			 $scope.tofromgreeting        = false;
			 event.preventDefault();
		 }
	 };
	 
	 $scope.resetapplyleave = function(){
			$scope.ephone     = '';
			$scope.lreason    = '';
			$scope.fromdate   = '';
			$scope.todate     = '';
			$('.error').css("display","none");
			$('#todaygreeting').attr('disabled','true');
			$('#fromdaygreeting').attr('disabled','true');
		};
});

function applyLeaveController($scope){
	 
}
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

