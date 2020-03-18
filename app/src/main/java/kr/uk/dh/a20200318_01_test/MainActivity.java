package kr.uk.dh.a20200318_01_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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
        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//               클릭된 방의 주소를 Toast로 출력
                Room clickedRoom = roomDatas.get(position);
//        클릭된 방의 정보를 목록에서 빼옴 . position번째
//                방 상세 화면으로 이동.
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room",clickedRoom);
                startActivity(intent);


            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Room data = roomDatas.get(position);

                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item,roomDatas);
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
