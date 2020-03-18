package kr.uk.dh.a20200318_01_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.uk.dh.a20200318_01_test.adapters.RoomAdapter;
import kr.uk.dh.a20200318_01_test.databinding.ActivityMainBinding;
import kr.uk.dh.a20200318_01_test.datas.Room;

public class MainActivity extends BaseActivity {
    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, null);
        binding.roomListView.setAdapter(roomAdapter);

        addRooms();
    }

    private void addRooms() {
        roomDatas.add(new Room(18000,"서울시 은",14,"살기"));
        roomDatas.add(new Room(28000,"경기도 구",24,"좋은 방"));
        roomDatas.add(new Room(38000,"인천 은구",34,"은 방"));
        roomDatas.add(new Room(84000,"경상북도 은평",44,"방"));
        roomDatas.add(new Room(58000,"경상남도 평구",54,"살기좋은"));




        roomAdapter.notifyDataSetChanged();
    }


}
