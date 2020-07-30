import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AdressComponent} from './adress/adress.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
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
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { AuthGaurdService } from './services/auth-gaurd.service';
import { JwtAuthHtppInterceptorService } from './services/jwt-auth-interceptor-service.service';



const appRoutes: Routes = [
  {path: 'welcome', component: WelcomeComponent,canActivate:[AuthGaurdService] },
  {path: 'students', component: StudentComponent,canActivate:[AuthGaurdService] },
  {path: 'list_students', component: ListStudentComponent,canActivate:[AuthGaurdService] },
  {path: 'student_detail/id/:id', component: StudentDetailsComponent,canActivate:[AuthGaurdService] },
  {path: 'staff', component: StaffComponent,canActivate:[AuthGaurdService] },
  {path: 'staff_detail/id/:id', component: DetailStaffComponent,canActivate:[AuthGaurdService] },
  {path: 'list_staff', component: ListStaffComponent,canActivate:[AuthGaurdService] },
  {path: 'messages', component: MessagesComponent,canActivate:[AuthGaurdService] },
  {path: 'list_messages', component: ListmessagesComponent,canActivate:[AuthGaurdService] },
  {path: 'list_messages/page/:p/of/:n', component: ListmessagesComponent,canActivate:[AuthGaurdService] },
  {path: 'detail_message/:id', component: DetailmessageComponent,canActivate:[AuthGaurdService] },
  {path: 'people', component: PersonComponent,canActivate:[AuthGaurdService] },
  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService]  },
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
    DetailmessageComponent,
 LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [Room, Contact, Addres, Department, Person, ServiceforallService,   {  
    provide:HTTP_INTERCEPTORS, useClass:JwtAuthHtppInterceptorService, multi:true 
  }],
  bootstrap: [AppComponent]
})
export class AppModule {}
