import {OperationSystem} from "./operation-system";

export class OperationSystemWithVersion {
  id: number;
  version: string;
  operationSystem: OperationSystem;

  constructor() {
    this.operationSystem = new OperationSystem();
  }
}
