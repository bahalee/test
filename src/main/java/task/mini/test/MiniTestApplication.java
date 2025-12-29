package task.mini.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniTestApplication.class, args);
        System.out.println("Application démarrée avec succès !");
        System.out.println(" API disponible sur: http://localhost:8080");
        System.out.println(" Endpoints CRUD:");
        System.out.println("   GET    /api/todos          - Liste des tâches");
        System.out.println("   GET    /api/todos/{id}     - Récupérer une tâche");
        System.out.println("   POST   /api/todos          - Ajouter une tâche");
        System.out.println("   PUT    /api/todos/{id}     - Modifier une tâche");
        System.out.println("   DELETE /api/todos/{id}     - Supprimer une tâche");
        System.out.println("   GET    /api/todos/count    - Nombre de tâches");
        System.out.println(" Interface web: http://localhost:8080");
    }
}