import {Component, OnInit} from '@angular/core';
import {MobileGpu} from "../../model/mobileGpu";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-app-new-gpu',
  templateUrl: './app-new-gpu.component.html',
  styleUrls: ['./app-new-gpu.component.css']
})
export class AppNewGpuComponent implements OnInit {

  result: FormGroup;

  constructor(protected fb: FormBuilder) {
    this.result = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(1)]],
      clockSpeedInMHz: [null, [Validators.required, Validators.min(1)]]
    });
  }

  getResult(): MobileGpu {
    const rawValue = this.result.getRawValue();
    return new MobileGpu(rawValue.name, rawValue.clockSpeedInMHz);
  }

  ngOnInit(): void {
  }

}
