public class Main {
    static int _TheStringWeBreak = 20;
    static int _TheNumberOfBreaks = 1;
    static int[] _WhereWeBreakTheString = new int[_TheNumberOfBreaks];
    



    public static void main(String[] args) {
        //System.out.println(_TheStringWeBreak);
        assignTheBreaks();
        RecursiveFindTheBestBreak(_TheStringWeBreak, _WhereWeBreakTheString);
    }

public static void assignTheBreaks(){
    _WhereWeBreakTheString[0] = 2;
    _WhereWeBreakTheString[1] = 8;
    //_WhereWeBreakTheString[2] = 10;
}

public static void randomBreaks(){

}

    

public static int[] RecursiveFindTheBestBreak(int stringToBreak, int[] breaksArray){
    int currentBreak = breaksArray[0];
    int currentString = stringToBreak;
    int[] breakPatern = new int[breaksArray.length+1];
    int nextBreak = breaksArray[1];
    
    
    if(breaksArray.length <2){
        breakPatern[0] = stringToBreak;
        breakPatern[breakPatern.length-1] = breaksArray[0];

        return breakPatern;
    
    }else{
        breakPatern[0] = stringToBreak + stringToBreak;
        for(int i = 0; i < breaksArray.length; i++){
            int[] newList = new int[breaksArray.length-1];
            for (int y =0; y< breaksArray.length; y++){
                if(breaksArray[y] != breaksArray[i]){
                    newList[y] = breaksArray[y];
                }
            }
            if(nextBreak < currentBreak){
                //leftside;
                RecursiveFindTheBestBreak();
            } else {
                currentString = currentString - currentBreak;
                for(int x = 0; x < breaksArray.length; x++){
                        breaksArray[x] = breaksArray[x]-currentBreak;
                    
                    
                }
            }


    }
    
    
    
    
    
    
    
    
    
    
    }else{
        
        


       
            //leftside
            RecursiveFindTheBestBreak(breaks[0], newbreaks);
        }else {
            //right side
            RecursiveFindTheBestBreak(stringToBreak-breaks[0], newbreaks);
        }





        RecursiveFindTheBestBreak(j);
    }


    







    return breakPatern;
}


}
