package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextFileConverter {
  private String fullFilenameWithPath;

  public HtmlTextFileConverter(String fullFilenameWithPath) {
    this.fullFilenameWithPath = fullFilenameWithPath;
  }

  public String convertToHtml() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
    HtmlTextBuilder result = new HtmlTextBuilder();

    String line = reader.readLine();
    while (line != null) {
      result.appendLine(line);
      line = reader.readLine();
    }
    return result.asString();

  }

  public String getFilename() {
    return this.fullFilenameWithPath;
  }
}
