import { Injectable } from '@angular/core';
import {HttpHelper} from "../../../../common/helpers/http/http.helper";
import {Observable, take} from "rxjs";
import {Video} from "../../types/video";
import {endpoints} from "../../../../common/constants/endpoints";
import {SessionService} from "../../../../common/service/session/session.service";

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  constructor(private readonly httpHelper: HttpHelper, private readonly sessionService: SessionService) { }

  public getVideo(id: string): Observable<Video> {
    return this.httpHelper.get<Video>({
      url: endpoints.host + endpoints.video,
      params: { id },
      sessionToken: this.sessionService.getSessionToken()
    })
      .pipe(take(1))
  }
}
