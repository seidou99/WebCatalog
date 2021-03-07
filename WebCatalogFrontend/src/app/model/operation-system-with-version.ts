import {OperationSystem} from "./operation-system";

export class OperationSystemWithVersion {

  version: string;
  operationSystem: OperationSystem;

  constructor() {
    this.operationSystem = new OperationSystem();
  }
}
