import {Contact} from './model.contact';
import {StatusOfThePerson} from './model.status-of-the-person';

export class Person {

  public id: number;
  public firstName: string;
  public lastName: string;
  public origin: string;
  public birthDate: Date;
  public status: StatusOfThePerson;
  public contact: Contact;

}
