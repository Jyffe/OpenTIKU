import React from 'react';
import Websocket from 'react-websocket';

class EventListener extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      type: -1
    };
  }

  /*
  * npm install --save react-websocket
  */
  handleData(data) {
      let result = JSON.parse(data);
      //console.log('WebSocket event', result);
      this.setState({type: result.value});
    }

  render() {
    return (
      <div>
        Event number: <strong>{this.state.type}</strong>

        <Websocket url='ws://localhost:8088/event'
          onMessage={this.handleData.bind(this)}/>
      </div>
    );
  }
}

export default EventListener;
