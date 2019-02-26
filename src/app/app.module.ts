import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AdressComponent} from './adress/adress.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {PersonComponent} from './person/person.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {StudentComponent} from './student/student.component';
import {StaffComponent} from './staff/staff.component';
import {RouterModule, Routes} from '@angular/router';
import {WelcomeComponent} from './welcome/welcome.component';
import {MessagesComponent} from './messages/messages.component';
import {Room} from './model/room';
import {Contact} from './model/contact';
import {Addres} from './model/addres';
import {Department} from './model/department';
import {Person} from './model/person';
import {ServiceforallService} from './services/serviceforall.service';
import { ListMessagesComponent } from './list-messages/list-messages.component';
import { ListmessagesComponent } from './messages/listmessages/listmessages.component';
import { ListStudentComponent } from './student/list-student/list-student.component';
import { ListStaffComponent } from './staff/list-staff/list-staff.component';
import { StudentDetailsComponent } from './student/student-details/student-details.component';
import { DetailStaffComponent } from './staff/detail-staff/detail-staff.component';
import { DetailmessageComponent } from './messages/detailmessage/detailmessage.component';

const appRoutes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'students', component: StudentComponent},
  {path: 'list_students', component: ListStudentComponent},
  {path: 'student_detail/id/:id', component: StudentDetailsComponent},
  {path: 'staff', component: StaffComponent},
  {path: 'staff_detail/id/:id', component: DetailStaffComponent},
  {path: 'list_staff', component: ListStaffComponent},
  {path: 'messages', component: MessagesComponent},
  {path: 'list_messages', component: ListmessagesComponent},
  {path: 'list_messages/page/:p/of/:n', component: ListmessagesComponent},
  {path: 'detail_message/:id', component: DetailmessageComponent},
  {path: 'people', component: PersonComponent},
  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  {path: '**', redirectTo: '/welcome', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    AdressComponent,
    PersonComponent,
    HeaderComponent,
    FooterComponent,
    StudentComponent,
    StaffComponent,
    WelcomeComponent,
    MessagesComponent,
    ListMessagesComponent,
    ListmessagesComponent,
    ListStudentComponent,
    ListStaffComponent,
    StudentDetailsComponent,
    DetailStaffComponent,
    DetailmessageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [Room, Contact, Addres, Department, Person, ServiceforallService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
