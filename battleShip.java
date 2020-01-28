//Programming I-4


//Group name: Destroyer's
//Includes: Brian Farrell, Tamanna Sultana,Sana Kanwal!
//Project BattleShip!

import java.util.Scanner;
public class battleShip
{
   public static void main(String[] args)
   {  //fifth
      Scanner kb = new Scanner(System.in);
      int i,j;
      // call to place ships for computer & player
      int[][] computer = placeShips();
      int[][] player   = placeShips();
      
      int c_score = 0;//keep track of computer hits
      int p_score = 0;//keep track of player hits
      int play = 1;
      
      printBoard(computer,player);
      
      // second we make a while loop for the coordinates
      while(c_score < 25 && p_score < 25 )
      {
         if(play == 1)
         {
            // user's move
            System.out.println("Your turn");
            
               int x,y,launch;
            do
            {
               System.out.print("Enter X coordinate: ");
               x=kb.nextInt();
                     
               System.out.print("Enter Y coordinate: ");
               y=kb.nextInt();
               
               while(x < 1 || x > 10 || y < 1 || y > 10)//checking boundaries
               {   
                  System.out.println("Enter correct pair of coordinates");
                  System.out.print("Enter X coordinate: ");
                  x=kb.nextInt();
                     
                  System.out.print("Enter Y coordinate: ");
                  y=kb.nextInt();
                                   
               }
               
               launch = launchMissile(computer,x,y);
                  
               if(launch == -1)
                  System.out.println("Thoes Coordinates have already been chosen. Please pick again.");
                  
             }while(launch == -1);
               
               if(launch == 2)
               {
                  // HIT
                  p_score++;
               }else
               {
                  // MISS
               }
            
         }else
         {  
            // computer's move
            int x;
            int y;
            int launch;
                  
            do{
               x=(int)((Math.random()* 10)+1);
               y=(int)((Math.random()* 10)+1);
               launch = launchMissile(player,x,y);
            }while(launch == -1);
            
               if(launch == 2)
               {
                  // HIT
                  c_score++;
               }else
               {
                  // MISS
               }               
            
         }
         
         printBoard(computer,player);
         
         // change player
         play *= -1;
      }
      
      // game over
      if(p_score > c_score)
         System.out.println("Congratulations you have won!");   
      else
         System.out.println("You lose! Try again!");
                
   } 
   //fourth we created this method
   public static int[][] placeShips()
   {
      int[][] b = new int[10][10];
      int[] ships ={2,2,3,3,3,4,4,4};
            
      //each ship
      for(int i=0;i < ships.length;i++)
      { //place ships[i]
      
         boolean placed = false;
         
         while(! placed)
         {   // v & h = Vertical/ Horizontal number of unoccupied boxes
         
            int v =0,h=0,x,y;
            
            x = (int)(Math.random()*(10));
            y = (int)(Math.random()*(10));
          int orient =(int)(Math.random()*(2));
                     
            for(int j=0; j < ships[i];j++)
            {
               if(x+j < ships.length && b[y][x+j] == 0)//x+j check for out of bounds
               h++;
               
               if(y+j < ships.length && b[y+j][x] == 0)//y+j check for out of bounds

               v++;
               
               if(orient == 0 && v == ships[i])
               {
                  placed = true;
                  
                  for(j=0; j < ships[i];j++)
                     b[y+j][x] = 1;
               }
               else if(h == ships[i])
               {
                  placed = true;
                  
                  for(j=0;j < ships[i];j++)
                     b[y][x+j] = 1;           
               }             
            
            }
              
         }
     }  
     
     return b; 
   }
     //third created this method
   public static int launchMissile(int[][] b,int x, int y)
   {
     //X is columns & Y is rows. X & Y are position
     // We need to convert x & y positions
     
      int i= y-1;
      int j= x-1;
      
      if( b[i][j] == 0)// 0 is == ocean(#)
      { 
         b[i][j] = 3;  // 3 is == miss (M)
         return 3;
      }
         
      else if(b[i][j] == 1)
      {
         b[i][j] = 2; // 2 is == Hit (H)
         return 2;
      }
         
      return -1;        
   }
     
   // first we created this method for the board  
   public static void printBoard( int[][] c,int[][] p)
   {
      System.out.println("Computer:");
      
      for(int i=0; i < c.length; i++)
      {
         for(int j=0; j < c.length; j++)
         {
           if(j==0)
           {
               if(i < 9)
                  System.out.print(" ");
               System.out.print(i+1 + "| ");
           }
           
           if(c[i][j] == 2)
            System.out.print(" H |");
           else if(c[i][j] == 3)
            System.out.print(" M |");
           else
            System.out.print(" # |");           
         }
         System.out.println();
      }
      
      System.out.println("  ------------------------------------------");
      System.out.println("     1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10");
      
      
      // then this prints out the player board
      System.out.println("Player:");
      
      for(int i=0; i < p.length; i++)
      {
         for(int j=0; j < p.length; j++)
         {
           if(j==0)
           {
               if(i < 9)
                  System.out.print(" ");
               System.out.print(i+1 + "| ");
           }
           
           if(p[i][j] == 2)
            System.out.print(" H |");
           else if(p[i][j] == 3)
            System.out.print(" M |");
          else if(p[i][j] == 1)
            System.out.print(" S |"); 
          else
            System.out.print(" # |");   
         }
         System.out.println();
      }
      
      System.out.println("  ------------------------------------------");
      System.out.println("     1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10");
     }

}
