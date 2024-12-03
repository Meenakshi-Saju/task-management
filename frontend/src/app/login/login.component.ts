import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userEmail: string = "";
  userPassword: string = "";

  route: string | undefined;

  //Injecting Router and HttpClient Object Using Constructor
  constructor(private router: Router, private http: HttpClient) {
    this.route = router.url;
  }

  //Login Method
  loginUser() {

    if (this.userEmail === "" || this.userPassword === "") {
      alert("Please Enter Valid Input !!");
    }
    else {
      let bodyData = {
        "userEmail": this.userEmail,
        "userPassword": this.userPassword,
      };
      //Fetching User Details from UI and Sending to the API using HTTP Post Method for User Login
      this.http.post("http://localhost:8080/api/v1/task/loginusers", bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
        console.log(resultData);
        if (resultData == "Login Failed") {
          alert("Login Failed");
          this.userEmail = "";
          this.userPassword = "";

        }
        else if (resultData == this.userEmail) {
          alert("Login Successful!");
          this.router.navigate(['/gettask']);
          this.userEmail = "";
          this.userPassword = "";
        }
        else {
          alert("Incorrect Email and Password not match");
          this.userEmail = "";
          this.userPassword = "";

        }
      });
    }
  }
}
