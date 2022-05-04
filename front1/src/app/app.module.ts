import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfilComponent } from './profil/profil.component';
import { NotificationComponent } from './notification/notification.component';
import { FindjobComponent } from './findjob/findjob.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ConseilcarriereComponent } from './conseilcarriere/conseilcarriere.component';
import { DeconnexionComponent } from './deconnexion/deconnexion.component';
import { NodataComponent } from './nodata/nodata.component';
import { HomeComponent } from './home/home.component';
import { CvComponent } from './cv/cv.component';
import { AlertesComponent } from './alertes/alertes.component';
import { CompteComponent } from './compte/compte.component';
import { MesoffresComponent } from './mesoffres/mesoffres.component';
import { Navbar1Component } from './navbar1/navbar1.component';
import { Navbar2Component } from './navbar2/navbar2.component';
import { ProfilstaticComponent } from './profilstatic/profilstatic.component';
import { DashbordclientComponent } from './dashbordclient/dashbordclient.component';
import { ContactusComponent } from './contactus/contactus.component';
import { PostjobComponent } from './postjob/postjob.component';

import { ProfilstaticjobComponent } from './profilstaticjob/profilstaticjob.component';
import { GgComponent } from './gg/gg.component';

import { MyaccountComponent } from './myaccount/myaccount.component';
import { Navbar3Component } from './navbar3/navbar3.component';
import { PagegardeComponent } from './pagegarde/pagegarde.component';
import { OffreemploieComponent } from './offreemploie/offreemploie.component';


@NgModule({
  declarations: [
    AppComponent,
    ProfilComponent,
    NotificationComponent,
    FindjobComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    ConseilcarriereComponent,
    DeconnexionComponent,
    NodataComponent,
    HomeComponent,
    CvComponent,
    AlertesComponent,
    CompteComponent,
    MesoffresComponent,
    Navbar1Component,
    Navbar2Component,
    ProfilstaticComponent,
    DashbordclientComponent,
    ContactusComponent,
    PostjobComponent,

    ProfilstaticjobComponent,
    GgComponent,

    MyaccountComponent,
     Navbar3Component,
     PagegardeComponent,
     OffreemploieComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {
        path:'cv',component :CvComponent ,

      } ,
      {
        path :'alertes',component:AlertesComponent
      },
      {
        path :'compte',component:CompteComponent
      },
      {
        path :'mesoffres',component:MesoffresComponent
      },
      {
        path :'Dashbord',component:DashbordclientComponent
      }

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
