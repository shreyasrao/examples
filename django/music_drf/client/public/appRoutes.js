angular
    .module('appRoutes', ["ui.router"])
    .config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

    $stateProvider.state({
        name: 'songs',
        url: '/',
        templateUrl: 'public/components/music/templates/songs.template',
        controller: 'SongsController'
    });

    $urlRouterProvider.otherwise('/');
}]);
