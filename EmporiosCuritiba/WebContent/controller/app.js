angular.module('pgInicial', ['ngMaterial'])
.run(['$rootScope', function ($rootScope) {
   $rootScope.variavelGlobal = 'user@log.com';
   angular.module('md-datepicker', ['ngMaterial', 'ngMessages']).controller('clientesController', function() {
	   this.myDate = new Date();
	   this.isOpen = false;
	   
   }); 
}]);




