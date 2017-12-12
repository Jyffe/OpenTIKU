import React from 'react';
import Websocket from 'react-websocket';

class EventListener extends React.Component {

  /*
  * npm install --save react-websocket
  */

  render() {
    return (
      <div>
        <Websocket url='ws://localhost:8088/event'
          onMessage={this.props.onEvent}/>
      </div>
    );
  }
}

export default EventListener;
