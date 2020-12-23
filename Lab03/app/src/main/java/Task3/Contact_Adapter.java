package Task3;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab03.R;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.*;

import org.w3c.dom.Text;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.itemsHolder>{
    private List <Contact> contactList;
    private Context context;
    private ItemClickListener itemClickListener;


    public Contact_Adapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }


    @NonNull
    @Override
    public itemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.contact_items,parent,false);
        return new itemsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemsHolder holder, int position) {

        Contact contact=contactList.get(position);
        holder.tv_id.setText(String.valueOf(contact.getId()));
        holder.tv_name.setText(contact.getName());
        holder.tv_phone.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }




    class itemsHolder extends  RecyclerView.ViewHolder  implements View.OnClickListener,View.OnLongClickListener{

        TextView tv_id;
        TextView tv_name;
        TextView tv_phone;
        public itemsHolder(View itemView) {
            super(itemView);

            tv_id=itemView.findViewById(R.id.items_id);
            tv_name=itemView.findViewById(R.id.items_name);
            tv_phone=itemView.findViewById(R.id.items_phone);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition(),true);
            return true;
        }


    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

interface  ItemClickListener{
    void onItemClick(View view, int position, boolean isLongClick);
}