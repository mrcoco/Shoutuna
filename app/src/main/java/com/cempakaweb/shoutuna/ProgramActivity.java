package com.cempakaweb.shoutuna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;

public class ProgramActivity extends AppCompatActivity {
    private ExpandingList mExpandingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        mExpandingList = findViewById(R.id.list_program);
        createItems();
    }

    private void createItems() {
        addItem("Senin", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tLesehan Siang",
                "13.00\tShoutuna Bergoyang",
                "15.00\tShoutuna Request Sastion",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tNgaji Shoutuna",
                "20.00\tIndohitz",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"}, R.color.blue, R.drawable.video_play_48);
        addItem("Selasa", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tLesehan Siang",
                "13.00\tTanya Kepada Polisi",
                "15.00\tShoutuna Request Sastion",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tNgaji Shoutuna",
                "20.00\tIndohitz",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
        addItem("Rabu", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tLesehan Siang",
                "13.00\tShoutuna Bergoyang",
                "15.00\tShoutuna Request Sastion",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tNgaji Shoutuna",
                "20.00\tIndohitz",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
        addItem("Kamis", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tLesehan Siang",
                "13.00\tShoutuna Bergoyang",
                "15.00\tShoutuna Request Sastion",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tLive Hadroh",
                "20.00\tIndohitz",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
        addItem("Jumat", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tLesehan Siang",
                "13.00\tShoutuna Bergoyang",
                "15.00\tShoutuna Mirror",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tIndohitz",
                "20.00\tParade Rock Jumat",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
        addItem("Sabtu", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "11.00\tAsian Delight",
                "13.00\tDasa Dangdut Shoutuna",
                "15.00\tWeekend Memories",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tPorjonan (Komunitas Purworejo)",
                "20.00\tIndohitz",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
        addItem("Ahad", new String[]{
                "05.00\tPengajian Shoutuna FM",
                "06.00\tSelamat Pagi Purworejo",
                "09.00\tHarmoni Keluarga",
                "10.00\tTop 30 This Weeks",
                "13.00\tShomalia (Shoutuna Lagu Malaysia)",
                "14.00\tKumpul Bocah",
                "15.00\tSalam Edos (Bollywood)",
                "17.00\tPengajian Shoutuna FM",
                "18.00\tPesona Religi",
                "19.00\tIndizone",
                "21.00\tShoutuna Dangdut Memory",
                "23.00\tPlaylist Shoutuna"
        }, R.color.blue, R.drawable.video_play_48);
    }

    private void addItem(String title, String[] subItems, int colorRes, int iconRes) {
        //Let's create an item with R.layout.expanding_layout
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.program_layout);

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            ((TextView) item.findViewById(R.id.title)).setText(title);

            //We can create items in batch.
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //Let's get the created sub item by its index
                final View view = item.getSubItemView(i);

                //Let's set some values in
                configureSubItem(item, view, subItems[i]);
            }
            /*item.findViewById(R.id.add_more_sub_items).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInsertDialog(new OnItemCreated() {
                        @Override
                        public void itemCreated(String title) {
                            View newSubItem = item.createSubItem();
                            configureSubItem(item, newSubItem, title);
                        }
                    });
                }
            });*/

        }
    }

    private void configureSubItem(final ExpandingItem item, final View view, String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
        /*view.findViewById(R.id.remove_sub_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.removeSubItem(view);
            }
        });*/
    }

    private void showInsertDialog(final OnItemCreated positive) {
        final EditText text = new EditText(this);
       /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(text);
        builder.setTitle(R.string.enter_title);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                positive.itemCreated(text.getText().toString());
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();*/
    }

    interface OnItemCreated {
        void itemCreated(String title);
    }
}
