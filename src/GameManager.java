import gui.Simulable;
public class GameManager implements Simulable {
    EventManager manager;
    public GameManager()
    {
        manager = new EventManager();       
    }

    public void addEvent(Event e)
    {
        manager.addEvent(e);
    }
    @Override
    public void next()
    {
        manager.next();
    }

    @Override
    public void restart()
    {
        manager.restart();
    }
}
