import java.util.ArrayList;
import java.util.HashMap;

public class New_Atempt {
     static NewTypeString _CommandString = new NewTypeString("_20_2_8_10");
     static ArrayList<NewTypeString> _ArrayCommandString = new ArrayList<NewTypeString>();
     static String delimiter = "_";
     static ArrayList<Tuple> _tuppleList = new ArrayList<Tuple>();
     static HashMap<String, Integer> _Ordered_Commands = new HashMap<>();
     //The ordering here is _length_br1_br2_...br_n


    public static void main(String[] args) {
        _tuppleList.add(new Tuple(1,20));
       
        //System.out.println(_tuppleList.get(0).toString());
        permutateCommandString(_CommandString);
        System.out.println("this is what is left: "+ _CommandString.str);
        System.out.println(_ArrayCommandString.get(0).str);
        
        for(NewTypeString theString: _ArrayCommandString){
            nextBreak(theString);
        }
        
        System.out.println("Done Running NextBreak");
//TODO: In order for the hashtable to actually speed up the program, it needs to store the length of the string and
//end the distance of the break from the right side to the break. This way generalization can take effect in the code.         
        System.out.println("There are "+ _Ordered_Commands.keySet().size() +", Key-Value pairs in this run through.");
        for(String keys: _Ordered_Commands.keySet()){
            
            String key = keys;
            int value = _Ordered_Commands.get(keys);
            
            System.out.println("Key: "+ key +"\tValue: "+ value);
        }
    }




//Final Form
     static int nextBreak(NewTypeString String_W_lengthOnFront){
        int length = pop(String_W_lengthOnFront.str);

//TODO: We runn our base case check here. if no more breaks left in the command stringjust return the value.        
        if( findOccuranceOf(_CommandString.str, "_") < 3 ){
            //System.out.println("The current value of this end node is: " +length);
            _Ordered_Commands.put(String_W_lengthOnFront.str, length);
            String_W_lengthOnFront.delete();
            return length;
        }
    //Remove the first two elements in the Command String.
        String_W_lengthOnFront.delete();
        int breakValue = pop(String_W_lengthOnFront.str);
        String_W_lengthOnFront.delete();

//TODO: This needs to remove tuple we are working on not the first tuple
       removeOldTuple(breakValue);

        
        
        


        PrintAll(length, breakValue, String_W_lengthOnFront);
        printATupleList(_tuppleList);

//TODO: Here we should find our new length and which tuple set we are using. 
        //( ) Find the tuple we should use
            //This is the break we are searching for
            int ValueToSearchFor = pop(String_W_lengthOnFront.str);
            int lengthOfTuple = -1;
            for(int i = 0; i < _tuppleList.size(); i++){
                if(_tuppleList.get(i)._Left_Value <= ValueToSearchFor && _tuppleList.get(i)._Right_Value > ValueToSearchFor){
                    //We found the correct tuple now. 
                    lengthOfTuple = _tuppleList.get(i)._Right_Value-_tuppleList.get(i)._Left_Value+1;
                    System.out.println("Length of the tuple we are using: "+ lengthOfTuple);
                    //We have the length here
            //( ) Add length to command string here
                    _CommandString.add(lengthOfTuple);
                    System.out.println("This is the new command string: "+ _CommandString.str);
                    
                    
                }
            }
        System.out.println("This is the Command String we are about to run: "+ _CommandString.str);
    
    //This is the recursive call here.
        int Value_Of_This_CommandString = nextBreak(String_W_lengthOnFront)+length;
        
        
        String_W_lengthOnFront.add(breakValue);
        String_W_lengthOnFront.add(length);
    //Here is where we assign to the hash map and begin to tally the total for each iteration of the code.
        _Ordered_Commands.put(String_W_lengthOnFront.str, Value_Of_This_CommandString);
       
        //System.out.println(_Ordered_Commands.get(String_W_lengthOnFront.str));
        String_W_lengthOnFront.delete();
        //System.out.println(String_W_lengthOnFront.str);
        //System.out.println("\nThis is the current value of the return: "+ Value_Of_This_CommandString);
     
        
        return Value_Of_This_CommandString;
     }//End NextBreak()

//Final Form
     static public void PrintAll(int length, int breakValue, NewTypeString leftoverString){
        System.out.println("The length of the current string is: "+ length);
        System.out.println("The next break is at: "+ breakValue);
        System.out.println("The rest of the command string is: "+ leftoverString.str);
     }

     static String findTuple(int Break_Value, ArrayList<Tuple> The_Tuples){

        return "";
     }
//final Form
     public static void printATupleList(ArrayList<Tuple> tupleLisToPrint){
        for(int i = 0; i < _tuppleList.size(); i++){
            System.out.println(tupleLisToPrint.get(i).toString());
            //printATuple(tupleLisToPrint.get(i));

        }
     }
//Final Form
     public static void printATuple(Tuple tupleToprint){
            System.out.println(tupleToprint._Left_Value +"_"+tupleToprint._Right_Value);
            System.out.println("Length of the tuple is: "+ (tupleToprint._Right_Value-tupleToprint._Left_Value+1));
        
     }

//WIP
     static ArrayList<NewTypeString> permutateCommandString(NewTypeString thisCommandString){
        ArrayList<NewTypeString> permutatedCommandString = new ArrayList<NewTypeString>();
        //remove the length but save it for later.
        int length = pop(thisCommandString.str);
        thisCommandString.delete();

    //create an arraylist to add in everysingle break we have. 
        ArrayList<Integer> ourBreaks = new ArrayList<Integer>();
        for(int i = 0; i < findOccuranceOf(thisCommandString.str, delimiter); i++ ){
            ourBreaks.add(pop(thisCommandString.str));
            thisCommandString.delete();
        }
        ourBreaks.add(pop(thisCommandString.str));
        thisCommandString.delete();


    //Testing if it will grab all the values
        for(Integer value: ourBreaks){
            System.out.println("Value is: "+ value);
        }

        permute(ourBreaks, 0, length);
        
        for(NewTypeString aString: _ArrayCommandString){
            System.out.println(aString.str);
        }
        printArraylist(ourBreaks, 0);
        //printArraylist(ourBreaks, 0);
        

        return permutatedCommandString;
     }//End Permute

     static void permute(java.util.List<Integer> arr, int k, int length){
        
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1, length);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
            for(int i = 0; i < k; i++){
                NewTypeString theString = new NewTypeString("");
                //System.out.println("THIS");
                //System.out.println(arr);
                for(int x = 0; x < arr.size(); x++){
                    theString.add(arr.get(x));
                    //arr.get(x);
                    
                }
                theString.add(length);
                _ArrayCommandString.add(theString);
                //_ArrayCommandString.add(arr); 
            }
            
        }
        
    }//end Permute

    static void printArraylist(java.util.List<Integer> arr, int k){
        //for(int i = k;  i < arr.size(); i++){
            
                //System.out.println(java.util.Arrays.toString(arr.toArray()));
            
        //}
    }
     

//Final Form
     static int pop(String String_with_Values){
        locationOf2ndSpace(String_with_Values, delimiter);
        try {
            return Integer.valueOf(String_with_Values.substring(1, locationOf2ndSpace(String_with_Values, delimiter)[1]));
        } catch (Exception e) {
            // TODO: What happens when the pop calls for the last break?
            return Integer.valueOf(String_with_Values.substring(1));
        }
        
     }

//Final form
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

//Final Form
    static int[] locationOf2ndSpace(String BreakOrderString, String Delimiter){
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
//Final Form
    static void removeOldTuple(int breakValue){
        for(int i = 0; i < _tuppleList.size(); i++){
            if (_tuppleList.get(i)._Left_Value < breakValue && breakValue < _tuppleList.get(i)._Right_Value){
                _tuppleList.add(new Tuple(_tuppleList.get(i)._Left_Value, breakValue));
                _tuppleList.add(new Tuple(breakValue+1, _tuppleList.get(i)._Right_Value));
                _tuppleList.remove(i);
            }
        }
    }
}//End Class

class Tuple {
   int _Left_Value;
   int _Right_Value; 


   Tuple(int _Left_Value, int _Right_Value){
    this._Left_Value = _Left_Value;
    this._Right_Value = _Right_Value;
   }

   Tuple(){}


   public int get_Left_Value() {
       return _Left_Value;
   }
   public int get_Right_Value() {
       return _Right_Value;
   }
   public void set_Left_Value(int _Left_Value) {
       this._Left_Value = _Left_Value;
   }
   public void set_Right_Value(int _Right_Value) {
       this._Right_Value = _Right_Value;
   }

   public String toString(){
    String ReturnedString;
    ReturnedString = "_"+ this._Left_Value +"_"+ this._Right_Value;
    return ReturnedString;
   }




}

class NewTypeString {
    public String str;
    public NewTypeString(String str){
        this.str = str;
    }

    public void delete(){
        try {
            this.str = str.substring(locationOf2ndSpace(this.str, New_Atempt.delimiter)[1]);
        } catch (Exception e) {
            //This is if we try to delete the last item in the String.
            this.str = str.substring(str.length());
        }
        
    }

    public void add(int valueToAdd){
        this.str = "_"+valueToAdd+str;
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

    static int[] locationOf2ndSpace(String BreakOrderString, String Delimiter){
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
}
