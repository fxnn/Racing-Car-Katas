package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HtmlTextFileConverterTest {

  public static final String TXT_MULTIPLE_LINES = "src/test/resources/multipleLines.txt";
  public static final String TXT_ESCAPING = "src/test/resources/escaping.txt";

  @Test
  public void getFilename() {
    HtmlTextFileConverter converter = new HtmlTextFileConverter(TXT_MULTIPLE_LINES);
    assertEquals(TXT_MULTIPLE_LINES, converter.getFilename());
  }

  @Test
  public void convertToHtml_multipleLines() throws Exception {
    HtmlTextFileConverter converter = new HtmlTextFileConverter(TXT_MULTIPLE_LINES);
    String expected = "line 1<br />line 2<br />line 3<br />";
    assertEquals(expected, converter.convertToHtml());
  }

  @Test
  public void convertToHtml_escaping() throws Exception {
    HtmlTextFileConverter converter = new HtmlTextFileConverter(TXT_ESCAPING);
    String expected = "&lt;&quot; that&quot;s a test &amp; a win! &quot;&gt;<br />";
    assertEquals(expected, converter.convertToHtml());
  }

}
