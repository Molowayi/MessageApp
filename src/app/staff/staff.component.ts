import {Component, OnInit} from '@angular/core';
import {Staff} from '../model/staff';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {StatusOfThePerson} from '../model/status-of-the-person';
import {Addres} from '../model/addres';
import {Contact} from '../model/contact';
import {Department} from '../model/department';
import {Role} from '../model/role';
import {ServiceforallService} from '../services/serviceforall.service';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
};

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  errorMsg: '';
  rol = [Role.ASSISTANT, Role.CLEANER, Role.MAINTENANCE, Role.MANAGER, Role.SECRETARY];
  statuss = [StatusOfThePerson.STUDENT, StatusOfThePerson.STAFF];
  formsent = true;
  newStaff: any = new Staff();
  staff: any;
  sofp: StatusOfThePerson = StatusOfThePerson.STAFF;
  the_role: Role.CLEANER;

  constructor(private  http: HttpClient, private httpService: ServiceforallService,
              private dept: Department, private adres: Addres, private contacte: Contact) {
    adres = {id: null, street: '', city: '', country: '', zipCode: '', number: ''};
    contacte = {id: null, adress: adres, email: '', mobile: ''};
    dept = {id: null, name: ''};
    this.newStaff.contact = contacte;
    this.newStaff.id = null;
    this.newStaff.firstName = '';
    this.newStaff.lastName = '';
    this.newStaff.origin = '';
    this.newStaff.department = dept;
    this.newStaff.role = this.the_role;    // empty?
    this.newStaff.status = this.sofp;
  }

  ngOnInit() {
    this.httpService.get<Staff>('http://localhost:8080/ngo/staff', httpOptions).subscribe(response => {
      this.staff = response;
    });
  }

  onSubmit() {
    this.httpService.post<Staff>('http://localhost:8080/ngo/staff', this.newStaff, httpOptions)
      .subscribe(data => {
        this.formsent = true;
      }, error => this.errorMsg = error.statusText);
    this.newStaff = null;
  }
}
