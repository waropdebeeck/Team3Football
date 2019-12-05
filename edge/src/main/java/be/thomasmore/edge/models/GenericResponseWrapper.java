package be.thomasmore.edge.models;

import java.util.LinkedHashMap;

public class GenericResponseWrapper {
    private LinkedHashMap _embedded;

    public void set_embedded(LinkedHashMap _embedded) {
        this._embedded = _embedded;
    }

    public LinkedHashMap get_embedded(){
        return _embedded;


    }
}
