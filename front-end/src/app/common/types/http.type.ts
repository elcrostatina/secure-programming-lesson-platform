import {HttpHeaders} from "@angular/common/http";

export type BaseRequestParams = {
    url: string;
    headers?: HttpHeaders;
    sessionToken?: string;
}

export type BodyRequestParams<T> = BaseRequestParams & {
    body?: T;
}
