import {Resource} from "./Resource";
import {Person} from "./Person";

export interface Reservation{
  id:number;
  nom:string;
  context:string;
  date:Date;
  duration:number;
  resource:Resource;
  person:Person
  personId:number;
  resourceId:number;



}
