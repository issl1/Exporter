package org.vaadin.haijian;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

import java.util.Date;

import org.vaadin.haijian.filegenerator.ExcelFileBuilder;
import org.vaadin.haijian.filegenerator.FileBuilder;

public class ExcelExporter extends Exporter {
	
    public ExcelExporter() {
        super();
    }

    public ExcelExporter(Table table) {
        super(table);
    }

    public ExcelExporter(Container container, Object[] visibleColumns) {
        super(container, visibleColumns);
    }

    public ExcelExporter(Container container) {
        super(container);
    }

    @Override
    protected FileBuilder createFileBuilder(Container container) {
        return new ExcelFileBuilder(container);
    }

    @Override
    protected String getDefaultDownloadFileName() {
		return "exported-excel-" + getDateTimeFmt().format(new Date()) + ".xls";
	}
    
    @Override
    protected String getDownloadFileName() {
    	if(downloadFileName == null){
    		return getDefaultDownloadFileName();
        }
    	if(downloadFileName.endsWith(".xls")){
    		return downloadFileName;
    	}else{
    		return downloadFileName + "-" + getDateTimeFmt().format(new Date()) + ".xls";
    	}
    }
}
