import { Component, OnInit } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ServiceforallService} from '../../services/serviceforall.service';
import {Staff} from '../../model/model.staff';
import {StatusOfThePerson} from '../../model/model.status-of-the-person';
import {Department} from '../../model/model.department';
import {Addres} from '../../model/model.addres';
import {Contact} from '../../model/model.contact';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
};

@Component({
  selector: 'app-list-staff',
  templateUrl: './list-staff.component.html',
  styleUrls: ['./list-staff.component.css']
})
export class ListStaffComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };

  statuss = [StatusOfThePerson.STUDENT, StatusOfThePerson.STAFF];
  staff: any;
  sofp: StatusOfThePerson = StatusOfThePerson.STUDENT;
  constructor(private httpService: ServiceforallService,
              private rum: Department,
              private adres: Addres,
              private contacte: Contact) { }

  ngOnInit() {
    this.httpService.get<Staff>('http://localhost:8080/ngo/staff', this.httpOptions).subscribe(response => {
      this.staff = response;
    });
  }

}
