import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SidenavComponent } from './sidenav/sidenav.component';
import { AppBarComponent } from './app-bar/app-bar.component';


const routes: Routes = [
  { path:  'sidenav', component:  SidenavComponent},
  { path:  'appbar', component:  AppBarComponent},
  { path:  '**', component:  SidenavComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
