import { MyaccountComponent } from './myaccount/myaccount.component';
import { NodataComponent } from './nodata/nodata.component';
import { ConseilcarriereComponent } from './conseilcarriere/conseilcarriere.component';
import { FindjobComponent } from './findjob/findjob.component';
import { ProfilComponent } from './profil/profil.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfilstaticComponent } from './profilstatic/profilstatic.component';
import { ContactusComponent } from './contactus/contactus.component';
import { DashbordclientComponent } from './dashbordclient/dashbordclient.component';
import { DashbodadminComponent } from './dashbodadmin/dashbodadmin.component';
import { PostjobComponent } from './postjob/postjob.component';
import { ProfilstaticjobComponent } from './profilstaticjob/profilstaticjob.component';
import { GgComponent } from './gg/gg.component';
import { PagegardeComponent } from './pagegarde/pagegarde.component';
import { OffreemploieComponent } from './offreemploie/offreemploie.component';
import { NotificationComponent } from './notification/notification.component';


const routes: Routes = [
  {
    path:'profil',component : ProfilComponent ,

  } ,
  {
    path :'findjob',component:FindjobComponent
  },
  {
    path :'conseilcarriere',component:ConseilcarriereComponent
  },
  {
    path :'nodatafo',component:NodataComponent
  },
  {
    path :'home',component:HomeComponent
  },
  {
    path :'gg',component:GgComponent
  },

  {
    path :'Profilstatic',component:ProfilstaticComponent
  }
  ,

  {
    path :'contactus',component:ContactusComponent
  }
  ,

  {
    path :'dashbordadmin',component:DashbodadminComponent
  }
  ,

  {
    path :'dashbordclient',component:DashbordclientComponent
  }
 ,
 {
  path :'Postjob',component:PostjobComponent
},
{
  path :'profilstaticjob',component:ProfilstaticjobComponent
}
,
{
  path :'Myaccount',component:MyaccountComponent
},
{
  path :'homen',component:PagegardeComponent
},
{
  path:'offreemploie',component:OffreemploieComponent
}
,{
  path:'a',component:NotificationComponent
}





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
