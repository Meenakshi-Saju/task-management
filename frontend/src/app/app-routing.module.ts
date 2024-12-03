import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AddtaskComponent } from './addtask/addtask.component';
import { GettaskComponent } from './gettask/gettask.component';
import { UpdatetaskComponent } from './updatetask/updatetask.component';

const routes: Routes = [
  {
    path:'',
    component:HomepageComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'addtask',
    component:AddtaskComponent
  },
  {
    path:'addtask/:status',
    component:AddtaskComponent
  },
  {
    path:'gettask',
    component:GettaskComponent
  },
  {
    path:'update',
    component:UpdatetaskComponent
  },
  {
    path:'updatetask/:id',
    component:UpdatetaskComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
