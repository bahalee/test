# Mini Test Technique - Todo API Spring Boot

Application Spring Boot simple développée pour un test technique en 30 minutes.

##  Fonctionnalités

- API REST complète pour la gestion de tâches (Todos)
- Stockage en mémoire (sans base de données)
- Validation des données
-  Interface web simple intégrée
-  Configuration CORS pour le frontend

## API Endpoints
### Endpoints CRUD Complets

| Méthode | URL | Description | Body |
|---------|-----|-------------|------|
| **GET** | `/api/todos` | Liste toutes les tâches | - |
| **GET** | `/api/todos/{id}` | Récupère une tâche spécifique | - |
| **POST** | `/api/todos` | Ajoute une nouvelle tâche | `{"title": "Tâche"}` |
| **PUT** | `/api/todos/{id}` | Met à jour une tâche | `{"title": "Nouveau", "completed": true}` |
| **DELETE** | `/api/todos/{id}` | Supprime une tâche | - |

## 🛠️ Technologies utilisées

- Java 17
- Spring Boot 3.1.5
- Maven
- Git

## ⚡ Installation



## 🌐 Accès

- API : http://localhost:8080/api/todos
- Interface : http://localhost:8080
