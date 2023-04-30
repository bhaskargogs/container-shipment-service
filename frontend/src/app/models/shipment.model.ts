

export interface Shipment {
    id: Number,

    origin: String,

    destination?: String,

    customerId: String,

    createdDate: Number,

    fragile: Boolean,

    notifyCustomer: Boolean,

    transportType: TransportType,
    temperatureRange: TemperatureRange
}

export enum TransportType {
    AIR = 'AIR',
    SEA = 'SEA',
    ROAD = 'ROAD'
}

export interface TemperatureRange {
    id: Number,
    min: Number,
    max: Number
}

export interface Action {
    id: Number,
    name: String,
}

export interface PlanTemplate {
    id?: Number,
    name?: String,
    actions?: Action[]
}

export interface ExecutionPlanAction {
    id: Number,
    actionName: String,
    isExecuted: Boolean,
    isNotify: Boolean,
}

export interface ExecutionPlan {
    id: Number,
    origin: String,
    destination: String,
    customerId: String,
    transportType: TransportType,
    temperature: TemperatureRange,
    fragile: Boolean,
    notifyCustomer: Boolean,
    templateId: Number,
    actions: ExecutionPlanAction[]
}