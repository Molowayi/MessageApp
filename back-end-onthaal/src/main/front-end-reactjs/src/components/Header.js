import React, { Component, Fragment } from 'react';

class Header extends Component {
    render() {
        return (
            
            <div className="container" id="header_container">
  <p className="alignright marginTop30"><small></small></p>
  <h4>ONTHAAL APPLICATIE</h4>
  <nav className="navbar navbar-inverse">
    <div className="container-fluid">
      <div className="navbar-header">
        <a className="navbar-brand" routerLink="/welcome">Onthaal Application</a>
      </div>
      <ul className="nav navbar-nav">

        <li className="active"><a routerLink="/welcome">Home</a></li>

        <li className="dropdown" ><a className="dropdown-toggle" data-toggle="dropdown" >Students <span
          className="caret"></span></a>
          <ul className="dropdown-menu">
            <li><a routerLink="/list_students">List students</a></li>
            <li><a routerLink="/students">Add new student</a></li>
            <li><a >Search a student</a></li>
            <li><a routerLink="/list_students">Archive a student</a></li>
          </ul>
        </li>

        <li className="dropdown" ><a className="dropdown-toggle" data-toggle="dropdown" >Staff Members<span
          className="caret"></span></a>
          <ul className="dropdown-menu">
            <li><a routerLink="/list_staff">List of the staff members</a></li>
            <li><a routerLink="/staff">Add new staff member</a></li>
            <li><a routerLink="/staff">Search</a></li>
            <li><a routerLink="/list_staff">Archive a staff member</a></li>
          </ul>
        </li>

        <li className="dropdown"   ><a className="dropdown-toggle" data-toggle="dropdown" >All the people <span
          className="caret"></span></a>
          <ul className="dropdown-menu">
            <li><a routerLink="/people">List of the all the people</a></li>
            <li><a routerLink="/list_staff">Staff members</a></li>
            <li><a routerLink="/list_students">Students</a></li>
            <li><a routerLink="/people">Search</a></li>
            <li><a routerLink="/people">Archive someone</a></li>
          </ul>
        </li>

        <li className="dropdown"><a className="dropdown-toggle" data-toggle="dropdown" >Messages <span
          className="caret"></span></a>
          <ul className="dropdown-menu">
            <li><a routerLink="/messages">Add new message</a></li>
            <li><a routerLink="/list_messages">List messages</a></li>
            <li><a >Search messages</a></li>
            <li><a routerLink="/list_messages">Archive a message</a></li>
          </ul>
        </li>
        <li><a  routerLink="/login" className="nav-link">Login</a></li>
        <li><a  routerLink="/logout" className="nav-link">LogOut</a></li>
      </ul>
        <form className="navbar-form navbar-left" >
            <div className="input-group">
                <input type="text" className="form-control" placeholder="Search" />
                <div className="input-group-btn">
                    <button className="btn btn-default" type="submit">
                    <i className="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
  </nav>
</div>

        );
    }
}

export default Header;