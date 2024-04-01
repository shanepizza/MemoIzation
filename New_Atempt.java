import java.util.ArrayList;
import java.util.HashMap;

public class New_Atempt {
     static NewTypeString _CommandString = new NewTypeString("_20_8_2_10");
     static String delimiter = "_";
     static ArrayList<Tuple> _tuppleList = new ArrayList<Tuple>();
     static HashMap _Ordered_Commands = new HashMap<>();
     //The ordering here is _length_br1_br2_...br_n


    public static void main(String[] args) {
        _tuppleList.add(new Tuple(1,20));
        printATupleList(_tuppleList);
        
       // System.out.println(_CommandString.str);
        //System.out.println(pop(_CommandString.str));
        //delete(_CommandString);
       // _CommandString.delete();
       // System.out.println(_CommandString.str);
       // System.out.println(pop(_CommandString.str));
        //delete(_CommandString);
        //_CommandString.delete();
        //System.out.println(_CommandString.str);
        nextBreak(_CommandString);
    }





     static int nextBreak(NewTypeString String_W_lengthOnFront){
        int length = pop(String_W_lengthOnFront.str);
        String_W_lengthOnFront.delete();
        int breakValue = pop(String_W_lengthOnFront.str);
        String_W_lengthOnFront.delete();

        _tuppleList.add(new Tuple(1, breakValue));
        _tuppleList.add(new Tuple(breakValue+1, length));
        _tuppleList.remove(0);


        PrintAll(length, breakValue, String_W_lengthOnFront);
        printATupleList(_tuppleList);



        int Value_Of_This_CommandString = 0;
        return Value_Of_This_CommandString;
     }

     static public void PrintAll(int length, int breakValue, NewTypeString leftoverString){
        System.out.println("The length of the current string is: "+ length);
        System.out.println("The next break is at: "+ breakValue);
        System.out.println("The rest of the string is: "+ leftoverString.str);
     }


     static String findTuple(int Break_Value, ArrayList<Tuple> The_Tuples){

        return "";
     }
//final Form
     public static void printATupleList(ArrayList<Tuple> tupleLisToPrint){
        for(int i = 0; i < _tuppleList.size(); i++){
            printATuple(tupleLisToPrint.get(i));

        }
     }
//Final Form
     public static void printATuple(Tuple tupleToprint){
            System.out.println(tupleToprint._Left_Value);
            System.out.println(tupleToprint._Right_Value);
        
     }

//Final Form
     //static String delete(String StringWeDeleteFrom){
      //  String StringWeReturn = StringWeDeleteFrom.substring(locationOf2ndSpace(StringWeDeleteFrom, delimiter)[1]);
       // return StringWeReturn;
     //}

//Final Form
     static int pop(String String_with_Values){
        locationOf2ndSpace(String_with_Values, delimiter);
        return Integer.valueOf(String_with_Values.substring(1, locationOf2ndSpace(String_with_Values, delimiter)[1]));
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
}

class NewTypeString {
    public String str;
    public NewTypeString(String str){
        this.str = str;
    }

    public void delete(){
        this.str = str.substring(locationOf2ndSpace(this.str, New_Atempt.delimiter)[1]);
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
