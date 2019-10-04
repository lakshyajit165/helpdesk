import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './sidenav/sidenav.component';
import { LayoutModule } from '@angular/cdk/layout';

import { FlexLayoutModule } from '@angular/flex-layout';
import { FooterComponent } from './footer/footer.component';
import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
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


@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,

    FooterComponent,
    CommandListComponent,
    TrackIssueComponent,
    FormComponent,
    IssueFilterPipe,
    IntentFilterPipe,
    CommandFilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,

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
  bootstrap: [AppComponent]
})
export class AppModule { }
