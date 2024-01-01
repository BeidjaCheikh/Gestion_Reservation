import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Resource} from "../../Resource";

@Injectable({
  providedIn: 'root'
})
export class ResourceService {
private apiResourceUrl = 'http://localhost:9999/resource-service/api/resources';

  constructor(private http: HttpClient) {}

  public getResources(): Observable<Resource[]> {
    return this.http.get<Resource[]>(this.apiResourceUrl);
  }

  public addResource(resource: Resource): Observable<Resource> {
    return this.http.post<Resource>(`${this.apiResourceUrl}/create`, resource);
  }

  public updateResource(resourceId: number, resource: Resource): Observable<Resource> {
    return this.http.put<Resource>(`${this.apiResourceUrl}/update/${resourceId}`, resource);
  }
  public getResourceById(resourceId: number): Observable<Resource> {
    return this.http.get<Resource>(`${this.apiResourceUrl}/${resourceId}`);
  }

  public deleteResource(personId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiResourceUrl}/delete/${personId}`);
  }
}
