package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionMap extends Section{

    public SectionMap() {
        super();
    }

    protected Map<String,String> mapContent = new HashMap<>();

    public List getPosition() {//возвращает сразу все позиции
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> entry: mapContent.entrySet()) {
            list.add(entry.getKey());
            list.add(entry.getValue());
        }
        return list;
    }

    public void addPosition(String title, String sentence) {
        mapContent.put(title, sentence);
    }

    public void updatePosition(String title, String sentence) {
        mapContent.replace(title, sentence);
    }

    public void removePosition(String title) {
        mapContent.remove(title);
    }
}
