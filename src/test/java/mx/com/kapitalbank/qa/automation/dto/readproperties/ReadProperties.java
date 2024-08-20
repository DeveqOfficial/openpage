package mx.com.kapitalbank.qa.automation.dto.readproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class ReadProperties {
    @Autowired
    @Qualifier("url")
    private ResourceBundleMessageSource urls;
    @Autowired
    @Qualifier("xpaths")
    private ResourceBundleMessageSource xpaths;
    @Autowired
    @Qualifier("text")
    private ResourceBundleMessageSource texts;


    public String url(String url){
        return urls.getMessage(url, null, LocaleContextHolder.getLocale());
    }
    public String xpath(String xpath){
        return xpaths.getMessage(xpath, null, LocaleContextHolder.getLocale());
    }
    public String text(String text){
        return texts.getMessage(text, null, LocaleContextHolder.getLocale());
    }
}
