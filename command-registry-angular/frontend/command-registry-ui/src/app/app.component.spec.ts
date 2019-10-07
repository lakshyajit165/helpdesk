import { TestBed, async } from '@angular/core/testing';
<<<<<<< HEAD
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';
=======

import { AppComponent } from './app.component';
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
import { SidenavComponent } from './sidenav/sidenav.component';
import { CommandListComponent } from './command-list/command-list.component';
import { TrackIssueComponent } from './track-issue/track-issue.component';
import { FormComponent } from './form/form.component';
<<<<<<< HEAD
import { APP_BASE_HREF } from '@angular/common';

describe('AppComponent', () => {
  const routes: Routes = [
    { path:  'sidenav', component:  SidenavComponent},
    { path:  'commandlist', component:  CommandListComponent},
    { path:  'trackissue', component:  TrackIssueComponent},
    { path:  'form', component:  FormComponent},
    { path:  '**', component:  CommandListComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
      providers: [
        {provide: APP_BASE_HREF, useValue: '/'}
=======
import { FooterComponent } from './footer/footer.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material/material.module';
import { IssueFilterPipe } from './pipes/issue-filter.pipe';
import { IntentFilterPipe } from './pipes/intent-filter.pipe';
import { CommandFilterPipe } from './pipes/command-filter.pipe';

fdescribe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
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
    HttpClientModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    MaterialModule
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

<<<<<<< HEAD
  it(`should have as title 'command-registry-ui'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('command-registry-ui');
  });
=======

  // it(`should have as title 'command-registry-ui'`, () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   expect(app.title).toEqual('command-registry-ui');
  // });
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

  // it('should render title in a h1 tag', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.debugElement.nativeElement;
  //   expect(compiled.querySelector('h1').textContent).toContain('Welcome to command-registry-ui!');
  // });
});
