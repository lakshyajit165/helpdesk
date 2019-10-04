import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormArray, FormGroup, Validators } from '@angular/forms';
// import { ICommand } from './model/CommandInterface';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { CommandServiceService } from '../services/command-service.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  constructor(

    private router: Router,
    private activatedRoute: ActivatedRoute,
    private command: CommandServiceService,
    public fb: FormBuilder) { }

  get name() {
    return this.Form.get('name');
  }
  get tags() {
    return this.Form.get('tags') as FormArray;
  }
  get desc() {
    return this.Form.get('desc');
  }
  get usage() {
    return this.Form.get('usage');
  }
  get status() {
    return this.parameters.get('status');
  }

  get parameters() {
    return this.Form.get('parameters') as FormArray;
  }

  get parameterName() {
    return this.parameters.get('parameterName');
  }
  get default() {
    return this.parameters.get('default');
  }
  get required() {
    return this.parameters.get('required');
  }
  get description() {
    return this.parameters.get('description');
  }



  get createParameters() {
    return this.Form.get('params');
  }


  selectedId;
  // title = 'Assignment';
  public hasError = true;

  Form = this.fb.group({
    name: [''],
    status: [''],
    desc: [''],
    usage: [''],
    parameters: this.fb.array([
     // this.createParameter()
    ]),

    tags: this.fb.array([]),
    // parameters:this.fb.array([])
  });


  createParameter(): FormGroup {
    return this.fb.group({
      parameterName: [''],
      default: [''],
      required: [''],
      description: ['']
    });
  }


  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params: ParamMap) => {
      // tslint:disable-next-line: radix
      const id = parseInt(params.get('id'));
      this.selectedId = id;
    });
  }
  onSubmit() {
    this.command.addCommands(this.Form.value).subscribe(
      data => console.log('Success', data),
      error => console.log('e', error));
  }

  onCancel() {
    this.router.navigateByUrl('/command-list');
  }
  addTags() {
    this.tags.push(this.fb.control(''));
  }
  addParameters() {

 // this.tags.push(this.fb.control(''));
    this.parameters.push(this.createParameter());
  }

}
