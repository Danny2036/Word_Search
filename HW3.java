/** @author Daniel McKinnon
  */
public class HW3{ 
  /** @param a string to be capitalized
    * @return The string entered with the appropriate letters capitalized
    */
  public static String capitalizeSentences(String s){
    StringBuilder x = new StringBuilder();
    boolean first = true;
    
    for(int i =0; i<s.length(); i++){
      char newchar = (s.charAt(i));
      //Accounts for the first letter of the String
      if((s.charAt(i) != ' ')&&(first)&&((s.charAt(i)>= 'a')&&(s.charAt(i)<= 'z'))){
        newchar = ((char)(s.charAt(i)+('A' - 'a')));
        first = false;
        //Accounts for non spaces after ?,!, and .
      } else if((first==false)&&(s.charAt(i) != ' ')&&((s.charAt(i-1)== '.')||(s.charAt(i-1)== '?')||(s.charAt(i-1)== '!'))){
        if((s.charAt(i)>'a')&&(s.charAt(i)<'z')){
          newchar = ((char)(s.charAt(i)+('A' - 'a')));
        }
        //Accounts for ?,!, or . that predeeds a space
      } else if ((first==false)&&(s.charAt(i-1)== ' ')&&((s.charAt(i-2)== '.')||(s.charAt(i-2)== '?')||(s.charAt(i-2)== '!'))&&((s.charAt(i)>= 'a')&&(s.charAt(i)<= 'z'))){
        newchar = ((char)(s.charAt(i)+('A' - 'a')));  
        //Accounts for letters that should not be capitalized
      }else { 
        //Does not change dashes and other symbols and letters that should be and are capitlized
        if((first==false)&&(s.charAt(i) >= 'A')&&(s.charAt(i) <= 'Z')&&!((s.charAt(i-1)== ' ')&&((s.charAt(i-2)== '.')||(s.charAt(i-2)== '?')||(s.charAt(i-2)== '!')))){
          newchar = ((char)(s.charAt(i)-('A' - 'a')));
        } else {
          newchar = newchar;
        }
      }
      x.append(newchar);
    }
    return x.toString();
  }
  /** @param a sequence of letters to look for
    * @param a String to look through for a specific sequence
    * @param returns wether or not the string contains the sequence
    */
  public static boolean subSequence(String sequence, String string){
    int hold = 0;
    boolean check = false;
    for(int i = 0; i < string.length(); i++){
      if (sequence.charAt(hold) == string.charAt(i)){
        hold = hold + 1;
      }
      if(hold == sequence.length()){
        hold = hold - 1;
        return check = true;
      }
    }
    return check;
  }
  
  /** @param A string to remove excess spaces from
    * @return A string with the minimal number of space
    */
  public static String removeExtraSpaces(String s){
    StringBuilder x = new StringBuilder();
    boolean before = true;
    for(int i = 0; i < s.length(); i++){
      //Deals with spaces in front of strings
      if ((before)&& (s.charAt(i) != ' ')){
        before = false;
        x.append(s.charAt(i));
      } else if((!before) && (s.charAt(i) != ' ')){
        x.append(s.charAt(i));
      } else if((!before)&&(i<s.length()-1)&&((s.charAt(i) == ' ')&& (s.charAt(i+1) != ' '))){
        x.append(s.charAt(i));
      }
    }
    return x.toString();
  }
  
  /** @param A string used to look through for sequences
    * @param a single string of words used to look into the other string for
    * @return wether or not one of the words in wordlist are in the string s
    */
  public static boolean containsWord(String s, String wordList){
    String newWordList = HW3.removeExtraSpaces(wordList);
    int start = 0;
    int end = 0;
    boolean search = true;
    
    //For loop applies to each string in between spaces
    for (int i = 0; i < newWordList.length(); i++){
      //Before a word has been made
      if(search){
        if (newWordList.charAt(i) == ' '){
          end = i-1;
          search = false;
        } else if (i == (newWordList.length() -1)){
          end = i-1;
          search = false;
        }
      }
      if(!search){
        StringBuilder x = new StringBuilder();
        for( int j = start; j < end + 1; j++){
          x.append(newWordList.charAt(j));
        }
        if(HW3.subSequence(x.toString(), s)){
          return true;
        } else{
          search = true;
          start = end + 2;
        }
      }
    }
    return false;
  }
  
  /** @param String array of words to look through
    * @param a single string of words used to look into the other string for
    * @return A string of the words that are on the board
    */
  public static String wordSearch(String[] board, String wordList){
    String newWordList = HW3.removeExtraSpaces(wordList);
    String [] draob = new String [board.length]; 
    
    //reverse contents of board
    for (int i = 0; i < board.length; i++){
      for (int j = board[i].length(); j > -1; j--){
        StringBuilder x = new StringBuilder();
        x.append(board[i].charAt(j));
        draob[i] = x.toString();
      }
    }
    //Turns the board and the reverse board into a String
    StringBuilder original = new StringBuilder();
    StringBuilder lanigiro = new StringBuilder();
    for(int a = 0; a < board.length; a++){
      original.append(board[a]+ ' ');
      lanigiro.append(draob[a]+ ' ');
    }
    //Compares the word of a sentence to the Arrary sentence. The adds words that match tothe string
    String answer= "";
    int start = 0;
    int end = 0;
    StringBuilder wordListWord = new StringBuilder();
    for(int b = 0; b < newWordList.length(); b++){
      for(int c = start; c < wordList.length(); c++){
        if (wordList.charAt(c) == ' '){
          end = c - 1;
        }
        for(int d = start; d < end; d++){
          wordListWord.append(wordList.charAt(d));
        }
        if ((HW3.containsWord(original.toString(), wordListWord.toString()))|| (HW3.containsWord(lanigiro.toString(), wordListWord.toString()))){
          answer += wordListWord.toString();
        }
        
      }
    }
    return answer;
  }
}

  /**
   * public static String wordSearch(String[] board, String wordList){
    String newWordList = HW3.removeExtraSpaces(wordList);
    String [] draob = new String [board.length]; 
    
    //reverse contents of board
    for (int i = 0; i < board.length; i++){
      for (int j = board[i].length(); j > -1; j--){
        StringBuilder x = new StringBuilder();
        x.append(board[i].charAt(j));
        draob[i] = x.toString();
      }
    }
    String answer= "";
    int start = 0;
    int end = 0;
    boolean search = true;
    for(int i = start; i < wordList.length(); i++){
      if (search){
        if (wordList.charAt(i) == ' '){
          end = i - 1;
        }
      }
      StringBuilder y = new StringBuilder();
      for(int j = 0; j < end + 1; j++){
        y.append(wordList.charAt(j));
      }
      for(int k = 0; k > board.length; k++){
        if (((HW3.subSequence(y.toString(), board[k])) || (HW3.subSequence(y.toString(), draob[k])))){
          answer += y.toString();
        }
      }
    }
    return "";
  }
*/
