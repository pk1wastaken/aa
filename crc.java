import java.util.Scanner;

class CRC {
    void div(int a[], int k) {
        int gp[] = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
        for (int i = 0; i < k; i++)
            if (a[i] == gp[0])
                for (int j = i, c = 0; j < 17 + i; j++)
                    a[j] ^= gp[c++];
    }

    public static void main(String args[]) {
        int a[] = new int[66], b[] = new int[66], len, k, f = 0;
        PRO7 o = new PRO7();
        Scanner s = new Scanner(System.in);
        len = s.nextInt();
        for (int i = 0; i < len; i++) a[i] = s.nextInt();
        for (int i = 0; i < 16; i++) a[len++] = 0;
        k = len - 16;
        System.arraycopy(a, 0, b, 0, len);
        o.div(a, k);
        for (int i = 0; i < len; i++) a[i] ^= b[i];
        System.out.println("Data: ");
        for (int i = 0; i < len; i++) System.out.print(a[i] + " ");
        System.out.println("\nEnter Received Data: ");
        for (int i = 0; i < len; i++) a[i] = s.nextInt();
        o.div(a, k);
        for (int i = 0; i < len; i++) if (a[i] != 0) f = 1;
        if (f == 1) System.out.println("error");
        else System.out.println("no error");
    }
}
