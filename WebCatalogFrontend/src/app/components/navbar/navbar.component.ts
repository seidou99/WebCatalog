import { Component, OnInit } from '@angular/core';
import {LocalStorageService} from "../../services/local-storage.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public localStorageService: LocalStorageService) { }

  ngOnInit(): void {
  }

}
