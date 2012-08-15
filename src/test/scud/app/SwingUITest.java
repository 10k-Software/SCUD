package scud.app;

import scud.app.SwingUI;
import scud.logic.GameLogic;

/**
 *
 * @author Jason Swalwell
 */
public class SwingUITest
{

    public SwingUITest()
    {
    }

    public static void main(String ... args)
    {
        GameLogic gameLogic = new GameLogic("Testlevel.xml");
        SwingUI sui = new SwingUI(gameLogic);
        sui.initUI();
    }
}
