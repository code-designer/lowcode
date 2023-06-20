package org.lowcode.utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides a set of simple and useful functions for files
 * @author bigoh
 *
 */
public class FileUtils {
	
	/**
	 * This method merges the content of two given files. the merging is operated sentence by sentence. keep in mind that a sentence
	 * must end with a full stop. For reasons of encoding, files must use UTF-8 to make algorithm working.
	 * Morever, the two given file paths as argument must be non-null.
	 * @param file is Path
	 * @param file2 is Path
	 * @return Path if files are non-null, and null if files are totally differents
	 * @throws IOException, if an I/O occurs
	 */
	public static Path merge (Path file, Path file2) throws IOException{
		return merge(file.toString(), file2.toString());
	}
	
	/**
	 * This method merges the content of two given files. the merging is operated sentence by sentence. keep in mind that a sentence
	 * must end with a full stop. For reasons of encoding, files must use UTF-8 for algorithm to work.
	 * In addition, the two file paths given as argument must be non-null.
	 * All sentences of the first file is copied in a list collection and each sentence of the second file is extracted for comparison 
	 * with the list collection. if a sentence of file 2 is not in the list collection, this means that phrase is not in the
	 * first file, so it is inserted.
	 * @param s is string
	 * @param s2 is string
	 * @return Path if files are non-null, and null if files are totally differents
	 * @throws IOException, if an I/O occurs
	 */
	public static Path merge(String s, String s2) throws IOException {
		
		if (s == null || s2 == null)
			throw new NullPointerException();
		
		//Convert string into Path objects
		Path path = Paths.get(s), path2 = Paths.get(s2);
		
		//BufferedInputStream for reading file content
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile()));
		
		//To store all sentences of the first file read with BufferedInputStream
		List<String> content = new LinkedList<>();
		
		//To determine whether there is sentence which common to the files
		boolean intersection = false;
		
		//Buffer for reading bytes
		byte[] buffer = new byte[1024];
		while (bis.available() > 0) {
			bis.read(buffer);
			StringBuilder line = new StringBuilder();
			for (byte b : buffer) {
				//46 is the ascii code for full stop
				if (b != 46) {
					line.append((char)b);
				}
				else {
					content.add(line.toString());
					line.setLength(0);
				}
			}
		}
		bis.close();
		//To store sentences of file 2 that will not find in file 1
		List<String> store = new ArrayList<>();
		
		//Check whether store is empty or not
		boolean storeEmpty = true;
		bis = new BufferedInputStream(new FileInputStream(path2.toFile()));
		
		//start indexes the first sentence of the list collection content which has not yet been iterated for comparison.
		//i is used to iterate all the content
		int i = 0, start = 0;
		
		while (bis.available() > 0) {
			//Extract a phrase from file 2
			bis.read(buffer);
			StringBuilder line = new StringBuilder();
			for (byte b : buffer) {
				if (b != 46) {
					line.append((char)b);
				}
				else {
					i = start;
					//Loop to check whether a phrase of file 2 is contained in file 1 (list content)
					while (i < content.size()) {
						if (content.get(i).equals(line.toString())) {
							//To insert phrase if is not contained in file 1 at the index of last phrase found in file 1
							if(!storeEmpty) {
								for (String st : store)
									content.add(i++, st);
								storeEmpty = true;
								store.clear();
							}
							start = ++i;
							break;
						}
						++i;
						//Store phrases for later insertion if they're not found in file 1
						if (i == content.size()) {
							store.add(line.toString());
							storeEmpty = false;
							intersection = true;
						}
						
					}
					line.setLength(0);
				}
			}
		}
		bis.close();
		
		//If the two files are totally differents, there is no merge.
		if (!intersection) {
			return null;
		}
		
		//Create a file from a list content
		String filename = path.getParent() + "\\merge.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		for (String str : content) {
			bw.write(str + ".");
		}
		bw.close();
		return Paths.get(filename);
	}
	
	/**
	 * This method extract the extension of full path file.
	 * @param path is String
	 * @return string that is an extension
	 */
	public static String getExtension(String path) {
		int index;
		
		if (path == null || (index = path.lastIndexOf(".")) < 0)
			return null;
		
		return path.substring( index + 1);
	}
	
	/**
	 * This method extract the extension of full path file.
	 * @param path is Path
	 * @return string that is an extension
	 */
	public static String getExtension(Path path) {
		return getExtension(path.toString());
	}

}
