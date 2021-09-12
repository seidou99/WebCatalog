import {Component, OnInit} from '@angular/core';
import {GeneratorService} from "../../services/generator.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {GeneratorApiConstants} from "../../Constants";

@Component({
  selector: 'app-app-generator',
  templateUrl: './app-generator.component.html',
  styleUrls: ['./app-generator.component.css']
})
export class AppGeneratorComponent implements OnInit {

  apiConstants = GeneratorApiConstants;

  constructor(public generatorService: GeneratorService, public snackBar: MatSnackBar) {
  }

  async callGenerator(apiUrl: string): Promise<void> {
    let message = 'GENERATION DONE';
    try {
      await this.generatorService.get(apiUrl).toPromise();
    } catch (e) {
      message = `ERROR CALLING ${apiUrl}`;
    }
    this.snackBar.open(message, 'OK', {duration: 3000});
  }

  ngOnInit(): void {
  }

}
