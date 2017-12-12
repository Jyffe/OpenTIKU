import React from 'react';
import Event from './Event.jsx';

const EventList = (props) => {

  return (

    <div>
      {props.events.map(event => <Event key={event.id} {...event}/>)}
    </div>

  );
}

export default EventList;
