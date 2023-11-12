package id.ac.unand.fti.si.pbo;

public class MemberGold extends Member implements CanRequestCicilan, CanRequestDelivery, CanGetDiskon,IPoin{
    public Integer saldo;


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
        if (jarakTujuan < 7){
            ongkir = 0;
        }
        else {

            ongkir = (Math.ceil(jarakTujuan) - 7)*1000;
        
        }
        return (Double) ongkir;
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
                diskon = jumlahBelanja * 0.98; 
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
                
                
            } 
            else if (jumlahBelanja >= 1000000 && jumlahBelanja <= 7000000) {
                diskon = jumlahBelanja * 0.96;
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
            } 
            else {
                diskon = jumlahBelanja * 0.94;
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
               
            }
        }
        return (int) diskon;
    };

/*--------------------------------------------------------------------------------------------------------- */
    public Integer redeemPoin(Integer hargaSouvenir){
    return this.poin = this.poin - hargaSouvenir;
    }
    public Integer getPoin(){
        return this.poin;
    }
}
