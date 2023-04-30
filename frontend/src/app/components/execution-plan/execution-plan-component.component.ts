import { Component, OnInit } from '@angular/core';
import {ExecutionPlan, TransportType} from "../../models/shipment.model";
import {ShipmentService} from "../../services/shipment.service";

@Component({
  selector: 'execution-plan-component',
  templateUrl: './execution-plan-component.component.html',
  styleUrls: ['./execution-plan-component.component.scss']
})
export class ExecutionPlanComponentComponent implements OnInit {
  AIR: TransportType = TransportType.AIR;
  ROAD: TransportType = TransportType.ROAD;
  SEA: TransportType = TransportType.SEA;
  executionPlans: ExecutionPlan[] = [];

  constructor(private shipmentService: ShipmentService) { }

  ngOnInit(): void {
    this.shipmentService.getExecutionPlans().subscribe(executionPlans => this.executionPlans = executionPlans);
  }

}
