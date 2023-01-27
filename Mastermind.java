
public class Mastermind {

  public static void main(String[] args) {
    MastermindOnePlayer onePlayer = new MastermindOnePlayer();
    MastermindTwoPlayer twoPlayer = new MastermindTwoPlayer();
    MastermindFunctions function = new MastermindFunctions();

    System.out.println("2 player mode?");
    System.out.println("Y/N");
    String twoPlayerString = function.input.next();
    char yeahOrNo = twoPlayerString.charAt(0);
    yeahOrNo = Character.toLowerCase(yeahOrNo);

    if (yeahOrNo == 'n') {
      System.out.println("This version you need to use words not numbers");
      onePlayer.OnePlayer();
    } else {
      twoPlayer.TwoPlayer();
    }

    function.input.close();
  }

} 
