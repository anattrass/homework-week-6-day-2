import static org.junit.Assert.*;
import org.junit.*;

public class SkyscraperTest{
  Skyscraper skyscraper;
  Adult adult;
  Child child;

  @Before 
  public void before() {
    skyscraper = new Skyscraper("The Shard");
    adult = new Adult();
    child = new Child();
  }

  @Test
  public void hasName(){
    assertEquals("The Shard", skyscraper.getName()); 
  }

  @Test
  public void liftStartsEmpty(){
    assertEquals(0, skyscraper.countLiftPeople());
  }

  @Test
  public void peopleCanGetInLift(){
    skyscraper.enterLift(adult);
    assertEquals(1, skyscraper.countLiftPeople());
  }

  @Test
  public void liftBreakdown() {
   skyscraper.enterLift(adult);
   skyscraper.enterLift(child);
   skyscraper.closed();
   assertEquals(skyscraper.countLiftPeople(), 0);
  }

  @Test
  public void childCanRide(){
    skyscraper.enterLift(child);
    assertEquals(1, skyscraper.countLiftPeople());
  }

  @Test
  public void canExitLift() {
    skyscraper.enterLift(child);
    Rideable people = skyscraper.exit();
    Child original = (Child)people;
    assertEquals("I'm so young", original.speak());
  }

  @Test
  public void peopleCanSpeak() {
    skyscraper.enterLift(adult);
    Rideable people = skyscraper.exit();
    assertEquals("I'm so old", people.speak());
  }

  // @Test
  // public void adultCanAlchol() {
  //   skyscraper.enterLift(adult);
  //   Rideable people = skyscraper.exit();
  //   assertEquals("I can purchase and consume alcohol", people.alcohol());
  // }

}

