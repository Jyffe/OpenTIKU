import React from 'react';
import Target from './Target.jsx';

const TargetList = (props) => {

  return (
    <div>
      {props.targets.map(target => <Target key={target.id} {...target}/>)}
    </div>
  );
}

export default TargetList;
