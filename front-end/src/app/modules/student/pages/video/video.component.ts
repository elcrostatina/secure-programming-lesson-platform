import { Component, OnInit } from '@angular/core';
import {VideoService} from "../../services/video/video.service";
import {ActivatedRoute} from "@angular/router";
import {merge, mergeMap} from "rxjs";

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.scss']
})
export class VideoComponent implements OnInit {
  public video?: string;

  constructor(private readonly videoService: VideoService, private readonly router: ActivatedRoute) { }

  ngOnInit(): void {
    this.getVideo();
  }

  private getVideo(): void {
    this.router.queryParams
      .pipe(mergeMap(queryParam => this.videoService.getVideo(queryParam['id'])))
      .subscribe({
        next: (video) => this.video = video,
        error: (error) => console.log(error),
      })
  }
}
