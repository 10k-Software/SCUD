package scud.app;

/**
 * BlankUI is used when no output is intended.
 * 
 * @author Chris Gibson
 */
public class BlankUI implements ScudUI
{
    private String lastMsg = "";  //Last message sent

    /**
     * Used simply to sate the ScudUI interface requirements.
     */
    public void initUI()
    {
        lastMsg = "";
    }

    /**
     * Used simply to sate the ScudUI interface requirements.
     * @param text text input from GameLogic
     */
    public void displayText(String text)
    {
        lastMsg = text;
    }

}
