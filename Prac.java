
import java.util.*;


public class Prac {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.nextLine();
            System.out.println(in.nextLine());
        }
        
        int max=0;
        int tot=0;
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
                {
               int co= count(or(topic[i],topic[j],m),m);
             //   System.out.print("co is" +co);
                if(co> max )
                    {
                    max=co;
                    tot=0;
                }
                if(co == max)
                    tot++;
            }
        }
        System.out.println(max);
                System.out.println(tot);

    }
    public static int [] or(String a ,String b, int n)
        {
        int [] l=new int[n];
        for(int i=0;i<n;i++)
            {
            l[i]=(((int)a.charAt(i) )|( (int)b.charAt(i)))-48;
        }
        
        System.out.print("or is");
        for(int i=0;i<n;i++)
            {
                    System.out.print(l[i]);

        }
        return l;
    }
    
    public static int count(int [] a, int n)
        {
        int tot=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==1)
                tot++;
        }
        return tot;
    }
    
}