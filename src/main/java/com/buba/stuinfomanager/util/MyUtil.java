package com.buba.stuinfomanager.util;


import org.apache.poi.ss.usermodel.Cell;

public class MyUtil {
    /**
     * 处理导入小数点
     * @param cell
     */
    public  static String  numOfImport(Cell cell) {
        String value = cell.toString();
        int i = cell.getCellType();
        if (i == 1) {//字符串类型
            return value;
        } else {
            String[] str = value.split("\\.");
            if (str.length > 1) {
                String str1 = str[1];
                int m = Integer.parseInt(str1);
                if (m == 0) {
                    return str[0];
                } else {
                    return value;
                }
            }else{
                return value;
            }
        }


    }
}
