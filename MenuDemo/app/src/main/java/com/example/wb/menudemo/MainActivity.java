package com.example.wb.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1, button2, button3;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        listView = (ListView)findViewById(R.id.listview);
        //将button1与上下文菜单绑定
        registerForContextMenu(button1);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        //为listView添加上下文菜单
        menuForListView(listView);
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.newfile:
                    //自定义事件处理
                    mode.finish(); // 关闭菜单
                    return true;
                case R.id.help:
                    //自定义事件处理
                    mode.finish(); // 关闭菜单
                    return true;
                case R.id.search:
                    //自定义事件处理
                    mode.finish(); // 关闭菜单
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mode = null;//销毁资源
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newfile:
                //自定义事件处理
                return true;
            case R.id.help:
                //自定义事件处理
                return true;
            case R.id.search:
                //自定义事件处理
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.newfile:
                //自定义事件处理
                return true;
            case R.id.help:
                //自定义事件处理
                return true;
            case R.id.search:
                //自定义事件处理
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    private void showPopupMenu(View v){
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }

    private void menuForListView(ListView listView){
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.newfile:
                        //自定义事件处理
                        mode.finish(); // 关闭菜单
                        return true;
                    case R.id.help:
                        //自定义事件处理
                        mode.finish(); // 关闭菜单
                        return true;
                    case R.id.search:
                        //自定义事件处理
                        mode.finish(); // 关闭菜单
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });
    }
    @Override
    public void onClick(View v) {
        if(v == button2)
            startActionMode(mActionModeCallback);
        else if(v==button3)
            showPopupMenu(v);
    }

}
