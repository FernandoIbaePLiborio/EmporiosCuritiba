var clientesModulo = angular.module('clientesModulo', ['ngMaterial']);
clientesModulo.controller("clientesController", function($scope, $http) {

		/*function dateController ($scope) {
         $scope.myDate = new Date();
         $scope.minDate = new Date(
            $scope.myDate.getFullYear(),
            $scope.myDate.getMonth() - 2,
            $scope.myDate.getDate());
         $scope.maxDate = new Date(
            $scope.myDate.getFullYear(),
            $scope.myDate.getMonth() + 2,
            $scope.myDate.getDate());
         $scope.onlyWeekendsPredicate = function(date) {
            var day = date.getDay();
            return day === 0 || day === 6;
         }
      }*/
	/* urlCliente = "http://104.198.248.92:8080/EmporiosCuritiba/WS/Cliente"; */
	urlCliente = "http://localhost:8080/EmporiosCuritiba/WS/Cliente";
	$scope.listarClientes = function() {
		$http.get(urlCliente+"/Pesquisar").then(function(response) {
            $scope.clientes = response.data.lista;
		});
		if ($scope.listarClientes == null){
			alert("lista vazia")
		}
	}

	$scope.selecionaCliente = function(clienteSelecionado) {
		$scope.cliente = clienteSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.cliente = "";
	}

	$scope.gravar = function() {
		if ($scope.cliente.id == undefined) {
			$http.post(urlCliente+"/Criar", $scope.cliente).then(function(response) {
				alert(response.data.mensagem);
					if (response.data.ok == true){
						alert(response.data.mensagem);
						{window.location='/EmporiosCuritiba/';}
					}
					$scope.limparCampos();
				}).error(function(erro) {
			console.log(err);
			});
		} else {
			$http.put(urlCliente+"/Atualizar", $scope.cliente).success(function(cliente) {
				$scope.produtos.push($scope.cliente);
				$scope.listarClientes();
				$scope.limparCampos();
					}).error(function(erro) {
				alert(erro)
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.codigo == undefined) {
			// alert("Favor selecionar um registro para poder excluir");
			// console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlCliente+"/Remover"+$scope.produto.id).success(function () {
				 $scope.listarClientes();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	// executa
	$scope.listarClientes();
});