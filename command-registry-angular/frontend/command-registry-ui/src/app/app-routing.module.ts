import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SidenavComponent } from './sidenav/sidenav.component';
<<<<<<< HEAD
=======

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
import { FormComponent } from './form/form.component';


const routes: Routes = [
  { path:  'sidenav', component:  SidenavComponent},
  { path:  'commandlist', component:  CommandListComponent},
  { path:  'trackissue', component:  TrackIssueComponent},
<<<<<<< HEAD
  { path:  'form', component:  FormComponent},
=======
 { path:  'form', component:  FormComponent},
 // { path:  'form/:id', component:  FormComponent},
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  { path:  '**', component:  CommandListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
