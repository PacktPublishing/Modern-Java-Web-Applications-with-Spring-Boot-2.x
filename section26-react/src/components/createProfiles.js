import React, {Component} from 'react';

class CreateProfiles extends Component {
    constructor(props) {
      super(props);
      this.state = {
              header : 'Add Profile',
              name : '',
              email : '',
              address : '',
              mobile : '',
              username : '',
              password : '',
              approved : ''
          
      };
      this.onChangeName = this.onChangeName.bind(this);
      this.onChangeEmail = this.onChangeEmail.bind(this);
      this.onChangeAddress = this.onChangeAddress.bind(this);
      this.onChangeMobile = this.onChangeMobile.bind(this);
      this.onChangeUsername = this.onChangeUsername.bind(this);
      this.onChangePassword = this.onChangePassword.bind(this);
      this.onChangeApproved = this.onChangeApproved.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
     onChangeName(e) {
        this.setState({
          name : e.target.value
        });
      }
      onChangeEmail(e) {
        this.setState({
          email : e.target.value
        })  
      }
      onChangeAddress(e) {
        this.setState({
          address : e.target.value
        })
      }
      onChangeMobile(e) {
        this.setState({
          mobile: e.target.value
        })
      }
      onChangeUsername(e) {
        this.setState({
          username: e.target.value
        })
      }
      onChangePassword(e) {
        this.setState({
          password: e.target.value
        })
      }
      onChangeApproved(e) {
        this.setState({
          approved: e.target.value
        })
      }
    handleSubmit(event) {
        event.preventDefault();
        fetch('http://localhost:8082/farmservice/signup/user/add', {
              method: 'POST',
              body: JSON.stringify({
                              name: this.state.name,
                              email: this.state.email,
                              address: this.state.address,
                              mobile: this.state.mobile,
                              username: this.state.username,
                              password: this.state.password,
                              approved: this.state.approved,
                             
              }),
              headers: {
                              "Content-type": "application/json; charset=UTF-8"
              }
          }).then(response => {
                  if(response.status === 200) {
                      alert("New website saved successfully");
                  }
              });
    }
    render() {
      return (
        <div class="container">
        <div class="col-lg-6">
            <div class="panel panel-default">
            <div class="panel-heading"><h3>{ this.state.header }</h3></div>
            <div class="panel-body"></div>
          <form onSubmit={this.handleSubmit} class="form-horizontal">
              <fieldset>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="name">Full Name</label>  
                  <div class="col-md-4">
                      <input type="text" name="name" value={this.state.name} onChange={this.onChangeName} placeholder="Name" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="email">Email</label>  
                  <div class="col-md-4">
                      <input type="text" name="email" value={this.state.email} onChange={this.onChangeEmail} placeholder="Email" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="address">Address</label>  
                  <div class="col-md-4">
                      <input type="text" name="address" value={this.state.address} onChange={this.onChangeAddress} placeholder="Address" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="mobile">Mobile</label>  
                  <div class="col-md-4">
                      <input type="text" name="mobile" value={this.state.mobile} onChange={this.onChangeMobile} placeholder="Mobile" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="username">Username</label>  
                  <div class="col-md-4">
                      <input type="text" name="username" value={this.state.username} onChange={this.onChangeUsername} placeholder="Username" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="password">Password</label>  
                  <div class="col-md-4">
                      <input type="text" name="password" value={this.state.password} onChange={this.onChangePassword} placeholder="Password" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="approved">Approved?</label>  
                  <div class="col-md-4">
                      <input type="text" name="approved" value={this.state.approved} onChange={this.onChangeApproved} placeholder="Approved" />
                  </div>
                </div>
                <div class="form-group">
                    <div class="col-md-8">
                      <input type="submit" value="Submit" />
                    </div>
                </div>
              </fieldset>
            </form>
          </div>
          </div>
            </div>
      );
    }
  }
  
  export default CreateProfiles;