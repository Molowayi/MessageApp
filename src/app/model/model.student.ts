import {Person} from './model.person';
import {Room} from './model.room';

export class Student extends Person {
  school: string;
  study_field: string;
  room: Room;
}
