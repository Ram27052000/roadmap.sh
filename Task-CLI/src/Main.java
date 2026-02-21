import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Task> tasks = new ArrayList<>();

    static Task addTask() {
        System.out.println("Enter taskid: ");
        int taskId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter task description: ");
        String taskDescription = sc.nextLine();
        System.out.println("Enter task status: ");
        String taskStatus = sc.nextLine();
        return new Task(taskId, taskStatus, taskDescription);
    }

    static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No task to show");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    static void updateTask() {
        System.out.println("Enter taskId to update: ");
        boolean found  = false;
        int taskId = sc.nextInt();
        sc.nextLine();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                System.out.println("Enter task description: ");
                String taskDescription = sc.nextLine();
                System.out.println("Enter task status: ");
                String taskStatus = sc.nextLine();
                task.setDescription(taskDescription);
                task.setStatus(taskStatus);
                found = true;
            }
        }
        if (! found) {
            System.out.println("No task to update");
        }
    }

    static void deleteTask() {
        System.out.println("Enter taskId to delete: ");
        int taskId = sc.nextInt();
        boolean removed = tasks.removeIf(task -> task.getId() == taskId);
        if(removed){
            System.out.println("Task has been deleted");
        }
        else{
            System.out.println("Task could not be deleted");
        }
    }


    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter one of the following options");
            System.out.println("1.Add Task");
            System.out.println("2.Get All tasks");
            System.out.println("3.Update tasks");
            System.out.println("4.Delete tasks");
            System.out.println("5.Exit");
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
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Good Bye!");
                    break;
            }
            if(choice == 5){
                break;
            }
        }
        sc.close();
    }
}