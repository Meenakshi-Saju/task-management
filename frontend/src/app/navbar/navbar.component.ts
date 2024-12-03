import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NavbarService } from '../navbar.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private router: Router , public nav: NavbarService) { }

  goLogin()
  {
    this.router.navigate(['/login']);
  }
}
