import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Task> tasks = new ArrayList<>();

    static Task addTask() {
        System.out.println("***** Add Task *****");
        System.out.println("Enter Task Id:");
        Scanner sc = new Scanner(System.in);
        int taskId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Task description:");
        String taskDescription = sc.nextLine();
        System.out.println("Enter Task Status:");
        String taskStatus = sc.nextLine();
        return new Task(taskId, taskDescription, taskStatus);
    }

    static void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    static Task updateTask() {
        System.out.println("***** Update Task *****");
        System.out.println("Enter Task Id:");
        Scanner sc = new Scanner(System.in);
        int taskId = sc.nextInt();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                System.out.println("Enter Task description:");
                String taskDescription = sc.nextLine();
                System.out.println("Enter Task Status:");
                String taskStatus = sc.nextLine();
                task.setDescription(taskDescription);
                task.setStatus(taskStatus);
                return task;
            }
        }
        System.out.println("Task not found.");
        return null;
    }

    static List<Task> deleteTask() {
        System.out.println("***** Delete Task *****");
        System.out.println("Enter Task Id:");
        Scanner sc = new Scanner(System.in);
        int taskId = sc.nextInt();
        int indexToRemove = -1;
        for (int i=0; i<tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            tasks.remove(indexToRemove);
            System.out.println("Task deleted.");
        }
        else{
            System.out.println("Task not found");
        }
        return tasks;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("***** Enter one of the following option *****");
            System.out.println("Press 1: Add Task");
            System.out.println("Press 2: List All the tasks");
            System.out.println("Press 3: Update Task");
            System.out.println("Press 4: Delete Task");
            System.out.println("Press 5: Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Task task = addTask();
                    tasks.add(task);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    Task updatedTask = updateTask();
                    tasks.add(updatedTask);
                    break;
                case 4:
                    List <Task> updatedTasks = deleteTask();
                    tasks.addAll(updatedTasks);
            }
            if (choice == 5) {
                break;
            }
        }
    }
}