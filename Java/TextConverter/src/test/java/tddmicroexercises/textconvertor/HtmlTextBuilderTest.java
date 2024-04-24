package tddmicroexercises.textconvertor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HtmlTextBuilderTest {

  @Test
  void empty() {
    Assertions.assertEquals("", new HtmlTextBuilder().asString());
  }

  @Test
  void singleLine() {
    HtmlTextBuilder sut = new HtmlTextBuilder().appendLine("line 1");
    Assertions.assertEquals("line 1<br />", sut.asString());
  }

  @Test
  void multipleLines() {
    HtmlTextBuilder sut = new HtmlTextBuilder().appendLine("line 1").appendLine("line 2").appendLine("line 3");
    Assertions.assertEquals("line 1<br />line 2<br />line 3<br />", sut.asString());
  }

  @Test
  void escaping() {
    HtmlTextBuilder sut = new HtmlTextBuilder().appendLine("<\" that\"s a test & a win! \">");
    Assertions.assertEquals("&lt;&quot; that&quot;s a test &amp; a win! &quot;&gt;<br />", sut.asString());
  }

}
