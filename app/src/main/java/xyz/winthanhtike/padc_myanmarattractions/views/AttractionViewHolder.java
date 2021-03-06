package xyz.winthanhtike.padc_myanmarattractions.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import xyz.winthanhtike.padc_myanmarattractions.R;
import xyz.winthanhtike.padc_myanmarattractions.activities.PlaceDetailActivity;
import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;
import xyz.winthanhtike.padc_myanmarattractions.fragments.MainActivityFragment;


/**
 * Created by winthanhtike on 7/6/16.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvPlaceTitle;
    private ImageView ivPlaceImage;

    private MainActivityFragment.PlaceItemController placeItemController;

    private MMAttractionVO mmAttractionVO;

    public AttractionViewHolder(View itemView, MainActivityFragment.PlaceItemController mPlaceItemController) {
        super(itemView);

        tvPlaceTitle = (TextView)itemView.findViewById(R.id.tv_place_title);
        ivPlaceImage = (ImageView)itemView.findViewById(R.id.iv_place_photo);
        itemView.setOnClickListener(this);
        placeItemController = mPlaceItemController;

    }

    public void setData(MMAttractionVO mmAttractionVO){
        this.mmAttractionVO = mmAttractionVO;
        tvPlaceTitle.setText(mmAttractionVO.getPlaceTitle());
        Glide.with(ivPlaceImage.getContext())
                .load(PlaceDetailActivity.IMAGE_URL+mmAttractionVO.getPlaceImages()[0])
                .placeholder(R.drawable.wallp)
                .error(R.mipmap.ic_launcher)
                .into(ivPlaceImage);
    }

    @Override
    public void onClick(View v) {
        placeItemController.onTapPlace(mmAttractionVO,ivPlaceImage);
    }
}
