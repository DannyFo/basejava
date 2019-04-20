package com.urise.webapp.model;

import java.util.List;

public  abstract class Section <SK> {

    public abstract List getPosition();

    public abstract void AddPosition(SK searchKey, String sentence);

    public abstract void UpdatePosition(SK searchKey, String sentence);

    public abstract void RemovePosition(SK searchKey);
}
