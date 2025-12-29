package task.mini.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniTestApplication.class, args);
        System.out.println(" Application démarrée avec succès !");
        System.out.println(" API disponible sur: http://localhost:8080");
        System.out.println(" Endpoints:");
        System.out.println("   GET  /api/todos      - Liste des tâches");
        System.out.println("   POST /api/todos      - Ajouter une tâche");
        System.out.println("   GET  /api/todos/count - Nombre de tâches");
    }
}