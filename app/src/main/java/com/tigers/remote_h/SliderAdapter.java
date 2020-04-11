package com.tigers.remote_h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int [] slide_images = {
            R.drawable.factors,
            R.drawable.sitting,
            R.drawable.monitor,
            R.drawable.light
    };

    public String [] slide_headings = {
            "RAHATSIZ EDİCİ FAKTÖRLER",
            "OTURUŞ",
            "MONİTÖR",
            "IŞIK"
    };

    public String [] slide_descs = {
            "Çalıştığınız ortamda telefon, oyun konsolu gibi dikkat dağıtıcı eleman olmamasına dikkat etmelisin. Ayrıca birlikte yaşadığın insanları, çalışırken seni rahatsız etmemeleri konusunda uyarmalısın.",
            "Sandalyene oturduğunda kolların 90 derecelik açı yapmalı ve ayağının yere değdiğine emin olmalısın. Eğer değmiyorsa destek yerleştirmelisin.",
            "Monitörü bir kol mesafesi uzaklığa yerleştirmeli ve ekranın en üst noktası göz hizana gelecek şekilde monitörünü ayarlamalısın.",
            "Çalıştığınız ortamın yeterince aydınlandığından emin olmalı ve eğer bilgisayar ile çalışıyorsan ve ortam karanlıksa monitörününün parlaklığını kısıp gece moduna aldığınızdan emin olmalısın"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.quote_img);
        TextView slideHeading = (TextView) view.findViewById(R.id.quote);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
