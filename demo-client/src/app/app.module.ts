import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { PersonsListComponent } from './persons/persons-list/persons-list.component';
import { PersonDetailsComponent } from './persons/person-details/person-details.component';
import { CreatePersonComponent } from './persons/create-person/create-person.component';

import { PersonService } from './persons/person.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonsListComponent,
    PersonDetailsComponent,
    CreatePersonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})

export class AppModule { }
