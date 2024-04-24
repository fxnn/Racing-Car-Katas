package tddmicroexercises.textconvertor;

public class HtmlTextBuilder {

  private static final String LINE_BREAK = "<br />";

  private StringBuilder result = new StringBuilder();

  public String asString() {
    return result.toString();
  }

  public HtmlTextBuilder appendLine(String line) {
    result.append(StringEscapeUtils.escapeHtml(line)).append(LINE_BREAK);
    return this;
  }
}
