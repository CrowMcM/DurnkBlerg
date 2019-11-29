package com.example.durnkblerg;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.*;

        import static com.example.durnkblerg.R.id.lock_icon;


public class AppAdapter extends BaseAdapter {

    private LayoutInflater LayoutInflater;
    private List<AppList> ListStorage;

    public AppAdapter(Context context,List<AppList> customisedListView){
        LayoutInflater=(LayoutInflater)context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        ListStorage=customisedListView;
    }

    public AppAdapter(List<AppList> installedApps) {
    }

    @Override
    public int getCount() {
        return ListStorage.size ();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder ListViewHolder;
        if (convertView == null) {

            ListViewHolder = new ViewHolder ();
            convertView = LayoutInflater.inflate ( R.layout.activity_app_list, parent, false );

            ListViewHolder.textInListView = (TextView) convertView.findViewById ( R.id.list_app_name );
            ListViewHolder.imageInListView = (ImageView) convertView.findViewById ( R.id.app_icon );
            ListViewHolder.lockInListView = (ImageView) convertView.findViewById ( R.id.lock_icon );

            convertView.setTag ( ListViewHolder );
        } else {
            ListViewHolder = (ViewHolder) convertView.getTag ();
        }
        ListViewHolder.textInListView.setText ( ListStorage.get ( position ).getName () );
        ListViewHolder.imageInListView.setImageDrawable ( ListStorage.get ( position ).getIcon () );
        ListViewHolder.lockInListView.setImageResource ( ListStorage.get ( position ).getLocked () );

        return convertView;
    }
        static class ViewHolder{

            TextView textInListView;
            ImageView imageInListView;
            ImageView lockInListView;
        }
    }

