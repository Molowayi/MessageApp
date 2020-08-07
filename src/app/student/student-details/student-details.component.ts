import {Component, OnInit} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Student} from '../../model/model.student';
import {ServiceforallService} from '../../services/serviceforall.service';
import {ActivatedRoute} from '@angular/router';
import {StatusOfThePerson} from '../../model/model.status-of-the-person';
import {Room} from '../../model/model.room';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };

  id: number;
  student: any = new Student();
  object_student: any = new Object();
  received_messages: any = null;
  sent_messages: any = null;

  constructor(private route: ActivatedRoute, private httpService: ServiceforallService) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;
    this.httpService.get<Student>('http://localhost:8080/ngo/student/' + this.id, this.httpOptions).subscribe(response => {
      this.student = response;
      this.object_student = response;
      console.log(this.object_student);
    });
    this.student.status = StatusOfThePerson.STUDENT;
    this.httpService.get<Room>('http://localhost:8080/ngo/room/student/' + this.id, this.httpOptions).subscribe(response => {
      this.student.room = response;
    });

    this.httpService.get<any>('http://localhost:8080/ngo/messages/sender/' + this.id, this.httpOptions).subscribe(response => {
      console.log('SENT');
      console.log(response);

      this.sent_messages = response;
    });

    this.httpService.get<any>('http://localhost:8080/ngo/messages/receiver/' + this.id, this.httpOptions).subscribe(response => {
      console.log('RECEIVED');

      console.log(response);
      this.received_messages = response;
    });
  }

  onSubmit() {
  }

}
