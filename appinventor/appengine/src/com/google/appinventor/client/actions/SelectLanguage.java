package com.google.appinventor.client.actions;

import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;

public class SelectLanguage implements Command {

  private String localeName;

  public SelectLanguage(String localeName) {
    this.localeName = localeName;
  }

  @Override
  public void execute() {
    final String queryParam = LocaleInfo.getLocaleQueryParam();
    Command savecmd = new SaveAction();
    savecmd.execute();
    if (queryParam != null) {
      UrlBuilder builder = Window.Location.createUrlBuilder().setParameter(
          queryParam, localeName);
      Window.Location.replace(builder.buildString());
    } else {
      // If we are using only cookies, just reload
      Window.Location.reload();
    }
  }

  public void setLocale(String nativeName) {
    localeName = nativeName;
  }
}
