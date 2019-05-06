import { Routes, RouterModule } from "@angular/router";
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';

const authRoutes:Routes=[
{
    path:'',
    children:[
        {
            path:'',
            redirectTo:'/login',
            pathMatch:'full'
        },
        {
            path:'register',
            component:RegisterComponent
        },
        {
            path:'login',
            component:LoginComponent
        }
    ]

}

];

@NgModule({
    imports:[RouterModule.forRoot(authRoutes)],
    exports:[RouterModule]
})

export class AuthenticationRoutingModule{
    
}