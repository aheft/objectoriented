import java.util.ArrayList;
import java.util.Arrays;

public class RunMe{

public static void main(String[] args){       
    ArrayList<String> wordsToTest = new ArrayList<>(Arrays.asList("red green blue orange red black brown green".split(" ")));

    WordCount testCounter = new WordCount();
    testCounter.addWord("One");
    testCounter.addWord("One");
    System.out.println(testCounter.countWord("One"));
    


	
}

	
}