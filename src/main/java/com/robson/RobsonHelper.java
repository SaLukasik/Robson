package com.robson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sara
 */
public class RobsonHelper {
    public static final String EMPTY_STR = "";
    public static final String INPUT_JSON_PROGRAM_FILE_PATH_AND_NAME = "c:\\git_repo\\Java_Exercises\\Robson\\pr1_in.json";
    public static final String OUTPUT_JAVA_PROGRAM_FILE_PATH_AND_NAME = "c:\\git_repo\\Java_Exercises\\Robson\\pr1_out.java";
    public static final String OUTPUT_JSON_PROGRAM_FILE_PATH_AND_NAME = "c:\\git_repo\\Java_Exercises\\Robson\\pr1_out.json";
    
    public static boolean isStringNotNullAndNotEmpty(String pString) {
        return ((null != pString) && (!pString.isEmpty()));
    }
        
    public static String stringToFile(String pStr, String pFilePathAndName) {
        String vErrorStr = RobsonHelper.EMPTY_STR;
            if (RobsonHelper.isStringNotNullAndNotEmpty(pFilePathAndName)) {
                File vFile = new File(pFilePathAndName);
                BufferedWriter vBw = null;
                try {
                    //If file exists lets delete it
                    if (vFile.exists()) vFile.delete();
                    //Creating new file
                    vFile.createNewFile();
                    //Saving string to file
                    vBw = new BufferedWriter(new FileWriter(vFile));
                    vBw.write(pStr);
                } 
                catch (IOException e)
                {
                    vErrorStr = e.getMessage();
                }
                catch (Exception e)
                {
                    vErrorStr = e.getMessage();
                }
                finally
                {
                    try
                    {
                        if (vBw != null) vBw.close(); 
                    }
                    catch (IOException e)
                    {
                        vErrorStr = e.getMessage();
                    }
                    catch (Exception e)
                    {
                        vErrorStr = e.getMessage();
                    }
                }
            }
            else {
                vErrorStr = "File path and name is null or empty";
            }
        return vErrorStr;
    }
    
    private static String fileToString (File pFile) throws Exception {
        String vFileStr = RobsonHelper.EMPTY_STR;
        if ((null != pFile) && (pFile.exists())) {
            FileInputStream vIs = new FileInputStream(pFile);
            byte[] vFileData = new byte[(int) pFile.length()];
            vIs.read(vFileData);
            vIs.close();
            vFileStr = new String(vFileData, "UTF-8");
        }
        else throw new FileNotFoundException("File " + pFile.toString() + " was not found");
        return vFileStr;
    }
    
    public static String fileToString(String pFilePathAndName) throws Exception {
        String vFileStr = RobsonHelper.EMPTY_STR;
        if (RobsonHelper.isStringNotNullAndNotEmpty(pFilePathAndName)) {
            File vFile = new File(pFilePathAndName);     
            vFileStr = fileToString(vFile);
        }
        else throw new Exception ("File path and name is null or empty");
        return vFileStr;
    }
}
