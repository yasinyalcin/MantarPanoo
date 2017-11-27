package mobil.org.mantarpano;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    Button yeniNotButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host=this.getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("1");
        TabHost.TabSpec tab2 = host.newTabSpec("2");
        TabHost.TabSpec tab3 = host.newTabSpec("3");

        tab1.setIndicator("1. sekme");
        tab2.setIndicator("2. sekme");
        tab3.setIndicator("3. sekme");




        tab1.setContent(new Intent(this,Tab1.class));
        tab2.setContent(new Intent(this,Tab2.class));
        tab3.setContent(new Intent(this,Tab3.class));



        host.addTab(tab1);
        host.addTab(tab2);
        host.addTab(tab3);



   }


}
