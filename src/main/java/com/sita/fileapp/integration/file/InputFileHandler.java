package com.sita.fileapp.integration.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author deepali.mehndiratta 
 * Class to process Input file received from poller
 *
 */
public class InputFileHandler {

	private String outputDir;
	private static final Logger logger = LoggerFactory.getLogger(InputFileHandler.class);

	/**
	 * @param inputFile
	 * @throws Exception
	 *   This Function returns true or false based on input file
	 *   content . For valid file- sum the content and send to output directory
	 *             
	 */
	public boolean handleFile(File inputFile) throws Exception {

		logger.info("Enter in handleFile method , processing {}", inputFile.getName());
		Double sum = 0.0;
		boolean isInValidFile = false;

		try (Scanner sc = new Scanner(inputFile)) {

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String val = new String(line);
				if (line.trim().matches("-?[1-9]\\d*|0")) {
					sum = sum + Double.parseDouble(line);
					//System.out.println(sum);
				} else if (!val.isEmpty()) {
					isInValidFile = true;
					break;
				}

			}
		} catch (IOException e) {
			isInValidFile = true;
			logger.error("Error occurred in handleFile Method {}"+e.getMessage());
		}

		logger.info("File is invalid for {}. is {}."+ inputFile.getName(),isInValidFile);
		if (isInValidFile) {
			return false;
		}
		
		logger.error("Sum is {}. , writing to output file "+sum);
		writeToOutputFile(inputFile, sum);
		return true;
	}

	private void writeToOutputFile(File inputFile, Double sum) throws FileNotFoundException, IOException {
		try {
			int pos = inputFile.getName().lastIndexOf(".");
			String justName = pos > 0 ? inputFile.getName().substring(0, pos) : inputFile.getName();
			String outFileName = justName + "_OUTPUT.txt";
			FileOutputStream out = new FileOutputStream(outputDir + outFileName);
			out.write(String.valueOf(sum).getBytes());
			out.close();
		} catch (IOException e) {
			logger.error("Error occurred in handleFile Method {}"+e.getMessage());
			throw e ; 
		}
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

}
