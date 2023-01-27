import java.util.*;

public class MastermindTwoPlayer {

  public void TwoPlayer() {

    MastermindFunctions function = new MastermindFunctions();
    
    ArrayList<String> codeOptions = new ArrayList<String>();

    codeOptions.add("red");
    codeOptions.add("blue");
    codeOptions.add("green");
    codeOptions.add("yellow");
    codeOptions.add("purple");
    codeOptions.add("orange");
    System.out.println("Player one will try to break the code");
    System.out.println(" ");
    System.out.println("player two will be chosing now");
    System.out.println(" ");
    System.out.println("want to add custom colors?");
    System.out.println("Y/N");
    function.twoPlayerString = function.input.next();
    function.yeahOrNo = function.twoPlayerString.charAt(0);
    function.yeahOrNo = Character.toLowerCase(function.yeahOrNo);
    if (function.yeahOrNo == 'y') {
      int customCollorLength = 0;
      while (function.error) {
        try {
          System.out.println("how mutch would you like to add?");
          String customCollors = function.input.next();
          customCollorLength =
            Integer.parseInt(
              customCollors.replaceAll("^\\D*?(-?\\d+).*$", "$1")
            );
            function.error = false;
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("somthing went wrong");
        }
      }

      System.out.println("you can now enter the new colors");
      System.out.println("keep in mind that these color " + codeOptions);
      System.out.println("are all ready in the game");
      for (int i = 0; i < customCollorLength; i++) {
        codeOptions.add(function.input.next());
      }
    }

    String masterCode[] = new String[function.codeLength];
    boolean check = true;
    System.out.println("want to use a custom code?");
    System.out.println("Y/N");
    String customCode = function.input.next();
    function.yeahOrNo = customCode.charAt(0);
    function.yeahOrNo = Character.toLowerCase(function.yeahOrNo);
    if (function.yeahOrNo == 'y') {
      System.out.println("you can now enter your custom code");
      System.out.println("your options are :" + codeOptions);
      for (int i = 0; i < function.codeLength; i++) {
        while (check) {
          masterCode[i] = function.input.next();
          if (!codeOptions.contains(masterCode[i])) {
            System.out.println("this color is not a option");
          } else {
            check = false;
          }
        }
        check = true;
      }
      function.cls();
    } else {
      masterCode = function.codeGenerator(function.codeLength, codeOptions);
    }

    for (; function.round< function.roundbase ; function.round ++){
      System.out.println("round : " + function.round + "/" + function.roundbase);
      function.win = function.rounds(function.codeLength,codeOptions,function.checkWhile,function.checkSum,masterCode);
      if ( function.win == true){
        break;
      }            
    }

    if (function.win == true) {
      System.out.println("player one won");
    } else {
      System.out.println("player two won");
    }
    
  }
}
