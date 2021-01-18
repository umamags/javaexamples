package com.joomla;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.simpleflatmapper.csv.CloseableCsvReader;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.csv.CsvReader;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

// uses http://simpleflatmapper.org/0101-getting-started-csv.html for csv parser
// and jackson-core for JsonGenerator
// alternative to https://dzone.com/articles/how-to-convert-csv-to-json-in-java
// stream csv as we read it
// see https://gist.github.com/arnaudroger/cf7806de83766b51dbfe84a1fab559b0 for reduce garbage version
public class CsvToJson {

    public static void main(String[] args) throws IOException {
        //CsvReader reader = CsvParser.reader("col1,col2\nval1,val2");
        File file = new File("C:/temp/books.csv");
        CloseableCsvReader reader = CsvParser.reader(file);

        JsonFactory jsonFactory = new JsonFactory();

        Iterator<String[]> iterator = reader.iterator();
        String[] headers = iterator.next();

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out)) {
    
            jsonGenerator.writeStartArray();
    
            while (iterator.hasNext()) {
                jsonGenerator.writeStartObject();
                String[] values = iterator.next();
                int nbCells = Math.min(values.length, headers.length);
                for(int i = 0; i < nbCells; i++) {
                    jsonGenerator.writeFieldName(headers[i]);
                    jsonGenerator.writeString(values[i]);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }
}