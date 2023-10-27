import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {BaseRequestParams, BodyRequestParams} from "../../types/http.type";

@Injectable({
  providedIn: 'root'
})
export class HttpHelper {

  constructor(private readonly httpClient: HttpClient) { }

  public get<T>(params: BaseRequestParams): Observable<T> {
    return this.httpClient.get<T>(params.url, { headers: this.headerHandler(params) });
  }

    public post<Response, Body>(params: BodyRequestParams<Body>): Observable<Response> {
      return this.httpClient.post<Response>(params.url, params.body, { headers: this.headerHandler(params) } );
    }

    private headerHandler(params: {headers?: HttpHeaders, sessionToken?: string }):  HttpHeaders {
     const headers: Record<any, any> = { ...params.headers }

      if (params.sessionToken) {
        headers['Authorization'] = params.sessionToken;
      }

      return headers as HttpHeaders;

    }
}
