import { Component } from '@angular/core';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-loginnavbar',
  templateUrl: './loginnavbar.component.html',
  styleUrls: ['./loginnavbar.component.css']
})
export class LoginnavbarComponent {

  constructor(public nav: NavbarService){

  }

  show(){
    this.nav.toggle();
  }
}
