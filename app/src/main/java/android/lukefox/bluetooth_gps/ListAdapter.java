package android.lukefox.bluetooth_gps;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter {


    //to reference the Activity
    private final Activity context;

    //to store the list of unique device names
    private final String[] uniqueNameArray;

    public ListAdapter(Activity context, String[] nameArrayParam){

        super(context,R.layout.listview_row , nameArrayParam);

        this.context=context;
        this.uniqueNameArray = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.uniqueDevice);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(uniqueNameArray[position]);

        return rowView;

    };

}
