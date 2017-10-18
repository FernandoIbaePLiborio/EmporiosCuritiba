var usuariosModulo = angular.module('usuariosModulo', []);
usuariosModulo.controller("usuariosController", function($scope, $http) {

	/*
	 * urlUsuario =
	 * "http://104.198.248.92:8080/EmporiosCuritiba/WS/Autenticacao";
	 */
	urlUsuario = "http://localhost:8080/EmporiosCuritiba/WS/Autenticacao";
	$scope.listarUsuarios = function() {
		$http.get(urlUsuario + "/Pesquisar").then(function(response) {
			$scope.usuarios = response.data.lista;
		});
		if ($scope.listarUsuarios == null) {
			alert("lista vazia")
		}
	}

	$scope.selecionaUsuario = function(usuarioSelecionado) {
		$rootScope.usuarioLogado = usuarioSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.usuario = "";
	}

	$scope.gravar = function() {
		if ($scope.usuario.id == undefined) {
			$scope.crypto($scope.usuario.senha)
			$http.post(urlUsuario + "/Criar", $scope.usuario).then(function(response) {
				alert(response.data.mensagem);
						if (response.data.ok == true){
							alert(response.data.mensagem);
							window.location = '/EmporiosCuritiba/';
						}
						$scope.limparCampos();
					}).error = function(erro) {
				console.log(err);
			};
		} else {
			// $scope.crypto($scope.usuario.senha)
			$http.put(urlUsuario + "/Atualizar", $scope.usuario).success(
					function(usuario) {
						alert(response.data.mensagem);
						if (response.data.ok == true)
							window.location = '/EmporiosCuritiba/';
					}).error = function(erro) {
				console.log(err);
			};
		}
	}

	$scope.logar = function() {
		$scope.crypto($scope.usuario.senha)
		$http.post(urlUsuario + "/Login", $scope.usuario).then(
				function(response) {
					$scope.limparCampos();
					alert(response.data.mensagem);
					if (response.data.ok == true) {
						// $scope.selecionaUsuario($scope.usuario.email);
						// window.localStorage.setItem('usuarioLogado',
						// $scope.usuario.email);
						// alert(window.localStorage.getItem('usuarioLogado'));
						// $scope.usuario.email
						window.location = '/EmporiosCuritiba/';
					}
				}).error = function(erro) {
			console.log(err);
		};
	}

	$scope.obterUsuarioLogado = function() {
		$http.get(urlUsuario + "/ObterUsuarioLogado").then(function(response) {
			/* alert(response.data.mensagem); */
			$scope.usuarioLog = response.data.mensagem;
			/* alert($scope.usuario.email); */
		}).error = function(erro) {
			console.log(response.data.mensagem);
		};
	}

	/*
	 * $scope.logout = function() { $scope.crypto($scope.usuario.senha)
	 * $http.post().then(function(response) { alert(response.data.mensagem); if
	 * (response.data.ok == true){ {window.location='/EmporiosCuritiba/';} }
	 * 
	 * $scope.limparCampos(); }).error(function(erro) { console.log(err); }); }
	 */

	$scope.crypto = function(senha) {
		$scope.hash = CryptoJS.MD5(senha);
		var str = $scope.hash;
		$scope.usuario.senha = str.toString();
	}
	$scope.obterUsuarioLogado();
});