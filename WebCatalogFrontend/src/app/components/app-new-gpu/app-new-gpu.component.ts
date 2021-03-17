import { Component, OnInit } from '@angular/core';
import {Gpu} from "../../model/gpu";

@Component({
  selector: 'app-app-new-gpu',
  templateUrl: './app-new-gpu.component.html',
  styleUrls: ['./app-new-gpu.component.css']
})
export class AppNewGpuComponent implements OnInit {

  result = new Gpu();

  constructor() { }

  ngOnInit(): void {
  }

}
