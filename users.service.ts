import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: Http) { }

  getMutualFriends(firstUserEmail, secondUserEmail) {
    let userEmails = {'firstUserEmail': firstUserEmail, 'secondUserEmail': secondUserEmail };
    console.log("-------   ", userEmails.firstUserEmail, userEmails.secondUserEmail);
    
    return this.http.post('http://localhost:8080/api/v1/findMutualFriends', userEmails)
        .map((res:Response) => res.json());

/*
    return [
      {id: 1, name: 'Mary', email: 'taylor@test.com'},
      {id: 2, name: 'Peter', email: 'Smith@gmail.com'},
      {id: 3, name: 'Lauren', email: 'Taylor3333@gmail.com'},
      {id: 4, name: 'Sam', email: 'Sam@gmail.com'},
      {id: 5, name: 'John', email: 'John@gmail.com'} 
	];*/
  }

   getCustomers(): User[] {
    return [];
   }


}
