/** @author Daniel McKinnon
  */
import junit.framework.TestCase;

public class HW3Test extends TestCase{
  
  /** @Test
    */
  public void testCapSentences(){
    assertEquals("", HW3.capitalizeSentences(""));
    assertEquals("Hello! What is my number? 341-1212! What is yours?", HW3.capitalizeSentences("hello! what is my number? 341-1212! WHAT is yours?"));
    assertEquals("Look!Sentence.No-spaces!", HW3.capitalizeSentences("look!sentence.no-spaces!"));
  }
  
  /** @Test
    */
  public void testSubSequence(){
    assertEquals(true,  HW3.subSequence(" ", " "));
    assertEquals(true,  HW3.subSequence("abc", "about chocolate "));
    assertEquals(false,  HW3.subSequence("abc", "acorn bud"));
    assertEquals(false,  HW3.subSequence("about chocolate", "abc"));
  }
  
  /** @Test
    */
  public void testRemoveExtraSpaces(){
    assertEquals("How about that ?",  HW3.removeExtraSpaces(" How about     that   ?    "));
    assertEquals("Look mah. No spaces",  HW3.removeExtraSpaces("Look mah. No spaces"));
    assertEquals("Now . Bring me prisoner 24601!",  HW3.removeExtraSpaces("Now        . Bring me       prisoner 24601!"));
    assertEquals("Hello world",  HW3.removeExtraSpaces("Hello                                                                                                                                   world"));
  }
  
  /** @Test
    */
  public void testContainsWord(){
    assertEquals(true,  HW3. containsWord("My what a lovely day", "hate     love"));
    assertEquals(true,  HW3.containsWord("StopThat!!", "! ? *"));
    assertEquals(false,  HW3. containsWord("Guess who is coming to dinner?", "Who Dinner"));
    assertEquals(false,  HW3.containsWord("One last example", ""));
  }
  
    /** @Test
    
  public void testWordSearch(){
    assertEquals("HO West ale stern",  HW3.wordSearch(String [] board = {"Case", "Western", "Reserve", "University", "Cleveland, OH"}, "HO CWRU west West ale stern sac")));
  }
  */
}