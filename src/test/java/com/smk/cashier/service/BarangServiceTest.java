package com.smk.cashier.service;

import com.smk.cashier.dao.BarangDao;
import com.smk.cashier.model.Barang;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BarangServiceTest {

    @Test
    @Order(2)
    void getBarangList() {
        List<Barang> barangList
                =BarangService.getInstance().barangList;
        assertEquals(barangList.size(),2);
    }

    @Test
    @Order(1)
    void addBarang() {
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("laptop");
        laptop.setHargaBarang(5000000);
        BarangService.getInstance()
                .addBarang(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("M0001");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(250000);
        BarangService.getInstance()
                .addBarang(mouse);
    }

    @Test
    @Order(4)
    void saveBarangtoDatabase(){
        BarangDao barangDao = new BarangDao();
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("laptop");
        laptop.setHargaBarang(5000000);
        laptop.setDateCreated(new Date());
        laptop.setLastModifed(new Date());
       barangDao.save(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("M0001");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(250000);
        mouse.setDateCreated(new Date());
        mouse.setLastModifed(new Date());
        barangDao.save(mouse);
    }
}
