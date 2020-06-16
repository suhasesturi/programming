package interviewbit.StacksAndQueues;

import java.util.LinkedList;

public class SimplifyDirectoryPath {
	public static void main(String[] args) {
		System.out.println(new SimplifyDirectoryPath().simplifyPath("/a/./b/../../c/"));
	}

	public String simplifyPath(String A) {
		LinkedList<String> queue = new LinkedList<>();
		String[] directories = A.split("/");
		for (String directory : directories) {
			if (directory.equals("..")) {
				queue.pollLast();
			} else {
				if (!(directory.equals(".") || directory.isEmpty())) {
					queue.addLast(directory);
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!queue.isEmpty()) {
			builder.append("/").append(queue.pollFirst());
		}
		return builder.length() == 0 ? "/" : builder.toString();
	}
}
