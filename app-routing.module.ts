import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AggeragteMarksComponent } from './aggeragte-marks/aggeragte-marks.component';
import { DeleteComponent } from './delete/delete.component';
import { GradeComponent } from './grade/grade.component';
import { InsertComponent } from './insert/insert.component';
import { UpdateComponent } from './update/update.component';


const routes: Routes = [
  {path:'insert',component:InsertComponent},
  {path:'delete',component:DeleteComponent},
  {path:'update',component:UpdateComponent},
  {path:'aggergatemarks',component:AggeragteMarksComponent},
  {path:'grade',component:GradeComponent}
  
];

@NgModule({

  imports: [RouterModule.forRoot(routes)],


  exports: [RouterModule]
})
export class AppRoutingModule { }
