angular
    .module('appRoutes', ["ui.router"])
    .config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

    $stateProvider
    .state({
        name: 'songs',
        url: '/',
        templateUrl: 'public/components/music/templates/songs.template',
        controller: 'SongsController'
    })
    .state({
	name: 'mySongs',
	url: '/my-songs/',
	templateUrl: 'public/components/music/templates/my-songs.template',
	controller: 'MySongsController'


	})
    ;

    $urlRouterProvider.otherwise('/');
}]);
