package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.team20.databinding.ActivityRentPageBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RentPageActivity extends AppCompatActivity {
    private ActivityRentPageBinding binding;
    private RentAdapter rentAdapter;
    private CategoryAdapter categoryAdapter;
    private ArrayList<ReturnData> rent_arrayList;
    private ArrayList<CategoryData> category_arrayList;
    private ArrayList<ReturnData> test_arrayList;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_my_page:
                        Intent intent_my_page = new Intent(RentPageActivity.this,MainActivity.class);
                        startActivity(intent_my_page);
                        break;
                    case R.id.item_borrow:
                        Intent intent_borrow = new Intent(RentPageActivity.this, RentPageActivity.class);
                        startActivity(intent_borrow);
                        break;
                    case R.id.item_registration:
                        Intent intent_registration = new Intent(RentPageActivity.this,RegisterActivity.class);
                        startActivity(intent_registration);
                        break;
                    case R.id.item_return:
                        Intent intent_return = new Intent(RentPageActivity.this,ReturnActivity.class);
                        startActivity(intent_return);
                        break;
                }
                return false;
            }
        });
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
        byte[] byteArray = bitmapToByteArray(bitmap);

        rent_arrayList = new ArrayList<>();
        rent_arrayList.add(new ReturnData("??????","10000",byteArray));
        rent_arrayList.add(new ReturnData("??????2","20000",byteArray));
        rent_arrayList.add(new ReturnData("??????3","30000",byteArray));
        rent_arrayList.add(new ReturnData("??????4","40000",byteArray));
        rent_arrayList.add(new ReturnData("??????5","10000",byteArray));
        rent_arrayList.add(new ReturnData("??????6","20000",byteArray));
        rent_arrayList.add(new ReturnData("??????7","30000",byteArray));
        rent_arrayList.add(new ReturnData("??????8","40000",byteArray));


        Bitmap bitmap_book = BitmapFactory.decodeResource(getResources(), R.drawable.book);
        byte[] byteArray_book = bitmapToByteArray(bitmap_book);
        Bitmap bitmap_elec = BitmapFactory.decodeResource(getResources(), R.drawable.elec);
        byte[] byteArray_elec = bitmapToByteArray(bitmap_elec);
        Bitmap bitmap_clothes = BitmapFactory.decodeResource(getResources(), R.drawable.clothes);
        byte[] byteArray_clothes = bitmapToByteArray(bitmap_clothes);
        Bitmap bitmap_stuff = BitmapFactory.decodeResource(getResources(), R.drawable.stuff);
        byte[] byteArray_stuff = bitmapToByteArray(bitmap_stuff);
        Bitmap bitmap_houseHold = BitmapFactory.decodeResource(getResources(), R.drawable.household);
        byte[] byteArray_houseHold = bitmapToByteArray(bitmap_houseHold);
        Bitmap bitmap_furniture = BitmapFactory.decodeResource(getResources(), R.drawable.furniture);
        byte[] byteArray_furniture = bitmapToByteArray(bitmap_furniture);
        Bitmap bitmap_child = BitmapFactory.decodeResource(getResources(), R.drawable.child);
        byte[] byteArray_child = bitmapToByteArray(bitmap_child);

        category_arrayList = new ArrayList<>();

        category_arrayList.add(new CategoryData("??????",byteArray_book));
        category_arrayList.add(new CategoryData("????????????",byteArray_elec));
        category_arrayList.add(new CategoryData("??????",byteArray_clothes));
        category_arrayList.add(new CategoryData("??????",byteArray_stuff));
        category_arrayList.add(new CategoryData("????????????",byteArray_houseHold));
        category_arrayList.add(new CategoryData("??????",byteArray_furniture));
        category_arrayList.add(new CategoryData("?????????",byteArray_child));

        categoryAdapter = new CategoryAdapter(category_arrayList);
        binding.rcCategory.setAdapter(categoryAdapter);

        Intent intent_category = getIntent();
        String category = intent_category.getStringExtra("????????????");
        if(category == null){category = "NULL";}
        switch (category){
            case "NULL":
                test_arrayList = new ArrayList<>();
                test_arrayList = rent_arrayList;
                break;
            case "??????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("??????","10000",byteArray_book));
                break;
            case "????????????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("????????????","10000",byteArray_elec));
                break;
            case "??????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("??????","10000",byteArray_clothes));
                break;
            case "??????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("??????","10000",byteArray_stuff));
                break;
            case "????????????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("????????????","10000",byteArray_houseHold));
                break;
            case "??????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("??????","10000",byteArray_furniture));
                break;
            case "?????????":
                test_arrayList = new ArrayList<>();
                test_arrayList.add(new ReturnData("?????????","10000",byteArray_child));
                break;

        }
        rentAdapter = new RentAdapter(test_arrayList);
        binding.rcItemsList.setAdapter(rentAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        binding.rcItemsList.setLayoutManager(linearLayoutManager);
    }
    public byte[] bitmapToByteArray(Bitmap bitmap) { //img>bitmap>byte[] ?????? ??????
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }

}
