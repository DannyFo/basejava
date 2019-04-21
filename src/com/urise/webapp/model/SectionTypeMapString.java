package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionTypeMapString extends Section{

    public SectionTypeMapString() {
        super();
    }

    protected Map<String,String> mapContent = new HashMap<>();

    public List getPosition() {//возвращает сразу все позиции
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> entry: mapContent.entrySet()) {
            list.add(entry.getKey() +"  "+ entry.getValue());
        }
        return list;
    }

    public void AddPosition(String title, String sentence) {
        mapContent.put(title, sentence);
    }

    public void UpdatePosition(String title, String sentence) {
        mapContent.replace(title, sentence);
    }

    public void RemovePosition(String title) {
        mapContent.remove(title);
    }
}
