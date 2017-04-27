'use strict';

var App = angular.module('App', ['ngRoute']);

// App.factory('myHttpInterceptor', function($rootScope, $q) {
//   console.log("MyHTTPInterceptor function");
//   return {
//     'requestError': function(config) {
//       $rootScope.status = 'HTTP REQUEST ERROR ' + config;
//       return config || $q.when(config);
//     },
//     'responseError': function(rejection) {
//       $rootScope.status = 'HTTP RESPONSE ERROR ' + rejection.status + '\n' +
//                           rejection.data;
//       return $q.reject(rejection);
//     },
//   };
// });


App.factory('songService', function($rootScope, $http, $q, $log) {

    $rootScope.status = 'Retrieving Songs...';
  var deferred = $q.defer();
  $http.get('rest/query')
  .success(function(data, status, headers, config) {
    $rootScope.songs = data;
    deferred.resolve();
    console.log($rootScope.songs);
    console.log("Current Songs Query Resolved");
    $rootScope.status = '';
  });
  return deferred.promise;
});

App.factory('favService', function ($rootScope, $http, $q, $log) {
    $rootScope.flipped = false;
    console.log("Favorites Query Started");
    // $rootScope.status = 'Getting Favorite songs...';
    var deferred = $q.defer();
    $http.get('rest/favorites')
    .success(function (data, status, header, config) {
      $rootScope.favorites = data;
      deferred.resolve();
      console.log($rootScope.favorites);
      console.log("Favorites Query Resolved");
      $rootScope.status = '';
    });
    return deferred.promise;

});

App.config(function($routeProvider) {
  $routeProvider.when('/', {
    controller : 'MainCtrl',
    templateUrl: '/partials/main.html',
    resolve    : { 'songService': 'songService', 'favService':'favService' },
  });

  $routeProvider.when('/favorites', {
    controller  : 'FavsCtrl',
    templateUrl :'/partials/favorites.html',
    resolve     :{'favService':'favService'}
  });

  $routeProvider.when('/playlists', {
    templateUrl:'/partials/playlists.html'
  });

  // $routeProvider.when('/invite', {
  //   controller : 'InsertCtrl',
  //   templateUrl: '/partials/insert.html',
  // });
  // $routeProvider.when('/update/:id', {
  //   controller : 'UpdateCtrl',
  //   templateUrl: '/partials/update.html',
  //   resolve    : { 'guestService': 'guestService' },
  // });
  $routeProvider.otherwise({
    redirectTo : '/'
  });
});




App.controller('FavsCtrl', function ($scope, $rootScope, $log, $http, $routeParams, $location, $route) {

    $("#linkMenu").children(".linkItem").each(function () {
       $(this).attr('class', 'linkItem');
    });

    $("#favoritesLink").attr('class', 'linkItem active');

    console.log("Favs Ctrl loaded");
  console.log($rootScope.favorites);
  // console.log("var flipped is " + $rootScope.flipped);

  if($rootScope.flipped==true){
      console.log("Panel is flipped")
      $(".partial").css("padding-top","12em ");
  }

  // $(".partial").css("padding-top","12em ");

  // $scope.unlike = function(song){
  //   $rootScope.status = 'Removing ' + song.title + " from favorites. ID: " + song.id;
  //   $http.post('/rest/unlike',{'id':song.id})
  //       .success(function(data,status, headers, config){
  //         console.log("Song Unliked");
  //         console.log(song);
  //         for(var i=0; i<$rootScope.favorites.length; i++){
  //           if($rootScope.favorites[i].id == song.id){
  //             $rootScope.favorites.splice(i,1);
  //             break;
  //           }
  //         }
  //         $rootScope.status = '';
  //       });
  // }
});

App.controller('MainCtrl', function($scope, $rootScope, $log, $http, $routeParams, $location, $route) {

    $("#linkMenu").children(".linkItem").each(function () {
       $(this).attr('class', 'linkItem');
    });

    $("#songsLink").attr('class', 'linkItem active');

    console.log("Main Ctrl loaded");


  if($rootScope.flipped==true){
      console.log("Panel is flipped")
      $(".partial").css("padding-top","12em ");
  }

  $rootScope.unlike = function(song){
    console.log("STARTING UNLIKE PROCESS");
    $rootScope.status = 'Removing ' + song.title + " from favorites. ID: " + song.id;
    $http.post('/rest/unlike',{'id':song.id})
        .success(function(data,status, headers, config){
          console.log("Song Unliked");
          console.log(song);
          for(var i=0; i<$rootScope.favorites.length; i++){
            if($rootScope.favorites[i].id == song.id){
              $rootScope.favorites.splice(i,1);
              break;
            }
          }
          $rootScope.status = '';
        });
  }


  $rootScope.like = function(song) {
    $rootScope.status = 'Adding ' + song.title + " to favorites. ID: " + song.id;

    var needToAdd = true;

    for(var i=0; i < $rootScope.favorites.length; i++){
      if($rootScope.favorites[i].id == song.id){
        needToAdd = false;
        break;
      }
    }

    if(needToAdd){
      $http.post('/rest/like', {'id':song.id})
      .success(function(data, status, headers, config){
      console.log("Song Like Successful: ");
      console.log(data);
      $rootScope.favorites.push(data);
      });
    }
    $rootScope.status = '';

    // $location.path('/');
  };
  //
  // $scope.update = function(guest) {
  //   $location.path('/update/' + guest.id);
  // };
  //
  // $scope.delete = function(guest) {
  //   $rootScope.status = 'Deleting guest ' + guest.id + '...';
  //   $http.post('/rest/delete', {'id': guest.id})
  //   .success(function(data, status, headers, config) {
  //     for (var i=0; i<$rootScope.guests.length; i++) {
  //       if ($rootScope.guests[i].id == guest.id) {
  //         $rootScope.guests.splice(i, 1);
  //         break;
  //       }
  //     }
  //     $rootScope.status = '';
  //   });
  // };

});

App.directive("songItemDirective", function($rootScope) {
    return {
        restrict: "A",
        link: function($scope, elem, attrs) {
            $(elem).dblclick(function($scope) {
                console.log("song clicked");
                $rootScope.flipped = true;
                $(elem).children("#songData").each(function () {
                    $rootScope.title = $(this).attr("titleVal");
                    $rootScope.artist = $(this).attr("artistVal");
                    $rootScope.link = $(this).attr("linkVal");
                    // alert($scope.link);
                });
                // $rootScope.link = 'https://soundcloud.com/liluzivert/15-xo-tour-llif3';
                var iframe = document.querySelector('#playerFrame');
                iframe.src = 'http://w.soundcloud.com/player/?url=http://api.soundcloud.com/tracks/43315398&auto_play=true';

                $rootScope.widget = SC.Widget(iframe);
                $rootScope.widget.load($rootScope.link);

                $rootScope.widget.bind(SC.Widget.Events.READY, function(eventData) {
                                $rootScope.widget.play();
                });

                // alert($rootScope.title + " " + $rootScope.artist + " " + $rootScope.link);
                // $("#playerFrame").attr('src', $rootScope.link);

                // $rootScope.sc = SC.Widget("playerFrame");
                // sc.autoplay = true;
                // $rootScope.link += '&auto_play=true';
                // $rootScope.link = 'https://soundcloud.com/liluzivert/15-xo-tour-llif3';
                // $rootScope.sc.load($rootScope.link);
                $("#panel").slideDown("slow");
                $(".partial").css("padding-top","12em ");


                // $rootScope.sc.play();
            });
        }
    }
});


// $(document).ready(function(){
    // $(document).ready(function(){
    //     // $("#flip").click(function(){
    //     //
    //     //     $("#panel").slideDown("slow");
    //     //     $(".partial").css("padding-top","12em ");
    //     //
    //     // });
    //
    // });

    // $(".plusMinus").click(function(){
    //     $(this).children().each(function(){
    //     	if($(this).css("display")=="none"){
    //         	$(this).css("display","initial");
    //         }
    //         else{
    //         	$(this).css("display","none");
    //         }
    //     	}
    //     );
    // });
    //
    // $(".songItem").click(function(){
    //     alert("Song click");
    // });
// });

//
// App.controller('InsertCtrl', function($scope, $rootScope, $log, $http, $routeParams, $location, $route) {
//
//   $scope.submitInsert = function() {
//     var guest = {
//       first : $scope.first,
//       last : $scope.last,
//     };
//     $rootScope.status = 'Creating...';
//     $http.post('/rest/insert', guest)
//     .success(function(data, status, headers, config) {
//       $rootScope.guests.push(data);
//       $rootScope.status = '';
//     });
//     $location.path('/');
//   }
// });
//
// App.controller('UpdateCtrl', function($routeParams, $rootScope, $scope, $log, $http, $location) {
//
//   for (var i=0; i<$rootScope.guests.length; i++) {
//     if ($rootScope.guests[i].id == $routeParams.id) {
//       $scope.guest = angular.copy($rootScope.guests[i]);
//     }
//   }
//
//   $scope.submitUpdate = function() {
//     $rootScope.status = 'Updating...';
//     $http.post('/rest/update', $scope.guest)
//     .success(function(data, status, headers, config) {
//       for (var i=0; i<$rootScope.guests.length; i++) {
//         if ($rootScope.guests[i].id == $scope.guest.id) {
//           $rootScope.guests.splice(i,1);
//           break;
//         }
//       }
//       $rootScope.guests.push(data);
//       $rootScope.status = '';
//     });
//     $location.path('/');
//   };
//
// });

