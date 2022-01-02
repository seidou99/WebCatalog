import {Component, OnInit} from '@angular/core';
import {User} from '../../model/User';
import {UserService} from '../../services/user.service';
import {ActivatedRoute} from "@angular/router";
import {ApiConstants} from "../../Constants";

@Component({
  selector: 'app-show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

  user: User = null;

  constructor(protected userService: UserService, protected route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    const userId = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    this.user = await this.userService.getById(userId).toPromise();
    console.log('user', this.user);
  }

  getUserRolesAsString(): string {
    let result = '';
    if (this.user !== null) {
      result = this.user.roles.map(r => r.name).join(', ');
    }
    return result;
  }

}
