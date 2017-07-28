music
	.controller('SongsController', function($scope, Songs, MySongs){
		Songs.query().$promise.then(function(data) {
			$scope.songs = data;
		});
});
