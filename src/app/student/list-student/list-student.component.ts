import { Component, OnInit } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {StatusOfThePerson} from '../../model/model.status-of-the-person';
import {Student} from '../../model/model.student';
import {ServiceforallService} from '../../services/serviceforall.service';
import {Room} from '../../model/model.room';
import {Addres} from '../../model/model.addres';
import {Contact} from '../../model/model.contact';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };

  statuss = [StatusOfThePerson.STUDENT, StatusOfThePerson.STAFF];
  // newStudent: any = new Student();
  student: any; // Student[];
  sofp: StatusOfThePerson = StatusOfThePerson.STUDENT;
  constructor(private httpService: ServiceforallService,
              private rum: Room,
              private adres: Addres,
              private contacte: Contact) { }

  ngOnInit() {
    this.httpService.get<Student>('http://localhost:8080/ngo/student', this.httpOptions).subscribe(response => {
      this.student = response;
    });

  }

}
