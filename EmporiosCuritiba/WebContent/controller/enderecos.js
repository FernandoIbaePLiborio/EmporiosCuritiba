var enderecosModulo = angular.module('enderecosModulo', []);
enderecosModulo.controller("enderecosController", function($scope, $http) {

	/* urlEndereco = "http://104.198.248.92:8080/EmporiosCuritiba/WS/Endereco"; */
	cep = "https://viacep.com.br/ws/"; 
	tipo = "/json/";
	urlEndereco = "http://localhost:8080/EmporiosCuritiba/WS/Endereco";
	$scope.listarEnderecos = function() {
		$http.get(urlEndereco+"/Pesquisar").then(function(response) {
            $scope.enderecos = response.data.lista;
		});
		if ($scope.listarEnderecos == null){
			alert("lista vazia")
		}
	}
	$scope.selecionaEndereco = function(enderecoSelecionado) {
		$scope.endereco = enderecoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.endereco = "";
	}

	$scope.buscaCEP = function(){
		var cepLimpo = $scope.endereco.cep.replace(/\-/g,'');
		var cepLimpo = cepLimpo.replace(/\./g,'');
		$http.get(cep+cepLimpo+tipo).success(function(response) {
			$scope.endereco = response;
			}).error(function(erro) {
		console.log(err);
		});
	}
	
	$scope.gravar = function() {
		if ($scope.endereco.id == undefined) {
			var end = new Object();
			end.cep = $scope.endereco.cep.replace(/\-/g,'');
			end.logradouro = $scope.endereco.logradouro;
			end.numero = $scope.endereco.numero;
			end.complemento = $scope.endereco.complemento;
			end.bairro = $scope.endereco.bairro;
			end.localidade = $scope.endereco.localidade;
			end.uf = $scope.endereco.uf;
			$http.post(urlEndereco+"/Criar",end).then(function(response) {
				alert(response.data.mensagem);
					if (response.data.ok == true){
						{window.location='/EmporiosCuritiba/';}
						$scope.limparCampos();
					}
				}).error(function(erro) {
			console.log(err);
			});
		} else {
			// alert("PUT *** verificado codigo para alterar registro");
			// console.log("PUT *** verificado codigo para alterar registro");
			$http.put(urlEndereco+"/Atualizar", $scope.endereco).success(function(endereco) {
				$scope.produtos.push($scope.endereco);
				$scope.listarEnderecos();
				$scope.limparCampos();
					}).error(function(erro) {
				alert(erro)
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.endereco.codigo == undefined) {
		} else {
			$http.delete(urlEndereco+"/Remover"+$scope.produto.id).success(function () {
				 $scope.listarEnderecos();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
});