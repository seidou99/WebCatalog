import {BaseDataObjectWithName} from "./base-data-object";
import {OperationSystemType} from "./operation-system-type";

export class OperationSystem extends BaseDataObjectWithName {
  type: OperationSystemType;
}
