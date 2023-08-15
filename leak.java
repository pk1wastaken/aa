import java.util.Scanner;
// import java.lang.*;

public class leaky{
    public static void main(String[] args) {
        int i;
        int a[]=new int[20];
        int buck_rem =0;
        int buck_cap =4;
        int rate =3;
        int sent , recv;
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the number of packets");
        int n = sc.nextInt();
        System.out.println("enter the packets");
        for(i =1; i<=n; i++)
            a[i] = sc.nextInt();
        System.out.println("clock\tpacketsize\taccept\tsent\tremaining");
        for(i=1;i<=n;i++)
        {
            if(a[i]!=0)
            {
                if(buck_rem+a[i]>buck_cap)
                recv=-1;
                else
                {
                    recv=a[i];
                    buck_rem+=a[i];
                }
            }
            else
            recv=0;
            if(buck_rem!=0)
            {
                if(buck_rem<rate)
                {
                    sent=buck_rem;
                    buck_rem-=sent;
                }
                else{
                    sent=rate;
                    buck_rem-=rate;
                }
            }
            else
            sent=0;
            if(recv==-1)
            System.out.println(i+"\t\t"+a[i]+"\t\t"+"dropped"+"\t\t"+sent+"\t\t"+buck_rem);
            else
            System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t\t"+sent+"\t\t"+buck_rem);
        }
        
    }

}
