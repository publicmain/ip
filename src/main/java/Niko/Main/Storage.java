package Niko.Main;

import Niko.Task.Deadline;
import Niko.Task.Event;
import Niko.Task.Task;
import Niko.Task.Todo;

import java.io.*;
import java.util.ArrayList;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void write(String tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))) {
            writer.write(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            String[] parts = line.split(", ");
            for (String part : parts) {
                Task task = parseTask(part);
                if (task != null) {
                    tasks.add(task);
                }
            }

        }

        reader.close();
        return tasks;
    }


    private Task parseTask(String line) {

        char typeChar = line.charAt(1);
        boolean isDone = line.charAt(4) == 'X';

        String description;
        Task task = null;


        switch (typeChar) {
            case 'T':
                description = line.substring(7).trim();
                task = new Todo(description);
                break;
            case 'D':
                description = line.substring(7, line.indexOf("(by:")).trim();
                String byDateString = line.substring(line.indexOf("(by:") + 5, line.length() - 1).trim();

                task = new Deadline(description, byDateString);
                break;

            case 'E':
                description = line.substring(7, line.indexOf("(from:")).trim();
                String fromDateString = line.substring(line.indexOf("(from:") + 7, line.indexOf("to:")).trim();
                String toDateString = line.substring(line.indexOf("to:") + 4, line.length() - 1).trim();

                task = new Event(description, fromDateString, toDateString);
                break;

            default:
                return null;

        }
        if (isDone) {
            task.markAsDone();
        }

        return task;
    }
}

