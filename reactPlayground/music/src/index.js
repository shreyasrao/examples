import React from 'react';
import ReactDOM from 'react-dom';
import './app.css';
import angular from 'angular';
import { Component } from 'react'
import { react2angular } from 'react2angular'
//import './songlist.js';




var SONGQUERY = [
      {index:0,title:"BARF",artist:"Drizzy"},
      {index:1,title:"HEROOOOR",artist:"FUK"}
]


function Song(props){
  return(
<section layout="row" layout-sm="column" layout-align="center center" layout-wrap  onDoubleClick={props.onClick}>
      <span>{props.song.index}</span>
      <span>{props.song.title}</span>
      <span>{props.song.artist}</span>
</section>
  );

}

class SongList extends React.Component {
  constructor(){
    super();
    this.state={
      currentSong : null,
	songs : SONGQUERY,
    };
  }


  handleDoubleClick(i) {
    // var curSong = this.state.currentSong + "playing";
    var curSong = this.state.songs[i];
    const sList = SONGQUERY;
    this.setState({
      currentSong : curSong.title + " by: " + curSong.artist,
    });
  }

  renderSong(i){
    return(
      <Song
        song = {this.state.songs[i]}
        onClick={() => this.handleDoubleClick(i)}
        />
    );
  }

  render(){
    return(
      <div>
        current song: {this.state.currentSong}
        {this.renderSong(0)}
        {this.renderSong(1)}
      </div>
    );
  }

}

angular.module("MyApp", ["ngMaterial"])

  .controller("TabOne", function($scope, $rootScope) {
    $scope.title = "Count Upwards";
  })
.component('myComponent', react2angular(SongList, ['fooBar', 'baz']))
;
