import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute , Router } from '@angular/router';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit{

  title : string = "";
  desc : string = "";
  status : string = "";

  r1: string ="";

  st : any ;

  constructor(private httpClient : HttpClient , private route: ActivatedRoute , private router: Router){
    this.r1 = router.url;
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.st = params['status'];
      console.log("Status :- "+this.st);
    });
  }

  // Add Task Method
  addTask()
  {
    if(this.title==="" || this.desc==="")
    {
      alert("Please Enter Valid Input");
    }
    else
    {
      let bodyData = {
        "title" : this.title,
        "description" : this.desc,
        "status" : this.st
      };
      //Fetching User Details from UI and Sending to the API using HTTP Post Method for Adding New Task
      this.httpClient.post("http://localhost:8080/api/v1/task/addtask",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
        console.log("Task Title : "+resultData);
        alert("Task Added Successfully");
        this.router.navigateByUrl('/gettask');
        this.title = "";
        this.desc = "" ;
        this.status = "" ;
      });
    }
  }
}
