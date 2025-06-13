# Project Documentation

## Entities

This section describes the data models (entities) used in the application.

### 1. AGENT
Represents an agent in the system.

**Attributes:**
*   `idAgent` (Long, Primary Key, Auto-generated)
*   `nomAgent` (String, Not Null, Max Length 75)
*   `prenomAgent` (String, Max Length 75)
*   `sexeAgent` (String, Not Null, Max Length 1)
*   `dateNaiss` (Date, Not Null, Format: "dd/mm/yyyy")
*   `telAgent` (String, Not Null, Max Length 20)
*   `mailAgent` (String, Not Null, Max Length 20)

**Relationships:**
*   **PAIEMENT**: One-to-Many (An AGENT can be associated with multiple PAIEMENTs). Mapped by `agent` in `PAIEMENT`.

### 2. CLIENT
Represents a client using the system.

**Attributes:**
*   `idClient` (Long, Primary Key, Auto-generated)
*   `nomClient` (String, Not Null, Max Length 100)
*   `prenomClient` (String, Not Null, Max Length 100)
*   `dateNaiss` (Date, Not Null, Format: "dd/mm/yyyy")
*   `mailClient` (String, Not Null, Max Length 100)
*   `telClient` (String, Not Null, Max Length 50)
*   `sexeClient` (String, Not Null)
*   `login` (String, Not Null, Max Length 100)
*   `password` (String, Not Null, Max Length 50)

**Relationships:**
*   **RESERVATION**: One-to-Many (A CLIENT can have multiple RESERVATIONs). Mapped by `client` in `RESERVATION`.

### 3. PAIEMENT
Represents a payment transaction.

**Attributes:**
*   `codePaiement` (String, Primary Key, Not Null, Max Length 10)
*   `datePaiement` (Date, Not Null, Format: "yyyy-MM-dd")

**Relationships:**
*   **RESERVATION**: Many-to-One (A PAIEMENT belongs to one RESERVATION). Join column `reservation`.
*   **AGENT**: Many-to-One (A PAIEMENT is processed by one AGENT). Join column `agent`.

### 4. RESERVATION
Represents a reservation made by a client for a voyage.

**Attributes:**
*   `idReservation` (Long, Primary Key, Auto-generated)
*   `dateReservation` (Date, Format: "yyyy-MM-dd")

**Relationships:**
*   **CLIENT**: Many-to-One (A RESERVATION is made by one CLIENT). Join column `client_id`.
*   **VOYAGE**: Many-to-One (A RESERVATION is for one VOYAGE). Join column `voyage_id`.
*   **TYPE_BILLET**: Many-to-One (A RESERVATION has one TYPE_BILLET). Join column `type_billet_id`.
*   **PAIEMENT**: One-to-Many (A RESERVATION can have multiple PAIEMENTs). *Note: This relationship should be mapped by `reservation` in the `PAIEMENT` entity. The `RESERVATION.paiementList` field should have `mappedBy = "reservation"`.*

### 5. TYPE_BILLET
Represents the type of a ticket (e.g., class, price).

**Attributes:**
*   `idTypeBillet` (Long, Primary Key, Auto-generated)
*   `libelleTypeBillet` (String, Not Null)
*   `prixTypeBillet` (Double, Not Null)

**Relationships:**
*   **RESERVATION**: One-to-Many (A TYPE_BILLET can be associated with multiple RESERVATIONs). Mapped by `typeBillet` in `RESERVATION`.

### 6. VOYAGE
Represents a voyage or trip.

**Attributes:**
*   `idVoyage` (Long, Primary Key, Auto-generated)
*   `departVoyage` (String, Not Null, Max Length 100)
*   `arriveVoyage` (String, Not Null, Max Length 100)
*   `dateVoyage` (Date, Not Null, Format: "yyyy-MM-dd")

**Relationships:**
*   **RESERVATION**: One-to-Many (A VOYAGE can have multiple RESERVATIONs). Mapped by `voyage` in `RESERVATION`.

## API Endpoints

This section lists the available API endpoints.
Base Path Prefix for all controllers: `/tg/voyage_pro/reservation/auth`
CORS: Enabled for all origins (`*`) for most controllers.

### 1. ClientController
Base Path: `/tg/voyage_pro/reservation/auth/client`

*   **`POST /create`**
    *   **Description**: Creates a new client.
    *   **Request Method**: `POST`
    *   **Request Body**: `CLIENT` object (JSON)
    *   **Response**: `CLIENT` object (JSON), HTTP 200
*   **`GET /getAll`**
    *   **Description**: Retrieves all clients.
    *   **Request Method**: `GET`
    *   **Response**: `List<ClientDTO>` (JSON), HTTP 200
*   **`GET /get/{idClient}`**
    *   **Description**: Retrieves a specific client by ID.
    *   **Request Method**: `GET`
    *   **Path Variable**: `idClient` (Long)
    *   **Response**: `ClientDTO` (JSON), HTTP 302 (Found)
*   **`PUT /update/{idClient}`**
    *   **Description**: Updates an existing client.
    *   **Request Method**: `PUT`
    *   **Path Variable**: `idClient` (Long)
    *   **Request Body**: `ClientDTO` object (JSON)
    *   **Response**: `ClientDTO` (JSON), HTTP 200
*   **`DELETE /delete/{idClient}`**
    *   **Description**: Deletes a client by ID.
    *   **Request Method**: `DELETE`
    *   **Path Variable**: `idClient` (Long)
    *   **Response**: Implementation-specific (likely a status message), HTTP 200
*   **`PUT /search`**
    *   **Description**: Searches for clients based on criteria.
    *   **Request Method**: `PUT`
    *   **Request Body**: `ClientDTO` object (JSON) for search criteria.
    *   **Response**: `List<ClientDTO>` (JSON), HTTP 200
*   **`GET /refresh`**
    *   **Description**: Refreshes the client list (exact behavior depends on service implementation).
    *   **Request Method**: `GET`
    *   **Response**: `List<ClientDTO>` (JSON), HTTP 200

### 2. ReservationController
Base Path: `/tg/voyage_pro/reservation/auth/reservation`

*   **`POST /create`**
    *   **Description**: Creates a new reservation.
    *   **Request Method**: `POST`
    *   **Request Body**: `ReservationDTO` object (JSON)
    *   **Response**: `RESERVATION` object (JSON)
*   **`GET /all`**
    *   **Description**: Retrieves all reservations.
    *   **Request Method**: `GET`
    *   **Response**: `List<ReservationDTO>` (JSON)
*   **`GET /update`**
    *   **Description**: Updates a reservation. *(Potential Issue: Uses GET with a request body. Should be PUT or PATCH and include an ID in the path.)*
    *   **Request Method**: `GET`
    *   **Request Body**: `ReservationDTO` object (JSON)
    *   **Response**: `ReservationDTO` (JSON)
*   **`DELETE /delete/{id}`**
    *   **Description**: Deletes a reservation by ID.
    *   **Request Method**: `DELETE`
    *   **Path Variable**: `id` (Long)
    *   **Response**: `boolean`

### 3. TypeBilletcontroller
Base Path: `/tg/voyage_pro/reservation/auth/ticket`

*   **`POST /create`**
    *   **Description**: Creates a new ticket type.
    *   **Request Method**: `POST`
    *   **Request Body**: `TYPE_BILLET` object (JSON)
    *   **Response**: `TYPE_BILLET` object (JSON)
*   **`GET /getAll`**
    *   **Description**: Retrieves all ticket types.
    *   **Request Method**: `GET`
    *   **Response**: `List<TYPE_BILLET>` (JSON)
*   **`GET /get/{id}`**
    *   **Description**: Retrieves a specific ticket type by ID.
    *   **Request Method**: `GET`
    *   **Path Variable**: `id` (Long)
    *   **Response**: `TypeBilletDTO` (JSON)
*   **`PUT /update/{idType}`**
    *   **Description**: Updates an existing ticket type.
    *   **Request Method**: `PUT`
    *   **Path Variable**: `idType` (Long)
    *   **Request Body**: `TypeBilletDTO` object (JSON)
    *   **Response**: `TypeBilletDTO` (JSON)
*   **`DELETE /delete/{id}`**
    *   **Description**: Deletes a ticket type by ID.
    *   **Request Method**: `DELETE`
    *   **Path Variable**: `id` (Long)
    *   **Response**: `boolean`

### 4. VoyageController
Base Path: `/tg/voyage_pro/reservation/auth/voyage`

*   **`POST /create`**
    *   **Description**: Creates a new voyage.
    *   **Request Method**: `POST`
    *   **Request Body**: `VoyageDTO` object (JSON)
    *   **Response**: `VOYAGE` or `VoyageDTO` object (JSON), HTTP 201 (Created)
*   **`GET /getAll`**
    *   **Description**: Retrieves all voyages.
    *   **Request Method**: `GET`
    *   **Response**: `List<VoyageDTO>` (JSON), HTTP 200
*   **`GET /get/{idVoyage}`**
    *   **Description**: Retrieves a specific voyage by ID.
    *   **Request Method**: `GET`
    *   **Path Variable**: `idVoyage` (Long)
    *   **Response**: `VOYAGE` object (JSON), HTTP 302 (Found)
*   **`DELETE /delete/{idVoyage}`**
    *   **Description**: Deletes a voyage by ID.
    *   **Request Method**: `DELETE`
    *   **Path Variable**: `idVoyage` (Long)
    *   **Response**: Implementation-specific (likely a status message), HTTP 200
*   **`PUT /update/{idVoyage}`**
    *   **Description**: Updates an existing voyage.
    *   **Request Method**: `PUT`
    *   **Path Variable**: `idVoyage` (Long)
    *   **Request Body**: `VoyageDTO` object (JSON)
    *   **Response**: `VOYAGE` or `VoyageDTO` object (JSON), HTTP 200
---

*Self-correction: Noted a potential issue in `RESERVATION` entity's `paiementList` mapping during previous analysis and included it in the documentation.*
*Self-correction: Noted the unconventional `GET /update` endpoint in `ReservationController` and included the observation in the documentation.*
*Self-correction: Clarified DTO vs Entity usage for request/response where possible, based on controller code.*
