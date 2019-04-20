package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionTypeMapString extends Section<String>{

    public SectionTypeMapString() {
        super();
    }

    protected Map<String,String> mapContent = new HashMap<>();

    @Override
    public List getPosition() {//возвращает сразу все позиции
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> entry: mapContent.entrySet()) {
            list.add(entry.getKey() + entry.getValue());
        }
        return list;
    }


    @Override
    public void AddPosition(String searchKey, String sentence) {
        mapContent.put(searchKey, sentence);
    }

    @Override
    public void UpdatePosition(String searchKey, String sentence) {
        mapContent.replace(searchKey, sentence);
    }

    @Override
    public void RemovePosition(String title) {
        mapContent.remove(title);
    }
}
