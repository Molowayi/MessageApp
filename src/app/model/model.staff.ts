import {Department} from './model.department';
import {Person} from './model.person';
import {Role} from './model.role';

export class Staff extends Person {
  role: Role;
  department: Department;
}
