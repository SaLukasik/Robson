package com.robson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sara
 */
public class RobsonMain {

    public static void main(String[] args) throws IOException{
        BufferedReader vReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Robson v.0.0.1 (by Sara Lukasik)");
        Robson vRobson = new Robson();
        vRobson.toJSON(RobsonHelper.OUTPUT_JSON_PROGRAM_FILE_PATH_AND_NAME);
        try {
            vRobson.fromJSON(RobsonHelper.INPUT_JSON_PROGRAM_FILE_PATH_AND_NAME);
        }
        catch (InvalidProgramException ex) {
            System.out.println("Error while parsing JSON file:" + ex.getMessage());
        }

        System.out.println("Robson exited.");
    }
}
