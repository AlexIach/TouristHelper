package adapters;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;

import model.Product;

/**
 * Created by Alex Iachimov on 5/5/2016.
 */
public class ProductListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;

    public ProductListAdapter(Context context, ArrayList<Product> products) {
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
            view = lInflater.inflate(R.layout.concrete_product_item_list, parent, false);
        }

        Product p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvConcreteProductName)).setText(p.getName()+"");
        ((TextView) view.findViewById(R.id.tvConcreteProductCalorie)).setText("Calorie :"+p.getCalorie() +"");
        ((TextView) view.findViewById(R.id.tvConcreteProductFats_Hyb_Prot)).setText("Pr.Ft.C-Hyd :"+p.getProteine()+"/"+p.getFats()+"/"+p.getCarbohydrates());

        return view;
    }

    // товар по позиции
    Product getProduct(int position) {
        return ((Product) getItem(position));
    }
}
