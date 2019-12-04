import React, { Component} from 'react';
import UsersProfiles from './components/usersProfiles';
import CreateProfiles from './components/createProfiles';
import './App.css';


class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      users : []
    }
  }
 

  componentDidMount(){
    fetch('http://localhost:8082/farmservice/signup/users')
    .then(res => res.json())
    .then((data) => {
      this.setState({ users: data })
    })
    .catch(console.log)
  }
  render(){
    return (
      <div className="App">
       
         <CreateProfiles  />
         <UsersProfiles users={this.state.users} />
        </div>
     
  );
 }
}
export default App;
