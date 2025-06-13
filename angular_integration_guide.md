# Angular Backend Integration Guide

This guide provides instructions and examples for connecting an Angular application to the project's backend APIs.

## 1. Setting up Angular Services with HttpClientModule

To communicate with backend APIs, Angular uses the `HttpClient` service. You need to import `HttpClientModule` into your main application module (usually `app.module.ts`).

**`app.module.ts`:**
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule

import { AppComponent } from './app.component';
// ... other imports

@NgModule({
  declarations: [
    AppComponent,
    // ... other components
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Add HttpClientModule here
    // ... other modules
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

Now, you can create Angular services and inject `HttpClient` to make HTTP requests.

**Example Service Structure (`client.service.ts`):**
```typescript
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

// Define interfaces for your DTOs/Entities if desired (recommended)
export interface ClientDTO {
  idClient?: number; // Optional for creation
  nomClient: string;
  prenomClient: string;
  dateNaiss: string; // Or Date, handle conversion appropriately
  mailClient: string;
  telClient: string;
  sexeClient: string;
  login: string;
  password?: string; // Optional for updates/responses
  // Add any other relevant fields from ClientDTO
}

// Interface for the raw CLIENT entity if used for POST
export interface Client {
  idClient?: number;
  nomClient: string;
  prenomClient: string;
  dateNaiss: string;
  mailClient: string;
  telClient: string;
  sexeClient: string;
  login: string;
  password?: string; // Password might be required for creation
}


@Injectable({
  providedIn: 'root' // Service available application-wide
})
export class ClientService {
  private baseUrl = '/tg/voyage_pro/reservation/auth/client'; // Base URL from API documentation

  constructor(private http: HttpClient) { }

  // CRUD methods will go here
}
```

## 2. Example CRUD Operations

Here are examples for `CLIENT` and `VOYAGE` entities. Remember to define corresponding DTO interfaces (e.g., `ClientDTO`, `VoyageDTO`) in your Angular application for type safety.

### Client Service (`client.service.ts`)

```typescript
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

// Define interfaces for your DTOs/Entities
export interface ClientDTO {
  idClient?: number;
  nomClient: string;
  prenomClient: string;
  dateNaiss: string;
  mailClient: string;
  telClient: string;
  sexeClient: string;
  login: string;
  password?: string; 
}

// Raw CLIENT entity as expected by POST /create
export interface Client {
  idClient?: number;
  nomClient: string;
  prenomClient: string;
  dateNaiss: string; 
  mailClient: string;
  telClient: string;
  sexeClient: string;
  login: string;
  password?: string; 
}

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private baseUrl = '/tg/voyage_pro/reservation/auth/client'; 

  // Standard HTTP options
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  // POST /create (expects full CLIENT object)
  createClient(clientData: Client): Observable<Client> {
    return this.http.post<Client>(`${this.baseUrl}/create`, clientData, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // GET /getAll
  getAllClients(): Observable<ClientDTO[]> {
    return this.http.get<ClientDTO[]>(`${this.baseUrl}/getAll`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // GET /get/{idClient}
  getClientById(idClient: number): Observable<ClientDTO> {
    return this.http.get<ClientDTO>(`${this.baseUrl}/get/${idClient}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // PUT /update/{idClient} (expects ClientDTO)
  updateClient(idClient: number, clientData: ClientDTO): Observable<ClientDTO> {
    return this.http.put<ClientDTO>(`${this.baseUrl}/update/${idClient}`, clientData, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // DELETE /delete/{idClient}
  deleteClient(idClient: number): Observable<any> { // Response type might vary (e.g., boolean, status message)
    return this.http.delete<any>(`${this.baseUrl}/delete/${idClient}`)
      .pipe(
        catchError(this.handleError)
      );
  }
  
  // PUT /search (expects ClientDTO for criteria)
  searchClients(searchCriteria: ClientDTO): Observable<ClientDTO[]> {
    return this.http.put<ClientDTO[]>(`${this.baseUrl}/search`, searchCriteria, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Basic error handler (see section 4 for more details)
  private handleError(error: any) {
    console.error('An API error occurred:', error);
    // Further error handling logic (e.g., user-friendly messages)
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
```

### Voyage Service (`voyage.service.ts`)

```typescript
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export interface VoyageDTO {
  idVoyage?: number;
  departVoyage: string;
  arriveVoyage: string;
  dateVoyage: string; // Or Date, handle conversion
}

@Injectable({
  providedIn: 'root'
})
export class VoyageService {
  private baseUrl = '/tg/voyage_pro/reservation/auth/voyage';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  // POST /create
  createVoyage(voyageData: VoyageDTO): Observable<VoyageDTO> { // Assuming response is VoyageDTO
    return this.http.post<VoyageDTO>(`${this.baseUrl}/create`, voyageData, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // GET /getAll
  getAllVoyages(): Observable<VoyageDTO[]> {
    return this.http.get<VoyageDTO[]>(`${this.baseUrl}/getAll`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // GET /get/{idVoyage}
  getVoyageById(idVoyage: number): Observable<VoyageDTO> { // Assuming response is VoyageDTO, though API doc says VOYAGE
    return this.http.get<VoyageDTO>(`${this.baseUrl}/get/${idVoyage}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  // PUT /update/{idVoyage}
  updateVoyage(idVoyage: number, voyageData: VoyageDTO): Observable<VoyageDTO> {
    return this.http.put<VoyageDTO>(`${this.baseUrl}/update/${idVoyage}`, voyageData, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  // DELETE /delete/{idVoyage}
  deleteVoyage(idVoyage: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete/${idVoyage}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('An API error occurred:', error);
    return throwError(() => new Error('Error in VoyageService; please try again.'));
  }
}
```

## 3. Handling Request Elements

### Request Headers
Headers like `Content-Type` are often required, especially for `POST` and `PUT` requests sending JSON data.

```typescript
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    // 'Authorization': 'Bearer YOUR_TOKEN' // Example for auth tokens
  })
};

// Use it in a request:
// this.http.post(url, data, httpOptions)
```

### Path Variables
Path variables are part of the URL. Use JavaScript template literals to build the URL.

```typescript
// For GET /get/{idClient}
const idClient = 123;
this.http.get<ClientDTO>(`${this.baseUrl}/get/${idClient}`);

// For PUT /update/{idClient}
// this.http.put<ClientDTO>(`${this.baseUrl}/update/${idClient}`, clientData, httpOptions);
```

### Query Parameters
Use `HttpParams` to add URL query parameters.

```typescript
import { HttpParams } from '@angular/common/http';

// Example: GET /api/items?orderBy=name&limit=10
let params = new HttpParams();
params = params.append('orderBy', 'name');
params = params.append('limit', '10');

// this.http.get(url, { params: params });
```
*(Note: The current API specification in `api_and_entity_summary.md` does not show endpoints that explicitly use query parameters, but this is how you would handle them.)*

### Request Bodies
For `POST` and `PUT` requests, the data (usually a JavaScript object matching the expected DTO/Entity structure) is passed as the second argument to `http.post()` or `http.put()`. `HttpClient` automatically converts it to JSON if `Content-Type` is `application/json`.

```typescript
// const clientData: Client = { /* ... */ };
// this.http.post<Client>(`${this.baseUrl}/create`, clientData, this.httpOptions);

// const voyageData: VoyageDTO = { /* ... */ };
// this.http.put<VoyageDTO>(`${this.baseUrl}/update/${idVoyage}`, voyageData, this.httpOptions);
```

## 4. Basic Error Handling in Angular Services

Use the `catchError` operator from RxJS to handle errors in your service calls.

```typescript
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

// ... inside your service method
return this.http.get<ClientDTO[]>(`${this.baseUrl}/getAll`)
  .pipe(
    catchError(this.handleError) // Reference to a private method
  );

// ... private handleError method in the service
private handleError(error: HttpErrorResponse) {
  if (error.error instanceof ErrorEvent) {
    // A client-side or network error occurred. Handle it accordingly.
    console.error('An error occurred:', error.error.message);
  } else {
    // The backend returned an unsuccessful response code.
    // The response body may contain clues as to what went wrong.
    console.error(
      `Backend returned code ${error.status}, ` +
      `body was: ${JSON.stringify(error.error)}`);
  }
  // Return an observable with a user-facing error message.
  return throwError(() => new Error('Something bad happened; please try again later.'));
}
```
You can then subscribe to these services in your components and handle the errors for the user (e.g., display a message).

## 5. CORS (Cross-Origin Resource Sharing)

The backend controllers are annotated with `@CrossOrigin("*")`. This configuration tells the browser to allow requests from any origin (domain, port, or protocol).

**Implications for Angular Development:**
*   **Simplified Development**: For simple cases during local development (e.g., Angular app on `http://localhost:4200` and backend on `http://localhost:8080`), you generally **do not need to set up an Angular proxy** (`proxy.conf.json`) to bypass browser's same-origin policy. The backend already permits the cross-origin requests.
*   **Production**: While `*` is permissive, for production environments, it's often recommended to restrict the allowed origins to the specific domain where your Angular application is hosted for better security. This would be a backend configuration change.
*   **Cookies/Authentication**: If your application uses cookie-based authentication or sessions, `@CrossOrigin("*")` might not be sufficient, and you might need `allowCredentials = "true"` on the backend along with `withCredentials: true` in your Angular HTTP requests. However, for token-based authentication (e.g., JWT in Authorization header), this is less of an issue.

This guide should provide a solid starting point for integrating your Angular frontend with the provided backend APIs. Remember to adapt DTO/Entity interfaces and service methods based on the exact requirements of your application.
```
