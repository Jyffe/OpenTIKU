import React from 'react';
import axios from 'axios';

class Form extends React.Component {

  state = {target: ''}

  handleSubmit = (event) => {

    event.preventDefault();

    console.log('Event: Form Submit', this.state.target);

    axios.get('http://localhost:8100/targets/'+this.state.target)
      .then(resp => {
        this.props.onSubmit(resp.data);

        this.setState({ target: '' });
      });
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input type="text"
          value={this.state.target}
          onChange={(event) => this.setState({ target: event.target.value })}
          placeholder="Target" required/>
        <button type="submit">Add target</button>
      </form>
    );
  }
};

export default Form;
