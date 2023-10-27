import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { EntrypointComponent } from "./pages/entrypoint/entrypoint.component";
import {StudentRoutingModule} from "./student-routing.module";

@NgModule({
    declarations: [EntrypointComponent],
    imports: [
        CommonModule,
        StudentRoutingModule
    ],
    providers: [],
})
export class StudentModule { }
