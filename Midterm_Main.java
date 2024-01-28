package Midterm;
//Nathan Lamoureux
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class Midterm_Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date creationDate = new Date();

        Midterm_Class ToDo = new Midterm_Class();

        loop:
        while (true) {


            //Displaying list to screen
            System.out.println("To Do List: (Created " + dateFormat.format(creationDate) + ")");

            ToDo.DisplayList();

            System.out.println("What would you like to do?");
            System.out.println("1(Add Item) 2(Delete Item) 3(Inspect Item) 4(Exit List)");
            int nextStep = keyboard.nextInt();

            switch (nextStep) {
                case 1:
                    ToDo.addItem();
                    break;
                case 2:
                    ToDo.deleteItem();
                    break;
                case 3:
                    ToDo.inspectItem();
                    break;
                case 4:
                    ToDo.changeCompletion();
                    break;
                case 5:
                    break loop;
            }
        }
        System.out.println("Exiting List");
    }

    static class Midterm_Item {
        private String completed;
        private java.util.Date completed_date;
        private String itemName;
        private String itemDescription;

        Midterm_Item(String itemName, String itemDescription) {
            this.completed_date = new Date();
            this.itemName = itemName;
            this.completed = "Incomplete";
            this.itemDescription = itemDescription;
        }

        public String getCompletedDate() {
            return this.completed_date.toString();
        }

        public String getCompleted() {
            return this.completed;
        }

        public String getItemName() {
            return this.itemName;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setDateCompleted() {
            this.completed_date = new Date();
            this.completed = "Complete";
        }


    }

    static class Midterm_Class {
        ArrayList<Midterm_Item> Tasks = new ArrayList<Midterm_Item>();
        Date creation;
        Scanner keyboard = new Scanner(System.in);
        int i;

        Midterm_Class() {
        }

        void DisplayList() {
            System.out.print(Tasks);
            if (Tasks.isEmpty()) {
                System.out.println("Looks like your to-do list is empty!");


            } else {
                for (int i = 0; i < Tasks.size(); i++) {
                    System.out.println(Tasks.get(i).getItemName());
                }
            }
        }

        void addItem() {
            System.out.println("What is the name of the item you want to add?");
            String itemName = keyboard.nextLine();
            System.out.println("What is the item description?");
            String itemDescription = keyboard.nextLine();
            Tasks.add(new Midterm_Item(itemName, itemDescription));

            System.out.println("The item is added!");
        }

        void deleteItem() {
            System.out.println("What is the name of the item you want to delete?");
            String itemName = keyboard.nextLine();
            for (int i = 0; i < Tasks.size(); i++) {
                if (Tasks.get(i).getItemName().equals(itemName)) {
                    Tasks.remove(i);
                }

            }
        }

        void inspectItem() {
            System.out.println("What is the name of the item you want to inspect?");
            String itemName = keyboard.nextLine();

            if(Tasks.get(i).getCompleted().equals("incorrect")) {
                System.out.println(Tasks.get(i).getItemName());
                System.out.println(Tasks.get(i).getItemDescription());
                System.out.println("Task is incomplete.");

            }
            else {
                System.out.println(Tasks.get(i).getItemName());
                System.out.println(Tasks.get(i).getItemDescription());
                System.out.println("Date completed: " + Tasks.get(i).getCompletedDate().toString());
            }
        }



        void changeCompletion() {
            System.out.println("What is the task you want to complete?");
            String itemName = keyboard.nextLine();
            for (int i = 0; i < Tasks.size(); i++) {
                if (Tasks.get(i).getItemName().equals(itemName)) {
                    Tasks.get(i).setDateCompleted();

                }

            }
        }

    }
}
