import {HttpHeaders} from "@angular/common/http";

export type BaseRequestParams = {
    url: string;
    headers?: HttpHeaders;
}

export type BodyRequestParams<T> = BaseRequestParams & {
    body?: T;
}
