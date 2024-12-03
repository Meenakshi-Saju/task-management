
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-gettask',
  templateUrl: './gettask.component.html',
  styleUrls: ['./gettask.component.css']
})
export class GettaskComponent implements OnInit {

  route: string | undefined;

  taskStatus: any;

  public TaskData: any = [];

  todo: boolean = false;
  doing: boolean = false;
  done: boolean = false;
  id: any;

  statusData: any;
  newTask: any;

  constructor(private router: Router, private http: HttpClient, public nav: NavbarService) {
    this.route = router.url;
  }

  ngOnInit(): void {
    this.nav.hide();
    this.loadData();
  }



  loadData() {
    this.http.get("http://localhost:8080/api/v1/task/gettask").subscribe((resultData: any) => {
      this.TaskData = resultData.map((task: any) => {
        return {
          ...task,
          startTime: new Date().toLocaleString("en-US", { dateStyle: "medium", timeStyle: "short" }) || "Not Set",
          endTime: task.endTime || "Not Set"
        };
      });
      console.log("Task Details: ", this.TaskData);
    });
  }

  openTask(st: string) {
    this.statusData = st;

    this.router.navigate(['/addtask', st]);
  }
  taskId(id: any) {
    this.id = id;
    this.router.navigate(['/updatetask', id]);
    console.log("Task ID - " + id);
  }



}
