import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './sidenav/sidenav.component';
import { LayoutModule } from '@angular/cdk/layout';
<<<<<<< HEAD
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule, MatInputModule, MatFormFieldModule, MatRadioModule } from '@angular/material';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
=======

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
import { FlexLayoutModule } from '@angular/flex-layout';
import { FooterComponent } from './footer/footer.component';
import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
<<<<<<< HEAD
import { CommandFilterPipe } from './command-filter.pipe';
import { CommandServiceService } from './services/command-service.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FormComponent } from './form/form.component';
=======
import { CommandServiceService } from './services/command-service.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FormComponent } from './form/form.component';
import { TrackIssueService } from './services/track-issue.service';
import { MaterialModule } from './material/material.module';
import { IssueFilterPipe } from './pipes/issue-filter.pipe';
import { IntentFilterPipe } from './pipes/intent-filter.pipe';
import { CommandFilterPipe } from './pipes/command-filter.pipe';
import { CommandMockService } from './services/command-mock.service';

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
<<<<<<< HEAD
    FooterComponent,
    CommandListComponent,
    TrackIssueComponent,
    CommandFilterPipe,
    FormComponent
=======

    FooterComponent,
    CommandListComponent,
    TrackIssueComponent,
    FormComponent,
    IssueFilterPipe,
    IntentFilterPipe,
    CommandFilterPipe
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
<<<<<<< HEAD
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
=======

    FlexLayoutModule,
    NgxPaginationModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  providers: [CommandServiceService, TrackIssueService, CommandMockService],
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  bootstrap: [AppComponent]
})
export class AppModule { }
