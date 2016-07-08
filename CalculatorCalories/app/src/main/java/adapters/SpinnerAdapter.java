package adapters;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.main.R;

/**
 * Created by Alex Iachimov on 5/6/2016.
 */
public class SpinnerAdapter {

    public void createAdapter(Context c,int array, int layoutSpinnerItem, int layoutSpinnerItemDrop,Spinner spinner){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(c,
                array, layoutSpinnerItem);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(layoutSpinnerItemDrop);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);


    }
}
