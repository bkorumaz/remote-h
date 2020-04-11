package com.tigers.remote_h;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.PagerAdapter;

public class QuoteAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    Boolean isQuotes;


    public QuoteAdapter(Context context, Boolean isQuotes) {
        this.context = context;
        this.isQuotes = isQuotes;
    }
    public String [] quotes = {
            "“Bilginin efendisi olmak için çalışmanın uşağı olmak şarttır.”\n" +  "-Balzac",
            "Hiçbir şeye ihtiyacımız yok, yalnız bir şeye ihtiyacımız vardır; çalışkan olmak.\n -Mustafa Kemal Atatürk",
            "Zafer, “zafer benimdir” diyebilenindir. Başarı ise “başaracağım” diye başlayarak sonunda “başardım” diyenindir.\n -Mustafa Kemal Atatürk",
            "Bir araya gelmek bir başlangıçtır; bir arada tutmak ilerlemedir; birlikte çalışmak başarıdır.\n" +"-Edward Everett Hale",
   };
    public String [] facts = {
            "Bilgi 1",
            "Uyuyarak kalorilerinizden kurtulun. Yani geç saatlere kadar oturup TV izlemek yerine normal saatlerde uyursanız, diğer seçeneğe göre çok daha fazla kalori harcarsınız",
            "İnsan beyni sabahları bilgi, akşamları ise duygu ve yaratıcılık ağırlıklı çalışır.",
            "Bilgi 4",
    };

    @Override
    public int getCount() {
        return quotes.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.quote_layout, container, false);

        TextView slideHeading = (TextView) view.findViewById(R.id.quote);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.quote_img);



        if(isQuotes) {
            slideHeading.setText(quotes[position]);
        } else {
            slideHeading.setText(facts[position]);
            Typeface typeface = ResourcesCompat.getFont(context, R.font.roboto_regular);
            slideHeading.setTypeface(typeface);
            slideImageView.setImageResource(R.drawable.ic_wb_incandescent_black_24dp);
        }


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
