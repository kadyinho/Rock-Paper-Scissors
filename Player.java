import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Player implements Moves, ISaveable
{   
    private String name;
    private int score;
    private int move;  //rock == 1  paper == 2  scissors == 3
    private ArrayList<String> history;

    public Player(String name)
    {
        this.history = new ArrayList<String>();
        this.name = name;
        this.score = 0;
    }

    public void setScore(int number)
    {
        this.score = number;
    }

    public int getMove()
    {
        return this.move;
    }

    public int getScore()
    {
        return this.score;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public ArrayList getHistory()
    {
        return this.history;
    }

    @Override
    public void playRock()
    {
        this.move = 1;
        history.add("Rock");
    }

    @Override
    public void playPaper()
    {
        this.move = 2;
        history.add("Paper");
    }

    @Override
    public void playScissors()
    {
        this.move = 3;
        history.add("Scissors");
    }

    public void opponentMove()
    {
        Random random = new Random();
        int[] list = {1, 2, 3};
        int spot = random.nextInt(list.length);
        if(list[spot] == 1)
        {
            System.out.print("\nOpponent played rock\n");
            playRock();
        }
        else if(list[spot] == 2)
        {
            System.out.print("\nOpponent played paper\n");
            playPaper();
        }
        else if(list[spot] == 3)
        {
            System.out.print("\nOpponent played scissors\n");
            playScissors();
        }
    }

    public void printHistory()
    {
        System.out.print("\n\t" + this.name + "\n");
        System.out.print("[");
        for(int i = 0; i < this.history.size(); i++)
        {
            System.out.print(this.history.get(i));
            
            if(i < this.history.size() - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
    }

    public void tied()
    {
        
    }

    public void won()
    {
        this.history.add("Win");
    }

    public void lost()
    {
        this.history.add("Lost");
    }

    
    public void scored()
    {
        this.score++;
    }



    

    

}