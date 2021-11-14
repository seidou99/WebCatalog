export interface LoginResponse {
  email: string;
  jwt: string;
  name: string;
  roles: Array<string>;
  surname: string;
  userId: number;
}
