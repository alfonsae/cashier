package com.smk.cashier.service;

import com.smk.cashier.dao.BarangDao;
import com.smk.cashier.dao.StokDao;
import com.smk.cashier.model.Barang;
import com.smk.cashier.model.Stok;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockServiceTest {
    @Test
    @Order(4)
    void saveStocktoDatabase(){
        StokDao stokDao= new StokDao();
        Stok stok = new Stok();
        stok.setStokBarang(10);
        stok.setKodeBarang("LP001");
        stok.setDateCreated(new Date());
        stok.setLastModifed(new Date());
        stokDao.save(stok);

        Stok stok2 = new Stok();
        stok2.setStokBarang(15);
        stok2.setKodeBarang("M0001");
        stok2.setDateCreated(new Date());
        stok2.setLastModifed(new Date());
        stokDao.save(stok2);
    }
    @Test
    @Order(5)
    void getDataById(){
        BarangDao barangDao = new BarangDao();
        Optional<Barang> barang1 = barangDao.get(1);
        barang1.ifPresent(new Consumer<Barang>() {
            @Override
            public void accept(Barang barang) {
                assertEquals("laptop",barang.getNamaBarang());
                assertEquals("LP001", barang.getKodeBarang());
            }
        });
        Optional<Barang> barang2 = barangDao.get(4);
        barang2.ifPresent(new Consumer<Barang>() {
            @Override
            public void accept(Barang barang) {
                assertEquals("Mouse",barang.getNamaBarang());
                assertEquals("M0001", barang.getKodeBarang());
            }
        });

    }
}

