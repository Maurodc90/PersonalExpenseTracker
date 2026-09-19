# Personal Expense Tracker

A REST API built with Spring Boot that loads expense data from a JSON file and provides endpoints for listing and filtering transactions.

## Tech Stack

- Java 21
- Spring Boot
- Jackson (JSON serialization/deserialization)
- Lombok (boilerplate reduction)
- Gradle

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/expenses` | List all expenses |
| GET | `/categories` | List available categories |
| GET | `/categories/{category}` | Filter expenses by category |
| GET | `/accounts` | List available accounts |
| GET | `/accounts/{account}` | Filter expenses by account |
| GET | `/date/{date}` | Filter expenses by date (yyyy-MM-dd) |

## Sample Data

The API ships with sample transactions representing a month of personal finances — a mix of income (salary, freelancing) and everyday spending:

```json
{
  "type": false,
  "date": "2026-09-05",
  "amount": 85.0,
  "category": "dining",
  "account": "credit card",
  "note": "Dinner with Elçin"
}
```

Entries without a note are omitted from the JSON response rather than showing null, using Jackson's `@JsonInclude(NON_NULL)`.


## Project Structure

```
src/main/java/com/maurodelcore/personalexpensetracker/
├── PersonalexpensetrackerApplication.java
├── controller/
│   └── PersonalExpenseController.java
├── model/
│   └── Expense.java
└── service/
    └── PersonalExpenseService.java
```



## Running

```bash
./gradlew bootRun
```

Then open `http://localhost:8080/expenses` in a browser or Postman.

## What I Practiced

- Jackson ObjectMapper for JSON deserialization
- `TypeReference` for generic collection types
- `@PostConstruct` for startup data loading
- `try-with-resources` for safe InputStream handling
- Lombok `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`
- `@JsonInclude(NON_NULL)` for clean API responses
- Service layer pattern (controller → service separation)
- `@PathVariable` for URL-based filtering