import java.time.LocalDateTime;

public class Task {
    int id;
    String description;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString(){
        return "TaskId: " +id + " " + "TaskDescription: "  +description + " " + "Status: " +status + " " +
               "CreatedAt: " +createdAt + " " + "UpdatedAt: " +updatedAt;
    }
}
