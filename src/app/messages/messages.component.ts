import {Component, OnInit} from '@angular/core';
import {Message} from '../model/model.message';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Person} from '../model/model.person';
import {ServiceforallService} from '../services/serviceforall.service';
import {Student} from '../model/model.student';
import {StatusOfThePerson} from '../model/model.status-of-the-person';
import {Staff} from '../model/model.staff';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };
  people: any;
  sender: Person = new Student();
  receiver: Person = new Student();
  staff_sender = new Staff();
  staff_receiver = new Staff();
  errorMsg = '';
  newMessage: any = new Message();
  message: any;

  constructor(private httpService: ServiceforallService, private http: HttpClient) {
    this.receiver.id = null;
    this.receiver.firstName = '';
    this.receiver.lastName = '';
    // this.receiver.status = StatusOfThePerson.STUDENT;

    this.newMessage.receiver = this.receiver;

    this.sender.id = null;
    this.sender.firstName = '';
    this.sender.lastName = '';

    this.newMessage.sender = this.sender;

    this.newMessage.id = null;
    this.newMessage.postTime = Date.now(); // new Date();
    this.newMessage.title = '';
    this.newMessage.content = '';
  }

  ngOnInit() {
    this.httpService.get<Message>('http://localhost:8080/ngo/message', this.httpOptions)
      .subscribe(response => {
        this.message = response;
        console.log(response);
      });

    this.httpService.get<Person>('http://localhost:8080/ngo/person', this.httpOptions).subscribe(response => {
      console.log(response);
      this.people = response;
    });
  }

  onSubmit() {
    if (this.sender.status === StatusOfThePerson.STAFF) {
      this.staff_sender.id = this.sender.id;
      this.staff_sender.firstName = this.sender.firstName;
      this.staff_sender.lastName = this.sender.lastName;
      this.staff_sender.status = StatusOfThePerson.STAFF;
      this.message.sender = this.staff_sender;
    }
    if (this.receiver.status === StatusOfThePerson.STAFF) {
      this.staff_receiver.id = this.receiver.id;
      this.staff_receiver.firstName = this.receiver.firstName;
      this.staff_receiver.lastName = this.receiver.lastName;
      this.staff_receiver.status = StatusOfThePerson.STAFF;

      this.message.receiver = this.staff_receiver;
    }
    console.log(this.newMessage);
    this.httpService.post<Message>('http://localhost:8080/ngo/message', this.newMessage, this.httpOptions)
      .subscribe(data => {
        this.newMessage = data;
      }, error => this.errorMsg = error.statusText);
  }
}
