/**
 * MastermindFunctions
 */
import java.util.*;

public class MastermindFunctions {
    
    public Scanner input = new Scanner(System.in);

    byte roundbase = 10;
    byte codeLength = 4;
    String twoPlayerString;
    byte round = 0;
    byte checkSum = 0;
    boolean checkWhile = true;
    boolean error = true;
    boolean win = false;
    char yeahOrNo;


    /**
    * this function is to 'clear' the console
    */
    public void cls() {
        for (int i = 0; i < 100; i++) {
          System.out.println(" ");
        }
      }
    
      /**
       * @author micha
       * @param codeLength  is how big the code need to be
       * @param codeOptions the colors the program can choose out
       * @return the random code with the length of codeLength out the options of
       *         CodeOptions
       * this function is to generat a random code
       */
      public String[] codeGenerator(int codeLength, ArrayList<String> codeOptions) {
        Random r = new Random();
        String masterCode[] = new String[codeLength];
        for (byte i = 0; i < codeLength; i++) {
          int index = r.nextInt(codeOptions.size());
          masterCode[i] = codeOptions.get(index);
          // System.out.println(masterCode[i]); //if the two slashes are remoeved then the code wil be sent in the console
        }
    
        return masterCode;
      }
    
      /**
       * @author micha
       * @param codeLength is how big the code need to be
       * @param userInput  is the what the user has put in the scanner
       * @param winCheck   is to check if the user has won
       * @param masterCode is the random code with the length of codeLength out the
       *                   options of CodeOptions
       * @return a array and prints the colors for correction
       * this funtion it to check if the input is the same as the code
       */
      public static String[] codeCorectie(
        int codeLength,
        String userInput[],
        byte winCheck,
        String masterCode[]
      ) {
        String pinDisplay[] = new String[codeLength];
    
        for (byte i = 0; i < codeLength; i++) {
          pinDisplay[i] = "---";
        }
    
        for (byte i = 0; i < codeLength; i++) {
          if (userInput[i].equalsIgnoreCase(masterCode[i])) {
            pinDisplay[i] = "black";
          } else {
            for (byte x = 0; x < codeLength; x++) {
              if (userInput[i].equalsIgnoreCase(masterCode[x])) {
                pinDisplay[i] = "white";
                break;
              }
            }
          }
        }
        return pinDisplay;
      }
    
      /**
       * @author micha
       * @param win        is to check if the user wins or loses
       * @param run        is to loop the game
       * @param wins       in to check how much wins the user has
       * @param round      is how much rounds the player took to beat the game
       * @param namePlayer is the name of the player
       * @param yeahOrNo   is to check of the user chooses yes or no
       * @param codeLength is how big the code need to be
       * @param masterCode is the random code with the length of codeLength out the
       *                   options of CodeOptions
       * @return run to check of the program has to end
       */
      public boolean win(boolean win,boolean run,int wins,int round,String namePlayer,int codeLength,String masterCode[]) {
        char yeahOrNo;
        String restartGame;
        if (win == true) {
          wins = wins + 1;
          System.out.println("You Have won");
          System.out.println("this is your :" + wins + " win");
          System.out.println("you did it and it only took " + round + " turn");
          System.out.println("");
          System.out.println("want to play again");
          System.out.println("Y/N");
          restartGame = input.next();
          yeahOrNo = restartGame.charAt(0);
          if (yeahOrNo == 'n') {
            System.out.println("goodbye " + namePlayer);
            run = false;
          }
        } else {
          System.out.println("Lose");
          System.out.println("want to play again");
          System.out.println("Y/N");
          restartGame = input.next();
          yeahOrNo = restartGame.charAt(0);
          if (yeahOrNo == 'n') {
            System.out.println("goodbye " + namePlayer);
            run = false;
          }
        }
        return run;
      }
    
      /**
       * @author micha
       * @param win        is to check if the user wins or loses
       * @param namePlayer is the name of the player
       * @param run        is to loop the game
       * @return run to check of the program has to end
       */
      public boolean winOG(boolean win, String namePlayer, boolean run) {
        String restartGame;
        if (win == true) {
          System.out.println(namePlayer + " My Friend you have won");
          System.out.println("Winner Winner Chicken Dinner !!");
          System.out.println("Mabey try hard mode?");
          System.out.println(" ");
          System.out.println("Opnieuwe? Y/N");
          restartGame = input.next();
          if (!restartGame.equalsIgnoreCase("Y")) {
            run = false;
          }
        } else {
          System.out.println(namePlayer + " My Friend You have losed");
          System.out.println("Skill Issue try again when you can think");
          System.out.println(" ");
          System.out.println("Opnieuwe? Y/N");
          restartGame = input.next();
          if (!restartGame.equalsIgnoreCase("Y")) {
            run = false;
          }
        }
        return run;
      }
    
      /**
       * @author micha
       * @param codeLength  is how big the code need to be
       * @param codeOptions the colors the program can choose out
       * @param round       is how much rounds the player took to beat the game
       * @param roundbase   is how much rounds the game has to play
       * @param checkWhile  is to check if the game can go on
       * @param checkSum    is to check to see if the player has the code correct
       * @param masterCode  is the random code with the length of codeLength out the
       *                    options of CodeOptions
       * @param OG          is to check if the user did the secret code
       */
      public boolean rounds(int codeLength,ArrayList<String> codeOptions,boolean checkWhile,int checkSum, String masterCode[]) {
        String userInput[] = new String[codeLength];
        boolean win = false;
        byte winCheck = 0;
        String pinDisplay[] = new String[codeLength];

        System.out.println("all color options are :" + codeOptions);

          checkWhile = true;
          while (checkWhile) {
            for (byte i = 0; i < codeLength; i++) {
              while (true) {
                try {
                  userInput[i] = input.next();
                  break;
                } catch (Exception e) {
                  System.err.println(e);
                  System.out.println("somthing went wrong please try again");
                }
              }
              
            }
    
            for (byte i = 0; i < codeLength; i++) {
              if (!codeOptions.contains(userInput[i])) {
                checkSum++;
              }
    
              if (checkSum == 0) {
                checkWhile = false;
              }
            }
            checkSum = 0;
            if (checkWhile == true) System.out.println(
              "Looks Like one of you Colors is not a collor of the list Pleas try again"
            );
            System.out.println("These are you options :" + codeOptions);
          }
    
          
    
          pinDisplay = codeCorectie(codeLength, userInput, winCheck, masterCode);
    
          for (byte i = 0; i < codeLength; i++) {
            System.out.print(pinDisplay[i] + " ");
            if (pinDisplay[i].equals("black")) {
              winCheck++;
            }
          }
          System.out.println("");

          if (winCheck == codeLength) {
            win = true;
          }

        return win;
      }

}