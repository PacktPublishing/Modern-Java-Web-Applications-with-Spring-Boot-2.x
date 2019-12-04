import { Component, OnInit } from '@angular/core';
import { Profile } from '../model/profile';
import { map } from 'rxjs/operators';
import { FarmServiceService } from '../service/farm-service.service';

@Component({
  selector: 'app-farm-users',
  templateUrl: './farm-users.component.html',
  styleUrls: ['./farm-users.component.css'],
  providers: [ FarmServiceService ]
})
export class FarmUsersComponent implements OnInit {
  userList: Array<Profile> = [];
  header = 'List of Users';
  constructor(private farmServiceService: FarmServiceService) {

    this.farmServiceService.getUsers().subscribe(res => {
      console.log(res);
      this.userList = res;
    });
  }

  ngOnInit() {
  }

}
