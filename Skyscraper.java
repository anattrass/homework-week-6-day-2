import java.util.*;

public class Skyscraper{

  private String name;
  private ArrayList<Rideable> lift;


  public Skyscraper(String name){
    this.name = name;
    this.lift = new ArrayList<Rideable>();
  }

  public String getName(){
    return this.name;
  }

  public int countLiftPeople(){
    return lift.size();
  }

  public void enterLift(Rideable people) {
    lift.add(people);
    }

  public void closed() {
    lift.clear();
  }

  public Rideable exit() {
   if (countLiftPeople() > 0) {
     return lift.remove(0);
   }
   return null;
  }

}
