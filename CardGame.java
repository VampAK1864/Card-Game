// Author: Antonis Kyriakou
// Compilication command: CardGame.java
// Execution command: java CardGame

public class CardGame {

//INITIALIZE DECK.
  public static String[] CreateDeck() {
    String[] suit = { "C", "D", "H", "S" };// ARRAY OF CARD TYPE.
    String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };//ARRAY OF THE CARDS.

    int SUITS = suit.length;//NUMBER SIZE OF SUITS(4).
    int RANKS = rank.length;//NUMBER SIZE OF CARDS(13).
    int N = SUITS * RANKS;//MULTIPLY ALL CARDS WITH THE TYPE.

    String[] deck = new String[N];//MAKING ALL THE TYPE OF CARDS.
    for (int i = 0; i < RANKS; i++)//I IS MAKING ALL THE POSSIBLE COMBINATIONS OF CARDS.
      for (int j = 0; j < SUITS; j++)//I IS MAKING ALL THE POSSIBLE COMBINATIONS OF TYPES.
        deck[SUITS * i + j] = rank[i] + suit[j];//MAKING ALL THE COMBINATIONS IN A NEW ARRAY.

    return deck;//RETURN THE COMPLETED DECK.
  }
//SHUFFLE DECK.
  public static void ShuffleDeck(String[] deck) {
    final int NUM_SHUFFLES = 12; //ALL CARDS NUMBER.

    int First_num;//RANKS. 
    int Second_num;//SUITS.
    String Swap;
    int range = deck.length;//SIZE OF ALL DECK.

    for (int count = 1; count <= NUM_SHUFFLES; count++)//SHUFFLING ALL POSSIBLE COMBINATIONS.
    {
      First_num = (int) (Math.random() * range);//SHUFFLING RANKS.
      Second_num = (int) (Math.random() * range);//SHUFFLING SUITS

      //SHUFFLING CARDS.
      Swap = deck[First_num];
      deck[First_num] = deck[Second_num];
      deck[Second_num] = Swap;
    }
  }
//DISPLAY DECK.
  public static void DisplayDeck(String[] deck) {

    for (int i = 0; i < 4; i++)//I IS FOR THE 4 PLAYERS.
    {
      System.out.print(" Player's " + (i + 1) + " " + " hand is: " + "\n");//SHOWS THE NUMBER OF PLAYER AND THE CARDS.

      for (int j = 0; j < 13; j++)//13 CARDS OF EACH PLAYER.
      {
        System.out.print(deck[i + j * 4]);//PRINTS THE 13 CARDS OF EACH PLAYER.
        System.out.print(" ");//PRINTS A SPACE.
      }
      System.out.print("\n");//PRINTS A LINE.
    }
  }

  public static void main(String[] args) {

    //ARRAYS WITH SHUFFLED CARDS OF EACH PLAYER.
    String[] Player1 = new String[13];
    	String[] Player2 = new String[13];
    		String[] Player3 = new String[13];
    			String[] Player4 = new String[13];

    			String[] deck = CreateDeck();//THE DECK.
    	ShuffleDeck(deck);//SHUFFLING THE CARDS.
    DisplayDeck(deck);//SHOWS DECK.

    // ARRAY CARD OF EACH PLAYER.
    
    // PLAYER 1.
    for (int j = 0; j < 13; j++)//13 FOR THE CARDS.
    {
      for (int c = 0; c < 1; c++)//FOR PLAYER 1.
      {
        Player1[j] = deck[0 + j * 4];//ARRAY OF PLAYER1 DECK.
      }
    }

    // PLAYER 2.
    for (int j = 0; j < 13; j++)//13 FOR THE CARDS.
    {
      for (int c = 0; c < 1; c++)//FOR PLAYER 2.
      {
        Player2[j] = deck[1 + j * 4];//ARRAY OF PLAYER2 DECK.
      }
    }

    // PLAYER 3.
    for (int j = 0; j < 13; j++)//13 FOR THE CARDS.
    {
      for (int c = 0; c < 1; c++)//FOR PLAYER 3.
      {
        Player3[j] = deck[2 + j * 4];//ARRAY OF PLAYER3 DECK.
      }
    }

    // PLAYER 4.
    for (int j = 0; j < 13; j++)//13 FOR THE CARDS.
    {
      for (int c = 0; c < 1; c++)//FOR PLAYER 4.
      {
        Player4[j] = deck[3 + j * 4];//ARRAY OF PLAYER4 DECK.
      }
    }

    int Pile = 0; // COUNTER OF THE GAME.
    	int Chip1 = 3; // "LIVES" OF PLAYER1.
    		int Chip2 = 3; // "LIVES" OF PLAYER2.
    			int Chip3 = 3; // "LIVES" OF PLAYER3.
    				int Chip4 = 3; // "LIVES" OF PLAYER4.
    				
    boolean stopFlag = false;
    
    while (Pile <= 100 && !stopFlag)//THIS CHECKING WHEN PILE IS LESS THAN 100 THAT THE GAME MUST BE PLAYED.
    {
      for (int c = 0; c < 52; c++)//CHECKS THE 52 CARDS.
      {
        if (Chip1 <= 0)//CHECKS IF CHIP FOR PLAYER 1 IS LESS EQUAL THAN ZER0.
        {
          System.out.println("The first eliminated player was Player1.");//PRINTS THAT THE ELIMINATED PLAYER IS 1.
          stopFlag = true;
          break;//ENDS THIS IF. 
        }
        else if (Chip2 <= 0)//CHECKS IF CHIP FOR PLAYER 2 IS LESS EQUAL THAN ZER0.
        {
          System.out.println("The first eliminated player was Player2.");//PRINTS THAT THE ELIMINATED PLAYER IS 2.
          stopFlag = true;
          break;//ENDS THIS IF. 
        }
        else if (Chip3 <= 0)//CHECKS IF CHIP FOR PLAYER 3 IS LESS EQUAL THAN ZER0.
        {
          System.out.println("The first eliminated player was Player3.");//PRINTS THAT THE ELIMINATED PLAYER IS 3.
          stopFlag = true;
          break;//ENDS THIS IF. 
        }
        else if (Chip4 <= 0)//CHECKS IF CHIP FOR PLAYER 4 IS LESS EQUAL THAN ZER0.
        {
          System.out.println("The first eliminated player was Player4.");//PRINTS THAT THE ELIMINATED PLAYER IS 4.
          stopFlag = true;
          break;//ENDS THIS IF.
        }
        
/*THE PURPOSE OF THIS SWTICH IS FOR CARDS
 *  TO COUNT THE POINTS IN PILE, ALSO THERE 
 *  ARE SOME CARDS THAT COUNT MORE.
 */
        switch (deck[c])
        {
        
 /*************** SPECIAL CARDS ******************/
        
        case "6H":
          Pile = Pile + 10;//PLUS 10 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "2S":
          Pile = Pile * 2;//MULTIPLIES PILE BY 2.
          break;//ENDS THIS CASE.

        case "5H":
        case "5D":
          Pile = Pile - 5;//MINUS PILE BY 2 POINTS.
          break;//ENDS THIS CASE.

        case "10C":
        case "10D":
        case "10H":
        case "10S":
          Pile = 100;//PUT PILES INSTANT TO 100.
          break;//ENDS THIS CASE.

        case "JC":
        case "JD":
        case "JH":
        case "JS":
          Pile = Pile - 10;//MINUS PILE BY 10 POINTS.
          break;//ENDS THIS CASE.

        case "QH":
          Pile = 0;
          break;//ENDS THIS CASE.

        //THE PILE DOSENT CHANGE.
        case "KC":
        case "KD":
        case "KH":
        case "KS":
          break;//ENDS THIS CASE.

  /*************** NORMAL CARDS ******************/
          
        case "2C":
        case "2D":
        case "2H":
          Pile = Pile + 2;//PLUS 2 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "3C":
        case "3D":
        case "3H":
        case "3S":
          Pile = Pile + 3;//PLUS 3 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "4C":
        case "4D":
        case "4H":
        case "4S":
          Pile = Pile + 4;//PLUS 4 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "5C":
        case "5S":
          Pile = Pile + 5;//PLUS 5 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "6C":
        case "6D":
        case "6S":
          Pile = Pile + 6;//PLUS 6 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "7C":
        case "7D":
        case "7H":
        case "7S":
          Pile = Pile + 7;//PLUS 7 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "8C":
        case "8D":
        case "8H":
        case "8S":
          Pile = Pile + 8;//PLUS 8 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "9C":
        case "9D":
        case "9H":
        case "9S":
          Pile = Pile + 9;//PLUS 9 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "QC":
        case "QD":
        case "QS":
          Pile = Pile + 10;//PLUS 10 POINTS TO PILE.
          break;//ENDS THIS CASE.

        case "AC":
        case "AD":
        case "AH":
        case "AS":
          Pile = Pile + 10;//PLUS 10 POINTS TO PILE.
          break;//ENDS THIS CASE.
        }

        System.out.println(" ");//PRINTS AN EMPTY LINE.

        int player = (c % 4) + 1;// PLAYER COUNTER.

        //PRINTS THE VALUE OF THE PILE AND WCHICH PLAYER HAS PLAYED AND WHAT CARD HAS PLAYED.
        System.out.print("Value of the pile is: " + Pile + "." + " " + "Player" + player + " " + "played: " + deck[c] + ".");

        if (Pile > 100)//CHECKS IF THE PILE IS BIGGER THAN 100.
        {
        	System.out.print("\n");//PRINTS A NEW LINE.
        	//PRINTS THE VALUE OF PILE THAT EXITED THE 100 AND THE PLAYER WHO EXITED.
          System.out.println('\n' + "With a final pile value of: " + Pile + " The loser of the round was " + "Player" + player);
      	System.out.print("\n");//PRINTS A NEW LINE.

            switch (player)//THIS SWTICH CHECKS WHO HAS HITTED SCORE 100 AND IT REMOVES ONE CHIP EACH TIME.
            {
            //PLAYER1 CHIPS.
            case 1:
              Chip1--;//REMOVES 1 CHIP EACH TIME FOR PLAYER1.
              break;//ENDS THIS CASE.
            //PLAYER2 CHIPS
            case 2:
              Chip2--;//REMOVES 1 CHIP EACH TIME FOR PLAYER2.
              break;//ENDS THIS CASE.
            //PLAYER3 CHIPS.
            case 3:
              Chip3--;//REMOVES 1 CHIP EACH TIME FOR PLAYER3.
              break;//ENDS THIS CASE.
            //PLAYER4 CHIPS.
            case 4:
              Chip4--;//REMOVES 1 CHIP EACH TIME FOR PLAYER4.
              break;//ENDS THIS CASE.
            }
            //CHECKS IF THE CHIPS ARE GREATER THAN 0 AND THEN SHUFFLING THE CARDS FOR ANOTHER ROUND.
            if (Chip1  > 0 && Chip2 > 0 && Chip3 > 0 && Chip4 > 0)
            {
              ShuffleDeck(deck);//SHUFFLING THE CARDS.
              DisplayDeck(deck);//DISPLAY DECK.
              Pile = 0;//PILE IS SET TO 0 FOR EVERY NEW ROUND.
            }
          }
        }
      }
    //PRINTS THE FINAL SCORE OF EACH PLAYER AND SHOWS THE LOSER. THE LOSER IS THE ONE WITH THE 0 CHIPS.
    System.out.println('\n' + "Final Score: Player1" + "\t" + "Player2" + " " + " "+ "Player3" + " " + " "+ "Player4");
    System.out.println("             " + "-------" + "    " + "-------" + "  " + "-------" + "  " + "-------");
    System.out.print("                " + Chip1+ "          " + Chip2+ "        " + Chip3 + "        " + Chip4);
    }
  }
