import React from 'react';

const Event = (props) => {

  //console.log('eventin propsit', props);

  return (

    <div>
      <div>{props.id}</div>
      <div>{props.status}</div>
      <div>{props.measurement}</div>
      <div>{props.location}</div>
    </div>

  );
};

export default Event;
