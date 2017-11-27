angular.module('moduleIndex', ['ngRoute', 'ngCookies', 'angular-md5'])

.controller('indexController', function($rootScope, $scope, $http, $timeout, $window, $cookies, $location) {
	
	$scope.ufObj = {};
	$scope.ufList = [];
	$scope.listaPessoa = [];
	$scope.nome = '';
	$scope.cpf = '';
	$scope.nascimento = '';
	$scope.peso = '';
	$scope.uf='';
	$scope.selectUF  = {};
	$scope.showloading = false;
	$scope.formCadastro;
	
	findListaUF();
	findListaPessoas();
	
	function findListaUF(){
		return $http.get('https://www.geonames.org/childrenJSON?geonameId=3469034')
		.then(function(response) {
				$scope.ufList = response.data.geonames;

				$timeout(function () {
		            $('select').material_select()
		         });

		}, function(response) {
//			Materialize.toast("Erro ao carregar Uf!", 3000, 'rounded orange accent-4' );
		});
	}
	
	function findListaPessoas(){
		return $http.get('/pessoaController/findAllPessoa')
		.then(function(response) {
				$scope.listaPessoa = response.data;
				console.log($scope.listaPessoa);

		}, function(response) {
			Materialize.toast("Erro ao carregar Uf!", 3000, 'rounded orange accent-4' );
		});
	}
	
	$scope.selecionaUF = function(estado){
		console.log(estado);
	}
	
	$scope.cadastrarPessoa = function() {
		if($scope.formCadastro.$invalid) {
			Materialize.toast('Preencha os campos obrigatórios!', 3000, 'rounded red darken-1' );
		} else {
			console.log($scope.listaPessoa);

			$scope.showloading = true;
			var pessoa = {};
			pessoa.nome = $scope.nome;
			pessoa.cpf = $scope.cpf;
			
			var data = new Date($scope.nascimento).getTime()/1000;
			pessoa.nascimento = data;

			pessoa.peso = $scope.peso;
			pessoa.uf = document.getElementById("select").value;
			console.log(pessoa);
			
			$http.post('/pessoaController/cadastrarPessoa', pessoa)
				.success(function(dataResponse, status, headers, response) {
					$scope.showloading = false;
					if(status == '200') {
						findListaPessoas();
						Materialize.toast(dataResponse, 3000, 'rounded green accent-4' );
					} else {
						Materialize.toast(dataResponse, 3000, 'rounded orange accent-4' );
					}
				}).error(function(data) {
					$scope.showloading = false;
					Materialize.toast(data, 3000, 'rounded red darken-1' );
			});
		}
	};
	
	$scope.removerPessoa = function(id){
		return $http.get('/pessoaController/removerPessoa/'+ id)
		.then(function(response) {
			findListaPessoas();
			Materialize.toast(response.data, 3000, 'rounded green accent-4' );
		}, function(response) {
			Materialize.toast(response.data, 3000, 'rounded orange accent-4' );
		});
	}
	
	

});
