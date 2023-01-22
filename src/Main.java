import java.util.Scanner;

class proses
{
    Scanner input = new Scanner(System.in);
    public void inputan_nilai_fx()
    {
        System.out.println("masukkan nilai f(x) = Ax^B + Cx^D + Ex + F ");
        System.out.print("masukkan nilai A = ");
        double A = input.nextDouble();
        System.out.print("masukkan nilai B = ");
        double B = input.nextDouble();
        System.out.print("masukkan nilai C = ");
        double C = input.nextDouble();
        System.out.print("masukkan nilai D = ");
        double D = input.nextDouble();
        System.out.print("masukkan nilai E = ");
        double E = input.nextDouble();
        System.out.print("masukkan nilai F = ");
        double F = input.nextDouble();

        System.out.println("f(x)    = " + A + "x^" + B + " + " + C + "x^" + D + " + " + E + "x" + " + " + F );
        proses_awal(A,B,C,D,E,F);

    }

    public void proses_awal(double A, double B, double C, double D, double E, double F)
    {
        double proses_fx_1_B = 1, proses_fx_1_D = 1,  proses_fx_2_B = 1, proses_fx_2_D = 1;
        System.out.print("masukkan x1 = ");
        double x1 = input.nextDouble();
        System.out.print("masukkan x2 = ");
        double x2 = input.nextDouble();
        System.out.print("masukkan batas iterasi = ");
        double batas_iterasi = input.nextDouble();


        for (int perulangan = 0; perulangan < B ; perulangan++)
        {
            proses_fx_1_B = proses_fx_1_B * x1;
            proses_fx_2_B = proses_fx_2_B * x2;
        }

        for (int perulangan = 0; perulangan < D ; perulangan++)
        {
            proses_fx_1_D = proses_fx_1_D * x1;
            proses_fx_2_D = proses_fx_2_D * x2;
        }

        double proses_fx_1 = A*proses_fx_1_B+C*proses_fx_1_D+E*x1+F;
        double proses_fx_2 = A * proses_fx_2_B + C * proses_fx_2_D + E*x2 + F;
        System.out.println("x1  = "+ x1);
        System.out.println("fx1 = " + proses_fx_1);
        System.out.println("x2  = "+ x2);
        System.out.println("fx2 = "+ proses_fx_2);

        double nilai_perbandingan = proses_fx_1 * proses_fx_2;
        boolean proses_perbandingan = nilai_perbandingan < 0;

        if (proses_perbandingan == true)
        {
            iterasi_pertama(A,B,C,D,E,F,x1,x2,proses_fx_1,proses_fx_2);
        }
        else
        {
            System.out.println("tidak memenuhi syarat");
            proses_awal(A, B, C, D, E, F);
        }
    }

    void iterasi_pertama(double A, double B, double C, double D, double E, double F,double x1,double x2,double proses_fx_1, double proses_fx_2 )
    {
        double proses_fx_3_B = 1, proses_fx_3_D = 1;
        double segitiga_x = x2 - x1;
        double x3 = x2 - proses_fx_1/proses_fx_2-proses_fx_1*segitiga_x;


        for (int perulangan = 0; perulangan < B ; perulangan++)
        {
            proses_fx_3_B = proses_fx_3_B * x3;

        }

        for (int perulangan = 0; perulangan < D ; perulangan++)
        {
            proses_fx_3_D = proses_fx_3_D * x3;

        }

        double proses_fx_3 = A*proses_fx_3_B+C*proses_fx_3_D+E*x1+F;

        boolean evaluasi = (proses_fx_3 * proses_fx_1) <0;

        if (evaluasi == true)
        {
            System.out.println("stop");
        }
        else
        {
            System.out.println("lanjut lagi iterasi berikutnya");
        }

    }

}
public class Main {
    public static void main(String[] args) {
        new proses().inputan_nilai_fx();
    }
}