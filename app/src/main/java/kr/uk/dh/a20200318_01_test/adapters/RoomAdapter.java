package kr.uk.dh.a20200318_01_test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.uk.dh.a20200318_01_test.R;
import kr.uk.dh.a20200318_01_test.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
                if (row == null) {
                    row = inf.inflate(R.layout.room_list_item, null);
                }

                Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.roomPriceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.desceTxt);

//        가격 설정 => setText에는 int값 넣지 말자.
//
//        priceTxt.setText(data.getAddress());
        if (data.getPrice() >= 10000) {
            int uk = data.getPrice() / 10000;
            int thousand = data.getPrice() %10000;

            priceTxt.setText(String.format("%d억 %,d" , uk , thousand));
        }
        else {
            priceTxt.setText(String.format("%,d", data.getPrice()));
        }
        String floorStr = "";
        if (data.getFloor() >0 ) {
            floorStr = String.format("%d층",data.getFloor());

        }
        else  if (data.getFloor() == 0) {
//            0 => 반지하로
            floorStr = "반지하";
        }
        else {
            floorStr = String.format("지하 %d층",data.getFloor()*-1);
        }
//        주소 / 층수 결합해서.
        addressAndFloorTxt.setText(String.format("%s,%S",data.getAddress(),floorStr));

        descTxt.setText(data.getDescription());
        return row;
    }

}
