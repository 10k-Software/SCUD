package scud.app;

import static org.junit.Assert.*;

/**
 * ScudAppTest tests the functionality of the class ScudApp via white-box
 * methods. What is not tested within ScudAppTest is tested via
 * input and output files handled within the integration
 * build script.
 * @author Lisa Hunter
 */
public class ScudAppTest 
{

    public ScudAppTest() 
    {
    }
    
    public static void setUpClass() throws Exception 
    {
    }

    public void setUp() 
    {
    }

    /**
     * Test of main method, of class ScudApp.
     */
    public void testMain() 
    {
        String[] args = {"-c"};
        ScudApp.main(args);
        System.out.println("This should start the Console");
        args = null;
        ScudApp.main(args);
        System.out.println("This should start the GUI");
    }

    /**
     * Test of getTitle method, of class ScudApp.
     */
    public void testGetTitle() 
    {
        String expResult = "        ,, \n"
            +"        `7MM\"\"\"Mq.                db                 mm \n"
            +"          MM   `MM.                                  MM \n"
            +"          MM   ,M9`7Mb,od8,pW\"Wq`7MM .gP\"Ya  ,p6\"bommMMmm \n"
            +"          MMmmdM9   MM' \"6W'   `WbMM,M'   Yb6M'  OO  MM \n"
            +"          MM        MM   8M     M8MM8M\"\"\"\"\"\"8M       MM \n"
            +"          MM        MM   YA.   ,A9MMYM.    ,YM.    , MM \n"
            +"        .JMML.    .JMML.  `Ybmd9' MM `Mbmmd' YMbmd'  `Mbmo \n"
            +"                               QO MP \n"
            +"                               `bmP \n"
            +"                                \n"
            +"                                \n"
            +"            .M\"\"\"bgd  .g8\"\"\"bgd`7MMF'   "
            +"`7MF`7MM\"\"\"Yb. \n"
            +"           ,MI    \"Y.dP'     `M  MM       M   MM    `Yb. \n"
            +"           `MMb.    dM'       `  MM       M   MM     `Mb \n"
            +"             `YMMNq.MM           MM       M   MM      MM \n"
            +"           .     `MMMM.          MM       M   MM     ,MP \n"
            +"           Mb     dM`Mb.     ,'  YM.     ,M   MM    ,dP' \n"
            +"           P\"Ybmmd\"   `\"bmmmd'    `bmmmmd\"' .JMMmmmdP' \n"
            +"\n\t\t\t By 10k Software";
        String result = ScudApp.getTitle();
        
        assertEquals(expResult, result);

    }

}