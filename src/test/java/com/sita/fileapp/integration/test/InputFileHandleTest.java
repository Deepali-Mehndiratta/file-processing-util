package com.sita.fileapp.integration.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sita.fileapp.integration.file.InputFileHandler;

import static org.junit.Assert.assertEquals;
import java.io.File;




public class InputFileHandleTest {
	
    public static InputFileHandler ml;
    
    public static File invalidFile ; 
    
    public static File validFile ;
	
    @BeforeClass
	public static void setUp() {
    	System.out.println("Before set up");
		invalidFile = new File("src/test/resources/invalid-file-1.txt");
		validFile = new File("src/test/resources/valid-file-1.txt");
		ml = new InputFileHandler();
	}
	

	@Test
	public void invalidFileScenario() throws Exception{
		
		boolean isValid = ml.handleFile(invalidFile);
		 assertEquals(isValid,false);

		
	}
	
	@Test
	public void validFileScenario() throws Exception{
		boolean isValid = ml.handleFile(validFile);
		 assertEquals(isValid,true);
	}

}
