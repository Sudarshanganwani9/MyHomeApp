package com.example.myhomeapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private final Context context;
    private final List<ResolveInfo> apps;

    public AppAdapter(Context context, List<ResolveInfo> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResolveInfo info = apps.get(position);
        holder.appName.setText(info.loadLabel(context.getPackageManager()));
        holder.appIcon.setImageDrawable(info.loadIcon(context.getPackageManager()));

        holder.itemView.setOnClickListener(v -> {
            Intent launchIntent = context.getPackageManager()
                    .getLaunchIntentForPackage(info.activityInfo.packageName);
            if (launchIntent != null) {
                context.startActivity(launchIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appName;

        public ViewHolder(View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            appName = itemView.findViewById(R.id.appName);
        }
    }
}
