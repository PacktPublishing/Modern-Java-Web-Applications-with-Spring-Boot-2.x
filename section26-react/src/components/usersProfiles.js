import React from 'react';

const UsersProfiles = ({ users }) => {

    let header = 'List of Users';
    return (
      <div class="container">
      <div class="col-lg-6">
            <div class="panel panel-default">
            <div class="panel-heading"><h3 >{ header }</h3></div>
            <div class="panel-body">
             
				    <table class="table table-condensed">
				      <thead>
				        <tr>
				            <th>Full Name</th>
				            <th>Email</th>
				            <th>Address</th>
				            <th>Mobile</th>
                    <th>Username</th>
                    <th>Password</th>
				        </tr>
				      </thead>

				      <tbody>
                {users.map((u) => (
                  <tr>
                    <td>{u.name}</td>
                    <td>{u.email}</td>
                    <td>{u.address}</td>
                    <td>{u.mobile}</td>
                    <td>{u.username}</td>
                    <td>{u.password}</td>
                  </tr>
                ))}
				      </tbody>
				    </table>
          </div>
          </div> 
      </div>
      </div>
    )
  };

  export default UsersProfiles