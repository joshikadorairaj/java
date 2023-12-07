package com.kgisl.MavenProject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class App{
    public static void main(String[] args)throws IOException {
        String filename="D:\\swathi\\Java\\MavenProject\\file.csv";
        List<EventTable> beans = new CsvToBeanBuilder(new FileReader(filename))
                .withType(EventTable.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
    }
}

// public class App {

//     private static final char DEFAULT_SEPARATOR = ',';
//     private static final char DOUBLE_QUOTES = '"';
//     private static final char DEFAULT_QUOTE_CHAR = DOUBLE_QUOTES;
//     private static final String NEW_LINE = "\n";

//     private boolean isMultiLine = false;
//     private String pendingField = "";
//     private String[] pendingFieldLine = new String[]{};

//     public static void main(String[] args) throws Exception {

//         // loads CSV file from the resource folder.
//         URL resource = App.class.getClassLoader().getResource("D:\\swathi\\Java\\MavenProject\\file.csv");
//         File file = Paths.get(resource.toURI()).toFile();

//         App obj = new App();
//         List<String[]> result = obj.readFile(file, 1);

//         int listIndex = 0;
//         for (String[] arrays : result) {
//             System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

//             int index = 0;
//             for (String array : arrays) {
//                 System.out.println(index++ + " : " + array);
//             }

//         }

//     }

//     public List<String[]> readFile(File csvFile) throws Exception {
//         return readFile(csvFile, 0);
//     }

//     public List<String[]> readFile(File csvFile, int skipLine)
//         throws Exception {

//         List<String[]> result = new ArrayList<>();
//         int indexLine = 1;

//         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

//             String line;
//             while ((line = br.readLine()) != null) {

//                 if (indexLine++ <= skipLine) {
//                     continue;
//                 }

//                 String[] csvLineInArray = parseLine(line);

//                 if (isMultiLine) {
//                     pendingFieldLine = joinArrays(pendingFieldLine, csvLineInArray);
//                 } else {

//                     if (pendingFieldLine != null && pendingFieldLine.length > 0) {
//                         // joins all fields and add to list
//                         result.add(joinArrays(pendingFieldLine, csvLineInArray));
//                         pendingFieldLine = new String[]{};
//                     } else {
//                         // if dun want to support multiline, only this line is required.
//                         result.add(csvLineInArray);
//                     }

//                 }


//             }
//         }

//         return result;
//     }

//     public String[] parseLine(String line) throws Exception {
//         return parseLine(line, DEFAULT_SEPARATOR);
//     }

//     public String[] parseLine(String line, char separator) throws Exception {
//         return parse(line, separator, DEFAULT_QUOTE_CHAR).toArray(String[]::new);
//     }

//     private List<String> parse(String line, char separator, char quoteChar)
//         throws Exception {

//         List<String> result = new ArrayList<>();

//         boolean inQuotes = false;
//         boolean isFieldWithEmbeddedDoubleQuotes = false;

//         StringBuilder field = new StringBuilder();

//         for (char c : line.toCharArray()) {

//             if (c == DOUBLE_QUOTES) {               // handle embedded double quotes ""
//                 if (isFieldWithEmbeddedDoubleQuotes) {

//                     if (field.length() > 0) {       // handle for empty field like "",""
//                         field.append(DOUBLE_QUOTES);
//                         isFieldWithEmbeddedDoubleQuotes = false;
//                     }

//                 } else {
//                     isFieldWithEmbeddedDoubleQuotes = true;
//                 }
//             } else {
//                 isFieldWithEmbeddedDoubleQuotes = false;
//             }

//             if (isMultiLine) {                      // multiline, add pending from the previous field
//                 field.append(pendingField).append(NEW_LINE);
//                 pendingField = "";
//                 inQuotes = true;
//                 isMultiLine = false;
//             }

//             if (c == quoteChar) {
//                 inQuotes = !inQuotes;
//             } else {
//                 if (c == separator && !inQuotes) {  // if find separator and not in quotes, add field to the list
//                     result.add(field.toString());
//                     field.setLength(0);             // empty the field and ready for the next
//                 } else {
//                     field.append(c);                // else append the char into a field
//                 }
//             }

//         }

//         //line done, what to do next?
//         if (inQuotes) {
//             pendingField = field.toString();        // multiline
//             isMultiLine = true;
//         } else {
//             result.add(field.toString());           // this is the last field
//         }

//         return result;

//     }

//     private String[] joinArrays(String[] array1, String[] array2) {
//         return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
//                 .toArray(String[]::new);
//     }

//     public static String sha256hex(String iNPUT) {
//         return null;
//     }
// }


// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Arrays;
// import java.util.List;

// import org.apache.commons.codec.digest.DigestUtils;

// import com.opencsv.CSVParser;
// import com.opencsv.CSVParserBuilder;
// import com.opencsv.CSVReader;
// import com.opencsv.CSVReaderBuilder;
// import com.opencsv.bean.CsvToBeanBuilder;
// import com.opencsv.exceptions.CsvException;

// public class App {

//     public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {

//     //     try (CSVReader reader = new CSVReader(new FileReader("D:\\swathi\\Java\\MavenProject\\file.csv"))) {
//     //   List<String[]> r = reader.readAll();
//     //   r.forEach(x -> System.out.println(Arrays.toString(x)));


//     // try (CSVReader reader = new CSVReader(new FileReader("D:\\swathi\\Java\\MavenProject\\file.csv"))) {
//     //     String[] lineInArray;
//     //     while ((lineInArray = reader.readNext()) != null) {
//     //         System.out.println(lineInArray[0] + lineInArray[1] + "etc...");
//     //     }
//     // }

// //      CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
// //   try(CSVReader reader = new CSVReaderBuilder(
// //           new FileReader("D:\\swathi\\Java\\MavenProject\\file.csv"))
// //           .withCSVParser(csvParser)   // custom CSV parser
// //           .withSkipLines(1)           // skip the first line, header info
// //           .build()){
// //       List<String[]> r = reader.readAll();
// //       r.forEach(x -> System.out.println(Arrays.toString(x)));
// //   }


//      String fileName = "D:\\swathi\\Java\\MavenProject\\file.csv";

//         List<EventTable> beans = new CsvToBeanBuilder(new FileReader(fileName))
//                 .withType(EventTable.class)
//                 .build()
//                 .parse();

//         beans.forEach(System.out::println);

//     // String fileName = "D:\\swathi\\Java\\MavenProject\\file.csv";

//     //     List<String[]> r;
//     //     try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
//     //         r = reader.readAll();
//     //     }

//     //     int listIndex = 0;
//     //     for (String[] arrays : r) {
//     //         System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

//     //         int index = 0;
//     //         for (String array : arrays) {
//     //             System.out.println(index++ + " : " + array);
//     //         }

//     //     }
//   }}

    

// //     public static String sha256hex(String iNPUT) {
// //         return DigestUtils.sha256Hex(iNPUT);
// //     }

// //     // public static String sha256hex(String input) {
// //     //     return DigestUtils.sha256Hex(input);
// //     // }

// // }