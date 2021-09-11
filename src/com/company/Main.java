package com.company;

import java.util.*;


public class Main {

    private static boolean gameWon = false;
    private static boolean newGame = true;
    private static String val;
    private static int guess = 1;

    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        val = getOriginalNumber();

        while(newGame) {
            while (guess <= 10 && !gameWon) {
                System.out.println("Please enter guess " + String.valueOf(guess));
                String new_text = text.nextLine();
                System.out.println(varianceCheck(val, new_text));
                guess += 1;
            }
            Game();

        }
    }

    private static void Game()
    {
        if(!gameWon)
        {
            System.out.println("Unfortunately, you have lost.  The number was " + val);
        }
        System.out.println("end");
        System.out.println("");
        System.out.println("Would you like to play a new game? [Y/N]");
        Scanner answerText = new Scanner(System.in);
        String answer = answerText.nextLine();
        if(Objects.equals(answer, "Y"))
        {
            val = getOriginalNumber();
            guess = 1;
        } else {
            newGame = false;
        }
    }


    private static String getOriginalNumber()
    {
        Random rand = new Random();
        int firstNum = rand.nextInt(10);
        int secondNum = rand.nextInt(10);
        int thirdNum = rand.nextInt(10);
        return(String.valueOf(firstNum) + String.valueOf(secondNum) + String.valueOf(thirdNum));
    }

    private static String varianceCheck(String val, String guess)
    {
        if(Objects.equals(val, guess))
        {
            gameWon = true;
            return "Winner Winner!";
        }
        StringBuilder output = new StringBuilder();
        List<String> valList = new ArrayList<String>(Arrays.asList(val.split("")));
        List<String> guessList = new ArrayList<String>(Arrays.asList(guess.split("")));
            for(int j = 0; j < guessList.size(); j++)
            {
                if(Objects.equals(guessList.get(j), valList.get(j)))
                {
                    output.append("Fermi ");

                } else if(guessList.contains(valList.get(j)))
                {
                    output.append("Pico ");

                }
            }


        if(output.length() < 1)
        {
            output.append("Bagels");
        }



        return ("" + output);

    }
}
