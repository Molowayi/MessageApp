import {Person} from './model.person';

export class Message {

  public id: number;
  public postTime: Date;
  public title: string;
  public content: string;   // Actually text
  public sender: Person;
  public receiver: Person;

  constructor() {
  }


}
