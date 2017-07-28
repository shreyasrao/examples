music
        .controller('MySongsController', function($scope, MySongs){
                MySongs.query().$promise.then(function(data) {
                        $scope.mySongs = data;
                });
});

