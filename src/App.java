import java.sql.SQLOutput;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static String name;

    public static int balance = 0;

    public static void main(String[] args) {

        viewShowBalance();

    }

    /**
     * HANDLE MENU
     */

    public static String input(String info){

        System.out.print(info);
        String value = scanner.nextLine();
        return value;
    }
    public static boolean handleOption(String param){
        if(param.equals("y") || param.equals("Y")){
            return true;
        } else {
            return false;
        }
    }

    /**
     * BUSSINESS LOGIC
     */

    // Menampilkan saldo
    public static void showBalance(){

        System.out.println("Nama Anda : " + name);
        System.out.println("Saldo Sekarang = Rp. " + balance);


    }
    // Menambahkan saldo
    public static int addBalance(int value){


        return balance += value;

    }
    // Mengurangi atau Menarik saldo
    public static int withdrawBalance(int value){

       if(value > balance){
           System.out.println("Gagal menarik saldo");
           return balance;
       } else {
           return balance -= value;
       }

    }

    /**
     * VIEW
     */

    // Menampilkan view atm
   
    public static void viewShowBalance(){

        System.out.println("### SELAMAT DATAND DI APP ATM SEDERHANA ###");
        name = input("Masukan Nama : ");

        balance += Integer.parseInt(input("Saldo Awal Anda : "));

        System.out.println("Nama Anda = " + name);
        System.out.println("Saldo Awal = Rp. " + balance);

        boolean handleBool = true;

        while (handleBool){
            System.out.println("PILIH MENU");
            System.out.println("1. Menabung");
            System.out.println("2. Tarik Tabungan");
            var option = input("Pilihan Anda : ");

            switch (option){
                case "1" :
                    viewAddBalance();
                    showBalance();
                   handleBool = viewRepeatOption();
                    break;
                case "2" :
                    viewWithdrawBalance();
                    showBalance();
                    handleBool = viewRepeatOption();
                    break;
                default:
                    System.out.println("Pilihan tidak diketahui");
            }
        }

    }
    // Menampilkan view tambah saldo
    public static void viewAddBalance(){
        addBalance(Integer.parseInt(input("Masukan Nominal Tabungan : ")));
    }
    // Menampilkan view mengurangi saldo
    public static void viewWithdrawBalance(){
        withdrawBalance(Integer.parseInt(input("Masukan Nominal Yang Ingin Ditarik : ")));
    }
    // Menampilkan view pilih menu ulangi program
    public static boolean viewRepeatOption(){
        String repeat = input("Apakah Anda ingin mengulang transaksi[y/N]?");
        return handleOption(repeat);
    }
}
