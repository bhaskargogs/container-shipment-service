import {ExecutionPlan, PlanTemplate, Shipment, TransportType} from "../models/shipment.model";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class ShipmentService {

    private shipments: Shipment[] = [];

    constructor(private http: HttpClient) { }


    getShipments(): Observable<Shipment[]>{
        return this.http.get<Shipment[]>('http://localhost:8081/rest/container/shipments');
    }

    getShipmentById(shipmentId: Number): Shipment | null {
        return this.shipments.find(it => it.id == shipmentId) || null;
    }

    getExecutionPlans(): Observable<ExecutionPlan[]> {
        return this.http.get<ExecutionPlan[]>('http://localhost:8081/rest/container/executionplans');
    }

    createExecutionPlan(shipment: Shipment, template: PlanTemplate) {
        return this.http.post<ExecutionPlan>('http://localhost:8081/rest/container/executionplans', {shipment, template});
    }

}