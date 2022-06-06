import java.util.ArrayList;

public class EventManager {
	private long currentDate;
	protected ArrayList <Event> events;

	public EventManager(){
		this.currentDate = 0;  //la date courante
		this.events = new ArrayList<>(); //liste des dates
	}

	public void addEvent(Event evenement){
		this.events.add(evenement);
	}

	public void next(){
        Event evenement ;
		for(int i=0;i<events.size();++i){
            evenement = events.get(i);
			if(evenement.getDate() == currentDate){
				evenement.execute();
				//events.remove(evenement);
				//--i;
				//evenement.date++;
				//events.add(evenement);
			}
            //System.out.println("DOO "+currentDate);
		}
		this.currentDate++;
	}


	public boolean isFinished(){
		if(this.events.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void restart(){
		this.currentDate = 0;
		Event evenement;
		for(int i=0;i<events.size();++i)
		{
			evenement = events.get(i);
			evenement.restart();
		}
	}

}
