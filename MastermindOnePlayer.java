import java.util.*;

public class MastermindOnePlayer {

  public void OnePlayer() {
    MastermindFunctions function = new MastermindFunctions();
    ArrayList<String> codeOptions = new ArrayList<String>();

    boolean dutch = false;
    boolean OG = false;
    String namePlayer = "PlaceHolder";
    byte wins = 0;
    boolean run = true;
    boolean switchMultieselect = true;
    boolean devMode = false;

    String masterCode[] = new String[function.codeLength];

    System.out.println("what difficulties do you want to play");
    System.out.println("You have The options out of easy, medium, hard and impossible");

    codeOptions.add("red");
    codeOptions.add("blue");
    codeOptions.add("green");
    codeOptions.add("yellow");
    codeOptions.add("purple");
    codeOptions.add("orange");

    while (switchMultieselect) {
      String selection = function.input.next();

      switch (selection) {
        case "easy":
          System.out.println("diffecultie is set to easy");
          function.roundbase = 11;
          function.codeLength = 3;
          codeOptions.remove("orange");
          switchMultieselect = false;

          break;
        case "medium":
          System.out.println("diffecultie is set to medium");
          function.roundbase = 10;
          function.codeLength = 4;
          switchMultieselect = false;

          break;
        case "hard":
          System.out.println("diffecultie is set to hard");
          function.roundbase = 8;
          function.codeLength = 5;
          codeOptions.add("pink");
          codeOptions.add("brown");
          switchMultieselect = false;

          break;
        case "impossible":
          System.out.println("diffecultie is set to impossible");
          function.roundbase = 5;
          function.codeLength = 8;
          codeOptions.add("pink");
          codeOptions.add("brown");
          codeOptions.add("cyan");
          codeOptions.add("lime");
          codeOptions.add("lavender");
          switchMultieselect = false;
          break;
        case "dev==>":
          devMode = true;
          break;
        case "dutchMode==>":
          dutch = true;
          codeOptions.clear();
          codeOptions.add("rood");
          codeOptions.add("blauw");
          codeOptions.add("groen");
          codeOptions.add("geel");
          codeOptions.add("paars");
          codeOptions.add("oranje");
          function.roundbase = 10;
          function.codeLength = 4;
          break;
        case "oneTry":
          if (devMode == true) {
            System.out.println("diffecultie is set to oen try");
            function.roundbase = 1;
            function.codeLength = 50;
            codeOptions.add("pink");
            codeOptions.add("brown");
            codeOptions.add("cyan");
            codeOptions.add("lime");
            codeOptions.add("lavender");
            switchMultieselect = false;
          }
          break;
        case "exit==>":
          switchMultieselect = false;
          break;
        default:
          System.out.println("diffecultie is set to auto(medium)");
          break;
        case "UpUpDownDownLeftRightLeftRightBAStart":
          System.out.println("Why did your try this.....");
          System.out.println(
            "i cant not give you nothing so you now have unlocked the OG mode text"
          );
          OG = true;
          break;
      }
    }

    if (OG == true) {
      System.out.println(" ");
      System.out.println("Enter name");
      namePlayer = function.input.next();
      System.out.println("Hello " + namePlayer);
      System.out.println(" ");
    } else {
      System.out.println(" ");
      System.out.println("Hello player can you please enter your name");
      namePlayer = function.input.next();
      System.out.println("A so your name is " + namePlayer);
      System.out.println("welcom and have fun");
    }

    if (dutch == false) {
      System.out.println(
        "try to break the " + function.codeLength + " long code"
      );
      System.out.println(
        "if you get black then the color and positon is correct"
      );
      System.out.println(
        "If you get white then the color is correct but the postion is not"
      );
      System.out.println(
        "If you get --- then the color and postion is not correct"
      );
    } else {
      System.out.println(
        "Probeer de " + function.codeLength + " lange code te cracken"
      );
      System.out.println("als je black krijgt dan is de kleur en plek goed");
      System.out.println(
        "als je white krijgt dan is de kleur goed maar de plek fout"
      );
      System.out.println(
        "als je --- krijgt dan is de kleur en de plaatsniet goed"
      );
    }

    while (run) {
      function.round = 0;
      masterCode = function.codeGenerator(function.codeLength, codeOptions);

      if (devMode == true) {
        for (int i = 0; i < function.codeLength; i++) {
          System.out.println(masterCode[i]);
        }
      }

      for (; function.round < function.roundbase; function.round++) {
        System.out.println(
          "round : " + function.round + "/" + function.roundbase
        );
        function.win =
          function.rounds(
            function.codeLength,
            codeOptions,
            function.checkWhile,
            function.checkSum,
            masterCode
          );
        if (function.win == true) {
          break;
        }
      }

      if (OG == false) {
        run =
          function.win(
            function.win,
            run,
            wins,
            function.round,
            namePlayer,
            function.codeLength,
            masterCode
          );
      } else {
        run = function.winOG(function.win, namePlayer, run);
      }
    }
  }
} //
