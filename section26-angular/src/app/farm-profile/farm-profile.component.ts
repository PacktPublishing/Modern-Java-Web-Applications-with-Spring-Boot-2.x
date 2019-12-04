import { Component, ViewChild, OnInit } from '@angular/core';
import { Profile } from '../model/profile';
import { map } from 'rxjs/operators';
import { FarmServiceService } from '../service/farm-service.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-farm-profile',
  templateUrl: './farm-profile.component.html',
  styleUrls: ['./farm-profile.component.css'],
  providers: [ FarmServiceService ]
})
export class FarmProfileComponent implements OnInit {
  @ViewChild('myForm', {static: false})
  myForm: NgForm;

  formData: Profile = {
    name: '',
    email: '',
    address: '',
    mobile: '',
    username: '',
    password: '',
    approved: false
};
header = 'Profile';

  constructor(private farmServiceService: FarmServiceService ) { }

  onsubmit() {
    console.log(this.formData);
    this.farmServiceService.addProfileUser(this.formData);
    this.myForm.reset();
  }

  ngOnInit() {
  }

}
