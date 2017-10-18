var produtosModulo = angular.module('produtosModulo', []);
produtosModulo.controller("produtosController", function($scope, $http) {

	/*urlProduto = "http://104.198.248.92:8080/EmporiosCuritiba/WS/Produto";*/
	urlProduto = "http://localhost:8080/EmporiosCuritiba/WS/Produto";
	$scope.listarProdutos = function() {
		$http.get(urlProduto+"/Pesquisar").then(function(response) {
            $scope.produtos = response.data.lista;
            
		});
		if ($scope.listarProdutos == null){
			alert("lista vazia")
		}
	}

	$scope.selecionaProduto = function(produtoSelecionado) {
		$scope.produto = produtoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.produto = "";
	}

	$scope.gravar = function() {

		if ($scope.produto.id == undefined) {
			$http.post(urlProduto+"/Criar", $scope.produto).then(function(response) {
			alert(response.data.mensagem);
			if (response.data.ok == true){
				{window.location='/EmporiosCuritiba/';}
			}
			$scope.listarProdutos();
			$scope.limparCampos();
				}).error(function(erro) {
			console.log(err);
			});
		} else {
			// alert("PUT *** verificado codigo para alterar registro");
			// console.log("PUT *** verificado codigo para alterar registro");
			$http.put(urlProduto+"/Atualizar", $scope.produto).success(function(produto) {
				$scope.produtos.push($scope.produto);
				$scope.listarProdutos();
				$scope.limparCampos();
					}).error(function(erro) {
				alert(erro)
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.produto.codigo == undefined) {
			// alert("Favor selecionar um registro para poder excluir");
			// console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlProduto+"/Remover"+$scope.produto.id).success(function () {
				 $scope.listarProdutos();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	// executa
	$scope.listarProdutos();
});