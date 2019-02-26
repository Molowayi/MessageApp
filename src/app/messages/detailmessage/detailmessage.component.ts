import {Component, OnInit} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Message} from '../../model/message';
import {ServiceforallService} from '../../services/serviceforall.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-detailmessage',
  templateUrl: './detailmessage.component.html',
  styleUrls: ['./detailmessage.component.css']
})
export class DetailmessageComponent implements OnInit {

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic aG9tZXI6aG9tZXI='})
  };
  id: number;
  object: any = null;

  constructor(private route: ActivatedRoute, private httpService: ServiceforallService) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;
    this.httpService.get<any>('http://localhost:8080/ngo/message_and_persons/' + this.id, this.httpOptions).subscribe(response => {
      console.log(response);
      this.object = response;
    });
  }

}
