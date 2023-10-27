import {AfterContentInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EntrypointService} from "../../services/entrypoint/entrypoint.service";

@Component({
  selector: 'app-entrypoint',
  templateUrl: './entrypoint.component.html',
  styleUrls: ['./entrypoint.component.scss']
})
export class EntrypointComponent implements AfterContentInit {
  public tokenValidationLoader: boolean = true;

  constructor(private readonly router: ActivatedRoute, private readonly entrypointService: EntrypointService) { }

  ngAfterContentInit(): void {
    this.router.queryParams.subscribe(params => {
      this.entrypointService.entrypointTokenValidation(params['token'])
          .subscribe({
            next: () => {},
            error: () => {},
            complete: () => {}
          });
    });
  }

}
