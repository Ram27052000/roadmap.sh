import java.time.LocalDateTime;

public class Task {
    int id;
    String description;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Task(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", description='" + description + "', status='" + status +
               "', createdAt=" + createdAt + ", updatedAt=" + updatedAt + "}";
    }
}
