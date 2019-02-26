import {Component, OnInit} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ServiceforallService} from '../../services/serviceforall.service';
import {Message} from '../../model/message';
import {forEach} from '@angular/router/src/utils/collection';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-listmessages',
  templateUrl: './listmessages.component.html',
  styleUrls: ['./listmessages.component.css']
})
export class ListmessagesComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };
  objects: any = null;
  messages: Message[] = null;
  public i = 0;
  page: number = null;
  messagesPerPage: number = null;
  totalMessages: number = null;
  totalPages: number = null;
  arrayOfPages: number[] = [];
  mapOfPages = new Map();
  url = '';

  constructor(private route: ActivatedRoute, private httpService: ServiceforallService) {
  }

  ngOnInit() {
    // this.page = this.route.snapshot.params.page;
    // this.messagesPerPage = this.route.snapshot.params.of;
    this.page = +this.route.snapshot.paramMap.get('p');
    this.messagesPerPage = +this.route.snapshot.paramMap.get('n');
    if (this.messagesPerPage === 0) {
      this.messagesPerPage = 5;
    }

    if (this.page !== 0) {
      this.url = 'http://localhost:8080/ngo/messages/page/number/'
        + this.page + '/' + this.messagesPerPage;
      if (this.page === this.totalPages) {
        this.url = 'http://localhost:8080/ngo/messages/offset/number/'
          + (this.page * this.messagesPerPage) + '/' + (this.totalMessages - (this.totalPages - 1) * this.messagesPerPage);
      }
      this.httpService.get<any>(this.url, this.httpOptions)
        .subscribe(response => {
          this.objects = response;
          this.totalMessages = (this.objects).pop();  // Last element of the http response contains the total of messages in the DB
          this.totalPages = 1 + Math.floor(this.totalMessages / this.messagesPerPage);
          if (this.totalMessages % this.messagesPerPage === 0) {
            this.totalPages -= 1;
          }
          for (this.i = 1; this.i <= this.totalPages; this.i++) {
            this.arrayOfPages.push(this.i);
          }

          for (this.i = 1; this.i < this.totalPages; this.i++) {
            this.mapOfPages.set(this.i, this.messagesPerPage);
          }
          this.mapOfPages.set(this.totalPages, this.totalMessages - (this.totalPages - 1) * this.messagesPerPage);
          //
          // console.log(response);
          // console.log('Total of messages : ' + this.totalMessages);
          // console.log('Total of pages : ' + this.totalPages);
          // console.log('Messages per page : ' + this.messagesPerPage);
          // console.log('Array of pages : ' + this.arrayOfPages);
          // console.log('Map : ' + this.mapOfPages.get(1));
          // console.log('Map : ' + this.mapOfPages.get(2));
          // console.log('Map : ' + this.mapOfPages.get(3));
        });
    } else {
      this.httpService.get<any>('http://localhost:8080/ngo/message_and_persons', this.httpOptions).subscribe(response => {
        this.objects = response;
      });
    }
  }

  readmore(messageId: number) {
    this.httpService.get<Message>('http://localhost:8080/ngo/message/' + messageId, this.httpOptions).subscribe(response => {
      console.log(response);
    });
  }
}
