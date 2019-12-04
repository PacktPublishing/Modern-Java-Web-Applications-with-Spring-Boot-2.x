import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FarmProfileComponent } from './farm-profile/farm-profile.component';
import { FarmUsersComponent } from './farm-users/farm-users.component';


const routes: Routes = [

  {
    path: 'profile',
    component: FarmProfileComponent
  },
  {
    path: 'users',
    component: FarmUsersComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
