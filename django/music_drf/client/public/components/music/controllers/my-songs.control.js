music
        .controller('MySongsController', function($scope, MySongs){
                Songs.query().$promise.then(function(data) {
                        $scope.mySongs = data;
                });
});

