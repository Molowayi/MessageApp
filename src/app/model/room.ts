import {Injectable} from '@angular/core';
import {Funktion} from './funktion';

@Injectable()
export class Room {
  id: number;
  function: Funktion;
  number: string;
}
