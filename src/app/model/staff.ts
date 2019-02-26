import {Department} from './Department';
import {Person} from './person';
import {Role} from './role';

export class Staff extends Person {
  role: Role;
  department: Department;
}
