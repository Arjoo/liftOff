import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { User } from '../User';

@Component({
  selector: 'app-mutual-friends',
  templateUrl: './mutual-friends.component.html',
  styleUrls: ['./mutual-friends.component.css']
})
export class MutualFriendsComponent implements OnInit {

  firstUserEmail: string = '';
  secondUserEmail: string = '';
  users: {};
  constructor(private usersService: UsersService) { }

  ngOnInit() {
  }

  onSubmit () {
  	console.log(this.firstUserEmail, this.secondUserEmail);
    this.usersService.getMutualFriends(this.firstUserEmail, this.secondUserEmail).subscribe(
            data => this.users = data);
    console.log(this.users);
  }

}
