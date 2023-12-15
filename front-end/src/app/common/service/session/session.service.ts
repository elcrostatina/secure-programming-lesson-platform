import {StorageHelper} from "../../helpers/storage/storage.helper";
import {Session} from "../../enums/session.enum";

export class SessionService {

  constructor(private readonly storageHelper: StorageHelper) {
  }

    public setSessionToken(sessionToken: string): void {
        this.storageHelper.setItem(Session.SessionToken, sessionToken)
    }

  public getSessionToken(): string {
      const token = this.storageHelper.getItem(Session.SessionToken);

      if (!token) {
          throw new Error('Session token not found');
      }

      return token;
    }
}
