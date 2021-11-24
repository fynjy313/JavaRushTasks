package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
	private String partOfName = "";
	private String partOfContent = "";
	private int minSize = 0;
	private int maxSize = Integer.MAX_VALUE;
	private List<Path> foundFiles = new ArrayList<>();

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		byte[] content = Files.readAllBytes(file); // размер файла: content.length
		boolean checkName = file.getFileName().toString().contains(partOfName);
		boolean checkContent = (new String(content)).contains(partOfContent);

		if (checkName & checkContent & (content.length > minSize) & (content.length < maxSize))
			foundFiles.add(file);

		return super.visitFile(file, attrs);
	}

	public void setPartOfName(String amigo) {
		this.partOfName = amigo;
	}

	public void setPartOfContent(String programmer) {
		this.partOfContent = programmer;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public List<Path> getFoundFiles() {
		return foundFiles;
	}

}
