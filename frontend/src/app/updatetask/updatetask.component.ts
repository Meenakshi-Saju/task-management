import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-updatetask',
  templateUrl: './updatetask.component.html',
  styleUrls: ['./updatetask.component.css']
})
export class UpdatetaskComponent implements OnInit{

  url = "http://localhost:8080/api/v1/task/updatetask";

  title : any ;
  desc : any ;

  taskTitle : any ;
  taskDesc :any;
  taskStatus : any ;

  id:any ;

  route: string | undefined;

  flag : boolean = false ;

  public TaskData:any = [];

  constructor(private router: Router , private http: HttpClient , private activatedRoute: ActivatedRoute ){
    this.route = router.url;
  }

  ngOnInit(): void {
    //Fetching URL Parameter Value Using Activated Route
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
    });
    this.loadTaskData();
  }

  //Fetching Previous Task Details from Database Before Update Operation
  loadTaskData(){
    this.http.get(this.url+'/'+this.id).subscribe((resultData: any)=>{
      this.title = resultData.title ;
      this.desc = resultData.description ;
      this.taskStatus = resultData.status ;

      console.log("Task ST : "+this.taskStatus);
    })
  }

  update(taskTitle: any , taskDesc: any){
      this.taskTitle = taskTitle ;
      this.taskDesc = taskDesc ;

      let bodyData = {
        "title" : this.taskTitle,
        "description" : this.taskDesc,
        "status" : this.taskStatus
      };
      //Fetching User Details from UI and Sending to the API using HTTP Post Method for Updating Task
      this.http.post(this.url+'/'+this.id,bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
        alert("Task Updated Successfully");
        this.title = "";
        this.desc = "" ;
        this.router.navigateByUrl('/gettask');
      });
  }

  //Delete Method
  delete(){
    this.http.delete(this.url+'/'+this.id,{responseType: 'text'}).subscribe((
      result:any)=>{

        alert("Task Deleted Successfully");
        console.log(result);
        this.router.navigateByUrl('/gettask');

      });
  }

  //Method to Change Task Status
  changeStatus(){
    this.flag = true ;
  }

  //Method to Get Task Status
  getStatus(event : any){
    this.taskStatus = event.target.value ;
  }

}
