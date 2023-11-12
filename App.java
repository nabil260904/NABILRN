package id.ac.unand.fti.si.pbo;

public class App {
    
    public static void main(String[] args) {
        MemberSilver memberSilver = new MemberSilver();
        
        // Mengeset saldo dan poin awal
        memberSilver.saldo = 1000000;
        memberSilver.poin = 500;
        
        // Menjalankan beberapa fungsi
        double ongkir = memberSilver.hitungOngkir(7.5);
        System.out.println("Ongkir: " + ongkir);
        
        int totalBayar = memberSilver.hitungTotalBayar(800000);
        System.out.println("Total Bayar: " + totalBayar);
        
        int redeemedPoin = memberSilver.redeemPoin(200);
        System.out.println("Poin setelah redeem: " + memberSilver.getPoin());
    }
    
}
