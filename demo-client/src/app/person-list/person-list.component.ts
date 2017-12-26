import {PersonService} from '../shared/person/person.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  persons: Array<any>;

  constructor(private personService: PersonService) {}

  ngOnInit() {
    this.personService.getAll().subscribe(data => {
      this.persons = data;
    });
  }

}
