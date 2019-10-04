import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SidenavComponent } from './sidenav/sidenav.component';

import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
import { FormComponent } from './form/form.component';


const routes: Routes = [
  { path:  'sidenav', component:  SidenavComponent},
  { path:  'commandlist', component:  CommandListComponent},
  { path:  'trackissue', component:  TrackIssueComponent},
 { path:  'form', component:  FormComponent},
 // { path:  'form/:id', component:  FormComponent},
  { path:  '**', component:  CommandListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
