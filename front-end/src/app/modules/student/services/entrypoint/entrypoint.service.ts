import { Injectable } from '@angular/core';
import {HttpHelper} from "../../../../common/helpers/http/http.helper";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EntrypointService {

  constructor(private readonly httpHelper: HttpHelper) { }

  public entrypointTokenValidation(token: string): Observable<void> {
    return this.httpHelper.post({ url: 'http://localhost:8080/token', body: {
       localName: 'foo',
        domain: 'bar',
      }});
  }
}
