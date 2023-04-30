import {Component, Input, OnInit} from '@angular/core';
import {Action, PlanTemplate, Shipment} from "../../models/shipment.model";
import {FormBuilder, Validators} from "@angular/forms";
import {ShipmentService} from "../../services/shipment.service";

@Component({
  selector: 'execution-plan-model',
  templateUrl: './execution-plan-model.component.html',
  styleUrls: ['./execution-plan-model.component.scss']
})
export class ExecutionPlanModelComponent implements OnInit {

  actions: Action[] = [
    {id: 1, name: 'shipment is taken from customer'},
    {id: 2, name: 'shipment is on the way'},
    {id: 3, name: 'shipment is arrived to destination'},
    {id: 4, name: 'shipment is handover to the destination target'}
  ];

  @Input()
  shipment: Shipment;

  templateForm = this.formBuilder.group({
    templateName: ['', [Validators.required]]
  })

  constructor(private formBuilder: FormBuilder, private shipmentService: ShipmentService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    const shipment = this.shipment;
    const template: PlanTemplate = {};
    template.id = 1;
    template.name = this.templateForm.get('templateName').value;
    template.actions = this.actions

    this.shipmentService.createExecutionPlan(shipment, template)
    .subscribe(response => console.log(response));

    if (this.templateForm.invalid) {
      return;
    }
  }


  }
