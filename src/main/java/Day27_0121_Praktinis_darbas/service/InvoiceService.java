package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Project;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceService {

    public void createInvoiceForCustomer(Customer customer) throws FileNotFoundException {
        HashMap<String, Double> projectInfoForInvoicing = new HashMap<>();
        double projectCostSum = 0;
        for (Project project : customer.getProjects()) {
            projectInfoForInvoicing.put(project.getName(), (double) (project.getProjectIncome()/project.getDurationInWeeks()*4));
        }
        for (Map.Entry<String, Double> doubleEntry : projectInfoForInvoicing.entrySet()) {
            projectCostSum += doubleEntry.getValue();
        }
        invoiceDesignGenerator(customer, projectInfoForInvoicing, projectCostSum);
    }

    private void invoiceDesignGenerator (Customer customer, HashMap<String, Double> projectInfoForInvoicing, double projectCostSum) throws FileNotFoundException {
        String path = "src/main/resources/Invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        float threeColumns = 190f;
        float twoColumn = 285f;
        float twoColumn150 = twoColumn + 150f;
        float[] twoColumnWidth = {twoColumn150, twoColumn};
        float[] fullWidth = {threeColumns*3};
        float[] oneColumnWidth = {twoColumn150};

        Paragraph spaceParagraph = new Paragraph("\n");

        Table table = new Table(twoColumnWidth);
        Cell invoiceCell = new Cell();
        table.addCell(invoiceCell.add(new Paragraph("INVOICE").setFontSize(20f))
                .setBorder(Border.NO_BORDER)
                .setBold());

        Table invData = new Table(new float[] {twoColumn/2, twoColumn/2});
        invData.addCell(getAligmentLeft("Invoice No.:"));
        invData.addCell(getAligmentRight("202302069852"));
        invData.addCell(getAligmentLeft("Invoice Date:"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        invData.addCell(getAligmentRight(dtf.format(LocalDateTime.now())));

        Cell nestedCell = new Cell();
        table.addCell(nestedCell.add(invData).setBorder(Border.NO_BORDER));

        Border greyBorder = new SolidBorder(ColorConstants.GRAY, 2f);
        Table divider = new Table(fullWidth);
        divider.setBorder(greyBorder);


        Table twoColumnTable = new Table(twoColumnWidth);
        twoColumnTable.addCell(getShippingAndBillingCell("Billing information"));
        twoColumnTable.addCell(getShippingAndBillingCell("Shipping information"));


        Table twoColumnTable2 = new Table(twoColumnWidth);
        twoColumnTable2.addCell(getCell10Left("Company", true));
        twoColumnTable2.addCell(getCell10Left("Name", true));
        twoColumnTable2.addCell(getCell10Left("Martyno projektai", false));
        twoColumnTable2.addCell(getCell10Left(customer.getName(), false));

        Table twoColumnTable3 = new Table(twoColumnWidth);
        twoColumnTable2.addCell(getCell10Left("Name", true));
        twoColumnTable2.addCell(getCell10Left("Address", true));
        twoColumnTable2.addCell(getCell10Left("Martynas Jokubauskis", false));
        twoColumnTable2.addCell(getCell10Left(customer.getProjects().get(0).getAddresses().get(0).getCity()
                + ", " + customer.getProjects().get(0).getAddresses().get(0).getCountry() , false));

        Table oneColumnTable = new Table(oneColumnWidth);
        oneColumnTable.addCell(getCell10Left("Address", true));
        oneColumnTable.addCell(getCell10Left("Kretinga, Kosmonautų g. 9", false));
        oneColumnTable.addCell(getCell10Left("Email", true));
        oneColumnTable.addCell(getCell10Left("martynas@martynoprojektai.com", false));

        Table divider2 = new Table(fullWidth);
        Border dottedBorder = new DashedBorder(ColorConstants.GRAY, 0.5f);

        Paragraph projectsPar = new Paragraph("Projects list");

        Table twoColumnProjects = new Table(twoColumnWidth);
        twoColumnProjects.setBackgroundColor(ColorConstants.BLACK);
        twoColumnProjects.addCell(new Cell().add(new Paragraph("Project")).setBold()
                .setFontColor(ColorConstants.WHITE)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorder(Border.NO_BORDER));
        twoColumnProjects.addCell(new Cell().add(new Paragraph("Cost")).setBold()
                .setFontColor(ColorConstants.WHITE)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER));

        Table twoColumnProjects2 = new Table(twoColumnWidth);
        for (Map.Entry<String, Double> doubleEntry : projectInfoForInvoicing.entrySet()) {
            twoColumnProjects2.addCell(new Cell().add(new Paragraph(doubleEntry.getKey()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));
            twoColumnProjects2.addCell(new Cell().add(new Paragraph(doubleEntry.getValue().toString()))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setBorder(Border.NO_BORDER));
        }
        Paragraph sum = new Paragraph("Total sum: " + projectCostSum);

        Table termsAndCons = new Table(fullWidth);
        termsAndCons.addCell(new Cell().add(new Paragraph("TERMS AND CONDITIONS\n")).setBold().setBorder(Border.NO_BORDER).setFontSize(10f));
        List<String> termsCons = new ArrayList<>();
        termsCons.add("1. You must pay for Martynas");
        termsCons.add("2. You have to pay in one transaction");
        termsCons.add("3. Don't dare to ask about these nonsense terms and conditions");
        termsCons.add("4. Play with code, have fun!");

        for (String termsCon : termsCons) {
            termsAndCons.addCell(new Cell().add(new Paragraph(termsCon)).setBorder(Border.NO_BORDER).setFontSize(10f));
        }

        document.add(table);
        document.add(spaceParagraph);
        document.add(divider);
        document.add(spaceParagraph);
        document.add(twoColumnTable.setMarginBottom(12f));
        document.add(twoColumnTable2);
        document.add(twoColumnTable3);
        document.add(oneColumnTable.setMarginBottom(10f));
        document.add(divider2.setBorder(dottedBorder));
        document.add(projectsPar);
        document.add(twoColumnProjects);
        document.add(twoColumnProjects2.setMarginBottom(20f));
        document.add(divider2.setBorder(dottedBorder));
        document.add(sum.setTextAlignment(TextAlignment.RIGHT));
        document.add(spaceParagraph);
        document.add(divider);
        document.add(termsAndCons.setFixedPosition(document.getLeftMargin(), document.getBottomMargin(), PageSize.A4.getWidth() - document.getLeftMargin() - document.getRightMargin()));



        document.close();
    }

    static Cell getAligmentRight (String textValue) {
        return new Cell().add(new Paragraph (textValue)).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }
    static Cell getAligmentLeft (String textValue) {
        return new Cell().add(new Paragraph (textValue)).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }
    static Cell getShippingAndBillingCell (String textValue) {
        return new Cell().add(new Paragraph (textValue)).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }
    static Cell getCell10Left(String textValue, boolean isBold){
        Cell myCell = new Cell().add(new Paragraph (textValue)).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ?myCell.setBold():myCell;
    }
}
