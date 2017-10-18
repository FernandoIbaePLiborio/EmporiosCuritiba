var aloMundo = angular.module('aloMundo', [ 'ngMaterial' ]);
aloMundo.controller('ToastEx', function($scope, $mdToast) {
	$mdToast.show($mdToast.simple('Seja bem vindo').position('left bottom')
			.hideDelay(3000)

	);
	angular.module('aloMundo').config(function($mdDateLocaleProvider) {
		$mdDateLocaleProvider.formatDate = function(date) {
			return moment(date).format('dd-mm-yyyy');
		};
	});
});