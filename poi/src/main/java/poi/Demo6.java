package poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取表格文件
 *
 * @author Nathan
 */
public class Demo6 {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:\\二货名单.xls");
        POIFSFileSystem fs = new POIFSFileSystem(is);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        // 获取第一个Sheet页
        HSSFSheet hssfSheet = wb.getSheetAt(0);
        if (hssfSheet == null) {
            return;
        }
        // 遍历行Row
        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow == null) {
                continue;
            }
            // 遍历列Cell
            for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                HSSFCell hssfCell = hssfRow.getCell(cellNum);
                if (hssfCell == null) {
                    continue;
                }
                System.out.print(" " + getValue(hssfCell));
            }
            System.out.println();
        }
    }

    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
