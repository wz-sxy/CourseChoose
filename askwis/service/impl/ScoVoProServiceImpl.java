package com.askwis.service.impl;

import com.askwis.dao.ScoVoProDao;
import com.askwis.domain.ScoVo;
import com.askwis.service.IScoVoProService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ScoVoProServiceImpl extends ServiceImpl<ScoVoProDao, ScoVo> implements IScoVoProService {
    @Autowired
    private ScoVoProDao scoVoProDao;

    @Override
    public List<ScoVo> getScoVo1(ScoVo scoVo){
        return scoVoProDao.getScoVo1(scoVo);
    }

    @Override
    public void poiImport(List list, String xlsPath, String xlsName, String... titles) {
        //先创建一个xls文件  workBook对象 代表excel文件
        Workbook workbook = new HSSFWorkbook();
        //创建一个sheet表
        Sheet sheet = workbook.createSheet(xlsName);
        //先打印标题栏
        int rowIndex = 0;
        Row row = sheet.createRow(rowIndex++);
        for (int i = 0; i < titles.length; i++) {
            row.createCell(i).setCellValue(titles[i]);
        }
        //打印list内容
        for (int i = 0; i < list.size(); i++) {
            //创建行
            Row row1 = sheet.createRow(rowIndex);
            //反射得到Class
            Class clazz = list.get(0).getClass();
            //反射得到所有属性
            Field[] fields = clazz.getDeclaredFields();
            int cellIndex = 0;
            for (int j = 0; j < fields.length; j++) {
                try {
                    //得到属性
                    Field field = fields[j];
                    //打开私有访问权限
                    field.setAccessible(true);
                    //获得属性值
                    Object value = field.get(list.get(i));
                    //创建列
                    row1.createCell(cellIndex++).setCellValue(value + "");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            rowIndex++;
        }
        //将内容输出
        try {
            workbook.write(new FileOutputStream(new File(xlsPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
