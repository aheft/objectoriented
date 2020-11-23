import java.util.HashMap;
import java.util.ArrayList;


public class WordCount {


    private HashMap<String, Integer> wordList;


    public WordCount() {
        wordList = new HashMap<String, Integer>();
       
    }

    public WordCount(String words) {
        wordList = new HashMap<String, Integer>();
        boolean  end = false;
        if(words !=  null){
            String[] strgs = words.split(" ");
            for(int i = 0; i < strgs.length;i++){
                
                if(wordList.containsKey(strgs[i]) == true){
                    int num = wordList.get(strgs[i]);
                    num = num + 1;
                    wordList.put(strgs[i],num);
                
                }else{
                    wordList.put(strgs[i],1);
                }
                
            }    
        }
    }


    public void addWord(String toAdd) {
            if(wordList.containsKey(toAdd) == true){
                int num = wordList.get(toAdd);
                num = num + 1;
                wordList.put(toAdd,num);              
            }
            else{
                wordList.put(toAdd,1);
            }
    }


    public void startOver() throws UnsupportedOperationException {
        if (wordList == null){
            throw new UnsupportedOperationException("no wordlist to clear");
        }
        wordList.clear();
    }


    public int countWord(String word) {
            int quantity = 0;

        if((wordList.containsKey(word)) ){
            quantity = wordList.get(word);
        }
        return quantity;
    }

}