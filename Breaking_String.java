import java.util.HashMap;

public class Breaking_String {
    static int lengthOfString = 5;
    static String[] _ListOfBreakPatterns = {"_8_10"};
    static String delimiter = "_";
    static int locationOfNumber = _ListOfBreakPatterns[0].indexOf("10");
    static HashMap<String, Integer> _ValuesOfOrderedBreaks = new HashMap<String, Integer>();
    static int[] locationsOfBreaks;
    public static void main(String[] args) {
        locationsOfBreaks = locationsOfSpaces(_ListOfBreakPatterns[0], delimiter);
        //System.out.println(locationOfNumber);
        int numberOfbreaks = findOccuranceOf( _ListOfBreakPatterns[0], "_");
        //System.out.println(locationsOfSpaces(_ListOfBreakPatterns[0], "_"));
        System.out.println(nextBreak(_ListOfBreakPatterns[0], lengthOfString, locationsOfBreaks[0], locationsOfBreaks[1]));
        System.out.println(_ValuesOfOrderedBreaks.get("_8"));




    }
    



    static int findOccuranceOf(String stringWeSearchThrough, String charWeSearchFor){
        int counter = -1;
        for(int i = 0; i < stringWeSearchThrough.length(); i++){
            //System.out.println(stringWeSearchThrough.substring(i, i+1));
            if(stringWeSearchThrough.substring(i, i+1).equals(charWeSearchFor)){
                counter ++;
            }
        }
        counter++;
        //System.out.println(counter);
        //Returns -1 if the character does not exist at all.
        return counter;
    }
 
    static int[] locationsOfSpaces(String BreakOrderString, String Delimiter){
        int[] locationsofDelimiters = new int[findOccuranceOf(BreakOrderString, Delimiter)];
        int pointer = 0;
        for(int i = 0; i < BreakOrderString.length(); i ++){
            if(BreakOrderString.substring(i, i+1).equals(Delimiter)){
                locationsofDelimiters[pointer] = i;
                pointer++;
            }
        }
        return locationsofDelimiters;
    }// end LocationsOfSpaces


    static int nextBreak(String Breaks, int valueOfCurrentString, int start, int stop){
        int valueOfBreak = valueOfCurrentString;
        int leftString = 0;
        int rightString = 0;

        if(findOccuranceOf(Breaks, delimiter) < 2){
            _ValuesOfOrderedBreaks.put(Breaks, valueOfBreak); 
            return valueOfCurrentString;
        }

        valueOfBreak = valueOfBreak+nextBreak(Breaks, valueOfCurrentString, locationsOfBreaks[start+1], locationsOfBreaks[stop+1]); 
        _ValuesOfOrderedBreaks.put(Breaks, valueOfBreak);

       // for(int i = 0; i < locationsOfSpaces(Breaks, delimiter).length; i++){
        //    nextBreak(Breaks, ValueLeftover, start, stop);
       // }
       // nextBreak(Breaks, ValueLeftover, startLeft, stopLeft);
        //nextBreak(Breaks, ValueLeftover, startRight, stopRight);

        return valueOfBreak;
    }
    
}
