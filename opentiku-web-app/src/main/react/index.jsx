import React from 'react';
import {render} from 'react-dom';
import TargetList from './TargetList.jsx';
import Form from './Form.jsx';
import EventListener from './EventListener.jsx';
import EventList from './EventList.jsx';

class App extends React.Component {

  state = {
    targets: [],
    events: []
  };

  addTargets = (targetInfo) => {

    this.setState(prevState => ({
      targets: prevState.targets.concat(targetInfo)
    }));
  };

  addEvents = (eventInfo) => {
    /* MUST use JSON.parse, otherwise event data is stored as String instead
     * of a JSON-object!
     */
    this.setState(prevState => ({
      events: prevState.events.concat(JSON.parse(eventInfo))
    }));
  };

  render () {
    return (
      <div>
        {/*
        <Form onSubmit={this.addTargets}/>
        <TargetList targets={this.state.targets}/>
        */}
        <EventListener onEvent={this.addEvents}/>
        <EventList events={this.state.events}/>
      </div>
    )
  }
}

render(<App/>, document.getElementById('app'));
