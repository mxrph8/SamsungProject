package dik.mysamsungproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UniversityAdapter extends ArrayAdapter<University> {

    private Context context;
    private List<University> universities;

    public UniversityAdapter(Context context, List<University> universities) {
        super(context, R.layout.vuzitem, universities);
        this.context = context;
        this.universities = universities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vuzitem, parent, false);

        TextView vuzTextView = rowView.findViewById(R.id.vuz);


        University university = universities.get(position);

        vuzTextView.setText(university.toString());

        return rowView;
    }
}
