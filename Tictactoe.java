import java.util.*;
class Main{
public static void move(String p,String[][] a)
    {
        
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Player "+p+"enter row and column (0-2)");
            int r= sc.nextInt();
            int c=sc.nextInt();
            if(a[r][c].equals(" ")){
                a[r][c]=p;
                return;
            }
            else{
                System.out.print("Cell occupied ");
                return;
            }
            
        }
        
    }
    public static void display(String a[][])
    {
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
   public static boolean draw(String a[][])
  {
       int f=0;
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(!a[i][j].equals(" ")){
                   f++;
               }
           }
       }
       if(f==9){
           return true;
       }
       else{
           return false;
       }
    }
    public static boolean win(String a[][])
    { 
          for (int i = 0; i < 3; i++) {
            if (a[i][0]!= " " && a[i][0] == a[i][1] && a[i][1] == a[i][2]) {
                return true;
            }
            if (a[0][i]!= " " && a[0][i] == a[1][i] && a[1][i] == a[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (a[0][0]!= " " && a[0][0] == a[1][1] && a[1][1] == a[2][2]) {
            return true;
        }
        if (a[0][2]!= " " && a[0][2] == a[1][1] && a[1][1] == a[2][0]) {
            return true;
        }

        // No winner
        return false;

}
public static void main(String[] args) {
        String player="X";
  String[][] a = new String[3][3];
        
       boolean flag=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=" ";
            }
        }
        while(flag)
        {
            display(a);
            move(player,a);
            if(win(a))
            {
                display(a);
                System.out.println("Player"+player+"wins");
                flag=false;
                
            }
            else if(draw(a))
            {
                display(a);
                System.out.println("It's a draw");
                flag=false;
            }
            else{
                if(player=="X")
   {
                    player="O";
                }
                else{
                    player="X";
                }
            }
       }
}
}