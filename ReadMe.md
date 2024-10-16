# Expense Tracker API

An API for managing personal expenses, built using Spring Boot. This application allows users to create, read, update, and delete (CRUD) expenses. The expenses are stored in a Supabase database, and the API supports JSON-based communication.

## Features

- Add a new expense with details such as title, description, category, date, and amount.
- Retrieve all expenses, sorted by the most recent date.
- Retrieve an expense by its ID.
- Update an existing expense.
- Delete an expense by ID.
- Exception handling for invalid or non-existent resources.

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Database**: Supabase (PostgreSQL)
- **Hosting**: Railway
- **Dependencies**:
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-web`
  - `lombok`
  - `jakarta.persistence`
  
## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kashan16/ExpenseTrackerAPI.git
   cd ExpenseTrackerAPI
   ```

2. **Set up the database**:
   - Configure your Supabase database connection in `application.properties` by adding the necessary connection details. Ensure your Supabase credentials are properly set.

3. **Run the application**:
   - If you are using Maven, you can start the application with:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Alternatively, run the `ExpenseTrackerApiApplication` class directly from your IDE.

4. **Access the API**:
   - The API is available at `https://expensetrackerapi-production-4874.up.railway.app/api/expense`.

## API Endpoints

| HTTP Method | Endpoint              | Description                               |
|-------------|-----------------------|-------------------------------------------|
| `POST`      | `/api/expense`         | Create a new expense                      |
| `GET`       | `/api/expense/all`     | Get all expenses                          |
| `GET`       | `/api/expense/{id}`    | Get an expense by ID                      |
| `PUT`       | `/api/expense/{id}`    | Update an existing expense by ID          |
| `DELETE`    | `/api/expense/{id}`    | Delete an expense by ID                   |

### Example Payloads

- **Create/Update Expense** (POST/PUT):
  ```json
  {
    "title": "Groceries",
    "description": "Weekly grocery shopping",
    "category": "Food",
    "date": "2024-09-20",
    "amount": 100
  }
  ```

## Usage

Once the application is running, you can interact with the API using tools like [Postman](https://www.postman.com/) or [cURL](https://curl.se/).

Example request to add an expense:

```bash
curl -X POST https://expensetrackerapi-production-4874.up.railway.app/api/expense \
-H "Content-Type: application/json" \
-d '{
  "title": "Groceries",
  "description": "Weekly grocery shopping",
  "category": "Food",
  "date": "2024-09-20",
  "amount": 100
}'
```

## Project Structure

- **Entity**: Contains the `Expense` entity with attributes: `id`, `title`, `description`, `category`, `date`, `amount`.
- **Repository**: Provides CRUD operations on the `Expense` entity.
- **Service**: Handles the business logic for expenses.
- **Controller**: Defines the API endpoints for managing expenses.
- **DTO**: Transfers data between layers to avoid exposing internal entity structure.

## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License.

---