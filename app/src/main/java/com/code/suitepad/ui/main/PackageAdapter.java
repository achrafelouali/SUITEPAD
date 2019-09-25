package com.code.suitepad.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.code.suitepad.R;
import com.code.suitepad.data.Model.Pkg;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ViewHolder> {


    private List<Pkg> mItems;
    private Context mContext;

    public PackageAdapter(Context context) {
        mContext = context;
    }

    public void setItems(List<Pkg> items) {
        mItems = items;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pkg mPackage = getItem(position);

        holder.setName(mPackage.getName());
        holder.setVersionName(mPackage.getVersionName());
        holder.setVersionCode(mPackage.getVersionCode());
        holder.setIcon(mPackage.getIcon());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private Pkg getItem(int position) {
        return mItems.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        AppCompatImageView image;
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.package_name)
        TextView mPackageName;
        @BindView(R.id.package_version)
        TextView mPackageVersion;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setName(String name) {
            this.mName.setText(name);
        }

        public void setVersionName(String versionName) {
            this.mPackageName.setText(mContext.getResources().getString(R.string.version_name) + versionName);
        }

        private void setVersionCode(int versionCode) {
            this.mPackageVersion.setText(mContext.getResources().getString(R.string.version_code) + versionCode);
        }

        private void setIcon(Drawable icon) {
            if (icon != null) {
                this.image.setBackgroundDrawable(icon);
            } else {
                this.image.setBackgroundResource(R.mipmap.ic_launcher);
            }
        }

    }
}
