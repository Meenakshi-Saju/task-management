import { Component } from '@angular/core';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {

  route: string | undefined;

  constructor(private router: Router ){
    this.route = router.url;
  }

  start(){
    this.router.navigate(['/register']);
  }
}
