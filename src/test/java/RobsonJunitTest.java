/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.robson.Robson;
import com.robson.RobsonHelper;

/**
 *
 * @author Sara
 */
public class RobsonJunitTest {
    
    public RobsonJunitTest() {
        Robson vRobson = new Robson();
        vRobson.toJSON(RobsonHelper.OUTPUT_JSON_PROGRAM_FILE_PATH_AND_NAME);
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
