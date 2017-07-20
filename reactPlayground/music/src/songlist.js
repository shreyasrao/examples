var SONGQUERY = [
      {index:0,title:"BARF",artist:"Drizzy"},
      {index:1,title:"HEROOOOR",artist:"FUK"}
]


function Song(props){
  return(
    <div onDoubleClick={props.onClick}>
    <button >
      <span>{props.song.index}</span>
      <span>{props.song.title}</span>
      <span>{props.song.artist}</span>
    </button>
      </div>
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

