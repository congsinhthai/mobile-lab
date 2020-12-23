package Task4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab2.R;

import java.util.List;


public class Adapter extends BaseAdapter {
    private List<Employee_Task4> employeeList;
    private Activity activity;

    public Adapter(List<Employee_Task4> employeeList, Activity activity) {
        this.employeeList = employeeList;
        this.activity = activity;
    }

    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(employeeList.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView= LayoutInflater.from(activity).inflate(R.layout.item_employee,null,false);
        }
        //get item
        Employee_Task4 employee=(Employee_Task4) getItem(position);
        //get view
        LinearLayout item_layout=(LinearLayout)convertView.findViewById(R.id.item_layout);
        TextView tv_full_name=(TextView)convertView.findViewById(R.id.item_name);
        TextView tv_position=(TextView)convertView.findViewById(R.id.item_staff);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.im_manager);
        //set full name
        tv_full_name.setText(employee.getName());

        if (employee.getIs_manager())
        {
            imageView.setVisibility(View.VISIBLE);
            tv_position.setVisibility(View.GONE);
        }else
        {
            imageView.setVisibility(View.GONE);
            tv_position.setVisibility(View.VISIBLE);
            tv_position.setText("Staff");
        }

        //show diffrent color
        if (position%2==0)
        {
            item_layout.setBackgroundResource(R.color.color_white);
        }
        else
        {
            item_layout.setBackgroundResource(R.color.light_blue);
        }
        return convertView;
    }
}
