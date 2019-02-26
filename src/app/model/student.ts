import {Person} from './Person';
import {Room} from './Room';

export class Student extends Person {
  school: string;
  study_field: string;
  room: Room;
}
