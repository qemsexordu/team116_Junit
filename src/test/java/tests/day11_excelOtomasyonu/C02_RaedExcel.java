package tests.day11_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractSet;
import java.util.Map;
import java.util.TreeMap;

public class C02_RaedExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/test/java/tests/day11_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis =  new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)


        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre); // Başkent (İngilizce)

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedResult="Kabil";
        String actualResult = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedResult,actualResult);

        //- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum());

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows());

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String>ulkelerMap = new TreeMap<>();
        for (int i = 1; i < sayfa1.getLastRowNum() ; i++) {
            String key=sayfa1.getRow(i).getCell(0).toString();
            String value = sayfa1.getRow(i).getCell(1).toString();
            ulkelerMap.put(key,value);

        }

        System.out.print(ulkelerMap);

        // listede benin isminde bir ulke olup olmadigini test edin
        Assert.assertTrue(ulkelerMap.containsKey("Benin"));

        // listede Ankara isminde bir Baskent olup olmadigini test edin
        Assert.assertTrue(ulkelerMap.containsValue("Ankara"));
    }

}
