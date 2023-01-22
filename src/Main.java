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
        System.out.print("masukkan batas iterasi = ");
        double batas_iterasi = input.nextDouble();
        System.out.print("masukkan nilai error   = ");
        double batas_error = input.nextDouble();

        System.out.println("f(x)    = " + A + "x^" + B + " + " + C + "x^" + D + " + " + E + "x" + " + " + F );
        input_x1_dan_x2(A,B,C,D,E,F,1,batas_iterasi,batas_error);

    }

    public void input_x1_dan_x2(double A, double B, double C, double D, double E, double F, double iterasi_ke,double batas_iterasi, double batas_error)
    {
        System.out.print("masukkan x1 = ");
        double x1 = input.nextDouble();
        System.out.print("masukkan x2 = ");
        double x2 = input.nextDouble();
        proses_awal(A,B,C,D,E,F,iterasi_ke,batas_iterasi,x1,x2, batas_error);
    }

    public void proses_awal(double A, double B, double C, double D, double E, double F, double iterasi_ke,double batas_iterasi, double x1,  double x2, double batas_error)
    {
        System.out.println("iterasi ke - "+ iterasi_ke);
        double proses_fx_1_B = 1, proses_fx_1_D = 1,  proses_fx_2_B = 1, proses_fx_2_D = 1;

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
            proses_selanjutnya(A,B,C,D,E,F,x1,x2,proses_fx_1,proses_fx_2,iterasi_ke,batas_iterasi, batas_error);
        }
        else
        {
            System.out.println("tidak memenuhi syarat");
            input_x1_dan_x2(A,B,C,D,E,F,iterasi_ke,batas_iterasi,batas_error);
        }
    }

    void proses_selanjutnya(double A, double B, double C, double D, double E, double F,double x1,double x2,double proses_fx_1, double proses_fx_2,double iterasi_ke,double batas_iterasi ,double batas_error)
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
        System.out.println("x3  = " + x3);
        System.out.println("fx3 = " + proses_fx_3);
        double proses_evaluasi = (proses_fx_3 * proses_fx_1);
        boolean evaluasi =  proses_evaluasi < batas_error;

        if (batas_error > proses_evaluasi  || iterasi_ke == 3)
        {
            System.out.println("stop");
        }
        else if (evaluasi ==true)
        {
            proses_awal(A,B,C,D,E,F,iterasi_ke+1,batas_iterasi,x1, x3,batas_error);
        }
        else
        {
            proses_awal(A,B,C,D,E,F,iterasi_ke+1,batas_iterasi,x3, x2,batas_error);
        }

    }

}
public class Main {
    public static void main(String[] args) {
        new proses().inputan_nilai_fx();
    }
}