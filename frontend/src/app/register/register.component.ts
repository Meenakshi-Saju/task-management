import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  userName: string = "";
  userCity: string = "";
  userEmail: string = "";
  userPassword: string = "";

  userId: any = 0;

  route: string | undefined;

  constructor(private http: HttpClient, private router: Router) {
    this.route = router.url;
  }

  //Save Method to Storing User Details into Database
  save() {
    if (this.userName === "" || this.userCity === "" || this.userEmail === "" || this.userPassword === "") {
      alert("Please Enter Valid Input !!");
    }
    else if (this.userPassword.length < 6) {
      alert("Password Length must be Greater than 6 !!! ");
    }
    else {
      let bodyData = {
        "name": this.userName,
        "email": this.userEmail,
        "city": this.userCity,
        "password": this.userPassword
      };
      //Fetching User Details from UI and Sending to the API using HTTP Post Method
      this.http.post("http://localhost:8080/api/v1/task/saveuser", bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
        console.log(resultData);
        alert("User Registration Successful!");
        this.userName = "";
        this.userCity = "";
        this.userPassword = "";
        this.userId = resultData;

        this.router.navigate(['/gettask']);
      });
    }
  }
}
