package com.tech.spaghetti.pdf.parser;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.detectors.NurminenDetectionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 1. Build a rest api
 * 2. Put it in a docker
 * 3. Test complex PDF
 */

public class SimplePDF {
    public static void main(String[] args){
        String FILENAME = "/Users/rishushrivastava/Document/GitHub/pdfparser/src/main/resources/data/20.pdf";

        try {
            PDDocument pd = PDDocument.load(new File(FILENAME));

            int totalpages = pd.getNumberOfPages();
            System.out.println("Total number of pages in a document: "+totalpages);

            ObjectExtractor objectExtractor = new ObjectExtractor(pd);
            SpreadsheetExtractionAlgorithm spreadsheetExtractionAlgorithm = new SpreadsheetExtractionAlgorithm();

            NurminenDetectionAlgorithm nurminenDetectionAlgorithm = new NurminenDetectionAlgorithm();
            nurminenDetectionAlgorithm.detect(objectExtractor.extract(totalpages));

            Page page = objectExtractor.extract(1);

            List<Table> tables = spreadsheetExtractionAlgorithm.extract(page);

            for(Table table: tables){
                List<List<RectangularTextContainer>> rows = table.getRows();

                for(int i=0; i<rows.size(); i++){

                    List<RectangularTextContainer> cells = rows.get(i);

                    for(int j=0; j<cells.size(); j++){
                        RectangularTextContainer text = cells.get(j);
                        System.out.println(text.getText()+"|");
                    }
                    System.out.println();
                }
            }

        } catch (IOException e){
            System.out.println("Exception logged "+e);
        }


    }
}
