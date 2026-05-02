# Clean Architecture - Todo API

Projet **Clean Architecture** avec Java.

## Thème

API de gestion de tâches (Todo) développée en **Spring Boot 4 / Java 21**.

## Structure du projet

```
src/main/java/architecture/clean/java/
│
├── entities/task/
│   └── Task.java                    # Entité métier pure (aucun import Spring/JPA)
│
├── usecases/task/
│   ├── CreateTaskUseCase.java       # Port d'entrée : créer une tâche
│   ├── LoadTasksUseCase.java        # Port d'entrée : lister les tâches
│   ├── TaskRepositoryPort.java      # Port de sortie : abstraction persistence
│   └── TaskUseCaseService.java      # Implémentation des cas d'usage (@Service)
│
├── adapters/task/
│   ├── TaskJpaEntity.java           # Entité JPA (annotations @Entity, @Id…)
│   ├── TaskJpaRepository.java       # Spring Data JPA
│   └── TaskRepositoryAdapter.java   # Implémente TaskRepositoryPort (@Repository)
│
└── interfaces/task/
    ├── CreateTaskRequest.java       # DTO requête HTTP (avec validation)
    ├── TaskResponse.java            # DTO réponse HTTP
    └── TaskController.java          # REST Controller (@RestController)
```

## Lancer le projet

```bash
./mvnw spring-boot:run
```

L'application démarre sur [http://localhost:8080](http://localhost:8080).

## Endpoints

| Méthode | URL      | Description         | Body (JSON)              |
|---------|----------|---------------------|--------------------------|
| POST    | /tasks   | Créer une tâche     | `{ "title": "..." }`     |
| GET     | /tasks   | Lister les tâches   | —                        |

### Exemples avec curl

```bash
# Créer une tâche
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Apprendre Clean Architecture"}'

# Lister les tâches
curl http://localhost:8080/tasks
```

## Base de données

H2 en mémoire (données réinitialisées à chaque redémarrage).
Console disponible sur [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
JDBC URL : `jdbc:h2:mem:taskdb`

## Technologies

- Java 21
- Spring Boot 4
- Spring Data JPA
- H2 (base de données en mémoire)
- Lombok
- Maven
