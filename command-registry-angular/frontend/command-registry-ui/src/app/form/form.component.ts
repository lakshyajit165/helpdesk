import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormArray, FormGroup, Validators } from '@angular/forms';
// import { ICommand } from './model/CommandInterface';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
<<<<<<< HEAD
=======

import { ICommand } from '../model/CommandInterface';
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
import { CommandServiceService } from '../services/command-service.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
<<<<<<< HEAD
  constructor(

    private router: Router,
    private activatedRoute: ActivatedRoute,
    private command: CommandServiceService,
    public fb: FormBuilder) { }
=======
  public receivedData: ICommand;
  public updatedData: ICommand;

  public FormData: ICommand[] = [];
  constructor(

    private router: Router,
    private route: ActivatedRoute,
    private command: CommandServiceService,
    public fb: FormBuilder) {
    this.route.queryParams.subscribe(params => {
      // console.log('params', this.router.getCurrentNavigation().extras.state.name);
      this.receivedData = this.router.getCurrentNavigation().extras.state.cmd;
    });
    console.log(this.receivedData);
  }


>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

  get name() {
    return this.Form.get('name');
  }
<<<<<<< HEAD
=======
  get id() {
    return this.Form.get('id');
  }
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
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
<<<<<<< HEAD
=======
    id: [''],
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    name: [''],
    status: [''],
    desc: [''],
    usage: [''],
    parameters: this.fb.array([
<<<<<<< HEAD
     // this.createParameter()
=======
      // this.createParameter()
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    ]),

    tags: this.fb.array([]),
    // parameters:this.fb.array([])
  });

<<<<<<< HEAD

=======
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  createParameter(): FormGroup {
    return this.fb.group({
      parameterName: [''],
      default: [''],
      required: [''],
      description: ['']
    });
  }

<<<<<<< HEAD

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params: ParamMap) => {
=======
  fillParameter(parameterNames, defaultvalue, requiredValue, descriptionValue): FormGroup {
    return this.fb.group({
      parameterName: parameterNames,
      default: defaultvalue,
      required: requiredValue,
      description: descriptionValue
    });
  }



  ngOnInit() {
    if (this.receivedData !== undefined) {
      this.Form.patchValue({
        id: this.receivedData.id,
        name: this.receivedData.name,
        desc: this.receivedData.desc,
        status: this.receivedData.status,
        usage: this.receivedData.usage,
      });





      for (const i of this.receivedData.tags) {
        this.tags.push(this.fb.control(i));
      }
      // console.log(this.receivedData);

      for (const parameter of this.receivedData.parameters) {
        this.parameters.push(this.fillParameter(
          parameter.parameterName,
          parameter.default_value,
          parameter.required,
          parameter.description));
      }


    }

    this.route.paramMap.subscribe((params: ParamMap) => {
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
      // tslint:disable-next-line: radix
      const id = parseInt(params.get('id'));
      this.selectedId = id;
    });
  }
<<<<<<< HEAD
  onSubmit() {
    this.command.addCommands(this.Form.value).subscribe(
      data => console.log('Success', data),
      error => console.log('e', error));
  }

=======

  // updateData=updated recevieddata

  onSubmit(formData) {
    if (this.receivedData === undefined) {
      console.log('it works');
      this.command.addCommands(this.Form.value).subscribe(
        data => console.log('Success', data),
        error => console.log('e', error));
      this.router.navigateByUrl('/command-list');
    } else {
      console.log('sach me nhya data h.', formData);
      this.command.updateCommands(formData).subscribe(
        data => console.log('Success', data),
        error => console.log('e', error));
      this.router.navigateByUrl('/command-list');
    }
  }


>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  onCancel() {
    this.router.navigateByUrl('/command-list');
  }
  addTags() {
    this.tags.push(this.fb.control(''));
  }
  addParameters() {

<<<<<<< HEAD
 // this.tags.push(this.fb.control(''));
=======
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    this.parameters.push(this.createParameter());
  }

}
