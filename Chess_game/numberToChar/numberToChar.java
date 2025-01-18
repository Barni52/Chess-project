package numberToChar;

public class numberToChar {
    public static String convert(int i){
        switch (i) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";        
            default:
                System.out.println("Got the wrong index of: " + i);
                return "E";
        }
    }
}
