import {Component, OnInit} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Staff} from '../../model/staff';
import {ServiceforallService} from '../../services/serviceforall.service';
import {ActivatedRoute} from '@angular/router';
import {StatusOfThePerson} from '../../model/status-of-the-person';
import {Department} from '../../model/department';

@Component({
  selector: 'app-detail-staff',
  templateUrl: './detail-staff.component.html',
  styleUrls: ['./detail-staff.component.css']
})
export class DetailStaffComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };

  id: number;
  staff: any = new Staff();
  object_staff: any = new Object();
  received_messages: any = null;
  sent_messages: any = null;

  constructor(private route: ActivatedRoute, private httpService: ServiceforallService) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;
    this.httpService.get<Staff>('http://localhost:8080/ngo/staff/' + this.id, this.httpOptions).subscribe(response => {
      this.staff = response;
      this.object_staff = response;
      this.object_staff.status = StatusOfThePerson.STAFF;
    });
    this.staff.status = StatusOfThePerson.STAFF;
    this.httpService.get<Department>('http://localhost:8080/ngo/department/staff/' + this.id, this.httpOptions)
      .subscribe(response => {
      this.staff.department = response;
    });

    this.httpService.get<any>('http://localhost:8080/ngo/messages/sender/' + this.id, this.httpOptions)
      .subscribe(response => {
      console.log('SENT') ;
      console.log(response)  ;
      this.sent_messages = response;
    });

    this.httpService.get<any>('http://localhost:8080/ngo/messages/receiver/' + this.id, this.httpOptions)
      .subscribe(response => {
      console.log('RECEIVED') ;
      console.log(response)  ;
      this.received_messages = response;
    });
  }

  onSubmit() {
  }

}
