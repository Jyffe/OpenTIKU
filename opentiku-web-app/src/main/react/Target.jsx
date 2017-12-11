import React from 'react';

const Target = (props) => {

  return (

    <div>
      <div>{props.id}</div>
      <div>{props.name}</div>
      <div>{props.state}</div>
      <div>{props.location}</div>
    </div>

  );
};

export default Target;
