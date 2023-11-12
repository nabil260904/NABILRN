package id.ac.unand.fti.si.pbo;

public class MemberPlatinum extends Member implements CanRequestCicilan, CanDeposit, CanRequestDelivery, CanGetDiskon,IPoin{
    public Integer saldo = 0;


    @Override
    public Integer hitungCicilanPerBulan(Integer totalBelanja, Integer jumlahBulan){
        Integer tenor = 24;
        if (totalBelanja < 5000000) {
            System.out.println("Harga barang harus lebih dari Rp 5.000.000");
        }
        if (tenor > jumlahBulan) {
            System.out.println("Tenor maksimal adalah 24 bulan");
        }
        // Hitung cicilan perbulan
        double cicilanPerbulan = totalBelanja / tenor;

        // Kembalikan hasil
        return (int) cicilanPerbulan;
    };
    public Double hitungOngkir(Double jarakTujuan) {
        double ongkir = 0;
         if (jarakTujuan < 10){
             ongkir = 0;
         }
         else {
 
             ongkir = (Math.ceil(jarakTujuan) - 10)*1000;
         
         }
         return (Double) ongkir;
     };
    /*--------------------------------------------------------------------------------------------------------- */
    public Integer deposit(Integer jumlahDeposit){
        return this.saldo = jumlahDeposit;
    };
    public Integer tarikTunai(Integer jumlahTarikTunai){
        return this.saldo -= jumlahTarikTunai;
    };
    public Integer cekSaldo(){
        return this.saldo;
    };

/*--------------------------------------------------------------------------------------------------------- */
    public Integer hitungTotalBayar(Integer jumlahBelanja){
        double diskon = 0;
        if (jumlahBelanja < 500000) {
            int newPoin = (jumlahBelanja/ 10000);
            this.poin = (int) (this.poin + newPoin);
            return (int) jumlahBelanja;
        } 
        else {
            if (jumlahBelanja >= 500000 && jumlahBelanja <= 1000000) {
                diskon = jumlahBelanja * 0.97; 
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
                
                
            } 
            else if (jumlahBelanja >= 1000000 && jumlahBelanja <= 7000000) {
                diskon = jumlahBelanja * 0.95;
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
            } 
            else if (jumlahBelanja >= 7000000 && jumlahBelanja <= 10000000) {
                diskon = jumlahBelanja * 0.93;
                int oldPoin = (int) diskon;
                int newPoin = (int) (oldPoin/ 10000);
                this.poin = (int) (this.poin + newPoin);
                this.poin--;
                diskon--;
            } 
            else {
                diskon = jumlahBelanja * 0.93;
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
               
            }
        }
        return (int) (diskon*1.0);
    };

/*--------------------------------------------------------------------------------------------------------- */
    public Integer redeemPoin(Integer hargaSouvenir){
    return this.poin = this.poin - hargaSouvenir;
    }
    public Integer getPoin(){
        return this.poin;
    }
}
