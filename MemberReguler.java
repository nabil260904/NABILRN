package id.ac.unand.fti.si.pbo;

public class MemberReguler extends Member implements CanGetDiskon, IPoin{
    public Integer saldo;


    
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
                diskon = jumlahBelanja * 0.99; 
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
                
                
            } 
            else if (jumlahBelanja >= 1000000 && jumlahBelanja <= 7000000) {
                diskon = jumlahBelanja * 0.98;
                int newPoin = (int) (diskon/ 10000);
                this.poin = (int) (this.poin + newPoin);
            } 
            else {
                diskon = jumlahBelanja * 0.97;
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
