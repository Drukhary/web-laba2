package drukhary.laba_2.AreaChecking;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {
    private static final long serialVersionUID = 2041275512219239991L;
    private ArrayList<ElementInfo> data;

    public Table() {
        data = new ArrayList<>();
    }

    public ArrayList<ElementInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ElementInfo> table) {
        this.data = table;
    }
}
