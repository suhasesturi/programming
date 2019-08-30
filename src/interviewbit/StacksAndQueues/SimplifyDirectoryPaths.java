package interviewbit.StacksAndQueues;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyDirectoryPaths {
    public String simplifyPath(String A) {
        LinkedList<String> hierarchy = new LinkedList<>();
        String[] directories = A.split("/");

        for (String directory : directories) {
            if (directory.equals(".") || directory.isEmpty()) continue;
            else if (directory.equals("..")) hierarchy.pollLast();
            else hierarchy.addLast(directory);
        }

        StringBuilder builder = new StringBuilder();
        hierarchy.forEach(directory -> builder.append("/").append(directory));
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
