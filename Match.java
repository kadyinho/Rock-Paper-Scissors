import java.util.Scanner;
import java.util.ArrayList;

public class Match
{
    private static Scanner let = new Scanner(System.in);
    private static Scanner num = new Scanner(System.in);
    // private static ArrayList<String> phistory = new ArrayList<String>();
    // private static ArrayList<String> ohistory = new ArrayList<String>();
    private static Player p;
    private static Player o;
    public static void main(String[] args) 
    {
        start();
    }

    public static void start()
    {
        String pName = "";
        String oName = "";
        
        System.out.print("\n\tStarting game...\n");
        while(pName.isBlank())
        {
            System.out.print("\nEnter Your Name: ");
            pName = let.nextLine();
        }
        while(oName.isBlank())
        {
            System.out.print("\nEnter Opponent's Name: ");
            oName = let.nextLine();
        }

        o = new Player(oName);
        p = new Player(pName);

        game();

    }

    public static void game()
    {
        gameMenu();
        boolean game = true;

        while(game)
        {
            System.out.print("\nplay: ");
            int choice = num.nextInt();

            switch(choice)
            {
                case 1:
                    p.playRock();
                    System.out.print("\nYou played rock");
                    o.opponentMove();
                    break;
                case 2:
                    p.playPaper();
                    System.out.print("\nYou played paper");
                    o.opponentMove();
                    break;
                case 3:
                    p.playScissors();
                    System.out.print("\nYou played scissors");
                    o.opponentMove();
                    break;
                default:
                    System.out.print("\n\tInvalid choice, choose again\n");
                    continue;
            }

            if(checkScore() == -1)
            {
                game = false;
            }

        }

    }

    public static int checkScore()
    {
        int om = o.getMove();
        int pm = p.getMove();

        if(om == 1 && pm == 2)
        {
            System.out.print("\n" + p.getName() + " won the game\n");            
            p.scored();
        }
        else if(om == 1 && pm == 3)
        {
            System.out.print("\n" + o.getName() + " won the game\n");                        
            o.scored();
        }
        else if(om == pm)
        {
            System.out.print("\nTie");
            o.tied();
            p.tied();
        }
        else if(om == 2 && pm == 1)
        {
            System.out.print("\n\t" + o.getName() + " won the game\n");                        
            o.scored();
        }
        else if(om == 2 && pm == 3)
        {
            System.out.print("\n\t" + p.getName() + " won the game\n");            
            p.scored();
        }
        else if(om == 3 && pm == 1)
        {
            System.out.print("\n\t" + p.getName() + " won the game\n");            
            p.scored();
        }
        else if(om == 3 && pm == 2)
        {
            System.out.print("\n\t" + o.getName() + " won the game\n");                        
            o.scored();
        }

        System.out.print("\n\t" + p.getName() + " "  + p.getScore() +
        " - " + o.getName() + " " + o.getScore() + "\n");

        if(p.getScore() == 2)
        {
            p.won();
            o.lost();
            System.out.print("\n\t" + p.getName() + " Won the round\n");
            p.setScore(0);
            o.setScore(0);
            if(next() == -1)
            return -1;
        }
        else if(o.getScore() == 2)
        {
            o.won();
            p.lost();
            System.out.print("\n\t" + o.getName() + " Won the round\n");
            p.setScore(0);
            o.setScore(0);
            if(next() == -1)
            return -1;
        }

        return 0;


    }

    public static int next()
    {
        System.out.print("\n\tEnter:\n" + 
            "1 - to play another match\n" +
            "2 - to view the move history for each player\n" +
            "3 - to exit the program");

        
        boolean flag = true;
        while(flag)
        {
            System.out.print("\nchoice: ");
            int choice = num.nextInt();
            switch(choice)
            {
                case 1:
                    game();
                    break;
                case 2:
                    p.printHistory();
                    System.out.print("\n");
                    o.printHistory();
                    System.out.print("\n\n");
                    break;
                case 3:
                    System.out.print("\nThanks for playing!\n\n\tProgram exited\n\n");
                    flag = false;
                    return -1;
                default:
                    System.out.print("\nInvalid choice\n");
                    break;
            }
        }

        return 0;
    }

    public static void gameMenu()
    {
        System.out.print("\n\tEnter:\n" +
            "1 - to play rock\n" +
            "2 - to play paper\n" + 
            "3 - to play scissors\n");
    }

    

    // public static void waitMenu()
    // {
    //     System.out.print("\n\t");
    // }
    
    
}