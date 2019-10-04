import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './sidenav/sidenav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule, MatInputModule, MatFormFieldModule, MatRadioModule } from '@angular/material';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FooterComponent } from './footer/footer.component';
import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
import { CommandFilterPipe } from './command-filter.pipe';
import { CommandServiceService } from './services/command-service.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FormComponent } from './form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    FooterComponent,
    CommandListComponent,
    TrackIssueComponent,
    CommandFilterPipe,
    FormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    FlexLayoutModule,
    NgxPaginationModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatRadioModule,
    ReactiveFormsModule,
    MatSidenavModule,
  // MatDialogModule,
   MatInputModule,
   MatGridListModule,
   MatButtonModule,
   MatListModule,
   BrowserModule,
   AppRoutingModule,
   BrowserAnimationsModule,
   MatToolbarModule,
  // MatSnackBarModule,
   HttpClientModule,
   // MatSelectModule,
   MatFormFieldModule,
   MatIconModule,
   FormsModule,
   BrowserModule,
   ReactiveFormsModule,
   // MatAutocompleteModule,
  // MatChipsModule,
   // ChartsModule
  ],
  providers: [CommandServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
