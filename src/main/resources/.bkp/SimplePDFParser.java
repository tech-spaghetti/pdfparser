package bkp;

import com.aspose.pdf.*;
import com.aspose.pdf.internal.ms.System.Collections.Generic.IGenericList;
import com.sun.org.apache.xml.internal.serializer.ToXMLSAXHandler;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.apache.tika.sax.ToXMLContentHandler;
import org.xml.sax.SAXException;

import java.io.*;

public class SimplePDFParser {
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        final String PATH="/Users/rishushrivastava/Documents/";

        FileInputStream finp = new FileInputStream(new File(PATH+"/data.pdf"));
        FileOutputStream fout = new FileOutputStream(new File(PATH+"/output.pdf"));


        //BodyContentHandler bodyContentHandler = new BodyContentHandler();
        ToHTMLContentHandler bodyContentHandler = new ToHTMLContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(finp,bodyContentHandler,metadata,context);

        System.out.println(bodyContentHandler.toString());



       /* Document document = new Document(finp);
        PageCollection pageCollection = document.getPages();
        int pageSize = pageCollection.size();

        System.out.println("Page Size: "+pageSize);

        Page page = pageCollection.get_Item(pageSize);

        TableAbsorber tableAbsorber = new TableAbsorber();
        tableAbsorber.visit(page);

        IGenericList<AbsorbedTable> genericList = tableAbsorber.getTableList();

        System.out.println(genericList.get_Item(0));

        for(AbsorbedTable absorbedTable : genericList)
        {
            System.out.println("here");
            IGenericList<AbsorbedRow> listRows = absorbedTable.getRowList();

            for(AbsorbedRow absorbedRow : listRows)
            {
                IGenericList<AbsorbedCell> listCells = absorbedRow.getCellList();

                for(AbsorbedCell absorbedCell : listCells)
                {
                    TextFragmentCollection  collectionTextFrag = absorbedCell.getTextFragments();

                    Rectangle rectangle = absorbedCell.getRectangle();

                    // Add pipes ("|") to indicate table ends
                    TextBuilder  textBuilder  = new TextBuilder(page);
                    TextFragment textFragment = new TextFragment("|");
                    double x = rectangle.getURX();
                    double y = rectangle.getURY();
                    textFragment.setPosition(new Position(x, y));
                    textBuilder.appendText(textFragment);

                }
            }
        } */


    }
}
