package scud.app;

import java.io.File;
import scud.logic.GameLogic;

/**
 * ScudApp is the application that initializes the Project SCUD program with 
 * respect to the user's arguments from the command line. Currently, the 
 * arguments accepted include -c (for console user interface). For any 
 * other argument, ScudApp will assume that it is a user game file and 
 * will try to see if it exists and if it can be read. If so, ScudApp 
 * will use that file for the game. If not, ScudApp will use the default 
 * game file. 
 * <p>
 * In regards to user interface, ScudApp uses a graphical user interface
 * as a default. 
 * 
 * @author Lisa Hunter
 * @.date 2008-10-12
 * @version 0.3
 */
public final class ScudApp 
{
    
    /**
     * Constructs a ScudApp, which does nothing. This is only included here
     * because Java automatically creates a default constructor.
     */
    private ScudApp()
    {
        
    }
    
    /**
     * Reads the command line arguments and sets up the platform with respect to those
     * arguments. Default runs the command-line version. 
     * Arguments currently handled are: -c (console)
     * Any extra arguments will be considered data files.
     * 
     * @param args the arguments from the command line
     */
    public static void main(String ... args)
    {
        // Will the user want console interface? 
        // The default is no, he won't
        boolean cluiFlag = false;
            
        // USE the default game file for now
        String fileName = null;
        
        // HANDLE the command-line arguments. FOR each argument
        for (int iter = 0; iter < args.length; iter++)
        {   
            // IF one of the arguments is -c
                if (args[iter].equals("-c"))
                {
                        // The user wants console interface. SET the flag
                        cluiFlag = true;
                }
                // ELSE if it's any other argument
                else
                {
                        // CONSIDER the argument to be a file
                        File gameFile = new File(args[iter]);
                        
                        // IF the user's file exists and is readable
                        if(gameFile.exists() && gameFile.canRead())
                        {
                                // USE the user's file instead
                                fileName = args[iter];
                        }
                }
        }
        // CONSTRUCT the game logic with the user file
        GameLogic logic = new GameLogic(fileName);
        
        // IF the user wants command line interface
        if (cluiFlag)
        {
                // START the command-line version
                ConsoleUI scud = new ConsoleUI(logic);
                scud.initUI();
        }
        else
        {
                // START the gui by default
                SwingUI gui = new SwingUI(logic);
                gui.initUI();
        }          
    }
    
    /**
     * Puts the Project Scud ASCII title into a string
     * 
     * @return the title as a string
     */ 
    public static String getTitle()
    {
        // STRING together the Ascii that prints "Project SCUD".
        String titleAscii = "        ,, \n"
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
        
        return titleAscii;
    }
}
