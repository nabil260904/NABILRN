package id.ac.unand.fti.si.pbo;

// meng-implementasikan beberapa interface (CanRequestDelivery, CanGetDiskon, IPoin)
public class MemberSilver extends Member implements CanRequestDelivery, CanGetDiskon, IPoin {
    // Atribut saldo hanya dapat diakses dari dalam kelas MemberSilver
    public Integer saldo;

    // Metode hitungOngkir() menghitung ongkir berdasarkan jarakTujuan, menunjukkan penggunaan polimorfisme
    public Double hitungOngkir(Double jarakTujuan) {
        double ongkir = 0;
        if (jarakTujuan < 5) {
            ongkir = 0;
        } else {
            ongkir = (Math.ceil(jarakTujuan) - 5) * 1500;
        }
        return (Double) ongkir;
    };

    // Metode hitungTotalBayar() menghitung total bayar dengan memperhitungkan diskon dan poin, menunjukkan penggunaan polimorfisme
    public Integer hitungTotalBayar(Integer jumlahBelanja) {
        double diskon = 0;
        if (jumlahBelanja < 500000) {
            int newPoin = (jumlahBelanja / 10000);
            this.poin = (int) (this.poin + newPoin);
            return (int) jumlahBelanja;
        } else {
            // Penggunaan diskon berdasarkan jumlahBelanja menunjukkan variasi metode untuk kondisi tertentu
            if (jumlahBelanja >= 500000 && jumlahBelanja <= 1000000) {
                diskon = jumlahBelanja * 0.99;
                int newPoin = (int) (diskon / 10000);
                this.poin = (int) (this.poin + newPoin);
            } else if (jumlahBelanja >= 1000000 && jumlahBelanja <= 7000000) {
                diskon = jumlahBelanja * 0.97;
                int newPoin = (int) (diskon / 10000);
                this.poin = (int) (this.poin + newPoin);
            } else {
                diskon = jumlahBelanja * 0.95;
                int newPoin = (int) (diskon / 10000);
                this.poin = (int) (this.poin + newPoin);
            }
        }
        return (int) diskon;
    };

    // Metode redeemPoin() mengurangkan poin berdasarkan hargaSouvenir, menunjukkan penggunaan polimorfisme
    public Integer redeemPoin(Integer hargaSouvenir) {
        return this.poin = this.poin - hargaSouvenir;
    }

    // Metode getPoin() mengembalikan nilai poin, menunjukkan penggunaan polimorfisme
    public Integer getPoin() {
        return this.poin;
    }
}
