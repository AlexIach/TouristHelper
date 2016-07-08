package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;

import java.util.ArrayList;

import model.EatenProduct;

/**
 * Created by Alex Iachimov on 5/13/2016.
 */
public class CalendarDayAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<EatenProduct> objects;

    public CalendarDayAdapter(Context context, ArrayList<EatenProduct> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.program_item_list_eaten_food, parent, false);
        }

        EatenProduct p = getProduct(position);
        String prot = p.getProduct().getProteine();
        double protD = Double.parseDouble(prot);
        protD = protD*p.getCoefficient();

        String fats = p.getProduct().getFats();
        double fatsD = Double.parseDouble(fats);
        fatsD = fatsD*p.getCoefficient();

        String chyd = p.getProduct().getCarbohydrates();
        double chydD = Double.parseDouble(chyd);
        chydD = chydD*p.getCoefficient();


        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvConcreteProductName)).setText(p.getName() + "");
        ((TextView) view.findViewById(R.id.tvConcreteProductCalorie)).setText("Calorie:"+p.getProduct().getCalorie()*p.getCoefficient()+"");
        ((TextView) view.findViewById(R.id.tvConcreteProductFats_Hyb_Prot)).setText("Pr.Ft.C-Hyb:"
                +protD+"/"
                +fatsD+"/"
                +chydD);
        ((TextView) view.findViewById(R.id.tvEatenProduct_Time)).setText(""+p.getHourTime()+":"+p.getMinTime());
        return view;
    }

    public void updateAdapter(ArrayList<EatenProduct> arrylst) {
        this.objects= arrylst;

        //and call notifyDataSetChangednotifyDataSetChanged();

    }

    // товар по позиции
    EatenProduct getProduct(int position) {
        return ((EatenProduct) getItem(position));
    }
}

