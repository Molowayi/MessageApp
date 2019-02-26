import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Addres} from '../model/addres';

@Component({
  selector: 'app-adress',
  templateUrl: './adress.component.html',
  styleUrls: ['./adress.component.css']
})
export class AdressComponent implements OnInit {

  addres: Addres;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }

}
