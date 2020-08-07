import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Person} from '../model/model.person';
import {ServiceforallService} from '../services/serviceforall.service';


@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };
  people: any;

  constructor(private http: HttpClient, private httpService: ServiceforallService) {
  }

  ngOnInit() {
    this.httpService.get<Person>('http://localhost:8080/ngo/person', this.httpOptions).subscribe(response => {
      console.log(response);
      this.people = response;
    });

  }
}
