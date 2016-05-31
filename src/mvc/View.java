package mvc;

import java.util.Collection;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class View {

    public static final String FAMOUS_KNIGHT = "Lancelot";
    public static final String INPUT_DATA = "Please, set a range.";
    public static final String INPUT_FROM = "From: ";
    public static final String INPUT_TO = "To: ";
    public static final String WRONG_INPUT_DOUBLE_DATA = "Wrong data input! Please, input a number: ";
    public static final String WRONG_TO = "Wrong data input! Please, input a number more than  ";
    public static final String NOT_MINUS = "Wrong data input! Please, input a number more than  0";


    void printMsg(String s){
        System.out.println(s);
    }
    void printMsgL(String s){
        System.out.print(s);
    }
    void printMsgAndDouble(String s, double d){
        System.out.println(s+d);
    }
    void printCollection(Collection collection){
        System.out.println(collection);
    }


}
