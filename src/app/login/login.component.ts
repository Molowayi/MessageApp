import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  welcome = 'Welcome to the MessageApp. You may need to register before you log in.'
  username = ''
  password = ''
  invalidLogin = false
  registrationError: string = "";
  nowLogin: string = "";

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {

        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true

      }
    )
    );

  }

  register(){
    
    (this.loginservice.register(this.username, this.password).subscribe(
      data => {
        console.log(data)
        this.welcome = "Good. Registration was successful. Now you can loggin."
      },
      error => {
        this.welcome = "There was an error. Registration failed. Try valid name and password."
      }
    )
    );

  }

}
