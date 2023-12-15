import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { EntrypointComponent } from "./pages/entrypoint/entrypoint.component";
import {StudentRoutingModule} from "./student-routing.module";
import {VideoComponent} from "./pages/video/video.component";

@NgModule({
    declarations: [EntrypointComponent, VideoComponent],
    imports: [
        CommonModule,
        StudentRoutingModule
    ],
    providers: [],
})
export class StudentModule { }
