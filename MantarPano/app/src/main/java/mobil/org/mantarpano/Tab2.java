package mobil.org.mantarpano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by yasü on 27.10.2017.
 */
public class Tab2 extends Activity
{
     ImageButton ilkButton;
    Point point;
	int butonSayisi=1;
    public LinearLayout linearLayout1, linearLayout2, linearLayout3;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=this.getIntent();
        setContentView(R.layout.tab1);
        ilkButtonUret();
        ilkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yeniNotUret();

            }
        });

    }

    public void ilkButtonUret()
    {
        final LinearLayout lnButton=findViewById(R.id.linearLayoutButton);
        ilkButton=new ImageButton(this);
        ilkButton.setImageResource(R.mipmap.ic_launcher);
        ilkButton.setLayoutParams(new LinearLayout.LayoutParams(900,200));
        lnButton.addView(ilkButton);

    }
    public void yeniNotUret()
    {
        point = new Point(492,900);
        final Button yeniButton =new Button(this);
        yeniButton.setText("Button1");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450,450); //Buton boyutları
        if (butonSayisi>=1 && butonSayisi<=2)
        {
            linearLayout1= findViewById(R.id.linearLayout1);
            yeniButton.setLayoutParams(params);
            linearLayout1.addView(yeniButton);
            butonSayisi++;
        }
        else if(butonSayisi>2 && butonSayisi<=4)
        {
            linearLayout2=findViewById(R.id.linearLayout2);
            params.setMargins(0,150,0,0);
            yeniButton.setLayoutParams(params);
            linearLayout2.addView(yeniButton);
            butonSayisi++;
        }
        else if(butonSayisi>4 && butonSayisi<=6)
        {
            linearLayout3= findViewById(R.id.linearLayout3);
            params.setMargins(0,870,0,0);
            yeniButton.setLayoutParams(params);
            linearLayout3.addView(yeniButton);
            butonSayisi++;
        }
        else if(butonSayisi>6)
            Toast.makeText(getApplicationContext(),"Yeni Sekmeye Geçiniz",Toast.LENGTH_SHORT).show();

        yeniButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {

                    case MotionEvent.ACTION_MOVE: { // Parmağımız ekran üzerinde hareket ederken
                        float x,y;
                        x=event.getX()/1.1f;
                        y=event.getY()/1.1f;

                        point.set((int)x,(int)y);
                        yeniButton.setX(point.x-yeniButton.getWidth()/1.7f);
                        yeniButton.setY(point.y-yeniButton.getHeight()/1.7f);
                        break;
                    }

                }
                return true;
            }
        });
    }

}
