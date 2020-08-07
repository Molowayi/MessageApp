import {Component, OnInit} from '@angular/core';
import {Student} from '../model/model.student';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Room} from '../model/model.room';
import {Addres} from '../model/model.addres';
import {Contact} from '../model/model.contact';
import {Funktion} from '../model/model.funktion';
import {StatusOfThePerson} from '../model/model.status-of-the-person';
import {ServiceforallService} from '../services/serviceforall.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };
  statuss = [StatusOfThePerson.STUDENT, StatusOfThePerson.STAFF];
  func = [Funktion.BATHROOM,
    Funktion.SPECTACLE_ROOM,
    Funktion.BATHROOM,
    Funktion.SLEEPROOM,
    Funktion.TOILET,
    Funktion.OFFICE,
    Funktion.KITCHEN];
  errorMsg: '';
  newStudent: any = new Student();
  student: any;
  sofp: StatusOfThePerson = StatusOfThePerson.STUDENT;

  constructor(private httpService: ServiceforallService,
              private http: HttpClient,
              private rum: Room,
              private adres: Addres,
              private contacte: Contact,
              private router: Router) {
    rum = {id: null, function: Funktion.SLEEPROOM, number: ''};
    adres = {id: null, street: '', city: '', country: '', zipCode: '', number: ''};
    contacte = {id: null, adress: adres, email: '', mobile: ''};
    this.newStudent.contact = contacte;
    this.newStudent.id = null;
    this.newStudent.firstName = '';
    this.newStudent.lastName = '';
    this.newStudent.origin = '';
    this.newStudent.study_field = '';
    this.newStudent.school = '';
    this.newStudent.room = rum;
    this.newStudent.status = this.sofp;
  }

  ngOnInit() {
    this.httpService.get<Student>('http://localhost:8080/ngo/student', this.httpOptions).subscribe(response => {
      this.student = response;
    });
  }

  onSubmit() {
    this.httpService.post<Student>('http://localhost:8080/ngo/student', this.newStudent, this.httpOptions)
      .subscribe(data => {
        this.newStudent = data;
      }, error => this.errorMsg = error.statusText);
    this.newStudent = null;
    this.router.navigate(['/students']);
  }

}
