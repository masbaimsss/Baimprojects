package com.baim.baimproject.MenuAwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baim.baimproject.MainActivity;
import com.baim.baimproject.lihatdatamakanan.tambahan.ChildAnimationExample;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;
import com.baim.baimproject.R;


public class Menuawalan extends AppCompatActivity implements BaseSliderView.OnSliderClickListener{
    SliderLayout2 mDemoSlider;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuawalan);
        mDemoSlider = (SliderLayout2)findViewById(R.id.slider);

        tv = (TextView) findViewById(R.id.baims);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menuawalan.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.gitar2);
        file_maps.put("2",R.drawable.gitar3);
        file_maps.put("3",R.drawable.gitar8);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout2.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout2.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
