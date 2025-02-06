package com.mono.infosender.objects.ext;

import com.mono.infosender.objects.AbsHtmlSendObjject;

import java.lang.reflect.Field;
import java.util.List;

public class HtmlSendObject<T> extends AbsHtmlSendObjject<T> {

    @Override
    public String toHtml() {
        Class<?> clazz = getObject().getClass();
        List<Field> fields = List.of(clazz.getDeclaredFields());
        StringBuilder html = new StringBuilder("<div>");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                html.append("<p>").append(field.getName()).append(": ").append(field.get(getObject())).append("</p>");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        html.append("</div>");
        return html.toString();
    }
}
