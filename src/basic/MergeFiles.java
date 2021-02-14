package basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MergeFiles {
	BufferedWriter bWriter;
	File outputFile;
	TreeMap<String, EnhancedFile> efMap = new TreeMap<>();

	public String getOutputFile() throws IOException {
		return outputFile.getCanonicalPath();
	}
	
	private List<EnhancedFile> getList(File inputDir) {
		List<EnhancedFile> eFileList = new ArrayList<>();
		
		for(File f : inputDir.listFiles()) {
			if ( f.isFile() )
				try {
					EnhancedFile ef = new EnhancedFile(f);
					eFileList.add(ef);
				} catch (FileNotFoundException e) {
					System.out.println("Warning. File[ " + f.toString() + "] not found, skipping");
				}
		}
		
		return eFileList;
	}

	private boolean isDone(List<EnhancedFile> eFileList) {
		for(EnhancedFile ef : eFileList) {
			if ( !ef.isClosed() )
				return false;
		}
		return true;
	}

	private void nextString(EnhancedFile ef) throws Exception {
		while ( !ef.isClosed() && efMap.containsKey(ef.currentLine()) ) {
			ef.readValidLine();
		}

		if ( !ef.isClosed() )
			efMap.put(ef.currentLine(), ef);			
	}
	
	private void writeLeastString() throws Exception {
		String leastString = efMap.firstKey();
		EnhancedFile ef = efMap.get( leastString );

		bWriter.write( leastString );
		bWriter.newLine();
		nextString( ef );
		efMap.remove( leastString );
	}
	
	public void process(File inputDir, File outputFile) throws Exception {
		List<EnhancedFile> eFileList = getList(inputDir);
		this.outputFile = outputFile;
		this.bWriter = new BufferedWriter(new FileWriter(outputFile));

		for(EnhancedFile ef : eFileList) {
			if ( ef.isClosed() ) 
				continue;

			ef.readValidLine();

			while ( !ef.isClosed() && efMap.containsKey(ef.currentLine()) ) {
				ef.readValidLine();
			}
			
			if ( !ef.isClosed() )
				efMap.put(ef.currentLine(), ef);			
		}

		while (!isDone( eFileList )) {
			writeLeastString();
		}
		
		this.bWriter.close();
	}
	
	public boolean validateArguments(String[] args) {
		if ( args == null || args.length != 2 ) return false;
		if ( !(new File(args[0])).isDirectory() ) {
			System.out.println(args[0] + " is not a directory");
			return false;
		}
		
		System.out.println("inputDir[" + args[0] + "]");
		System.out.println("outputFile[" + args[1] + "]");
		
		return true;
	}
	
	public static void main(String[] args) {
		MergeFiles mf = new MergeFiles();
		
		if ( !mf.validateArguments(args) ) {
			System.out.println( "MergeFiles <input directory containing files> <output file>" );
			System.exit(0);
		}
		
		try {
			mf.process(new File(args[0]), new File(args[1]));
			System.out.println("Successfully completed processing.  Output file[" + mf.getOutputFile() + "]");
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());			
		}		
	}	
}

class EnhancedFile {
	File file;
	BufferedReader inputStream;
	String priorLine = null;
	String currentLine = null;
	boolean isClosed = false;
	
	EnhancedFile(File file) throws FileNotFoundException {
		this.file = file;
		inputStream = new BufferedReader(new FileReader(file));
	}
	
	public String priorLine() {
		return priorLine;
	}
	
	public String currentLine() {
		return currentLine;
	}
	
	public void readValidLine() throws Exception {
		priorLine = currentLine;
		currentLine = null;
		
		String line = null;
		while ( (line = inputStream.readLine()) != null ) {
			if ( line.length() != 0 ) {  // empty line
				if ( priorLine != null && line.compareTo(priorLine) < 0 )  // not sorted
					throw new Exception( "current line[" + line + "] is not lexicographically sorted to prior line[" + priorLine + "]" );
				else if ( priorLine == null || line.compareTo(priorLine) > 0 ) { // sorted.  note duplicate line (compareTo == 0) is bypassed.
					currentLine = line;
					return;
				}
			}
		}
	
		close();
	}
	
	public boolean isClosed() {
		return isClosed;
	}
	
	public void close() throws IOException {
		if ( inputStream != null ) {
			isClosed = true;
			inputStream.close();
		}
	}
}
